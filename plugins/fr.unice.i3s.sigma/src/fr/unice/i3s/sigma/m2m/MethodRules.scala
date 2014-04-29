package fr.unice.i3s.sigma.m2m

import java.lang.annotation.Annotation
import java.lang.reflect.Method

import scala.util.Failure
import scala.util.Success
import scala.util.Try

import com.typesafe.scalalogging.log4j.Logging

import fr.unice.i3s.sigma.m2m.annotations.Abstract
import fr.unice.i3s.sigma.m2m.annotations.Greedy
import fr.unice.i3s.sigma.m2m.annotations.Lazy
import fr.unice.i3s.sigma.m2m.annotations.LazyUnique
import fr.unice.i3s.sigma.support.SigmaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport

trait MethodRules extends EcorePackageScalaSupport with SigmaSupport with Logging { this: BaseM2MT ⇒

  class MethodRule(
    val name: String,
    val sourceClass: MetaClass,
    val targetClasses: Seq[MetaClass],
    underlying: Method) extends MatchedRule {

    protected def doTransform(source: AnyRef, targets: Seq[AnyRef]): Try[Boolean] =
      Try(underlying.invoke(target, (source +: targets): _*)) match {
        case Success(None) ⇒ Success(false) // no transformation
        case Success(null) | Success(Some(_)) ⇒ Success(true) // null will be the result of invoking (...)Unit
        case Success(x) ⇒ Failure(new M2MTransformationException(s"Unexpected return value `$x` from rule application: $this ($underlying) when transforming $source"))
        case Failure(e) ⇒ Failure(new M2MTransformationException(s"Invocation of rule $name failed: ${e.getCause.getMessage}", e.getCause))
      }

    override def toString = "Method" + super.toString
  }

  /** The invocation target. Useful to override for mocks */
  protected val target: MethodRules = this

  /** The prefix for the rule methods */
  protected val ruleMethodPrefix = "rule"

  protected override def loadRules: Seq[Rule] =
    this.getClass.getMethods.toSeq collect { case m if isMethodRule(m) ⇒ createRule(m) }

  protected def createRule(method: Method): Rule = {

    def findAnnotation[A <: Annotation](method: Method, annotationClass: Class[A]): Option[A] = {
      Option(method.getAnnotation(annotationClass)) orElse {
        val cl = method.getDeclaringClass.getSuperclass

        if (cl != null && cl != classOf[Object]) {
          Try(cl.getDeclaredMethod(method.getName(), method.getParameterTypes: _*))
            .toOption
            .flatMap(findAnnotation(_, annotationClass))
        } else
          None
      }
    }

    val name = method.getName.drop(ruleMethodPrefix.size)

    // resolve to 

    val sourceClass = method.getParameterTypes()(0)
    val source = findSourceMetaClass(sourceClass)

    val targetClasses = method.getParameterTypes.drop(1)
    val targets = targetClasses map findTargetMetaClass
    
    val isAbstract = findAnnotation(method, classOf[Abstract]).isDefined
    val isGreedy = findAnnotation(method, classOf[Greedy]).isDefined
    val isLazy = findAnnotation(method, classOf[Lazy]).isDefined
    val isLazyUnique = findAnnotation(method, classOf[LazyUnique]).isDefined

    // abstract rules cannot be lazy
    assert(isAbstract implies !isLazy, s"$name: cannot be both abstract and lazy at the same time")
    // abstract rules cannot be greedy
    assert(isAbstract implies !isGreedy, s"$name: cannot be both abstract and greedy at the same time")
    // abstract rules cannot be lazy unique
    assert(isAbstract implies !isLazyUnique, s"$name: cannot be both abstract and lazy unique at the same time")

    // if the rule is not abstract then all target classes must be instantiable 
    assert(!isAbstract implies (targets forall (!_.isAbstract)),
      s"$name: is non-abstract and as such it cannot define a target which is an abstract class")

    val rule = (isAbstract, isGreedy, isLazy, isLazyUnique) match {
      // matched rule
      case (false, false, false, false) ⇒ new MethodRule(name, source, targets, method) with MatchedRule
      // abstract rule
      case (true, false, false, false) ⇒ new MethodRule(name, source, targets, method) with AbstractRule
      // greedy rule
      case (false, true, false, false) ⇒ new MethodRule(name, source, targets, method) with GreedyRule
      // lazy rule
      case (false, false, true, false) ⇒ new MethodRule(name, source, targets, method) with LazyRule
      // lazy unique rule
      case (false, false, false, true) ⇒ new MethodRule(name, source, targets, method) with LazyUniqueRule
      // greedy lazy rule
      case (false, true, true, false) ⇒ new MethodRule(name, source, targets, method) with GreedyRule with LazyRule
      // greedy lazy unique rule
      case (false, true, true, true) ⇒ new MethodRule(name, source, targets, method) with GreedyRule with LazyUniqueRule
      // error
      case _ ⇒ throw new M2MTransformationException(s"Rule: $name has an invalid modification attributes (abstract, lazy, greedy)")
    }

    rule
  }

  // regular rule<Name> (S,T1,...,Tn)Unit or ruke<Name> (S,T1,...,Tn)Option[Unit] ignoring lazy rules
  protected def isMethodRule(method: Method): Boolean = {
    // must start with prefix
    method.getName.startsWith(ruleMethodPrefix) &&
      // longer than prefix
      method.getName.size > ruleMethodPrefix.size &&
      (
        // either (...)Unit
        method.getReturnType.isAssignableFrom(classOf[Unit]) ||
        // or (...)Option[Unit]
        // TODO: better check for Option[Unit]
        method.getReturnType.isAssignableFrom(classOf[Option[Unit]])) &&
        // at least 2 args
        method.getParameterTypes.size >= 2
  }

}

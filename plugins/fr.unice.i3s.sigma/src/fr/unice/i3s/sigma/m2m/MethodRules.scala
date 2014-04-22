package fr.unice.i3s.sigma.m2m

import java.lang.reflect.Method
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EClass
import com.typesafe.scalalogging.log4j.Logging
import scala.util.Try
import scala.util.Success
import scala.util.Failure
import fr.unice.i3s.sigma.m2m.annotations.Abstract
import fr.unice.i3s.sigma.m2m.annotations.Lazy
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.SigmaSupport
import fr.unice.i3s.sigma.m2m.annotations.Greedy
import java.lang.annotation.Annotation

trait MethodRules extends EcorePackageScalaSupport with SigmaSupport with Logging { this: BaseM2MT ⇒

  class MethodRule(
    val name: String,
    val sourceClass: EClass,
    val targetClasses: Seq[EClass],
    underlying: Method) extends MatchedRule {

    protected def doTransform(source: EObject, targets: Seq[EObject]): Try[Boolean] =
      Try(underlying.invoke(target, (source +: targets): _*)) match {
        case Success(None) ⇒ Success(false) // no transformation
        case Success(null) | Success(Some(_: Unit)) ⇒ Success(true) // null will be the result of invoking (...)Unit
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

  protected lazy val sourceEClasses = sourceMetaModels flatMap (_.eClassifiers) collect { case e: EClass ⇒ e }
  protected lazy val targetEClasses = targetMetaModels flatMap (_.eClassifiers) collect { case e: EClass ⇒ e }

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

    val source = method.getParameterTypes()(0)
    val sourceClass = sourceEClasses
      .find(_.instanceClassName == source.getName)
      .orThrow(new M2MTransformationException(s"The rule $name defines a source element ${source.getName} which has not been found in any of the source meta-models: ${sourceMetaModels map (_.name) mkString (", ")}"))

    val targets = method.getParameterTypes drop 1
    val targetClasses = targets.map { c ⇒
      targetEClasses
        .find(_.instanceClassName == c.getName)
        .orThrow(new M2MTransformationException(s"The rule $name defines a target element ${c.getName} which has not been found in any of the target meta-models: ${targetMetaModels map (_.name) mkString (", ")}"))
    }

    val isAbstract = findAnnotation(method, classOf[Abstract]).isDefined
    val isGreedy = findAnnotation(method, classOf[Greedy]).isDefined
    val isLazy = findAnnotation(method, classOf[Lazy]).isDefined

    // abstract rules cannot be lazy
    if (isAbstract && isLazy)
      throw new M2MTransformationException(s"Rule: $name cannot be both abstract and lazy at the same time")
    // abstract rules cannot be greedy
    if (isAbstract && isGreedy)
      throw new M2MTransformationException(s"Rule: $name cannot be both abstract and greedy at the same time")

    // if the rule is not abstract then all target classes must be instantiable 
    if (!isAbstract && (targetClasses exists { c ⇒ c.isAbstract || c.isInterface }))
      throw new M2MTransformationException(s"Rule: $name is non-abstract and as such it cannot define a target which is an abstract class")

    val rule = (isAbstract, isGreedy, isLazy) match {
      // matched rule
      case (false, false, false) ⇒ new MethodRule(name, sourceClass, targetClasses, method) with MatchedRule
      // abstract rule
      case (true, false, false) ⇒ new MethodRule(name, sourceClass, targetClasses, method) with AbstractRule
      // greedy rule
      case (false, true, false) ⇒ new MethodRule(name, sourceClass, targetClasses, method) with GreedyRule
      // lazy rule
      case (false, false, true) ⇒ new MethodRule(name, sourceClass, targetClasses, method) with LazyRule
      // greedy lazy rule
      case (false, true, true) ⇒ new MethodRule(name, sourceClass, targetClasses, method) with GreedyRule with LazyRule
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
        method.getReturnType.isAssignableFrom(classOf[Option[Unit]])
      ) &&
        // at least 2 args
        method.getParameterTypes.size >= 2 &&
        // all of them must be instances of EObject
        method.getParameterTypes.forall(classOf[EObject].isAssignableFrom(_))
  }

}

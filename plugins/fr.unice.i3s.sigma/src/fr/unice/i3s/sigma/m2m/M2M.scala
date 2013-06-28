package fr.unice.i3s.sigma.m2m

import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType

import scala.annotation.implicitNotFound
import scala.reflect.ClassTag
import scala.reflect.classTag
import scala.util.DynamicVariable

import org.apache.commons.lang3.reflect.TypeUtils
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl

import com.typesafe.scalalogging.log4j.Logging

import fr.unice.i3s.sigma.OverloadHack
import fr.unice.i3s.sigma.support.EMFBuilder
import fr.unice.i3s.sigma.support.EMFScalaSupport

trait RuleMethods { this: M2M with Logging ⇒

  abstract class MethodBasedRule(
    name: String,
    isLazy: Boolean,
    isUnique: Boolean,
    underlying: Method,
    sourceClass: Class[_],
    targetClasses: Seq[Class[_]]) extends BasicRule(name, isLazy) {

    override def isApplicable(source: EObject) = sourceClass.isAssignableFrom(source.getClass)

    override def shouldTransfrorm = true

    override def doApply(source: EObject): Option[Seq[EObject]] = {

      traceForSource(source) match {
        case Some(target) if isLazy implies isUnique ⇒
          // regular matched rule && unique lazy rules always return the same
          Some(Seq(target))
        case _ ⇒
          // transform
          doTransform(source)
      }
    }

    protected def doTransform(source: EObject): Option[Seq[EObject]]

    override def toString = {
      var prefix = if (isLazy) "Lazy" else ""
      prefix = if (isUnique) "Unique" else ""

      s"${prefix}MethodRule $name: ${sourceClass.getSimpleName} -> ${targetClasses map (_.getSimpleName) mkString (", ")}"
    }
  }

  class RegularRule(
    name: String,
    isLazy: Boolean,
    isUnique: Boolean,
    underlying: Method,
    sourceClass: Class[_],
    targetClasses: Seq[Class[_]]) extends MethodBasedRule(name, isLazy, isUnique, underlying, sourceClass, targetClasses) {

    protected def doTransform(source: EObject): Option[Seq[EObject]] = {
      // 1. create targets
      val targets = targetClasses map { x ⇒ createEObject(x.getName) }
      val args = source +: targets

      // 2. invoke method
      underlying.invoke(RuleMethods.this, args: _*) match {
        // null will be the result of invoking (...)Unit
        case null | Some(_: Unit) ⇒ Some(targets)
        case None ⇒ None
        case x ⇒ sys.error(s"Unexpected return value `$x` from rule application: $this ($underlying) when transforming $source")
      }
    }

    override def toString = "Regular" + super.toString
  }

  class ExplicitTargetRule(
    name: String,
    isLazy: Boolean,
    isUnique: Boolean,
    underlying: Method,
    sourceClass: Class[_],
    targetClass: Class[_]) extends MethodBasedRule(name, isLazy, isUnique, underlying, sourceClass, Seq(targetClass)) {

    protected def doTransform(source: EObject): Option[Seq[EObject]] = {

      // 1. invoke method
      underlying.invoke(RuleMethods.this, source) match {
        case target: EObject ⇒ Some(Seq(target))
        case Some(target: EObject) ⇒ Some(Seq(target))
        case None ⇒ None
        case x ⇒ sys.error(s"Unexpected return value `$x` from rule application: $this ($underlying) when transforming $source")
      }
    }

    override def toString = "ExplicitTarget" + super.toString
  }

  class PartialRule(
    name: String,
    isLazy: Boolean,
    isUnique: Boolean,
    underlying: Method,
    sourceClass: Class[_],
    targetClass: Class[_]) extends MethodBasedRule(name, isLazy, isUnique, underlying, sourceClass, Seq(targetClass)) {

    protected def doTransform(source: EObject): Option[Seq[EObject]] = {

      // 1. invoke method
      underlying.invoke(RuleMethods.this) match {
        // TODO: make type safe?
        case pfce: PartialFunction[EObject, EObject] ⇒
          if (pfce.isDefinedAt(source)) {
            Some(Seq(pfce(source)))
          } else {
            None
          }
        case x ⇒ sys.error(s"Unexpected return value `$x` from rule application: $this ($underlying) when transforming $source")
      }

    }

    override def toString = "ExplicitTarget" + super.toString
  }

  def loadRules = {
    val ruleMethodPrefix = "rule"

    def isLazyRule(method: Method) = method.isAnnotationPresent(classOf[Lazy])
    def isUniqueRule(method: Method) = method.isAnnotationPresent(classOf[Unique])

    object PartialRuleMethod {
      def unapply(method: Method): Option[(String, Boolean, Boolean, Class[_], Class[_])] = {
        if ( // must start with prefix
        method.getName.startsWith(ruleMethodPrefix) &&
          // longer than prefix
          method.getName.size > ruleMethodPrefix.size &&
          // ()PartialFunction[A,B]
          // TODO: check for A and B are EObject
          method.getReturnType.isAssignableFrom(classOf[PartialFunction[_, _]]) &&
          // zero argument
          method.getParameterTypes.size == 0) {

          val name = method.getName.drop(ruleMethodPrefix.size)

          // TODO: check for EObject
          val typeArgs = TypeUtils.getTypeArguments(method.getGenericReturnType.asInstanceOf[ParameterizedType])
          val source = typeArgs.get(classOf[PartialFunction[_, _]].getTypeParameters()(0)).asInstanceOf[Class[_]]
          val target = typeArgs.get(classOf[PartialFunction[_, _]].getTypeParameters()(1)).asInstanceOf[Class[_]]

          Some((name, isLazyRule(method), isUniqueRule(method), source, target))
        } else None
      }
    }

    object ExplicitTargetRuleMethod {
      def unapply(method: Method): Option[(String, Boolean, Boolean, Class[_], Class[_])] = {
        if ( // must start with prefix
        method.getName.startsWith(ruleMethodPrefix) &&
          // longer than prefix
          method.getName.size > ruleMethodPrefix.size &&
          (
            // either (S)T1
            method.getReturnType.isAssignableFrom(classOf[EObject]) ||
            // or (S)Option[T1]
            // TODO: better check for Option[EObject]
            method.getReturnType.isAssignableFrom(classOf[Option[EObject]])
          ) &&
            // one argument
            method.getParameterTypes.size == 1) {

          val name = method.getName.drop(ruleMethodPrefix.size)

          val source = method.getParameterTypes()(0)

          val typeArgs = TypeUtils.getTypeArguments(method.getGenericReturnType.asInstanceOf[ParameterizedType])
          val target = typeArgs.values.iterator.next.asInstanceOf[Class[_]]

          Some((name, isLazyRule(method), isUniqueRule(method), source, target))
        } else None
      }
    }

    object RegularRuleMethod {

      def unapply(method: Method): Option[(String, Boolean, Boolean, Class[_], Seq[Class[_]])] = {

        if ( // must start with prefix
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
            method.getParameterTypes.size >= 2) {

          val name = method.getName.drop(ruleMethodPrefix.size)

          val source = method.getParameterTypes()(0)
          // TODO: check for EObject
          val targets = method.getParameterTypes drop 1
          // TODO: check for EObjects

          Some((name, isLazyRule(method), isUniqueRule(method), source, targets))
        } else None
      }
    }

    getClass.getMethods.toSeq collect {

      // regular rule (S,T1,...,Tn)Unit or (T1,...,Tn)Option[Unit]
      case method @ RegularRuleMethod(name, isLazy, isUnique, source, targets) ⇒
        val rule = new RegularRule(name, isLazy, isUnique, method, source, targets)
        logger debug s"Registered rule: $rule"
        rule

      // rule (S)T1 or (S)Option[T1]
      case method @ ExplicitTargetRuleMethod(name, isLazy, isUnique, source, target) ⇒
        val rule = new ExplicitTargetRule(name, isLazy, isUnique, method, source, target)
        logger debug s"Registered rule: $rule"
        rule

      // partial rule ()PartialFunction[S,T1]  
      case method @ PartialRuleMethod(name, isLazy, isUnique, source, target) ⇒
        val rule = new PartialRule(name, isLazy, isUnique, method, source, target)
        logger debug s"Registered rule: $rule"
        rule

    }
  }

  // TODO: use partial functions by default
  def partial[F, T](perform: PartialFunction[F, T]) = perform

  implicit class EObjectM2MSupport(that: EObject) {
    def unary_~[B >: Null <: EObject]: B = transformOne(that, true) match {
      case Some(targets) ⇒ targets(0).asInstanceOf[B]
      case None ⇒ null
    }
  }

  implicit class EListM2MSupport(that: EList[_ <: EObject]) {
    def unary_~[B <: EObject] = {
      val result = that map (transformOne(_, true))
      result collect {
        case Some(targets) ⇒ targets(0).asInstanceOf[B]
      }
    }
  }
}

trait M2M extends EMFScalaSupport with OverloadHack with Logging {

  trait TransformationRule {
    def apply(source: EObject): Option[Seq[EObject]]
    def isApplicable(source: EObject): Boolean
    def isLazy: Boolean
    def name: String
  }

  abstract class BasicRule(val name: String, val isLazy: Boolean) extends TransformationRule with Logging {

    protected def shouldTransfrorm = true
    protected def doApply(source: EObject): Option[Seq[EObject]]

    def apply(source: EObject): Option[Seq[EObject]] = {
      assert(isApplicable(source))

      logger debug s"[$name]: Executing on $source"

      // check
      if (shouldTransfrorm) {
        // execute
        doApply(source) match {
          case Some(targets) ⇒
            // add container-less eobjects into resource
            resource.getContents ++= targets filter (_.eContainer == null)

            // add to trace log
            traceLog ++= targets map (source -> (this, _))

            logger debug s"[$name]: Transformed $source -> $targets"

            Some(targets)
          case None ⇒
            logger debug s"[$name]: Did not transform $source"

            None
        }
      } else {
        logger debug s"Rule $name should not execute on $source"
        None
      }
    }

    protected def traceForSource(source: EObject): Option[EObject] = {
      traceLog.get(source) match {
        case Some((rule, target)) if rule == this ⇒ Some(target)
        case None ⇒ None
      }
    }
  }

  type TraceLog = collection.mutable.HashMap[EObject, (TransformationRule, EObject)]

  val targetMetaModels: Seq[EPackage]

  private val session = new DynamicVariable[(Resource, TraceLog)](null)

  protected[m2m] lazy val targetBuilders = targetMetaModels map (new EMFBuilder(_))

  protected[m2m] def traceLog = session.value._2
  protected[m2m] def resource = session.value._1

  protected[m2m] def createEObject(name: String) = {
    val target = targetBuilders collectFirst {
      case builder if builder.canCreate(name) ⇒ builder.create(name)
    }

    require(target.isDefined, s"Unable to create target EClass: $name")

    target.get
  }

  protected[m2m] def loadRules: Seq[TransformationRule]

  private lazy val rules: Seq[TransformationRule] = loadRules

  protected[m2m] def createNewResource =
    new ResourceSetImpl().createResource(URI.createURI("transfromation"))

  def apply(source: EObject): EList[EObject] = {
    val res = createNewResource
    val tl = new TraceLog

    session.withValue((res, tl)) {
      transform(source)
    }

    res.getContents
  }

  protected[m2m] def transformOne(source: EObject, lazyRules: Boolean = true, rule: Option[TransformationRule] = None) = {
    logger debug s"Transforming $source"

    val ruleToUse = rule orElse {
      rules find { x ⇒ (x.isLazy implies lazyRules) && x.isApplicable(source) }
    }

    ruleToUse match {
      case Some(rule) ⇒
        rule(source)
      case None ⇒
        logger debug (s"No rule to convert ${source.getClass.getSimpleName}")
        None
    }
  }

  protected[m2m] def transform(source: EObject) {
    transformOne(source)

    for (elem ← source.eContents) transform(elem)
  }

  def guardedBy[T](g: ⇒ Boolean) = g

  implicit class CheckedBoolean(that: Boolean) {
    def transform[T](g: ⇒ T): Option[T] = {
      if (that) {
        Some(g)
      } else {
        None
      }
    }
  }
}
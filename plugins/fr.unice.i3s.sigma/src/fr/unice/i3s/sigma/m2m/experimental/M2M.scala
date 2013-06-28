package fr.unice.i3s.sigma.m2m.experimental

import scala.annotation.implicitNotFound
import scala.reflect.ClassTag
import scala.reflect.classTag
import scala.util.DynamicVariable

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

  private val registeredRules = collection.mutable.Set[RH]()

  // TODO: unique and lazy rules
  abstract class MethodBasedRule[S <: EObject: ClassTag, T <: EObject: ClassTag](
    name: String,
    isLazy: Boolean,
    isUnique: Boolean) extends BasicRule[S, T](name, isLazy) {

    override def isApplicable(source: EObject) = source match {
      case _: S ⇒ true
      case _ ⇒ false
    }

    override def shouldTransfrorm = true

    override def doApply(source: S): Option[(T, Seq[EObject])] = {

      traceForSource(source) match {
        case Some(target) if isLazy implies isUnique ⇒
          // regular matched rule && unique lazy rules always return the same
          Some(target, Seq())
        case _ ⇒
          // transform
          doTransform(source)
      }
    }

    protected def doTransform(source: S): Option[(T, Seq[EObject])]

    override def toString = {
      var prefix = if (isLazy) "Lazy" else ""
      prefix = if (isUnique) "Unique" else ""

      s"${prefix}MethodRule $name: ${classTag[S]} -> ${classTag[T]}"
    }
  }

  def partial[F, T](perform: PartialFunction[F, T]) = perform

  //  def transform[T: ClassTag](block: T): Option[T] = Some(block)
  def transform[T: ClassTag](block: T): T = block

  // TODO: generate all 22 rules
  def rule[S <: EObject: ClassTag, T <: EObject: ClassTag](delegate: (S, T) ⇒ T): Rule[S, T] = {
    val r = new MethodBasedRule[S, T]("rule1", false, false) {
      def doTransform(source: S): Option[(T, Seq[EObject])] = {
        val target = createEObject[T]
        delegate(source, target)

        Some(target, Seq())
      }
    }
    registeredRules += new RH {
      type RS = S
      type RT = T
      val rule = r
    }

    logger debug s"Registered rule: $r"

    r
  }

  def rule[S <: EObject: ClassTag, T <: EObject: ClassTag, T2 <: EObject: ClassTag](delegate: (S, T, T2) ⇒ Unit): Rule[S, T] = {
    val r = new MethodBasedRule[S, T]("rule1", false, false) {
      def doTransform(source: S): Option[(T, Seq[EObject])] = {
        val target = createEObject[T]
        val target2 = createEObject[T2]

        delegate(source, target, target2)

        Some(target, Seq(target2))
      }
    }
    registeredRules += new RH {
      type RS = S
      type RT = T
      val rule = r
    }

    logger debug s"Registered rule: $r"

    r
  }

  def loadRules = registeredRules.toSeq

  // TODO: multirule

  def rule[S <: EObject: ClassTag, T <: EObject: ClassTag](delegate: PartialFunction[S, T])(implicit o: Overloaded1) = {
    val r = new MethodBasedRule[S, T]("rule1", false, false) {
      def doTransform(source: S): Option[(T, Seq[EObject])] = {
        if (delegate.isDefinedAt(source)) {
          val target = delegate.apply(source)
          Some(target, Seq())
        } else {
          None
        }
      }
    }

    registeredRules += new RH {
      type RS = S
      type RT = T
      val rule = r
    }

    logger debug s"Registered rule: $r"

    r
  }

  implicit class EObjectM2MSupport[A <: EObject: ClassTag](that: A) {
    def unary_~[B >: Null <: EObject](implicit rule: Rule[A, B]): B = transformOne(that, rule) match {
      // TODO: make type-safe
      case Some(targets) ⇒ targets._1
      case None ⇒ null
    }
  }

  implicit class EListM2MSupport[A <: EObject: ClassTag](that: EList[A]) {
    def unary_~[B <: EObject](implicit rule: Rule[A, B]) = {
      // TODO: make type-safe
      val result = that map (transformOne(_, rule))
      result collect {
        case Some(targets) ⇒ targets._1
      }
    }
  }

}

trait M2M extends EMFScalaSupport with OverloadHack with Logging {

  @implicitNotFound(msg = "No conversion rule between ${S} and ${T}.")
  trait Rule[S <: EObject, T <: EObject] {

    def apply(source: S): Option[(T, Seq[EObject])]

    def isApplicable(source: EObject): Boolean

    def isLazy: Boolean

    def name: String

  }

  def transformOne[S <: EObject: ClassTag, T <: EObject](source: EObject, withRule: Rule[S, T]) = {

    source match {
      case x: S ⇒ withRule.apply(x)
      case _ ⇒ sys.error("")
    }

  }

  abstract class BasicRule[S <: EObject: ClassTag, T <: EObject: ClassTag](val name: String, val isLazy: Boolean) extends Rule[S, T] with Logging {

    protected def shouldTransfrorm = true
    protected def doApply(source: S): Option[(T, Seq[EObject])]

    def apply(source: S): Option[(T, Seq[EObject])] = {
      assert(isApplicable(source))

      logger debug s"[$name]: Executing on $source"

      // check
      if (shouldTransfrorm) {
        // execute
        doApply(source) match {
          case Some(result) ⇒
            // add container-less EObjects into resource
            val targets = result._1 +: result._2
            resource.getContents ++= targets filter (_.eContainer == null)

            // add to trace log
            traceLog ++= targets map (source -> (this, _))

            logger debug s"[$name]: Transformed $source -> $targets"

            Some(result)
          case None ⇒
            logger debug s"[$name]: Did not transform $source"

            None
        }
      } else {
        logger debug s"Rule $name should not execute on $source"
        None
      }
    }

    protected def traceForSource(source: S): Option[T] = {
      traceLog.get(source) match {
        case Some((rule, target: T)) if rule == this ⇒ Some(target)
        case None ⇒ None
      }
    }
  }

  type TraceLog = collection.mutable.HashMap[EObject, (Rule[_, _], EObject)]

  val targetMetaModels: Seq[EPackage]

  private val session = new DynamicVariable[(Resource, TraceLog)](null)

  protected[m2m] lazy val targetBuilders = targetMetaModels map (new EMFBuilder(_))

  protected[m2m] def traceLog = session.value._2
  protected[m2m] def resource = session.value._1

  protected[m2m] def createEObject[T <: EObject: ClassTag]: T =
    createEObject(classTag[T].runtimeClass.getName) match {
      case x: T ⇒ x
      case _ ⇒ sys.error("")
    }

  protected[m2m] def createEObject(name: String): EObject = {
    val target = targetBuilders collectFirst {
      case builder if builder.canCreate(name) ⇒ builder.create(name)
    }

    require(target.isDefined, s"Unable to create target EClass: $name")

    target.get
  }

  protected[m2m] def loadRules: Seq[RH]

  trait RH {
    type RS <: EObject
    type RT <: EObject

    val rule: Rule[RS, RT]
  }

  //  private lazy val rules: Seq[Rule[_, _]] = loadRules
  private lazy val rules: Seq[RH] = loadRules

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

  protected[m2m] def transformOne(source: EObject, lazyRules: Boolean = true) = {
    logger debug s"Transforming $source"

    rules find { x ⇒ (x.rule.isLazy implies lazyRules) && x.rule.isApplicable(source) } match {
      case Some(rh) ⇒
        // TODO: type safety?
        rh.rule(source.asInstanceOf[rh.RS])
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
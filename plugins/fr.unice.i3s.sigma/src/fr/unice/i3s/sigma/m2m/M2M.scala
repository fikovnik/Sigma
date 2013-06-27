package fr.unice.i3s.sigma.m2m

import scala.annotation.implicitNotFound
import org.eclipse.emf.common.util.EList
import scala.reflect.{ classTag, ClassTag }
import org.eclipse.emf.ecore.EObject
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.internal.OverloadHack
import scala.collection.mutable.LinkedList
import scala.collection.mutable.ListBuffer
import org.eclipse.emf.ecore.EPackage
import fr.unice.i3s.sigma.TypeUnion
import fr.unice.i3s.sigma.support.EMFBuilder
import com.typesafe.scalalogging.log4j.Logging
import scala.reflect.macros.Context
import scala.util.DynamicVariable
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI

trait BRule {
  type From <: EObject
  type To <: EObject

  def apply(from: From): (Option[To], Seq[_ <: EObject])
  def isLazy: Boolean
  def canTransform(source: EObject): Boolean
}

@implicitNotFound(msg = "No conversion rule between ${From} and ${To}.")
trait Rule[-From <: EObject, +To <: EObject] {

  def apply(from: From): (Option[To], Seq[_ <: EObject])

  def isLazy: Boolean

  def canTransform(source: EObject): Boolean

}

trait RuleMethods { this: M2M with Logging ⇒

  // TODO: use partial functions by default
  def partial[F, T](perform: PartialFunction[F, T]) = perform

  // TODO: generate all 22 rules

  def rule[F <: EObject: ClassTag, T <: EObject: ClassTag, T2 <: EObject: ClassTag](delegate: (F, T, T2) ⇒ Unit): Rule[F, T] = {
    val r = new RuleImpl[F, T](classTag[T2]) {
      def apply(from: F): (Option[T], Seq[_ <: EObject]) = {
        if (shouldExecute(from)) {
          logger debug s"Executing $this on $from"

          val to = createTarget[T]
          val t2 = createTarget[T2]
          
          currentResource.value.getContents += to
          currentResource.value.getContents += t2
          
          delegate(from, to, t2)

          traceLog += (to -> this)
          traceLog += (t2 -> this)
          
          logger debug s"Executed $this, transformed to $to, $t2"

          (Some(to), Seq(t2))
        } else {
          (None, Seq())
        }
      }
    }
    rules += r
    r
  }

  // TODO: multirule

  def rule[F <: EObject: ClassTag, T <: EObject: ClassTag](delegate: PartialFunction[F, T])(implicit o: Overloaded1) = {
    val r = new RuleImpl[F, T] {
      def apply(from: F): (Option[To], Seq[_ <: EObject]) =
        if (shouldExecute(from) && delegate.isDefinedAt(from)) {
          logger debug s"Executing $this on $from"
          val to = delegate(from)
          traceLog += (to -> this)
          logger debug s"Executed $this, transformed to $to"
          (Some(to), Seq())
        } else (None, Seq())
    }
    rules += r
    r
  }

}

trait M2M extends EMFScalaSupport with OverloadHack with Logging {

  protected[m2m] val traceLog = new collection.mutable.HashMap[EObject, BRule]

  protected[m2m] val currentResource = new DynamicVariable[Resource](null)

  //  val sourceMetaModel: EPackage
  val targetMetaModels: Seq[EPackage]
  lazy val targetBuilders = targetMetaModels map (new EMFBuilder(_))

  // TODO: make type safe using type tags
  //  import TypeUnion._
  //  val targetMetaModels: |∨|[EPackage, Seq[EPackage]]
  //  lazy val targetBuilders = targetMetaModels match {
  //    case x: EPackage ⇒ Seq(new EMFBuilder(x))
  //    case xs: Seq[EPackage] ⇒ xs map (new EMFBuilder(_))
  //  }

  protected def createTarget[T <: EObject: ClassTag]: T = {
    val target = targetBuilders collectFirst {
      case builder if builder.canCreate[T] ⇒ builder.create[T]
    }

    require(target.isDefined, s"Unable to create target EClass: ${classTag[T]}")

    target.get
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

  val rules = ListBuffer[BRule]()

  abstract class RuleImpl[F <: EObject: ClassTag, T <: EObject: ClassTag](additional: ClassTag[_ <: EObject]*) extends Rule[F, T] with BRule {

    type From = F
    type To = T

    val fromTag = classTag[From]
    val toTag = classTag[To]

    def isLazy: Boolean = {
      // TODO: support for lazy rules
      false
    }

    def canTransform(source: EObject): Boolean = {
      fromTag.runtimeClass.isAssignableFrom(source.getClass)
    }

    def shouldExecute(from: F) = {
      traceLog.get(from) match {
        case Some(rule) if rule == this ⇒ false
        case _ ⇒ true
      }
    }

    override def toString = s"Rule ${fromTag.runtimeClass.getSimpleName} -> ${toTag.runtimeClass.getSimpleName}"
  }

  protected def createNewResource =
    new ResourceSetImpl().createResource(URI.createURI("transfromation"))

  def apply(source: EObject): EList[EObject] = {
    val resource = createNewResource

    currentResource.withValue(resource) {
      transform(source)
    }

    resource.getContents
  }

  protected def transform[T <: EObject: ClassTag](source: T) {
    logger debug s"Transforming $source"

    val result = rules find { x ⇒ !x.isLazy && x.canTransform(source) } match {
      case Some(rule) ⇒

        val targets = rule(source.asInstanceOf[rule.From]) match {
          case (Some(target), xs) ⇒ target +: xs
          case _ ⇒ Seq()
        }

        targets
      case None ⇒
        logger debug (s"No rule to convert ${classTag[T]}")
        Seq()
    }

    for (elem ← source.eContents) transform(elem)
  }

  implicit class EObjectM2MSupport[A <: EObject](that: A) {
    def unary_~[B >: Null <: EObject](implicit r: Rule[A, B]): B = r(that)._1.orNull
  }

  implicit class EListM2MSupport[A <: EObject](that: EList[A]) {
    def unary_~[B <: EObject](implicit r: Rule[A, B]) = {
      val result = that map (r(_))
      result collect {
        case (Some(target), _) ⇒ target
      }
    }
  }

}
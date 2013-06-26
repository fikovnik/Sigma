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

trait BRule {
  type From <: EObject
  type To <: EObject

  def apply(from: From): Option[To]
  def isLazy: Boolean
  def canTransform(source: EObject): Boolean
}

@implicitNotFound(msg = "No conversion rule between ${From} and ${To}.")
trait Rule[-From <: EObject, +To <: EObject] {

  def apply(from: From): Option[To]

  def isLazy: Boolean

  def canTransform(source: EObject): Boolean

}

trait RuleMethods { this: M2M ⇒

  def partial[F, T](perform: PartialFunction[F, T]) = perform

  //  def rule[F <: EObject: ClassTag, T <: EObject: ClassTag](delegate: (F, T) ⇒ Unit) = {
  //    val r = new RuleImpl[F, T]() {
  //      def apply(from: F): Option[T] = {
  //        val to = createTarget[T]
  //        delegate(from, to)
  //        Some(to)
  //      }
  //    }
  //    rules += r
  //    r
  //  }

  // TODO: generate all 22 rules


  def rule[F <: EObject: ClassTag, T <: EObject: ClassTag, T2 <: EObject: ClassTag](delegate: (F, T, T2) ⇒ Unit) = {
    val r = new RuleImpl[F, T](classTag[T2]) {
      def apply(from: F): Option[T] = {
        val to = createTarget[T]
        val t2 = createTarget[T2]
        delegate(from, to, t2)
        Some(to)
      }
    }
    rules += r
    r
  }

  // TODO: multirule

  def rule[F <: EObject: ClassTag, T <: EObject: ClassTag](delegate: PartialFunction[F, T])(implicit o: Overloaded1) = {
    val r = new RuleImpl[F, T] {
      def apply(from: F): Option[T] =
        if (delegate.isDefinedAt(from)) Some(delegate(from))
        else None
    }
    rules += r
    r
  }
}

//object M2M {
//  import language.experimental.macros
//
//  type M2MContext = Context { type PrefixType = RuleMethods }
//
//  def hello[F <: EObject, T <: EObject](delegate: (F, T) ⇒ Unit): Rule[F, F] = macro hello_impl[F, T]
//
//  def hello_impl[F <: EObject, T <: EObject](c: M2MContext)(delegate: c.Expr[(F, T) ⇒ Unit]): c.Expr[Rule[F, T]] = {
//    import c.universe._
//    val paramRep = show(delegate.tree)
//    val paramRepTree = Literal(Constant(paramRep))
//    val paramRepExpr = c.Expr[String](paramRepTree)
//    reify { c.prefix.splice.rule2(paramRepExpr.splice, delegate.splice) }
//  }
//}

trait M2M extends EMFScalaSupport with OverloadHack with Logging {

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

  def guardedBy[T](g: Boolean) = g

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

    override def toString = s"Rule ${fromTag.runtimeClass.getSimpleName} -> ${toTag.runtimeClass.getSimpleName}"
  }

  def apply(source: EObject): Set[EObject] = {
    logger debug s"Transforming $source"

    val result = collection.mutable.Set[EObject]()

    result ++= transform(source)

    for (elem ← source.eContents) result ++= apply(elem)

    result.toSet
  }

  protected def transform[T <: EObject: ClassTag](source: T) = {
    val result = collection.mutable.Set[EObject]()

    for (rule ← rules if !rule.isLazy && rule.canTransform(source)) {
      logger debug s"Executing $rule on $source"
      // TODO: make type safe
      result ++= rule(source.asInstanceOf[rule.From])
    }

    result
  }

  implicit class EObjectM2MSupport[A <: EObject](that: A) {
    def unary_~[B >: Null <: EObject](implicit r: Rule[A, B]): B = r(that).orNull
  }

  implicit class EListM2MSupport[A <: EObject](that: EList[A]) {
    def unary_~[B <: EObject](implicit r: Rule[A, B]) = {
      val targets = that map (r(_))
      targets collect {
        case Some(t) ⇒ t
      }
    }
  }

}
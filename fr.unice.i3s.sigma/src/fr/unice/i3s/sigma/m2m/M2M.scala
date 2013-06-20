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

@implicitNotFound(msg = "No conversion rule between ${From} and ${To}.")
trait Rule[-From, +To] extends ((From) ⇒ To)

trait RuleMethods { this: M2M ⇒

  def partial[A, B](perform: PartialFunction[A, B]) = perform
//  def rule[From: ClassTag, To: ClassTag](delegate: (From, To) ⇒ Unit) = new Rule[From, To] {
//    def apply(from: From): To = null.asInstanceOf[To]
//  }

  def rule[From <: EObject: ClassTag, To <: EObject: ClassTag, T2 <: EObject: ClassTag](delegate: (From, To, T2) ⇒ Unit) = {
    new RuleImpl[From, To](classTag[T2])
  }

  def partialRule[From: ClassTag, To: ClassTag](delegate: PartialFunction[From, To])(implicit o: Overloaded1) = new Rule[From, To] {
    def apply(from: From): To = delegate(from)
  }
}

trait M2M extends EMFScalaSupport with OverloadHack {

  private type ¬[A] = A ⇒ Nothing
  type ∨[T, U] = ¬[¬[T] with ¬[U]]
  private type ¬¬[A] = ¬[¬[A]]

  /**
   * Disjunct union type that can be used to form union types such as:
   * {{{
   * [T: (Int |∨| String)#λ]
   * }}}
   *
   */
  type |∨|[T, U] = { type λ[X] = ¬¬[X] <:< (T ∨ U) }

  // TODO: explore shapeless with HList

//  val sourceMetaModel: EPackage
//  val targetMetaModels: |∨|[EPackage, List[EPackage]]

  // explore stuff like - for type safety i.e only EObjects
  // def ruleClass2Table = transform(cls: UmlClass, tab: Table, pkey: Column) {

  def guardedBy[T](g: Boolean) = g

  implicit class CheckedBoolean(that: Boolean) {
    def transform[T](g: ⇒ T): Option[T] = {
      if (that) {
        println("transforms")
        Some(g)
      } else {
        println("cancelled")
        None
      }
    }
  }

  private val rules = ListBuffer[Rule[_, _]]()

  class RuleImpl[-From: ClassTag, +To: ClassTag](additional: ClassTag[_ <: EObject]*) extends Rule[From, To] {

    def apply(from: From) = {
      null.asInstanceOf[To]
    }

    def transformaAll(excluded: LinkedList[EObject]) {
      // get all instances of From
      //      for (e <- elems) {
      //        transform(e)
      //      }
    }

  }

  def apply(source: EObject): Set[EObject] = {
    Set[EObject]()
    // iterate over all non lazy rules
    //    for (rule <- rules) {
    //      rule.transformAll()
    //    }

  }

  implicit class EObjectM2MSupport[A <: EObject](that: A) {
    def unary_~[B](implicit r: Rule[A, B]) = r(that)
  }

  implicit class EListM2MSupport[A <: EObject](that: EList[A]) {
    //    def unary_~[B](implicit r: Rule[A, B]) = that.map(r(_))
    def unary_~[B <: EObject](implicit r: Rule[A, B]) = that.map(~_)
  }

}
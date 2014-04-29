package fr.unice.i3s.sigma

import scala.util.Try
import scala.reflect.ClassTag
import scala.collection.generic.Growable

package object m2m {

  trait M2MContext {
    protected[m2m] def sourceForTarget(elem: AnyRef): Option[AnyRef]
    protected[m2m] def sourcesForTarget(elem: AnyRef): Seq[AnyRef]
    
    protected[m2m] def targetsForSource[T : ClassTag](elem: AnyRef): Set[T]
    protected[m2m] def allTargetsForSource(elem: AnyRef): Seq[Set[AnyRef]]
  }

  def applyUntilFailure[A, B](elems: TraversableOnce[A])(fun: A ⇒ Try[B]): Try[Seq[B]] = Try {
    (elems foldLeft Seq[B]()) { (a, b) ⇒
      a :+ fun(b).get
    }
  }

}
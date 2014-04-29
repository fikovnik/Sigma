package fr.unice.i3s.sigma.m2m

import scala.collection.generic.Growable
import scala.reflect.ClassTag
import scala.reflect.classTag
import org.eclipse.emf.ecore.EObject
import com.typesafe.scalalogging.log4j.Logging
import scala.util.Try
import scala.util.Success
import scala.util.Failure
import fr.unice.i3s.sigma.m2m._
import fr.unice.i3s.sigma.support.SigmaSupport._

trait Transformable {
  def sSource: Option[AnyRef]

  def sSources: Seq[AnyRef]

  def sTarget[T: ClassTag]: T

  def sTargetOption[T: ClassTag]: Option[T]

  def sTargets[T: ClassTag]: Set[T]

  def sAllTargets: Seq[Set[AnyRef]]
}

class DefaultTransformable[T <: AnyRef](context: M2MContext, that: T) extends Transformable with Logging {

  def sSource: Option[AnyRef] = context.sourceForTarget(that)

  def sSources: Seq[AnyRef] = context.sourcesForTarget(that)

  def sTarget[T: ClassTag]: T = sTargetOption asserting (s"No rule to transform $that (${that.getClass}) to ${classTag[T]}")

  def sTargetOption[T: ClassTag]: Option[T] = sTargets[T].headOption

  def sTargets[T: ClassTag]: Set[T] = context.targetsForSource[T](that)

  def sAllTargets: Seq[Set[AnyRef]] = context.allTargetsForSource(that)
}

class SigmaM2MSequenceSupport[A <% Transformable](that: Traversable[A]) {

  // TODO: sSource
  // TODO: sSources

  def sTarget[T: ClassTag]: Seq[T] = {
    val targets = that map (_.sTargetOption[T]) toSeq
    
    targets collect { case Some(v) ⇒ v }
  }

  def sTargets[T: ClassTag]: Seq[Set[T]] = that map (_.sTargets[T]) toSeq

}
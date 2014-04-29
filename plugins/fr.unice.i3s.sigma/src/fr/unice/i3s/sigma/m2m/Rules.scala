package fr.unice.i3s.sigma.m2m

import scala.util.Try
import scala.annotation.tailrec
import scala.util.Success
import fr.unice.i3s.sigma.support.SigmaSupport._

trait Rule {

  def sourceClass: MetaClass

  def targetClasses: Seq[MetaClass]

  def primaryTargetClass: MetaClass = targetClasses(0)

  def transform(source: AnyRef, targets: Seq[AnyRef]): Try[Boolean] =
    if (!isApplicable(source)) Success(false)
    else {
      doTransform(source, targets)
    }

  protected def doTransform(source: AnyRef, targets: Seq[AnyRef]): Try[Boolean]

  /** Determines if the rule represented by this `Rule` instance is applicable for the given `source` model element. */
  def isApplicable(source: AnyRef): Boolean

  /** The name of the rule. */
  def name: String

  override def toString =
    s"Rule $name (${sourceClass.name} -> ${targetClasses map (_.name) mkString (", ")})"
}

/**
 * A regular rule is using *type-of* relation for matching the source model elements `sourcgetClass`.
 */
trait MatchedRule extends Rule {

  def isApplicable(source: AnyRef) = sourceClass isTypeOf source

  override def toString = "Matched" + super.toString
}

trait AbstractRule extends Rule {
  def isSuperRuleOf(baseRule: Rule): Boolean = {

    @tailrec
    def checkTargets(baseTargets: Seq[MetaClass], superTargets: Seq[MetaClass]): Boolean = superTargets match {
      case Seq() ⇒ true
      case Seq(x, xs @ _*) ⇒ baseTargets.indexWhere { y ⇒ x isKindOf y } match {
        case -1 ⇒ false
        case idx ⇒ checkTargets(baseTargets.slice(idx, baseTargets.size), xs)
      }
    }

    sourceClass.isKindOf(baseRule.sourceClass) && checkTargets(baseRule.targetClasses, targetClasses)
  }

  override def transform(source: AnyRef, targets: Seq[AnyRef]) = doTransform(source, targets)

  override def isApplicable(source: AnyRef) = false

  override def toString = "Abstract" + super.toString
}

trait GreedyRule extends Rule {

  override def isApplicable(source: AnyRef) = sourceClass isKindOf source

  override def toString = "Greedy" + super.toString
}

trait LazyRule extends Rule {
  override def toString = "Lazy" + super.toString
}

trait LazyUniqueRule extends Rule {
  override def toString = "LazyUnique" + super.toString
}
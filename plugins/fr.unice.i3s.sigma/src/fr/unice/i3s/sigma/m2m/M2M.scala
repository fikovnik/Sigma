package fr.unice.i3s.sigma.m2m

import scala.annotation.tailrec
import scala.reflect.ClassTag
import scala.reflect.classTag
import scala.util.DynamicVariable
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.support.SigmaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._
import fr.unice.i3s.sigma.support.ScalaEcorePackage
import fr.unice.i3s.sigma.internal.OverloadHack

// TODO: shapeless
trait Rule {

  def sourceClass: EClass

  def targetClasses: Seq[EClass]

  def primaryTargetClass: EClass = targetClasses(0)

  def conflicts(rule: Rule): Boolean =
    if (rule != this)
      !(rule.sourceClass != this.sourceClass || rule.primaryTargetClass != this.primaryTargetClass)
    else false

  def transform(source: EObject, targets: Seq[EObject]): Try[Boolean] =
    if (!isApplicable(source)) Success(false)
    else {
      doTransform(source, targets)
    }

  protected def doTransform(source: EObject, targets: Seq[EObject]): Try[Boolean]

  /** Determines if the rule represented by this `Rule` instance is applicable for the given `source` model element. */
  def isApplicable(source: EObject): Boolean

  /** The name of the rule. */
  def name: String

  override def toString =
    s"Rule $name (${sourceClass.name} -> ${targetClasses map (_.name) mkString (", ")})"
}

/**
 * A regular rule is using *type-of* relation for matching the source model elements `sourceClass`.
 */
trait MatchedRule extends Rule {

  def isApplicable(source: EObject) = sourceClass == source.eClass

  override def toString = "Matched" + super.toString
}

trait AbstractRule extends Rule {
  def isSuperRuleOf(baseRule: Rule): Boolean = {

    @tailrec
    def checkTargets(baseTargets: Seq[EClass], superTargets: Seq[EClass]): Boolean = superTargets match {
      case Seq() ⇒ true
      case Seq(x, xs @ _*) ⇒ baseTargets.indexWhere { y ⇒ x.isSuperTypeOf(y) } match {
        case -1 ⇒ false
        case idx ⇒ checkTargets(baseTargets.slice(idx, baseTargets.size), xs)
      }
    }

    sourceClass.isSuperTypeOf(baseRule.sourceClass) && checkTargets(baseRule.targetClasses, targetClasses)
  }

  override def transform(source: EObject, targets: Seq[EObject]) = doTransform(source, targets)

  override def isApplicable(source: EObject) = false

  override def toString = "Abstract" + super.toString
}

trait GreedyRule extends Rule {

  override def conflicts(rule: Rule): Boolean =
    if (rule != this)
      !(rule.sourceClass.isSuperTypeOf(this.sourceClass) || rule.primaryTargetClass != this.primaryTargetClass)
    else false

  override def isApplicable(source: EObject) = sourceClass isSuperTypeOf source.eClass

  override def toString = "Greedy" + super.toString
}

/**
 * The base trait for all Model-to-Model Transformations
 */
// TODO: rename to M2MT
trait BaseM2MT extends SigmaSupport with Logging with OverloadHack {

  /** Trace log entry*/
  type TraceLogEntry = Map[Rule, Seq[EObject]]
  /** Trace log that contains the transformation trace used to resolve `source` <-> `target` elements. */
  type TraceLog = collection.mutable.HashMap[EObject, TraceLogEntry]

  // TODO: allow either a single package or a sequence of packages
  private[this] var _sourceMetaModels: Seq[EPackage] = _
  def sourceMetaModels: Seq[EPackage] = {
    require(_sourceMetaModels != null, "Source meta-models cannot be empty.")
    _sourceMetaModels.toSeq
  }
  def sourceMetaModels_=(metaModel: EPackage) = _sourceMetaModels = Seq(metaModel)
  def sourceMetaModels_=(metaModels: Seq[EPackage]) = _sourceMetaModels = metaModels
  def sourceMetaModels_=(metaModel: ScalaEcorePackage[_ <: EPackage]) = _sourceMetaModels = Seq(metaModel.ePackage)
  def sourceMetaModels_=(metaModels: Seq[ScalaEcorePackage[_ <: EPackage]])(implicit o: Overloaded1) = _sourceMetaModels = metaModels map (_.ePackage)

  private[this] var _targetMetaModels: Seq[EPackage] = _
  def targetMetaModels: Seq[EPackage] = {
    require(_targetMetaModels != null, "Target meta-models cannot be empty.")
    _targetMetaModels.toSeq
  }
  def targetMetaModels_=(metaModel: EPackage) = _targetMetaModels = Seq(metaModel)
  def targetMetaModels_=(metaModels: Seq[EPackage]) = _targetMetaModels = metaModels
  def targetMetaModels_=(metaModel: ScalaEcorePackage[_ <: EPackage]) = _targetMetaModels = Seq(metaModel.ePackage)
  def targetMetaModels_=(metaModels: Seq[ScalaEcorePackage[_ <: EPackage]])(implicit o: Overloaded1) = _targetMetaModels = metaModels map (_.ePackage)

  /** M2M Transformation session allowing to execute multiple M2M transformations at the same time. */
  private[this] val session = new DynamicVariable[(collection.mutable.ListBuffer[EObject], TraceLog)](null)

  /** Transformation trace log */
  protected[m2m] def traceLog = session.value._2

  protected def loadRules: Seq[Rule]

  lazy val rules: Seq[Rule] = {
    val res = loadRules

    val nonAbstractRules = res filter {
      _ match {
        case _: AbstractRule ⇒ false
        case _ ⇒ true
      }
    }

    for (rule ← nonAbstractRules) {
      res find { r ⇒ r.conflicts(rule) } match {
        case Some(conflict) ⇒ throw new M2MTransformationException(s"Rule $rule conflits with $conflict likely because of having the same source->primary target relation")
        case None ⇒
      }
    }

    res foreach { r ⇒ logger debug s"Loaded rule: $r" }
    res
  }

  protected def check = {
    require(_sourceMetaModels != null, "Source meta models cannot be empty.")
    require(_targetMetaModels != null, "Target meta models cannot be empty.")
    require(rules != null && rules.nonEmpty, "There must be at least one rule defined")
  }

  // TODO: apply(source: Resource): Resource

  def apply(source: EObject): (Iterable[EObject], Iterable[EObject]) = {
    check

    val tl = new TraceLog
    val sc = collection.mutable.ListBuffer[EObject]()

    session.withValue((sc, tl)) {
      transform(source)

      val pri = primaryTargetsForSource(source).toSeq
      val sec = traceLog.values.flatMap(_.values).flatten.toSeq
      val secNonContained = sec filter (_.eContainer == null)
      val secNonPri = secNonContained diff pri

      (pri, secNonPri)
    }
  }

  protected def findRules(source: EObject): Seq[Rule] =
    rules filter (_.isApplicable(source))

  protected def findAbstractRules(rule: Rule): Seq[AbstractRule] =
    rules collect { case r: AbstractRule if r.isSuperRuleOf(rule) ⇒ r }

  protected def createTargets(rule: Rule, source: EObject): Seq[EObject] =
    rule.targetClasses map (_.newInstance)

  protected def executeRule(rule: Rule, source: EObject, targets: Seq[EObject]): Try[Boolean] = {
    logger trace s"${rule.name}: executing"

    rule.transform(source, targets) match {
      case res @ Success(true) ⇒
        logger trace s"${rule.name}: rule executed, result: ${targets}"
        res
      case res @ Success(false) ⇒
        logger trace s"${rule.name}: rule did not execute. Possibly because its guard did not match the source element."
        res
      case Failure(e) ⇒
        logger error s"${rule.name}: rule failure: $e"
        throw e
    }
  }

  protected def doTransformOne(source: EObject): Seq[Seq[EObject]] = {
    // 1. find matching rules
    findRules(source) match {
      case Seq() ⇒
        logger info s"No rule applicable to $source found."

        // no results
        Seq()

      case Seq(rules @ _*) ⇒
        logger trace s"Matched rules: ${rules map (_.name) mkString (", ")}"

        val transformations = collection.mutable.HashMap[Rule, Seq[EObject]]()

        // 2. execute all matching rules
        for (rule ← rules) {
          logger trace s"${rule.name}: begin execution"
          // 2.1 create targets
          val targets = createTargets(rule, source)

          // 2.3 find and execute all abstract rules        
          val abstractRules = findAbstractRules(rule)
          logger debug {
            if (abstractRules.nonEmpty)
              s"${rule.name}: found matching abstract rules: ${abstractRules mkString (", ")}"
            else
              s"${rule.name}: found no matching abstract rules"
          }
          for (abstractRule ← abstractRules) {

            // it is possible that the abstract rule defines less targets than the base rule
            // we therefore need to find the proper targets, e.g.:
            // AR: S, T1, T3
            //  R: S, T1, T2, T3
            // => should take only T1 and T3 from R
            @tailrec
            def findTargets(cls: Seq[EClass], vals: Seq[EObject], res: Seq[EObject] = Seq()): Seq[EObject] = cls match {
              case Seq() ⇒ res
              case Seq(x, xs @ _*) ⇒
                val i = vals.indexWhere { y ⇒ x.isSuperTypeOf(y.eClass) }
                findTargets(xs, vals.slice(i, vals.size), res :+ vals(i))
            }

            executeRule(abstractRule, source, findTargets(abstractRule.targetClasses, targets))
          }

          // 2.4 execute rules
          executeRule(rule, source, targets)

          // 2.7 store all targets
          transformations += (rule -> targets)
        }

        // 3 add to trace log
        traceLog += (source -> transformations.toMap)

        // return the results
        transformations.map { case (rule, targets) ⇒ targets }.toSeq
    }
  }

  protected def transformOne(source: EObject): Iterable[Iterable[EObject]] = {
    logger debug s"Transforming $source"

    // if source has been already transformed then return its result
    targetsForSource(source) match {
      case Seq() ⇒
        doTransformOne(source)
      case traces ⇒
        logger debug s"$source has been already transformed"
        traces
    }
  }

  protected[m2m] def transform(source: EObject): Iterable[EObject] = {
    // transform the element
    transformOne(source)

    // transform all its content
    for (elem ← source.eContents) transform(elem)

    primaryTargetsForSource(source)
  }

  protected[m2m] def transformed(elem: EObject): Boolean =
    traceLog contains elem

  /**
   * Returns all traces `target` element which has been transformed by this `rule` using the given `elem` source element.
   *
   * @param elem the source element
   * @param rule the concerned rule
   */
  protected[m2m] def tracesForSource(elem: EObject): TraceLogEntry = (traceLog get elem) getOrElse Map()

  /**
   * Returns all `target` elements which have been transformed from the given `elem` source element.
   *
   * @param elem the source element
   */
  protected[m2m] def targetsForSource(elem: EObject): Iterable[Iterable[EObject]] = tracesForSource(elem).values.toSeq

  /**
   * Returns all `target` elements which have been transformed by the given `rule` from the given `elem` source element.
   *
   * @param elem the source element
   * @param rule the rule that was involved in the transformation
   */
  protected[m2m] def targetsForSource(elem: EObject, rule: Rule = null): Iterable[EObject] =
    (tracesForSource(elem) get rule) getOrElse Seq()

  /**
   * Returns the primary `target` elements which have been transformed from the given `elem` source element.
   *
   * @param elem the source element
   */
  protected[m2m] def primaryTargetsForSource(elem: EObject): Iterable[EObject] =
    targetsForSource(elem) collect { case Seq(x, xs @ _*) ⇒ x }

  /**
   * Returns the primary `target` element which has been transformed by the given `rule` from the given `elem` source element.
   *
   * @param elem the source element
   * @param rule the concerned rule
   */
  protected[m2m] def targetForSource(elem: EObject, rule: Rule): Option[EObject] = targetsForSource(elem, rule) match {
    case Seq() ⇒ None
    case Seq(x, xs @ _*) ⇒ Some(x)
  }

  // TODO: move following to API

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

  implicit class OptionM2MSupport(that: Option[_ <: EObject]) {
    def unary_~[B >: Null <: EObject]: Option[B] = that flatMap (~_)
  }

  implicit class EObjectM2MSupport(that: EObject) {
    def unary_~[B <: EObject: ClassTag]: Option[B] = {
      transformOne(that)
      targetsForSource(that) collectFirst {
        // it takes the first one since that is the primary source-target relation
        //        case Seq(x, xs @ _*) if x.getClass.isAssignableFrom(classTag[B].runtimeClass) ⇒ x.asInstanceOf[B]
        case Seq(x: B, xs @ _*) ⇒ x
      }
    }
  }

  implicit class TraversableM2MSupport(that: Traversable[_ <: EObject]) {
    def unary_~[B <: EObject: ClassTag]: Traversable[B] = {
      that foreach transformOne

      println(classTag[B])

      val primary = that map primaryTargetsForSource
      val targets = primary map { x ⇒
        x collectFirst {
          case y if y.isInstanceOf[B] ⇒ y.asInstanceOf[B]
          //          case y if classTag[B].runtimeClass.isAssignableFrom(y.getClass) ⇒ y.asInstanceOf[B]
          //          case y: B ⇒ y
        }
      }
      targets collect { case Some(e) ⇒ e }
    }
  }

  implicit class EListM2MSupport(that: EList[_ <: EObject]) {
    def unary_~[B <: EObject: ClassTag]: Traversable[B] = ~(that.toSeq)
  }

}

trait M2MT extends BaseM2MT with MethodRules
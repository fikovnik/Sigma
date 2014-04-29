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
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.support.SigmaSupport._
import fr.unice.i3s.sigma.m2m._
import scala.collection.generic.Growable

/**
 * The base trait for all Model-to-Model Transformations
 */
trait BaseM2MT extends M2MContext with Logging {

  /** Trace log entry*/
  type TraceLogEntry = collection.mutable.HashMap[Rule, Set[AnyRef]]
  /** Trace log that contains the transformation trace used to resolve `source` <-> `target` elements. */
  type TraceLog = collection.mutable.HashMap[AnyRef, TraceLogEntry]

  // it is used to associate extra transformation results that would otherwise be lost
  private[this] val ExtraSource = new AnyRef

  /** M2M Transformation session allowing to execute multiple M2M transformations at the same time. */
  private[this] val session = new DynamicVariable[TraceLog](null)

  /** Current executing rule */
  private[this] val executingRule = new DynamicVariable[Rule](null)

  /** Transformation trace log */
  protected[m2m] def traceLog = session.value

  protected implicit val context: M2MContext = this

  lazy val rules: Seq[Rule] = {
    val res = loadRules
    res foreach { r ⇒ logger debug s"Loaded rule: $r" }
    res
  }

  private[this] var _sourceMetaModels: Seq[MetaModel] = _
  def sourceMetaModels: Seq[MetaModel] = _sourceMetaModels ensuring (_sourceMetaModels != null, "Source meta-models cannot be empty.")
  def sourceMetaModels_=(metaModel: MetaModel) = _sourceMetaModels = Seq(metaModel)
  def sourceMetaModels_=(metaModels: TraversableOnce[MetaModel]) = _sourceMetaModels = Seq(_sourceMetaModels: _*)

  private[this] var _targetMetaModels: Seq[MetaModel] = _
  def targetMetaModels: Seq[MetaModel] = _targetMetaModels ensuring (_ != null, "Target meta-models cannot be empty.")
  def targetMetaModels_=(metaModel: MetaModel) = _targetMetaModels = Seq(metaModel)
  def targetMetaModels_=(metaModels: TraversableOnce[MetaModel]) = _targetMetaModels = Seq(_targetMetaModels: _*)

  protected def loadRules: Seq[Rule]

  object MaintainanceRule extends Rule {
    def sourceClass = ???
    def targetClasses = ???
    def doTransform(source: AnyRef, targets: Seq[AnyRef]) = ???
    def isApplicable(source: AnyRef) = false
    def name: String = "MaintainanceRule"
  }

  protected[m2m] def findSourceMetaClass(elem: AnyRef): MetaClass = sourceMetaModels collectFirst {
    case e if e.containsElement(elem) => e.findMetaClass(elem).get
  } asserting {
    s"Element $elem could not be found in any source meta models ${sourceMetaModels mkString ("(", ")", ")")}"
  }

  protected[m2m] def findSourceMetaClass(clazz: Class[_]): MetaClass = sourceMetaModels collectFirst {
    case e if e.containsClass(clazz) => e.findMetaClass(clazz).get
  } asserting {
    s"Class ${clazz.name} could not be found in any source meta models ${sourceMetaModels mkString ("(", ")", ")")}"
  }

  protected[m2m] def findTargetMetaClass(elem: AnyRef): MetaClass = targetMetaModels collectFirst {
    case e if e.containsElement(elem) => e.findMetaClass(elem).get
  } asserting {
    s"Element $elem could not be found in any target meta models ${targetMetaModels mkString ("(", ")", ")")}"
  }

  protected[m2m] def findTargetMetaClass(clazz: Class[_]): MetaClass = targetMetaModels collectFirst {
    case e if e.containsClass(clazz) => e.findMetaClass(clazz).get
  } asserting {
    s"Class ${clazz.name} could not be found in any target meta models ${targetMetaModels mkString ("(", ")", ")")}"
  }

  def transform(source: AnyRef): Set[AnyRef] = transformAll(Seq(source))

  def transformAll(sources: TraversableOnce[AnyRef]): Set[AnyRef] = {
    session.withValue(new TraceLog) {

      executingRule.withValue(MaintainanceRule) {
        setUp
      }

      applyUntilFailure(sources) { source ⇒
        val mm = findSourceMetaClass(source)
        val sourceContents = mm.contents(source)

        applyUntilFailure(source +: sourceContents)(transformOne)
      }.get

      val targets = traceLog.values.flatMap(_.values).flatten.toSet

      executingRule.withValue(MaintainanceRule) {
        tearDown
      }

      targets
    }
  }

  protected[m2m] def findAllRules(source: AnyRef): Seq[Rule] =
    rules filter (_.isApplicable(source))

  protected[m2m] def findNonLazyRules(source: AnyRef): Seq[Rule] =
    findAllRules(source) filter { r ⇒
      r.isApplicable(source) &&
        !r.isInstanceOf[LazyRule] &&
        !r.isInstanceOf[LazyUniqueRule]
    }

  protected[m2m] def findRules[T: ClassTag](source: AnyRef, considerAllTargets: Boolean): Seq[Rule] = {
    val applicable = findAllRules(source)
    val meta = findTargetMetaClass(classTag[T].runtimeClass)

    if (considerAllTargets) {
      applicable filter (_.targetClasses exists { t ⇒ meta isKindOf t })
    } else {
      applicable filter { r => meta isKindOf r.primaryTargetClass }
    }
  }

  protected[m2m] def findAbstractRules(rule: Rule): Seq[AbstractRule] =
    rules collect { case r: AbstractRule if r.isSuperRuleOf(rule) ⇒ r }

  protected[m2m] def createTargets(rule: Rule, source: AnyRef): Seq[AnyRef] = {
    rule.targetClasses map (_.newInstance)
  }

  protected[m2m] def executeRule(rule: Rule, source: AnyRef, targets: Seq[AnyRef]): Try[Boolean] = {
    logger trace s"${rule.name}: executing"

    executingRule.withValue(rule) {
      rule.transform(source, targets) match {
        case res @ Success(true) ⇒
          logger trace s"${rule.name}: rule executed, result: ${targets}"
          res
        case res @ Success(false) ⇒
          logger trace s"${rule.name}: rule did not execute, possibly because its guard did not match the source element"
          res
        case res @ Failure(e) ⇒
          logger error s"${rule.name}: rule failure [${e.getClass.getName}]: ${e.getMessage}"
          res
      }
    }
  }

  protected[m2m] def doTransformOne(source: AnyRef, rule: Rule): Set[AnyRef] = {
    require(!rule.isInstanceOf[AbstractRule], "doTransformOne cannot be called on an AbstractRule")

    logger trace s"Transforming $source using $rule"

    // FIXME: the rule execution should be moved back to the rule itself
    if (!rule.isInstanceOf[LazyRule] && transformed(source, rule)) {
      logger trace s"${rule.name}: has already transformed $source"

      // return the already traced targets
      tracesForSource(source)(rule)
    } else {
      logger trace s"${rule.name}: begin execution"

      // create targets
      val targets = createTargets(rule, source)

      // store targets so consecutive requests for the transformation
      // will not cause the nest transformation of the same source
      associate(source, rule, targets)

      // find and execute all applicable abstract rules        
      val abstractRules = findAbstractRules(rule)
      logger debug {
        if (abstractRules.nonEmpty)
          s"${rule.name}: found matching abstract rules: ${abstractRules mkString (", ")}"
        else
          s"${rule.name}: found no matching abstract rules"
      }

      val abstractRuleExecution = applyUntilFailure(abstractRules) { abstractRule ⇒

        // it is possible that the abstract rule defines less targets than the base rule
        // we therefore need to find the proper targets, e.g.:
        // AR: S, T1, T3
        //  R: S, T1, T2, T3
        // => should take only T1 and T3 from R
        @tailrec
        def findTargets(cls: Seq[MetaClass], vals: Seq[AnyRef], res: Seq[AnyRef] = Seq()): Seq[AnyRef] = cls match {
          case Seq() ⇒ res
          case Seq(x, xs @ _*) ⇒
            val i = vals.indexWhere { y ⇒ x isKindOf y.getClass }
            findTargets(xs, vals.slice(i, vals.size), res :+ vals(i))
        }

        executeRule(abstractRule, source, findTargets(abstractRule.targetClasses, targets))
      }

      // based on the result of abstract rule execution
      abstractRuleExecution match {
        case Success(_) ⇒
          // execute rules
          val res = executeRule(rule, source, targets)

          logger trace s"${rule.name}: finish execution"

          res match {
            case Success(true) ⇒
              // rule executed and transformed
              targets.toSet
            case Success(false) ⇒
              // rule executed, but did not transformed - the original targets
              // are therefore replaced this is marked by an empty sequence
              traceLog(source)(rule) = Set()
              Set()
            case Failure(e) ⇒ throw e
          }
        case Failure(e) ⇒
          // bubble-up the failure
          throw new M2MTransformationException(s"Abstract rule invocation on $source failed", e)
      }
    }
  }

  protected[m2m] def transformOne(source: AnyRef): Try[Unit] = {
    if (transformed(source)) {
      Success()
    } else {
      // find matching rules
      findNonLazyRules(source) match {
        case Seq() ⇒
          logger info s"No rule applicable to $source found."
          // no results
          Success()

        case Seq(rules @ _*) ⇒
          logger trace s"Matched rules to transform $source: ${rules map (_.name) mkString (", ")}"

          // execute all not-applied matching rules
          val res = applyUntilFailure(rules) { rule ⇒ Try(doTransformOne(source, rule)) }

          res match {
            case Success(traces) ⇒ Success()
            case Failure(e) ⇒ Failure(new M2MTransformationException(s"Transformation of $source failed", e))
          }

      }
    }
  }

  /**
   * Returns `true` if all non-lazy rules have already been executed on the given `source`, `false` otherwise.
   *
   * @param elem the source element
   */
  protected[m2m] def transformed(elem: AnyRef): Boolean =
    findNonLazyRules(elem) forall (transformed(elem, _))

  /**
   * Returns `true` if the `rule` has already been executed on the given `source`, `false` otherwise.
   *
   * @param elem the source element
   * @param rule the concerned rule
   */
  protected[m2m] def transformed(elem: AnyRef, rule: Rule): Boolean =
    if (rule.isInstanceOf[LazyRule])
      false
    else
      traceLog get (elem) flatMap (_ get rule) isDefined

  def sourceForTarget(elem: AnyRef): Option[AnyRef] =
    traceLog find { case (s, t) ⇒ t.values exists (_ contains elem) } map { case (s, t) ⇒ s }

  def sourcesForTarget(elem: AnyRef): Seq[AnyRef] =
    traceLog filter { case (s, t) ⇒ t.values exists (_ contains elem) } map { case (s, t) ⇒ s } toSeq

  /**
   * Returns all targets elements which have been transformed from the given `elem` source element using regular matched rules.
   *
   * @param elem the source element
   * @param rule the concerned rule
   */
  protected[m2m] def tracesForSource(elem: AnyRef): TraceLogEntry =
    (traceLog get elem) getOrElse collection.mutable.HashMap()

  /**
   * Returns all targets elements which have been transformed from the given `elem` source element using all rules.
   *
   * @param elem the source element
   */
  protected[m2m] def allTargetsForSource(elem: AnyRef): Seq[Set[AnyRef]] = {
    val rules = findAllRules(elem)
    if (rules.isEmpty) {
      logger trace s"No rule to transform $elem"
      Seq()
    } else {
      val pending = rules filterNot (transformed(elem, _))
      val res = pending map (doTransformOne(elem, _))
      // currently executed once with all the already executed matched rules
      val all = res ++ (tracesForSource(elem) collect { case (k, v) if !pending.contains(k) => v })
      all
    }
  }

  protected[m2m] def targetsForSource[T: ClassTag](elem: AnyRef): Set[T] = {
    val rules = findRules[T](elem, considerAllTargets = false)
    if (rules.isEmpty) {
      logger trace s"No rule to transform $elem (${elem.getClass}) to ${classTag[T]}"
      Set()
    } else {
      val pending = rules filterNot (transformed(elem, _))
      val res = pending flatMap (doTransformOne(elem, _))
      // currently executed once with all the already executed matched rules
      val all = res.toSet ++ (tracesForSource(elem) collect { case (k, v) if !pending.contains(k) => v }).flatten
      all collect { case x: T => x }
    }
  }

  protected[m2m] def associate(source: AnyRef, rule: Rule, targets: Seq[AnyRef]) {

    traceLog get (source) match {
      case Some(entry) ⇒ entry get (rule) match {
        // lazy rules always overwrites the targets 
        case Some(trace) if rule.isInstanceOf[LazyRule] ⇒ entry(rule) = targets.toSet
        case Some(trace) ⇒ entry(rule) = trace ++ targets
        case None ⇒ entry += rule -> targets.toSet
      }
      case None ⇒
        traceLog += source -> collection.mutable.HashMap(rule -> targets.toSet)
    }
  }

  // API

  protected def associate(source: AnyRef, targets: Seq[AnyRef]) {
    require(executingRule.value != null, "associate can only be invoked from a rule body")
    associate(source, executingRule.value, targets)
  }

  protected def associate(source: AnyRef, target: AnyRef) {
    associate(source, Seq(target))
  }

  protected def associate(target: AnyRef) {
    associate(ExtraSource, target)
  }

  protected def setUp: Unit = {}

  protected def tearDown: Unit = {}

  protected def guardedBy[T](g: ⇒ Boolean) = g

  implicit class CheckedBoolean(that: Boolean) {
    def transform[T](g: ⇒ T): Option[T] = if (that) Some(g) else None
  }

  implicit def seq2TransformableSeq[A <% Transformable](that: Traversable[A]) = new SigmaM2MSequenceSupport(that)
}

trait M2MT extends BaseM2MT with MethodRules
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
import fr.unice.i3s.sigma.support.SigmaEcorePackage
import fr.unice.i3s.sigma.internal.OverloadHack
import scala.collection.generic.Growable

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

trait LazyRule extends Rule {
  override def toString = "Lazy" + super.toString
}

/**
 * The base trait for all Model-to-Model Transformations
 */
// TODO: rename to M2MT
trait BaseM2MT extends SigmaSupport with Logging with OverloadHack {

  /** Trace log entry*/
  type TraceLogEntry = collection.mutable.HashMap[Rule, Seq[EObject]]
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
  def sourceMetaModels_=(metaModel: SigmaEcorePackage[_ <: EPackage]) = _sourceMetaModels = Seq(metaModel.ePackage)
  def sourceMetaModels_=(metaModels: Seq[SigmaEcorePackage[_ <: EPackage]])(implicit o: Overloaded1) = _sourceMetaModels = metaModels map (_.ePackage)

  private[this] var _targetMetaModels: Seq[EPackage] = _
  def targetMetaModels: Seq[EPackage] = {
    require(_targetMetaModels != null, "Target meta-models cannot be empty.")
    _targetMetaModels.toSeq
  }
  def targetMetaModels_=(metaModel: EPackage) = _targetMetaModels = Seq(metaModel)
  def targetMetaModels_=(metaModels: Seq[EPackage]) = _targetMetaModels = metaModels
  def targetMetaModels_=(metaModel: SigmaEcorePackage[_ <: EPackage]) = _targetMetaModels = Seq(metaModel.ePackage)
  def targetMetaModels_=(metaModels: Seq[SigmaEcorePackage[_ <: EPackage]])(implicit o: Overloaded1) = _targetMetaModels = metaModels map (_.ePackage)

  /** M2M Transformation session allowing to execute multiple M2M transformations at the same time. */
  private[this] val session = new DynamicVariable[TraceLog](null)

  /** Transformation trace log */
  protected[m2m] def traceLog = session.value

  private def applyUntilFailure[A, B](elems: Seq[A], res: Seq[B] = Seq())(fun: A ⇒ Try[B]): Either[(A, Failure[B]), Seq[B]] = elems match {
    case Seq() ⇒ Right(res)
    case Seq(x, xs @ _*) ⇒ fun(x) match {
      case Success(succ) ⇒ applyUntilFailure(xs, res :+ succ)(fun)
      case fail @ Failure(_) ⇒ Left((x, fail))
    }
  }

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

  def execute(source: EObject): (Iterable[EObject], Iterable[EObject]) = this(source) match {
    case Success(res) ⇒ res
    case Failure(e) ⇒ throw e
  }

  def apply(source: EObject): Try[(Iterable[EObject], Iterable[EObject])] = {
    check

    session.withValue(new TraceLog) {
      transform(source) match {
        case Success(_) ⇒

          val pri = primaryTargetsForSource(source).toSeq
          val priNonContained = pri filter (_.eContainer == null)

          val sec = traceLog.values.flatMap(_.values).flatten.toSeq
          val secNonContained = sec filter (_.eContainer == null)
          val secNonPri = secNonContained diff pri

          Success(priNonContained, secNonPri)

        case Failure(e) ⇒ Failure(e)
      }
    }
  }

  protected[m2m] def findNonLazyRules(source: EObject): Seq[Rule] =
    rules filter { r ⇒ r.isApplicable(source) && !r.isInstanceOf[LazyRule] }

  protected[m2m] def findRules[T <: EObject: ClassTag](source: EObject): Seq[Rule] =
    rules filter { r ⇒
      r.isApplicable(source) &&
        classTag[T].runtimeClass.isAssignableFrom(r.primaryTargetClass.getInstanceClass)
    }

  protected[m2m] def findAbstractRules(rule: Rule): Seq[AbstractRule] =
    rules collect { case r: AbstractRule if r.isSuperRuleOf(rule) ⇒ r }

  protected[m2m] def createTargets(rule: Rule, source: EObject): Seq[EObject] =
    rule.targetClasses map (_.newInstance)

  protected[m2m] def executeRule(rule: Rule, source: EObject, targets: Seq[EObject]): Try[Boolean] = {
    logger trace s"${rule.name}: executing"

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

  protected[m2m] def doTransformOne(source: EObject, rule: Rule): Try[Unit] = {
    require(!rule.isInstanceOf[AbstractRule], "doTransformOne cannot be called on an AbstractRule")

    logger trace s"Transforming $source using $rule"

    // execute abstract rules
    // it could be that an execution of the last rule has already triggered 
    // an execution of this rule on the source object
    if (transformed(source, rule)) {
      logger trace s"${rule.name}: has already transformed $source"
      Success()
    } else {
      logger trace s"${rule.name}: begin execution"

      // create targets
      val targets = createTargets(rule, source)

      // store targets so consecutive requests for the transformation
      // will not cause the nest transformation of the same source
      traceLog.get(source) match {
        case Some(entry) ⇒
          entry += rule -> targets
        case None ⇒
          traceLog += (source -> collection.mutable.HashMap(rule -> targets))
      }

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
        def findTargets(cls: Seq[EClass], vals: Seq[EObject], res: Seq[EObject] = Seq()): Seq[EObject] = cls match {
          case Seq() ⇒ res
          case Seq(x, xs @ _*) ⇒
            val i = vals.indexWhere { y ⇒ x.isSuperTypeOf(y.eClass) }
            findTargets(xs, vals.slice(i, vals.size), res :+ vals(i))
        }

        executeRule(abstractRule, source, findTargets(abstractRule.targetClasses, targets))
      }

      // based on the result of abstract rule execution
      abstractRuleExecution match {
        case Right(_) ⇒
          // execute rules
          val res = executeRule(rule, source, targets)

          logger trace s"${rule.name}: finish execution"

          res match {
            case Success(true) ⇒
              // rule executed and transformed
              Success()
            case Success(false) ⇒
              // rule executed, but did not transformed
              // this is marked by an empty Seq() stored in the trace log
              traceLog(source)(rule) = Seq()
              Success()
            case Failure(e) ⇒ Failure(e)
          }
        case Left((abstractRule, Failure(e))) ⇒
          // bubble-up the failure
          Failure(new M2MTransformationException(s"Invocation of ${abstractRule} failed", e))
      }
    }
  }

  protected[m2m] def doTransformOne(source: EObject): Try[Unit] = {
    logger debug s"Transforming $source"

    // find matching rules
    findNonLazyRules(source) match {
      case Seq() ⇒
        logger info s"No rule applicable to $source found."

        // no results
        Success()

      case Seq(rules @ _*) ⇒
        logger trace s"Matched rules: ${rules map (_.name) mkString (", ")}"

        // execute all not-applied matching rules
        val results = applyUntilFailure(rules) { rule ⇒ doTransformOne(source, rule) }

        results match {
          case Right(traces) ⇒ Success()
          case Left((rule, Failure(e))) ⇒ Failure(new M2MTransformationException(s"Invocation of ${rule} failed", e))
        }

    }
  }

  protected[m2m] def transformOne(source: EObject): Try[Unit] = {
    require(source != null, "Source element cannot be null")

    if (transformed(source)) Success()
    else doTransformOne(source)
  }

  protected[m2m] def transform(source: EObject): Try[Unit] = {

    // transform the element
    transformOne(source) match {
      case Success(x) ⇒

        // transform all its content
        applyUntilFailure(source.eContents)(transform(_)) match {
          case Right(_) ⇒ Success()
          case Left((elem, fail)) ⇒ fail
        }

      case fail @ Failure(_) ⇒ fail
    }
  }

  /**
   * Returns `true` if all the non-lazy rules have already been executed on the given `source` and `false` otherwise.
   *
   * @param elem the source element
   */
  protected[m2m] def transformed(elem: EObject): Boolean = {
    val rules = findNonLazyRules(elem)
    rules forall (transformed(elem, _))
  }

  /**
   * Returns `true` if the `rule` has already been executed on the given `source` and `false` otherwise.
   *
   * @param elem the source element
   * @param rule the concerned rule
   */
  protected[m2m] def transformed(elem: EObject, rule: Rule): Boolean = {
    traceLog get elem flatMap (_ get rule) isDefined
  }

  /**
   * Returns all traces `target` element which has been transformed by this `rule` using the given `elem` source element.
   *
   * @param elem the source element
   * @param rule the concerned rule
   */
  protected[m2m] def tracesForSource(elem: EObject): TraceLogEntry = (traceLog get elem) getOrElse collection.mutable.HashMap()

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
  protected[m2m] def targetsForSource(elem: EObject, rule: Rule): Iterable[EObject] =
    (tracesForSource(elem) get rule) getOrElse Seq()

  /**
   * Returns the primary `target` elements which have been transformed from the given `elem` source element.
   *
   * @param elem the source element
   */
  protected[m2m] def primaryTargetsForSource(elem: EObject): Iterable[EObject] =
    targetsForSource(elem) collect { case Seq(x, xs @ _*) ⇒ x }

  /**
   * Returns the primary `target` elements which have been transformed from the given `elem` source element.
   *
   * @param elem the source element
   */
  protected[m2m] def primaryTargetForSource(elem: EObject, rule: Rule): Option[EObject] =
    targetForSource(elem, rule).toSeq match {
      case Seq() ⇒ None
      case Seq(x, xs @ _*) ⇒ Some(x)
    }

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

  private case class DefaultTransformable(that: EObject) extends Transformable {
    def transform[A <: EObject: ClassTag]: Option[A] = that.sEquivalent[A]
  }

  private case class NoTransformable extends Transformable {
    def transform[A <: EObject: ClassTag]: Option[A] = None
  }

  private case class DefaultTransformableSequence(that: Traversable[EObject]) extends TransformableSequence {
    def transform[A <: EObject: ClassTag]: Traversable[A] = that.sEquivalent[A]
  }

  implicit class CheckedBoolean(that: Boolean) {
    def transform[T](g: ⇒ T): Option[T] = if (that) Some(g) else None
  }

  implicit class OptionM2MSupport(that: Option[_ <: EObject]) {
    def unary_~ : Transformable = that map DefaultTransformable getOrElse NoTransformable()
  }

  implicit class EObjectM2MSupport(that: EObject) {

    def sAllEquivalents: Seq[EObject] = Option(that) match {
      case Some(value) ⇒
        transformOne(value);
        primaryTargetsForSource(value).toSeq
      case None ⇒
        Seq()
    }

    def sEquivalents[T <: EObject: ClassTag]: Seq[T] = findRules[T](that) match {
      case Seq() ⇒ Seq()
      case rules ⇒
        rules foreach (doTransformOne(that, _))
        primaryTargetsForSource(that).toSeq collect { case x: T ⇒ x }
    }

    /**
     * @return the transformed object or [[None]] in the case there is no rule that can transform `that` into `T`
     */
    def sEquivalent[T <: EObject: ClassTag]: Option[T] = findRules[T](that) match {
      case Seq() ⇒
        logger trace s"No rule to transform $that into ${classTag[T]}"
        None
      case Seq(rule) ⇒
        doTransformOne(that, rule) match {
          case Success(_) ⇒ primaryTargetForSource(that, rule) map (_.asInstanceOf[T])
          case Failure(_) ⇒ None
        }
      case Seq(rules @ _*) ⇒
        throw new M2MTransformationException(s"Method equivalent[${classTag[T]}] cannot be applied on ${that.getClass} since there are multiple rules that can transform it $rules")
    }

    def unary_~ : Transformable = DefaultTransformable(that)

  }

  implicit class TraversableM2MSupport(that: Traversable[_ <: EObject]) {

    /**
     * Triggers execution of all applicable rules.
     */
    def sAllEquivalents: Seq[Seq[EObject]] = {
      that foreach transformOne
      (that map (primaryTargetsForSource(_).toSeq)).toSeq
    }

    def sEquivalents[T <: EObject: ClassTag]: Seq[Seq[T]] = {
      val targets = that map (_.sEquivalents[T])
      targets.toSeq
    }
    
    /**
     * Triggers execution only of a rule that can transform `that` into `T`.
     */
    def sEquivalent[T <: EObject: ClassTag]: Seq[T] = {
      val targets = that map (_.sEquivalent[T])

      targets.toSeq collect { case Some(v) ⇒ v }
    }

    def unary_~ : TransformableSequence = DefaultTransformableSequence(that)
  }

  trait GrowableM2MSupport {

    type A <: EObject

    protected def +=(elem: A): this.type

    /**
     * Adds a single element to this growable collection.
     *
     *  @param elem  the element to add.
     *  @return the growable collection itself
     */
    def +=(elem: Transformable)(implicit ev: ClassTag[A]): this.type = { elem.transform[A] foreach (+=(_)); this }

    /**
     * Adds two or more elements to this growable collection.
     *
     *  @param elem1 the first element to add.
     *  @param elem2 the second element to add.
     *  @param elems the remaining elements to add.
     *  @return the growable collection itself
     */
    def +=(elem1: Transformable, elem2: Transformable, elems: Transformable*)(implicit ev: ClassTag[A]): this.type = {
      this += elem1 += elem2
      elems foreach +=
      this
    }

    /**
     * Adds all elements produced by a [[TransformableSequence]] to this growable collection.
     *
     *  @param xs the TransformableSequence producing the elements to add.
     *  @return	the growable collection itself.
     */
    def ++=(xs: TransformableSequence)(implicit ev: ClassTag[A]): this.type = { xs.transform[A] foreach +=; this }
  }

  implicit class ScalaGrowableM2MSupport[B <: EObject: ClassTag](that: Growable[B]) extends GrowableM2MSupport {
    type A = B

    protected def +=(elem: A) = { that += elem; this }
  }

  implicit class EListM2MSupport[B <: EObject: ClassTag](that: EList[B]) extends GrowableM2MSupport {
    type A = B

    def +=(elem: A): this.type = { that add elem; this }

    def +=(elem: Option[A]): this.type = { elem foreach +=; this }

    /**
     * Adds all elements produced by a [[TraversableOnce]] to this growable collection.
     *
     *  @param xs the [[TraversableOnce]] producing the elements to add.
     *  @return	the growable collection itself.
     */
    def ++=(xs: TraversableOnce[A]): this.type = { xs foreach +=; this }

    def ++=(xs: TraversableOnce[Option[A]])(implicit e: Overloaded1): this.type = { xs foreach +=; this }

    def equivalents: Seq[Seq[EObject]] = that.toSeq.sAllEquivalents

    def equivalents[T <: EObject: ClassTag]: Seq[Seq[T]] = that.toSeq.sEquivalents[T]

    def equivalent[T <: EObject: ClassTag]: Seq[T] = that.toSeq.sEquivalent[T]

    def unary_~ : TransformableSequence = ~(that.toSeq)
  }

}

trait M2MT extends BaseM2MT with MethodRules
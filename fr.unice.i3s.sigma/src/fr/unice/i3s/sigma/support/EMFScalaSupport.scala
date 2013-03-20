package fr.unice.i3s.sigma.support

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.util.EcoreUtil
import scala.reflect.{ ClassTag, classTag }
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.ecore.util.Diagnostician
import scala.collection.GenTraversableOnce
import org.eclipse.emf.common.util.EMap
import fr.unice.i3s.sigma.util.DelegatingEList
import scala.collection.mutable.Buffer
import scala.language.implicitConversions

trait EMFScalaSupport {

  // TODO: rewrite the Diagnostics to be nomads
  implicit class RichSigmaDiagnostic(that: Diagnostic) {
    private val SEVERITIES = Map(
      Diagnostic.OK -> "OK",
      Diagnostic.INFO -> "INFO",
      Diagnostic.WARNING -> "WARNING",
      Diagnostic.ERROR -> "ERROR",
      Diagnostic.CANCEL -> "CANCEL")

    def flatten: List[Diagnostic] = {
      that.getChildren.toList match {
        case Nil ⇒ that :: Nil
        case e ⇒ e.flatMap(_.flatten).toList
      }
    }

    def prettyPrint = {
      flatten
        .map(d ⇒ "%s %s (%s)\n"
          format (SEVERITIES(d.getSeverity), d.getMessage, d.getData.get(0)))
        .mkString("\n")
    }

    def findConstraint(name: String, obj: Option[EObject], severity: Int = Diagnostic.ERROR): Option[Diagnostic] = {
      val msg = "The '%s' constraint is violated" format name

      flatten.find(e ⇒ e.getMessage.startsWith(msg) &&
        e.getSeverity == severity &&
        (obj match {
          case Some(x) ⇒ e.getData.get(0) == x
          case None ⇒ true
        }))
    }

    def containsConstraint(name: String, obj: Option[EObject], severity: Int = Diagnostic.ERROR) =
      findConstraint(name, obj, severity).isDefined

    def isOK = that.getSeverity == Diagnostic.OK
  }

  implicit class RichSigmaNotifier(that: Notifier) {
    def adapter[A: ClassTag] = {
      Option(EcoreUtil.getAdapter(that.eAdapters, classTag[A].runtimeClass).asInstanceOf[A])
    }
  }

  implicit class RichSigmaEObject[A <: EObject](that: A) {

    def validate = Diagnostician.INSTANCE.validate(that)

    def violations(severity: Int = Diagnostic.ERROR) = {
      validate.flatten.filter(_.getSeverity() == severity)
    }

    /**
     * @returns true if object represented by this instance directly violates the given constrain
     */
    def violatesConstraint(name: String, severity: Int = Diagnostic.ERROR) = {
      validate.containsConstraint(name, Some(that), severity)
    }

    /**
     * @returns true if object represented by this instance or any of its children violates the given constrain
     */
    def violatesConstraintAny(name: String, severity: Int = Diagnostic.ERROR) = {
      validate.containsConstraint(name, None, severity)
    }

    def isValid = {
      validate.isOK
    }

    def copy = EcoreUtil.copy(that)
  }

  /**
   * Includes some of the missing collection operations that are present in OCL
   */
  implicit class RichSigmaList[A](that: List[A]) {
    def unique = {
      that.distinct.lengthCompare(that.length) == 0
    }

    def notEmpty = {
      !that.isEmpty
    }

    def includesAll[B](b: GenTraversableOnce[B]) = {
      b.forall(that.contains(_))
    }
  }

  implicit class RichSigmaBoolean(that: Boolean) {
    def implies(b: ⇒ Boolean) = {
      !that || b
    }
  }

  implicit def scalaBufferAsEList[T](that: Buffer[T]) = new DelegatingEList(that)

  //  // conversion between EMF collections
  //  implicit def eListAsScalaImmutableList[A](a: EList[A]): List[A] =
  //    asScalaBuffer(a).toList
  //
  //  implicit def scalaListAsEList[A](a: List[A]): EList[A] =
  //    new DelegatingEList(a)

  implicit def eMapAsScalaMap[A, B](a: EMap[A, B]): scala.collection.mutable.Map[A, B] =
    mapAsScalaMap(a.map())
}

object EMFScalaSupport extends EMFScalaSupport
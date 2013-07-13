package fr.unice.i3s.sigma.support

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
import java.io.PrintStream
import org.eclipse.emf.ecore.util.EContentAdapter
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.util.EList
import scala.collection.SeqLike
import scala.collection.IterableLike

trait EMFScalaSupport {

  implicit def eMapAsScalaMap[A, B](a: EMap[A, B]): scala.collection.mutable.Map[A, B] =
    scala.collection.JavaConversions.mapAsScalaMap(a.map())

  implicit def asScalaBuffer[A](that: EList[A]): Buffer[A] =
    scala.collection.JavaConversions.asScalaBuffer(that)
  implicit def asEList[T](that: Buffer[T]) = new DelegatingEList(that)
  implicit def asEList[T](that: Seq[T]) = new DelegatingEList(that.toBuffer)

  // TODO: rewrite the Diagnostics to be nomads
  implicit class RichSigmaDiagnostic(that: Diagnostic) {
    import collection.JavaConversions._
    
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

    def init(fun: A ⇒ Any): A = {
      fun(that)
      that
    }

    def initLater(fun: A ⇒ Any): A = {
      that.adapter[PostponedInitizationAdapter[_]] match {
        case Some(_) ⇒ throw new IllegalStateException("Multiple postponed initialization is not supported. Object: " + that)
        case None ⇒ that.eAdapters += new PostponedInitizationAdapter(fun)
      }
      that
    }

    def dump(out: PrintStream = System.out, indent: Int = 0) {
      out.println(" " * indent + that)
      for (e ← that.eContents) {
        e.dump(out, indent + 2)
      }
    }

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
    
    def container[T <: EObject : ClassTag](): T = that match {
      case x: T => x
      case _ => throw new IllegalArgumentException(s"The eContainer of $that is ${that.eContainer.getClass} not ${classTag[T].runtimeClass}")
    }
  }

  /**
   * Includes some of the missing collection operations that are present in OCL
   */
  implicit class RichSigmaSeq[A](that: Seq[A]) {
    def unique = {
      that.distinct.lengthCompare(that.length) == 0
    }

    def notEmpty = {
      !that.isEmpty
    }

    def includesAll[B](b: GenTraversableOnce[B]) = {
      b.forall(that.contains(_))
    }

    // TODO: transitive closure
  }

  implicit class RichSigmaEList[A <: EObject : ClassTag](that: EList[A]) {
    def +==(elem: A): A = {
      that.add(elem)
      elem
    }

    def ++==[B <: A](elems: Seq[B]): Seq[B] = {
      that.addAll(elems)
      elems
    }
    
    def +=(elem: A) = that.add(elem)
    
    def +=(elem: => Option[A])(implicit proxyBuilder: EMFProxyBuilder[A]) {
	  that.add(proxyBuilder(elem))
    }
  }

  implicit class RichSigmaBoolean(that: Boolean) {
    def implies(b: ⇒ Boolean) = {
      !that || b
    }
  }
}

object EMFScalaSupport extends EMFScalaSupport
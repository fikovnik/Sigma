package fr.unice.i3s.sigma.support

import java.io.PrintStream
import scala.annotation.implicitNotFound
import scala.collection.GenTraversableOnce
import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
import scala.language.implicitConversions
import scala.reflect.ClassTag
import scala.reflect.classTag
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.util.EcoreUtil
import fr.unice.i3s.sigma.util.DelegatingEList
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EAnnotation
import fr.unice.i3s.sigma.internal.OverloadHack

trait EMFScalaSupport {

  implicit def eMapAsScalaMap[A, B](a: EMap[A, B]): scala.collection.mutable.Map[A, B] =
    scala.collection.JavaConversions.mapAsScalaMap(a.map())

  implicit def asScalaBuffer[A](that: EList[A]): Buffer[A] =
    scala.collection.JavaConversions.asScalaBuffer(that)
  implicit def asEList[T](that: Buffer[T]) = new DelegatingEList(that)
  implicit def asEList[T](that: Iterable[T]) = new DelegatingEList(that.toSeq)

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

  implicit class RichSigmaEModelElement(that: EModelElement) {
    def getAnnotationValue(name: String, detail: String): Option[String] = getAnnotation(name) flatMap { a => Option(a.getDetails.get(detail)) }
      
    def getAnnotation(name: String): Option[EAnnotation] = (that, that.getEAnnotations find (_.getSource == name)) match {
      case (_, Some(annotation)) => 
        Some(annotation)
      case (cls: EClass, None) => 
        cls.getESuperTypes map (_.getAnnotation(name)) collectFirst { case Some(x) => x }
      case _ => 
        None
    }
    
    def isAnnotatedAs(name: String) = that.getAnnotation(name).isDefined    
  }
  
  implicit class RichSigmaEClass(that: EClass) {
    def newInstance: EObject = that.getEPackage.getEFactoryInstance.create(that)
  }
  
  implicit class RichSigmaEObject[A <: EObject](that: A) extends OverloadHack {

    def sInit(fun: A ⇒ Any): A = {
      fun(that)
      that
    }

    def sInitLater(fun: A ⇒ Any): A = {
      that.adapter[PostponedInitizationAdapter[_]] match {
        case Some(_) ⇒ throw new IllegalStateException("Multiple postponed initialization is not supported. Object: " + that)
        case None ⇒ that.eAdapters += new PostponedInitizationAdapter(fun)
      }
      that
    }

    def sDump(out: PrintStream = System.out, indent: Int = 0) {
      out.println(" " * indent + that)
      for (e ← that.eContents) {
        e.sDump(out, indent + 2)
      }
    }

    def sValidate = Diagnostician.INSTANCE.validate(that)

    def sViolations(severity: Int = Diagnostic.ERROR) = {
      sValidate.flatten.filter(_.getSeverity() == severity)
    }

    /**
     * @returns true if object represented by this instance directly violates the given constrain
     */
    def sViolatesConstraint(name: String, severity: Int = Diagnostic.ERROR) = {
      sValidate.containsConstraint(name, Some(that), severity)
    }

    /**
     * @returns true if object represented by this instance or any of its children violates the given constrain
     */
    def sViolatesConstraintAny(name: String, severity: Int = Diagnostic.ERROR) = {
      sValidate.containsConstraint(name, None, severity)
    }

    def sIsValid = {
      sValidate.isOK
    }

    def sCopy = EcoreUtil.copy(that)

    def sContainer[T <: EObject: ClassTag]: Option[T] = that.eContainer match {
      case null => None
      case x: T => Some(x)
      case _ => None
    }
    
    def sAllContents[T <: EObject: ClassTag]: Seq[T] = {
      import collection.JavaConversions.asScalaIterator
      
      (that.eAllContents collect { case x: T ⇒ x }).toSeq
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

  implicit class RichSigmaEList[A <: EObject](that: EList[A]) {
    def +==[B <: A](elem: B): B = {
      that.add(elem)
      elem
    }

    def ++==[B <: A](elems: Seq[B]): Seq[B] = {
      that.addAll(elems)
      elems
    }

    def +=(elem: A) = that.add(elem)

    def +=(elem: ⇒ Option[A])(implicit proxyBuilder: EMFProxyBuilder[A]) {
      that.add(proxyBuilder(elem))
    }
  }

  implicit class RichScalaResource(that: Resource) {
    import collection.JavaConversions.asScalaIterator

    def contents[T <: EObject: ClassTag]: Seq[T] = (that.getAllContents collect {
      case x: T ⇒ x
    }).toSeq
  }

}

object EMFScalaSupport extends EMFScalaSupport
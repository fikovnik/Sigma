package fr.unice.i3s.sigma.scala

import scala.collection.JavaConversions._
import java.io.File
import java.util.Collections
import scala.collection.GenTraversableOnce
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList
import scala.collection.JavaConversions.mapAsScalaMap
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.Diagnostician
import org.eclipse.emf.ecore.util.EcoreUtil
import com.google.common.base.Charsets
import com.google.common.io.Files
import fr.unice.i3s.sigma.delegates.SigmaDelegateDomain.delegatingEList
import org.eclipse.emf.common.util.EMap
import org.eclipse.emf.ecore.xmi.XMIResource
import org.eclipse.emf.ecore.xmi.XMLResource
import java.io.FileWriter
import java.io.Closeable
import java.io.Writer
import scala.reflect.{ ClassTag, classTag }

/**
 * A utility package that extends some Scala types with OCL-like operations.
 */
package object utils {

  object io {
    def using[B](file: File)(f: Writer ⇒ B): B = using(new FileWriter(file))(f)

    def using[A <: Closeable, B](input: A)(f: A ⇒ B): B = {
      try { f(input) } finally { input.close() }
    }
  }

  // Loading and saving Resources

  final class ResourceLoadingException(msg: String, cause: Throwable) extends RuntimeException(msg, cause)

  def load[A <: EObject](fname: String, resolveAll: Boolean = true): (A, ResourceSet) = {
    val rs = new ResourceSetImpl()
    val r = rs.getResource(URI.createFileURI(new File(fname).getAbsolutePath), true)

    if (resolveAll) {
      EcoreUtil.resolveAll(rs)
    }

    (r.getContents().get(0).asInstanceOf[A], rs)
  }

  // TODO: to refactor

  def loadFromString[T <: EObject](content: String,
    extension: String,
    options: Map[_, _] = null): T = {

    val temp = File.createTempFile("emfutils", "." + extension)
    Files.write(content, temp, Charsets.UTF_8)

    try {
      loadFromFile(temp, options)
    } finally {
      if (temp != null) temp.delete()
    }
  }

  def loadFromFile[T <: EObject](file: File,
    options: Map[_, _] = null): T = {

    val uri = URI.createFileURI(file.getAbsolutePath())
    loadFromURI(uri, options)
  }

  def loadFromURI[T <: EObject](uri: URI,
    options: Map[_, _] = null): T = {

    loadResource(uri, options).getContents().get(0).asInstanceOf[T]
  }

  def loadResourceFromString(content: String,
    extension: String,
    options: Map[_, _] = null): Resource = {

    val temp = File.createTempFile("emfutils", "." + extension)
    Files.write(content, temp, Charsets.UTF_8)

    try {
      loadResourceFromFile(temp, options)
    } finally {
      if (temp != null) temp.delete()
    }
  }

  def loadResourceFromFile(file: File,
    options: Map[_, _] = null): Resource = {
    val uri = URI.createFileURI(file.getAbsolutePath())
    loadResource(uri, options)
  }

  def loadResource(uri: URI,
    options: Map[_, _] = null) = {
    val resourceSet = new ResourceSetImpl();
    Option(options) match {
      case Some(o) ⇒
        val loadOpts = resourceSet.getLoadOptions()
        for ((k, v) ← o)
          loadOpts.put(k.asInstanceOf[AnyRef], v.asInstanceOf[AnyRef])
      case None ⇒
    }

    resourceSet.getResource(uri, true)
  }

  def resolve(resource: Resource) = {
    EcoreUtil.resolveAll(resource)
    resource
  }

  def check(resource: Resource) = {
    val errors = resource.getErrors();

    if (errors == null || errors.isEmpty()) {
      resource;
    } else {

      val sb = new StringBuilder();
      for (d ← errors) {
        sb ++= (d.toString() + "\n");
      }

      throw new ResourceLoadingException("Error loading resource: " + resource + ":\n" + sb.toString(),
        null);
    }
  }

  def save(root: EObject, file: File) {
    val uri = URI.createFileURI(file.getAbsolutePath())

    save(root, uri);
  }

  def save(root: EObject, uri: URI) {
    val resourceSet = new ResourceSetImpl()
    val resource = resourceSet.createResource(uri)

    resource.getContents().add(root)

    // TODO: reogranize - should be a boolean param
    // TODO: should we have XMI dependency?
    resource.save(Map(
      XMLResource.OPTION_SCHEMA_LOCATION -> (true: java.lang.Boolean)))
  }

  // EMF Validation helpers
  class RichSigmaDiagnostic(a: Diagnostic) {
    private val SEVERITIES = Map(
      Diagnostic.OK -> "OK",
      Diagnostic.INFO -> "INFO",
      Diagnostic.WARNING -> "WARNING",
      Diagnostic.ERROR -> "ERROR",
      Diagnostic.CANCEL -> "CANCEL")

    def flatten: List[Diagnostic] = {
      a.getChildren toList match {
        case Nil ⇒ a :: Nil
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
  }

  implicit def richSigmaDiagnostic(a: Diagnostic): RichSigmaDiagnostic = new RichSigmaDiagnostic(a)

  class RichSigmaNotifier(n: Notifier) {
    def adapter[A: ClassTag] = {
      Option(EcoreUtil.getAdapter(n.eAdapters, classTag[A].runtimeClass).asInstanceOf[A])
    }
  }

  implicit def richSigmaNotifier(n: Notifier) = new RichSigmaNotifier(n)

  // TODO: rewrite the Diagnostics to be nomads
  class RichSigmaEObject[A <: EObject](obj: A) {
    def container[B <: EObject] = {
      obj.eContainer.asInstanceOf[B]
    }

    def containerOption[B <: EObject](implicit m: Manifest[B]) = {
      if (obj.eContainer != null
        && obj.eContainer.getClass.isAssignableFrom(m.erasure)) {
        Some(obj.eContainer.asInstanceOf[B])
      } else {
        None
      }
    }

    def validate = Diagnostician.INSTANCE.validate(obj)

    def violations(severity: Int = Diagnostic.ERROR) = {
      validate.flatten.filter(_.getSeverity() == severity)
    }

    /**
     * @returns true if object represented by this instance directly violates the given constrain
     */
    def violatesConstraint(name: String, severity: Int = Diagnostic.ERROR) = {
      validate.containsConstraint(name, Some(obj), severity)
    }

    /**
     * @returns true if object represented by this instance or any of its children violates the given constrain
     */
    def violatesConstraintAny(name: String, severity: Int = Diagnostic.ERROR) = {
      validate.containsConstraint(name, None, severity)
    }

    def isValid = {
      validate.getSeverity == Diagnostic.OK
    }

    def copy = EcoreUtil.copy(obj)
  }

  class RichSigmaAnyRef(a: AnyRef) {
    def instanceOf[A](implicit m: Manifest[A]) = {
      if (a != null && m.erasure.isAssignableFrom(a.getClass)) {
        Some(a.asInstanceOf[A])
      } else {
        None
      }
    }
  }

  /**
   * Includes some of the missing collection operations that are present in OCL
   */
  class RichSigmaList[A](a: List[A]) {
    def unique = {
      a.distinct.lengthCompare(a.length) == 0
    }

    def notEmpty = {
      !a.isEmpty
    }

    def includesAll[B](b: GenTraversableOnce[B]) = {
      b.forall(a.contains(_))
    }
  }

  class RichSigmaOption[A](a: Option[A]) {
    def getOrThrow(e: Throwable) = {
      a match {
        case Some(x) ⇒ x
        case None ⇒ throw e
      }
    }

    def getOrThrow(msg: String) = {
      a match {
        case Some(x) ⇒ x
        case None ⇒ throw new RuntimeException(msg)
      }
    }
  }

  class RichSigmaBoolean(a: Boolean) {
    def implies(b: ⇒ Boolean) = {
      !a || b
    }
  }

  class RichSigmaString(a: String) {
    def splitFirst(p: String) = a.indexOf(p) match {
      case -1 ⇒ (a, "")
      case i ⇒ (a.take(i), a.drop(i + 1))
    }
  }

  // rich sigma types

  implicit def richEObject[A <: EObject](obj: A) = new RichSigmaEObject(obj)
  implicit def richAnyRef(a: AnyRef) = new RichSigmaAnyRef(a)
  implicit def richList[A](a: List[A]) = new RichSigmaList(a)
  implicit def richOption[A](a: Option[A]) = new RichSigmaOption(a)
  implicit def richBoolean(a: Boolean) = new RichSigmaBoolean(a)
  implicit def richString(a: String) = new RichSigmaString(a)

  // conversion between EMF collections

  implicit def eListAsScalaImmutableList[A](a: EList[A]): List[A] =
    asScalaBuffer(a).toList

  implicit def scalaListAsEList[A](a: List[A]): EList[A] =
    delegatingEList(seqAsJavaList(a))

  implicit def eMapAsScalaMap[A, B](a: EMap[A, B]): scala.collection.mutable.Map[A, B] =
    mapAsScalaMap(a.map())

  object EMF {

    import org.eclipse.emf.ecore._

    implicit class ScalaEClass(that: EClass) {

    }

  }

}
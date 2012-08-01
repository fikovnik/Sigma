package fr.unice.i3s.utils.scala

import scala.collection.JavaConversions._
import org.eclipse.core.resources.IResource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import com.google.common.io.Files
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import java.io.ByteArrayOutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import java.io.File
import java.util.Collections
import com.google.common.base.Charsets
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.DelegatingEList
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.common.notify.Notifier
import scala.collection.GenTraversableOnce
import fr.unice.i3s.sigma.scala.emfutils.ResourceLoadingException
import fr.unice.i3s.sigma.core.SigmaDelegateDomain.delegatingEList

package object emfutils {

  class RichSigmaEObject[A <: EObject](obj: A) {
    def container[B <: EObject] = {
      obj.eContainer.asInstanceOf[B]
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
        case Some(x) => x
        case None => throw e
      }
    }

    def getOrThrow(msg: String) = {
      a match {
        case Some(x) => x
        case None => throw new RuntimeException(msg)
      }
    }
  }

  class RichSigmaBoolean(a: Boolean) {
    def implies(b: => Boolean) = {
      !a || b
    }
  }

  class RichSigmaString(a: String) {
    def splitFirst(p: String) = a.indexOf(p) match {
      case -1 => (a, "")
      case i => (a.take(i), a.drop(i + 1))
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

  // TODO: maps

  def load[A <: EObject](fname: String): (A, ResourceSet) = {
    val rs = new ResourceSetImpl()
    val r = rs.getResource(URI.createFileURI(new File(fname).getAbsolutePath), true)
    EcoreUtil.resolveAll(rs)

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
      case Some(o) =>
        val loadOpts = resourceSet.getLoadOptions()
        for ((k, v) <- o)
          loadOpts.put(k.asInstanceOf[AnyRef], v.asInstanceOf[AnyRef])
      case None =>
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
      for (d <- errors) {
        sb ++= (d.toString() + "\n");
      }

      throw new ResourceLoadingException("Error loading resource: " + resource + ":\n" + sb.toString(),
        null);
    }
  }

  def save(root: EObject, file: IResource) {
    val uri = URI.createPlatformResourceURI(file.getFullPath().toString(),
      true);

    save(root, uri);
  }

  def save(root: EObject, file: File) {
    val uri = URI.createFileURI(file.getAbsolutePath())

    save(root, uri);
  }

  def save(root: EObject, uri: URI) {
    val resourceSet = new ResourceSetImpl()
    val resource = resourceSet.createResource(uri)

    resource.getContents().add(root)
    resource.save(Collections.EMPTY_MAP)
  }

  def toString(root: EObject) {
    val baos = new ByteArrayOutputStream()

    new ResourceSetImpl().createResource(
      URI.createFileURI(File.createTempFile("EMFUtil", ".model")
        .getAbsolutePath())).save(baos, Collections.EMPTY_MAP)

    new String(baos.toByteArray())
  }

  implicit def eListAsScalaImmutableList[A](a: EList[A]): List[A] =
    asScalaBuffer(a).toList

  implicit def scalaListAsEList[A](a: List[A]): EList[A] =
    new DelegatingEList[A] {
      override def delegateList: java.util.List[A] = seqAsJavaList(a)
    }
}
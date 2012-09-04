package fr.unice.i3s.sigma.scala

import scala.collection.GenTraversableOnce
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.seqAsJavaList

import scala.collection.JavaConversions.mapAsScalaMap
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

import fr.unice.i3s.sigma.core.SigmaDelegateDomain.delegatingEList

/**
 * A utility package that extends some Scala types with OCL-like operations.
 */
package object utils {

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

  implicit def eMapAsScalaMap[A,B](a: EMap[A,B]): scala.collection.mutable.Map[A,B] =
    mapAsScalaMap(a.map())

}
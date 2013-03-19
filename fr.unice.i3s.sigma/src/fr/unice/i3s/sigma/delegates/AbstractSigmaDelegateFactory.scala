package fr.unice.i3s.sigma.delegates

import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import java.lang.reflect.Method
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EModelElement
import java.text.ParseException
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import java.lang.reflect.Modifier

abstract class AbstractSigmaDelegateFactory[T] extends EcorePackageScalaSupport {

  def domain = SigmaDelegateDomain.instance

  protected def delegateOverride(element: EModelElement, key: String = domain.delegateAnnotationKey) =
    Option(EcoreUtil.getAnnotation(element, domain.getURI, key))

  protected def getPackageDelegate(pkg: EPackage): String = {
    def compute(pkg: EPackage, cumm: String): String = delegateOverride(pkg) match {
      case Some(delOvr) ⇒ delOvr + "." + cumm
      case None ⇒ Option(pkg.eSuperPackage) match {
        case Some(sup) ⇒ compute(sup, pkg.name + "." + cumm)
        case None ⇒ cumm
      }
    }

    compute(pkg, "")
  }

  protected def lookupClassDelegate(clazz: EClass) = {
    delegateOverride(clazz) match {
      case Some(delOvr) ⇒ delOvr
      case None ⇒ {
        getPackageDelegate(clazz.ePackage) + "." + domain.classDelegateName(clazz)
      }
    }
  }

  protected def lookupMethod(element: T, containingClass: EClass, delegateOverride: Option[String]): (String, String) = {
    delegateOverride match {
      case Some(delOver) ⇒ {
        val msep = delOver.lastIndexOf('.')
        if (msep == -1) {
          (lookupClassDelegate(containingClass), delOver)
        } else {
          val className = delOver.take(msep)
          val methodName = delOver.drop(msep + 1)

          if (className.isEmpty)
            throw new ParseException(
              "Method name part of the delegate specification must not be empty", 0)

          if (methodName.isEmpty)
            throw new ParseException(
              "Class name part of the delegate specification must not be empty when including the dot operator",
              0)

          (className, methodName)
        }

      }
      case None ⇒ {
        // try to find delegate override in the classifier
        (lookupClassDelegate(containingClass), delegateMethodName(element))
      }
    }
  }

  protected def delegateMethodName(element: T): String
  protected def checkMethodSignature(element: T, method: Method): Boolean
  protected def methodSignature(element: T): String

  protected def lookupDelegate(element: T, containingClass: EClass, delegateOverride: Option[String]): Either[String, Method] = {
    val (className, methodName) = lookupMethod(element, containingClass, delegateOverride)

    domain.loadDelegateClass(className) match {
      case None ⇒ Left("Unable to load class: " + className)
      case Some(clazz) ⇒ clazz.getMethods find { m ⇒
        // must have correct name
        m.getName == delegateMethodName(element) &&
          // must be static
          Modifier.isStatic(m.getModifiers) &&
          // must be public
          Modifier.isPublic(m.getModifiers) &&
          // must check
          checkMethodSignature(element, m)
      } match {
        case None ⇒ Left(s"Unable to find expected method: `${methodSignature(element)}` in `$className`")
        case Some(m) ⇒ Right(m)
      }
    }
  }

}
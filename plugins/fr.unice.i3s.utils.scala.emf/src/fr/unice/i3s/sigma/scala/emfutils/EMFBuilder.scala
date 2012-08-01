package fr.unice.i3s.sigma.scala.emfutils

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EDataType
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.ecore.util.EContentAdapter
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource

import fr.unice.i3s.sigma.support.scala.utils._

final class PostponeContentInitializerAdapter extends EContentAdapter {
  val codes = {
    import Notification._

    ADD :: ADD_MANY :: SET :: Nil
  }

  override def notifyChanged(notification: Notification) {
    super.notifyChanged(notification)

    if (codes contains notification.getEventType) {
      notification.getNotifier match {
        case resource: Resource =>
          initializeObject(notification.getNewValue)
        case _ => Option(notification.getFeature).collect {
          case r: EReference if r.isContainment => r
        } match {
          case Some(ref) =>
            initializeObject(notification.getNewValue)
          case None =>
        }
      }
    }
  }

  private def initializeObject(obj: Object) {
    obj match {
      case eobj: EObject => eobj.adapter[PostponedInitizationAdapter[_]] match {
        case Some(adapter) => adapter.initialize()
        case None =>
      }
      case _ =>
    }
  }
}

final class PostponedInitizationAdapter[T <: EObject](val initializer: T => Unit) extends AdapterImpl {

  def initialize() {
    initializer(getTarget().asInstanceOf[T])
    getTarget().eAdapters.remove(this)
  }

  override def isAdapterForType(`type`: Object): Boolean = {
    `type` == classOf[PostponedInitizationAdapter[_]]
  }

}

final class EMFBuilder(val pkg: EPackage) {

  class PostponedInializationEObject[T <: EObject](val obj: T) {

    def initializeLater(initializer: T => Unit): T = {
      obj.adapter[PostponedInitizationAdapter[_]] match {
        case None => obj.eAdapters += new PostponedInitizationAdapter(initializer)
        case Some(o) => throw new IllegalStateException("Multiple initialization is not supported. Object: " + obj)
      }
      obj
    }
  }

  implicit def postponedInializationEObject[T <: EObject](obj: T) =
    new PostponedInializationEObject(obj)

  val factory = pkg.getEFactoryInstance

  def create[T <: EObject](initializer: T => Unit = { _: T => })(implicit m: Manifest[T]): T = {
    val eclazz = Option(pkg.getEClassifier(m.erasure.getSimpleName))

    val instance = (eclazz match {
      case Some(o) => o match {
        case c: EClass => factory.create(c)
        case _ => throw new RuntimeException("Only EClass types are supported")
      }
      case None => throw new RuntimeException("Unable to find EClass %s in package %s" format (m.erasure.getSimpleName, pkg.getNsURI))
    }).asInstanceOf[T]

    initializer(instance)

    instance
  }

}
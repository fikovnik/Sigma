package fr.unice.i3s.sigma.scala.utils

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
import org.eclipse.emf.common.util.EList
import fr.unice.i3s.sigma.scala.utils._
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.impl.EObjectImpl
import scala.reflect.runtime.universe.{ typeOf, TypeTag }

import reflect.{ ClassTag, classTag }

final class PostponeContentInitializerAdapter extends EContentAdapter {
  val codes = {
    import Notification._

    ADD :: ADD_MANY :: SET :: Nil
  }

  override def notifyChanged(notification: Notification) {
    super.notifyChanged(notification)

    if (codes contains notification.getEventType) {
      notification.getNotifier match {
        case resource: Resource ⇒
          initializeObject(notification.getNewValue)
        case _ ⇒ Option(notification.getFeature).collect {
          case r: EReference if r.isContainment ⇒ r
        } match {
          case Some(ref) ⇒
            initializeObject(notification.getNewValue)
          case None ⇒
        }
      }
    }
  }

  private def initializeObject(obj: Object) {
    obj match {
      case eobj: EObject ⇒ eobj.adapter[PostponedInitizationAdapter[_]] match {
        case Some(adapter) ⇒ adapter.initialize()
        case None ⇒
      }
      case _ ⇒
    }
  }
}

final class PostponedInitizationAdapter[T <: EObject](val initializer: T ⇒ Unit) extends AdapterImpl {
  def initialize() {
    initializer(getTarget().asInstanceOf[T])
    getTarget().eAdapters.remove(this)
  }

  override def isAdapterForType(`type`: Object): Boolean = {
    `type` == classOf[PostponedInitizationAdapter[_]]
  }

}

trait EMFDynamicContext {
  protected val context = new TypedDynamicVariable[EObject](null)
  protected val referenceContext = new TypedDynamicVariable[EList[_ <: EObject]](null)

  def self[T <: EObject: TypeTag]: T = Option(context.value) match {
    case Some(c) ⇒ c
    case None ⇒ throw new IllegalStateException("The current container is empty.")
  }

  def referenceList[T <: EObject: TypeTag]: EList[T] = Option(referenceContext.value[EList[T]]) match {
    case Some(c) ⇒ c
    case None ⇒ throw new IllegalStateException("The current container list is empty.")
  }

  def isContainerTypeOf[T <: EObject: TypeTag] = context.valueType =:= typeOf[T]

  def isContainerListSet = referenceContext.value[EList[_ <: EObject]] != null
}

class EMFBuilder[T <: EPackage](val pkg: T) extends EMFDynamicContext {

  implicit class InitializableEObject[T <: EObject: TypeTag](val obj: T) {
    def apply(fun: ⇒ Unit): T = {
      context.withValue(obj) { fun; obj }
    }

    def init(fun: T ⇒ Unit): T = {
      context.withValue(obj) { fun(obj); obj }
    }

    // FIXME: this is likely broken
    def initLater(initializer: T ⇒ Unit): T = {
      context.withValue(obj) {
        obj.adapter[PostponedInitizationAdapter[_]] match {
          case None ⇒
            obj.eAdapters += new PostponedInitizationAdapter(initializer)
          case Some(o) ⇒
            throw new IllegalStateException("Multiple initialization is not supported. Object: " + obj)
        }
        obj
      }
    }
  }

  protected val factory = pkg.getEFactoryInstance

  def create[T <: EObject: ClassTag]: T = {
    val clazz = classTag[T].runtimeClass.getSimpleName
    val classifier = pkg.getEClassifier(clazz)

    require(classifier != null,
      s"Unable to find EClass $clazz in package ${pkg.getNsURI}")

    val instance = classifier match {
      case c: EClass ⇒ factory.create(c)
      case _ ⇒ throw new IllegalArgumentException(
        s"EClassifier $clazz is not an EClass")
    }

    // this is necessary as we will never be able to do static type safety
    // as along as EMF will not provide generic version of EFactory.create()
    instance.asInstanceOf[T]
  }

  protected def setNotDefault[T](setter: (T) ⇒ Unit, value: T, default: T) {
    if (value != null) setter(value)
  }
}
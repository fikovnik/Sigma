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
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.common.util.URI
import scala.collection.mutable.MultiMap
import scala.collection.mutable.Set
import scala.collection.mutable.Buffer
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import org.eclipse.emf.ecore.EStructuralFeature

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
  protected val containerContext = new TypedDynamicVariable[EList[_ <: EObject]](null)

  def self[T <: EObject: TypeTag]: Option[T] = Option(context.value)
  def container[T <: EObject: TypeTag]: Option[EList[T]] = {
    val x = containerContext.valueType
    if (containerContext.valueType =:= typeOf[EList[T]])
      Option(containerContext.value[EList[T]])
    else
      None
  }

  //  def isContainerTypeOf[T <: EObject: TypeTag] = 
}

class EMFBuilder[T <: EPackage](val pkg: T) extends EMFDynamicContext {

  implicit class InitializableEObject[T <: EObject: TypeTag](val obj: T) {
    def apply(fun: ⇒ Unit): T = {
      context.withValue(obj) { fun }
      obj
    }

    def init(fun: T ⇒ Unit): T = {
      context.withValue(obj) { fun(obj) }
      obj
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

  implicit class InitializableEList[T <: EObject: TypeTag](val that: EList[T]) {
    def apply(fun: ⇒ Unit): EList[T] = {
      containerContext.withValue(that) { fun }
      that
    }
  }

  protected case class InternalProxy(val proxy: EObject, val getter: Unit ⇒ Option[EObject], val setter: EObject ⇒ Any)

  protected val proxies = Buffer[InternalProxy]()

  protected class InternalProxyAdapter(val getter: Unit ⇒ Option[EObject]) extends AdapterImpl {
    override def isAdapterForType(`type`: Object): Boolean = `type` == classOf[InternalProxyAdapter]
  }
  
  protected object ResolveProxyAdapter extends AdapterImpl {
      override def notifyChanged(msg: Notification) {
        import Notification._

        msg.getEventType match {
          case ADD | ADD_MANY | SET ⇒

            val owner = msg.getNotifier.asInstanceOf[EObject]
            val feature = msg.getFeature.asInstanceOf[EStructuralFeature]

            msg.getNewValue match {
              case obj: EObject ⇒
                obj.adapter[InternalProxyAdapter] match {
                  case Some(adapter) ⇒
                    val setter = { value: EObject ⇒
                      if (feature.isMany())
                        owner.eGet(feature).asInstanceOf[EList[EObject]] += value
                      else
                        owner.eSet(feature, value)
                    }
                  
                    val proxy = InternalProxy(obj, adapter.getter, setter)
                    proxies += proxy
                  case None ⇒
                    val clazz = obj.getClass

                    for (proxy ← proxies.filter(_.proxy.getClass == clazz)) {
                      proxy.getter() match {
                        case Some(r) ⇒ {
                          proxies -= proxy
                          proxy.setter(r)
                        }
                        case None ⇒
                      }
                    }
                }
              case _ ⇒
            }
          case _ ⇒
        }
      }
    }

  def ref[T <: EObject: ClassTag](expr: ⇒ Option[T]): T = {
    val getter = () => expr
    
    getter() match {
      case Some(e) => e
      case None =>
        // create a proxy
        val proxy = create[T]
        proxy.asInstanceOf[InternalEObject].eSetProxyURI(URI.createURI(s"EMFBuilder internal proxy"))
        proxy.eAdapters += new InternalProxyAdapter((Unit ⇒ expr))
        proxy
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

    // attach a listener to resolve proxies
    instance.eAdapters += ResolveProxyAdapter

    // this is necessary as we will never be able to do static type safety
    // as along as EMF will not provide generic version of EFactory.create()
    instance.asInstanceOf[T]
  }

  protected def setNotDefault[T](setter: (T) ⇒ Unit, value: T, default: T) {
    if (value != default) setter(value)
  }
}
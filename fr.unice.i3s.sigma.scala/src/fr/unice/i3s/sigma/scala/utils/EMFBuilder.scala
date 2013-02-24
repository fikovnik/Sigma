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
  }

  implicit class InitializableEList[T <: EObject: TypeTag](val that: EList[T]) {
    def apply(fun: ⇒ Unit): EList[T] = {
      containerContext.withValue(that) { fun }
      that
    }
  }

  protected case class InternalProxy(val proxy: EObject, val getter: Unit ⇒ Option[EObject], val setter: EObject ⇒ Any)

  protected val proxies = Buffer[InternalProxy]()

  /**
   * This is a holder of the recorded getter in the proxy.
   */
  protected class InternalProxyAdapter(val getter: Unit ⇒ Option[EObject]) extends AdapterImpl {
    override def isAdapterForType(`type`: Object): Boolean = `type` == classOf[InternalProxyAdapter]
  }

  /**
   * Responsible for recording and resolving proxies.
   */
  protected object ResolveProxyAdapter extends AdapterImpl {
    override def notifyChanged(msg: Notification) {
      import Notification._

      msg.getEventType match {
        case ADD | ADD_MANY | SET ⇒

          val owner = msg.getNotifier.asInstanceOf[EObject]
          val feature = msg.getFeature.asInstanceOf[EStructuralFeature]

          msg.getNewValue match {
            case obj: EObject ⇒
              // check if the newly set/added value is a proxy
              obj.adapter[InternalProxyAdapter] match {
                case Some(adapter) ⇒
                  // it is a proxy so create a setter (we are setting a feature `feature` in `owner`)
                  val setter = { value: EObject ⇒
                    if (feature.isMany()) {
                      val list = owner.eGet(feature).asInstanceOf[EList[EObject]]
                      val idx = list indexOf obj
                      list update(idx, value)
                    } else
                      owner.eSet(feature, value)
                  }

                  // store the proxy
                  proxies += InternalProxy(obj, adapter.getter, setter)
                case None ⇒
                  // it is not a proxy so by adding this new value into the tree some proxies might get resolved
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
    val getter = () ⇒ expr

    getter() match {
      case Some(e) ⇒ e
      case None ⇒
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
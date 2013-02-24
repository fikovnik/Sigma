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

  implicit class ReferenceableEList[T <: ENamedElement: ClassTag](val that: EList[T]) {
    def byName(name: String): T = {
      that.find(_.getName == name) match {
        case Some(e) ⇒ e
        case None ⇒
          val x = create[T]
          // set an URI that will contain the name
          x.asInstanceOf[InternalEObject].eSetProxyURI(URI.createURI(s"name='$name'"))
          // add a notification listener
          x.eAdapters += new AdapterImpl {
            override def notifyChanged(msg: Notification) {
              println(s"From proxy $name: $msg")
            }
          }
          x
        //throw new NoSuchElementException(s"`$name` is not in $that")
      }
    }
  }

  class EObjectProxyHandler[T <: EObject](var target: T, expr: Unit ⇒ Option[T]) extends InvocationHandler {
    def invoke(proxy: Object, method: Method, args: Array[Object]): Object = {
      if (method.getName == "eIsProxy") {
        expr() match {
          case Some(o) ⇒
            target = o; false: java.lang.Boolean
          case None ⇒ true: java.lang.Boolean
        }
      } else {
        //        println(target + ": " + method.getName + ": " + args)
        method.invoke(target, args: _*)
      }
    }
  }

  //  case class EObjectProxy[T <: EObject](val proxy: T, val expr: Unit ⇒ Option[T])
  //
  //  protected val proxies = Buffer[EObjectProxy[_ <: EObject]]()

  def ref[T <: EObject: ClassTag](expr: ⇒ Option[T]): T = {
    val proxy = create[T]
    proxy.asInstanceOf[InternalEObject].eSetProxyURI(URI.createURI(s"internal emf builder proxy"))

    //    proxies += EObjectProxy(proxy, (Unit ⇒ expr))
    proxy
    val clazz = classTag[T].runtimeClass
    Proxy.newProxyInstance(clazz.getClassLoader, Array(clazz), new EObjectProxyHandler(proxy, (Unit ⇒ expr))).asInstanceOf[T]
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

    //    // attach a listener to resolve proxies
    //    instance.eAdapters += new AdapterImpl {
    //      override def notifyChanged(msg: Notification) {
    //        import Notification._
    //        msg.getEventType match {
    //          case ADD | ADD_MANY =>
    //            val objType = msg.getNewValue.getClass
    //            proxies.filter(_.proxy.getClass == objType) 
    //          case _ =>
    //        }
    //      }
    //    }

    // this is necessary as we will never be able to do static type safety
    // as along as EMF will not provide generic version of EFactory.create()
    instance.asInstanceOf[T]
  }

  protected def setNotDefault[T](setter: (T) ⇒ Unit, value: T, default: T) {
    if (value != null) setter(value)
  }
}
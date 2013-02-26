package fr.unice.i3s.sigma.scala.construct

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.common.util.EList
import reflect.{ ClassTag, classTag }
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.common.util.URI
import scala.collection.mutable.Buffer
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.common.notify.Notification.ADD
import org.eclipse.emf.common.notify.Notification.ADD_MANY
import org.eclipse.emf.common.notify.Notification.SET
import scala.reflect.runtime.universe.{ typeOf, TypeTag }
import fr.unice.i3s.sigma.scala.common.EMFScalaSupport
import fr.unice.i3s.sigma.scala.core.internal.DynamicContainer

abstract class AbstractEMFBuilder {
  def create[T <: EObject: TypeTag]: T
}

abstract trait AutoContainment extends AbstractEMFBuilder {

  implicit class InitializableEList[T <: EObject: TypeTag](val that: EList[T]) {
    def apply(fun: ⇒ Unit): EList[T] = {
      container.withValue(that) { fun }
      that
    }
  }

  private[this] val container = new DynamicContainer

  abstract override def create[T <: EObject: TypeTag]: T = {
    val instance = super.create[T]

    // set the containment if supported
    if (container.isCompatible[T]) {
      container += instance
    }

    instance
  }
}

class EMFBuilder[P <: EPackage](val pkg: P) extends AbstractEMFBuilder {

  implicit class InitializableEObject[T <: EObject: TypeTag](val obj: T) {
    def init(fun: T ⇒ Any): T = {
      fun(obj)
      obj
    }
  }

  protected case class InternalProxy(val proxy: EObject, val getter: Unit ⇒ Option[EObject], val setter: EObject ⇒ Any)

  /**
   * This is a holder of the recorded getter in the proxy.
   */
  protected class InternalProxyAdapter(val getter: Unit ⇒ Option[EObject]) extends AdapterImpl {
    override def isAdapterForType(`type`: Object): Boolean = `type` == classOf[EMFBuilder.this.InternalProxyAdapter]
  }

  /**
   * Responsible for recording and resolving proxies.
   */
  protected object ResolveProxyAdapter extends AdapterImpl with EMFScalaSupport {
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
                case Some(adapter) ⇒ {
                  // it is a proxy so create a setter (we are setting a feature `feature` in `owner`)
                  val setter = { value: EObject ⇒
                    if (feature.isMany()) {
                      // we need to replace the proxy in the list
                      val list = owner.eGet(feature).asInstanceOf[EList[EObject]]
                      val idx = list indexOf obj
                      list update (idx, value)
                    } else
                      owner.eSet(feature, value)
                  }

                  // store the proxy
                  proxies += InternalProxy(obj, adapter.getter, setter)
                }

                case None ⇒ {
                  // it is not a proxy so by adding this new value into the tree some proxies might get resolved
                  val clazz = obj.getClass

                  for (proxy ← proxies.filter(_.proxy.getClass == clazz)) {
                    proxy.getter() match {
                      case Some(value) ⇒ {
                        // remove the proxy first otherwise it will be infinite recursion
                        proxies -= proxy
                        // set it
                        proxy.setter(value)
                      }
                      case None ⇒
                    }
                  }
                }
              }
            case _ ⇒
          }
        case _ ⇒
      }
    }
  }

  protected val proxies = Buffer[InternalProxy]()
  protected val factory = pkg.getEFactoryInstance

  def ref[T <: EObject: TypeTag](expr: ⇒ Option[T]): T = {
    val getter = () ⇒ expr

    getter() match {
      case Some(e) ⇒ e
      case None ⇒
        // create a proxy
        val proxy = createInternal[T]
        proxy.asInstanceOf[InternalEObject].eSetProxyURI(URI.createURI(s"EMFBuilder internal proxy"))
        proxy.eAdapters += new InternalProxyAdapter((Unit ⇒ expr))
        proxy
    }
  }

  def build[T <: EObject: TypeTag](configs: (T ⇒ Any)*): T = {
    configure(create[T], configs: _*)
  }

  override def create[T <: EObject: TypeTag]: T = createInternal[T]

  protected def createInternal[T <: EObject: TypeTag]: T = {
    val m = runtimeMirror(getClass.getClassLoader)
    val clazz = m.runtimeClass(typeOf[T].typeSymbol.asClass)
    val classifier = pkg.getEClassifier(clazz.getSimpleName)

    require(classifier != null,
      s"Unable to find EClass $clazz in package ${pkg.getNsURI}")

    val instance = classifier match {
      case c: EClass ⇒
        // this is necessary as we will never be able to do static type safety
        // as along as EMF will not provide generic version of EFactory.create()
        factory.create(c).asInstanceOf[T]
      case _ ⇒ throw new IllegalArgumentException(
        s"EClassifier $clazz is not an EClass")
    }

    // attach a listener to resolve proxies
    instance.eAdapters += ResolveProxyAdapter

    instance

  }

  protected def setNotDefault[T](setter: (T) ⇒ Unit, value: T, default: T) {
    if (value != default) setter(value)
  }

  protected def setNotEmpty[T](target: EList[T], source: EList[T]) {
    if (source != null && !source.isEmpty) target ++= source
  }

  protected def configure[T](target: T, configs: (T ⇒ Any)*): T = {
    configs.foreach(cfg ⇒ cfg(target))
    target
  }
}
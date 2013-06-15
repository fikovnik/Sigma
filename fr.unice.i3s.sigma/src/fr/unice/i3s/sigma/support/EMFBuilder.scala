package fr.unice.i3s.sigma.support

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
import scala.collection.mutable.SynchronizedBuffer
import scala.collection.mutable.ArrayBuffer

object EMFBuilder {

  // TODO: move to EMFScalaSupport
  implicit class InitializableEObject[T <: EObject: ClassTag](val obj: T) {
    def init(fun: T ⇒ Any): T = {
      fun(obj)
      obj
    }
  }
  
}

class EMFBuilder[P <: EPackage](val pkg: P) {

  private case class InternalProxy(val proxy: EObject, val getter: Unit ⇒ Option[EObject], val setter: EObject ⇒ Any)

  /**
   * This is a holder of the recorded getter in the proxy.
   */
  private case class InternalProxyAdapter(val getter: Unit ⇒ Option[EObject]) extends AdapterImpl {
    override def isAdapterForType(`type`: Object): Boolean = `type` == classOf[EMFBuilder.this.InternalProxyAdapter]
  }

  /**
   * Responsible for recording and resolving proxies.
   */
  private object ResolveProxyAdapter extends AdapterImpl with EMFScalaSupport {
    val proxies = new ArrayBuffer[InternalProxy] with SynchronizedBuffer[InternalProxy]

    override def notifyChanged(msg: Notification) {
      import Notification._

      // TODO: refactor into smaller pieces
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

  val factory = pkg.getEFactoryInstance

  def ref[T <: EObject: ClassTag](expr: ⇒ Option[T]): T = {
    val getter = () ⇒ expr

    getter() match {
      case Some(e) ⇒ e
      case None ⇒
        // create a proxy
        val proxy = create[T]
        proxy.asInstanceOf[InternalEObject].eSetProxyURI(URI.createURI(s"EMFBuilder internal proxy"))
        proxy.eAdapters += InternalProxyAdapter((Unit ⇒ expr))
        proxy
    }
  }

  def build[T <: EObject: ClassTag](configs: (T ⇒ Any)*): T = {
    configure(create[T], configs: _*)
  }

  def create[T <: EObject: ClassTag]: T = {
    val clazz = classTag[T].runtimeClass
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
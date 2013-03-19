package fr.unice.i3s.sigma

import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext

object Activator {
  var context: Option[BundleContext] = None
}

class Activator extends BundleActivator {

  override def start(context: BundleContext) {
    Activator.context = Some(context)
  }

  override def stop(context: BundleContext) {
    Activator.context = None
  }

}
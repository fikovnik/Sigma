package fr.unice.i3s.sigma

import org.osgi.framework.BundleContext
import org.eclipse.core.runtime.Plugin

object SigmaPlugin {
  val PLUGIN_ID = "fr.unice.i3s.sigma" //$NON-NLS-1$

  var plugin: Option[SigmaPlugin] = None
}

class SigmaPlugin extends Plugin {

  import SigmaPlugin._

  override def start(context: BundleContext) {
    super.start(context)
    plugin = Some(this)
  }

  override def stop(context: BundleContext) {
    plugin = None
    super.stop(context)
  }

}
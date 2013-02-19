package fr.unice.i3s.sigma.scala.core

import org.osgi.framework.BundleContext
import org.eclipse.core.runtime.Plugin
import org.eclipse.core.runtime.preferences.ConfigurationScope

object SigmaScalaPlugin {
  val PLUGIN_ID = "fr.unice.i3s.sigma.core" //$NON-NLS-1$

  var plugin: Option[SigmaScalaPlugin] = None
}

final class SigmaScalaPlugin extends Plugin {

  import SigmaScalaPlugin._

  override def start(context: BundleContext) {
    super.start(context)
    plugin = Some(this)
  }

  override def stop(context: BundleContext) {
    plugin = None
    super.stop(context)
  }

}
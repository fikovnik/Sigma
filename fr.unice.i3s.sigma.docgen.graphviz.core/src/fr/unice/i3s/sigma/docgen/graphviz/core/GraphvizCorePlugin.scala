package fr.unice.i3s.sigma.docgen.graphviz.core

import org.osgi.framework.BundleContext
import org.eclipse.core.runtime.Plugin
import org.eclipse.core.runtime.preferences.ConfigurationScope

object GraphvizCorePlugin {
  val PLUGIN_ID = "fr.unice.i3s.sigma.docgen.graphwiz.core" //$NON-NLS-1$

  // SETTINGS
  val DOT_PATH = "dotPath"
  val DOT_PATH_DEFAULT = "/usr/local/bin/dot"

  var plugin: Option[GraphvizCorePlugin] = None
}

final class GraphvizCorePlugin extends Plugin {

  import GraphvizCorePlugin._

  def gvDot: GVDot = {
    val prefs = ConfigurationScope.INSTANCE.getNode(PLUGIN_ID)
    val dotPath = prefs.get(DOT_PATH, DOT_PATH_DEFAULT)

    new GVDot(dotPath)
  }

  override def start(context: BundleContext) {
    super.start(context)
    plugin = Some(this)
    //    graphwizService = Some()
  }

  override def stop(context: BundleContext) {
    plugin = None
    super.stop(context)
  }

}
package fr.unice.i3s.sigma.docgen.graphviz.core

import org.eclipse.core.runtime.preferences.ConfigurationScope
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot

object GraphvizCorePlugin {
  val PLUGIN_ID = "fr.unice.i3s.sigma.docgen.graphwiz.core" //$NON-NLS-1$
  val GRAPHVIZ_PREFERENCE_PAGE_ID = "fr.unice.i3s.sigma.docgen.graphwiz.ui.preferences.DefaultPreferences"

  // SETTINGS
  val DOT_PATH = "dotPath"
  val DOT_PATH_DEFAULT = "/usr/local/bin/dot"

  var plugin: GraphvizCorePlugin = _
}

final class GraphvizCorePlugin extends AbstractUIPlugin {

  import GraphvizCorePlugin._

  def gvDot: GVDot = {
    val prefs = ConfigurationScope.INSTANCE.getNode(PLUGIN_ID)
    val dotPath = prefs.get(DOT_PATH, DOT_PATH_DEFAULT)

    new GVDot(dotPath)
  }

  override def start(context: BundleContext) {
    super.start(context)
    plugin = this
    //    graphwizService = Some()
  }

  override def stop(context: BundleContext) {
    plugin = null
    super.stop(context)
  }

}
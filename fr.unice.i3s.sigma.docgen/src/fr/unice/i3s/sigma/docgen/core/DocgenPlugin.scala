package fr.unice.i3s.sigma.docgen.core

import org.eclipse.core.runtime.preferences.ConfigurationScope
import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot
import org.eclipse.jface.dialogs.MessageDialogWithToggle

object DocgenPlugin {
  val PLUGIN_ID = "fr.unice.i3s.sigma.docgen" //$NON-NLS-1$
  val GRAPHVIZ_PREFERENCE_PAGE_ID = "fr.unice.i3s.sigma.docgen.graphviz.ui.preferences.DefaultPreferences"

  // SETTINGS
  val PREF_DOT_PATH = "dotPath"
  val PREF_DOT_PATH_DEFAULT = "/usr/local/bin/dot"
  val PREF_AUTO_REVEAL_RESULT_TOGGLE = "revealExportResult"
  val PREF_AUTO_REVEAL_RESULT_TOGGLE_DEFAULT = MessageDialogWithToggle.PROMPT

  var plugin: DocgenPlugin = _
}

final class DocgenPlugin extends AbstractUIPlugin {

  import DocgenPlugin._

  def gvDot: GVDot = {
    val prefs = ConfigurationScope.INSTANCE.getNode(PLUGIN_ID)

    val dotPath = prefs.get(PREF_DOT_PATH, PREF_DOT_PATH_DEFAULT)

    new GVDot(dotPath)
  }

  override def start(context: BundleContext) {
    super.start(context)
    plugin = DocgenPlugin.this
  }

  override def stop(context: BundleContext) {
    plugin = null
    super.stop(context)
  }

}
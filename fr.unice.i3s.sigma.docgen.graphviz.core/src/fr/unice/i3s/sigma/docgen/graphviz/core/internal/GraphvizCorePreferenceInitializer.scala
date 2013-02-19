package fr.unice.i3s.sigma.docgen.graphviz.core.internal

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import org.eclipse.core.runtime.preferences.DefaultScope
import fr.unice.i3s.sigma.docgen.graphviz.core.GraphvizCorePlugin._

class GraphvizCorePreferenceInitializer extends AbstractPreferenceInitializer {

  override def initializeDefaultPreferences {
    val prefs = DefaultScope.INSTANCE.getNode(PLUGIN_ID)

    prefs.put(DOT_PATH, DOT_PATH_DEFAULT);
  }

}
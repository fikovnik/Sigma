package fr.unice.i3s.sigma.docgen.core.internal

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer
import org.eclipse.core.runtime.preferences.DefaultScope
import fr.unice.i3s.sigma.docgen.core.DocgenPlugin

class DocgenPreferenceInitializer extends AbstractPreferenceInitializer {

  import DocgenPlugin._

  override def initializeDefaultPreferences {
    val prefs = DefaultScope.INSTANCE.getNode(PLUGIN_ID)

    prefs.put(PREF_DOT_PATH, PREF_DOT_PATH_DEFAULT);
    prefs.put(PREF_AUTO_REVEAL_RESULT_TOGGLE, PREF_AUTO_REVEAL_RESULT_TOGGLE_DEFAULT)
  }

}
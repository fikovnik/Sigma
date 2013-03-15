package fr.unice.i3s.sigma.docgen.ui.internal.preferences

import org.eclipse.jface.dialogs.MessageDialogWithToggle
import org.eclipse.jface.preference.FieldEditorPreferencePage
import org.eclipse.jface.preference.RadioGroupFieldEditor
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage

import fr.unice.i3s.sigma.docgen.core.DocgenPlugin

class DefaultPreferencePage extends FieldEditorPreferencePage
  with IWorkbenchPreferencePage {

  setPreferenceStore(DocgenPlugin.plugin.getPreferenceStore);
  setDescription("Sigma Docgen Configuration");

  override def createFieldEditors {

    addField(new RadioGroupFieldEditor(
      DocgenPlugin.PREF_AUTO_REVEAL_RESULT_TOGGLE,
      "Automatically reveal results after export",
      3,
      Array(
        Array("Always", MessageDialogWithToggle.ALWAYS),
        Array("Never", MessageDialogWithToggle.NEVER),
        Array("Prompt", MessageDialogWithToggle.PROMPT)),
      getFieldEditorParent, true))
  }

  override def init(workbench: IWorkbench) = {}

}
package fr.unice.i3s.sigma.docgen.graphviz.ui.internal.preferences

import scala.util.Failure
import scala.util.Success

import org.eclipse.jface.preference.FieldEditorPreferencePage
import org.eclipse.jface.preference.FileFieldEditor
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage

import fr.unice.i3s.sigma.docgen.core.DocgenPlugin
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot.UnsupportedVersionException

class DefaultPreferencePage
  extends FieldEditorPreferencePage //(FieldEditorPreferencePage.FLAT)
  with IWorkbenchPreferencePage {

  setPreferenceStore(DocgenPlugin.plugin.getPreferenceStore);

  override def createFieldEditors {
    addField(new FileFieldEditor(DocgenPlugin.PREF_DOT_PATH, "Graphwiz dot path:", getFieldEditorParent) {
      override def doCheckState = new GVDot(getStringValue) validate match {
        case Success(version) ⇒ {
          clearErrorMessage
          true
        }
        case Failure(failure) ⇒ {
          setErrorMessage(failure match {
            case e: UnsupportedVersionException ⇒ "Unsupported dot version: " + e.version
            case e: Throwable ⇒ "Unable to validate dot executable: " + e.getMessage
          })

          false
        }
      }
    })
  }

  override def init(workbench: IWorkbench) = {}
}
package fr.unice.i3s.sigma.docgen.graphviz.ui.internal.preferences

import scala.util.Failure
import scala.util.Success

import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.preferences.ConfigurationScope
import org.eclipse.jface.dialogs.IMessageProvider
import org.eclipse.jface.preference.FieldEditorPreferencePage
import org.eclipse.jface.preference.FileFieldEditor
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkbenchPreferencePage
import org.eclipse.ui.preferences.ScopedPreferenceStore

import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot.UnsupportedVersionException
import fr.unice.i3s.sigma.docgen.graphviz.core.GraphvizCorePlugin
import fr.unice.i3s.sigma.scala.utils.PlatformUtils.createError
import fr.unice.i3s.sigma.scala.utils.PlatformUtils.createInfo

class DefaultPreferencePage
  extends FieldEditorPreferencePage(FieldEditorPreferencePage.FLAT)
  with IWorkbenchPreferencePage {

  setPreferenceStore(new ScopedPreferenceStore(ConfigurationScope.INSTANCE, GraphvizCorePlugin.PLUGIN_ID));
  setDescription("Graphviz Default Configuration");

  override def createFieldEditors {
    addField(new FileFieldEditor(GraphvizCorePlugin.DOT_PATH, "Graphwiz dot path:", getFieldEditorParent()) {
      override def doCheckState = {

        val status = new GVDot(getStringValue) validate match {
          case Success(version) ⇒ createInfo("Found dot version: " + version)
          case Failure(failure) ⇒ failure match {
            case e: UnsupportedVersionException ⇒ createError("Unsupported dot version: " + e.version, e)
            case e: Throwable ⇒ createError("Unable to validate dot executable", e)
          }
        }

        if (!status.isOK()) {
          if (status.getSeverity() == IStatus.ERROR) {
            getPage.setMessage(status.getMessage(), IMessageProvider.ERROR)
          } else {
            getPage.setMessage(status.getMessage(), IMessageProvider.WARNING)
          }

          false
        } else {
          getPage.setMessage(null, IMessageProvider.ERROR)
          getPage.setMessage(null, IMessageProvider.WARNING)

          true;
        }
      }
    })
  }

  override def init(workbench: IWorkbench) = {}

}
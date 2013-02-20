package fr.unice.i3s.sigma.docgen.ui.internal.preferences

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

class DefaultPreferencePage extends FieldEditorPreferencePage
  with IWorkbenchPreferencePage {

  setDescription("Sigma Docgen Configuration");

  override def createFieldEditors {}

  override def init(workbench: IWorkbench) = {}

}
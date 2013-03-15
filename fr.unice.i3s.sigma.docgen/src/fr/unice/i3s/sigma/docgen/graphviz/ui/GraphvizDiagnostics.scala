package fr.unice.i3s.sigma.docgen.graphviz.ui

import scala.util.Failure
import scala.util.Success
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.MessageDialogWithToggle
import org.eclipse.swt.widgets.Shell
import org.eclipse.ui.dialogs.PreferencesUtil
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot
import fr.unice.i3s.sigma.docgen.core.DocgenPlugin
import fr.unice.i3s.sigma.scala.ui.util.SWTUtils.asyncExec
import org.eclipse.jface.dialogs.MessageDialog

object GraphvizDiagnostics {

  def validate(dot: GVDot, shell: Shell): Boolean = {
    dot validate match {
      case Success(_) ⇒ true
      case Failure(e) ⇒ askToOpenPreferences(shell); false
    }
  }

  private[this] def askToOpenPreferences(shell: Shell) {
    asyncExec {
      if (MessageDialog.openQuestion(shell, "Sigma Graphviz diagnostics",
        "Your Sigma Graphwiz configuration does not seem to be correct. Do you want to check it now? Without it it will not be possible to generate class diagrams.")) {
        val pref = PreferencesUtil
          .createPreferenceDialogOn(shell,
            DocgenPlugin.GRAPHVIZ_PREFERENCE_PAGE_ID, null, null);

        if (pref != null) pref.open();
      }
    }
  }

}
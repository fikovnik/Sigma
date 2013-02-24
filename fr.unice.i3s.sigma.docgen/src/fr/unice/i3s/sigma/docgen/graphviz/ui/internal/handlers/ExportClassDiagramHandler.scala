package fr.unice.i3s.sigma.docgen.graphviz.ui.internal.handlers

import java.io.File
import scala.collection.JavaConversions.asScalaBuffer
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.runtime.jobs.IJobChangeEvent
import org.eclipse.core.runtime.jobs.JobChangeAdapter
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.util.EcoreUtil.Copier
import org.eclipse.jface.dialogs.IDialogConstants
import org.eclipse.jface.dialogs.MessageDialogWithToggle
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.swt.SWT
import org.eclipse.swt.program.Program
import org.eclipse.swt.widgets.FileDialog
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.handlers.HandlerUtil
import fr.unice.i3s.sigma.docgen.core.DocgenPlugin
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot
import fr.unice.i3s.sigma.docgen.graphviz.common.GVOutputType
import fr.unice.i3s.sigma.docgen.graphviz.core.GenerateClassDiagramJob
import fr.unice.i3s.sigma.scala.construct.EMFBuilder
import fr.unice.i3s.sigma.scala.ui.utils.SWTUtils
import fr.unice.i3s.sigma.docgen.graphviz.ui.GraphvizDiagnostics
import org.eclipse.swt.widgets.Shell
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport

class ExportClassDiagramHandler extends AbstractHandler with EcorePackageScalaSupport {

  protected def dot: GVDot = DocgenPlugin.plugin.gvDot

  override def execute(event: ExecutionEvent): Object = {
    val selection = HandlerUtil.getActiveMenuSelection(event).asInstanceOf[IStructuredSelection]
    val shell = HandlerUtil.getActiveShell(event)

    if (selection != null && !selection.isEmpty() && GraphvizDiagnostics.validate(dot, shell)) {
      val pkg = prepareInput(selection)

      showSaveDialog(shell) match {
        case None ⇒ null
        case Some((fileName, outputType)) ⇒ export(pkg, fileName, outputType); null
      }
    }

    null
  }

  private def prepareInput(selection: IStructuredSelection): EPackage = {

    val items: List[Object] = selection.toArray.toList

    items match {
      case x :: Nil if x.isInstanceOf[EPackage] ⇒ x.asInstanceOf[EPackage]

      case _ ⇒ {
        val copier = new Copier(true, true)
        val pkg = (new EMFBuilder(EcorePackage.eINSTANCE)).create[EPackage]

        pkg.eClassifiers ++= items.collect {
          case e: EClass ⇒
            copier.copy(e).asInstanceOf[EClass]
        }
        copier.copyReferences
        pkg
      }
    }
  }

  private def showSaveDialog(shell: Shell) = {
    val typeNames = GVOutputType.values map (_.name)
    val typeExts = GVOutputType.values map (_.ext)

    val fd = new FileDialog(shell, SWT.SAVE);
    fd.setOverwrite(true);
    fd.setText("Save Class Diagram As");
    fd.setFileName("ClassDiagram." + typeExts(0));
    fd.setFilterExtensions(typeExts.toArray);
    fd.setFilterNames(typeNames.toArray);

    Option((fd.open, GVOutputType.values(fd.getFilterIndex())))
  }

  private def export(pkg: EPackage, fileName: String, outputType: GVOutputType) {

    val file = new File(fileName)
    val job = new GenerateClassDiagramJob(pkg, file, outputType, dot)

    job addJobChangeListener new JobChangeAdapter {
      override def done(event: IJobChangeEvent) {
        val job = event.getJob.asInstanceOf[GenerateClassDiagramJob]

        SWTUtils.asyncExec {
          val shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell()
          val prefs = DocgenPlugin.plugin.getPreferenceStore
          val revealOpt = {
            if (prefs.contains(DocgenPlugin.PREF_AUTO_REVEAL_RESULT_TOGGLE)) {
              prefs.getString(DocgenPlugin.PREF_AUTO_REVEAL_RESULT_TOGGLE) match {
                case MessageDialogWithToggle.ALWAYS ⇒ Some(true)
                case MessageDialogWithToggle.NEVER ⇒ Some(false)
                case MessageDialogWithToggle.PROMPT ⇒ None
              }
            } else None
          }

          val reveal = revealOpt match {
            case None ⇒
              val dialog = MessageDialogWithToggle.openYesNoCancelQuestion(
                shell,
                "Class Diagram Generated",
                "Class Diagram has been generated. Do you want to see it?",
                null, false, prefs, DocgenPlugin.PREF_AUTO_REVEAL_RESULT_TOGGLE)
              dialog.getReturnCode() == IDialogConstants.YES_ID
            case Some(v) ⇒ v
          }

          if (reveal) {
            Program.launch(job.output.getAbsolutePath())
          }
        }
      }
    }

    job schedule
  }

}
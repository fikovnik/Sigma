package fr.unice.i3s.sigma.docgen.graphviz.core

import org.eclipse.core.runtime.jobs.Job
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.emf.ecore.EPackage
import java.io.File
import fr.unice.i3s.sigma.docgen.graphviz.core.GVDot.OutputType
import scala.util.Try

class GenerateClassDiagramJob(pkg: EPackage, output: File, outputType: OutputType, dot: GVDot) extends Job("Generate Class Diagram") {

  setPriority(Job.LONG)
  setUser(true)

  override def run(monitor: IProgressMonitor): IStatus = {
    null
  }

  def doRun(monitor: IProgressMonitor): Try[String] = {
    null
  }

}
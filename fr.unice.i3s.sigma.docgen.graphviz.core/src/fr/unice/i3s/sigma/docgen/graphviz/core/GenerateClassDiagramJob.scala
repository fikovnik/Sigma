package fr.unice.i3s.sigma.docgen.graphviz.core

import java.io.File

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.IStatus
import org.eclipse.core.runtime.Status
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.ecore.EPackage

import fr.unice.i3s.sigma.docgen.graphviz.core.GVDot.OutputType
import fr.unice.i3s.sigma.docgen.graphviz.core.internal.ClassDiagram
import fr.unice.i3s.sigma.scala.utils.PlatformUtils
import fr.unice.i3s.sigma.scala.utils.io.using

class GenerateClassDiagramJob(pkg: EPackage, output: File, outputType: OutputType, dot: GVDot)
  extends Job("Generate Class Diagram") {

  require(pkg != null)
  require(output != null)
  require(dot != null)

  setPriority(Job.LONG)
  setUser(true)

  override def run(monitor: IProgressMonitor): IStatus = {
    try doRun(monitor)
    catch {
      case e: Throwable ⇒ PlatformUtils.createError("Unable to save class diagram", e)
    }

    Status.OK_STATUS
  }

  def doRun(monitor: IProgressMonitor) {
    monitor beginTask ("Generating class diagram", 1)

    val dotFile = File.createTempFile("sigma-docgen-classdiagram", ".dot")

    using(dotFile) { writer ⇒
      val digram = new ClassDiagram(pkg)
      digram >> writer
    }

    dot.generate(dotFile, output, outputType)
    dotFile.delete

    monitor.done
  }

}
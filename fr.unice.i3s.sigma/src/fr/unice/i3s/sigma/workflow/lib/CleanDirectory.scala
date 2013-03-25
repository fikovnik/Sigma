package fr.unice.i3s.sigma.workflow.lib

import fr.unice.i3s.sigma.workflow.WorkflowTask
import java.io.File
import fr.unice.i3s.sigma.util.IOUtils
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import fr.unice.i3s.sigma.workflow.WorkflowTaskFactory

object CleanDirectory extends WorkflowTaskFactory {
  type Task = CleanDirectory

  def apply(
    path: String,
    deleteParentDir: Boolean = false,
    stopOnError: Boolean = false)(implicit runner: WorkflowRunner): CleanDirectory = {

    val task = new CleanDirectory(path, deleteParentDir, stopOnError)
    execute(task)
    task
  }
}

class CleanDirectory(
  val path: String,
  val deleteParentDir: Boolean = false,
  val stopOnError: Boolean = false) extends WorkflowTask with Logging {

  val dir = new File(path)

  def execute {
    if (dir.exists) {
      logger.info("Deleting directory: " + dir.getCanonicalPath)
      cleanDirectory
    }
  }

  def cleanDirectory = IOUtils.rmdir(dir, deleteParentDir, stopOnError,
    {
      case (f, true) ⇒ logger.debug("Deleting: " + f.getCanonicalPath)
      case (f, false) if stopOnError ⇒ logger.error("Unable Deleting: " + f.getCanonicalPath)
      case (f, false) ⇒ logger.warn("Unable Deleting: " + f.getCanonicalPath)
    })

}
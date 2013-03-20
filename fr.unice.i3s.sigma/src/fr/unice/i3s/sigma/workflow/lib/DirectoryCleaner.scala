package fr.unice.i3s.sigma.workflow.lib

import fr.unice.i3s.sigma.workflow.WorkflowComponent
import java.io.File
import fr.unice.i3s.sigma.util.IOUtils
import com.typesafe.scalalogging.log4j.Logging

case class DirectoryCleaner(
  val path: String,
  val deleteParentDir: Boolean = false,
  val stopOnError: Boolean = false) extends WorkflowComponent with Logging {

  val dir = new File(path)

  def invoke {
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
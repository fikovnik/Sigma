package fr.unice.i3s.sigma.workflow.lib

import java.io.File
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.util.IOUtils
import fr.unice.i3s.sigma.workflow.WorkflowTask
import scala.beans.BeanProperty

class CleanDirectory extends WorkflowTask with Logging {

  @BeanProperty
  protected var path: File = _
  protected def path_=(v: String): Unit = path = new File(v)
  protected def setPath(v: String) = path = v

  @BeanProperty
  protected var deleteParentDir: Boolean = false

  @BeanProperty
  protected var stopOnError: Boolean = true

  def doExecute {
    if (path.exists) {
      logger.info("Deleting directory: " + path.getCanonicalPath)
      cleanDirectory
    }
  }

  def cleanDirectory = IOUtils.rmdir(path, deleteParentDir, stopOnError,
    {
      case (f, true) ⇒ logger.debug("Deleting: " + f.getCanonicalPath)
      case (f, false) if stopOnError ⇒ logger.error("Unable Deleting: " + f.getCanonicalPath)
      case (f, false) ⇒ logger.warn("Unable Deleting: " + f.getCanonicalPath)
    })

}
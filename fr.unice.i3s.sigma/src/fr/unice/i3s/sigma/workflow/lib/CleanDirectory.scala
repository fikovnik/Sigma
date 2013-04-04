package fr.unice.i3s.sigma.workflow.lib

import java.io.File

import com.typesafe.scalalogging.log4j.Logging

import fr.unice.i3s.sigma.util.IOUtils
import fr.unice.i3s.sigma.workflow.WorkflowTask

class CleanDirectory extends WorkflowTask with Logging {
  private var _path: File = _
  protected def path: File = _path
  protected def path_=(v: File) = _path = v
  protected def path_=(v: String) = _path = new File(v)
  protected def setPath(v: String) = path = v

  private var _deleteParentDir: Boolean = _
  protected def deleteParentDir: Boolean = _deleteParentDir
  protected def deleteParentDir_=(v: Boolean) = _deleteParentDir = v
  protected def setDeleteParentDir(v: Boolean) = deleteParentDir = v

  private var _stopOnError: Boolean = _
  protected def stopOnError: Boolean = _stopOnError
  protected def stopOnError_=(v: Boolean) = _stopOnError = v
  protected def setStopOnError(v: Boolean) = stopOnError = v

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
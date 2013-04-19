package fr.unice.i3s.sigma.workflow.lib

import fr.unice.i3s.sigma.workflow.WorkflowTask
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.util.IOUtils
import scala.util.Success
import scala.util.Failure

class RunShellCommand extends WorkflowTask with Logging {

  protected var cmd: String = _

  protected def doExecute {
    logger.info(s"Running commands: `$cmd`")
    IOUtils.SystemExecutor.execute(cmd) match {
      case Success(_) ⇒ logger.info(s"Command `$cmd` executed successfully")
      case Failure(e) ⇒ logger.info(s"Command `$cmd` failed: $e")
    }
  }

}
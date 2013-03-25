package fr.unice.i3s.sigma.workflow

import com.typesafe.scalalogging.log4j.Logging
import scala.util.Failure
import scala.util.Success

class BasicWorkflowRunner extends WorkflowRunner with Logging {

  def execute(task: WorkflowTask) {
    // TODO: introduce task name
    logger.trace("Initializing component: " + task.getClass)
    task.validate match {
      case Failure(e) ⇒
        logger.error("Task validation failed", e)
      case Success(_) ⇒
        val stopwatch = System.currentTimeMillis
        task.execute
        val duration = System.currentTimeMillis - stopwatch
        logger.trace(s"Executed in ${duration}ms")
    }
  }

}
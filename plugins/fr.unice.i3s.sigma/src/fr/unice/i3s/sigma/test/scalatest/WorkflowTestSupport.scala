package fr.unice.i3s.sigma.test.scalatest

import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import fr.unice.i3s.sigma.workflow.BasicWorkflowRunner

trait WorkflowTestSupport extends Logging {

  implicit val runner: WorkflowRunner = new BasicWorkflowRunner

}
package fr.unice.i3s.sigma.workflow

import com.typesafe.scalalogging.log4j.Logging

class WorkflowApp extends App with Logging {

  implicit val runner: WorkflowRunner = new BasicWorkflowRunner

}
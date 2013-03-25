package fr.unice.i3s.sigma.workflow

import scala.util.Try
import scala.util.Success

trait WorkflowTask {

  def validate: Try[Unit] = Success()

  def execute: Unit

}
package fr.unice.i3s.sigma.scala.workflow

import com.typesafe.scalalogging.log4j.Logging

trait WorkflowComponent extends DelayedInit with Logging {

  def delayedInit(body: ⇒ Unit) = {
    logger.trace("Initializing component: " + this.getClass)
    body
    val stopwatch = System.currentTimeMillis
    invoke
    val duration = System.currentTimeMillis - stopwatch
    logger.trace(s"Executed in ${duration}ms")
  }

  def invoke
}
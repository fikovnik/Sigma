package fr.unice.i3s.sigma.workflow

import scala.util.Try
import scala.util.Success
import scala.collection.mutable.ListBuffer

trait WorkflowTask { //extends DelayedInit {

  //  private val initCode = new ListBuffer[() ⇒ Unit]
  //
  //  override def delayedInit(body: ⇒ Unit) {
  //    initCode += (() ⇒ body)
  //  }

  def unary_!(implicit runner: WorkflowRunner): this.type = {
    runner.execute(this)
    this
  }

  def validate: Try[Unit] = Success()

  final def execute: Unit = {
    //    for (proc ← initCode) proc()
    doExecute
  }

  protected def doExecute: Unit

}
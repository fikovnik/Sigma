package fr.unice.i3s.sigma.workflow

trait WorkflowRunner {

  def execute(task: WorkflowTask): Unit

}
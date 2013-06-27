package fr.unice.i3s.sigma.workflow

trait Workflow {

  protected implicit val runner: WorkflowRunner = new BasicWorkflowRunner

  protected def execute(task: WorkflowTask) = !task

}
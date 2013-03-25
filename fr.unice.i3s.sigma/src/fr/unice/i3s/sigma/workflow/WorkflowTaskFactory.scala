package fr.unice.i3s.sigma.workflow

class WorkflowTaskFactory {
  type Task <: WorkflowTask
  type Config = (Task) ⇒ Unit

  protected def execute(task: Task)(implicit runner: WorkflowRunner) = runner.execute(task)
}
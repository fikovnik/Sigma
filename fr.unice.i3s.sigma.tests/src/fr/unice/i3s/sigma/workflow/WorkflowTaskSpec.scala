package fr.unice.i3s.sigma.workflow

import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class WorkflowTaskSpec extends FlatSpec with MustMatchers {

  "WorkflowTask" must "be able to execute itself" in {

    implicit val runner = new WorkflowRunner {
      def execute(task: WorkflowTask) = task.execute
    }

    class Task extends WorkflowTask {
      var executed = "NO"
      var property: String = _
      def doExecute = executed = property
    }

    val task = !new Task {
      property = "YES"
    }

    task.executed must be === "YES"
  }

}
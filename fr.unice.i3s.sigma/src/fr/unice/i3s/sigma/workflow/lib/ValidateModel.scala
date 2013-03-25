package fr.unice.i3s.sigma.workflow.lib

import fr.unice.i3s.sigma.workflow.WorkflowTask
import org.eclipse.emf.ecore.EObject
import com.typesafe.scalalogging.log4j.Logging
import org.eclipse.emf.ecore.util.Diagnostician
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.workflow.WorkflowTaskFactory
import fr.unice.i3s.sigma.workflow.WorkflowRunner

object ValidateModel extends WorkflowTaskFactory {
  type Task = ValidateModel

  def apply(models: EObject*)(implicit runner: WorkflowRunner): ValidateModel = {
    val task = new ValidateModel(models)
    execute(task)
    task
  }
}

class ValidateModel(val models: Seq[EObject]) extends WorkflowTask with Logging with EMFScalaSupport {

  def execute {
    val diagnostician = Diagnostician.INSTANCE
    models.par.map { m ⇒
      logger.debug("Validating model: " + m)
      val diag = diagnostician.validate(m)
      if (!diag.isOK) {
        val problems = diag.prettyPrint
        logger.error(s"Validation of $m failed:\n$problems")
      }
    }
  }

}
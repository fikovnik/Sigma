package fr.unice.i3s.sigma.workflow.lib

import scala.collection.mutable.Buffer

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.Diagnostician

import com.typesafe.scalalogging.log4j.Logging

import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.workflow.WorkflowTask

class ValidateModel extends WorkflowTask with Logging with EMFScalaSupport {

  private val models = Buffer[EObject]()

  def model(m: EObject) = models += m

  def doExecute {
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
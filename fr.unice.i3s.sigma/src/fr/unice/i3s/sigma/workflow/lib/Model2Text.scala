package fr.unice.i3s.sigma.workflow.lib

import fr.unice.i3s.sigma.workflow.WorkflowTask
import fr.unice.i3s.sigma.m2t.TextTemplate
import java.io.File
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.util.IOUtils.using

class Model2Text extends WorkflowTask with Logging {

  protected var source: TextTemplate = _
  protected var target: File = _
  protected def target_=(v: String): Unit = target = new File(v)

  protected def doExecute {
    // FIXME: add template name
    logger.info(s"Executing Model2Text template")
    using(target) { f ⇒
      logger.info(s"Saving output to file ${target}")
      source >> f
    }
  }

}
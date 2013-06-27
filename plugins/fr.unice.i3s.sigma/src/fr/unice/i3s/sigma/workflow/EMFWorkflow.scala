package fr.unice.i3s.sigma.workflow

import fr.unice.i3s.sigma.support.EMFScalaSupport
import org.eclipse.emf.ecore.EObject
import scala.reflect.ClassTag
import com.typesafe.scalalogging.log4j.Logging
import org.eclipse.emf.common.util.URI
import fr.unice.i3s.sigma.util.EMFUtils

trait EMFWorkflow extends EMFScalaSupport with Logging {

  def loadModel[T <: EObject: ClassTag](path: String): T = loadModel[T](URI.createURI(path))

  def loadModel[T <: EObject: ClassTag](uri: java.net.URL): T = loadModel[T](uri.toString)

  def loadModel[T <: EObject: ClassTag](uri: URI): T = {
    logger.info("Loading model: " + uri);

    EMFUtils.IO.load[T](uri, true)
  }

}
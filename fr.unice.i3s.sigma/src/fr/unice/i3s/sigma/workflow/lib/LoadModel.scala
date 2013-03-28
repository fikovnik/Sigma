package fr.unice.i3s.sigma.workflow.lib

import fr.unice.i3s.sigma.workflow.WorkflowTaskFactory
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import scala.collection.mutable.Buffer
import org.eclipse.emf.ecore.EObject
import fr.unice.i3s.sigma.util.EMFUtils
import org.eclipse.emf.common.util.URI
import fr.unice.i3s.sigma.workflow.WorkflowTask
import com.typesafe.scalalogging.log4j.Logging
import scala.reflect.{ classTag, ClassTag }
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import fr.unice.i3s.sigma.TypeUnion._

object LoadModel extends WorkflowTaskFactory {
  type Task = LoadModel

  def apply[T: (URI |∨| String)#λ](modelsPath: T*)(implicit runner: WorkflowRunner) = {
    val uris = modelsPath collect {
      case x: URI ⇒ x
      case x: String ⇒ URI.createURI(x)
    }
    val task = new LoadModel(uris)
    execute(task)
    task
  }
}

class LoadModel(val modelsURI: Seq[URI])(implicit val _runner: WorkflowRunner) extends WorkflowTask with Logging {
  protected var _models: Seq[EObject] = _

  def models: Seq[EObject] = _models
  def model[T <: EObject: ClassTag]: T = model[T](0)
  def model[T <: EObject: ClassTag](idx: Int): T = _models(idx) match {
    case x: T ⇒ x
    case x ⇒ throw new RuntimeException(s"Loaded model `$x` is not of type: `${classTag[T]}` but `${x.getClass.getName}`")
  }

  def execute {
    _models = modelsURI.par.map { uri ⇒
      logger.info("Loading model: " + uri);
      EMFUtils.IO.load[EObject](uri, true)
    }.toList
  }
}
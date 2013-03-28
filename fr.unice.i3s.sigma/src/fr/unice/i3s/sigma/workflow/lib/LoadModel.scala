package fr.unice.i3s.sigma.workflow.lib

import scala.collection.mutable.Buffer
import scala.reflect.ClassTag
import scala.reflect.classTag

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet

import com.typesafe.scalalogging.log4j.Logging

import fr.unice.i3s.sigma.TypeUnion._
import fr.unice.i3s.sigma.util.EMFUtils
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import fr.unice.i3s.sigma.workflow.WorkflowTask

class LoadModel extends WorkflowTask with Logging {
  protected var _models: Seq[EObject] = _

  private var _modelsURI = Buffer[URI]()

  def modelURI(v: URI): Unit = _modelsURI += v
  def modelURI(v: java.net.URL): Unit = modelURI(v.toString)
  def modelURI(v: String): Unit = _modelsURI += URI.createURI(v)

  def models: Seq[EObject] = _models
  def model[T <: EObject: ClassTag]: T = model[T](0)
  def model[T <: EObject: ClassTag](idx: Int): T = _models(idx) match {
    case x: T ⇒ x
    case x ⇒ throw new RuntimeException(s"Loaded model `$x` is not of type: `${classTag[T]}` but `${x.getClass.getName}`")
  }

  def doExecute {
    _models = _modelsURI.par.map { uri ⇒
      logger.info("Loading model: " + uri);
      EMFUtils.IO.load[EObject](uri, true)
    }.toList
  }
}
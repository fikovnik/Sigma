package fr.unice.i3s.sigma.util

import java.io.File

import scala.collection.JavaConversions._
import scala.reflect.ClassTag
import scala.reflect.classTag

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.xmi.XMLResource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

object EMFUtils {

  object IO {

    def loadResource(uri: URI, resolveAll: Boolean = true, resourceSet: ResourceSet = new ResourceSetImpl): Resource = {
      val res = resourceSet.getResource(uri, true)

      if (resolveAll) {
        EcoreUtil.resolveAll(resourceSet)
      }

      res
    }

    def loadResourceFromFile[T <: EObject: ClassTag](file: File, resolveAll: Boolean = true): Resource = {
      val uri = URI.createFileURI(file.getAbsolutePath())
      loadResource(uri, resolveAll)
    }

    def load[T <: EObject: ClassTag](uri: URI, resolveAll: Boolean = true, resourceSet: ResourceSet = new ResourceSetImpl): T = {
      val res = loadResource(uri, resolveAll, resourceSet)

      res.getContents().get(0) match {
        case x: T ⇒ x
        case x ⇒ throw new RuntimeException(s"Loaded model `$x` is not of type: `${classTag[T]}` but `${x.getClass.getName}`")
      }
    }

    def loadFromFile[T <: EObject: ClassTag](file: File, resolveAll: Boolean = true): T = {
      val uri = URI.createFileURI(file.getAbsolutePath())
      load(uri, resolveAll)
    }

    def saveToFile(file: File, elems: TraversableOnce[EObject]) {
      val uri = URI.createFileURI(file.getAbsolutePath())
      save(uri, elems);
    }

    def save(uri: URI, elems: TraversableOnce[EObject]) {
      val resourceSet = new ResourceSetImpl()
      val resource = resourceSet.createResource(uri)
      val contents = resource.getContents()

      elems foreach contents.add

      // TODO: re-organize - should be a boolean param
      // TODO: should we have XMI dependency?
      resource.save(Map(
        XMLResource.OPTION_SCHEMA_LOCATION -> (true: java.lang.Boolean)
      ))
    }

    def registerDefaultFactories {
      Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap
        .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl)
    }

  }

  def resolve(resource: Resource) = {
    EcoreUtil.resolveAll(resource)
    resource
  }

}
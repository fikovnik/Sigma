package fr.unice.i3s.sigma.scala.common.util

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import com.google.common.io.Files
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import java.io.File
import com.google.common.base.Charsets
import org.eclipse.emf.ecore.xmi.XMLResource

object EMFUtils {

  object IO {

    def load[T <: EObject](uri: URI, resolveAll: Boolean = true): (T, ResourceSet) = {
      val rs = new ResourceSetImpl()
      val r = rs.getResource(uri, true)

      if (resolveAll) {
        EcoreUtil.resolveAll(rs)
      }

      // TODO: fix the asInstanceOf
      (r.getContents().get(0).asInstanceOf[T], rs)
    }

    def loadFromFile[T <: EObject](file: File, resolveAll: Boolean = true): (T, ResourceSet) = {

      val uri = URI.createFileURI(file.getAbsolutePath())
      load(uri, resolveAll)
    }

    def saveToFile(root: EObject, file: File) {
      val uri = URI.createFileURI(file.getAbsolutePath())

      save(root, uri);
    }

    def save(root: EObject, uri: URI) {
      val resourceSet = new ResourceSetImpl()
      val resource = resourceSet.createResource(uri)

      resource.getContents().add(root)

      // TODO: reogranize - should be a boolean param
      // TODO: should we have XMI dependency?
      resource.save(Map(
        XMLResource.OPTION_SCHEMA_LOCATION -> (true: java.lang.Boolean)))
    }

  }

  def resolve(resource: Resource) = {
    EcoreUtil.resolveAll(resource)
    resource
  }

}
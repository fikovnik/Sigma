package fr.unice.i3s.sigma.scala

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import java.io.File
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.resource.ResourceSet
import fr.unice.i3s.sigma.scala.common.util.IOUtils
import fr.unice.i3s.sigma.scala.common.util.EMFUtils

package object tools {

  val scalaKeywords = List("abstract", "case", "do", "else", "finally", "for", "import", "lazy", "object", "override", "return", "sealed", "trait", "try", "var", "while", "catch", "class", "extends", "false", "forSome", "if", "match", "new", "package", "private", "super", "this", "true", "type", "with", "yield", "def", "final", "implicit", "null", "protected", "throw", "val")

  def load[A <: EObject](fname: String): (A, ResourceSet) = {
    GenModelPackage.eINSTANCE.getGenClass

    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap() +=
      ("genmodel" -> new XMIResourceFactoryImpl())
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap() +=
      ("ecore" -> new XMIResourceFactoryImpl())

    EMFUtils.IO.loadFromFile[A](new File(fname))
  }

}
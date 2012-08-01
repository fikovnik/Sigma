package fr.unice.i3s.sigma.support.scala.tools

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

package object tools {

  def load[A <: EObject](fname : String) : (A, ResourceSet) = {
    GenModelPackage.eINSTANCE.getGenClass

    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap() +=
      ("genmodel" -> new XMIResourceFactoryImpl())
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap() +=
      ("ecore" -> new XMIResourceFactoryImpl())

    val rs = new ResourceSetImpl()
    val r = rs.getResource(URI.createFileURI(new File(fname).getAbsolutePath), true)
    EcoreUtil.resolveAll(rs)

    (r.getContents().get(0).asInstanceOf[A], rs)
  }

}
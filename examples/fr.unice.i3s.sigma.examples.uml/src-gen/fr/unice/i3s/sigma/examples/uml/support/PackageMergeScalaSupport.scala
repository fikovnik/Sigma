package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.PackageMerge;

import scala.Option;

trait PackageMergeScalaSupport extends EMFScalaSupport {
  type PackageMerge = org.eclipse.uml2.uml.PackageMerge
  
  protected implicit val _packagemergeProxyBuilder = new EMFProxyBuilder[PackageMerge](UMLPackageScalaSupport._umlBuilder)
  
  object PackageMerge {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, mergedPackage: org.eclipse.uml2.uml.Package = null): PackageMerge = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[PackageMerge]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (mergedPackage != null) _instance.setMergedPackage(mergedPackage)
      
      _instance
    }
  }
  
  implicit class PackageMergeScalaSupport(that: PackageMerge) {
    def mergedPackage: org.eclipse.uml2.uml.Package = that.getMergedPackage
    def mergedPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setMergedPackage(value)
    def mergedPackage_=(value: ⇒ Option[org.eclipse.uml2.uml.Package]): Unit =
      that.setMergedPackage(UMLPackageScalaSupport._umlBuilder.ref(value))
    def receivingPackage: org.eclipse.uml2.uml.Package = that.getReceivingPackage
    def receivingPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setReceivingPackage(value)
    def receivingPackage_=(value: ⇒ Option[org.eclipse.uml2.uml.Package]): Unit =
      that.setReceivingPackage(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object PackageMergeScalaSupport extends PackageMergeScalaSupport

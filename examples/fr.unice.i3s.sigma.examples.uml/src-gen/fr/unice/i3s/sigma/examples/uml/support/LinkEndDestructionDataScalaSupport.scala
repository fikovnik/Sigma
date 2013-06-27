package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.QualifierValue;

import scala.Option;

trait LinkEndDestructionDataScalaSupport extends EMFScalaSupport {
  type LinkEndDestructionData = org.eclipse.uml2.uml.LinkEndDestructionData
  
  protected implicit val _linkenddestructiondataProxyBuilder = new EMFProxyBuilder[LinkEndDestructionData](UMLPackageScalaSupport._umlBuilder)
  
  object LinkEndDestructionData {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, end: Property = null, qualifier: EList[QualifierValue] = null, value: InputPin = null, destroyAt: InputPin = null, isDestroyDuplicates: Boolean = false): LinkEndDestructionData = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[LinkEndDestructionData]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (end != null) _instance.setEnd(end)
      if (qualifier != null) _instance.getQualifiers.addAll(qualifier)
      if (value != null) _instance.setValue(value)
      if (destroyAt != null) _instance.setDestroyAt(destroyAt)
      if (isDestroyDuplicates != false) _instance.setIsDestroyDuplicates(isDestroyDuplicates)
      
      _instance
    }
  }
  
  implicit class LinkEndDestructionDataScalaSupport(that: LinkEndDestructionData) {
    def destroyAt: InputPin = that.getDestroyAt
    def destroyAt_=(value: InputPin): Unit = that.setDestroyAt(value)
    def destroyAt_=(value: ⇒ Option[InputPin]): Unit =
      that.setDestroyAt(UMLPackageScalaSupport._umlBuilder.ref(value))
    def isDestroyDuplicates: Boolean = that.isDestroyDuplicates
    def isDestroyDuplicates_=(value: Boolean): Unit = that.setIsDestroyDuplicates(value)
  }
}

object LinkEndDestructionDataScalaSupport extends LinkEndDestructionDataScalaSupport

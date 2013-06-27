package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.QualifierValue;

import scala.Option;

trait LinkEndDataScalaSupport extends EMFScalaSupport {
  type LinkEndData = org.eclipse.uml2.uml.LinkEndData
  
  protected implicit val _linkenddataProxyBuilder = new EMFProxyBuilder[LinkEndData](UMLPackageScalaSupport._umlBuilder)
  
  object LinkEndData {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, end: Property = null, qualifier: EList[QualifierValue] = null, value: InputPin = null): LinkEndData = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[LinkEndData]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (end != null) _instance.setEnd(end)
      if (qualifier != null) _instance.getQualifiers.addAll(qualifier)
      if (value != null) _instance.setValue(value)
      
      _instance
    }
  }
  
  implicit class LinkEndDataScalaSupport(that: LinkEndData) {
    def end: Property = that.getEnd
    def end_=(value: Property): Unit = that.setEnd(value)
    def end_=(value: ⇒ Option[Property]): Unit =
      that.setEnd(UMLPackageScalaSupport._umlBuilder.ref(value))
    def qualifier: EList[QualifierValue] = that.getQualifiers
    def value: InputPin = that.getValue
    def value_=(value: InputPin): Unit = that.setValue(value)
    def value_=(value: ⇒ Option[InputPin]): Unit =
      that.setValue(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object LinkEndDataScalaSupport extends LinkEndDataScalaSupport

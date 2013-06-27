package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.QualifierValue;

import scala.Option;

trait QualifierValueScalaSupport extends EMFScalaSupport {
  type QualifierValue = org.eclipse.uml2.uml.QualifierValue
  
  protected implicit val _qualifiervalueProxyBuilder = new EMFProxyBuilder[QualifierValue](UMLPackageScalaSupport._umlBuilder)
  
  object QualifierValue {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, qualifier: Property = null, value: InputPin = null): QualifierValue = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[QualifierValue]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (qualifier != null) _instance.setQualifier(qualifier)
      if (value != null) _instance.setValue(value)
      
      _instance
    }
  }
  
  implicit class QualifierValueScalaSupport(that: QualifierValue) {
    def qualifier: Property = that.getQualifier
    def qualifier_=(value: Property): Unit = that.setQualifier(value)
    def qualifier_=(value: ⇒ Option[Property]): Unit =
      that.setQualifier(UMLPackageScalaSupport._umlBuilder.ref(value))
    def value: InputPin = that.getValue
    def value_=(value: InputPin): Unit = that.setValue(value)
    def value_=(value: ⇒ Option[InputPin]): Unit =
      that.setValue(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object QualifierValueScalaSupport extends QualifierValueScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.LinkEndCreationData;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.QualifierValue;

import scala.Option;

trait LinkEndCreationDataScalaSupport extends EMFScalaSupport {
  type LinkEndCreationData = org.eclipse.uml2.uml.LinkEndCreationData
  
  protected implicit val _linkendcreationdataProxyBuilder = new EMFProxyBuilder[LinkEndCreationData](UMLPackageScalaSupport._umlBuilder)
  
  object LinkEndCreationData {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, end: Property = null, qualifier: EList[QualifierValue] = null, value: InputPin = null, insertAt: InputPin = null, isReplaceAll: Boolean = false): LinkEndCreationData = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[LinkEndCreationData]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (end != null) _instance.setEnd(end)
      if (qualifier != null) _instance.getQualifiers.addAll(qualifier)
      if (value != null) _instance.setValue(value)
      if (insertAt != null) _instance.setInsertAt(insertAt)
      if (isReplaceAll != false) _instance.setIsReplaceAll(isReplaceAll)
      
      _instance
    }
  }
  
  implicit class LinkEndCreationDataScalaSupport(that: LinkEndCreationData) {
    def insertAt: InputPin = that.getInsertAt
    def insertAt_=(value: InputPin): Unit = that.setInsertAt(value)
    def insertAt_=(value: ⇒ Option[InputPin]): Unit =
      that.setInsertAt(UMLPackageScalaSupport._umlBuilder.ref(value))
    def isReplaceAll: Boolean = that.isReplaceAll
    def isReplaceAll_=(value: Boolean): Unit = that.setIsReplaceAll(value)
  }
}

object LinkEndCreationDataScalaSupport extends LinkEndCreationDataScalaSupport

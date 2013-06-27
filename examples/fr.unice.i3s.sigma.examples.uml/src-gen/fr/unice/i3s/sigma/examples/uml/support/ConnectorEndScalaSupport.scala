package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

import scala.Option;

trait ConnectorEndScalaSupport extends EMFScalaSupport {
  type ConnectorEnd = org.eclipse.uml2.uml.ConnectorEnd
  
  protected implicit val _connectorendProxyBuilder = new EMFProxyBuilder[ConnectorEnd](UMLPackageScalaSupport._umlBuilder)
  
  object ConnectorEnd {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, isOrdered: Boolean = false, isUnique: Boolean = true, lowerValue: ValueSpecification = null, upperValue: ValueSpecification = null, partWithPort: Property = null, role: ConnectableElement = null): ConnectorEnd = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ConnectorEnd]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (isOrdered != false) _instance.setIsOrdered(isOrdered)
      if (isUnique != true) _instance.setIsUnique(isUnique)
      if (lowerValue != null) _instance.setLowerValue(lowerValue)
      if (upperValue != null) _instance.setUpperValue(upperValue)
      if (partWithPort != null) _instance.setPartWithPort(partWithPort)
      if (role != null) _instance.setRole(role)
      
      _instance
    }
  }
  
  implicit class ConnectorEndScalaSupport(that: ConnectorEnd) {
    def definingEnd: Property = that.getDefiningEnd
    def partWithPort: Property = that.getPartWithPort
    def partWithPort_=(value: Property): Unit = that.setPartWithPort(value)
    def partWithPort_=(value: ⇒ Option[Property]): Unit =
      that.setPartWithPort(UMLPackageScalaSupport._umlBuilder.ref(value))
    def role: ConnectableElement = that.getRole
    def role_=(value: ConnectableElement): Unit = that.setRole(value)
    def role_=(value: ⇒ Option[ConnectableElement]): Unit =
      that.setRole(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ConnectorEndScalaSupport extends ConnectorEndScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConnectorKind;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ConnectorScalaSupport extends EMFScalaSupport {
  type Connector = org.eclipse.uml2.uml.Connector
  
  protected implicit val _connectorProxyBuilder = new EMFProxyBuilder[Connector](UMLPackageScalaSupport._umlBuilder)
  
  object Connector {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, static: Boolean = false, contract: EList[Behavior] = null, end: EList[ConnectorEnd] = null, redefinedConnector: EList[Connector] = null, type_ : Association = null): Connector = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Connector]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (static != false) _instance.setIsStatic(static)
      if (contract != null) _instance.getContracts.addAll(contract)
      if (end != null) _instance.getEnds.addAll(end)
      if (redefinedConnector != null) _instance.getRedefinedConnectors.addAll(redefinedConnector)
      if (type_  != null) _instance.setType(type_ )
      
      _instance
    }
  }
  
  implicit class ConnectorScalaSupport(that: Connector) {
    def contract: EList[Behavior] = that.getContracts
    def end: EList[ConnectorEnd] = that.getEnds
    def kind: ConnectorKind = that.getKind
    def redefinedConnector: EList[Connector] = that.getRedefinedConnectors
    def type_ : Association = that.getType
    def type__=(value: Association): Unit = that.setType(value)
    def type__=(value: ⇒ Option[Association]): Unit =
      that.setType(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ConnectorScalaSupport extends ConnectorScalaSupport

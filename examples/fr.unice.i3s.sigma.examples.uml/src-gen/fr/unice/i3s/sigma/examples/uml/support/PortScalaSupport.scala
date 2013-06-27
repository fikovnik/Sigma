package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait PortScalaSupport extends EMFScalaSupport {
  type Port = org.eclipse.uml2.uml.Port
  
  protected implicit val _portProxyBuilder = new EMFProxyBuilder[Port](UMLPackageScalaSupport._umlBuilder)
  
  object Port {
    def apply(): Port = {
      UMLPackageScalaSupport._umlBuilder.create[Port]
    }
  }
  
  implicit class PortScalaSupport(that: Port) {
    def isBehavior: Boolean = that.isBehavior
    def isBehavior_=(value: Boolean): Unit = that.setIsBehavior(value)
    def isConjugated: Boolean = that.isConjugated
    def isConjugated_=(value: Boolean): Unit = that.setIsConjugated(value)
    def isService: Boolean = that.isService
    def isService_=(value: Boolean): Unit = that.setIsService(value)
    def protocol: ProtocolStateMachine = that.getProtocol
    def protocol_=(value: ProtocolStateMachine): Unit = that.setProtocol(value)
    def protocol_=(value: ⇒ Option[ProtocolStateMachine]): Unit =
      that.setProtocol(UMLPackageScalaSupport._umlBuilder.ref(value))
    def provided: EList[Interface] = that.getProvideds
    def redefinedPort: EList[Port] = that.getRedefinedPorts
    def required: EList[Interface] = that.getRequireds
  }
}

object PortScalaSupport extends PortScalaSupport

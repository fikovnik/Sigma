package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait InterfaceScalaSupport extends EMFScalaSupport {
  type Interface = org.eclipse.uml2.uml.Interface
  
  protected implicit val _interfaceProxyBuilder = new EMFProxyBuilder[Interface](UMLPackageScalaSupport._umlBuilder)
  
  object Interface {
    def apply(): Interface = {
      UMLPackageScalaSupport._umlBuilder.create[Interface]
    }
  }
  
  implicit class InterfaceScalaSupport(that: Interface) {
    def nestedClassifier: EList[Classifier] = that.getNestedClassifiers
    def ownedAttribute: EList[Property] = that.getOwnedAttributes
    def ownedOperation: EList[Operation] = that.getOwnedOperations
    def ownedReception: EList[Reception] = that.getOwnedReceptions
    def protocol: ProtocolStateMachine = that.getProtocol
    def protocol_=(value: ProtocolStateMachine): Unit = that.setProtocol(value)
    def redefinedInterface: EList[Interface] = that.getRedefinedInterfaces
  }
}

object InterfaceScalaSupport extends InterfaceScalaSupport

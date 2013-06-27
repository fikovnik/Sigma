package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait ComponentScalaSupport extends EMFScalaSupport {
  type Component = org.eclipse.uml2.uml.Component
  
  protected implicit val _componentProxyBuilder = new EMFProxyBuilder[Component](UMLPackageScalaSupport._umlBuilder)
  
  object Component {
    def apply(): Component = {
      UMLPackageScalaSupport._umlBuilder.create[Component]
    }
  }
  
  implicit class ComponentScalaSupport(that: Component) {
    def isIndirectlyInstantiated: Boolean = that.isIndirectlyInstantiated
    def isIndirectlyInstantiated_=(value: Boolean): Unit = that.setIsIndirectlyInstantiated(value)
    def packagedElement: EList[PackageableElement] = that.getPackagedElements
    def provided: EList[Interface] = that.getProvideds
    def realization: EList[ComponentRealization] = that.getRealizations
    def required: EList[Interface] = that.getRequireds
  }
}

object ComponentScalaSupport extends ComponentScalaSupport

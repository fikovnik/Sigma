package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait ClassScalaSupport extends EMFScalaSupport {
  type Class = org.eclipse.uml2.uml.Class
  
  protected implicit val _classProxyBuilder = new EMFProxyBuilder[Class](UMLPackageScalaSupport._umlBuilder)
  
  object Class {
    def apply(): Class = {
      UMLPackageScalaSupport._umlBuilder.create[Class]
    }
  }
  
  implicit class ClassScalaSupport(that: org.eclipse.uml2.uml.Class) {
    def ownedOperation: EList[Operation] = that.getOwnedOperations
    def extension: EList[Extension] = that.getExtensions
    def isActive: Boolean = that.isActive
    def isActive_=(value: Boolean): Unit = that.setIsActive(value)
    def nestedClassifier: EList[Classifier] = that.getNestedClassifiers
    def ownedReception: EList[Reception] = that.getOwnedReceptions
    def superClass: EList[org.eclipse.uml2.uml.Class] = that.getSuperClasses
  }
}

object ClassScalaSupport extends ClassScalaSupport

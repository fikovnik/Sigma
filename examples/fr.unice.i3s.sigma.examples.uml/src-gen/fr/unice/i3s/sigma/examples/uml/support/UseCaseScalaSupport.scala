package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait UseCaseScalaSupport extends EMFScalaSupport {
  type UseCase = org.eclipse.uml2.uml.UseCase
  
  protected implicit val _usecaseProxyBuilder = new EMFProxyBuilder[UseCase](UMLPackageScalaSupport._umlBuilder)
  
  object UseCase {
    def apply(): UseCase = {
      UMLPackageScalaSupport._umlBuilder.create[UseCase]
    }
  }
  
  implicit class UseCaseScalaSupport(that: UseCase) {
    def extend: EList[Extend] = that.getExtends
    def extensionPoint: EList[ExtensionPoint] = that.getExtensionPoints
    def include: EList[Include] = that.getIncludes
    def subject: EList[Classifier] = that.getSubjects
  }
}

object UseCaseScalaSupport extends UseCaseScalaSupport

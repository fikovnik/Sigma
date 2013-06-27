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
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait EnumerationScalaSupport extends EMFScalaSupport {
  type Enumeration = org.eclipse.uml2.uml.Enumeration
  
  protected implicit val _enumerationProxyBuilder = new EMFProxyBuilder[Enumeration](UMLPackageScalaSupport._umlBuilder)
  
  object Enumeration {
    def apply(): Enumeration = {
      UMLPackageScalaSupport._umlBuilder.create[Enumeration]
    }
  }
  
  implicit class EnumerationScalaSupport(that: Enumeration) {
    def ownedLiteral: EList[EnumerationLiteral] = that.getOwnedLiterals
  }
}

object EnumerationScalaSupport extends EnumerationScalaSupport

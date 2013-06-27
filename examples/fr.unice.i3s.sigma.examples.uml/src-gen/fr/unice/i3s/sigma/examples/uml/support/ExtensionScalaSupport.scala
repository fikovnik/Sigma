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
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait ExtensionScalaSupport extends EMFScalaSupport {
  type Extension = org.eclipse.uml2.uml.Extension
  
  protected implicit val _extensionProxyBuilder = new EMFProxyBuilder[Extension](UMLPackageScalaSupport._umlBuilder)
  
  object Extension {
    def apply(): Extension = {
      UMLPackageScalaSupport._umlBuilder.create[Extension]
    }
  }
  
  implicit class ExtensionScalaSupport(that: Extension) {
    def isRequired: Boolean = that.isRequired
    def metaclass: org.eclipse.uml2.uml.Class = that.getMetaclass
  }
}

object ExtensionScalaSupport extends ExtensionScalaSupport

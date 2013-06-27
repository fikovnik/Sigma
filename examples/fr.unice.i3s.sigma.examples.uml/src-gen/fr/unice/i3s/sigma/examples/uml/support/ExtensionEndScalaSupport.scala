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
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait ExtensionEndScalaSupport extends EMFScalaSupport {
  type ExtensionEnd = org.eclipse.uml2.uml.ExtensionEnd
  
  protected implicit val _extensionendProxyBuilder = new EMFProxyBuilder[ExtensionEnd](UMLPackageScalaSupport._umlBuilder)
  
  object ExtensionEnd {
    def apply(): ExtensionEnd = {
      UMLPackageScalaSupport._umlBuilder.create[ExtensionEnd]
    }
  }
}

object ExtensionEndScalaSupport extends ExtensionEndScalaSupport

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
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait InformationItemScalaSupport extends EMFScalaSupport {
  type InformationItem = org.eclipse.uml2.uml.InformationItem
  
  protected implicit val _informationitemProxyBuilder = new EMFProxyBuilder[InformationItem](UMLPackageScalaSupport._umlBuilder)
  
  object InformationItem {
    def apply(): InformationItem = {
      UMLPackageScalaSupport._umlBuilder.create[InformationItem]
    }
  }
  
  implicit class InformationItemScalaSupport(that: InformationItem) {
    def represented: EList[Classifier] = that.getRepresenteds
  }
}

object InformationItemScalaSupport extends InformationItemScalaSupport

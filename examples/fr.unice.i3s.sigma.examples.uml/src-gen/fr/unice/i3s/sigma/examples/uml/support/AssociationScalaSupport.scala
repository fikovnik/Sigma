package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

trait AssociationScalaSupport extends EMFScalaSupport {
  type Association = org.eclipse.uml2.uml.Association
  
  protected implicit val _associationProxyBuilder = new EMFProxyBuilder[Association](UMLPackageScalaSupport._umlBuilder)
  
  object Association {
    def apply(): Association = {
      UMLPackageScalaSupport._umlBuilder.create[Association]
    }
  }
  
  implicit class AssociationScalaSupport(that: Association) {
    def endType: EList[Type] = that.getEndTypes
    def isDerived: Boolean = that.isDerived
    def isDerived_=(value: Boolean): Unit = that.setIsDerived(value)
    def memberEnd: EList[Property] = that.getMemberEnds
    def ownedEnd: EList[Property] = that.getOwnedEnds
    def navigableOwnedEnd: EList[Property] = that.getNavigableOwnedEnds
  }
}

object AssociationScalaSupport extends AssociationScalaSupport

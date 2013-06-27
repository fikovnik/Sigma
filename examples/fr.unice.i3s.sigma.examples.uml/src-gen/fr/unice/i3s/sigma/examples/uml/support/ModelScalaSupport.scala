package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.VisibilityKind;

trait ModelScalaSupport extends EMFScalaSupport {
  type Model = org.eclipse.uml2.uml.Model
  
  protected implicit val _modelProxyBuilder = new EMFProxyBuilder[Model](UMLPackageScalaSupport._umlBuilder)
  
  object Model {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, templateParameter: TemplateParameter = null, ownedTemplateSignature: TemplateSignature = null, templateBinding: EList[TemplateBinding] = null, URI: String = null, packageMerge: EList[PackageMerge] = null, packagedElement: EList[PackageableElement] = null, profileApplication: EList[ProfileApplication] = null, viewpoint: String = null): Model = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Model]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (elementImport != null) _instance.getElementImports.addAll(elementImport)
      if (packageImport != null) _instance.getPackageImports.addAll(packageImport)
      if (ownedRule != null) _instance.getOwnedRules.addAll(ownedRule)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (ownedTemplateSignature != null) _instance.setOwnedTemplateSignature(ownedTemplateSignature)
      if (templateBinding != null) _instance.getTemplateBindings.addAll(templateBinding)
      if (URI != null) _instance.setURI(URI)
      if (packageMerge != null) _instance.getPackageMerges.addAll(packageMerge)
      if (packagedElement != null) _instance.getPackagedElements.addAll(packagedElement)
      if (profileApplication != null) _instance.getProfileApplications.addAll(profileApplication)
      if (viewpoint != null) _instance.setViewpoint(viewpoint)
      
      _instance
    }
  }
  
  implicit class ModelScalaSupport(that: Model) {
    def viewpoint: String = that.getViewpoint
    def viewpoint_=(value: String): Unit = that.setViewpoint(value)
  }
}

object ModelScalaSupport extends ModelScalaSupport

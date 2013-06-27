package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

trait RedefinableTemplateSignatureScalaSupport extends EMFScalaSupport {
  type RedefinableTemplateSignature = org.eclipse.uml2.uml.RedefinableTemplateSignature
  
  protected implicit val _redefinabletemplatesignatureProxyBuilder = new EMFProxyBuilder[RedefinableTemplateSignature](UMLPackageScalaSupport._umlBuilder)
  
  object RedefinableTemplateSignature {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, ownedParameter: EList[TemplateParameter] = null, parameter: EList[TemplateParameter] = null, extendedSignature: EList[RedefinableTemplateSignature] = null): RedefinableTemplateSignature = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[RedefinableTemplateSignature]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (ownedParameter != null) _instance.getOwnedParameters.addAll(ownedParameter)
      if (parameter != null) _instance.getParameters.addAll(parameter)
      if (extendedSignature != null) _instance.getExtendedSignatures.addAll(extendedSignature)
      
      _instance
    }
  }
  
  implicit class RedefinableTemplateSignatureScalaSupport(that: RedefinableTemplateSignature) {
    def extendedSignature: EList[RedefinableTemplateSignature] = that.getExtendedSignatures
    def inheritedParameter: EList[TemplateParameter] = that.getInheritedParameters
    def classifier: Classifier = that.getClassifier
  }
}

object RedefinableTemplateSignatureScalaSupport extends RedefinableTemplateSignatureScalaSupport

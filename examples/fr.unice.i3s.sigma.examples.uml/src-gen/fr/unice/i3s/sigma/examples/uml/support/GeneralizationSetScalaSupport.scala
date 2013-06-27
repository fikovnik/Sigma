package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait GeneralizationSetScalaSupport extends EMFScalaSupport {
  type GeneralizationSet = org.eclipse.uml2.uml.GeneralizationSet
  
  protected implicit val _generalizationsetProxyBuilder = new EMFProxyBuilder[GeneralizationSet](UMLPackageScalaSupport._umlBuilder)
  
  object GeneralizationSet {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, isCovering: Boolean = false, isDisjoint: Boolean = false, powertype: Classifier = null, generalization: EList[Generalization] = null): GeneralizationSet = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[GeneralizationSet]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (isCovering != false) _instance.setIsCovering(isCovering)
      if (isDisjoint != false) _instance.setIsDisjoint(isDisjoint)
      if (powertype != null) _instance.setPowertype(powertype)
      if (generalization != null) _instance.getGeneralizations.addAll(generalization)
      
      _instance
    }
  }
  
  implicit class GeneralizationSetScalaSupport(that: GeneralizationSet) {
    def isCovering: Boolean = that.isCovering
    def isCovering_=(value: Boolean): Unit = that.setIsCovering(value)
    def isDisjoint: Boolean = that.isDisjoint
    def isDisjoint_=(value: Boolean): Unit = that.setIsDisjoint(value)
    def powertype: Classifier = that.getPowertype
    def powertype_=(value: Classifier): Unit = that.setPowertype(value)
    def powertype_=(value: ⇒ Option[Classifier]): Unit =
      that.setPowertype(UMLPackageScalaSupport._umlBuilder.ref(value))
    def generalization: EList[Generalization] = that.getGeneralizations
  }
}

object GeneralizationSetScalaSupport extends GeneralizationSetScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait FeatureScalaSupport extends EMFScalaSupport {
  type Feature = org.eclipse.uml2.uml.Feature
  
  protected implicit val _featureProxyBuilder = new EMFProxyBuilder[Feature](UMLPackageScalaSupport._umlBuilder)
  
  object Feature {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, static: Boolean = false): Feature = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Feature]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (static != false) _instance.setIsStatic(static)
      
      _instance
    }
  }
  
  implicit class FeatureScalaSupport(that: Feature) {
    def featuringClassifier: EList[Classifier] = that.getFeaturingClassifiers
    def static: Boolean = that.isStatic
    def static_=(value: Boolean): Unit = that.setIsStatic(value)
  }
}

object FeatureScalaSupport extends FeatureScalaSupport

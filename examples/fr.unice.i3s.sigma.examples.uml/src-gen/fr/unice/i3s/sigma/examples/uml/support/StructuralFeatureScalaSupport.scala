package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

trait StructuralFeatureScalaSupport extends EMFScalaSupport {
  type StructuralFeature = org.eclipse.uml2.uml.StructuralFeature
  
  protected implicit val _structuralfeatureProxyBuilder = new EMFProxyBuilder[StructuralFeature](UMLPackageScalaSupport._umlBuilder)
  
  object StructuralFeature {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false, static: Boolean = false, type_ : Type = null, isOrdered: Boolean = false, isUnique: Boolean = true, lowerValue: ValueSpecification = null, upperValue: ValueSpecification = null, isReadOnly: Boolean = false): StructuralFeature = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[StructuralFeature]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (static != false) _instance.setIsStatic(static)
      if (type_  != null) _instance.setType(type_ )
      if (isOrdered != false) _instance.setIsOrdered(isOrdered)
      if (isUnique != true) _instance.setIsUnique(isUnique)
      if (lowerValue != null) _instance.setLowerValue(lowerValue)
      if (upperValue != null) _instance.setUpperValue(upperValue)
      if (isReadOnly != false) _instance.setIsReadOnly(isReadOnly)
      
      _instance
    }
  }
  
  implicit class StructuralFeatureScalaSupport(that: StructuralFeature) {
    def isReadOnly: Boolean = that.isReadOnly
    def isReadOnly_=(value: Boolean): Unit = that.setIsReadOnly(value)
  }
}

object StructuralFeatureScalaSupport extends StructuralFeatureScalaSupport

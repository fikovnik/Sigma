package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ExtensionPointScalaSupport extends EMFScalaSupport {
  type ExtensionPoint = org.eclipse.uml2.uml.ExtensionPoint
  
  protected implicit val _extensionpointProxyBuilder = new EMFProxyBuilder[ExtensionPoint](UMLPackageScalaSupport._umlBuilder)
  
  object ExtensionPoint {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isLeaf: Boolean = false): ExtensionPoint = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ExtensionPoint]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      
      _instance
    }
  }
  
  implicit class ExtensionPointScalaSupport(that: ExtensionPoint) {
    def useCase: UseCase = that.getUseCase
    def useCase_=(value: UseCase): Unit = that.setUseCase(value)
    def useCase_=(value: ⇒ Option[UseCase]): Unit =
      that.setUseCase(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ExtensionPointScalaSupport extends ExtensionPointScalaSupport

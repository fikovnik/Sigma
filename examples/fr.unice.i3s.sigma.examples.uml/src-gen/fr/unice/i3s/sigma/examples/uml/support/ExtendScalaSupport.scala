package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ExtendScalaSupport extends EMFScalaSupport {
  type Extend = org.eclipse.uml2.uml.Extend
  
  protected implicit val _extendProxyBuilder = new EMFProxyBuilder[Extend](UMLPackageScalaSupport._umlBuilder)
  
  object Extend {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, condition: Constraint = null, extendedCase: UseCase = null, extensionLocation: EList[ExtensionPoint] = null): Extend = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Extend]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (condition != null) _instance.setCondition(condition)
      if (extendedCase != null) _instance.setExtendedCase(extendedCase)
      if (extensionLocation != null) _instance.getExtensionLocations.addAll(extensionLocation)
      
      _instance
    }
  }
  
  implicit class ExtendScalaSupport(that: Extend) {
    def condition: Constraint = that.getCondition
    def condition_=(value: Constraint): Unit = that.setCondition(value)
    def extendedCase: UseCase = that.getExtendedCase
    def extendedCase_=(value: UseCase): Unit = that.setExtendedCase(value)
    def extendedCase_=(value: ⇒ Option[UseCase]): Unit =
      that.setExtendedCase(UMLPackageScalaSupport._umlBuilder.ref(value))
    def extensionLocation: EList[ExtensionPoint] = that.getExtensionLocations
    def extension: UseCase = that.getExtension
    def extension_=(value: UseCase): Unit = that.setExtension(value)
    def extension_=(value: ⇒ Option[UseCase]): Unit =
      that.setExtension(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ExtendScalaSupport extends ExtendScalaSupport

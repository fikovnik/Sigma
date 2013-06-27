package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait CollaborationUseScalaSupport extends EMFScalaSupport {
  type CollaborationUse = org.eclipse.uml2.uml.CollaborationUse
  
  protected implicit val _collaborationuseProxyBuilder = new EMFProxyBuilder[CollaborationUse](UMLPackageScalaSupport._umlBuilder)
  
  object CollaborationUse {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, roleBinding: EList[Dependency] = null, type_ : Collaboration = null): CollaborationUse = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[CollaborationUse]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (roleBinding != null) _instance.getRoleBindings.addAll(roleBinding)
      if (type_  != null) _instance.setType(type_ )
      
      _instance
    }
  }
  
  implicit class CollaborationUseScalaSupport(that: CollaborationUse) {
    def roleBinding: EList[Dependency] = that.getRoleBindings
    def type_ : Collaboration = that.getType
    def type__=(value: Collaboration): Unit = that.setType(value)
    def type__=(value: ⇒ Option[Collaboration]): Unit =
      that.setType(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object CollaborationUseScalaSupport extends CollaborationUseScalaSupport

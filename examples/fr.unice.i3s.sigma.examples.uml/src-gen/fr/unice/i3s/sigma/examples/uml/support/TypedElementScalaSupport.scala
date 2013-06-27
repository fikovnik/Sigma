package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait TypedElementScalaSupport extends EMFScalaSupport {
  type TypedElement = org.eclipse.uml2.uml.TypedElement
  
  protected implicit val _typedelementProxyBuilder = new EMFProxyBuilder[TypedElement](UMLPackageScalaSupport._umlBuilder)
  
  object TypedElement {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, type_ : Type = null): TypedElement = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[TypedElement]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (type_  != null) _instance.setType(type_ )
      
      _instance
    }
  }
  
  implicit class TypedElementScalaSupport(that: TypedElement) {
    def type_ : Type = that.getType
    def type__=(value: Type): Unit = that.setType(value)
    def type__=(value: ⇒ Option[Type]): Unit =
      that.setType(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object TypedElementScalaSupport extends TypedElementScalaSupport

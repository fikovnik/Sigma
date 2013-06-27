package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait IncludeScalaSupport extends EMFScalaSupport {
  type Include = org.eclipse.uml2.uml.Include
  
  protected implicit val _includeProxyBuilder = new EMFProxyBuilder[Include](UMLPackageScalaSupport._umlBuilder)
  
  object Include {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, addition: UseCase = null): Include = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Include]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (addition != null) _instance.setAddition(addition)
      
      _instance
    }
  }
  
  implicit class IncludeScalaSupport(that: Include) {
    def addition: UseCase = that.getAddition
    def addition_=(value: UseCase): Unit = that.setAddition(value)
    def addition_=(value: ⇒ Option[UseCase]): Unit =
      that.setAddition(UMLPackageScalaSupport._umlBuilder.ref(value))
    def includingCase: UseCase = that.getIncludingCase
    def includingCase_=(value: UseCase): Unit = that.setIncludingCase(value)
    def includingCase_=(value: ⇒ Option[UseCase]): Unit =
      that.setIncludingCase(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object IncludeScalaSupport extends IncludeScalaSupport

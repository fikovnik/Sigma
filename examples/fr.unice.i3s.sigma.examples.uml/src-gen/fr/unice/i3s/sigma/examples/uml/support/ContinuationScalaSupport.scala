package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait ContinuationScalaSupport extends EMFScalaSupport {
  type Continuation = org.eclipse.uml2.uml.Continuation
  
  protected implicit val _continuationProxyBuilder = new EMFProxyBuilder[Continuation](UMLPackageScalaSupport._umlBuilder)
  
  object Continuation {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, covered: EList[Lifeline] = null, generalOrdering: EList[GeneralOrdering] = null, setting: Boolean = true): Continuation = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Continuation]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (covered != null) _instance.getCovereds.addAll(covered)
      if (generalOrdering != null) _instance.getGeneralOrderings.addAll(generalOrdering)
      if (setting != true) _instance.setSetting(setting)
      
      _instance
    }
  }
  
  implicit class ContinuationScalaSupport(that: Continuation) {
    def setting: Boolean = that.isSetting
    def setting_=(value: Boolean): Unit = that.setSetting(value)
  }
}

object ContinuationScalaSupport extends ContinuationScalaSupport

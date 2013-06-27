package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

trait DeploymentTargetScalaSupport extends EMFScalaSupport {
  type DeploymentTarget = org.eclipse.uml2.uml.DeploymentTarget
  
  protected implicit val _deploymenttargetProxyBuilder = new EMFProxyBuilder[DeploymentTarget](UMLPackageScalaSupport._umlBuilder)
  
  object DeploymentTarget {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, deployment: EList[Deployment] = null): DeploymentTarget = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[DeploymentTarget]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (deployment != null) _instance.getDeployments.addAll(deployment)
      
      _instance
    }
  }
  
  implicit class DeploymentTargetScalaSupport(that: DeploymentTarget) {
    def deployedElement: EList[PackageableElement] = that.getDeployedElements
    def deployment: EList[Deployment] = that.getDeployments
  }
}

object DeploymentTargetScalaSupport extends DeploymentTargetScalaSupport

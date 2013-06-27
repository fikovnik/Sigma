package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ActivityGroupScalaSupport extends EMFScalaSupport {
  type ActivityGroup = org.eclipse.uml2.uml.ActivityGroup
  
  protected implicit val _activitygroupProxyBuilder = new EMFProxyBuilder[ActivityGroup](UMLPackageScalaSupport._umlBuilder)
  
  object ActivityGroup {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL): ActivityGroup = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ActivityGroup]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      
      _instance
    }
  }
  
  implicit class ActivityGroupScalaSupport(that: ActivityGroup) {
    def containedEdge: EList[ActivityEdge] = that.getContainedEdges
    def containedNode: EList[ActivityNode] = that.getContainedNodes
    def inActivity: Activity = that.getInActivity
    def inActivity_=(value: Activity): Unit = that.setInActivity(value)
    def inActivity_=(value: ⇒ Option[Activity]): Unit =
      that.setInActivity(UMLPackageScalaSupport._umlBuilder.ref(value))
    def subgroup: EList[ActivityGroup] = that.getSubgroups
    def superGroup: ActivityGroup = that.getSuperGroup
  }
}

object ActivityGroupScalaSupport extends ActivityGroupScalaSupport

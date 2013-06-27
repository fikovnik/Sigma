package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ActivityPartitionScalaSupport extends EMFScalaSupport {
  type ActivityPartition = org.eclipse.uml2.uml.ActivityPartition
  
  protected implicit val _activitypartitionProxyBuilder = new EMFProxyBuilder[ActivityPartition](UMLPackageScalaSupport._umlBuilder)
  
  object ActivityPartition {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, isDimension: Boolean = false, isExternal: Boolean = false, node: EList[ActivityNode] = null, represents: Element = null, subpartition: EList[ActivityPartition] = null, edge: EList[ActivityEdge] = null): ActivityPartition = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ActivityPartition]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (isDimension != false) _instance.setIsDimension(isDimension)
      if (isExternal != false) _instance.setIsExternal(isExternal)
      if (node != null) _instance.getNodes.addAll(node)
      if (represents != null) _instance.setRepresents(represents)
      if (subpartition != null) _instance.getSubpartitions.addAll(subpartition)
      if (edge != null) _instance.getEdges.addAll(edge)
      
      _instance
    }
  }
  
  implicit class ActivityPartitionScalaSupport(that: ActivityPartition) {
    def isDimension: Boolean = that.isDimension
    def isDimension_=(value: Boolean): Unit = that.setIsDimension(value)
    def isExternal: Boolean = that.isExternal
    def isExternal_=(value: Boolean): Unit = that.setIsExternal(value)
    def node: EList[ActivityNode] = that.getNodes
    def represents: Element = that.getRepresents
    def represents_=(value: Element): Unit = that.setRepresents(value)
    def represents_=(value: ⇒ Option[Element]): Unit =
      that.setRepresents(UMLPackageScalaSupport._umlBuilder.ref(value))
    def subpartition: EList[ActivityPartition] = that.getSubpartitions
    def superPartition: ActivityPartition = that.getSuperPartition
    def superPartition_=(value: ActivityPartition): Unit = that.setSuperPartition(value)
    def superPartition_=(value: ⇒ Option[ActivityPartition]): Unit =
      that.setSuperPartition(UMLPackageScalaSupport._umlBuilder.ref(value))
    def edge: EList[ActivityEdge] = that.getEdges
  }
}

object ActivityPartitionScalaSupport extends ActivityPartitionScalaSupport

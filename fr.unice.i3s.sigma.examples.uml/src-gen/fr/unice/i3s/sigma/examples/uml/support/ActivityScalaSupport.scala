package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Variable;

trait ActivityScalaSupport {
  implicit class ActivityScalaSupport(that: Activity) {
    def ownedGroup: EList[ActivityGroup] = that.getOwnedGroups
    def edge: EList[ActivityEdge] = that.getEdges
    def variable: EList[Variable] = that.getVariables
    def group: EList[ActivityGroup] = that.getGroups
    def ownedNode: EList[ActivityNode] = that.getOwnedNodes
    def isReadOnly: Boolean = that.isReadOnly
    def isReadOnly_=(value: Boolean): Unit = that.setIsReadOnly(value)
    def isSingleExecution: Boolean = that.isSingleExecution
    def isSingleExecution_=(value: Boolean): Unit = that.setIsSingleExecution(value)
    def partition: EList[ActivityPartition] = that.getPartitions
    def structuredNode: EList[StructuredActivityNode] = that.getStructuredNodes
    def node: EList[ActivityNode] = that.getNodes
  }
}

object ActivityScalaSupport extends ActivityScalaSupport

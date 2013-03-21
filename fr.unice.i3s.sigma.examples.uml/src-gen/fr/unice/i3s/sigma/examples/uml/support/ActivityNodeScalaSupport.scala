package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StructuredActivityNode;

trait ActivityNodeScalaSupport {
  implicit class ActivityNodeScalaSupport(that: ActivityNode) {
    def activity: Activity = that.getActivity
    def activity_=(value: Activity): Unit = that.setActivity(value)
    def inPartition: EList[ActivityPartition] = that.getInPartitions
    def inStructuredNode: StructuredActivityNode = that.getInStructuredNode
    def inStructuredNode_=(value: StructuredActivityNode): Unit = that.setInStructuredNode(value)
    def inInterruptibleRegion: EList[InterruptibleActivityRegion] = that.getInInterruptibleRegions
    def outgoing: EList[ActivityEdge] = that.getOutgoings
    def incoming: EList[ActivityEdge] = that.getIncomings
    def inGroup: EList[ActivityGroup] = that.getInGroups
    def redefinedNode: EList[ActivityNode] = that.getRedefinedNodes
  }
}

object ActivityNodeScalaSupport extends ActivityNodeScalaSupport

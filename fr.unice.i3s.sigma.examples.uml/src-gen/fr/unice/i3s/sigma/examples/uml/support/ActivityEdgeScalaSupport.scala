package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.ValueSpecification;

trait ActivityEdgeScalaSupport {
  implicit class ActivityEdgeScalaSupport(that: ActivityEdge) {
    def activity: Activity = that.getActivity
    def activity_=(value: Activity): Unit = that.setActivity(value)
    def guard: ValueSpecification = that.getGuard
    def guard_=(value: ValueSpecification): Unit = that.setGuard(value)
    def inPartition: EList[ActivityPartition] = that.getInPartitions
    def inStructuredNode: StructuredActivityNode = that.getInStructuredNode
    def inStructuredNode_=(value: StructuredActivityNode): Unit = that.setInStructuredNode(value)
    def interrupts: InterruptibleActivityRegion = that.getInterrupts
    def interrupts_=(value: InterruptibleActivityRegion): Unit = that.setInterrupts(value)
    def redefinedEdge: EList[ActivityEdge] = that.getRedefinedEdges
    def source: ActivityNode = that.getSource
    def source_=(value: ActivityNode): Unit = that.setSource(value)
    def target: ActivityNode = that.getTarget
    def target_=(value: ActivityNode): Unit = that.setTarget(value)
    def weight: ValueSpecification = that.getWeight
    def weight_=(value: ValueSpecification): Unit = that.setWeight(value)
    def inGroup: EList[ActivityGroup] = that.getInGroups
  }
}

object ActivityEdgeScalaSupport extends ActivityEdgeScalaSupport

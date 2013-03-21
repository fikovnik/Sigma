package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;

trait ActivityGroupScalaSupport {
  implicit class ActivityGroupScalaSupport(that: ActivityGroup) {
    def containedEdge: EList[ActivityEdge] = that.getContainedEdges
    def containedNode: EList[ActivityNode] = that.getContainedNodes
    def inActivity: Activity = that.getInActivity
    def inActivity_=(value: Activity): Unit = that.setInActivity(value)
    def subgroup: EList[ActivityGroup] = that.getSubgroups
    def superGroup: ActivityGroup = that.getSuperGroup
  }
}

object ActivityGroupScalaSupport extends ActivityGroupScalaSupport

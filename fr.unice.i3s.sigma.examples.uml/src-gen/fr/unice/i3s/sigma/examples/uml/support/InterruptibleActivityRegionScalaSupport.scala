package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;

trait InterruptibleActivityRegionScalaSupport {
  implicit class InterruptibleActivityRegionScalaSupport(that: InterruptibleActivityRegion) {
    def node: EList[ActivityNode] = that.getNodes
    def interruptingEdge: EList[ActivityEdge] = that.getInterruptingEdges
  }
}

object InterruptibleActivityRegionScalaSupport extends InterruptibleActivityRegionScalaSupport

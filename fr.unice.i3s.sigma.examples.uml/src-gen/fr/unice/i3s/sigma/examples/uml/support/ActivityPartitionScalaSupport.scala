package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Element;

trait ActivityPartitionScalaSupport {
  implicit class ActivityPartitionScalaSupport(that: ActivityPartition) {
    def isDimension: Boolean = that.isDimension
    def isDimension_=(value: Boolean): Unit = that.setIsDimension(value)
    def isExternal: Boolean = that.isExternal
    def isExternal_=(value: Boolean): Unit = that.setIsExternal(value)
    def node: EList[ActivityNode] = that.getNodes
    def represents: Element = that.getRepresents
    def represents_=(value: Element): Unit = that.setRepresents(value)
    def subpartition: EList[ActivityPartition] = that.getSubpartitions
    def superPartition: ActivityPartition = that.getSuperPartition
    def superPartition_=(value: ActivityPartition): Unit = that.setSuperPartition(value)
    def edge: EList[ActivityEdge] = that.getEdges
  }
}

object ActivityPartitionScalaSupport extends ActivityPartitionScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;

trait VertexScalaSupport {
  implicit class VertexScalaSupport(that: Vertex) {
    def container: Region = that.getContainer
    def container_=(value: Region): Unit = that.setContainer(value)
    def incoming: EList[Transition] = that.getIncomings
    def outgoing: EList[Transition] = that.getOutgoings
  }
}

object VertexScalaSupport extends VertexScalaSupport

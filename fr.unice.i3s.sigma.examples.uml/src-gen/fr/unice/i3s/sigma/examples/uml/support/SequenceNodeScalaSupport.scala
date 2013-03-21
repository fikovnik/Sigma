package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.SequenceNode;

trait SequenceNodeScalaSupport {
  implicit class SequenceNodeScalaSupport(that: SequenceNode) {
    def executableNode: EList[ExecutableNode] = that.getExecutableNodes
  }
}

object SequenceNodeScalaSupport extends SequenceNodeScalaSupport

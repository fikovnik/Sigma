package EER.support

import EER.AttributedNode;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AttributedNodeScalaSupport extends EMFScalaSupport {
  type AttributedNode = EER.AttributedNode
  
  object AttributedNode {
  }
}

object AttributedNodeScalaSupport extends AttributedNodeScalaSupport

package EER.support

import EER.Node;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait NodeScalaSupport extends EMFScalaSupport {
  type Node = EER.Node
  
  object Node {
  }
}

object NodeScalaSupport extends NodeScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Node;

trait NodeScalaSupport {
  implicit class NodeScalaSupport(that: Node) {
    def nestedNode: EList[Node] = that.getNestedNodes
  }
}

object NodeScalaSupport extends NodeScalaSupport

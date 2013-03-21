package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.ValueSpecification;

trait JoinNodeScalaSupport {
  implicit class JoinNodeScalaSupport(that: JoinNode) {
    def isCombineDuplicate: Boolean = that.isCombineDuplicate
    def isCombineDuplicate_=(value: Boolean): Unit = that.setIsCombineDuplicate(value)
    def joinSpec: ValueSpecification = that.getJoinSpec
    def joinSpec_=(value: ValueSpecification): Unit = that.setJoinSpec(value)
  }
}

object JoinNodeScalaSupport extends JoinNodeScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;

trait DirectedRelationshipScalaSupport {
  implicit class DirectedRelationshipScalaSupport(that: DirectedRelationship) {
    def source: EList[Element] = that.getSources
    def target: EList[Element] = that.getTargets
  }
}

object DirectedRelationshipScalaSupport extends DirectedRelationshipScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Relationship;

trait RelationshipScalaSupport {
  implicit class RelationshipScalaSupport(that: Relationship) {
    def relatedElement: EList[Element] = that.getRelatedElements
  }
}

object RelationshipScalaSupport extends RelationshipScalaSupport

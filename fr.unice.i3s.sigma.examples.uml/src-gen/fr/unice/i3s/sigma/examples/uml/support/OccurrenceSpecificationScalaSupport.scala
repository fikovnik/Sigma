package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.OccurrenceSpecification;

trait OccurrenceSpecificationScalaSupport {
  implicit class OccurrenceSpecificationScalaSupport(that: OccurrenceSpecification) {
    def toAfter: EList[GeneralOrdering] = that.getToAfters
    def toBefore: EList[GeneralOrdering] = that.getToBefores
  }
}

object OccurrenceSpecificationScalaSupport extends OccurrenceSpecificationScalaSupport

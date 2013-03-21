package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

trait AssociationScalaSupport {
  implicit class AssociationScalaSupport(that: Association) {
    def endType: EList[Type] = that.getEndTypes
    def isDerived: Boolean = that.isDerived
    def isDerived_=(value: Boolean): Unit = that.setIsDerived(value)
    def memberEnd: EList[Property] = that.getMemberEnds
    def ownedEnd: EList[Property] = that.getOwnedEnds
    def navigableOwnedEnd: EList[Property] = that.getNavigableOwnedEnds
  }
}

object AssociationScalaSupport extends AssociationScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.ClearAssociationAction;
import org.eclipse.uml2.uml.InputPin;

trait ClearAssociationActionScalaSupport {
  implicit class ClearAssociationActionScalaSupport(that: ClearAssociationAction) {
    def association: Association = that.getAssociation
    def association_=(value: Association): Unit = that.setAssociation(value)
    def `object`: InputPin = that.getObject
    def object_=(value: InputPin): Unit = that.setObject(value)
  }
}

object ClearAssociationActionScalaSupport extends ClearAssociationActionScalaSupport

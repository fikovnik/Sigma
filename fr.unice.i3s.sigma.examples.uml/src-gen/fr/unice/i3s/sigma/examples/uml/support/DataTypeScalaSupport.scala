package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Property;

trait DataTypeScalaSupport {
  implicit class DataTypeScalaSupport(that: DataType) {
    def ownedAttribute: EList[Property] = that.getOwnedAttributes
    def ownedOperation: EList[Operation] = that.getOwnedOperations
  }
}

object DataTypeScalaSupport extends DataTypeScalaSupport

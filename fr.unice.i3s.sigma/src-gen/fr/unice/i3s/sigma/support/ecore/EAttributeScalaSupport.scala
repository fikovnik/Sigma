package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

trait EAttributeScalaSupport {
  implicit class EAttributeScalaSupport(that: EAttribute) {
    def iD: Boolean = that.isID
    def iD_=(value: Boolean): Unit = that.setID(value)
    def eAttributeType: EDataType = that.getEAttributeType
  }
}

object EAttributeScalaSupport extends EAttributeScalaSupport

package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

trait EAttributeScalaSupport {
  implicit class EAttributeScalaSupport(obj: EAttribute) {
    def iD: Boolean = obj.isID
    def iD_=(value: Boolean): Unit = obj.setID(value)
    def eAttributeType: EDataType = obj.getEAttributeType
  }
}

object EAttributeScalaSupport extends EAttributeScalaSupport

package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

trait EEnumLiteralScalaSupport {
  implicit class EEnumLiteralScalaSupport(that: EEnumLiteral) {
    def value: Int = that.getValue
    def value_=(value: Int): Unit = that.setValue(value)
    def instance: Enumerator = that.getInstance
    def instance_=(value: Enumerator): Unit = that.setInstance(value)
    def literal: String = that.getLiteral
    def literal_=(value: String): Unit = that.setLiteral(value)
    def eEnum: EEnum = that.getEEnum
  }
}

object EEnumLiteralScalaSupport extends EEnumLiteralScalaSupport

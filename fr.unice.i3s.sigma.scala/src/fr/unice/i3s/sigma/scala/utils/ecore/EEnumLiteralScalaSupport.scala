package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

trait EEnumLiteralScalaSupport {
  implicit class EEnumLiteralScalaSupport(obj: EEnumLiteral) {
    def value: Int = obj.getValue
    def value_=(value: Int): Unit = obj.setValue(value)
    def instance: Enumerator = obj.getInstance
    def instance_=(value: Enumerator): Unit = obj.setInstance(value)
    def literal: String = obj.getLiteral
    def literal_=(value: String): Unit = obj.setLiteral(value)
    def eEnum: EEnum = obj.getEEnum
  }
}

object EEnumLiteralScalaSupport extends EEnumLiteralScalaSupport

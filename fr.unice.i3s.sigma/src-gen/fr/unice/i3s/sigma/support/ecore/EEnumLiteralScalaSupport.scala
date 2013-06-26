package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

trait EEnumLiteralScalaSupport extends EMFScalaSupport {
  type EEnumLiteral = org.eclipse.emf.ecore.EEnumLiteral
  
  protected implicit val _eenumliteralProxyBuilder = new EMFProxyBuilder[EEnumLiteral](EcorePackageScalaSupport._ecoreBuilder)
  
  object EEnumLiteral {
    def apply(name: String = null, value: Int = 0, instance: Enumerator = null, literal: String = null): EEnumLiteral = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EEnumLiteral]
      
      if (name != null) instance.setName(name)
      if (value != 0) instance.setValue(value)
      if (instance != null) instance.setInstance(instance)
      if (literal != null) instance.setLiteral(literal)
      
      instance
    }
  }
  
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

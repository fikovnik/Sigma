package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

trait EEnumLiteralScalaSupport extends EMFScalaSupport {
  type EEnumLiteral = org.eclipse.emf.ecore.EEnumLiteral
  
  protected implicit val _eenumliteralProxyBuilder = new EMFProxyBuilder[EEnumLiteral](EcorePackageScalaSupport._ecoreBuilder)
  
  object EEnumLiteral {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, value: Int = 0, instance: Enumerator = null, literal: String = null): EEnumLiteral = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EEnumLiteral]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (value != 0) _instance.setValue(value)
      if (instance != null) _instance.setInstance(instance)
      if (literal != null) _instance.setLiteral(literal)
      
      _instance
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

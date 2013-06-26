package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

trait EEnumScalaSupport extends EMFScalaSupport {
  type EEnum = org.eclipse.emf.ecore.EEnum
  
  protected implicit val _eenumProxyBuilder = new EMFProxyBuilder[EEnum](EcorePackageScalaSupport._ecoreBuilder)
  
  object EEnum {
    def apply(name: String = null, instanceClassName: String = null, instanceTypeName: String = null, serializable: Boolean = true): EEnum = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EEnum]
      
      if (name != null) instance.setName(name)
      if (instanceClassName != null) instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) instance.setInstanceTypeName(instanceTypeName)
      if (serializable != true) instance.setSerializable(serializable)
      
      instance
    }
  }
  
  implicit class EEnumScalaSupport(that: EEnum) {
    def eLiterals: EList[EEnumLiteral] = that.getELiterals
  }
}

object EEnumScalaSupport extends EEnumScalaSupport

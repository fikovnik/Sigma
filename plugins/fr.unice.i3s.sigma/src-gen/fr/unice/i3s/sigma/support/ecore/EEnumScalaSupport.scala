package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.ETypeParameter;

trait EEnumScalaSupport extends EMFScalaSupport {
  type EEnum = org.eclipse.emf.ecore.EEnum
  
  protected implicit val _eenumProxyBuilder = new EMFProxyBuilder[EEnum](EcorePackageScalaSupport._ecoreBuilder)
  
  object EEnum {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, instanceClassName: String = null, instanceTypeName: String = null, eTypeParameters: EList[ETypeParameter] = null, serializable: Boolean = true, eLiterals: EList[EEnumLiteral] = null): EEnum = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EEnum]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (instanceClassName != null) _instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) _instance.setInstanceTypeName(instanceTypeName)
      if (eTypeParameters != null) _instance.getETypeParameters.addAll(eTypeParameters)
      if (serializable != true) _instance.setSerializable(serializable)
      if (eLiterals != null) _instance.getELiterals.addAll(eLiterals)
      
      _instance
    }
  }
}

object EEnumScalaSupport extends EEnumScalaSupport

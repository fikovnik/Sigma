package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ETypeParameter;

trait EDataTypeScalaSupport extends EMFScalaSupport {
  type EDataType = org.eclipse.emf.ecore.EDataType
  
  protected implicit val _edatatypeProxyBuilder = new EMFProxyBuilder[EDataType](EcorePackageScalaSupport._ecoreBuilder)
  
  object EDataType {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, instanceClassName: String = null, instanceTypeName: String = null, eTypeParameters: EList[ETypeParameter] = null, serializable: Boolean = true): EDataType = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EDataType]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (instanceClassName != null) _instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) _instance.setInstanceTypeName(instanceTypeName)
      if (eTypeParameters != null) _instance.getETypeParameters.addAll(eTypeParameters)
      if (serializable != true) _instance.setSerializable(serializable)
      
      _instance
    }
  }
}

object EDataTypeScalaSupport extends EDataTypeScalaSupport

package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EDataType;

trait EDataTypeScalaSupport extends EMFScalaSupport {
  type EDataType = org.eclipse.emf.ecore.EDataType
  
  protected implicit val _edatatypeProxyBuilder = new EMFProxyBuilder[EDataType](EcorePackageScalaSupport._ecoreBuilder)
  
  object EDataType {
    def apply(name: String = null, instanceClassName: String = null, instanceTypeName: String = null, serializable: Boolean = true): EDataType = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EDataType]
      
      if (name != null) instance.setName(name)
      if (instanceClassName != null) instance.setInstanceClassName(instanceClassName)
      if (instanceTypeName != null) instance.setInstanceTypeName(instanceTypeName)
      if (serializable != true) instance.setSerializable(serializable)
      
      instance
    }
  }
  
  implicit class EDataTypeScalaSupport(that: EDataType) {
    def serializable: Boolean = that.isSerializable
    def serializable_=(value: Boolean): Unit = that.setSerializable(value)
  }
}

object EDataTypeScalaSupport extends EDataTypeScalaSupport

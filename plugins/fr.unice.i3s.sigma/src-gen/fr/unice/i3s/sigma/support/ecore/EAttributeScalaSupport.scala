package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;

trait EAttributeScalaSupport extends EMFScalaSupport {
  type EAttribute = org.eclipse.emf.ecore.EAttribute
  
  protected implicit val _eattributeProxyBuilder = new EMFProxyBuilder[EAttribute](EcorePackageScalaSupport._ecoreBuilder)
  
  object EAttribute {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, eType: EClassifier = null, eGenericType: EGenericType = null, changeable: Boolean = true, volatile: Boolean = false, transient: Boolean = false, defaultValueLiteral: String = null, unsettable: Boolean = false, derived: Boolean = false, iD: Boolean = false): EAttribute = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EAttribute]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (name != null) _instance.setName(name)
      if (ordered != true) _instance.setOrdered(ordered)
      if (unique != true) _instance.setUnique(unique)
      if (lowerBound != 0) _instance.setLowerBound(lowerBound)
      if (upperBound != 1) _instance.setUpperBound(upperBound)
      if (eType != null) _instance.setEType(eType)
      if (eGenericType != null) _instance.setEGenericType(eGenericType)
      if (changeable != true) _instance.setChangeable(changeable)
      if (volatile != false) _instance.setVolatile(volatile)
      if (transient != false) _instance.setTransient(transient)
      if (defaultValueLiteral != null) _instance.setDefaultValueLiteral(defaultValueLiteral)
      if (unsettable != false) _instance.setUnsettable(unsettable)
      if (derived != false) _instance.setDerived(derived)
      if (iD != false) _instance.setID(iD)
      
      _instance
    }
  }
  
  implicit class EAttributeScalaSupport(that: EAttribute) {
    def iD: Boolean = that.isID
    def iD_=(value: Boolean): Unit = that.setID(value)
    def eAttributeType: EDataType = that.getEAttributeType
  }
}

object EAttributeScalaSupport extends EAttributeScalaSupport

package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EDataType;

trait EAttributeScalaSupport extends EMFScalaSupport {
  type EAttribute = org.eclipse.emf.ecore.EAttribute
  
  protected implicit val _eattributeProxyBuilder = new EMFProxyBuilder[EAttribute](EcorePackageScalaSupport._ecoreBuilder)
  
  object EAttribute {
    def apply(name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, changeable: Boolean = true, volatile: Boolean = false, transient: Boolean = false, defaultValueLiteral: String = null, unsettable: Boolean = false, derived: Boolean = false, iD: Boolean = false): EAttribute = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EAttribute]
      
      if (name != null) instance.setName(name)
      if (ordered != true) instance.setOrdered(ordered)
      if (unique != true) instance.setUnique(unique)
      if (lowerBound != 0) instance.setLowerBound(lowerBound)
      if (upperBound != 1) instance.setUpperBound(upperBound)
      if (changeable != true) instance.setChangeable(changeable)
      if (volatile != false) instance.setVolatile(volatile)
      if (transient != false) instance.setTransient(transient)
      if (defaultValueLiteral != null) instance.setDefaultValueLiteral(defaultValueLiteral)
      if (unsettable != false) instance.setUnsettable(unsettable)
      if (derived != false) instance.setDerived(derived)
      if (iD != false) instance.setID(iD)
      
      instance
    }
  }
  
  implicit class EAttributeScalaSupport(that: EAttribute) {
    def iD: Boolean = that.isID
    def iD_=(value: Boolean): Unit = that.setID(value)
    def eAttributeType: EDataType = that.getEAttributeType
  }
}

object EAttributeScalaSupport extends EAttributeScalaSupport

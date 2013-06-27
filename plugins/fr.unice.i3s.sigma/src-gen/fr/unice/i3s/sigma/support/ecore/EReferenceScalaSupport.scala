package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

import scala.Option;

trait EReferenceScalaSupport extends EMFScalaSupport {
  type EReference = org.eclipse.emf.ecore.EReference
  
  protected implicit val _ereferenceProxyBuilder = new EMFProxyBuilder[EReference](EcorePackageScalaSupport._ecoreBuilder)
  
  object EReference {
    def apply(name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, changeable: Boolean = true, volatile: Boolean = false, transient: Boolean = false, defaultValueLiteral: String = null, unsettable: Boolean = false, derived: Boolean = false, containment: Boolean = false, resolveProxies: Boolean = true): EReference = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EReference]
      
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
      if (containment != false) instance.setContainment(containment)
      if (resolveProxies != true) instance.setResolveProxies(resolveProxies)
      
      instance
    }
  }
  
  implicit class EReferenceScalaSupport(that: EReference) {
    def containment: Boolean = that.isContainment
    def containment_=(value: Boolean): Unit = that.setContainment(value)
    def container: Boolean = that.isContainer
    def resolveProxies: Boolean = that.isResolveProxies
    def resolveProxies_=(value: Boolean): Unit = that.setResolveProxies(value)
    def eOpposite: EReference = that.getEOpposite
    def eOpposite_=(value: EReference): Unit = that.setEOpposite(value)
    def eOpposite_=(value: ⇒ Option[EReference]): Unit =
      that.setEOpposite(EcorePackageScalaSupport._ecoreBuilder.ref(value))
    def eReferenceType: EClass = that.getEReferenceType
    def eKeys: EList[EAttribute] = that.getEKeys
  }
}

object EReferenceScalaSupport extends EReferenceScalaSupport

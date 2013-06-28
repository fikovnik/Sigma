package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EReference;

import scala.Option;

trait EReferenceScalaSupport extends EMFScalaSupport {
  type EReference = org.eclipse.emf.ecore.EReference
  
  protected implicit val _ereferenceProxyBuilder = new EMFProxyBuilder[EReference](EcorePackageScalaSupport._ecoreBuilder)
  
  object EReference {
    def apply(eAnnotations: EList[EAnnotation] = null, name: String = null, ordered: Boolean = true, unique: Boolean = true, lowerBound: Int = 0, upperBound: Int = 1, eType: EClassifier = null, eGenericType: EGenericType = null, changeable: Boolean = true, volatile: Boolean = false, transient: Boolean = false, defaultValueLiteral: String = null, unsettable: Boolean = false, derived: Boolean = false, containment: Boolean = false, resolveProxies: Boolean = true, eOpposite: EReference = null, eKeys: EList[EAttribute] = null): EReference = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EReference]
      
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
      if (containment != false) _instance.setContainment(containment)
      if (resolveProxies != true) _instance.setResolveProxies(resolveProxies)
      if (eOpposite != null) _instance.setEOpposite(eOpposite)
      if (eKeys != null) _instance.getEKeys.addAll(eKeys)
      
      _instance
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

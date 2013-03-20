package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

trait EReferenceScalaSupport {
  implicit class EReferenceScalaSupport(that: EReference) {
    def containment: Boolean = that.isContainment
    def containment_=(value: Boolean): Unit = that.setContainment(value)
    def container: Boolean = that.isContainer
    def resolveProxies: Boolean = that.isResolveProxies
    def resolveProxies_=(value: Boolean): Unit = that.setResolveProxies(value)
    def eOpposite: EReference = that.getEOpposite
    def eOpposite_=(value: EReference): Unit = that.setEOpposite(value)
    def eReferenceType: EClass = that.getEReferenceType
    def eKeys: EList[EAttribute] = that.getEKeys
  }
}

object EReferenceScalaSupport extends EReferenceScalaSupport

package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

trait EReferenceScalaSupport {
  implicit class EReferenceScalaSupport(obj: EReference) {
    def containment: Boolean = obj.isContainment
    def containment_=(value: Boolean): Unit = obj.setContainment(value)
    def container: Boolean = obj.isContainer
    def resolveProxies: Boolean = obj.isResolveProxies
    def resolveProxies_=(value: Boolean): Unit = obj.setResolveProxies(value)
    def eOpposite: EReference = obj.getEOpposite
    def eOpposite_=(value: EReference): Unit = obj.setEOpposite(value)
    def eReferenceType: EClass = obj.getEReferenceType
    def eKeys: EList[EAttribute] = obj.getEKeys
  }
}

object EReferenceScalaSupport extends EReferenceScalaSupport

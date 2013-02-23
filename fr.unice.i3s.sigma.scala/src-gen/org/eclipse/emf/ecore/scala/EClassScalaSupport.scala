package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

trait EClassScalaSupport {
  implicit class EClassScalaSupport(that: EClass) {
    def `abstract`: Boolean = that.isAbstract
    def abstract_=(value: Boolean): Unit = that.setAbstract(value)
    def interface: Boolean = that.isInterface
    def interface_=(value: Boolean): Unit = that.setInterface(value)
    def eSuperTypes: EList[EClass] = that.getESuperTypes
    def eOperations: EList[EOperation] = that.getEOperations
    def eAllAttributes: EList[EAttribute] = that.getEAllAttributes
    def eAllReferences: EList[EReference] = that.getEAllReferences
    def eReferences: EList[EReference] = that.getEReferences
    def eAttributes: EList[EAttribute] = that.getEAttributes
    def eAllContainments: EList[EReference] = that.getEAllContainments
    def eAllOperations: EList[EOperation] = that.getEAllOperations
    def eAllStructuralFeatures: EList[EStructuralFeature] = that.getEAllStructuralFeatures
    def eAllSuperTypes: EList[EClass] = that.getEAllSuperTypes
    def eIDAttribute: EAttribute = that.getEIDAttribute
    def eStructuralFeatures: EList[EStructuralFeature] = that.getEStructuralFeatures
    def eGenericSuperTypes: EList[EGenericType] = that.getEGenericSuperTypes
    def eAllGenericSuperTypes: EList[EGenericType] = that.getEAllGenericSuperTypes
  }
}

object EClassScalaSupport extends EClassScalaSupport

package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

trait EClassScalaSupport {
  implicit class EClassScalaSupport(obj: EClass) {
    def `abstract`: Boolean = obj.isAbstract
    def abstract_=(value: Boolean): Unit = obj.setAbstract(value)
    def interface: Boolean = obj.isInterface
    def interface_=(value: Boolean): Unit = obj.setInterface(value)
    def eSuperTypes: EList[EClass] = obj.getESuperTypes
    def eOperations: EList[EOperation] = obj.getEOperations
    def eAllAttributes: EList[EAttribute] = obj.getEAllAttributes
    def eAllReferences: EList[EReference] = obj.getEAllReferences
    def eReferences: EList[EReference] = obj.getEReferences
    def eAttributes: EList[EAttribute] = obj.getEAttributes
    def eAllContainments: EList[EReference] = obj.getEAllContainments
    def eAllOperations: EList[EOperation] = obj.getEAllOperations
    def eAllStructuralFeatures: EList[EStructuralFeature] = obj.getEAllStructuralFeatures
    def eAllSuperTypes: EList[EClass] = obj.getEAllSuperTypes
    def eIDAttribute: EAttribute = obj.getEIDAttribute
    def eStructuralFeatures: EList[EStructuralFeature] = obj.getEStructuralFeatures
    def eGenericSuperTypes: EList[EGenericType] = obj.getEGenericSuperTypes
    def eAllGenericSuperTypes: EList[EGenericType] = obj.getEAllGenericSuperTypes
  }
}

object EClassScalaSupport extends EClassScalaSupport

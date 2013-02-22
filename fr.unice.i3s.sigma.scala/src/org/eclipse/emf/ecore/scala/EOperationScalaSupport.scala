package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypeParameter;

trait EOperationScalaSupport {
  implicit class EOperationScalaSupport(obj: EOperation) {
    def eContainingClass: EClass = obj.getEContainingClass
    def eTypeParameters: EList[ETypeParameter] = obj.getETypeParameters
    def eParameters: EList[EParameter] = obj.getEParameters
    def eExceptions: EList[EClassifier] = obj.getEExceptions
    def eGenericExceptions: EList[EGenericType] = obj.getEGenericExceptions
  }
}

object EOperationScalaSupport extends EOperationScalaSupport

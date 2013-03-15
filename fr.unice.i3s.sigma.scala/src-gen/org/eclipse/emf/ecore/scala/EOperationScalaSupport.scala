package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypeParameter;

trait EOperationScalaSupport {
  implicit class EOperationScalaSupport(that: EOperation) {
    def eContainingClass: EClass = that.getEContainingClass
    def eTypeParameters: EList[ETypeParameter] = that.getETypeParameters
    def eParameters: EList[EParameter] = that.getEParameters
    def eExceptions: EList[EClassifier] = that.getEExceptions
    def eGenericExceptions: EList[EGenericType] = that.getEGenericExceptions
  }
}

object EOperationScalaSupport extends EOperationScalaSupport

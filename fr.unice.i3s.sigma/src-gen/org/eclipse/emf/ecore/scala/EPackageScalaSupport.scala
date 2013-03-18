package org.eclipse.emf.ecore.scala

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

trait EPackageScalaSupport {
  implicit class EPackageScalaSupport(that: EPackage) {
    def nsURI: String = that.getNsURI
    def nsURI_=(value: String): Unit = that.setNsURI(value)
    def nsPrefix: String = that.getNsPrefix
    def nsPrefix_=(value: String): Unit = that.setNsPrefix(value)
    def eFactoryInstance: EFactory = that.getEFactoryInstance
    def eFactoryInstance_=(value: EFactory): Unit = that.setEFactoryInstance(value)
    def eClassifiers: EList[EClassifier] = that.getEClassifiers
    def eSubpackages: EList[EPackage] = that.getESubpackages
    def eSuperPackage: EPackage = that.getESuperPackage
  }
}

object EPackageScalaSupport extends EPackageScalaSupport

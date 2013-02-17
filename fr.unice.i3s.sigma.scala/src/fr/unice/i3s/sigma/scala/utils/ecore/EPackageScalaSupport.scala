package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

trait EPackageScalaSupport {
  implicit class EPackageScalaSupport(obj: EPackage) {
    def nsURI: String = obj.getNsURI
    def nsURI_=(value: String): Unit = obj.setNsURI(value)
    def nsPrefix: String = obj.getNsPrefix
    def nsPrefix_=(value: String): Unit = obj.setNsPrefix(value)
    def eFactoryInstance: EFactory = obj.getEFactoryInstance
    def eFactoryInstance_=(value: EFactory): Unit = obj.setEFactoryInstance(value)
    def eClassifiers: EList[EClassifier] = obj.getEClassifiers
    def eSubpackages: EList[EPackage] = obj.getESubpackages
    def eSuperPackage: EPackage = obj.getESuperPackage
  }
}

object EPackageScalaSupport extends EPackageScalaSupport

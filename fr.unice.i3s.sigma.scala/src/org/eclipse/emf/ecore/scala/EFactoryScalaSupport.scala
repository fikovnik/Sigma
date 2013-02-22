package org.eclipse.emf.ecore.scala

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

trait EFactoryScalaSupport {
  implicit class EFactoryScalaSupport(obj: EFactory) {
    def ePackage: EPackage = obj.getEPackage
    def ePackage_=(value: EPackage): Unit = obj.setEPackage(value)
  }
}

object EFactoryScalaSupport extends EFactoryScalaSupport

package fr.unice.i3s.sigma.support.ecore

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

trait EFactoryScalaSupport {
  implicit class EFactoryScalaSupport(that: EFactory) {
    def ePackage: EPackage = that.getEPackage
    def ePackage_=(value: EPackage): Unit = that.setEPackage(value)
  }
}

object EFactoryScalaSupport extends EFactoryScalaSupport

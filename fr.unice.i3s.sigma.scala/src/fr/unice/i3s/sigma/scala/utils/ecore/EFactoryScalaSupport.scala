package fr.unice.i3s.sigma.scala.utils.ecore

import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

trait EFactoryScalaSupport {
  implicit class EFactoryScalaSupport(obj: EFactory) {
    def ePackage: EPackage = obj.getEPackage
    def ePackage_=(value: EPackage): Unit = obj.setEPackage(value)
  }
}

object EFactoryScalaSupport extends EFactoryScalaSupport

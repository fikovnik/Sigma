package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;

import scala.Option;

trait EPackageScalaSupport extends EMFScalaSupport {
  type EPackage = org.eclipse.emf.ecore.EPackage
  
  protected implicit val _epackageProxyBuilder = new EMFProxyBuilder[EPackage](EcorePackageScalaSupport._ecoreBuilder)
  
  object EPackage {
    def apply(name: String = null, nsURI: String = null, nsPrefix: String = null): EPackage = {
      val instance = EcorePackageScalaSupport._ecoreBuilder.create[EPackage]
      
      if (name != null) instance.setName(name)
      if (nsURI != null) instance.setNsURI(nsURI)
      if (nsPrefix != null) instance.setNsPrefix(nsPrefix)
      
      instance
    }
  }
  
  implicit class EPackageScalaSupport(that: EPackage) {
    def nsURI: String = that.getNsURI
    def nsURI_=(value: String): Unit = that.setNsURI(value)
    def nsPrefix: String = that.getNsPrefix
    def nsPrefix_=(value: String): Unit = that.setNsPrefix(value)
    def eFactoryInstance: EFactory = that.getEFactoryInstance
    def eFactoryInstance_=(value: EFactory): Unit = that.setEFactoryInstance(value)
    def eFactoryInstance_=(value: ⇒ Option[EFactory]): Unit =
      that.setEFactoryInstance(EcorePackageScalaSupport._ecoreBuilder.ref(value))
    def eClassifiers: EList[EClassifier] = that.getEClassifiers
    def eSubpackages: EList[EPackage] = that.getESubpackages
    def eSuperPackage: EPackage = that.getESuperPackage
  }
}

object EPackageScalaSupport extends EPackageScalaSupport

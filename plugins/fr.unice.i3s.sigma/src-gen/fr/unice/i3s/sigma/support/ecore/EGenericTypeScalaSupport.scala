package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypeParameter;

import scala.Option;

trait EGenericTypeScalaSupport extends EMFScalaSupport {
  type EGenericType = org.eclipse.emf.ecore.EGenericType
  
  protected implicit val _egenerictypeProxyBuilder = new EMFProxyBuilder[EGenericType](EcorePackageScalaSupport._ecoreBuilder)
  
  object EGenericType {
    def apply(eUpperBound: EGenericType = null, eTypeArguments: EList[EGenericType] = null, eLowerBound: EGenericType = null, eTypeParameter: ETypeParameter = null, eClassifier: EClassifier = null): EGenericType = {
      val _instance = EcorePackageScalaSupport._ecoreBuilder.create[EGenericType]
      
      if (eUpperBound != null) _instance.setEUpperBound(eUpperBound)
      if (eTypeArguments != null) _instance.getETypeArguments.addAll(eTypeArguments)
      if (eLowerBound != null) _instance.setELowerBound(eLowerBound)
      if (eTypeParameter != null) _instance.setETypeParameter(eTypeParameter)
      if (eClassifier != null) _instance.setEClassifier(eClassifier)
      
      _instance
    }
  }
  
  implicit class EGenericTypeScalaSupport(that: EGenericType) {
    def eUpperBound: EGenericType = that.getEUpperBound
    def eUpperBound_=(value: EGenericType): Unit = that.setEUpperBound(value)
    def eTypeArguments: EList[EGenericType] = that.getETypeArguments
    def eRawType: EClassifier = that.getERawType
    def eLowerBound: EGenericType = that.getELowerBound
    def eLowerBound_=(value: EGenericType): Unit = that.setELowerBound(value)
    def eTypeParameter: ETypeParameter = that.getETypeParameter
    def eTypeParameter_=(value: ETypeParameter): Unit = that.setETypeParameter(value)
    def eTypeParameter_=(value: ⇒ Option[ETypeParameter]): Unit =
      that.setETypeParameter(EcorePackageScalaSupport._ecoreBuilder.ref(value))
    def eClassifier: EClassifier = that.getEClassifier
    def eClassifier_=(value: EClassifier): Unit = that.setEClassifier(value)
    def eClassifier_=(value: ⇒ Option[EClassifier]): Unit =
      that.setEClassifier(EcorePackageScalaSupport._ecoreBuilder.ref(value))
  }
}

object EGenericTypeScalaSupport extends EGenericTypeScalaSupport

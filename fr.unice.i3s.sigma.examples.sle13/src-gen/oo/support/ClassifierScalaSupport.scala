package oo.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Classifier;
import oo.Stereotype;

import org.eclipse.emf.common.util.EList;

trait ClassifierScalaSupport extends EMFScalaSupport {
  type Classifier = oo.Classifier
  
  protected implicit val _classifierProxyBuilder = new EMFProxyBuilder[Classifier](OOPackageScalaSupport._ooBuilder)
  
  object Classifier {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null): Classifier = {
      val instance = OOPackageScalaSupport._ooBuilder.create[Classifier]
      
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (name != null) instance.setName(name)
      
      instance
    }
    
    def unapply(that: Classifier): Option[(EList[Stereotype],String)] =
      Some((that.getStereotypes,that.getName))
  }
}

object ClassifierScalaSupport extends ClassifierScalaSupport

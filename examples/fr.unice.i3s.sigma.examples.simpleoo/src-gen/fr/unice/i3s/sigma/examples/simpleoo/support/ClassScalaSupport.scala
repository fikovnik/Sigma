package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Feature;
import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ClassScalaSupport extends EMFScalaSupport {
  type Class = fr.unice.i3s.sigma.examples.simpleoo.Class
  
  protected implicit val _classProxyBuilder = new EMFProxyBuilder[Class](SimpleooPackageScalaSupport._simpleooBuilder)
  
  object Class {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, abstract_ : Boolean = false, features: EList[Feature] = null): Class = {
      val _instance = SimpleooPackageScalaSupport._simpleooBuilder.create[Class]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      if (abstract_  != false) _instance.setAbstract(abstract_ )
      if (features != null) _instance.getFeatures.addAll(features)
      
      _instance
    }
  }
}

object ClassScalaSupport extends ClassScalaSupport

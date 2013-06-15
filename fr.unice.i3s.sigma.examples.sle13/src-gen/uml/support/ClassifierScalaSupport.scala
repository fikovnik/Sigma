package uml.support

import org.eclipse.emf.common.util.EList;

import uml.Classifier;
import uml.Stereotype;

trait ClassifierScalaSupport {
  type Classifier = uml.Classifier
  
  object Classifier {
    def apply(name: String = null, stereotypes: EList[Stereotype] = null): Classifier = {
      val instance = UmlPackageScalaSupport.builder.create[Classifier]
      
      if (name != null) instance.setName(name)
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      
      instance
    }
    
    def unapply(that: Classifier): Option[(String,EList[Stereotype])] =
      Some((that.getName,that.getStereotypes))
  }
  
  implicit class ClassifierScalaSupport(that: Classifier) {
    }
}

object ClassifierScalaSupport extends ClassifierScalaSupport

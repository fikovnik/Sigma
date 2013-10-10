package oo.support
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Classifier;
import oo.Stereotype;



trait ClassifierScalaSupport extends EMFScalaSupport {
  type Classifier = oo.Classifier
  
  object Classifier {
    def unapply(that: Classifier): Option[(EList[Stereotype],String)] =
      Some((that.getStereotypes,that.getName))
  }
}

object ClassifierScalaSupport extends ClassifierScalaSupport

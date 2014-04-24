package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ClassifierScalaSupport extends EMFScalaSupport {
  type Classifier = fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier
  
  object Classifier {
    def unapply(that: Classifier): Option[(String)] =
      Some((that.getName))
  }
}

object ClassifierScalaSupport extends ClassifierScalaSupport

package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Classifier;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ClassifierScalaSupport extends EMFScalaSupport {
  type Classifier = fr.unice.i3s.sigma.examples.simpleoo.Classifier
  
  object Classifier {
  }
}

object ClassifierScalaSupport extends ClassifierScalaSupport

package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Feature;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait FeatureScalaSupport extends EMFScalaSupport {
  type Feature = fr.unice.i3s.sigma.examples.simpleoo.Feature
  
  object Feature {
  }
}

object FeatureScalaSupport extends FeatureScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.OpaqueBehavior;

trait OpaqueBehaviorScalaSupport {
  implicit class OpaqueBehaviorScalaSupport(that: OpaqueBehavior) {
    def body: EList[String] = that.getBodies
    def language: EList[String] = that.getLanguages
  }
}

object OpaqueBehaviorScalaSupport extends OpaqueBehaviorScalaSupport

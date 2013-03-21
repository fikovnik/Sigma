package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Parameter;

trait OpaqueExpressionScalaSupport {
  implicit class OpaqueExpressionScalaSupport(that: OpaqueExpression) {
    def behavior: Behavior = that.getBehavior
    def behavior_=(value: Behavior): Unit = that.setBehavior(value)
    def body: EList[String] = that.getBodies
    def language: EList[String] = that.getLanguages
    def result: Parameter = that.getResult
  }
}

object OpaqueExpressionScalaSupport extends OpaqueExpressionScalaSupport

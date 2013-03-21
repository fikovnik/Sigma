package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Type;

trait BehavioralFeatureScalaSupport {
  implicit class BehavioralFeatureScalaSupport(that: BehavioralFeature) {
    def concurrency: CallConcurrencyKind = that.getConcurrency
    def concurrency_=(value: CallConcurrencyKind): Unit = that.setConcurrency(value)
    def isAbstract: Boolean = that.isAbstract
    def isAbstract_=(value: Boolean): Unit = that.setIsAbstract(value)
    def method: EList[Behavior] = that.getMethods
    def ownedParameter: EList[Parameter] = that.getOwnedParameters
    def ownedParameterSet: EList[ParameterSet] = that.getOwnedParameterSets
    def raisedException: EList[Type] = that.getRaisedExceptions
  }
}

object BehavioralFeatureScalaSupport extends BehavioralFeatureScalaSupport

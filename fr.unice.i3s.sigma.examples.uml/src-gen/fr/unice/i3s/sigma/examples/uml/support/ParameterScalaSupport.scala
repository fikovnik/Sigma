package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.ValueSpecification;

trait ParameterScalaSupport {
  implicit class ParameterScalaSupport(that: Parameter) {
    def default: String = that.getDefault
    def default_=(value: String): Unit = that.setDefault(value)
    def defaultValue: ValueSpecification = that.getDefaultValue
    def defaultValue_=(value: ValueSpecification): Unit = that.setDefaultValue(value)
    def direction: ParameterDirectionKind = that.getDirection
    def direction_=(value: ParameterDirectionKind): Unit = that.setDirection(value)
    def effect: ParameterEffectKind = that.getEffect
    def effect_=(value: ParameterEffectKind): Unit = that.setEffect(value)
    def isException: Boolean = that.isException
    def isException_=(value: Boolean): Unit = that.setIsException(value)
    def isStream: Boolean = that.isStream
    def isStream_=(value: Boolean): Unit = that.setIsStream(value)
    def operation: Operation = that.getOperation
    def parameterSet: EList[ParameterSet] = that.getParameterSets
  }
}

object ParameterScalaSupport extends ParameterScalaSupport

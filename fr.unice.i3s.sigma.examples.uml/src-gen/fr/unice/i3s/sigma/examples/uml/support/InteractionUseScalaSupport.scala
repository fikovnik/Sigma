package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

trait InteractionUseScalaSupport {
  implicit class InteractionUseScalaSupport(that: InteractionUse) {
    def actualGate: EList[Gate] = that.getActualGates
    def argument: EList[ValueSpecification] = that.getArguments
    def refersTo: Interaction = that.getRefersTo
    def refersTo_=(value: Interaction): Unit = that.setRefersTo(value)
    def returnValue: ValueSpecification = that.getReturnValue
    def returnValue_=(value: ValueSpecification): Unit = that.setReturnValue(value)
    def returnValueRecipient: Property = that.getReturnValueRecipient
    def returnValueRecipient_=(value: Property): Unit = that.setReturnValueRecipient(value)
  }
}

object InteractionUseScalaSupport extends InteractionUseScalaSupport

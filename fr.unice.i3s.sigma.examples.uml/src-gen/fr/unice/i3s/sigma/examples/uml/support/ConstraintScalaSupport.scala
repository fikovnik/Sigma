package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.ValueSpecification;

trait ConstraintScalaSupport {
  implicit class ConstraintScalaSupport(that: Constraint) {
    def constrainedElement: EList[Element] = that.getConstrainedElements
    def context: Namespace = that.getContext
    def context_=(value: Namespace): Unit = that.setContext(value)
    def specification: ValueSpecification = that.getSpecification
    def specification_=(value: ValueSpecification): Unit = that.setSpecification(value)
  }
}

object ConstraintScalaSupport extends ConstraintScalaSupport

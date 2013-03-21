package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.ValueSpecification;

trait IntervalScalaSupport {
  implicit class IntervalScalaSupport(that: Interval) {
    def max: ValueSpecification = that.getMax
    def max_=(value: ValueSpecification): Unit = that.setMax(value)
    def min: ValueSpecification = that.getMin
    def min_=(value: ValueSpecification): Unit = that.setMin(value)
  }
}

object IntervalScalaSupport extends IntervalScalaSupport

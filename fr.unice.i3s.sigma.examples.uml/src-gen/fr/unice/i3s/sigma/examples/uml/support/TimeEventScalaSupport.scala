package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;

trait TimeEventScalaSupport {
  implicit class TimeEventScalaSupport(that: TimeEvent) {
    def isRelative: Boolean = that.isRelative
    def isRelative_=(value: Boolean): Unit = that.setIsRelative(value)
    def when: TimeExpression = that.getWhen
    def when_=(value: TimeExpression): Unit = that.setWhen(value)
  }
}

object TimeEventScalaSupport extends TimeEventScalaSupport

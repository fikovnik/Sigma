package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.TestIdentityAction;

trait TestIdentityActionScalaSupport {
  implicit class TestIdentityActionScalaSupport(that: TestIdentityAction) {
    def first: InputPin = that.getFirst
    def first_=(value: InputPin): Unit = that.setFirst(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
    def second: InputPin = that.getSecond
    def second_=(value: InputPin): Unit = that.setSecond(value)
  }
}

object TestIdentityActionScalaSupport extends TestIdentityActionScalaSupport

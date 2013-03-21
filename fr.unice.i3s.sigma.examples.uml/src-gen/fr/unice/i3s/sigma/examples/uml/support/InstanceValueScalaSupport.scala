package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;

trait InstanceValueScalaSupport {
  implicit class InstanceValueScalaSupport(that: InstanceValue) {
    def instance: InstanceSpecification = that.getInstance
    def instance_=(value: InstanceSpecification): Unit = that.setInstance(value)
  }
}

object InstanceValueScalaSupport extends InstanceValueScalaSupport

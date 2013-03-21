package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Model;

trait ModelScalaSupport {
  implicit class ModelScalaSupport(that: Model) {
    def viewpoint: String = that.getViewpoint
    def viewpoint_=(value: String): Unit = that.setViewpoint(value)
  }
}

object ModelScalaSupport extends ModelScalaSupport

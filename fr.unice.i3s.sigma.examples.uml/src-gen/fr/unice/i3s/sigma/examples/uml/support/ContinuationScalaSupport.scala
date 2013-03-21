package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Continuation;

trait ContinuationScalaSupport {
  implicit class ContinuationScalaSupport(that: Continuation) {
    def setting: Boolean = that.isSetting
    def setting_=(value: Boolean): Unit = that.setSetting(value)
  }
}

object ContinuationScalaSupport extends ContinuationScalaSupport

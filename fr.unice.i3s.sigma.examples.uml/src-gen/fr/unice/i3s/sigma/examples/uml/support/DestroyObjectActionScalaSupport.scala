package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.InputPin;

trait DestroyObjectActionScalaSupport {
  implicit class DestroyObjectActionScalaSupport(that: DestroyObjectAction) {
    def isDestroyLinks: Boolean = that.isDestroyLinks
    def isDestroyLinks_=(value: Boolean): Unit = that.setIsDestroyLinks(value)
    def isDestroyOwnedObjects: Boolean = that.isDestroyOwnedObjects
    def isDestroyOwnedObjects_=(value: Boolean): Unit = that.setIsDestroyOwnedObjects(value)
    def target: InputPin = that.getTarget
    def target_=(value: InputPin): Unit = that.setTarget(value)
  }
}

object DestroyObjectActionScalaSupport extends DestroyObjectActionScalaSupport

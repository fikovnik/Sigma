package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.ObjectFlow;

trait ObjectFlowScalaSupport {
  implicit class ObjectFlowScalaSupport(that: ObjectFlow) {
    def isMulticast: Boolean = that.isMulticast
    def isMulticast_=(value: Boolean): Unit = that.setIsMulticast(value)
    def isMultireceive: Boolean = that.isMultireceive
    def isMultireceive_=(value: Boolean): Unit = that.setIsMultireceive(value)
    def selection: Behavior = that.getSelection
    def selection_=(value: Behavior): Unit = that.setSelection(value)
    def transformation: Behavior = that.getTransformation
    def transformation_=(value: Behavior): Unit = that.setTransformation(value)
  }
}

object ObjectFlowScalaSupport extends ObjectFlowScalaSupport

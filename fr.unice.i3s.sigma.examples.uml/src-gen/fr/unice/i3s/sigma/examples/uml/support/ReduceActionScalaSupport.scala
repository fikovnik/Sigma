package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.ReduceAction;

trait ReduceActionScalaSupport {
  implicit class ReduceActionScalaSupport(that: ReduceAction) {
    def collection: InputPin = that.getCollection
    def collection_=(value: InputPin): Unit = that.setCollection(value)
    def isOrdered: Boolean = that.isOrdered
    def isOrdered_=(value: Boolean): Unit = that.setIsOrdered(value)
    def reducer: Behavior = that.getReducer
    def reducer_=(value: Behavior): Unit = that.setReducer(value)
    def result: OutputPin = that.getResult
    def result_=(value: OutputPin): Unit = that.setResult(value)
  }
}

object ReduceActionScalaSupport extends ReduceActionScalaSupport

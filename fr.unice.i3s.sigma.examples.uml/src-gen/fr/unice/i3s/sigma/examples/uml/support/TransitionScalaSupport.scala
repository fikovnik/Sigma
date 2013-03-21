package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Vertex;

trait TransitionScalaSupport {
  implicit class TransitionScalaSupport(that: Transition) {
    def effect: Behavior = that.getEffect
    def effect_=(value: Behavior): Unit = that.setEffect(value)
    def guard: Constraint = that.getGuard
    def guard_=(value: Constraint): Unit = that.setGuard(value)
    def kind: TransitionKind = that.getKind
    def kind_=(value: TransitionKind): Unit = that.setKind(value)
    def redefinedTransition: Transition = that.getRedefinedTransition
    def redefinedTransition_=(value: Transition): Unit = that.setRedefinedTransition(value)
    def source: Vertex = that.getSource
    def source_=(value: Vertex): Unit = that.setSource(value)
    def target: Vertex = that.getTarget
    def target_=(value: Vertex): Unit = that.setTarget(value)
    def trigger: EList[Trigger] = that.getTriggers
    def container: Region = that.getContainer
    def container_=(value: Region): Unit = that.setContainer(value)
  }
}

object TransitionScalaSupport extends TransitionScalaSupport

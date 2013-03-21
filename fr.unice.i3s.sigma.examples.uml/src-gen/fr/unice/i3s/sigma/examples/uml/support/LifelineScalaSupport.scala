package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.PartDecomposition;
import org.eclipse.uml2.uml.ValueSpecification;

trait LifelineScalaSupport {
  implicit class LifelineScalaSupport(that: Lifeline) {
    def decomposedAs: PartDecomposition = that.getDecomposedAs
    def decomposedAs_=(value: PartDecomposition): Unit = that.setDecomposedAs(value)
    def interaction: Interaction = that.getInteraction
    def interaction_=(value: Interaction): Unit = that.setInteraction(value)
    def represents: ConnectableElement = that.getRepresents
    def represents_=(value: ConnectableElement): Unit = that.setRepresents(value)
    def selector: ValueSpecification = that.getSelector
    def selector_=(value: ValueSpecification): Unit = that.setSelector(value)
    def coveredBy: EList[InteractionFragment] = that.getCoveredBys
  }
}

object LifelineScalaSupport extends LifelineScalaSupport

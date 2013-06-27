package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.PartDecomposition;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait LifelineScalaSupport extends EMFScalaSupport {
  type Lifeline = org.eclipse.uml2.uml.Lifeline
  
  protected implicit val _lifelineProxyBuilder = new EMFProxyBuilder[Lifeline](UMLPackageScalaSupport._umlBuilder)
  
  object Lifeline {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, decomposedAs: PartDecomposition = null, represents: ConnectableElement = null, selector: ValueSpecification = null, coveredBy: EList[InteractionFragment] = null): Lifeline = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Lifeline]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (decomposedAs != null) _instance.setDecomposedAs(decomposedAs)
      if (represents != null) _instance.setRepresents(represents)
      if (selector != null) _instance.setSelector(selector)
      if (coveredBy != null) _instance.getCoveredBys.addAll(coveredBy)
      
      _instance
    }
  }
  
  implicit class LifelineScalaSupport(that: Lifeline) {
    def decomposedAs: PartDecomposition = that.getDecomposedAs
    def decomposedAs_=(value: PartDecomposition): Unit = that.setDecomposedAs(value)
    def decomposedAs_=(value: ⇒ Option[PartDecomposition]): Unit =
      that.setDecomposedAs(UMLPackageScalaSupport._umlBuilder.ref(value))
    def interaction: Interaction = that.getInteraction
    def interaction_=(value: Interaction): Unit = that.setInteraction(value)
    def interaction_=(value: ⇒ Option[Interaction]): Unit =
      that.setInteraction(UMLPackageScalaSupport._umlBuilder.ref(value))
    def represents: ConnectableElement = that.getRepresents
    def represents_=(value: ConnectableElement): Unit = that.setRepresents(value)
    def represents_=(value: ⇒ Option[ConnectableElement]): Unit =
      that.setRepresents(UMLPackageScalaSupport._umlBuilder.ref(value))
    def selector: ValueSpecification = that.getSelector
    def selector_=(value: ValueSpecification): Unit = that.setSelector(value)
    def coveredBy: EList[InteractionFragment] = that.getCoveredBys
  }
}

object LifelineScalaSupport extends LifelineScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait TransitionScalaSupport extends EMFScalaSupport {
  type Transition = org.eclipse.uml2.uml.Transition
  
  protected implicit val _transitionProxyBuilder = new EMFProxyBuilder[Transition](UMLPackageScalaSupport._umlBuilder)
  
  object Transition {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, isLeaf: Boolean = false, effect: Behavior = null, guard: Constraint = null, kind: TransitionKind = TransitionKind.EXTERNAL_LITERAL, redefinedTransition: Transition = null, source: Vertex = null, target: Vertex = null, trigger: EList[Trigger] = null): Transition = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Transition]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (elementImport != null) _instance.getElementImports.addAll(elementImport)
      if (packageImport != null) _instance.getPackageImports.addAll(packageImport)
      if (ownedRule != null) _instance.getOwnedRules.addAll(ownedRule)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (effect != null) _instance.setEffect(effect)
      if (guard != null) _instance.setGuard(guard)
      if (kind != TransitionKind.EXTERNAL_LITERAL) _instance.setKind(kind)
      if (redefinedTransition != null) _instance.setRedefinedTransition(redefinedTransition)
      if (source != null) _instance.setSource(source)
      if (target != null) _instance.setTarget(target)
      if (trigger != null) _instance.getTriggers.addAll(trigger)
      
      _instance
    }
  }
  
  implicit class TransitionScalaSupport(that: Transition) {
    def effect: Behavior = that.getEffect
    def effect_=(value: Behavior): Unit = that.setEffect(value)
    def guard: Constraint = that.getGuard
    def guard_=(value: Constraint): Unit = that.setGuard(value)
    def guard_=(value: ⇒ Option[Constraint]): Unit =
      that.setGuard(UMLPackageScalaSupport._umlBuilder.ref(value))
    def kind: TransitionKind = that.getKind
    def kind_=(value: TransitionKind): Unit = that.setKind(value)
    def redefinedTransition: Transition = that.getRedefinedTransition
    def redefinedTransition_=(value: Transition): Unit = that.setRedefinedTransition(value)
    def redefinedTransition_=(value: ⇒ Option[Transition]): Unit =
      that.setRedefinedTransition(UMLPackageScalaSupport._umlBuilder.ref(value))
    def source: Vertex = that.getSource
    def source_=(value: Vertex): Unit = that.setSource(value)
    def source_=(value: ⇒ Option[Vertex]): Unit =
      that.setSource(UMLPackageScalaSupport._umlBuilder.ref(value))
    def target: Vertex = that.getTarget
    def target_=(value: Vertex): Unit = that.setTarget(value)
    def target_=(value: ⇒ Option[Vertex]): Unit =
      that.setTarget(UMLPackageScalaSupport._umlBuilder.ref(value))
    def trigger: EList[Trigger] = that.getTriggers
    def container: Region = that.getContainer
    def container_=(value: Region): Unit = that.setContainer(value)
    def container_=(value: ⇒ Option[Region]): Unit =
      that.setContainer(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object TransitionScalaSupport extends TransitionScalaSupport

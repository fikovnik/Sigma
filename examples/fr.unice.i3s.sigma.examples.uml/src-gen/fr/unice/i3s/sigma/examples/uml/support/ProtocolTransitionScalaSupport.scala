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
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.ProtocolTransition;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ProtocolTransitionScalaSupport extends EMFScalaSupport {
  type ProtocolTransition = org.eclipse.uml2.uml.ProtocolTransition
  
  protected implicit val _protocoltransitionProxyBuilder = new EMFProxyBuilder[ProtocolTransition](UMLPackageScalaSupport._umlBuilder)
  
  object ProtocolTransition {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, isLeaf: Boolean = false, effect: Behavior = null, guard: Constraint = null, kind: TransitionKind = TransitionKind.EXTERNAL_LITERAL, redefinedTransition: Transition = null, source: Vertex = null, target: Vertex = null, trigger: EList[Trigger] = null, postCondition: Constraint = null, preCondition: Constraint = null): ProtocolTransition = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ProtocolTransition]
      
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
      if (postCondition != null) _instance.setPostCondition(postCondition)
      if (preCondition != null) _instance.setPreCondition(preCondition)
      
      _instance
    }
  }
  
  implicit class ProtocolTransitionScalaSupport(that: ProtocolTransition) {
    def postCondition: Constraint = that.getPostCondition
    def postCondition_=(value: Constraint): Unit = that.setPostCondition(value)
    def postCondition_=(value: ⇒ Option[Constraint]): Unit =
      that.setPostCondition(UMLPackageScalaSupport._umlBuilder.ref(value))
    def preCondition: Constraint = that.getPreCondition
    def preCondition_=(value: Constraint): Unit = that.setPreCondition(value)
    def preCondition_=(value: ⇒ Option[Constraint]): Unit =
      that.setPreCondition(UMLPackageScalaSupport._umlBuilder.ref(value))
    def referred: EList[Operation] = that.getReferreds
  }
}

object ProtocolTransitionScalaSupport extends ProtocolTransitionScalaSupport

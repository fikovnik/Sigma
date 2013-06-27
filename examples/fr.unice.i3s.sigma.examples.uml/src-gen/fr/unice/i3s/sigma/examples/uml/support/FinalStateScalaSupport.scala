package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.VisibilityKind;

trait FinalStateScalaSupport extends EMFScalaSupport {
  type FinalState = org.eclipse.uml2.uml.FinalState
  
  protected implicit val _finalstateProxyBuilder = new EMFProxyBuilder[FinalState](UMLPackageScalaSupport._umlBuilder)
  
  object FinalState {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, isLeaf: Boolean = false, connection: EList[ConnectionPointReference] = null, connectionPoint: EList[Pseudostate] = null, deferrableTrigger: EList[Trigger] = null, doActivity: Behavior = null, entry: Behavior = null, exit: Behavior = null, redefinedState: State = null, stateInvariant: Constraint = null, submachine: StateMachine = null, region: EList[Region] = null): FinalState = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[FinalState]
      
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
      if (connection != null) _instance.getConnections.addAll(connection)
      if (connectionPoint != null) _instance.getConnectionPoints.addAll(connectionPoint)
      if (deferrableTrigger != null) _instance.getDeferrableTriggers.addAll(deferrableTrigger)
      if (doActivity != null) _instance.setDoActivity(doActivity)
      if (entry != null) _instance.setEntry(entry)
      if (exit != null) _instance.setExit(exit)
      if (redefinedState != null) _instance.setRedefinedState(redefinedState)
      if (stateInvariant != null) _instance.setStateInvariant(stateInvariant)
      if (submachine != null) _instance.setSubmachine(submachine)
      if (region != null) _instance.getRegions.addAll(region)
      
      _instance
    }
  }
}

object FinalStateScalaSupport extends FinalStateScalaSupport

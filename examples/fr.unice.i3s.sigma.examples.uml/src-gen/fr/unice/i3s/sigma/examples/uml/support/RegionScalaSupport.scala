package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait RegionScalaSupport extends EMFScalaSupport {
  type Region = org.eclipse.uml2.uml.Region
  
  protected implicit val _regionProxyBuilder = new EMFProxyBuilder[Region](UMLPackageScalaSupport._umlBuilder)
  
  object Region {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, isLeaf: Boolean = false, extendedRegion: Region = null, transition: EList[Transition] = null, subvertex: EList[Vertex] = null): Region = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Region]
      
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
      if (extendedRegion != null) _instance.setExtendedRegion(extendedRegion)
      if (transition != null) _instance.getTransitions.addAll(transition)
      if (subvertex != null) _instance.getSubvertices.addAll(subvertex)
      
      _instance
    }
  }
  
  implicit class RegionScalaSupport(that: Region) {
    def extendedRegion: Region = that.getExtendedRegion
    def extendedRegion_=(value: Region): Unit = that.setExtendedRegion(value)
    def extendedRegion_=(value: ⇒ Option[Region]): Unit =
      that.setExtendedRegion(UMLPackageScalaSupport._umlBuilder.ref(value))
    def state: State = that.getState
    def state_=(value: State): Unit = that.setState(value)
    def state_=(value: ⇒ Option[State]): Unit =
      that.setState(UMLPackageScalaSupport._umlBuilder.ref(value))
    def stateMachine: StateMachine = that.getStateMachine
    def stateMachine_=(value: StateMachine): Unit = that.setStateMachine(value)
    def stateMachine_=(value: ⇒ Option[StateMachine]): Unit =
      that.setStateMachine(UMLPackageScalaSupport._umlBuilder.ref(value))
    def transition: EList[Transition] = that.getTransitions
    def subvertex: EList[Vertex] = that.getSubvertices
  }
}

object RegionScalaSupport extends RegionScalaSupport

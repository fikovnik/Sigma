package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ConnectionPointReferenceScalaSupport extends EMFScalaSupport {
  type ConnectionPointReference = org.eclipse.uml2.uml.ConnectionPointReference
  
  protected implicit val _connectionpointreferenceProxyBuilder = new EMFProxyBuilder[ConnectionPointReference](UMLPackageScalaSupport._umlBuilder)
  
  object ConnectionPointReference {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, entry: EList[Pseudostate] = null, exit: EList[Pseudostate] = null): ConnectionPointReference = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ConnectionPointReference]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (entry != null) _instance.getEntries.addAll(entry)
      if (exit != null) _instance.getExits.addAll(exit)
      
      _instance
    }
  }
  
  implicit class ConnectionPointReferenceScalaSupport(that: ConnectionPointReference) {
    def entry: EList[Pseudostate] = that.getEntries
    def exit: EList[Pseudostate] = that.getExits
    def state: State = that.getState
    def state_=(value: State): Unit = that.setState(value)
    def state_=(value: ⇒ Option[State]): Unit =
      that.setState(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ConnectionPointReferenceScalaSupport extends ConnectionPointReferenceScalaSupport

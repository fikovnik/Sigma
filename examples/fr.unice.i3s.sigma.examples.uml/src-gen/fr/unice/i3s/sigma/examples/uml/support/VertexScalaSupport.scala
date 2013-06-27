package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait VertexScalaSupport extends EMFScalaSupport {
  type Vertex = org.eclipse.uml2.uml.Vertex
  
  protected implicit val _vertexProxyBuilder = new EMFProxyBuilder[Vertex](UMLPackageScalaSupport._umlBuilder)
  
  object Vertex {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL): Vertex = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Vertex]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      
      _instance
    }
  }
  
  implicit class VertexScalaSupport(that: Vertex) {
    def container: Region = that.getContainer
    def container_=(value: Region): Unit = that.setContainer(value)
    def container_=(value: ⇒ Option[Region]): Unit =
      that.setContainer(UMLPackageScalaSupport._umlBuilder.ref(value))
    def incoming: EList[Transition] = that.getIncomings
    def outgoing: EList[Transition] = that.getOutgoings
  }
}

object VertexScalaSupport extends VertexScalaSupport

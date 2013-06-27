package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait MessageEndScalaSupport extends EMFScalaSupport {
  type MessageEnd = org.eclipse.uml2.uml.MessageEnd
  
  protected implicit val _messageendProxyBuilder = new EMFProxyBuilder[MessageEnd](UMLPackageScalaSupport._umlBuilder)
  
  object MessageEnd {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, message: Message = null): MessageEnd = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[MessageEnd]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (message != null) _instance.setMessage(message)
      
      _instance
    }
  }
  
  implicit class MessageEndScalaSupport(that: MessageEnd) {
    def message: Message = that.getMessage
    def message_=(value: Message): Unit = that.setMessage(value)
    def message_=(value: ⇒ Option[Message]): Unit =
      that.setMessage(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object MessageEndScalaSupport extends MessageEndScalaSupport

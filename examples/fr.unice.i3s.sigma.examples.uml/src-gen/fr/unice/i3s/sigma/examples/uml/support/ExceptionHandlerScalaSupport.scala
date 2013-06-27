package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ObjectNode;

import scala.Option;

trait ExceptionHandlerScalaSupport extends EMFScalaSupport {
  type ExceptionHandler = org.eclipse.uml2.uml.ExceptionHandler
  
  protected implicit val _exceptionhandlerProxyBuilder = new EMFProxyBuilder[ExceptionHandler](UMLPackageScalaSupport._umlBuilder)
  
  object ExceptionHandler {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, exceptionInput: ObjectNode = null, exceptionType: EList[Classifier] = null, handlerBody: ExecutableNode = null): ExceptionHandler = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ExceptionHandler]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (exceptionInput != null) _instance.setExceptionInput(exceptionInput)
      if (exceptionType != null) _instance.getExceptionTypes.addAll(exceptionType)
      if (handlerBody != null) _instance.setHandlerBody(handlerBody)
      
      _instance
    }
  }
  
  implicit class ExceptionHandlerScalaSupport(that: ExceptionHandler) {
    def exceptionInput: ObjectNode = that.getExceptionInput
    def exceptionInput_=(value: ObjectNode): Unit = that.setExceptionInput(value)
    def exceptionInput_=(value: ⇒ Option[ObjectNode]): Unit =
      that.setExceptionInput(UMLPackageScalaSupport._umlBuilder.ref(value))
    def exceptionType: EList[Classifier] = that.getExceptionTypes
    def handlerBody: ExecutableNode = that.getHandlerBody
    def handlerBody_=(value: ExecutableNode): Unit = that.setHandlerBody(value)
    def handlerBody_=(value: ⇒ Option[ExecutableNode]): Unit =
      that.setHandlerBody(UMLPackageScalaSupport._umlBuilder.ref(value))
    def protectedNode: ExecutableNode = that.getProtectedNode
    def protectedNode_=(value: ExecutableNode): Unit = that.setProtectedNode(value)
    def protectedNode_=(value: ⇒ Option[ExecutableNode]): Unit =
      that.setProtectedNode(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ExceptionHandlerScalaSupport extends ExceptionHandlerScalaSupport

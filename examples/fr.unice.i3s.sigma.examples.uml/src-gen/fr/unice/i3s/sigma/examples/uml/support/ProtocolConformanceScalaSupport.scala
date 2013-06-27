package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.ProtocolConformance;
import org.eclipse.uml2.uml.ProtocolStateMachine;

import scala.Option;

trait ProtocolConformanceScalaSupport extends EMFScalaSupport {
  type ProtocolConformance = org.eclipse.uml2.uml.ProtocolConformance
  
  protected implicit val _protocolconformanceProxyBuilder = new EMFProxyBuilder[ProtocolConformance](UMLPackageScalaSupport._umlBuilder)
  
  object ProtocolConformance {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, generalMachine: ProtocolStateMachine = null): ProtocolConformance = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[ProtocolConformance]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (generalMachine != null) _instance.setGeneralMachine(generalMachine)
      
      _instance
    }
  }
  
  implicit class ProtocolConformanceScalaSupport(that: ProtocolConformance) {
    def generalMachine: ProtocolStateMachine = that.getGeneralMachine
    def generalMachine_=(value: ProtocolStateMachine): Unit = that.setGeneralMachine(value)
    def generalMachine_=(value: ⇒ Option[ProtocolStateMachine]): Unit =
      that.setGeneralMachine(UMLPackageScalaSupport._umlBuilder.ref(value))
    def specificMachine: ProtocolStateMachine = that.getSpecificMachine
    def specificMachine_=(value: ProtocolStateMachine): Unit = that.setSpecificMachine(value)
    def specificMachine_=(value: ⇒ Option[ProtocolStateMachine]): Unit =
      that.setSpecificMachine(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ProtocolConformanceScalaSupport extends ProtocolConformanceScalaSupport

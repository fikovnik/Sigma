package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

trait InformationFlowScalaSupport extends EMFScalaSupport {
  type InformationFlow = org.eclipse.uml2.uml.InformationFlow
  
  protected implicit val _informationflowProxyBuilder = new EMFProxyBuilder[InformationFlow](UMLPackageScalaSupport._umlBuilder)
  
  object InformationFlow {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, conveyed: EList[Classifier] = null, informationSource: EList[NamedElement] = null, informationTarget: EList[NamedElement] = null, realization: EList[Relationship] = null, realizingActivityEdge: EList[ActivityEdge] = null, realizingConnector: EList[Connector] = null, realizingMessage: EList[Message] = null): InformationFlow = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[InformationFlow]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (conveyed != null) _instance.getConveyeds.addAll(conveyed)
      if (informationSource != null) _instance.getInformationSources.addAll(informationSource)
      if (informationTarget != null) _instance.getInformationTargets.addAll(informationTarget)
      if (realization != null) _instance.getRealizations.addAll(realization)
      if (realizingActivityEdge != null) _instance.getRealizingActivityEdges.addAll(realizingActivityEdge)
      if (realizingConnector != null) _instance.getRealizingConnectors.addAll(realizingConnector)
      if (realizingMessage != null) _instance.getRealizingMessages.addAll(realizingMessage)
      
      _instance
    }
  }
  
  implicit class InformationFlowScalaSupport(that: InformationFlow) {
    def conveyed: EList[Classifier] = that.getConveyeds
    def informationSource: EList[NamedElement] = that.getInformationSources
    def informationTarget: EList[NamedElement] = that.getInformationTargets
    def realization: EList[Relationship] = that.getRealizations
    def realizingActivityEdge: EList[ActivityEdge] = that.getRealizingActivityEdges
    def realizingConnector: EList[Connector] = that.getRealizingConnectors
    def realizingMessage: EList[Message] = that.getRealizingMessages
  }
}

object InformationFlowScalaSupport extends InformationFlowScalaSupport

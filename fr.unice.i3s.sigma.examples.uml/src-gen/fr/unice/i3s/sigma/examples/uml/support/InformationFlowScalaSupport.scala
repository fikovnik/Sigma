package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Relationship;

trait InformationFlowScalaSupport {
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

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VisibilityKind;

trait ActivityScalaSupport extends EMFScalaSupport {
  type Activity = org.eclipse.uml2.uml.Activity
  
  protected implicit val _activityProxyBuilder = new EMFProxyBuilder[Activity](UMLPackageScalaSupport._umlBuilder)
  
  object Activity {
    def apply(): Activity = {
      UMLPackageScalaSupport._umlBuilder.create[Activity]
    }
  }
  
  implicit class ActivityScalaSupport(that: Activity) {
    def ownedGroup: EList[ActivityGroup] = that.getOwnedGroups
    def edge: EList[ActivityEdge] = that.getEdges
    def variable: EList[Variable] = that.getVariables
    def group: EList[ActivityGroup] = that.getGroups
    def ownedNode: EList[ActivityNode] = that.getOwnedNodes
    def isReadOnly: Boolean = that.isReadOnly
    def isReadOnly_=(value: Boolean): Unit = that.setIsReadOnly(value)
    def isSingleExecution: Boolean = that.isSingleExecution
    def isSingleExecution_=(value: Boolean): Unit = that.setIsSingleExecution(value)
    def partition: EList[ActivityPartition] = that.getPartitions
    def structuredNode: EList[StructuredActivityNode] = that.getStructuredNodes
    def node: EList[ActivityNode] = that.getNodes
  }
}

object ActivityScalaSupport extends ActivityScalaSupport

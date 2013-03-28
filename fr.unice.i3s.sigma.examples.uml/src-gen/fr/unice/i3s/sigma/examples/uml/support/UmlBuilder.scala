package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.AutoContainment;
import fr.unice.i3s.sigma.support.EMFBuilder;

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.AcceptCallAction;
import org.eclipse.uml2.uml.AcceptEventAction;
import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.ActionExecutionSpecification;
import org.eclipse.uml2.uml.ActionInputPin;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.ActivityGroup;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.ActivityPartition;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.AddStructuralFeatureValueAction;
import org.eclipse.uml2.uml.AddVariableValueAction;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.AnyReceiveEvent;
import org.eclipse.uml2.uml.Artifact;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.AssociationClass;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.BehavioralFeature;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.BroadcastSignalAction;
import org.eclipse.uml2.uml.CallAction;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.CentralBufferNode;
import org.eclipse.uml2.uml.ChangeEvent;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.ClassifierTemplateParameter;
import org.eclipse.uml2.uml.Clause;
import org.eclipse.uml2.uml.ClearAssociationAction;
import org.eclipse.uml2.uml.ClearStructuralFeatureAction;
import org.eclipse.uml2.uml.ClearVariableAction;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.CommunicationPath;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.ConditionalNode;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.ConnectableElementTemplateParameter;
import org.eclipse.uml2.uml.ConnectionPointReference;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.CreateLinkAction;
import org.eclipse.uml2.uml.CreateLinkObjectAction;
import org.eclipse.uml2.uml.CreateObjectAction;
import org.eclipse.uml2.uml.DataStoreNode;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DeployedArtifact;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.DeploymentSpecification;
import org.eclipse.uml2.uml.DeploymentTarget;
import org.eclipse.uml2.uml.DestroyLinkAction;
import org.eclipse.uml2.uml.DestroyObjectAction;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Device;
import org.eclipse.uml2.uml.Duration;
import org.eclipse.uml2.uml.DurationInterval;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExceptionHandler;
import org.eclipse.uml2.uml.ExecutableNode;
import org.eclipse.uml2.uml.ExecutionEnvironment;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.ExpansionKind;
import org.eclipse.uml2.uml.ExpansionNode;
import org.eclipse.uml2.uml.ExpansionRegion;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.ExtensionEnd;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.FinalState;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.ForkNode;
import org.eclipse.uml2.uml.FunctionBehavior;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.InformationItem;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.InputPin;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.InterruptibleActivityRegion;
import org.eclipse.uml2.uml.Interval;
import org.eclipse.uml2.uml.IntervalConstraint;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.LinkAction;
import org.eclipse.uml2.uml.LinkEndCreationData;
import org.eclipse.uml2.uml.LinkEndData;
import org.eclipse.uml2.uml.LinkEndDestructionData;
import org.eclipse.uml2.uml.LiteralBoolean;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralNull;
import org.eclipse.uml2.uml.LiteralReal;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.LoopNode;
import org.eclipse.uml2.uml.Manifestation;
import org.eclipse.uml2.uml.MergeNode;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.MultiplicityElement;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.ObjectNodeOrderingKind;
import org.eclipse.uml2.uml.Observation;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.OpaqueAction;
import org.eclipse.uml2.uml.OpaqueBehavior;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.OperationTemplateParameter;
import org.eclipse.uml2.uml.OutputPin;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageMerge;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.ParameterEffectKind;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.PartDecomposition;
import org.eclipse.uml2.uml.Pin;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.ProfileApplication;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ProtocolConformance;
import org.eclipse.uml2.uml.ProtocolStateMachine;
import org.eclipse.uml2.uml.ProtocolTransition;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.PseudostateKind;
import org.eclipse.uml2.uml.QualifierValue;
import org.eclipse.uml2.uml.RaiseExceptionAction;
import org.eclipse.uml2.uml.ReadExtentAction;
import org.eclipse.uml2.uml.ReadIsClassifiedObjectAction;
import org.eclipse.uml2.uml.ReadLinkAction;
import org.eclipse.uml2.uml.ReadLinkObjectEndAction;
import org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction;
import org.eclipse.uml2.uml.ReadSelfAction;
import org.eclipse.uml2.uml.ReadStructuralFeatureAction;
import org.eclipse.uml2.uml.ReadVariableAction;
import org.eclipse.uml2.uml.Realization;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.ReclassifyObjectAction;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.RedefinableTemplateSignature;
import org.eclipse.uml2.uml.ReduceAction;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.Relationship;
import org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction;
import org.eclipse.uml2.uml.RemoveVariableValueAction;
import org.eclipse.uml2.uml.ReplyAction;
import org.eclipse.uml2.uml.SendObjectAction;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.SequenceNode;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StartClassifierBehaviorAction;
import org.eclipse.uml2.uml.StartObjectBehaviorAction;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateInvariant;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.StructuralFeatureAction;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateParameterSubstitution;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.TemplateableElement;
import org.eclipse.uml2.uml.TestIdentityAction;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.TimeEvent;
import org.eclipse.uml2.uml.TimeExpression;
import org.eclipse.uml2.uml.TimeInterval;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.Transition;
import org.eclipse.uml2.uml.TransitionKind;
import org.eclipse.uml2.uml.Trigger;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.UnmarshallAction;
import org.eclipse.uml2.uml.Usage;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.ValuePin;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.ValueSpecificationAction;
import org.eclipse.uml2.uml.Variable;
import org.eclipse.uml2.uml.VariableAction;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.WriteStructuralFeatureAction;
import org.eclipse.uml2.uml.WriteVariableAction;

object UmlBuilder extends EMFBuilder(UMLPackage.eINSTANCE) {
  import AutoContainment._
  
  type Abstraction = org.eclipse.uml2.uml.Abstraction
  object Abstraction {
    def apply(config: (Abstraction ⇒ Any)*): Abstraction =
      contained(build[Abstraction](config: _*))
  }
  
  type Dependency = org.eclipse.uml2.uml.Dependency
  object Dependency {
    def apply(config: (Dependency ⇒ Any)*): Dependency =
      contained(build[Dependency](config: _*))
  }
  
  type Comment = org.eclipse.uml2.uml.Comment
  object Comment {
    def apply(config: (Comment ⇒ Any)*): Comment =
      contained(build[Comment](config: _*))
  }
  
  type Stereotype = org.eclipse.uml2.uml.Stereotype
  object Stereotype {
    def apply(config: (Stereotype ⇒ Any)*): Stereotype =
      contained(build[Stereotype](config: _*))
  }
  
  type UMLClass = org.eclipse.uml2.uml.Class
  object UMLClass {
    def apply(config: (UMLClass ⇒ Any)*): UMLClass =
      contained(build[UMLClass](config: _*))
  }
  
  type StringExpression = org.eclipse.uml2.uml.StringExpression
  object StringExpression {
    def apply(config: (StringExpression ⇒ Any)*): StringExpression =
      contained(build[StringExpression](config: _*))
  }
  
  type Expression = org.eclipse.uml2.uml.Expression
  object Expression {
    def apply(config: (Expression ⇒ Any)*): Expression =
      contained(build[Expression](config: _*))
  }
  
  type UMLPackage = org.eclipse.uml2.uml.Package
  object UMLPackage {
    def apply(config: (UMLPackage ⇒ Any)*): UMLPackage =
      contained(build[UMLPackage](config: _*))
  }
  
  type TemplateSignature = org.eclipse.uml2.uml.TemplateSignature
  object TemplateSignature {
    def apply(config: (TemplateSignature ⇒ Any)*): TemplateSignature =
      contained(build[TemplateSignature](config: _*))
  }
  
  type TemplateParameter = org.eclipse.uml2.uml.TemplateParameter
  object TemplateParameter {
    def apply(config: (TemplateParameter ⇒ Any)*): TemplateParameter =
      contained(build[TemplateParameter](config: _*))
  }
  
  type TemplateBinding = org.eclipse.uml2.uml.TemplateBinding
  object TemplateBinding {
    def apply(config: (TemplateBinding ⇒ Any)*): TemplateBinding =
      contained(build[TemplateBinding](config: _*))
  }
  
  type TemplateParameterSubstitution = org.eclipse.uml2.uml.TemplateParameterSubstitution
  object TemplateParameterSubstitution {
    def apply(config: (TemplateParameterSubstitution ⇒ Any)*): TemplateParameterSubstitution =
      contained(build[TemplateParameterSubstitution](config: _*))
  }
  
  type PackageMerge = org.eclipse.uml2.uml.PackageMerge
  object PackageMerge {
    def apply(config: (PackageMerge ⇒ Any)*): PackageMerge =
      contained(build[PackageMerge](config: _*))
  }
  
  type ProfileApplication = org.eclipse.uml2.uml.ProfileApplication
  object ProfileApplication {
    def apply(config: (ProfileApplication ⇒ Any)*): ProfileApplication =
      contained(build[ProfileApplication](config: _*))
  }
  
  type Profile = org.eclipse.uml2.uml.Profile
  object Profile {
    def apply(config: (Profile ⇒ Any)*): Profile =
      contained(build[Profile](config: _*))
  }
  
  type ElementImport = org.eclipse.uml2.uml.ElementImport
  object ElementImport {
    def apply(config: (ElementImport ⇒ Any)*): ElementImport =
      contained(build[ElementImport](config: _*))
  }
  
  type PackageImport = org.eclipse.uml2.uml.PackageImport
  object PackageImport {
    def apply(config: (PackageImport ⇒ Any)*): PackageImport =
      contained(build[PackageImport](config: _*))
  }
  
  type Extension = org.eclipse.uml2.uml.Extension
  object Extension {
    def apply(config: (Extension ⇒ Any)*): Extension =
      contained(build[Extension](config: _*))
  }
  
  type Association = org.eclipse.uml2.uml.Association
  object Association {
    def apply(config: (Association ⇒ Any)*): Association =
      contained(build[Association](config: _*))
  }
  
  type Property = org.eclipse.uml2.uml.Property
  object Property {
    def apply(config: (Property ⇒ Any)*): Property =
      contained(build[Property](config: _*))
  }
  
  type ConnectorEnd = org.eclipse.uml2.uml.ConnectorEnd
  object ConnectorEnd {
    def apply(config: (ConnectorEnd ⇒ Any)*): ConnectorEnd =
      contained(build[ConnectorEnd](config: _*))
  }
  
  type ConnectableElementTemplateParameter = org.eclipse.uml2.uml.ConnectableElementTemplateParameter
  object ConnectableElementTemplateParameter {
    def apply(config: (ConnectableElementTemplateParameter ⇒ Any)*): ConnectableElementTemplateParameter =
      contained(build[ConnectableElementTemplateParameter](config: _*))
  }
  
  type Deployment = org.eclipse.uml2.uml.Deployment
  object Deployment {
    def apply(config: (Deployment ⇒ Any)*): Deployment =
      contained(build[Deployment](config: _*))
  }
  
  type DeploymentSpecification = org.eclipse.uml2.uml.DeploymentSpecification
  object DeploymentSpecification {
    def apply(config: (DeploymentSpecification ⇒ Any)*): DeploymentSpecification =
      contained(build[DeploymentSpecification](config: _*))
  }
  
  type Artifact = org.eclipse.uml2.uml.Artifact
  object Artifact {
    def apply(config: (Artifact ⇒ Any)*): Artifact =
      contained(build[Artifact](config: _*))
  }
  
  type Manifestation = org.eclipse.uml2.uml.Manifestation
  object Manifestation {
    def apply(config: (Manifestation ⇒ Any)*): Manifestation =
      contained(build[Manifestation](config: _*))
  }
  
  type Operation = org.eclipse.uml2.uml.Operation
  object Operation {
    def apply(config: (Operation ⇒ Any)*): Operation =
      contained(build[Operation](config: _*))
  }
  
  type InterfaceRealization = org.eclipse.uml2.uml.InterfaceRealization
  object InterfaceRealization {
    def apply(config: (InterfaceRealization ⇒ Any)*): InterfaceRealization =
      contained(build[InterfaceRealization](config: _*))
  }
  
  type Realization = org.eclipse.uml2.uml.Realization
  object Realization {
    def apply(config: (Realization ⇒ Any)*): Realization =
      contained(build[Realization](config: _*))
  }
  
  type Interface = org.eclipse.uml2.uml.Interface
  object Interface {
    def apply(config: (Interface ⇒ Any)*): Interface =
      contained(build[Interface](config: _*))
  }
  
  type Reception = org.eclipse.uml2.uml.Reception
  object Reception {
    def apply(config: (Reception ⇒ Any)*): Reception =
      contained(build[Reception](config: _*))
  }
  
  type Signal = org.eclipse.uml2.uml.Signal
  object Signal {
    def apply(config: (Signal ⇒ Any)*): Signal =
      contained(build[Signal](config: _*))
  }
  
  type ProtocolStateMachine = org.eclipse.uml2.uml.ProtocolStateMachine
  object ProtocolStateMachine {
    def apply(config: (ProtocolStateMachine ⇒ Any)*): ProtocolStateMachine =
      contained(build[ProtocolStateMachine](config: _*))
  }
  
  type StateMachine = org.eclipse.uml2.uml.StateMachine
  object StateMachine {
    def apply(config: (StateMachine ⇒ Any)*): StateMachine =
      contained(build[StateMachine](config: _*))
  }
  
  type Pseudostate = org.eclipse.uml2.uml.Pseudostate
  object Pseudostate {
    def apply(config: (Pseudostate ⇒ Any)*): Pseudostate =
      contained(build[Pseudostate](config: _*))
  }
  
  type Region = org.eclipse.uml2.uml.Region
  object Region {
    def apply(config: (Region ⇒ Any)*): Region =
      contained(build[Region](config: _*))
  }
  
  type State = org.eclipse.uml2.uml.State
  object State {
    def apply(config: (State ⇒ Any)*): State =
      contained(build[State](config: _*))
  }
  
  type ConnectionPointReference = org.eclipse.uml2.uml.ConnectionPointReference
  object ConnectionPointReference {
    def apply(config: (ConnectionPointReference ⇒ Any)*): ConnectionPointReference =
      contained(build[ConnectionPointReference](config: _*))
  }
  
  type Trigger = org.eclipse.uml2.uml.Trigger
  object Trigger {
    def apply(config: (Trigger ⇒ Any)*): Trigger =
      contained(build[Trigger](config: _*))
  }
  
  type Port = org.eclipse.uml2.uml.Port
  object Port {
    def apply(config: (Port ⇒ Any)*): Port =
      contained(build[Port](config: _*))
  }
  
  type Constraint = org.eclipse.uml2.uml.Constraint
  object Constraint {
    def apply(config: (Constraint ⇒ Any)*): Constraint =
      contained(build[Constraint](config: _*))
  }
  
  type Transition = org.eclipse.uml2.uml.Transition
  object Transition {
    def apply(config: (Transition ⇒ Any)*): Transition =
      contained(build[Transition](config: _*))
  }
  
  type ProtocolConformance = org.eclipse.uml2.uml.ProtocolConformance
  object ProtocolConformance {
    def apply(config: (ProtocolConformance ⇒ Any)*): ProtocolConformance =
      contained(build[ProtocolConformance](config: _*))
  }
  
  type Parameter = org.eclipse.uml2.uml.Parameter
  object Parameter {
    def apply(config: (Parameter ⇒ Any)*): Parameter =
      contained(build[Parameter](config: _*))
  }
  
  type ParameterSet = org.eclipse.uml2.uml.ParameterSet
  object ParameterSet {
    def apply(config: (ParameterSet ⇒ Any)*): ParameterSet =
      contained(build[ParameterSet](config: _*))
  }
  
  type DataType = org.eclipse.uml2.uml.DataType
  object DataType {
    def apply(config: (DataType ⇒ Any)*): DataType =
      contained(build[DataType](config: _*))
  }
  
  type OperationTemplateParameter = org.eclipse.uml2.uml.OperationTemplateParameter
  object OperationTemplateParameter {
    def apply(config: (OperationTemplateParameter ⇒ Any)*): OperationTemplateParameter =
      contained(build[OperationTemplateParameter](config: _*))
  }
  
  type ExtensionEnd = org.eclipse.uml2.uml.ExtensionEnd
  object ExtensionEnd {
    def apply(config: (ExtensionEnd ⇒ Any)*): ExtensionEnd =
      contained(build[ExtensionEnd](config: _*))
  }
  
  type Model = org.eclipse.uml2.uml.Model
  object Model {
    def apply(config: (Model ⇒ Any)*): Model =
      contained(build[Model](config: _*))
  }
  
  type Enumeration = org.eclipse.uml2.uml.Enumeration
  object Enumeration {
    def apply(config: (Enumeration ⇒ Any)*): Enumeration =
      contained(build[Enumeration](config: _*))
  }
  
  type EnumerationLiteral = org.eclipse.uml2.uml.EnumerationLiteral
  object EnumerationLiteral {
    def apply(config: (EnumerationLiteral ⇒ Any)*): EnumerationLiteral =
      contained(build[EnumerationLiteral](config: _*))
  }
  
  type InstanceSpecification = org.eclipse.uml2.uml.InstanceSpecification
  object InstanceSpecification {
    def apply(config: (InstanceSpecification ⇒ Any)*): InstanceSpecification =
      contained(build[InstanceSpecification](config: _*))
  }
  
  type Slot = org.eclipse.uml2.uml.Slot
  object Slot {
    def apply(config: (Slot ⇒ Any)*): Slot =
      contained(build[Slot](config: _*))
  }
  
  type PrimitiveType = org.eclipse.uml2.uml.PrimitiveType
  object PrimitiveType {
    def apply(config: (PrimitiveType ⇒ Any)*): PrimitiveType =
      contained(build[PrimitiveType](config: _*))
  }
  
  type Usage = org.eclipse.uml2.uml.Usage
  object Usage {
    def apply(config: (Usage ⇒ Any)*): Usage =
      contained(build[Usage](config: _*))
  }
  
  type CollaborationUse = org.eclipse.uml2.uml.CollaborationUse
  object CollaborationUse {
    def apply(config: (CollaborationUse ⇒ Any)*): CollaborationUse =
      contained(build[CollaborationUse](config: _*))
  }
  
  type Collaboration = org.eclipse.uml2.uml.Collaboration
  object Collaboration {
    def apply(config: (Collaboration ⇒ Any)*): Collaboration =
      contained(build[Collaboration](config: _*))
  }
  
  type Generalization = org.eclipse.uml2.uml.Generalization
  object Generalization {
    def apply(config: (Generalization ⇒ Any)*): Generalization =
      contained(build[Generalization](config: _*))
  }
  
  type GeneralizationSet = org.eclipse.uml2.uml.GeneralizationSet
  object GeneralizationSet {
    def apply(config: (GeneralizationSet ⇒ Any)*): GeneralizationSet =
      contained(build[GeneralizationSet](config: _*))
  }
  
  type RedefinableTemplateSignature = org.eclipse.uml2.uml.RedefinableTemplateSignature
  object RedefinableTemplateSignature {
    def apply(config: (RedefinableTemplateSignature ⇒ Any)*): RedefinableTemplateSignature =
      contained(build[RedefinableTemplateSignature](config: _*))
  }
  
  type UseCase = org.eclipse.uml2.uml.UseCase
  object UseCase {
    def apply(config: (UseCase ⇒ Any)*): UseCase =
      contained(build[UseCase](config: _*))
  }
  
  type Extend = org.eclipse.uml2.uml.Extend
  object Extend {
    def apply(config: (Extend ⇒ Any)*): Extend =
      contained(build[Extend](config: _*))
  }
  
  type ExtensionPoint = org.eclipse.uml2.uml.ExtensionPoint
  object ExtensionPoint {
    def apply(config: (ExtensionPoint ⇒ Any)*): ExtensionPoint =
      contained(build[ExtensionPoint](config: _*))
  }
  
  type Include = org.eclipse.uml2.uml.Include
  object Include {
    def apply(config: (Include ⇒ Any)*): Include =
      contained(build[Include](config: _*))
  }
  
  type Substitution = org.eclipse.uml2.uml.Substitution
  object Substitution {
    def apply(config: (Substitution ⇒ Any)*): Substitution =
      contained(build[Substitution](config: _*))
  }
  
  type ClassifierTemplateParameter = org.eclipse.uml2.uml.ClassifierTemplateParameter
  object ClassifierTemplateParameter {
    def apply(config: (ClassifierTemplateParameter ⇒ Any)*): ClassifierTemplateParameter =
      contained(build[ClassifierTemplateParameter](config: _*))
  }
  
  type Connector = org.eclipse.uml2.uml.Connector
  object Connector {
    def apply(config: (Connector ⇒ Any)*): Connector =
      contained(build[Connector](config: _*))
  }
  
  type Image = org.eclipse.uml2.uml.Image
  object Image {
    def apply(config: (Image ⇒ Any)*): Image =
      contained(build[Image](config: _*))
  }
  
  type OpaqueExpression = org.eclipse.uml2.uml.OpaqueExpression
  object OpaqueExpression {
    def apply(config: (OpaqueExpression ⇒ Any)*): OpaqueExpression =
      contained(build[OpaqueExpression](config: _*))
  }
  
  type AcceptCallAction = org.eclipse.uml2.uml.AcceptCallAction
  object AcceptCallAction {
    def apply(config: (AcceptCallAction ⇒ Any)*): AcceptCallAction =
      contained(build[AcceptCallAction](config: _*))
  }
  
  type AcceptEventAction = org.eclipse.uml2.uml.AcceptEventAction
  object AcceptEventAction {
    def apply(config: (AcceptEventAction ⇒ Any)*): AcceptEventAction =
      contained(build[AcceptEventAction](config: _*))
  }
  
  type Activity = org.eclipse.uml2.uml.Activity
  object Activity {
    def apply(config: (Activity ⇒ Any)*): Activity =
      contained(build[Activity](config: _*))
  }
  
  type ActivityPartition = org.eclipse.uml2.uml.ActivityPartition
  object ActivityPartition {
    def apply(config: (ActivityPartition ⇒ Any)*): ActivityPartition =
      contained(build[ActivityPartition](config: _*))
  }
  
  type StructuredActivityNode = org.eclipse.uml2.uml.StructuredActivityNode
  object StructuredActivityNode {
    def apply(config: (StructuredActivityNode ⇒ Any)*): StructuredActivityNode =
      contained(build[StructuredActivityNode](config: _*))
  }
  
  type InputPin = org.eclipse.uml2.uml.InputPin
  object InputPin {
    def apply(config: (InputPin ⇒ Any)*): InputPin =
      contained(build[InputPin](config: _*))
  }
  
  type OutputPin = org.eclipse.uml2.uml.OutputPin
  object OutputPin {
    def apply(config: (OutputPin ⇒ Any)*): OutputPin =
      contained(build[OutputPin](config: _*))
  }
  
  type Variable = org.eclipse.uml2.uml.Variable
  object Variable {
    def apply(config: (Variable ⇒ Any)*): Variable =
      contained(build[Variable](config: _*))
  }
  
  type InterruptibleActivityRegion = org.eclipse.uml2.uml.InterruptibleActivityRegion
  object InterruptibleActivityRegion {
    def apply(config: (InterruptibleActivityRegion ⇒ Any)*): InterruptibleActivityRegion =
      contained(build[InterruptibleActivityRegion](config: _*))
  }
  
  type ExceptionHandler = org.eclipse.uml2.uml.ExceptionHandler
  object ExceptionHandler {
    def apply(config: (ExceptionHandler ⇒ Any)*): ExceptionHandler =
      contained(build[ExceptionHandler](config: _*))
  }
  
  type ActionExecutionSpecification = org.eclipse.uml2.uml.ActionExecutionSpecification
  object ActionExecutionSpecification {
    def apply(config: (ActionExecutionSpecification ⇒ Any)*): ActionExecutionSpecification =
      contained(build[ActionExecutionSpecification](config: _*))
  }
  
  type Lifeline = org.eclipse.uml2.uml.Lifeline
  object Lifeline {
    def apply(config: (Lifeline ⇒ Any)*): Lifeline =
      contained(build[Lifeline](config: _*))
  }
  
  type PartDecomposition = org.eclipse.uml2.uml.PartDecomposition
  object PartDecomposition {
    def apply(config: (PartDecomposition ⇒ Any)*): PartDecomposition =
      contained(build[PartDecomposition](config: _*))
  }
  
  type InteractionUse = org.eclipse.uml2.uml.InteractionUse
  object InteractionUse {
    def apply(config: (InteractionUse ⇒ Any)*): InteractionUse =
      contained(build[InteractionUse](config: _*))
  }
  
  type Gate = org.eclipse.uml2.uml.Gate
  object Gate {
    def apply(config: (Gate ⇒ Any)*): Gate =
      contained(build[Gate](config: _*))
  }
  
  type Message = org.eclipse.uml2.uml.Message
  object Message {
    def apply(config: (Message ⇒ Any)*): Message =
      contained(build[Message](config: _*))
  }
  
  type Interaction = org.eclipse.uml2.uml.Interaction
  object Interaction {
    def apply(config: (Interaction ⇒ Any)*): Interaction =
      contained(build[Interaction](config: _*))
  }
  
  type InteractionOperand = org.eclipse.uml2.uml.InteractionOperand
  object InteractionOperand {
    def apply(config: (InteractionOperand ⇒ Any)*): InteractionOperand =
      contained(build[InteractionOperand](config: _*))
  }
  
  type InteractionConstraint = org.eclipse.uml2.uml.InteractionConstraint
  object InteractionConstraint {
    def apply(config: (InteractionConstraint ⇒ Any)*): InteractionConstraint =
      contained(build[InteractionConstraint](config: _*))
  }
  
  type GeneralOrdering = org.eclipse.uml2.uml.GeneralOrdering
  object GeneralOrdering {
    def apply(config: (GeneralOrdering ⇒ Any)*): GeneralOrdering =
      contained(build[GeneralOrdering](config: _*))
  }
  
  type OccurrenceSpecification = org.eclipse.uml2.uml.OccurrenceSpecification
  object OccurrenceSpecification {
    def apply(config: (OccurrenceSpecification ⇒ Any)*): OccurrenceSpecification =
      contained(build[OccurrenceSpecification](config: _*))
  }
  
  type ActionInputPin = org.eclipse.uml2.uml.ActionInputPin
  object ActionInputPin {
    def apply(config: (ActionInputPin ⇒ Any)*): ActionInputPin =
      contained(build[ActionInputPin](config: _*))
  }
  
  type ActivityFinalNode = org.eclipse.uml2.uml.ActivityFinalNode
  object ActivityFinalNode {
    def apply(config: (ActivityFinalNode ⇒ Any)*): ActivityFinalNode =
      contained(build[ActivityFinalNode](config: _*))
  }
  
  type ActivityParameterNode = org.eclipse.uml2.uml.ActivityParameterNode
  object ActivityParameterNode {
    def apply(config: (ActivityParameterNode ⇒ Any)*): ActivityParameterNode =
      contained(build[ActivityParameterNode](config: _*))
  }
  
  type Actor = org.eclipse.uml2.uml.Actor
  object Actor {
    def apply(config: (Actor ⇒ Any)*): Actor =
      contained(build[Actor](config: _*))
  }
  
  type AddStructuralFeatureValueAction = org.eclipse.uml2.uml.AddStructuralFeatureValueAction
  object AddStructuralFeatureValueAction {
    def apply(config: (AddStructuralFeatureValueAction ⇒ Any)*): AddStructuralFeatureValueAction =
      contained(build[AddStructuralFeatureValueAction](config: _*))
  }
  
  type AddVariableValueAction = org.eclipse.uml2.uml.AddVariableValueAction
  object AddVariableValueAction {
    def apply(config: (AddVariableValueAction ⇒ Any)*): AddVariableValueAction =
      contained(build[AddVariableValueAction](config: _*))
  }
  
  type AnyReceiveEvent = org.eclipse.uml2.uml.AnyReceiveEvent
  object AnyReceiveEvent {
    def apply(config: (AnyReceiveEvent ⇒ Any)*): AnyReceiveEvent =
      contained(build[AnyReceiveEvent](config: _*))
  }
  
  type AssociationClass = org.eclipse.uml2.uml.AssociationClass
  object AssociationClass {
    def apply(config: (AssociationClass ⇒ Any)*): AssociationClass =
      contained(build[AssociationClass](config: _*))
  }
  
  type BehaviorExecutionSpecification = org.eclipse.uml2.uml.BehaviorExecutionSpecification
  object BehaviorExecutionSpecification {
    def apply(config: (BehaviorExecutionSpecification ⇒ Any)*): BehaviorExecutionSpecification =
      contained(build[BehaviorExecutionSpecification](config: _*))
  }
  
  type BroadcastSignalAction = org.eclipse.uml2.uml.BroadcastSignalAction
  object BroadcastSignalAction {
    def apply(config: (BroadcastSignalAction ⇒ Any)*): BroadcastSignalAction =
      contained(build[BroadcastSignalAction](config: _*))
  }
  
  type CallBehaviorAction = org.eclipse.uml2.uml.CallBehaviorAction
  object CallBehaviorAction {
    def apply(config: (CallBehaviorAction ⇒ Any)*): CallBehaviorAction =
      contained(build[CallBehaviorAction](config: _*))
  }
  
  type CallEvent = org.eclipse.uml2.uml.CallEvent
  object CallEvent {
    def apply(config: (CallEvent ⇒ Any)*): CallEvent =
      contained(build[CallEvent](config: _*))
  }
  
  type CallOperationAction = org.eclipse.uml2.uml.CallOperationAction
  object CallOperationAction {
    def apply(config: (CallOperationAction ⇒ Any)*): CallOperationAction =
      contained(build[CallOperationAction](config: _*))
  }
  
  type CentralBufferNode = org.eclipse.uml2.uml.CentralBufferNode
  object CentralBufferNode {
    def apply(config: (CentralBufferNode ⇒ Any)*): CentralBufferNode =
      contained(build[CentralBufferNode](config: _*))
  }
  
  type ChangeEvent = org.eclipse.uml2.uml.ChangeEvent
  object ChangeEvent {
    def apply(config: (ChangeEvent ⇒ Any)*): ChangeEvent =
      contained(build[ChangeEvent](config: _*))
  }
  
  type Clause = org.eclipse.uml2.uml.Clause
  object Clause {
    def apply(config: (Clause ⇒ Any)*): Clause =
      contained(build[Clause](config: _*))
  }
  
  type ClearAssociationAction = org.eclipse.uml2.uml.ClearAssociationAction
  object ClearAssociationAction {
    def apply(config: (ClearAssociationAction ⇒ Any)*): ClearAssociationAction =
      contained(build[ClearAssociationAction](config: _*))
  }
  
  type ClearStructuralFeatureAction = org.eclipse.uml2.uml.ClearStructuralFeatureAction
  object ClearStructuralFeatureAction {
    def apply(config: (ClearStructuralFeatureAction ⇒ Any)*): ClearStructuralFeatureAction =
      contained(build[ClearStructuralFeatureAction](config: _*))
  }
  
  type ClearVariableAction = org.eclipse.uml2.uml.ClearVariableAction
  object ClearVariableAction {
    def apply(config: (ClearVariableAction ⇒ Any)*): ClearVariableAction =
      contained(build[ClearVariableAction](config: _*))
  }
  
  type CombinedFragment = org.eclipse.uml2.uml.CombinedFragment
  object CombinedFragment {
    def apply(config: (CombinedFragment ⇒ Any)*): CombinedFragment =
      contained(build[CombinedFragment](config: _*))
  }
  
  type CommunicationPath = org.eclipse.uml2.uml.CommunicationPath
  object CommunicationPath {
    def apply(config: (CommunicationPath ⇒ Any)*): CommunicationPath =
      contained(build[CommunicationPath](config: _*))
  }
  
  type Component = org.eclipse.uml2.uml.Component
  object Component {
    def apply(config: (Component ⇒ Any)*): Component =
      contained(build[Component](config: _*))
  }
  
  type ComponentRealization = org.eclipse.uml2.uml.ComponentRealization
  object ComponentRealization {
    def apply(config: (ComponentRealization ⇒ Any)*): ComponentRealization =
      contained(build[ComponentRealization](config: _*))
  }
  
  type ConditionalNode = org.eclipse.uml2.uml.ConditionalNode
  object ConditionalNode {
    def apply(config: (ConditionalNode ⇒ Any)*): ConditionalNode =
      contained(build[ConditionalNode](config: _*))
  }
  
  type ConsiderIgnoreFragment = org.eclipse.uml2.uml.ConsiderIgnoreFragment
  object ConsiderIgnoreFragment {
    def apply(config: (ConsiderIgnoreFragment ⇒ Any)*): ConsiderIgnoreFragment =
      contained(build[ConsiderIgnoreFragment](config: _*))
  }
  
  type Continuation = org.eclipse.uml2.uml.Continuation
  object Continuation {
    def apply(config: (Continuation ⇒ Any)*): Continuation =
      contained(build[Continuation](config: _*))
  }
  
  type ControlFlow = org.eclipse.uml2.uml.ControlFlow
  object ControlFlow {
    def apply(config: (ControlFlow ⇒ Any)*): ControlFlow =
      contained(build[ControlFlow](config: _*))
  }
  
  type CreateLinkAction = org.eclipse.uml2.uml.CreateLinkAction
  object CreateLinkAction {
    def apply(config: (CreateLinkAction ⇒ Any)*): CreateLinkAction =
      contained(build[CreateLinkAction](config: _*))
  }
  
  type LinkEndData = org.eclipse.uml2.uml.LinkEndData
  object LinkEndData {
    def apply(config: (LinkEndData ⇒ Any)*): LinkEndData =
      contained(build[LinkEndData](config: _*))
  }
  
  type QualifierValue = org.eclipse.uml2.uml.QualifierValue
  object QualifierValue {
    def apply(config: (QualifierValue ⇒ Any)*): QualifierValue =
      contained(build[QualifierValue](config: _*))
  }
  
  type LinkEndCreationData = org.eclipse.uml2.uml.LinkEndCreationData
  object LinkEndCreationData {
    def apply(config: (LinkEndCreationData ⇒ Any)*): LinkEndCreationData =
      contained(build[LinkEndCreationData](config: _*))
  }
  
  type CreateLinkObjectAction = org.eclipse.uml2.uml.CreateLinkObjectAction
  object CreateLinkObjectAction {
    def apply(config: (CreateLinkObjectAction ⇒ Any)*): CreateLinkObjectAction =
      contained(build[CreateLinkObjectAction](config: _*))
  }
  
  type CreateObjectAction = org.eclipse.uml2.uml.CreateObjectAction
  object CreateObjectAction {
    def apply(config: (CreateObjectAction ⇒ Any)*): CreateObjectAction =
      contained(build[CreateObjectAction](config: _*))
  }
  
  type DataStoreNode = org.eclipse.uml2.uml.DataStoreNode
  object DataStoreNode {
    def apply(config: (DataStoreNode ⇒ Any)*): DataStoreNode =
      contained(build[DataStoreNode](config: _*))
  }
  
  type DecisionNode = org.eclipse.uml2.uml.DecisionNode
  object DecisionNode {
    def apply(config: (DecisionNode ⇒ Any)*): DecisionNode =
      contained(build[DecisionNode](config: _*))
  }
  
  type ObjectFlow = org.eclipse.uml2.uml.ObjectFlow
  object ObjectFlow {
    def apply(config: (ObjectFlow ⇒ Any)*): ObjectFlow =
      contained(build[ObjectFlow](config: _*))
  }
  
  type DestroyLinkAction = org.eclipse.uml2.uml.DestroyLinkAction
  object DestroyLinkAction {
    def apply(config: (DestroyLinkAction ⇒ Any)*): DestroyLinkAction =
      contained(build[DestroyLinkAction](config: _*))
  }
  
  type LinkEndDestructionData = org.eclipse.uml2.uml.LinkEndDestructionData
  object LinkEndDestructionData {
    def apply(config: (LinkEndDestructionData ⇒ Any)*): LinkEndDestructionData =
      contained(build[LinkEndDestructionData](config: _*))
  }
  
  type DestroyObjectAction = org.eclipse.uml2.uml.DestroyObjectAction
  object DestroyObjectAction {
    def apply(config: (DestroyObjectAction ⇒ Any)*): DestroyObjectAction =
      contained(build[DestroyObjectAction](config: _*))
  }
  
  type DestructionOccurrenceSpecification = org.eclipse.uml2.uml.DestructionOccurrenceSpecification
  object DestructionOccurrenceSpecification {
    def apply(config: (DestructionOccurrenceSpecification ⇒ Any)*): DestructionOccurrenceSpecification =
      contained(build[DestructionOccurrenceSpecification](config: _*))
  }
  
  type MessageOccurrenceSpecification = org.eclipse.uml2.uml.MessageOccurrenceSpecification
  object MessageOccurrenceSpecification {
    def apply(config: (MessageOccurrenceSpecification ⇒ Any)*): MessageOccurrenceSpecification =
      contained(build[MessageOccurrenceSpecification](config: _*))
  }
  
  type Device = org.eclipse.uml2.uml.Device
  object Device {
    def apply(config: (Device ⇒ Any)*): Device =
      contained(build[Device](config: _*))
  }
  
  type Node = org.eclipse.uml2.uml.Node
  object Node {
    def apply(config: (Node ⇒ Any)*): Node =
      contained(build[Node](config: _*))
  }
  
  type Duration = org.eclipse.uml2.uml.Duration
  object Duration {
    def apply(config: (Duration ⇒ Any)*): Duration =
      contained(build[Duration](config: _*))
  }
  
  type IntervalConstraint = org.eclipse.uml2.uml.IntervalConstraint
  object IntervalConstraint {
    def apply(config: (IntervalConstraint ⇒ Any)*): IntervalConstraint =
      contained(build[IntervalConstraint](config: _*))
  }
  
  type Interval = org.eclipse.uml2.uml.Interval
  object Interval {
    def apply(config: (Interval ⇒ Any)*): Interval =
      contained(build[Interval](config: _*))
  }
  
  type DurationInterval = org.eclipse.uml2.uml.DurationInterval
  object DurationInterval {
    def apply(config: (DurationInterval ⇒ Any)*): DurationInterval =
      contained(build[DurationInterval](config: _*))
  }
  
  type ExecutionEnvironment = org.eclipse.uml2.uml.ExecutionEnvironment
  object ExecutionEnvironment {
    def apply(config: (ExecutionEnvironment ⇒ Any)*): ExecutionEnvironment =
      contained(build[ExecutionEnvironment](config: _*))
  }
  
  type ExecutionOccurrenceSpecification = org.eclipse.uml2.uml.ExecutionOccurrenceSpecification
  object ExecutionOccurrenceSpecification {
    def apply(config: (ExecutionOccurrenceSpecification ⇒ Any)*): ExecutionOccurrenceSpecification =
      contained(build[ExecutionOccurrenceSpecification](config: _*))
  }
  
  type ExpansionNode = org.eclipse.uml2.uml.ExpansionNode
  object ExpansionNode {
    def apply(config: (ExpansionNode ⇒ Any)*): ExpansionNode =
      contained(build[ExpansionNode](config: _*))
  }
  
  type ExpansionRegion = org.eclipse.uml2.uml.ExpansionRegion
  object ExpansionRegion {
    def apply(config: (ExpansionRegion ⇒ Any)*): ExpansionRegion =
      contained(build[ExpansionRegion](config: _*))
  }
  
  type FinalState = org.eclipse.uml2.uml.FinalState
  object FinalState {
    def apply(config: (FinalState ⇒ Any)*): FinalState =
      contained(build[FinalState](config: _*))
  }
  
  type FlowFinalNode = org.eclipse.uml2.uml.FlowFinalNode
  object FlowFinalNode {
    def apply(config: (FlowFinalNode ⇒ Any)*): FlowFinalNode =
      contained(build[FlowFinalNode](config: _*))
  }
  
  type ForkNode = org.eclipse.uml2.uml.ForkNode
  object ForkNode {
    def apply(config: (ForkNode ⇒ Any)*): ForkNode =
      contained(build[ForkNode](config: _*))
  }
  
  type FunctionBehavior = org.eclipse.uml2.uml.FunctionBehavior
  object FunctionBehavior {
    def apply(config: (FunctionBehavior ⇒ Any)*): FunctionBehavior =
      contained(build[FunctionBehavior](config: _*))
  }
  
  type OpaqueBehavior = org.eclipse.uml2.uml.OpaqueBehavior
  object OpaqueBehavior {
    def apply(config: (OpaqueBehavior ⇒ Any)*): OpaqueBehavior =
      contained(build[OpaqueBehavior](config: _*))
  }
  
  type InformationFlow = org.eclipse.uml2.uml.InformationFlow
  object InformationFlow {
    def apply(config: (InformationFlow ⇒ Any)*): InformationFlow =
      contained(build[InformationFlow](config: _*))
  }
  
  type InformationItem = org.eclipse.uml2.uml.InformationItem
  object InformationItem {
    def apply(config: (InformationItem ⇒ Any)*): InformationItem =
      contained(build[InformationItem](config: _*))
  }
  
  type InitialNode = org.eclipse.uml2.uml.InitialNode
  object InitialNode {
    def apply(config: (InitialNode ⇒ Any)*): InitialNode =
      contained(build[InitialNode](config: _*))
  }
  
  type InstanceValue = org.eclipse.uml2.uml.InstanceValue
  object InstanceValue {
    def apply(config: (InstanceValue ⇒ Any)*): InstanceValue =
      contained(build[InstanceValue](config: _*))
  }
  
  type JoinNode = org.eclipse.uml2.uml.JoinNode
  object JoinNode {
    def apply(config: (JoinNode ⇒ Any)*): JoinNode =
      contained(build[JoinNode](config: _*))
  }
  
  type LiteralBoolean = org.eclipse.uml2.uml.LiteralBoolean
  object LiteralBoolean {
    def apply(config: (LiteralBoolean ⇒ Any)*): LiteralBoolean =
      contained(build[LiteralBoolean](config: _*))
  }
  
  type LiteralInteger = org.eclipse.uml2.uml.LiteralInteger
  object LiteralInteger {
    def apply(config: (LiteralInteger ⇒ Any)*): LiteralInteger =
      contained(build[LiteralInteger](config: _*))
  }
  
  type LiteralNull = org.eclipse.uml2.uml.LiteralNull
  object LiteralNull {
    def apply(config: (LiteralNull ⇒ Any)*): LiteralNull =
      contained(build[LiteralNull](config: _*))
  }
  
  type LiteralReal = org.eclipse.uml2.uml.LiteralReal
  object LiteralReal {
    def apply(config: (LiteralReal ⇒ Any)*): LiteralReal =
      contained(build[LiteralReal](config: _*))
  }
  
  type LiteralString = org.eclipse.uml2.uml.LiteralString
  object LiteralString {
    def apply(config: (LiteralString ⇒ Any)*): LiteralString =
      contained(build[LiteralString](config: _*))
  }
  
  type LiteralUnlimitedNatural = org.eclipse.uml2.uml.LiteralUnlimitedNatural
  object LiteralUnlimitedNatural {
    def apply(config: (LiteralUnlimitedNatural ⇒ Any)*): LiteralUnlimitedNatural =
      contained(build[LiteralUnlimitedNatural](config: _*))
  }
  
  type LoopNode = org.eclipse.uml2.uml.LoopNode
  object LoopNode {
    def apply(config: (LoopNode ⇒ Any)*): LoopNode =
      contained(build[LoopNode](config: _*))
  }
  
  type MergeNode = org.eclipse.uml2.uml.MergeNode
  object MergeNode {
    def apply(config: (MergeNode ⇒ Any)*): MergeNode =
      contained(build[MergeNode](config: _*))
  }
  
  type OpaqueAction = org.eclipse.uml2.uml.OpaqueAction
  object OpaqueAction {
    def apply(config: (OpaqueAction ⇒ Any)*): OpaqueAction =
      contained(build[OpaqueAction](config: _*))
  }
  
  type ProtocolTransition = org.eclipse.uml2.uml.ProtocolTransition
  object ProtocolTransition {
    def apply(config: (ProtocolTransition ⇒ Any)*): ProtocolTransition =
      contained(build[ProtocolTransition](config: _*))
  }
  
  type RaiseExceptionAction = org.eclipse.uml2.uml.RaiseExceptionAction
  object RaiseExceptionAction {
    def apply(config: (RaiseExceptionAction ⇒ Any)*): RaiseExceptionAction =
      contained(build[RaiseExceptionAction](config: _*))
  }
  
  type ReadExtentAction = org.eclipse.uml2.uml.ReadExtentAction
  object ReadExtentAction {
    def apply(config: (ReadExtentAction ⇒ Any)*): ReadExtentAction =
      contained(build[ReadExtentAction](config: _*))
  }
  
  type ReadIsClassifiedObjectAction = org.eclipse.uml2.uml.ReadIsClassifiedObjectAction
  object ReadIsClassifiedObjectAction {
    def apply(config: (ReadIsClassifiedObjectAction ⇒ Any)*): ReadIsClassifiedObjectAction =
      contained(build[ReadIsClassifiedObjectAction](config: _*))
  }
  
  type ReadLinkAction = org.eclipse.uml2.uml.ReadLinkAction
  object ReadLinkAction {
    def apply(config: (ReadLinkAction ⇒ Any)*): ReadLinkAction =
      contained(build[ReadLinkAction](config: _*))
  }
  
  type ReadLinkObjectEndAction = org.eclipse.uml2.uml.ReadLinkObjectEndAction
  object ReadLinkObjectEndAction {
    def apply(config: (ReadLinkObjectEndAction ⇒ Any)*): ReadLinkObjectEndAction =
      contained(build[ReadLinkObjectEndAction](config: _*))
  }
  
  type ReadLinkObjectEndQualifierAction = org.eclipse.uml2.uml.ReadLinkObjectEndQualifierAction
  object ReadLinkObjectEndQualifierAction {
    def apply(config: (ReadLinkObjectEndQualifierAction ⇒ Any)*): ReadLinkObjectEndQualifierAction =
      contained(build[ReadLinkObjectEndQualifierAction](config: _*))
  }
  
  type ReadSelfAction = org.eclipse.uml2.uml.ReadSelfAction
  object ReadSelfAction {
    def apply(config: (ReadSelfAction ⇒ Any)*): ReadSelfAction =
      contained(build[ReadSelfAction](config: _*))
  }
  
  type ReadStructuralFeatureAction = org.eclipse.uml2.uml.ReadStructuralFeatureAction
  object ReadStructuralFeatureAction {
    def apply(config: (ReadStructuralFeatureAction ⇒ Any)*): ReadStructuralFeatureAction =
      contained(build[ReadStructuralFeatureAction](config: _*))
  }
  
  type ReadVariableAction = org.eclipse.uml2.uml.ReadVariableAction
  object ReadVariableAction {
    def apply(config: (ReadVariableAction ⇒ Any)*): ReadVariableAction =
      contained(build[ReadVariableAction](config: _*))
  }
  
  type ReclassifyObjectAction = org.eclipse.uml2.uml.ReclassifyObjectAction
  object ReclassifyObjectAction {
    def apply(config: (ReclassifyObjectAction ⇒ Any)*): ReclassifyObjectAction =
      contained(build[ReclassifyObjectAction](config: _*))
  }
  
  type ReduceAction = org.eclipse.uml2.uml.ReduceAction
  object ReduceAction {
    def apply(config: (ReduceAction ⇒ Any)*): ReduceAction =
      contained(build[ReduceAction](config: _*))
  }
  
  type RemoveStructuralFeatureValueAction = org.eclipse.uml2.uml.RemoveStructuralFeatureValueAction
  object RemoveStructuralFeatureValueAction {
    def apply(config: (RemoveStructuralFeatureValueAction ⇒ Any)*): RemoveStructuralFeatureValueAction =
      contained(build[RemoveStructuralFeatureValueAction](config: _*))
  }
  
  type RemoveVariableValueAction = org.eclipse.uml2.uml.RemoveVariableValueAction
  object RemoveVariableValueAction {
    def apply(config: (RemoveVariableValueAction ⇒ Any)*): RemoveVariableValueAction =
      contained(build[RemoveVariableValueAction](config: _*))
  }
  
  type ReplyAction = org.eclipse.uml2.uml.ReplyAction
  object ReplyAction {
    def apply(config: (ReplyAction ⇒ Any)*): ReplyAction =
      contained(build[ReplyAction](config: _*))
  }
  
  type SendObjectAction = org.eclipse.uml2.uml.SendObjectAction
  object SendObjectAction {
    def apply(config: (SendObjectAction ⇒ Any)*): SendObjectAction =
      contained(build[SendObjectAction](config: _*))
  }
  
  type SendSignalAction = org.eclipse.uml2.uml.SendSignalAction
  object SendSignalAction {
    def apply(config: (SendSignalAction ⇒ Any)*): SendSignalAction =
      contained(build[SendSignalAction](config: _*))
  }
  
  type SequenceNode = org.eclipse.uml2.uml.SequenceNode
  object SequenceNode {
    def apply(config: (SequenceNode ⇒ Any)*): SequenceNode =
      contained(build[SequenceNode](config: _*))
  }
  
  type SignalEvent = org.eclipse.uml2.uml.SignalEvent
  object SignalEvent {
    def apply(config: (SignalEvent ⇒ Any)*): SignalEvent =
      contained(build[SignalEvent](config: _*))
  }
  
  type StartClassifierBehaviorAction = org.eclipse.uml2.uml.StartClassifierBehaviorAction
  object StartClassifierBehaviorAction {
    def apply(config: (StartClassifierBehaviorAction ⇒ Any)*): StartClassifierBehaviorAction =
      contained(build[StartClassifierBehaviorAction](config: _*))
  }
  
  type StartObjectBehaviorAction = org.eclipse.uml2.uml.StartObjectBehaviorAction
  object StartObjectBehaviorAction {
    def apply(config: (StartObjectBehaviorAction ⇒ Any)*): StartObjectBehaviorAction =
      contained(build[StartObjectBehaviorAction](config: _*))
  }
  
  type StateInvariant = org.eclipse.uml2.uml.StateInvariant
  object StateInvariant {
    def apply(config: (StateInvariant ⇒ Any)*): StateInvariant =
      contained(build[StateInvariant](config: _*))
  }
  
  type TestIdentityAction = org.eclipse.uml2.uml.TestIdentityAction
  object TestIdentityAction {
    def apply(config: (TestIdentityAction ⇒ Any)*): TestIdentityAction =
      contained(build[TestIdentityAction](config: _*))
  }
  
  type TimeConstraint = org.eclipse.uml2.uml.TimeConstraint
  object TimeConstraint {
    def apply(config: (TimeConstraint ⇒ Any)*): TimeConstraint =
      contained(build[TimeConstraint](config: _*))
  }
  
  type TimeInterval = org.eclipse.uml2.uml.TimeInterval
  object TimeInterval {
    def apply(config: (TimeInterval ⇒ Any)*): TimeInterval =
      contained(build[TimeInterval](config: _*))
  }
  
  type TimeExpression = org.eclipse.uml2.uml.TimeExpression
  object TimeExpression {
    def apply(config: (TimeExpression ⇒ Any)*): TimeExpression =
      contained(build[TimeExpression](config: _*))
  }
  
  type TimeEvent = org.eclipse.uml2.uml.TimeEvent
  object TimeEvent {
    def apply(config: (TimeEvent ⇒ Any)*): TimeEvent =
      contained(build[TimeEvent](config: _*))
  }
  
  type TimeObservation = org.eclipse.uml2.uml.TimeObservation
  object TimeObservation {
    def apply(config: (TimeObservation ⇒ Any)*): TimeObservation =
      contained(build[TimeObservation](config: _*))
  }
  
  type UnmarshallAction = org.eclipse.uml2.uml.UnmarshallAction
  object UnmarshallAction {
    def apply(config: (UnmarshallAction ⇒ Any)*): UnmarshallAction =
      contained(build[UnmarshallAction](config: _*))
  }
  
  type ValuePin = org.eclipse.uml2.uml.ValuePin
  object ValuePin {
    def apply(config: (ValuePin ⇒ Any)*): ValuePin =
      contained(build[ValuePin](config: _*))
  }
  
  type ValueSpecificationAction = org.eclipse.uml2.uml.ValueSpecificationAction
  object ValueSpecificationAction {
    def apply(config: (ValueSpecificationAction ⇒ Any)*): ValueSpecificationAction =
      contained(build[ValueSpecificationAction](config: _*))
  }
}

object UmlAssignments extends OverloadHack {
  private def nothing: Nothing = sys.error("this method is not meant to be called")
  
  def isIndirectlyInstantiated(implicit ev: Nothing) = nothing
  def isIndirectlyInstantiated_=[T <: Component](value: Boolean) =
    (target: T) ⇒ target.setIsIndirectlyInstantiated(value)
  
  
  def static(implicit ev: Nothing) = nothing
  def static_=[T <: Feature](value: Boolean) =
    (target: T) ⇒ target.setIsStatic(value)
  
  
  def exceptionType(implicit ev: Nothing) = nothing
  def exceptionType_=[T <: ExceptionHandler](value: EList[Classifier]) =
    (target: T) ⇒ target.getExceptionTypes.addAll(value)
  
  
  def ownedReception(implicit ev: Nothing) = nothing
  def ownedReception_=[T <: org.eclipse.uml2.uml.Class](value: EList[Reception]) =
    (target: T) ⇒ target.getOwnedReceptions.addAll(value)
  
  def ownedReception_=[T <: Interface](value: EList[Reception])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getOwnedReceptions.addAll(value)
  
  
  def packageMerge(implicit ev: Nothing) = nothing
  def packageMerge_=[T <: org.eclipse.uml2.uml.Package](value: EList[PackageMerge]) =
    (target: T) ⇒ target.getPackageMerges.addAll(value)
  
  
  def execution(implicit ev: Nothing) = nothing
  def execution_=[T <: ExecutionOccurrenceSpecification](value: ExecutionSpecification) =
    (target: T) ⇒ target.setExecution(value)
  def execution_=[T <: ExecutionOccurrenceSpecification](value: ⇒ Option[ExecutionSpecification]) =
    (target: T) ⇒ target.setExecution(UmlBuilder.ref(value))
  
  
  def localPrecondition(implicit ev: Nothing) = nothing
  def localPrecondition_=[T <: Action](value: EList[Constraint]) =
    (target: T) ⇒ target.getLocalPreconditions.addAll(value)
  
  
  def ownedConnector(implicit ev: Nothing) = nothing
  def ownedConnector_=[T <: StructuredClassifier](value: EList[Connector]) =
    (target: T) ⇒ target.getOwnedConnectors.addAll(value)
  
  
  def postCondition(implicit ev: Nothing) = nothing
  def postCondition_=[T <: ProtocolTransition](value: Constraint) =
    (target: T) ⇒ target.setPostCondition(value)
  def postCondition_=[T <: ProtocolTransition](value: ⇒ Option[Constraint]) =
    (target: T) ⇒ target.setPostCondition(UmlBuilder.ref(value))
  
  
  def nameExpression(implicit ev: Nothing) = nothing
  def nameExpression_=[T <: NamedElement](value: StringExpression) =
    (target: T) ⇒ target.setNameExpression(value)
  
  
  def utilizedElement(implicit ev: Nothing) = nothing
  def utilizedElement_=[T <: Manifestation](value: PackageableElement) =
    (target: T) ⇒ target.setUtilizedElement(value)
  def utilizedElement_=[T <: Manifestation](value: ⇒ Option[PackageableElement]) =
    (target: T) ⇒ target.setUtilizedElement(UmlBuilder.ref(value))
  
  
  def isMultireceive(implicit ev: Nothing) = nothing
  def isMultireceive_=[T <: ObjectFlow](value: Boolean) =
    (target: T) ⇒ target.setIsMultireceive(value)
  
  
  def format(implicit ev: Nothing) = nothing
  def format_=[T <: Image](value: String) =
    (target: T) ⇒ target.setFormat(value)
  
  
  def returnInformation(implicit ev: Nothing) = nothing
  def returnInformation_=[T <: AcceptCallAction](value: OutputPin) =
    (target: T) ⇒ target.setReturnInformation(value)
  
  def returnInformation_=[T <: ReplyAction](value: InputPin)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setReturnInformation(value)
  
  
  def outputValue(implicit ev: Nothing) = nothing
  def outputValue_=[T <: OpaqueAction](value: EList[OutputPin]) =
    (target: T) ⇒ target.getOutputValues.addAll(value)
  
  
  def operand(implicit ev: Nothing) = nothing
  def operand_=[T <: Expression](value: EList[ValueSpecification]) =
    (target: T) ⇒ target.getOperands.addAll(value)
  
  def operand_=[T <: CombinedFragment](value: EList[InteractionOperand])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getOperands.addAll(value)
  
  
  def executableNode(implicit ev: Nothing) = nothing
  def executableNode_=[T <: SequenceNode](value: EList[ExecutableNode]) =
    (target: T) ⇒ target.getExecutableNodes.addAll(value)
  
  
  def weight(implicit ev: Nothing) = nothing
  def weight_=[T <: ActivityEdge](value: ValueSpecification) =
    (target: T) ⇒ target.setWeight(value)
  
  
  def ownedGroup(implicit ev: Nothing) = nothing
  def ownedGroup_=[T <: Activity](value: EList[ActivityGroup]) =
    (target: T) ⇒ target.getOwnedGroups.addAll(value)
  
  
  def annotatedElement(implicit ev: Nothing) = nothing
  def annotatedElement_=[T <: Comment](value: EList[Element]) =
    (target: T) ⇒ target.getAnnotatedElements.addAll(value)
  
  
  def method(implicit ev: Nothing) = nothing
  def method_=[T <: BehavioralFeature](value: EList[Behavior]) =
    (target: T) ⇒ target.getMethods.addAll(value)
  
  
  def test(implicit ev: Nothing) = nothing
  def test_=[T <: Clause](value: EList[ExecutableNode]) =
    (target: T) ⇒ target.getTests.addAll(value)
  
  def test_=[T <: LoopNode](value: EList[ExecutableNode])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getTests.addAll(value)
  
  
  def refersTo(implicit ev: Nothing) = nothing
  def refersTo_=[T <: InteractionUse](value: Interaction) =
    (target: T) ⇒ target.setRefersTo(value)
  def refersTo_=[T <: InteractionUse](value: ⇒ Option[Interaction]) =
    (target: T) ⇒ target.setRefersTo(UmlBuilder.ref(value))
  
  
  def postcondition(implicit ev: Nothing) = nothing
  def postcondition_=[T <: Operation](value: EList[Constraint]) =
    (target: T) ⇒ target.getPostconditions.addAll(value)
  
  def postcondition_=[T <: Behavior](value: EList[Constraint])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getPostconditions.addAll(value)
  
  
  def body(implicit ev: Nothing) = nothing
  def body_=[T <: Comment](value: String) =
    (target: T) ⇒ target.setBody(value)
  
  def body_=[T <: OpaqueExpression](value: EList[String])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getBodies.addAll(value)
  
  def body_=[T <: Clause](value: EList[ExecutableNode])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getBodies.addAll(value)
  
  def body_=[T <: OpaqueBehavior](value: EList[String])(implicit o: Overloaded3) =
    (target: T) ⇒ target.getBodies.addAll(value)
  
  def body_=[T <: OpaqueAction](value: EList[String])(implicit o: Overloaded4) =
    (target: T) ⇒ target.getBodies.addAll(value)
  
  
  def name(implicit ev: Nothing) = nothing
  def name_=[T <: NamedElement](value: String) =
    (target: T) ⇒ target.setName(value)
  
  
  def generalOrdering(implicit ev: Nothing) = nothing
  def generalOrdering_=[T <: InteractionFragment](value: EList[GeneralOrdering]) =
    (target: T) ⇒ target.getGeneralOrderings.addAll(value)
  
  
  def parameter(implicit ev: Nothing) = nothing
  def parameter_=[T <: TemplateSignature](value: EList[TemplateParameter]) =
    (target: T) ⇒ target.getParameters.addAll(value)
  
  def parameter_=[T <: ParameterSet](value: EList[Parameter])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getParameters.addAll(value)
  
  def parameter_=[T <: ActivityParameterNode](value: Parameter)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setParameter(value)
  def parameter_=[T <: ActivityParameterNode](value: ⇒ Option[Parameter])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setParameter(UmlBuilder.ref(value))
  
  
  def maxint(implicit ev: Nothing) = nothing
  def maxint_=[T <: InteractionConstraint](value: ValueSpecification) =
    (target: T) ⇒ target.setMaxint(value)
  
  
  def nestedArtifact(implicit ev: Nothing) = nothing
  def nestedArtifact_=[T <: Artifact](value: EList[Artifact]) =
    (target: T) ⇒ target.getNestedArtifacts.addAll(value)
  
  
  def source(implicit ev: Nothing) = nothing
  def source_=[T <: Transition](value: Vertex) =
    (target: T) ⇒ target.setSource(value)
  def source_=[T <: Transition](value: ⇒ Option[Vertex]) =
    (target: T) ⇒ target.setSource(UmlBuilder.ref(value))
  
  def source_=[T <: ActivityEdge](value: ActivityNode)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSource(value)
  def source_=[T <: ActivityEdge](value: ⇒ Option[ActivityNode])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSource(UmlBuilder.ref(value))
  
  
  def submachineState(implicit ev: Nothing) = nothing
  def submachineState_=[T <: StateMachine](value: EList[State]) =
    (target: T) ⇒ target.getSubmachineStates.addAll(value)
  
  
  def lowerValue(implicit ev: Nothing) = nothing
  def lowerValue_=[T <: MultiplicityElement](value: ValueSpecification) =
    (target: T) ⇒ target.setLowerValue(value)
  
  
  def predecessorClause(implicit ev: Nothing) = nothing
  def predecessorClause_=[T <: Clause](value: EList[Clause]) =
    (target: T) ⇒ target.getPredecessorClauses.addAll(value)
  
  
  def incoming(implicit ev: Nothing) = nothing
  def incoming_=[T <: ActivityNode](value: EList[ActivityEdge]) =
    (target: T) ⇒ target.getIncomings.addAll(value)
  
  
  def qualifier(implicit ev: Nothing) = nothing
  def qualifier_=[T <: Property](value: EList[Property]) =
    (target: T) ⇒ target.getQualifiers.addAll(value)
  
  def qualifier_=[T <: LinkEndData](value: EList[QualifierValue])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getQualifiers.addAll(value)
  
  def qualifier_=[T <: QualifierValue](value: Property)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setQualifier(value)
  def qualifier_=[T <: QualifierValue](value: ⇒ Option[Property])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setQualifier(UmlBuilder.ref(value))
  
  def qualifier_=[T <: ReadLinkObjectEndQualifierAction](value: Property)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setQualifier(value)
  def qualifier_=[T <: ReadLinkObjectEndQualifierAction](value: ⇒ Option[Property])(implicit o: Overloaded3) =
    (target: T) ⇒ target.setQualifier(UmlBuilder.ref(value))
  
  
  def subExpression(implicit ev: Nothing) = nothing
  def subExpression_=[T <: StringExpression](value: EList[StringExpression]) =
    (target: T) ⇒ target.getSubExpressions.addAll(value)
  
  
  def connectionPoint(implicit ev: Nothing) = nothing
  def connectionPoint_=[T <: StateMachine](value: EList[Pseudostate]) =
    (target: T) ⇒ target.getConnectionPoints.addAll(value)
  
  def connectionPoint_=[T <: State](value: EList[Pseudostate])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getConnectionPoints.addAll(value)
  
  
  def powertype(implicit ev: Nothing) = nothing
  def powertype_=[T <: GeneralizationSet](value: Classifier) =
    (target: T) ⇒ target.setPowertype(value)
  def powertype_=[T <: GeneralizationSet](value: ⇒ Option[Classifier]) =
    (target: T) ⇒ target.setPowertype(UmlBuilder.ref(value))
  
  
  def deployment(implicit ev: Nothing) = nothing
  def deployment_=[T <: DeploymentTarget](value: EList[Deployment]) =
    (target: T) ⇒ target.getDeployments.addAll(value)
  
  
  def deployedArtifact(implicit ev: Nothing) = nothing
  def deployedArtifact_=[T <: Deployment](value: EList[DeployedArtifact]) =
    (target: T) ⇒ target.getDeployedArtifacts.addAll(value)
  
  
  def subpartition(implicit ev: Nothing) = nothing
  def subpartition_=[T <: ActivityPartition](value: EList[ActivityPartition]) =
    (target: T) ⇒ target.getSubpartitions.addAll(value)
  
  
  def request(implicit ev: Nothing) = nothing
  def request_=[T <: SendObjectAction](value: InputPin) =
    (target: T) ⇒ target.setRequest(value)
  
  
  def location(implicit ev: Nothing) = nothing
  def location_=[T <: Image](value: String) =
    (target: T) ⇒ target.setLocation(value)
  
  
  def subject(implicit ev: Nothing) = nothing
  def subject_=[T <: UseCase](value: EList[Classifier]) =
    (target: T) ⇒ target.getSubjects.addAll(value)
  
  
  def exceptionInput(implicit ev: Nothing) = nothing
  def exceptionInput_=[T <: ExceptionHandler](value: ObjectNode) =
    (target: T) ⇒ target.setExceptionInput(value)
  def exceptionInput_=[T <: ExceptionHandler](value: ⇒ Option[ObjectNode]) =
    (target: T) ⇒ target.setExceptionInput(UmlBuilder.ref(value))
  
  
  def URI(implicit ev: Nothing) = nothing
  def URI_=[T <: org.eclipse.uml2.uml.Package](value: String) =
    (target: T) ⇒ target.setURI(value)
  
  
  def collection(implicit ev: Nothing) = nothing
  def collection_=[T <: ReduceAction](value: InputPin) =
    (target: T) ⇒ target.setCollection(value)
  
  
  def subvertex(implicit ev: Nothing) = nothing
  def subvertex_=[T <: Region](value: EList[Vertex]) =
    (target: T) ⇒ target.getSubvertices.addAll(value)
  
  
  def isSubstitutable(implicit ev: Nothing) = nothing
  def isSubstitutable_=[T <: Generalization](value: Boolean) =
    (target: T) ⇒ target.setIsSubstitutable(value)
  
  
  def ownedTemplateSignature(implicit ev: Nothing) = nothing
  def ownedTemplateSignature_=[T <: TemplateableElement](value: TemplateSignature) =
    (target: T) ⇒ target.setOwnedTemplateSignature(value)
  
  
  def returnValue(implicit ev: Nothing) = nothing
  def returnValue_=[T <: InteractionUse](value: ValueSpecification) =
    (target: T) ⇒ target.setReturnValue(value)
  
  
  def decider(implicit ev: Nothing) = nothing
  def decider_=[T <: Clause](value: OutputPin) =
    (target: T) ⇒ target.setDecider(value)
  def decider_=[T <: Clause](value: ⇒ Option[OutputPin]) =
    (target: T) ⇒ target.setDecider(UmlBuilder.ref(value))
  
  def decider_=[T <: LoopNode](value: OutputPin)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setDecider(value)
  def decider_=[T <: LoopNode](value: ⇒ Option[OutputPin])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setDecider(UmlBuilder.ref(value))
  
  
  def realizingConnector(implicit ev: Nothing) = nothing
  def realizingConnector_=[T <: InformationFlow](value: EList[Connector]) =
    (target: T) ⇒ target.getRealizingConnectors.addAll(value)
  
  
  def interruptingEdge(implicit ev: Nothing) = nothing
  def interruptingEdge_=[T <: InterruptibleActivityRegion](value: EList[ActivityEdge]) =
    (target: T) ⇒ target.getInterruptingEdges.addAll(value)
  
  
  def definingFeature(implicit ev: Nothing) = nothing
  def definingFeature_=[T <: Slot](value: StructuralFeature) =
    (target: T) ⇒ target.setDefiningFeature(value)
  def definingFeature_=[T <: Slot](value: ⇒ Option[StructuralFeature]) =
    (target: T) ⇒ target.setDefiningFeature(UmlBuilder.ref(value))
  
  
  def isOrdered(implicit ev: Nothing) = nothing
  def isOrdered_=[T <: MultiplicityElement](value: Boolean) =
    (target: T) ⇒ target.setIsOrdered(value)
  
  def isOrdered_=[T <: ReduceAction](value: Boolean)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setIsOrdered(value)
  
  
  def isControlType(implicit ev: Nothing) = nothing
  def isControlType_=[T <: ObjectNode](value: Boolean) =
    (target: T) ⇒ target.setIsControlType(value)
  
  
  def generalMachine(implicit ev: Nothing) = nothing
  def generalMachine_=[T <: ProtocolConformance](value: ProtocolStateMachine) =
    (target: T) ⇒ target.setGeneralMachine(value)
  def generalMachine_=[T <: ProtocolConformance](value: ⇒ Option[ProtocolStateMachine]) =
    (target: T) ⇒ target.setGeneralMachine(UmlBuilder.ref(value))
  
  
  def inPartition(implicit ev: Nothing) = nothing
  def inPartition_=[T <: ActivityNode](value: EList[ActivityPartition]) =
    (target: T) ⇒ target.getInPartitions.addAll(value)
  
  def inPartition_=[T <: ActivityEdge](value: EList[ActivityPartition])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getInPartitions.addAll(value)
  
  
  def ownedComment(implicit ev: Nothing) = nothing
  def ownedComment_=[T <: Element](value: EList[Comment]) =
    (target: T) ⇒ target.getOwnedComments.addAll(value)
  
  
  def isUnique(implicit ev: Nothing) = nothing
  def isUnique_=[T <: MultiplicityElement](value: Boolean) =
    (target: T) ⇒ target.setIsUnique(value)
  
  
  def realizingClassifier(implicit ev: Nothing) = nothing
  def realizingClassifier_=[T <: ComponentRealization](value: EList[Classifier]) =
    (target: T) ⇒ target.getRealizingClassifiers.addAll(value)
  
  
  def role(implicit ev: Nothing) = nothing
  def role_=[T <: ConnectorEnd](value: ConnectableElement) =
    (target: T) ⇒ target.setRole(value)
  def role_=[T <: ConnectorEnd](value: ⇒ Option[ConnectableElement]) =
    (target: T) ⇒ target.setRole(UmlBuilder.ref(value))
  
  
  def roleBinding(implicit ev: Nothing) = nothing
  def roleBinding_=[T <: CollaborationUse](value: EList[Dependency]) =
    (target: T) ⇒ target.getRoleBindings.addAll(value)
  
  
  def conformance(implicit ev: Nothing) = nothing
  def conformance_=[T <: ProtocolStateMachine](value: EList[ProtocolConformance]) =
    (target: T) ⇒ target.getConformances.addAll(value)
  
  
  def minint(implicit ev: Nothing) = nothing
  def minint_=[T <: InteractionConstraint](value: ValueSpecification) =
    (target: T) ⇒ target.setMinint(value)
  
  
  def event(implicit ev: Nothing) = nothing
  def event_=[T <: Trigger](value: Event) =
    (target: T) ⇒ target.setEvent(value)
  def event_=[T <: Trigger](value: ⇒ Option[Event]) =
    (target: T) ⇒ target.setEvent(UmlBuilder.ref(value))
  
  def event_=[T <: TimeObservation](value: NamedElement)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setEvent(value)
  def event_=[T <: TimeObservation](value: ⇒ Option[NamedElement])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setEvent(UmlBuilder.ref(value))
  
  
  def isDirect(implicit ev: Nothing) = nothing
  def isDirect_=[T <: ReadIsClassifiedObjectAction](value: Boolean) =
    (target: T) ⇒ target.setIsDirect(value)
  
  
  def isReadOnly(implicit ev: Nothing) = nothing
  def isReadOnly_=[T <: StructuralFeature](value: Boolean) =
    (target: T) ⇒ target.setIsReadOnly(value)
  
  def isReadOnly_=[T <: Activity](value: Boolean)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setIsReadOnly(value)
  
  
  def setting(implicit ev: Nothing) = nothing
  def setting_=[T <: Continuation](value: Boolean) =
    (target: T) ⇒ target.setSetting(value)
  
  
  def ownedActual(implicit ev: Nothing) = nothing
  def ownedActual_=[T <: TemplateParameterSubstitution](value: ParameterableElement) =
    (target: T) ⇒ target.setOwnedActual(value)
  
  
  def isSingleExecution(implicit ev: Nothing) = nothing
  def isSingleExecution_=[T <: Activity](value: Boolean) =
    (target: T) ⇒ target.setIsSingleExecution(value)
  
  
  def setupPart(implicit ev: Nothing) = nothing
  def setupPart_=[T <: LoopNode](value: EList[ExecutableNode]) =
    (target: T) ⇒ target.getSetupParts.addAll(value)
  
  
  def isLeaf(implicit ev: Nothing) = nothing
  def isLeaf_=[T <: RedefinableElement](value: Boolean) =
    (target: T) ⇒ target.setIsLeaf(value)
  
  
  def generalization(implicit ev: Nothing) = nothing
  def generalization_=[T <: Classifier](value: EList[Generalization]) =
    (target: T) ⇒ target.getGeneralizations.addAll(value)
  
  def generalization_=[T <: GeneralizationSet](value: EList[Generalization])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getGeneralizations.addAll(value)
  
  
  def newClassifier(implicit ev: Nothing) = nothing
  def newClassifier_=[T <: ReclassifyObjectAction](value: EList[Classifier]) =
    (target: T) ⇒ target.getNewClassifiers.addAll(value)
  
  
  def toAfter(implicit ev: Nothing) = nothing
  def toAfter_=[T <: OccurrenceSpecification](value: EList[GeneralOrdering]) =
    (target: T) ⇒ target.getToAfters.addAll(value)
  
  
  def isStrict(implicit ev: Nothing) = nothing
  def isStrict_=[T <: ProfileApplication](value: Boolean) =
    (target: T) ⇒ target.setIsStrict(value)
  
  
  def ownedUseCase(implicit ev: Nothing) = nothing
  def ownedUseCase_=[T <: Classifier](value: EList[UseCase]) =
    (target: T) ⇒ target.getOwnedUseCases.addAll(value)
  
  
  def lifeline(implicit ev: Nothing) = nothing
  def lifeline_=[T <: Interaction](value: EList[Lifeline]) =
    (target: T) ⇒ target.getLifelines.addAll(value)
  
  
  def isUnmarshall(implicit ev: Nothing) = nothing
  def isUnmarshall_=[T <: AcceptEventAction](value: Boolean) =
    (target: T) ⇒ target.setIsUnmarshall(value)
  
  
  def isCovering(implicit ev: Nothing) = nothing
  def isCovering_=[T <: GeneralizationSet](value: Boolean) =
    (target: T) ⇒ target.setIsCovering(value)
  
  
  def isTestedFirst(implicit ev: Nothing) = nothing
  def isTestedFirst_=[T <: LoopNode](value: Boolean) =
    (target: T) ⇒ target.setIsTestedFirst(value)
  
  
  def extensionPoint(implicit ev: Nothing) = nothing
  def extensionPoint_=[T <: UseCase](value: EList[ExtensionPoint]) =
    (target: T) ⇒ target.getExtensionPoints.addAll(value)
  
  
  def isException(implicit ev: Nothing) = nothing
  def isException_=[T <: Parameter](value: Boolean) =
    (target: T) ⇒ target.setIsException(value)
  
  
  def isService(implicit ev: Nothing) = nothing
  def isService_=[T <: Port](value: Boolean) =
    (target: T) ⇒ target.setIsService(value)
  
  
  def replyValue(implicit ev: Nothing) = nothing
  def replyValue_=[T <: ReplyAction](value: EList[InputPin]) =
    (target: T) ⇒ target.getReplyValues.addAll(value)
  
  
  def icon(implicit ev: Nothing) = nothing
  def icon_=[T <: Stereotype](value: EList[Image]) =
    (target: T) ⇒ target.getIcons.addAll(value)
  
  
  def entry(implicit ev: Nothing) = nothing
  def entry_=[T <: State](value: Behavior) =
    (target: T) ⇒ target.setEntry(value)
  
  def entry_=[T <: ConnectionPointReference](value: EList[Pseudostate])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getEntries.addAll(value)
  
  
  def redefinedConnector(implicit ev: Nothing) = nothing
  def redefinedConnector_=[T <: Connector](value: EList[Connector]) =
    (target: T) ⇒ target.getRedefinedConnectors.addAll(value)
  
  
  def ownedOperation(implicit ev: Nothing) = nothing
  def ownedOperation_=[T <: org.eclipse.uml2.uml.Class](value: EList[Operation]) =
    (target: T) ⇒ target.getOwnedOperations.addAll(value)
  
  def ownedOperation_=[T <: Artifact](value: EList[Operation])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getOwnedOperations.addAll(value)
  
  def ownedOperation_=[T <: Interface](value: EList[Operation])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getOwnedOperations.addAll(value)
  
  def ownedOperation_=[T <: DataType](value: EList[Operation])(implicit o: Overloaded3) =
    (target: T) ⇒ target.getOwnedOperations.addAll(value)
  
  
  def removeAt(implicit ev: Nothing) = nothing
  def removeAt_=[T <: RemoveStructuralFeatureValueAction](value: InputPin) =
    (target: T) ⇒ target.setRemoveAt(value)
  
  def removeAt_=[T <: RemoveVariableValueAction](value: InputPin)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setRemoveAt(value)
  
  
  def effect(implicit ev: Nothing) = nothing
  def effect_=[T <: Transition](value: Behavior) =
    (target: T) ⇒ target.setEffect(value)
  
  def effect_=[T <: Parameter](value: ParameterEffectKind)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setEffect(value)
  
  
  def result(implicit ev: Nothing) = nothing
  def result_=[T <: AcceptEventAction](value: EList[OutputPin]) =
    (target: T) ⇒ target.getResults.addAll(value)
  
  def result_=[T <: WriteStructuralFeatureAction](value: OutputPin)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: CallAction](value: EList[OutputPin])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getResults.addAll(value)
  
  def result_=[T <: ClearStructuralFeatureAction](value: OutputPin)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ConditionalNode](value: EList[OutputPin])(implicit o: Overloaded4) =
    (target: T) ⇒ target.getResults.addAll(value)
  
  def result_=[T <: CreateLinkObjectAction](value: OutputPin)(implicit o: Overloaded5) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: CreateObjectAction](value: OutputPin)(implicit o: Overloaded6) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: LoopNode](value: EList[OutputPin])(implicit o: Overloaded7) =
    (target: T) ⇒ target.getResults.addAll(value)
  
  def result_=[T <: ReadExtentAction](value: OutputPin)(implicit o: Overloaded8) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReadIsClassifiedObjectAction](value: OutputPin)(implicit o: Overloaded9) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReadLinkAction](value: OutputPin)(implicit o: Overloaded10) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReadLinkObjectEndAction](value: OutputPin)(implicit o: Overloaded11) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReadLinkObjectEndQualifierAction](value: OutputPin)(implicit o: Overloaded12) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReadSelfAction](value: OutputPin)(implicit o: Overloaded13) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReadStructuralFeatureAction](value: OutputPin)(implicit o: Overloaded14) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReadVariableAction](value: OutputPin)(implicit o: Overloaded15) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: ReduceAction](value: OutputPin)(implicit o: Overloaded16) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: TestIdentityAction](value: OutputPin)(implicit o: Overloaded17) =
    (target: T) ⇒ target.setResult(value)
  
  def result_=[T <: UnmarshallAction](value: EList[OutputPin])(implicit o: Overloaded18) =
    (target: T) ⇒ target.getResults.addAll(value)
  
  def result_=[T <: ValueSpecificationAction](value: OutputPin)(implicit o: Overloaded19) =
    (target: T) ⇒ target.setResult(value)
  
  
  def nestedNode(implicit ev: Nothing) = nothing
  def nestedNode_=[T <: Node](value: EList[Node]) =
    (target: T) ⇒ target.getNestedNodes.addAll(value)
  
  
  def redefinedInterface(implicit ev: Nothing) = nothing
  def redefinedInterface_=[T <: Interface](value: EList[Interface]) =
    (target: T) ⇒ target.getRedefinedInterfaces.addAll(value)
  
  
  def ownedBehavior(implicit ev: Nothing) = nothing
  def ownedBehavior_=[T <: BehavioredClassifier](value: EList[Behavior]) =
    (target: T) ⇒ target.getOwnedBehaviors.addAll(value)
  
  
  def before(implicit ev: Nothing) = nothing
  def before_=[T <: GeneralOrdering](value: OccurrenceSpecification) =
    (target: T) ⇒ target.setBefore(value)
  def before_=[T <: GeneralOrdering](value: ⇒ Option[OccurrenceSpecification]) =
    (target: T) ⇒ target.setBefore(UmlBuilder.ref(value))
  
  
  def represented(implicit ev: Nothing) = nothing
  def represented_=[T <: InformationItem](value: EList[Classifier]) =
    (target: T) ⇒ target.getRepresenteds.addAll(value)
  
  
  def isID(implicit ev: Nothing) = nothing
  def isID_=[T <: Property](value: Boolean) =
    (target: T) ⇒ target.setIsID(value)
  
  
  def fragment(implicit ev: Nothing) = nothing
  def fragment_=[T <: Interaction](value: EList[InteractionFragment]) =
    (target: T) ⇒ target.getFragments.addAll(value)
  
  def fragment_=[T <: InteractionOperand](value: EList[InteractionFragment])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getFragments.addAll(value)
  
  
  def partition(implicit ev: Nothing) = nothing
  def partition_=[T <: Activity](value: EList[ActivityPartition]) =
    (target: T) ⇒ target.getPartitions.addAll(value)
  
  
  def exception(implicit ev: Nothing) = nothing
  def exception_=[T <: RaiseExceptionAction](value: InputPin) =
    (target: T) ⇒ target.setException(value)
  
  
  def conveyed(implicit ev: Nothing) = nothing
  def conveyed_=[T <: InformationFlow](value: EList[Classifier]) =
    (target: T) ⇒ target.getConveyeds.addAll(value)
  
  
  def ownedAttribute(implicit ev: Nothing) = nothing
  def ownedAttribute_=[T <: StructuredClassifier](value: EList[Property]) =
    (target: T) ⇒ target.getOwnedAttributes.addAll(value)
  
  def ownedAttribute_=[T <: Artifact](value: EList[Property])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getOwnedAttributes.addAll(value)
  
  def ownedAttribute_=[T <: Interface](value: EList[Property])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getOwnedAttributes.addAll(value)
  
  def ownedAttribute_=[T <: Signal](value: EList[Property])(implicit o: Overloaded3) =
    (target: T) ⇒ target.getOwnedAttributes.addAll(value)
  
  def ownedAttribute_=[T <: DataType](value: EList[Property])(implicit o: Overloaded4) =
    (target: T) ⇒ target.getOwnedAttributes.addAll(value)
  
  
  def isRemoveDuplicates(implicit ev: Nothing) = nothing
  def isRemoveDuplicates_=[T <: RemoveStructuralFeatureValueAction](value: Boolean) =
    (target: T) ⇒ target.setIsRemoveDuplicates(value)
  
  def isRemoveDuplicates_=[T <: RemoveVariableValueAction](value: Boolean)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setIsRemoveDuplicates(value)
  
  
  def realization(implicit ev: Nothing) = nothing
  def realization_=[T <: Component](value: EList[ComponentRealization]) =
    (target: T) ⇒ target.getRealizations.addAll(value)
  
  def realization_=[T <: InformationFlow](value: EList[Relationship])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getRealizations.addAll(value)
  
  
  def preCondition(implicit ev: Nothing) = nothing
  def preCondition_=[T <: ProtocolTransition](value: Constraint) =
    (target: T) ⇒ target.setPreCondition(value)
  def preCondition_=[T <: ProtocolTransition](value: ⇒ Option[Constraint]) =
    (target: T) ⇒ target.setPreCondition(UmlBuilder.ref(value))
  
  
  def outgoing(implicit ev: Nothing) = nothing
  def outgoing_=[T <: ActivityNode](value: EList[ActivityEdge]) =
    (target: T) ⇒ target.getOutgoings.addAll(value)
  
  
  def redefinedEdge(implicit ev: Nothing) = nothing
  def redefinedEdge_=[T <: ActivityEdge](value: EList[ActivityEdge]) =
    (target: T) ⇒ target.getRedefinedEdges.addAll(value)
  
  
  def extendedCase(implicit ev: Nothing) = nothing
  def extendedCase_=[T <: Extend](value: UseCase) =
    (target: T) ⇒ target.setExtendedCase(value)
  def extendedCase_=[T <: Extend](value: ⇒ Option[UseCase]) =
    (target: T) ⇒ target.setExtendedCase(UmlBuilder.ref(value))
  
  
  def min(implicit ev: Nothing) = nothing
  def min_=[T <: Interval](value: ValueSpecification) =
    (target: T) ⇒ target.setMin(value)
  def min_=[T <: Interval](value: ⇒ Option[ValueSpecification]) =
    (target: T) ⇒ target.setMin(UmlBuilder.ref(value))
  
  
  def extendedStateMachine(implicit ev: Nothing) = nothing
  def extendedStateMachine_=[T <: StateMachine](value: EList[StateMachine]) =
    (target: T) ⇒ target.getExtendedStateMachines.addAll(value)
  
  
  def interactionOperator(implicit ev: Nothing) = nothing
  def interactionOperator_=[T <: CombinedFragment](value: InteractionOperatorKind) =
    (target: T) ⇒ target.setInteractionOperator(value)
  
  
  def messageSort(implicit ev: Nothing) = nothing
  def messageSort_=[T <: Message](value: MessageSort) =
    (target: T) ⇒ target.setMessageSort(value)
  
  
  def mapping(implicit ev: Nothing) = nothing
  def mapping_=[T <: Abstraction](value: OpaqueExpression) =
    (target: T) ⇒ target.setMapping(value)
  
  
  def oldClassifier(implicit ev: Nothing) = nothing
  def oldClassifier_=[T <: ReclassifyObjectAction](value: EList[Classifier]) =
    (target: T) ⇒ target.getOldClassifiers.addAll(value)
  
  
  def signature(implicit ev: Nothing) = nothing
  def signature_=[T <: TemplateBinding](value: TemplateSignature) =
    (target: T) ⇒ target.setSignature(value)
  def signature_=[T <: TemplateBinding](value: ⇒ Option[TemplateSignature]) =
    (target: T) ⇒ target.setSignature(UmlBuilder.ref(value))
  
  def signature_=[T <: Message](value: NamedElement)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSignature(value)
  def signature_=[T <: Message](value: ⇒ Option[NamedElement])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSignature(UmlBuilder.ref(value))
  
  
  def direction(implicit ev: Nothing) = nothing
  def direction_=[T <: Parameter](value: ParameterDirectionKind) =
    (target: T) ⇒ target.setDirection(value)
  
  
  def represents(implicit ev: Nothing) = nothing
  def represents_=[T <: ActivityPartition](value: Element) =
    (target: T) ⇒ target.setRepresents(value)
  def represents_=[T <: ActivityPartition](value: ⇒ Option[Element]) =
    (target: T) ⇒ target.setRepresents(UmlBuilder.ref(value))
  
  def represents_=[T <: Lifeline](value: ConnectableElement)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setRepresents(value)
  def represents_=[T <: Lifeline](value: ⇒ Option[ConnectableElement])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setRepresents(UmlBuilder.ref(value))
  
  
  def generalizationSet(implicit ev: Nothing) = nothing
  def generalizationSet_=[T <: Generalization](value: EList[GeneralizationSet]) =
    (target: T) ⇒ target.getGeneralizationSets.addAll(value)
  
  
  def memberEnd(implicit ev: Nothing) = nothing
  def memberEnd_=[T <: Association](value: EList[Property]) =
    (target: T) ⇒ target.getMemberEnds.addAll(value)
  
  
  def instance(implicit ev: Nothing) = nothing
  def instance_=[T <: InstanceValue](value: InstanceSpecification) =
    (target: T) ⇒ target.setInstance(value)
  def instance_=[T <: InstanceValue](value: ⇒ Option[InstanceSpecification]) =
    (target: T) ⇒ target.setInstance(UmlBuilder.ref(value))
  
  
  def toBefore(implicit ev: Nothing) = nothing
  def toBefore_=[T <: OccurrenceSpecification](value: EList[GeneralOrdering]) =
    (target: T) ⇒ target.getToBefores.addAll(value)
  
  
  def expr(implicit ev: Nothing) = nothing
  def expr_=[T <: Duration](value: ValueSpecification) =
    (target: T) ⇒ target.setExpr(value)
  
  def expr_=[T <: TimeExpression](value: ValueSpecification)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setExpr(value)
  
  
  def parameterSubstitution(implicit ev: Nothing) = nothing
  def parameterSubstitution_=[T <: TemplateBinding](value: EList[TemplateParameterSubstitution]) =
    (target: T) ⇒ target.getParameterSubstitutions.addAll(value)
  
  
  def isRelative(implicit ev: Nothing) = nothing
  def isRelative_=[T <: TimeEvent](value: Boolean) =
    (target: T) ⇒ target.setIsRelative(value)
  
  
  def stateInvariant(implicit ev: Nothing) = nothing
  def stateInvariant_=[T <: State](value: Constraint) =
    (target: T) ⇒ target.setStateInvariant(value)
  def stateInvariant_=[T <: State](value: ⇒ Option[Constraint]) =
    (target: T) ⇒ target.setStateInvariant(UmlBuilder.ref(value))
  
  
  def powertypeExtent(implicit ev: Nothing) = nothing
  def powertypeExtent_=[T <: Classifier](value: EList[GeneralizationSet]) =
    (target: T) ⇒ target.getPowertypeExtents.addAll(value)
  
  
  def isSynchronous(implicit ev: Nothing) = nothing
  def isSynchronous_=[T <: CallAction](value: Boolean) =
    (target: T) ⇒ target.setIsSynchronous(value)
  
  
  def realizingMessage(implicit ev: Nothing) = nothing
  def realizingMessage_=[T <: InformationFlow](value: EList[Message]) =
    (target: T) ⇒ target.getRealizingMessages.addAll(value)
  
  
  def fileName(implicit ev: Nothing) = nothing
  def fileName_=[T <: Artifact](value: String) =
    (target: T) ⇒ target.setFileName(value)
  
  
  def informationTarget(implicit ev: Nothing) = nothing
  def informationTarget_=[T <: InformationFlow](value: EList[NamedElement]) =
    (target: T) ⇒ target.getInformationTargets.addAll(value)
  
  
  def isCombineDuplicate(implicit ev: Nothing) = nothing
  def isCombineDuplicate_=[T <: JoinNode](value: Boolean) =
    (target: T) ⇒ target.setIsCombineDuplicate(value)
  
  
  def structuredNodeOutput(implicit ev: Nothing) = nothing
  def structuredNodeOutput_=[T <: StructuredActivityNode](value: EList[OutputPin]) =
    (target: T) ⇒ target.getStructuredNodeOutputs.addAll(value)
  
  
  def redefinedPort(implicit ev: Nothing) = nothing
  def redefinedPort_=[T <: Port](value: EList[Port]) =
    (target: T) ⇒ target.getRedefinedPorts.addAll(value)
  
  
  def supplier(implicit ev: Nothing) = nothing
  def supplier_=[T <: Dependency](value: EList[NamedElement]) =
    (target: T) ⇒ target.getSuppliers.addAll(value)
  
  
  def formalGate(implicit ev: Nothing) = nothing
  def formalGate_=[T <: Interaction](value: EList[Gate]) =
    (target: T) ⇒ target.getFormalGates.addAll(value)
  
  
  def structuredNodeInput(implicit ev: Nothing) = nothing
  def structuredNodeInput_=[T <: StructuredActivityNode](value: EList[InputPin]) =
    (target: T) ⇒ target.getStructuredNodeInputs.addAll(value)
  
  
  def regionAsInput(implicit ev: Nothing) = nothing
  def regionAsInput_=[T <: ExpansionNode](value: ExpansionRegion) =
    (target: T) ⇒ target.setRegionAsInput(value)
  def regionAsInput_=[T <: ExpansionNode](value: ⇒ Option[ExpansionRegion]) =
    (target: T) ⇒ target.setRegionAsInput(UmlBuilder.ref(value))
  
  
  def collaborationUse(implicit ev: Nothing) = nothing
  def collaborationUse_=[T <: Classifier](value: EList[CollaborationUse]) =
    (target: T) ⇒ target.getCollaborationUses.addAll(value)
  
  
  def finish(implicit ev: Nothing) = nothing
  def finish_=[T <: ExecutionSpecification](value: OccurrenceSpecification) =
    (target: T) ⇒ target.setFinish(value)
  def finish_=[T <: ExecutionSpecification](value: ⇒ Option[OccurrenceSpecification]) =
    (target: T) ⇒ target.setFinish(UmlBuilder.ref(value))
  
  
  def bodyCondition(implicit ev: Nothing) = nothing
  def bodyCondition_=[T <: Operation](value: Constraint) =
    (target: T) ⇒ target.setBodyCondition(value)
  def bodyCondition_=[T <: Operation](value: ⇒ Option[Constraint]) =
    (target: T) ⇒ target.setBodyCondition(UmlBuilder.ref(value))
  
  
  def extend(implicit ev: Nothing) = nothing
  def extend_=[T <: UseCase](value: EList[Extend]) =
    (target: T) ⇒ target.getExtends.addAll(value)
  
  
  def redefinedOperation(implicit ev: Nothing) = nothing
  def redefinedOperation_=[T <: Operation](value: EList[Operation]) =
    (target: T) ⇒ target.getRedefinedOperations.addAll(value)
  
  
  def destroyAt(implicit ev: Nothing) = nothing
  def destroyAt_=[T <: LinkEndDestructionData](value: InputPin) =
    (target: T) ⇒ target.setDestroyAt(value)
  def destroyAt_=[T <: LinkEndDestructionData](value: ⇒ Option[InputPin]) =
    (target: T) ⇒ target.setDestroyAt(UmlBuilder.ref(value))
  
  
  def ownedParameter(implicit ev: Nothing) = nothing
  def ownedParameter_=[T <: TemplateSignature](value: EList[TemplateParameter]) =
    (target: T) ⇒ target.getOwnedParameters.addAll(value)
  
  def ownedParameter_=[T <: BehavioralFeature](value: EList[Parameter])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getOwnedParameters.addAll(value)
  
  def ownedParameter_=[T <: Behavior](value: EList[Parameter])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getOwnedParameters.addAll(value)
  
  
  def clientDependency(implicit ev: Nothing) = nothing
  def clientDependency_=[T <: NamedElement](value: EList[Dependency]) =
    (target: T) ⇒ target.getClientDependencies.addAll(value)
  
  
  def isDerivedUnion(implicit ev: Nothing) = nothing
  def isDerivedUnion_=[T <: Property](value: Boolean) =
    (target: T) ⇒ target.setIsDerivedUnion(value)
  
  
  def ownedNode(implicit ev: Nothing) = nothing
  def ownedNode_=[T <: Activity](value: EList[ActivityNode]) =
    (target: T) ⇒ target.getOwnedNodes.addAll(value)
  
  
  def transformation(implicit ev: Nothing) = nothing
  def transformation_=[T <: ObjectFlow](value: Behavior) =
    (target: T) ⇒ target.setTransformation(value)
  def transformation_=[T <: ObjectFlow](value: ⇒ Option[Behavior]) =
    (target: T) ⇒ target.setTransformation(UmlBuilder.ref(value))
  
  
  def extendedRegion(implicit ev: Nothing) = nothing
  def extendedRegion_=[T <: Region](value: Region) =
    (target: T) ⇒ target.setExtendedRegion(value)
  def extendedRegion_=[T <: Region](value: ⇒ Option[Region]) =
    (target: T) ⇒ target.setExtendedRegion(UmlBuilder.ref(value))
  
  
  def redefinedBehavior(implicit ev: Nothing) = nothing
  def redefinedBehavior_=[T <: Behavior](value: EList[Behavior]) =
    (target: T) ⇒ target.getRedefinedBehaviors.addAll(value)
  
  
  def constrainingClassifier(implicit ev: Nothing) = nothing
  def constrainingClassifier_=[T <: ClassifierTemplateParameter](value: EList[Classifier]) =
    (target: T) ⇒ target.getConstrainingClassifiers.addAll(value)
  
  
  def loopVariable(implicit ev: Nothing) = nothing
  def loopVariable_=[T <: LoopNode](value: EList[OutputPin]) =
    (target: T) ⇒ target.getLoopVariables.addAll(value)
  
  
  def useCase(implicit ev: Nothing) = nothing
  def useCase_=[T <: Classifier](value: EList[UseCase]) =
    (target: T) ⇒ target.getUseCases.addAll(value)
  
  
  def endData(implicit ev: Nothing) = nothing
  def endData_=[T <: LinkAction](value: EList[LinkEndData]) =
    (target: T) ⇒ target.getEndData.addAll(value)
  
  
  def `object`(implicit ev: Nothing) = nothing
  def object_=[T <: StructuralFeatureAction](value: InputPin) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: ClearAssociationAction](value: InputPin)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: ReadIsClassifiedObjectAction](value: InputPin)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: ReadLinkObjectEndAction](value: InputPin)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: ReadLinkObjectEndQualifierAction](value: InputPin)(implicit o: Overloaded4) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: ReclassifyObjectAction](value: InputPin)(implicit o: Overloaded5) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: StartClassifierBehaviorAction](value: InputPin)(implicit o: Overloaded6) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: StartObjectBehaviorAction](value: InputPin)(implicit o: Overloaded7) =
    (target: T) ⇒ target.setObject(value)
  
  def object_=[T <: UnmarshallAction](value: InputPin)(implicit o: Overloaded8) =
    (target: T) ⇒ target.setObject(value)
  
  
  def extensionLocation(implicit ev: Nothing) = nothing
  def extensionLocation_=[T <: Extend](value: EList[ExtensionPoint]) =
    (target: T) ⇒ target.getExtensionLocations.addAll(value)
  
  
  def isDimension(implicit ev: Nothing) = nothing
  def isDimension_=[T <: ActivityPartition](value: Boolean) =
    (target: T) ⇒ target.setIsDimension(value)
  
  
  def loopVariableInput(implicit ev: Nothing) = nothing
  def loopVariableInput_=[T <: LoopNode](value: EList[InputPin]) =
    (target: T) ⇒ target.getLoopVariableInputs.addAll(value)
  
  
  def ownedLiteral(implicit ev: Nothing) = nothing
  def ownedLiteral_=[T <: Enumeration](value: EList[EnumerationLiteral]) =
    (target: T) ⇒ target.getOwnedLiterals.addAll(value)
  
  
  def isExternal(implicit ev: Nothing) = nothing
  def isExternal_=[T <: ActivityPartition](value: Boolean) =
    (target: T) ⇒ target.setIsExternal(value)
  
  
  def deploymentLocation(implicit ev: Nothing) = nothing
  def deploymentLocation_=[T <: DeploymentSpecification](value: String) =
    (target: T) ⇒ target.setDeploymentLocation(value)
  
  
  def onPort(implicit ev: Nothing) = nothing
  def onPort_=[T <: InvocationAction](value: Port) =
    (target: T) ⇒ target.setOnPort(value)
  def onPort_=[T <: InvocationAction](value: ⇒ Option[Port]) =
    (target: T) ⇒ target.setOnPort(UmlBuilder.ref(value))
  
  
  def upperBound(implicit ev: Nothing) = nothing
  def upperBound_=[T <: ObjectNode](value: ValueSpecification) =
    (target: T) ⇒ target.setUpperBound(value)
  
  
  def specification(implicit ev: Nothing) = nothing
  def specification_=[T <: Behavior](value: BehavioralFeature) =
    (target: T) ⇒ target.setSpecification(value)
  def specification_=[T <: Behavior](value: ⇒ Option[BehavioralFeature]) =
    (target: T) ⇒ target.setSpecification(UmlBuilder.ref(value))
  
  def specification_=[T <: Constraint](value: ValueSpecification)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSpecification(value)
  
  def specification_=[T <: InstanceSpecification](value: ValueSpecification)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setSpecification(value)
  
  
  def coveredBy(implicit ev: Nothing) = nothing
  def coveredBy_=[T <: Lifeline](value: EList[InteractionFragment]) =
    (target: T) ⇒ target.getCoveredBys.addAll(value)
  
  
  def constrainedElement(implicit ev: Nothing) = nothing
  def constrainedElement_=[T <: Constraint](value: EList[Element]) =
    (target: T) ⇒ target.getConstrainedElements.addAll(value)
  
  
  def alias(implicit ev: Nothing) = nothing
  def alias_=[T <: ElementImport](value: String) =
    (target: T) ⇒ target.setAlias(value)
  
  
  def extendedSignature(implicit ev: Nothing) = nothing
  def extendedSignature_=[T <: RedefinableTemplateSignature](value: EList[RedefinableTemplateSignature]) =
    (target: T) ⇒ target.getExtendedSignatures.addAll(value)
  
  
  def isFinalSpecialization(implicit ev: Nothing) = nothing
  def isFinalSpecialization_=[T <: Classifier](value: Boolean) =
    (target: T) ⇒ target.setIsFinalSpecialization(value)
  
  
  def firstEvent(implicit ev: Nothing) = nothing
  def firstEvent_=[T <: TimeConstraint](value: Boolean) =
    (target: T) ⇒ target.setFirstEvent(value)
  
  def firstEvent_=[T <: TimeObservation](value: Boolean)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setFirstEvent(value)
  
  
  def redefinedTransition(implicit ev: Nothing) = nothing
  def redefinedTransition_=[T <: Transition](value: Transition) =
    (target: T) ⇒ target.setRedefinedTransition(value)
  def redefinedTransition_=[T <: Transition](value: ⇒ Option[Transition]) =
    (target: T) ⇒ target.setRedefinedTransition(UmlBuilder.ref(value))
  
  
  def mustIsolate(implicit ev: Nothing) = nothing
  def mustIsolate_=[T <: StructuredActivityNode](value: Boolean) =
    (target: T) ⇒ target.setMustIsolate(value)
  
  
  def symbol(implicit ev: Nothing) = nothing
  def symbol_=[T <: Expression](value: String) =
    (target: T) ⇒ target.setSymbol(value)
  
  
  def classifierBehavior(implicit ev: Nothing) = nothing
  def classifierBehavior_=[T <: BehavioredClassifier](value: Behavior) =
    (target: T) ⇒ target.setClassifierBehavior(value)
  def classifierBehavior_=[T <: BehavioredClassifier](value: ⇒ Option[Behavior]) =
    (target: T) ⇒ target.setClassifierBehavior(UmlBuilder.ref(value))
  
  
  def structuredNode(implicit ev: Nothing) = nothing
  def structuredNode_=[T <: Activity](value: EList[StructuredActivityNode]) =
    (target: T) ⇒ target.getStructuredNodes.addAll(value)
  
  
  def isDeterminate(implicit ev: Nothing) = nothing
  def isDeterminate_=[T <: ConditionalNode](value: Boolean) =
    (target: T) ⇒ target.setIsDeterminate(value)
  
  
  def addition(implicit ev: Nothing) = nothing
  def addition_=[T <: Include](value: UseCase) =
    (target: T) ⇒ target.setAddition(value)
  def addition_=[T <: Include](value: ⇒ Option[UseCase]) =
    (target: T) ⇒ target.setAddition(UmlBuilder.ref(value))
  
  
  def second(implicit ev: Nothing) = nothing
  def second_=[T <: TestIdentityAction](value: InputPin) =
    (target: T) ⇒ target.setSecond(value)
  
  
  def operation(implicit ev: Nothing) = nothing
  def operation_=[T <: CallEvent](value: Operation) =
    (target: T) ⇒ target.setOperation(value)
  def operation_=[T <: CallEvent](value: ⇒ Option[Operation]) =
    (target: T) ⇒ target.setOperation(UmlBuilder.ref(value))
  
  def operation_=[T <: CallOperationAction](value: Operation)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setOperation(value)
  def operation_=[T <: CallOperationAction](value: ⇒ Option[Operation])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setOperation(UmlBuilder.ref(value))
  
  
  def realizingActivityEdge(implicit ev: Nothing) = nothing
  def realizingActivityEdge_=[T <: InformationFlow](value: EList[ActivityEdge]) =
    (target: T) ⇒ target.getRealizingActivityEdges.addAll(value)
  
  
  def decisionInputFlow(implicit ev: Nothing) = nothing
  def decisionInputFlow_=[T <: DecisionNode](value: ObjectFlow) =
    (target: T) ⇒ target.setDecisionInputFlow(value)
  def decisionInputFlow_=[T <: DecisionNode](value: ⇒ Option[ObjectFlow]) =
    (target: T) ⇒ target.setDecisionInputFlow(UmlBuilder.ref(value))
  
  
  def isReplaceAll(implicit ev: Nothing) = nothing
  def isReplaceAll_=[T <: AddStructuralFeatureValueAction](value: Boolean) =
    (target: T) ⇒ target.setIsReplaceAll(value)
  
  def isReplaceAll_=[T <: AddVariableValueAction](value: Boolean)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setIsReplaceAll(value)
  
  def isReplaceAll_=[T <: LinkEndCreationData](value: Boolean)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setIsReplaceAll(value)
  
  def isReplaceAll_=[T <: ReclassifyObjectAction](value: Boolean)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setIsReplaceAll(value)
  
  
  def condition(implicit ev: Nothing) = nothing
  def condition_=[T <: ParameterSet](value: EList[Constraint]) =
    (target: T) ⇒ target.getConditions.addAll(value)
  
  def condition_=[T <: Extend](value: Constraint)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setCondition(value)
  
  
  def regionAsOutput(implicit ev: Nothing) = nothing
  def regionAsOutput_=[T <: ExpansionNode](value: ExpansionRegion) =
    (target: T) ⇒ target.setRegionAsOutput(value)
  def regionAsOutput_=[T <: ExpansionNode](value: ⇒ Option[ExpansionRegion]) =
    (target: T) ⇒ target.setRegionAsOutput(UmlBuilder.ref(value))
  
  
  def port(implicit ev: Nothing) = nothing
  def port_=[T <: Trigger](value: EList[Port]) =
    (target: T) ⇒ target.getPorts.addAll(value)
  
  
  def max(implicit ev: Nothing) = nothing
  def max_=[T <: Interval](value: ValueSpecification) =
    (target: T) ⇒ target.setMax(value)
  def max_=[T <: Interval](value: ⇒ Option[ValueSpecification]) =
    (target: T) ⇒ target.setMax(UmlBuilder.ref(value))
  
  
  def general(implicit ev: Nothing) = nothing
  def general_=[T <: Generalization](value: Classifier) =
    (target: T) ⇒ target.setGeneral(value)
  def general_=[T <: Generalization](value: ⇒ Option[Classifier]) =
    (target: T) ⇒ target.setGeneral(UmlBuilder.ref(value))
  
  
  def informationSource(implicit ev: Nothing) = nothing
  def informationSource_=[T <: InformationFlow](value: EList[NamedElement]) =
    (target: T) ⇒ target.getInformationSources.addAll(value)
  
  
  def joinSpec(implicit ev: Nothing) = nothing
  def joinSpec_=[T <: JoinNode](value: ValueSpecification) =
    (target: T) ⇒ target.setJoinSpec(value)
  
  
  def language(implicit ev: Nothing) = nothing
  def language_=[T <: OpaqueExpression](value: EList[String]) =
    (target: T) ⇒ target.getLanguages.addAll(value)
  
  def language_=[T <: OpaqueBehavior](value: EList[String])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getLanguages.addAll(value)
  
  def language_=[T <: OpaqueAction](value: EList[String])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getLanguages.addAll(value)
  
  
  def ownedEnd(implicit ev: Nothing) = nothing
  def ownedEnd_=[T <: Association](value: EList[Property]) =
    (target: T) ⇒ target.getOwnedEnds.addAll(value)
  
  
  def after(implicit ev: Nothing) = nothing
  def after_=[T <: GeneralOrdering](value: OccurrenceSpecification) =
    (target: T) ⇒ target.setAfter(value)
  def after_=[T <: GeneralOrdering](value: ⇒ Option[OccurrenceSpecification]) =
    (target: T) ⇒ target.setAfter(UmlBuilder.ref(value))
  
  
  def concurrency(implicit ev: Nothing) = nothing
  def concurrency_=[T <: BehavioralFeature](value: CallConcurrencyKind) =
    (target: T) ⇒ target.setConcurrency(value)
  
  
  def interfaceRealization(implicit ev: Nothing) = nothing
  def interfaceRealization_=[T <: BehavioredClassifier](value: EList[InterfaceRealization]) =
    (target: T) ⇒ target.getInterfaceRealizations.addAll(value)
  
  
  def ownedParameteredElement(implicit ev: Nothing) = nothing
  def ownedParameteredElement_=[T <: TemplateParameter](value: ParameterableElement) =
    (target: T) ⇒ target.setOwnedParameteredElement(value)
  
  
  def handlerBody(implicit ev: Nothing) = nothing
  def handlerBody_=[T <: ExceptionHandler](value: ExecutableNode) =
    (target: T) ⇒ target.setHandlerBody(value)
  def handlerBody_=[T <: ExceptionHandler](value: ⇒ Option[ExecutableNode]) =
    (target: T) ⇒ target.setHandlerBody(UmlBuilder.ref(value))
  
  
  def manifestation(implicit ev: Nothing) = nothing
  def manifestation_=[T <: Artifact](value: EList[Manifestation]) =
    (target: T) ⇒ target.getManifestations.addAll(value)
  
  
  def isControl(implicit ev: Nothing) = nothing
  def isControl_=[T <: Pin](value: Boolean) =
    (target: T) ⇒ target.setIsControl(value)
  
  
  def bodyPart(implicit ev: Nothing) = nothing
  def bodyPart_=[T <: LoopNode](value: EList[ExecutableNode]) =
    (target: T) ⇒ target.getBodyParts.addAll(value)
  
  
  def selection(implicit ev: Nothing) = nothing
  def selection_=[T <: ObjectNode](value: Behavior) =
    (target: T) ⇒ target.setSelection(value)
  def selection_=[T <: ObjectNode](value: ⇒ Option[Behavior]) =
    (target: T) ⇒ target.setSelection(UmlBuilder.ref(value))
  
  def selection_=[T <: ObjectFlow](value: Behavior)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSelection(value)
  def selection_=[T <: ObjectFlow](value: ⇒ Option[Behavior])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSelection(UmlBuilder.ref(value))
  
  
  def aggregation(implicit ev: Nothing) = nothing
  def aggregation_=[T <: Property](value: AggregationKind) =
    (target: T) ⇒ target.setAggregation(value)
  
  
  def client(implicit ev: Nothing) = nothing
  def client_=[T <: Dependency](value: EList[NamedElement]) =
    (target: T) ⇒ target.getClients.addAll(value)
  
  
  def default(implicit ev: Nothing) = nothing
  def default_=[T <: TemplateParameter](value: ParameterableElement) =
    (target: T) ⇒ target.setDefault(value)
  def default_=[T <: TemplateParameter](value: ⇒ Option[ParameterableElement]) =
    (target: T) ⇒ target.setDefault(UmlBuilder.ref(value))
  
  
  def variable(implicit ev: Nothing) = nothing
  def variable_=[T <: Activity](value: EList[Variable]) =
    (target: T) ⇒ target.getVariables.addAll(value)
  
  def variable_=[T <: StructuredActivityNode](value: EList[Variable])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getVariables.addAll(value)
  
  def variable_=[T <: VariableAction](value: Variable)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setVariable(value)
  def variable_=[T <: VariableAction](value: ⇒ Option[Variable])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setVariable(UmlBuilder.ref(value))
  
  
  def covered(implicit ev: Nothing) = nothing
  def covered_=[T <: InteractionFragment](value: EList[Lifeline]) =
    (target: T) ⇒ target.getCovereds.addAll(value)
  
  
  def inputElement(implicit ev: Nothing) = nothing
  def inputElement_=[T <: ExpansionRegion](value: EList[ExpansionNode]) =
    (target: T) ⇒ target.getInputElements.addAll(value)
  
  
  def association(implicit ev: Nothing) = nothing
  def association_=[T <: Property](value: Association) =
    (target: T) ⇒ target.setAssociation(value)
  def association_=[T <: Property](value: ⇒ Option[Association]) =
    (target: T) ⇒ target.setAssociation(UmlBuilder.ref(value))
  
  def association_=[T <: ClearAssociationAction](value: Association)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setAssociation(value)
  def association_=[T <: ClearAssociationAction](value: ⇒ Option[Association])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setAssociation(UmlBuilder.ref(value))
  
  
  def sendEvent(implicit ev: Nothing) = nothing
  def sendEvent_=[T <: Message](value: MessageEnd) =
    (target: T) ⇒ target.setSendEvent(value)
  def sendEvent_=[T <: Message](value: ⇒ Option[MessageEnd]) =
    (target: T) ⇒ target.setSendEvent(UmlBuilder.ref(value))
  
  
  def structuralFeature(implicit ev: Nothing) = nothing
  def structuralFeature_=[T <: StructuralFeatureAction](value: StructuralFeature) =
    (target: T) ⇒ target.setStructuralFeature(value)
  def structuralFeature_=[T <: StructuralFeatureAction](value: ⇒ Option[StructuralFeature]) =
    (target: T) ⇒ target.setStructuralFeature(UmlBuilder.ref(value))
  
  
  def connector(implicit ev: Nothing) = nothing
  def connector_=[T <: Message](value: Connector) =
    (target: T) ⇒ target.setConnector(value)
  def connector_=[T <: Message](value: ⇒ Option[Connector]) =
    (target: T) ⇒ target.setConnector(UmlBuilder.ref(value))
  
  
  def viewpoint(implicit ev: Nothing) = nothing
  def viewpoint_=[T <: Model](value: String) =
    (target: T) ⇒ target.setViewpoint(value)
  
  
  def parameterSet(implicit ev: Nothing) = nothing
  def parameterSet_=[T <: Parameter](value: EList[ParameterSet]) =
    (target: T) ⇒ target.getParameterSets.addAll(value)
  
  
  def isConjugated(implicit ev: Nothing) = nothing
  def isConjugated_=[T <: Port](value: Boolean) =
    (target: T) ⇒ target.setIsConjugated(value)
  
  
  def interrupts(implicit ev: Nothing) = nothing
  def interrupts_=[T <: ActivityEdge](value: InterruptibleActivityRegion) =
    (target: T) ⇒ target.setInterrupts(value)
  def interrupts_=[T <: ActivityEdge](value: ⇒ Option[InterruptibleActivityRegion]) =
    (target: T) ⇒ target.setInterrupts(UmlBuilder.ref(value))
  
  
  def ownedDefault(implicit ev: Nothing) = nothing
  def ownedDefault_=[T <: TemplateParameter](value: ParameterableElement) =
    (target: T) ⇒ target.setOwnedDefault(value)
  
  
  def content(implicit ev: Nothing) = nothing
  def content_=[T <: Image](value: String) =
    (target: T) ⇒ target.setContent(value)
  
  
  def configuration(implicit ev: Nothing) = nothing
  def configuration_=[T <: Deployment](value: EList[DeploymentSpecification]) =
    (target: T) ⇒ target.getConfigurations.addAll(value)
  
  
  def isActive(implicit ev: Nothing) = nothing
  def isActive_=[T <: org.eclipse.uml2.uml.Class](value: Boolean) =
    (target: T) ⇒ target.setIsActive(value)
  
  
  def insertAt(implicit ev: Nothing) = nothing
  def insertAt_=[T <: AddStructuralFeatureValueAction](value: InputPin) =
    (target: T) ⇒ target.setInsertAt(value)
  
  def insertAt_=[T <: AddVariableValueAction](value: InputPin)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setInsertAt(value)
  
  def insertAt_=[T <: LinkEndCreationData](value: InputPin)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setInsertAt(value)
  def insertAt_=[T <: LinkEndCreationData](value: ⇒ Option[InputPin])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setInsertAt(UmlBuilder.ref(value))
  
  
  def returnValueRecipient(implicit ev: Nothing) = nothing
  def returnValueRecipient_=[T <: InteractionUse](value: Property) =
    (target: T) ⇒ target.setReturnValueRecipient(value)
  def returnValueRecipient_=[T <: InteractionUse](value: ⇒ Option[Property]) =
    (target: T) ⇒ target.setReturnValueRecipient(UmlBuilder.ref(value))
  
  
  def first(implicit ev: Nothing) = nothing
  def first_=[T <: TestIdentityAction](value: InputPin) =
    (target: T) ⇒ target.setFirst(value)
  
  
  def ordering(implicit ev: Nothing) = nothing
  def ordering_=[T <: ObjectNode](value: ObjectNodeOrderingKind) =
    (target: T) ⇒ target.setOrdering(value)
  
  
  def navigableOwnedEnd(implicit ev: Nothing) = nothing
  def navigableOwnedEnd_=[T <: Association](value: EList[Property]) =
    (target: T) ⇒ target.getNavigableOwnedEnds.addAll(value)
  
  
  def isAssured(implicit ev: Nothing) = nothing
  def isAssured_=[T <: ConditionalNode](value: Boolean) =
    (target: T) ⇒ target.setIsAssured(value)
  
  
  def include(implicit ev: Nothing) = nothing
  def include_=[T <: UseCase](value: EList[Include]) =
    (target: T) ⇒ target.getIncludes.addAll(value)
  
  
  def profileApplication(implicit ev: Nothing) = nothing
  def profileApplication_=[T <: org.eclipse.uml2.uml.Package](value: EList[ProfileApplication]) =
    (target: T) ⇒ target.getProfileApplications.addAll(value)
  
  
  def importedElement(implicit ev: Nothing) = nothing
  def importedElement_=[T <: ElementImport](value: PackageableElement) =
    (target: T) ⇒ target.setImportedElement(value)
  def importedElement_=[T <: ElementImport](value: ⇒ Option[PackageableElement]) =
    (target: T) ⇒ target.setImportedElement(UmlBuilder.ref(value))
  
  
  def region(implicit ev: Nothing) = nothing
  def region_=[T <: StateMachine](value: EList[Region]) =
    (target: T) ⇒ target.getRegions.addAll(value)
  
  def region_=[T <: State](value: EList[Region])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getRegions.addAll(value)
  
  
  def exit(implicit ev: Nothing) = nothing
  def exit_=[T <: State](value: Behavior) =
    (target: T) ⇒ target.setExit(value)
  
  def exit_=[T <: ConnectionPointReference](value: EList[Pseudostate])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getExits.addAll(value)
  
  
  def precondition(implicit ev: Nothing) = nothing
  def precondition_=[T <: Operation](value: EList[Constraint]) =
    (target: T) ⇒ target.getPreconditions.addAll(value)
  
  def precondition_=[T <: Behavior](value: EList[Constraint])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getPreconditions.addAll(value)
  
  
  def mode(implicit ev: Nothing) = nothing
  def mode_=[T <: ExpansionRegion](value: ExpansionKind) =
    (target: T) ⇒ target.setMode(value)
  
  
  def outputElement(implicit ev: Nothing) = nothing
  def outputElement_=[T <: ExpansionRegion](value: EList[ExpansionNode]) =
    (target: T) ⇒ target.getOutputElements.addAll(value)
  
  
  def successorClause(implicit ev: Nothing) = nothing
  def successorClause_=[T <: Clause](value: EList[Clause]) =
    (target: T) ⇒ target.getSuccessorClauses.addAll(value)
  
  
  def end(implicit ev: Nothing) = nothing
  def end_=[T <: Connector](value: EList[ConnectorEnd]) =
    (target: T) ⇒ target.getEnds.addAll(value)
  
  def end_=[T <: LinkEndData](value: Property)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setEnd(value)
  def end_=[T <: LinkEndData](value: ⇒ Option[Property])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setEnd(UmlBuilder.ref(value))
  
  def end_=[T <: ReadLinkObjectEndAction](value: Property)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setEnd(value)
  def end_=[T <: ReadLinkObjectEndAction](value: ⇒ Option[Property])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setEnd(UmlBuilder.ref(value))
  
  
  def isMulticast(implicit ev: Nothing) = nothing
  def isMulticast_=[T <: ObjectFlow](value: Boolean) =
    (target: T) ⇒ target.setIsMulticast(value)
  
  
  def importedPackage(implicit ev: Nothing) = nothing
  def importedPackage_=[T <: PackageImport](value: org.eclipse.uml2.uml.Package) =
    (target: T) ⇒ target.setImportedPackage(value)
  def importedPackage_=[T <: PackageImport](value: ⇒ Option[org.eclipse.uml2.uml.Package]) =
    (target: T) ⇒ target.setImportedPackage(UmlBuilder.ref(value))
  
  
  def message(implicit ev: Nothing) = nothing
  def message_=[T <: MessageEnd](value: Message) =
    (target: T) ⇒ target.setMessage(value)
  def message_=[T <: MessageEnd](value: ⇒ Option[Message]) =
    (target: T) ⇒ target.setMessage(UmlBuilder.ref(value))
  
  def message_=[T <: Interaction](value: EList[Message])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getMessages.addAll(value)
  
  def message_=[T <: ConsiderIgnoreFragment](value: EList[NamedElement])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getMessages.addAll(value)
  
  
  def isReentrant(implicit ev: Nothing) = nothing
  def isReentrant_=[T <: Behavior](value: Boolean) =
    (target: T) ⇒ target.setIsReentrant(value)
  
  
  def target(implicit ev: Nothing) = nothing
  def target_=[T <: Transition](value: Vertex) =
    (target: T) ⇒ target.setTarget(value)
  def target_=[T <: Transition](value: ⇒ Option[Vertex]) =
    (target: T) ⇒ target.setTarget(UmlBuilder.ref(value))
  
  def target_=[T <: ActivityEdge](value: ActivityNode)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setTarget(value)
  def target_=[T <: ActivityEdge](value: ⇒ Option[ActivityNode])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setTarget(UmlBuilder.ref(value))
  
  def target_=[T <: CallOperationAction](value: InputPin)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setTarget(value)
  
  def target_=[T <: DestroyObjectAction](value: InputPin)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setTarget(value)
  
  def target_=[T <: SendObjectAction](value: InputPin)(implicit o: Overloaded4) =
    (target: T) ⇒ target.setTarget(value)
  
  def target_=[T <: SendSignalAction](value: InputPin)(implicit o: Overloaded5) =
    (target: T) ⇒ target.setTarget(value)
  
  
  def classifier(implicit ev: Nothing) = nothing
  def classifier_=[T <: InstanceSpecification](value: EList[Classifier]) =
    (target: T) ⇒ target.getClassifiers.addAll(value)
  
  def classifier_=[T <: CreateObjectAction](value: Classifier)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setClassifier(value)
  def classifier_=[T <: CreateObjectAction](value: ⇒ Option[Classifier])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setClassifier(UmlBuilder.ref(value))
  
  def classifier_=[T <: ReadExtentAction](value: Classifier)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setClassifier(value)
  def classifier_=[T <: ReadExtentAction](value: ⇒ Option[Classifier])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setClassifier(UmlBuilder.ref(value))
  
  def classifier_=[T <: ReadIsClassifiedObjectAction](value: Classifier)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setClassifier(value)
  def classifier_=[T <: ReadIsClassifiedObjectAction](value: ⇒ Option[Classifier])(implicit o: Overloaded3) =
    (target: T) ⇒ target.setClassifier(UmlBuilder.ref(value))
  
  
  def templateParameter(implicit ev: Nothing) = nothing
  def templateParameter_=[T <: ParameterableElement](value: TemplateParameter) =
    (target: T) ⇒ target.setTemplateParameter(value)
  def templateParameter_=[T <: ParameterableElement](value: ⇒ Option[TemplateParameter]) =
    (target: T) ⇒ target.setTemplateParameter(UmlBuilder.ref(value))
  
  
  def redefinedProperty(implicit ev: Nothing) = nothing
  def redefinedProperty_=[T <: Property](value: EList[Property]) =
    (target: T) ⇒ target.getRedefinedProperties.addAll(value)
  
  
  def receiveEvent(implicit ev: Nothing) = nothing
  def receiveEvent_=[T <: Message](value: MessageEnd) =
    (target: T) ⇒ target.setReceiveEvent(value)
  def receiveEvent_=[T <: Message](value: ⇒ Option[MessageEnd]) =
    (target: T) ⇒ target.setReceiveEvent(UmlBuilder.ref(value))
  
  
  def inState(implicit ev: Nothing) = nothing
  def inState_=[T <: ObjectNode](value: EList[State]) =
    (target: T) ⇒ target.getInStates.addAll(value)
  
  
  def raisedException(implicit ev: Nothing) = nothing
  def raisedException_=[T <: BehavioralFeature](value: EList[Type]) =
    (target: T) ⇒ target.getRaisedExceptions.addAll(value)
  
  
  def node(implicit ev: Nothing) = nothing
  def node_=[T <: ActivityPartition](value: EList[ActivityNode]) =
    (target: T) ⇒ target.getNodes.addAll(value)
  
  def node_=[T <: StructuredActivityNode](value: EList[ActivityNode])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getNodes.addAll(value)
  
  def node_=[T <: InterruptibleActivityRegion](value: EList[ActivityNode])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getNodes.addAll(value)
  
  
  def transition(implicit ev: Nothing) = nothing
  def transition_=[T <: Region](value: EList[Transition]) =
    (target: T) ⇒ target.getTransitions.addAll(value)
  
  
  def templateBinding(implicit ev: Nothing) = nothing
  def templateBinding_=[T <: TemplateableElement](value: EList[TemplateBinding]) =
    (target: T) ⇒ target.getTemplateBindings.addAll(value)
  
  
  def decisionInput(implicit ev: Nothing) = nothing
  def decisionInput_=[T <: DecisionNode](value: Behavior) =
    (target: T) ⇒ target.setDecisionInput(value)
  def decisionInput_=[T <: DecisionNode](value: ⇒ Option[Behavior]) =
    (target: T) ⇒ target.setDecisionInput(UmlBuilder.ref(value))
  
  
  def packagedElement(implicit ev: Nothing) = nothing
  def packagedElement_=[T <: org.eclipse.uml2.uml.Package](value: EList[PackageableElement]) =
    (target: T) ⇒ target.getPackagedElements.addAll(value)
  
  def packagedElement_=[T <: Component](value: EList[PackageableElement])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getPackagedElements.addAll(value)
  
  
  def changeExpression(implicit ev: Nothing) = nothing
  def changeExpression_=[T <: ChangeEvent](value: ValueSpecification) =
    (target: T) ⇒ target.setChangeExpression(value)
  
  
  def connection(implicit ev: Nothing) = nothing
  def connection_=[T <: State](value: EList[ConnectionPointReference]) =
    (target: T) ⇒ target.getConnections.addAll(value)
  
  
  def deferrableTrigger(implicit ev: Nothing) = nothing
  def deferrableTrigger_=[T <: State](value: EList[Trigger]) =
    (target: T) ⇒ target.getDeferrableTriggers.addAll(value)
  
  
  def redefinedState(implicit ev: Nothing) = nothing
  def redefinedState_=[T <: State](value: State) =
    (target: T) ⇒ target.setRedefinedState(value)
  def redefinedState_=[T <: State](value: ⇒ Option[State]) =
    (target: T) ⇒ target.setRedefinedState(UmlBuilder.ref(value))
  
  
  def edge(implicit ev: Nothing) = nothing
  def edge_=[T <: Activity](value: EList[ActivityEdge]) =
    (target: T) ⇒ target.getEdges.addAll(value)
  
  def edge_=[T <: ActivityPartition](value: EList[ActivityEdge])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getEdges.addAll(value)
  
  def edge_=[T <: StructuredActivityNode](value: EList[ActivityEdge])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getEdges.addAll(value)
  
  
  def decomposedAs(implicit ev: Nothing) = nothing
  def decomposedAs_=[T <: Lifeline](value: PartDecomposition) =
    (target: T) ⇒ target.setDecomposedAs(value)
  def decomposedAs_=[T <: Lifeline](value: ⇒ Option[PartDecomposition]) =
    (target: T) ⇒ target.setDecomposedAs(UmlBuilder.ref(value))
  
  
  def isAbstract(implicit ev: Nothing) = nothing
  def isAbstract_=[T <: Classifier](value: Boolean) =
    (target: T) ⇒ target.setIsAbstract(value)
  
  def isAbstract_=[T <: BehavioralFeature](value: Boolean)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setIsAbstract(value)
  
  
  def guard(implicit ev: Nothing) = nothing
  def guard_=[T <: Transition](value: Constraint) =
    (target: T) ⇒ target.setGuard(value)
  def guard_=[T <: Transition](value: ⇒ Option[Constraint]) =
    (target: T) ⇒ target.setGuard(UmlBuilder.ref(value))
  
  def guard_=[T <: ActivityEdge](value: ValueSpecification)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setGuard(value)
  
  def guard_=[T <: InteractionOperand](value: InteractionConstraint)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setGuard(value)
  
  
  def kind(implicit ev: Nothing) = nothing
  def kind_=[T <: Pseudostate](value: PseudostateKind) =
    (target: T) ⇒ target.setKind(value)
  
  def kind_=[T <: Transition](value: TransitionKind)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setKind(value)
  
  
  def behavior(implicit ev: Nothing) = nothing
  def behavior_=[T <: OpaqueExpression](value: Behavior) =
    (target: T) ⇒ target.setBehavior(value)
  def behavior_=[T <: OpaqueExpression](value: ⇒ Option[Behavior]) =
    (target: T) ⇒ target.setBehavior(UmlBuilder.ref(value))
  
  def behavior_=[T <: BehaviorExecutionSpecification](value: Behavior)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setBehavior(value)
  def behavior_=[T <: BehaviorExecutionSpecification](value: ⇒ Option[Behavior])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setBehavior(UmlBuilder.ref(value))
  
  def behavior_=[T <: CallBehaviorAction](value: Behavior)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setBehavior(value)
  def behavior_=[T <: CallBehaviorAction](value: ⇒ Option[Behavior])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setBehavior(UmlBuilder.ref(value))
  
  
  def appliedProfile(implicit ev: Nothing) = nothing
  def appliedProfile_=[T <: ProfileApplication](value: Profile) =
    (target: T) ⇒ target.setAppliedProfile(value)
  def appliedProfile_=[T <: ProfileApplication](value: ⇒ Option[Profile]) =
    (target: T) ⇒ target.setAppliedProfile(UmlBuilder.ref(value))
  
  
  def isBehavior(implicit ev: Nothing) = nothing
  def isBehavior_=[T <: Port](value: Boolean) =
    (target: T) ⇒ target.setIsBehavior(value)
  
  
  def `type`(implicit ev: Nothing) = nothing
  def type_=[T <: TypedElement](value: Type) =
    (target: T) ⇒ target.setType(value)
  def type_=[T <: TypedElement](value: ⇒ Option[Type]) =
    (target: T) ⇒ target.setType(UmlBuilder.ref(value))
  
  def type_=[T <: CollaborationUse](value: Collaboration)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setType(value)
  def type_=[T <: CollaborationUse](value: ⇒ Option[Collaboration])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setType(UmlBuilder.ref(value))
  
  def type_=[T <: Connector](value: Association)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setType(value)
  def type_=[T <: Connector](value: ⇒ Option[Association])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setType(UmlBuilder.ref(value))
  
  
  def invariant(implicit ev: Nothing) = nothing
  def invariant_=[T <: StateInvariant](value: Constraint) =
    (target: T) ⇒ target.setInvariant(value)
  
  
  def subsettedProperty(implicit ev: Nothing) = nothing
  def subsettedProperty_=[T <: Property](value: EList[Property]) =
    (target: T) ⇒ target.getSubsettedProperties.addAll(value)
  
  
  def collaborationRole(implicit ev: Nothing) = nothing
  def collaborationRole_=[T <: Collaboration](value: EList[ConnectableElement]) =
    (target: T) ⇒ target.getCollaborationRoles.addAll(value)
  
  
  def inInterruptibleRegion(implicit ev: Nothing) = nothing
  def inInterruptibleRegion_=[T <: ActivityNode](value: EList[InterruptibleActivityRegion]) =
    (target: T) ⇒ target.getInInterruptibleRegions.addAll(value)
  
  
  def start(implicit ev: Nothing) = nothing
  def start_=[T <: ExecutionSpecification](value: OccurrenceSpecification) =
    (target: T) ⇒ target.setStart(value)
  def start_=[T <: ExecutionSpecification](value: ⇒ Option[OccurrenceSpecification]) =
    (target: T) ⇒ target.setStart(UmlBuilder.ref(value))
  
  
  def redefinedClassifier(implicit ev: Nothing) = nothing
  def redefinedClassifier_=[T <: Classifier](value: EList[Classifier]) =
    (target: T) ⇒ target.getRedefinedClassifiers.addAll(value)
  
  
  def ownedParameterSet(implicit ev: Nothing) = nothing
  def ownedParameterSet_=[T <: BehavioralFeature](value: EList[ParameterSet]) =
    (target: T) ⇒ target.getOwnedParameterSets.addAll(value)
  
  def ownedParameterSet_=[T <: Behavior](value: EList[ParameterSet])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getOwnedParameterSets.addAll(value)
  
  
  def isDestroyDuplicates(implicit ev: Nothing) = nothing
  def isDestroyDuplicates_=[T <: LinkEndDestructionData](value: Boolean) =
    (target: T) ⇒ target.setIsDestroyDuplicates(value)
  
  
  def observation(implicit ev: Nothing) = nothing
  def observation_=[T <: Duration](value: EList[Observation]) =
    (target: T) ⇒ target.getObservations.addAll(value)
  
  def observation_=[T <: TimeExpression](value: EList[Observation])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getObservations.addAll(value)
  
  
  def fromAction(implicit ev: Nothing) = nothing
  def fromAction_=[T <: ActionInputPin](value: Action) =
    (target: T) ⇒ target.setFromAction(value)
  
  
  def cfragmentGate(implicit ev: Nothing) = nothing
  def cfragmentGate_=[T <: CombinedFragment](value: EList[Gate]) =
    (target: T) ⇒ target.getCfragmentGates.addAll(value)
  
  
  def defaultValue(implicit ev: Nothing) = nothing
  def defaultValue_=[T <: Property](value: ValueSpecification) =
    (target: T) ⇒ target.setDefaultValue(value)
  
  def defaultValue_=[T <: Parameter](value: ValueSpecification)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setDefaultValue(value)
  
  
  def selector(implicit ev: Nothing) = nothing
  def selector_=[T <: Lifeline](value: ValueSpecification) =
    (target: T) ⇒ target.setSelector(value)
  
  
  def actual(implicit ev: Nothing) = nothing
  def actual_=[T <: TemplateParameterSubstitution](value: ParameterableElement) =
    (target: T) ⇒ target.setActual(value)
  def actual_=[T <: TemplateParameterSubstitution](value: ⇒ Option[ParameterableElement]) =
    (target: T) ⇒ target.setActual(UmlBuilder.ref(value))
  
  
  def isLocallyReentrant(implicit ev: Nothing) = nothing
  def isLocallyReentrant_=[T <: Action](value: Boolean) =
    (target: T) ⇒ target.setIsLocallyReentrant(value)
  
  
  def clause(implicit ev: Nothing) = nothing
  def clause_=[T <: ConditionalNode](value: EList[Clause]) =
    (target: T) ⇒ target.getClauses.addAll(value)
  
  
  def slot(implicit ev: Nothing) = nothing
  def slot_=[T <: InstanceSpecification](value: EList[Slot]) =
    (target: T) ⇒ target.getSlots.addAll(value)
  
  
  def substitution(implicit ev: Nothing) = nothing
  def substitution_=[T <: Classifier](value: EList[Substitution]) =
    (target: T) ⇒ target.getSubstitutions.addAll(value)
  
  
  def parameteredElement(implicit ev: Nothing) = nothing
  def parameteredElement_=[T <: TemplateParameter](value: ParameterableElement) =
    (target: T) ⇒ target.setParameteredElement(value)
  def parameteredElement_=[T <: TemplateParameter](value: ⇒ Option[ParameterableElement]) =
    (target: T) ⇒ target.setParameteredElement(UmlBuilder.ref(value))
  
  
  def partWithPort(implicit ev: Nothing) = nothing
  def partWithPort_=[T <: ConnectorEnd](value: Property) =
    (target: T) ⇒ target.setPartWithPort(value)
  def partWithPort_=[T <: ConnectorEnd](value: ⇒ Option[Property]) =
    (target: T) ⇒ target.setPartWithPort(UmlBuilder.ref(value))
  
  
  def upperValue(implicit ev: Nothing) = nothing
  def upperValue_=[T <: MultiplicityElement](value: ValueSpecification) =
    (target: T) ⇒ target.setUpperValue(value)
  
  
  def doActivity(implicit ev: Nothing) = nothing
  def doActivity_=[T <: State](value: Behavior) =
    (target: T) ⇒ target.setDoActivity(value)
  
  
  def formal(implicit ev: Nothing) = nothing
  def formal_=[T <: TemplateParameterSubstitution](value: TemplateParameter) =
    (target: T) ⇒ target.setFormal(value)
  def formal_=[T <: TemplateParameterSubstitution](value: ⇒ Option[TemplateParameter]) =
    (target: T) ⇒ target.setFormal(UmlBuilder.ref(value))
  
  
  def nestedClassifier(implicit ev: Nothing) = nothing
  def nestedClassifier_=[T <: org.eclipse.uml2.uml.Class](value: EList[Classifier]) =
    (target: T) ⇒ target.getNestedClassifiers.addAll(value)
  
  def nestedClassifier_=[T <: Interface](value: EList[Classifier])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getNestedClassifiers.addAll(value)
  
  
  def isDerived(implicit ev: Nothing) = nothing
  def isDerived_=[T <: Association](value: Boolean) =
    (target: T) ⇒ target.setIsDerived(value)
  
  def isDerived_=[T <: Property](value: Boolean)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setIsDerived(value)
  
  
  def redefinedNode(implicit ev: Nothing) = nothing
  def redefinedNode_=[T <: ActivityNode](value: EList[ActivityNode]) =
    (target: T) ⇒ target.getRedefinedNodes.addAll(value)
  
  
  def argument(implicit ev: Nothing) = nothing
  def argument_=[T <: InteractionUse](value: EList[ValueSpecification]) =
    (target: T) ⇒ target.getArguments.addAll(value)
  
  def argument_=[T <: Message](value: EList[ValueSpecification])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getArguments.addAll(value)
  
  def argument_=[T <: InvocationAction](value: EList[InputPin])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getArguments.addAll(value)
  
  
  def ownedRule(implicit ev: Nothing) = nothing
  def ownedRule_=[T <: Namespace](value: EList[Constraint]) =
    (target: T) ⇒ target.getOwnedRules.addAll(value)
  
  
  def handler(implicit ev: Nothing) = nothing
  def handler_=[T <: ExecutableNode](value: EList[ExceptionHandler]) =
    (target: T) ⇒ target.getHandlers.addAll(value)
  
  
  def visibility(implicit ev: Nothing) = nothing
  def visibility_=[T <: NamedElement](value: VisibilityKind) =
    (target: T) ⇒ target.setVisibility(value)
  
  def visibility_=[T <: ElementImport](value: VisibilityKind)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setVisibility(value)
  
  def visibility_=[T <: PackageImport](value: VisibilityKind)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setVisibility(value)
  
  
  def value(implicit ev: Nothing) = nothing
  def value_=[T <: Slot](value: EList[ValueSpecification]) =
    (target: T) ⇒ target.getValues.addAll(value)
  
  def value_=[T <: WriteStructuralFeatureAction](value: InputPin)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: WriteVariableAction](value: InputPin)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: LinkEndData](value: InputPin)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setValue(value)
  def value_=[T <: LinkEndData](value: ⇒ Option[InputPin])(implicit o: Overloaded3) =
    (target: T) ⇒ target.setValue(UmlBuilder.ref(value))
  
  def value_=[T <: QualifierValue](value: InputPin)(implicit o: Overloaded4) =
    (target: T) ⇒ target.setValue(value)
  def value_=[T <: QualifierValue](value: ⇒ Option[InputPin])(implicit o: Overloaded4) =
    (target: T) ⇒ target.setValue(UmlBuilder.ref(value))
  
  def value_=[T <: LiteralBoolean](value: Boolean)(implicit o: Overloaded5) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: LiteralInteger](value: Int)(implicit o: Overloaded6) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: LiteralReal](value: Double)(implicit o: Overloaded7) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: LiteralString](value: String)(implicit o: Overloaded8) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: LiteralUnlimitedNatural](value: Int)(implicit o: Overloaded9) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: ValuePin](value: ValueSpecification)(implicit o: Overloaded10) =
    (target: T) ⇒ target.setValue(value)
  
  def value_=[T <: ValueSpecificationAction](value: ValueSpecification)(implicit o: Overloaded11) =
    (target: T) ⇒ target.setValue(value)
  
  
  def when(implicit ev: Nothing) = nothing
  def when_=[T <: TimeEvent](value: TimeExpression) =
    (target: T) ⇒ target.setWhen(value)
  
  
  def elementImport(implicit ev: Nothing) = nothing
  def elementImport_=[T <: Namespace](value: EList[ElementImport]) =
    (target: T) ⇒ target.getElementImports.addAll(value)
  
  
  def action(implicit ev: Nothing) = nothing
  def action_=[T <: ActionExecutionSpecification](value: Action) =
    (target: T) ⇒ target.setAction(value)
  def action_=[T <: ActionExecutionSpecification](value: ⇒ Option[Action]) =
    (target: T) ⇒ target.setAction(UmlBuilder.ref(value))
  
  def action_=[T <: Interaction](value: EList[Action])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getActions.addAll(value)
  
  
  def replyToCall(implicit ev: Nothing) = nothing
  def replyToCall_=[T <: ReplyAction](value: Trigger) =
    (target: T) ⇒ target.setReplyToCall(value)
  def replyToCall_=[T <: ReplyAction](value: ⇒ Option[Trigger]) =
    (target: T) ⇒ target.setReplyToCall(UmlBuilder.ref(value))
  
  
  def protocol(implicit ev: Nothing) = nothing
  def protocol_=[T <: Interface](value: ProtocolStateMachine) =
    (target: T) ⇒ target.setProtocol(value)
  
  def protocol_=[T <: Port](value: ProtocolStateMachine)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setProtocol(value)
  def protocol_=[T <: Port](value: ⇒ Option[ProtocolStateMachine])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setProtocol(UmlBuilder.ref(value))
  
  
  def representation(implicit ev: Nothing) = nothing
  def representation_=[T <: Classifier](value: CollaborationUse) =
    (target: T) ⇒ target.setRepresentation(value)
  def representation_=[T <: Classifier](value: ⇒ Option[CollaborationUse]) =
    (target: T) ⇒ target.setRepresentation(UmlBuilder.ref(value))
  
  
  def executionLocation(implicit ev: Nothing) = nothing
  def executionLocation_=[T <: DeploymentSpecification](value: String) =
    (target: T) ⇒ target.setExecutionLocation(value)
  
  
  def bodyOutput(implicit ev: Nothing) = nothing
  def bodyOutput_=[T <: Clause](value: EList[OutputPin]) =
    (target: T) ⇒ target.getBodyOutputs.addAll(value)
  
  def bodyOutput_=[T <: LoopNode](value: EList[OutputPin])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getBodyOutputs.addAll(value)
  
  
  def isDisjoint(implicit ev: Nothing) = nothing
  def isDisjoint_=[T <: GeneralizationSet](value: Boolean) =
    (target: T) ⇒ target.setIsDisjoint(value)
  
  
  def isDestroyOwnedObjects(implicit ev: Nothing) = nothing
  def isDestroyOwnedObjects_=[T <: DestroyObjectAction](value: Boolean) =
    (target: T) ⇒ target.setIsDestroyOwnedObjects(value)
  
  
  def unmarshallType(implicit ev: Nothing) = nothing
  def unmarshallType_=[T <: UnmarshallAction](value: Classifier) =
    (target: T) ⇒ target.setUnmarshallType(value)
  def unmarshallType_=[T <: UnmarshallAction](value: ⇒ Option[Classifier]) =
    (target: T) ⇒ target.setUnmarshallType(UmlBuilder.ref(value))
  
  
  def contract(implicit ev: Nothing) = nothing
  def contract_=[T <: InterfaceRealization](value: Interface) =
    (target: T) ⇒ target.setContract(value)
  def contract_=[T <: InterfaceRealization](value: ⇒ Option[Interface]) =
    (target: T) ⇒ target.setContract(UmlBuilder.ref(value))
  
  def contract_=[T <: Substitution](value: Classifier)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setContract(value)
  def contract_=[T <: Substitution](value: ⇒ Option[Classifier])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setContract(UmlBuilder.ref(value))
  
  def contract_=[T <: Connector](value: EList[Behavior])(implicit o: Overloaded2) =
    (target: T) ⇒ target.getContracts.addAll(value)
  
  
  def inputValue(implicit ev: Nothing) = nothing
  def inputValue_=[T <: LinkAction](value: EList[InputPin]) =
    (target: T) ⇒ target.getInputValues.addAll(value)
  
  def inputValue_=[T <: OpaqueAction](value: EList[InputPin])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getInputValues.addAll(value)
  
  
  def allowSubstitutable(implicit ev: Nothing) = nothing
  def allowSubstitutable_=[T <: ClassifierTemplateParameter](value: Boolean) =
    (target: T) ⇒ target.setAllowSubstitutable(value)
  
  
  def packageImport(implicit ev: Nothing) = nothing
  def packageImport_=[T <: Namespace](value: EList[PackageImport]) =
    (target: T) ⇒ target.getPackageImports.addAll(value)
  
  
  def metaclassReference(implicit ev: Nothing) = nothing
  def metaclassReference_=[T <: Profile](value: EList[ElementImport]) =
    (target: T) ⇒ target.getMetaclassReferences.addAll(value)
  
  
  def isDestroyLinks(implicit ev: Nothing) = nothing
  def isDestroyLinks_=[T <: DestroyObjectAction](value: Boolean) =
    (target: T) ⇒ target.setIsDestroyLinks(value)
  
  
  def reducer(implicit ev: Nothing) = nothing
  def reducer_=[T <: ReduceAction](value: Behavior) =
    (target: T) ⇒ target.setReducer(value)
  def reducer_=[T <: ReduceAction](value: ⇒ Option[Behavior]) =
    (target: T) ⇒ target.setReducer(UmlBuilder.ref(value))
  
  
  def mergedPackage(implicit ev: Nothing) = nothing
  def mergedPackage_=[T <: PackageMerge](value: org.eclipse.uml2.uml.Package) =
    (target: T) ⇒ target.setMergedPackage(value)
  def mergedPackage_=[T <: PackageMerge](value: ⇒ Option[org.eclipse.uml2.uml.Package]) =
    (target: T) ⇒ target.setMergedPackage(UmlBuilder.ref(value))
  
  
  def metamodelReference(implicit ev: Nothing) = nothing
  def metamodelReference_=[T <: Profile](value: EList[PackageImport]) =
    (target: T) ⇒ target.getMetamodelReferences.addAll(value)
  
  
  def isQuery(implicit ev: Nothing) = nothing
  def isQuery_=[T <: Operation](value: Boolean) =
    (target: T) ⇒ target.setIsQuery(value)
  
  
  def actualGate(implicit ev: Nothing) = nothing
  def actualGate_=[T <: InteractionUse](value: EList[Gate]) =
    (target: T) ⇒ target.getActualGates.addAll(value)
  
  
  def localPostcondition(implicit ev: Nothing) = nothing
  def localPostcondition_=[T <: Action](value: EList[Constraint]) =
    (target: T) ⇒ target.getLocalPostconditions.addAll(value)
  
  
  def submachine(implicit ev: Nothing) = nothing
  def submachine_=[T <: State](value: StateMachine) =
    (target: T) ⇒ target.setSubmachine(value)
  def submachine_=[T <: State](value: ⇒ Option[StateMachine]) =
    (target: T) ⇒ target.setSubmachine(UmlBuilder.ref(value))
  
  
  def isStream(implicit ev: Nothing) = nothing
  def isStream_=[T <: Parameter](value: Boolean) =
    (target: T) ⇒ target.setIsStream(value)
  
  
  def trigger(implicit ev: Nothing) = nothing
  def trigger_=[T <: Transition](value: EList[Trigger]) =
    (target: T) ⇒ target.getTriggers.addAll(value)
  
  def trigger_=[T <: AcceptEventAction](value: EList[Trigger])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getTriggers.addAll(value)
  
  
  def signal(implicit ev: Nothing) = nothing
  def signal_=[T <: Reception](value: Signal) =
    (target: T) ⇒ target.setSignal(value)
  def signal_=[T <: Reception](value: ⇒ Option[Signal]) =
    (target: T) ⇒ target.setSignal(UmlBuilder.ref(value))
  
  def signal_=[T <: BroadcastSignalAction](value: Signal)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSignal(value)
  def signal_=[T <: BroadcastSignalAction](value: ⇒ Option[Signal])(implicit o: Overloaded1) =
    (target: T) ⇒ target.setSignal(UmlBuilder.ref(value))
  
  def signal_=[T <: SendSignalAction](value: Signal)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setSignal(value)
  def signal_=[T <: SendSignalAction](value: ⇒ Option[Signal])(implicit o: Overloaded2) =
    (target: T) ⇒ target.setSignal(UmlBuilder.ref(value))
  
  def signal_=[T <: SignalEvent](value: Signal)(implicit o: Overloaded3) =
    (target: T) ⇒ target.setSignal(value)
  def signal_=[T <: SignalEvent](value: ⇒ Option[Signal])(implicit o: Overloaded3) =
    (target: T) ⇒ target.setSignal(UmlBuilder.ref(value))
}

trait OverloadHack {
  class Overloaded1
  implicit val overload1 = new Overloaded1
  
  class Overloaded2
  implicit val overload2 = new Overloaded2
  
  class Overloaded3
  implicit val overload3 = new Overloaded3
  
  class Overloaded4
  implicit val overload4 = new Overloaded4
  
  class Overloaded5
  implicit val overload5 = new Overloaded5
  
  class Overloaded6
  implicit val overload6 = new Overloaded6
  
  class Overloaded7
  implicit val overload7 = new Overloaded7
  
  class Overloaded8
  implicit val overload8 = new Overloaded8
  
  class Overloaded9
  implicit val overload9 = new Overloaded9
  
  class Overloaded10
  implicit val overload10 = new Overloaded10
  
  class Overloaded11
  implicit val overload11 = new Overloaded11
  
  class Overloaded12
  implicit val overload12 = new Overloaded12
  
  class Overloaded13
  implicit val overload13 = new Overloaded13
  
  class Overloaded14
  implicit val overload14 = new Overloaded14
  
  class Overloaded15
  implicit val overload15 = new Overloaded15
  
  class Overloaded16
  implicit val overload16 = new Overloaded16
  
  class Overloaded17
  implicit val overload17 = new Overloaded17
  
  class Overloaded18
  implicit val overload18 = new Overloaded18
  
  class Overloaded19
  implicit val overload19 = new Overloaded19
}

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait OperationScalaSupport extends EMFScalaSupport {
  type Operation = org.eclipse.uml2.uml.Operation
  
  protected implicit val _operationProxyBuilder = new EMFProxyBuilder[Operation](UMLPackageScalaSupport._umlBuilder)
  
  object Operation {
    def apply(): Operation = {
      UMLPackageScalaSupport._umlBuilder.create[Operation]
    }
  }
  
  implicit class OperationScalaSupport(that: Operation) {
    def interface: Interface = that.getInterface
    def interface_=(value: Interface): Unit = that.setInterface(value)
    def interface_=(value: ⇒ Option[Interface]): Unit =
      that.setInterface(UMLPackageScalaSupport._umlBuilder.ref(value))
    def bodyCondition: Constraint = that.getBodyCondition
    def bodyCondition_=(value: Constraint): Unit = that.setBodyCondition(value)
    def bodyCondition_=(value: ⇒ Option[Constraint]): Unit =
      that.setBodyCondition(UMLPackageScalaSupport._umlBuilder.ref(value))
    def class_ : org.eclipse.uml2.uml.Class = that.getClass_
    def class__=(value: org.eclipse.uml2.uml.Class): Unit = that.setClass_(value)
    def class__=(value: ⇒ Option[org.eclipse.uml2.uml.Class]): Unit =
      that.setClass_(UMLPackageScalaSupport._umlBuilder.ref(value))
    def datatype: DataType = that.getDatatype
    def datatype_=(value: DataType): Unit = that.setDatatype(value)
    def datatype_=(value: ⇒ Option[DataType]): Unit =
      that.setDatatype(UMLPackageScalaSupport._umlBuilder.ref(value))
    def isOrdered: Boolean = that.isOrdered
    def isQuery: Boolean = that.isQuery
    def isQuery_=(value: Boolean): Unit = that.setIsQuery(value)
    def isUnique: Boolean = that.isUnique
    def lower: Int = that.getLower
    def postcondition: EList[Constraint] = that.getPostconditions
    def precondition: EList[Constraint] = that.getPreconditions
    def redefinedOperation: EList[Operation] = that.getRedefinedOperations
    def type_ : Type = that.getType
    def upper: Int = that.getUpper
  }
}

object OperationScalaSupport extends OperationScalaSupport

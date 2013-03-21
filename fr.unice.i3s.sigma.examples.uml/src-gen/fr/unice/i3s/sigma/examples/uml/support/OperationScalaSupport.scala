package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Type;

trait OperationScalaSupport {
  implicit class OperationScalaSupport(that: Operation) {
    def interface: Interface = that.getInterface
    def interface_=(value: Interface): Unit = that.setInterface(value)
    def bodyCondition: Constraint = that.getBodyCondition
    def bodyCondition_=(value: Constraint): Unit = that.setBodyCondition(value)
    def `class`: org.eclipse.uml2.uml.Class = that.getClass_
    def class_=(value: org.eclipse.uml2.uml.Class): Unit = that.setClass_(value)
    def datatype: DataType = that.getDatatype
    def datatype_=(value: DataType): Unit = that.setDatatype(value)
    def isOrdered: Boolean = that.isOrdered
    def isQuery: Boolean = that.isQuery
    def isQuery_=(value: Boolean): Unit = that.setIsQuery(value)
    def isUnique: Boolean = that.isUnique
    def lower: Int = that.getLower
    def postcondition: EList[Constraint] = that.getPostconditions
    def precondition: EList[Constraint] = that.getPreconditions
    def redefinedOperation: EList[Operation] = that.getRedefinedOperations
    def `type`: Type = that.getType
    def upper: Int = that.getUpper
  }
}

object OperationScalaSupport extends OperationScalaSupport

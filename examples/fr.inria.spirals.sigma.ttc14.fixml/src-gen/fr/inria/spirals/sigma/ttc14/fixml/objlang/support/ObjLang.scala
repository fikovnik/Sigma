package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Field;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Member;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral;

import fr.unice.i3s.sigma.m2m.Transformable;

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;
import fr.unice.i3s.sigma.support.SigmaEcorePackage;

import org.eclipse.emf.common.util.EList;

import scala.Option;


trait ObjLang
  extends EMFScalaSupport {
    
    implicit class NamedElement2Sigma(that: NamedElement) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
    }
    
    implicit class Class2Sigma(that: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class) {
      def superclass: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class = that.getSuperclass
      def superclass_=(value: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class): Unit = that.setSuperclass(value)
      def superclass_=(value: Transformable): Unit = value.transform[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class].foreach(that.setSuperclass(_))
      def superclass_=(value: ⇒ Option[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class]): Unit =
        that.setSuperclass(ObjLang._objlangBuilder.ref(value))
      def members: EList[Member] = that.getMembers
      def constructors: EList[Constructor] = that.getConstructors
      def attributes: EList[Attribute] = that.getAttributes
      def references: EList[Reference] = that.getReferences
    }
    
    implicit class Member2Sigma(that: Member) {
      def parent: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class = that.getParent
      def parent_=(value: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class): Unit = that.setParent(value)
      def parent_=(value: Transformable): Unit = value.transform[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class].foreach(that.setParent(_))
      def parent_=(value: ⇒ Option[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class]): Unit =
        that.setParent(ObjLang._objlangBuilder.ref(value))
    }
    
    implicit class Constructor2Sigma(that: Constructor) {
      def parameters: EList[Parameter] = that.getParameters
      def initialisations: EList[FieldInitialisiation] = that.getInitialisations
    }
    
    
    implicit class ReferenceParameter2Sigma(that: ReferenceParameter) {
      def type_ : fr.inria.spirals.sigma.ttc14.fixml.objlang.Class = that.getType
      def type__=(value: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class): Unit = that.setType(value)
      def type__=(value: Transformable): Unit = value.transform[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class].foreach(that.setType(_))
      def type__=(value: ⇒ Option[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class]): Unit =
        that.setType(ObjLang._objlangBuilder.ref(value))
    }
    
    implicit class PrimitiveParameter2Sigma(that: PrimitiveParameter) {
      def type_ : PrimitiveType = that.getType
      def type__=(value: PrimitiveType): Unit = that.setType(value)
    }
    
    implicit class FieldInitialisiation2Sigma(that: FieldInitialisiation) {
      def field: Field = that.getField
      def field_=(value: Field): Unit = that.setField(value)
      def field_=(value: Transformable): Unit = value.transform[Field].foreach(that.setField(_))
      def field_=(value: ⇒ Option[Field]): Unit =
        that.setField(ObjLang._objlangBuilder.ref(value))
      def expression: Expression = that.getExpression
      def expression_=(value: Expression): Unit = that.setExpression(value)
      def expression_=(value: Transformable): Unit = value.transform[Expression].foreach(that.setExpression(_))
    }
    
    implicit class Field2Sigma(that: Field) {
      def initialValue: Option[Expression] = Option(that.getInitialValue)
      def initialValue_=(value: Expression): Unit = that.setInitialValue(value)
      def initialValue_=(value: Transformable): Unit = value.transform[Expression].foreach(that.setInitialValue(_))
    }
    
    implicit class Reference2Sigma(that: Reference) {
      def type_ : fr.inria.spirals.sigma.ttc14.fixml.objlang.Class = that.getType
      def type__=(value: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class): Unit = that.setType(value)
      def type__=(value: Transformable): Unit = value.transform[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class].foreach(that.setType(_))
      def type__=(value: ⇒ Option[fr.inria.spirals.sigma.ttc14.fixml.objlang.Class]): Unit =
        that.setType(ObjLang._objlangBuilder.ref(value))
    }
    
    implicit class Attribute2Sigma(that: Attribute) {
      def type_ : PrimitiveType = that.getType
      def type__=(value: PrimitiveType): Unit = that.setType(value)
    }
    
    
    implicit class StringLiteral2Sigma(that: StringLiteral) {
      def value: String = that.getValue
      def value_=(value: String): Unit = that.setValue(value)
    }
    
    implicit class ConstructorCall2Sigma(that: ConstructorCall) {
      def constructor: Constructor = that.getConstructor
      def constructor_=(value: Constructor): Unit = that.setConstructor(value)
      def constructor_=(value: Transformable): Unit = value.transform[Constructor].foreach(that.setConstructor(_))
      def constructor_=(value: ⇒ Option[Constructor]): Unit =
        that.setConstructor(ObjLang._objlangBuilder.ref(value))
      def arguments: EList[Expression] = that.getArguments
    }
    
    implicit class ParameterAccess2Sigma(that: ParameterAccess) {
      def parameter: Parameter = that.getParameter
      def parameter_=(value: Parameter): Unit = that.setParameter(value)
      def parameter_=(value: Transformable): Unit = value.transform[Parameter].foreach(that.setParameter(_))
      def parameter_=(value: ⇒ Option[Parameter]): Unit =
        that.setParameter(ObjLang._objlangBuilder.ref(value))
    }
    
    
    
    object _objlang extends SigmaEcorePackage[ObjLangPackage] with
      NamedElementScalaSupport with
      ClassScalaSupport with
      MemberScalaSupport with
      ConstructorScalaSupport with
      ParameterScalaSupport with
      ReferenceParameterScalaSupport with
      PrimitiveParameterScalaSupport with
      FieldInitialisiationScalaSupport with
      FieldScalaSupport with
      ReferenceScalaSupport with
      AttributeScalaSupport with
      ExpressionScalaSupport with
      StringLiteralScalaSupport with
      ConstructorCallScalaSupport with
      ParameterAccessScalaSupport with
      NullLiteralScalaSupport {
      
      val ePackage = ObjLangPackage.eINSTANCE
    }
  }

object ObjLang extends ObjLang {
  private[this] val ePackage = ObjLangPackage.eINSTANCE
  
  protected[support] val _objlangBuilder = new EMFBuilder(ePackage)
}

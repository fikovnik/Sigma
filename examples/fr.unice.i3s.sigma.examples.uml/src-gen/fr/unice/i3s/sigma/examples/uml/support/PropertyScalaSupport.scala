package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Deployment;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait PropertyScalaSupport extends EMFScalaSupport {
  type Property = org.eclipse.uml2.uml.Property
  
  protected implicit val _propertyProxyBuilder = new EMFProxyBuilder[Property](UMLPackageScalaSupport._umlBuilder)
  
  object Property {
    def apply(): Property = {
      UMLPackageScalaSupport._umlBuilder.create[Property]
    }
  }
  
  implicit class PropertyScalaSupport(that: Property) {
    def interface: Interface = that.getInterface
    def interface_=(value: Interface): Unit = that.setInterface(value)
    def interface_=(value: ⇒ Option[Interface]): Unit =
      that.setInterface(UMLPackageScalaSupport._umlBuilder.ref(value))
    def datatype: DataType = that.getDatatype
    def datatype_=(value: DataType): Unit = that.setDatatype(value)
    def datatype_=(value: ⇒ Option[DataType]): Unit =
      that.setDatatype(UMLPackageScalaSupport._umlBuilder.ref(value))
    def aggregation: AggregationKind = that.getAggregation
    def aggregation_=(value: AggregationKind): Unit = that.setAggregation(value)
    def associationEnd: Property = that.getAssociationEnd
    def associationEnd_=(value: Property): Unit = that.setAssociationEnd(value)
    def associationEnd_=(value: ⇒ Option[Property]): Unit =
      that.setAssociationEnd(UMLPackageScalaSupport._umlBuilder.ref(value))
    def qualifier: EList[Property] = that.getQualifiers
    def class_ : org.eclipse.uml2.uml.Class = that.getClass_
    def default: String = that.getDefault
    def default_=(value: String): Unit = that.setDefault(value)
    def defaultValue: ValueSpecification = that.getDefaultValue
    def defaultValue_=(value: ValueSpecification): Unit = that.setDefaultValue(value)
    def isComposite: Boolean = that.isComposite
    def isComposite_=(value: Boolean): Unit = that.setIsComposite(value)
    def isDerived: Boolean = that.isDerived
    def isDerived_=(value: Boolean): Unit = that.setIsDerived(value)
    def isDerivedUnion: Boolean = that.isDerivedUnion
    def isDerivedUnion_=(value: Boolean): Unit = that.setIsDerivedUnion(value)
    def isID: Boolean = that.isID
    def isID_=(value: Boolean): Unit = that.setIsID(value)
    def opposite: Property = that.getOpposite
    def opposite_=(value: Property): Unit = that.setOpposite(value)
    def opposite_=(value: ⇒ Option[Property]): Unit =
      that.setOpposite(UMLPackageScalaSupport._umlBuilder.ref(value))
    def owningAssociation: Association = that.getOwningAssociation
    def owningAssociation_=(value: Association): Unit = that.setOwningAssociation(value)
    def owningAssociation_=(value: ⇒ Option[Association]): Unit =
      that.setOwningAssociation(UMLPackageScalaSupport._umlBuilder.ref(value))
    def redefinedProperty: EList[Property] = that.getRedefinedProperties
    def subsettedProperty: EList[Property] = that.getSubsettedProperties
    def association: Association = that.getAssociation
    def association_=(value: Association): Unit = that.setAssociation(value)
    def association_=(value: ⇒ Option[Association]): Unit =
      that.setAssociation(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object PropertyScalaSupport extends PropertyScalaSupport

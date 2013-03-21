package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ValueSpecification;

trait PropertyScalaSupport {
  implicit class PropertyScalaSupport(that: Property) {
    def interface: Interface = that.getInterface
    def interface_=(value: Interface): Unit = that.setInterface(value)
    def datatype: DataType = that.getDatatype
    def datatype_=(value: DataType): Unit = that.setDatatype(value)
    def aggregation: AggregationKind = that.getAggregation
    def aggregation_=(value: AggregationKind): Unit = that.setAggregation(value)
    def associationEnd: Property = that.getAssociationEnd
    def associationEnd_=(value: Property): Unit = that.setAssociationEnd(value)
    def qualifier: EList[Property] = that.getQualifiers
    def `class`: org.eclipse.uml2.uml.Class = that.getClass_
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
    def owningAssociation: Association = that.getOwningAssociation
    def owningAssociation_=(value: Association): Unit = that.setOwningAssociation(value)
    def redefinedProperty: EList[Property] = that.getRedefinedProperties
    def subsettedProperty: EList[Property] = that.getSubsettedProperties
    def association: Association = that.getAssociation
    def association_=(value: Association): Unit = that.setAssociation(value)
  }
}

object PropertyScalaSupport extends PropertyScalaSupport

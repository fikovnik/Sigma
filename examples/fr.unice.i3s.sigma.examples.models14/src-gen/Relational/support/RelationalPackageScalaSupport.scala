package Relational.support

import Relational.Attribute;
import Relational.AttributeType;
import Relational.CandidateKey;
import Relational.Constraint;
import Relational.Domain;
import Relational.EnumeratedLiteral;
import Relational.EnumerationType;
import Relational.ForeignKey;
import Relational.RelationalPackage;
import Relational.Schema;
import Relational.Table;

import fr.unice.i3s.sigma.m2m.Transformable;

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;
import fr.unice.i3s.sigma.support.SigmaEcorePackage;

import org.eclipse.emf.common.util.EList;

import scala.Option;


trait RelationalPackageScalaSupport
  extends EMFScalaSupport {
    
    implicit class Schema2Sigma(that: Schema) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
      def tables: EList[Table] = that.getTables
      def domains: EList[Domain] = that.getDomains
      def constraints: EList[Constraint] = that.getConstraints
    }
    
    implicit class Table2Sigma(that: Table) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
      def primaryKey: CandidateKey = that.getPrimaryKey
      def primaryKey_=(value: CandidateKey): Unit = that.setPrimaryKey(value)
      def primaryKey_=(value: Transformable): Unit = value.transform[CandidateKey].foreach(that.setPrimaryKey(_))
      def primaryKey_=(value: ⇒ Option[CandidateKey]): Unit =
        that.setPrimaryKey(RelationalPackageScalaSupport._relationalBuilder.ref(value))
      def candidateKey: EList[CandidateKey] = that.getCandidateKey
      def attributes: EList[Attribute] = that.getAttributes
      def foreignKey: EList[ForeignKey] = that.getForeignKey
    }
    
    implicit class Attribute2Sigma(that: Attribute) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
      def type_ : AttributeType = that.getType
      def type__=(value: AttributeType): Unit = that.setType(value)
      def nullable: Boolean = that.isNullable
      def nullable_=(value: Boolean): Unit = that.setNullable(value)
      def domain: Domain = that.getDomain
      def domain_=(value: Domain): Unit = that.setDomain(value)
      def domain_=(value: Transformable): Unit = value.transform[Domain].foreach(that.setDomain(_))
      def domain_=(value: ⇒ Option[Domain]): Unit =
        that.setDomain(RelationalPackageScalaSupport._relationalBuilder.ref(value))
      def multiplicity: Int = that.getMultiplicity
      def multiplicity_=(value: Int): Unit = that.setMultiplicity(value)
    }
    
    implicit class Domain2Sigma(that: Domain) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
      def constraints: EList[Constraint] = that.getConstraints
    }
    
    implicit class CandidateKey2Sigma(that: CandidateKey) {
      def attributes: EList[Attribute] = that.getAttributes
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
    }
    
    implicit class ForeignKey2Sigma(that: ForeignKey) {
      def referencedTable: Table = that.getReferencedTable
      def referencedTable_=(value: Table): Unit = that.setReferencedTable(value)
      def referencedTable_=(value: Transformable): Unit = value.transform[Table].foreach(that.setReferencedTable(_))
      def referencedTable_=(value: ⇒ Option[Table]): Unit =
        that.setReferencedTable(RelationalPackageScalaSupport._relationalBuilder.ref(value))
    }
    
    
    implicit class EnumerationType2Sigma(that: EnumerationType) {
      def literals: EList[EnumeratedLiteral] = that.getLiterals
    }
    
    implicit class EnumeratedLiteral2Sigma(that: EnumeratedLiteral) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
    }
    
    implicit class Constraint2Sigma(that: Constraint) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
      def description: String = that.getDescription
      def description_=(value: String): Unit = that.setDescription(value)
    }
    
    
    object _Relational extends SigmaEcorePackage[RelationalPackage] with
      SchemaScalaSupport with
      TableScalaSupport with
      AttributeScalaSupport with
      DomainScalaSupport with
      CandidateKeyScalaSupport with
      ForeignKeyScalaSupport with
      PrimitiveTypeScalaSupport with
      EnumerationTypeScalaSupport with
      EnumeratedLiteralScalaSupport with
      ConstraintScalaSupport {
      
      val ePackage = RelationalPackage.eINSTANCE
    }
  }

object RelationalPackageScalaSupport extends RelationalPackageScalaSupport {
  private[this] val ePackage = RelationalPackage.eINSTANCE
  
  protected[support] val _relationalBuilder = new EMFBuilder(ePackage)
}

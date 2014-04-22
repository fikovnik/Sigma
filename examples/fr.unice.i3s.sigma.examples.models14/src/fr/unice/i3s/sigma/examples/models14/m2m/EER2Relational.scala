package fr.unice.i3s.sigma.examples.models14.m2m

import java.io.File

import com.typesafe.scalalogging.log4j.Logging

import EER.support.EERPackageScalaSupport
import Relational.support.RelationalPackageScalaSupport
import fr.unice.i3s.sigma.m2m.M2MT
import fr.unice.i3s.sigma.util.EMFUtils

class EER2Relational extends M2MT with EERPackageScalaSupport with RelationalPackageScalaSupport with Logging {

  sourceMetaModels = _EER
  targetMetaModels = _Relational

  def ruleProject2Schema(p: _EER.Project, s: _Relational.Schema) {
    logger info s"Processing project ${p.name}"

    // The schema is named as the EER project
    s.name = p.name;
    // We add as tables the results of transforming all the entities and weak entities
    s.tables ++= ~p.nodes.collect { case e: _EER.Entity ⇒ e }
    // We add as domains the results of transforming all domains
    s.domains ++= ~p.domains
  }

  def ruleEntity2Table(e: _EER.Entity, t: _Relational.Table) {
    logger info s"Processing entity ${e.name}"

    def singleAttributes(from: _EER.Attribute): Seq[_EER.SingleAttribute] = from match {
      case sa: _EER.SingleAttribute ⇒ Seq(sa)
      case ca: _EER.CompositeAttribute ⇒ ca.singlesAttributes flatMap singleAttributes
    }

    t.name = e.name
    t.candidateKey ++= ~e.candidateKey
    t.primaryKey = ~e.primaryKey
    t.attributes ++= ~(e.attributes flatMap singleAttributes)
  }

  //  def ruleWeakEntity2Table(e: _EER.WeakEntity, t: _Relational.Table) {
  //    logger info s"Processing weak entity ${e.name}"
  //
  //    t.name = e.name
  //    t.candidateKey ++= ~e.candidateKey
  //    t.primaryKey = ~e.primaryKey
  //  }

  def ruleSingleAttribute2Attribute(sa: _EER.SingleAttribute, a: _Relational.Attribute) {
    logger info s"Processing single attribute ${sa.name}"

    a.name = sa.name
    a.domain = ~sa.domain
    a.nullable = sa.nullable
    a.multiplicity = sa.multiplicity
    a.type_ = if (sa.derivate) Relational.AttributeType.DERIVATE else Relational.AttributeType.SIMPLE
  }

  def ruleCandidateKey2CandidateKey(e: _EER.CandidateKey, r: _Relational.CandidateKey) {
    logger info s"Processing candidate key ${e.name}"

    //    r.name = e.name
    r.attributes ++= ~e.attributes
  }

  def rulePrimitiveType2PrimitiveType(p1: _EER.PrimitiveType, p2: _Relational.PrimitiveType) {
    logger info s"Processing primitive type ${p1.name}"

    p2.name = p1.name
  }

  def ruleEnumerationType2EnumerationType(e1: _EER.EnumerationType, e2: _Relational.EnumerationType) {
    logger info s"Processing enumeration type ${e1.name}"

    e2.name = e1.name
    e2.literals ++= ~e1.literals
  }

  def ruleEnumeratedLiteral2EnumeratedLiteral(l1: _EER.EnumeratedLiteral, l2: _Relational.EnumeratedLiteral) {
    logger info s"Processing enumeration literal ${l1.name}"

    l2.name = l1.name
  }

}

object EER2RelationalTest extends App with EERPackageScalaSupport {

  EMFUtils.IO.registerDefaultFactories
  EER.EERPackage.eINSTANCE.eClass
  Relational.RelationalPackage.eINSTANCE.eClass

  val project = EMFUtils.IO.loadFromFile[_EER.Project](new File("tests/default.xmi"), true)

  val m2m = new EER2Relational()
  val (pri, sec) = m2m.execute(project)

  pri foreach (_.sDump())

}
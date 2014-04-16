package fr.unice.i3s.sigma.examples.simpleoo.m2m

import fr.unice.i3s.sigma.m2m.M2MT
import fr.unice.i3s.sigma.m2m.annotations.Abstract
import fr.unice.i3s.sigma.examples.simpleoo.support.SimpleooPackageScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport

class Ecore2SimpleOO extends M2MT with SimpleooPackageScalaSupport with EcorePackageScalaSupport {

  sourceMetaModels = _ecore.ePackage
  targetMetaModels = _simpleoo.ePackage

  @Abstract
  def ruleENamedElement2ModelElement(s: _ecore.ENamedElement, t: _simpleoo.ModelElement) {
    t.name = s.name
    //    t.ownedStereotypes ++= find stereotypes
  }

  def ruleEPackage2Package(s: _ecore.EPackage, t: _simpleoo.Package) {
    t.ownedElements ++= ~s.eClassifiers
  }

  def ruleEClass2Class(s: _ecore.EClass, t: _simpleoo.Class) {
    t.superClass = ~s.eSuperTypes.headOption
    t.abstract_ = s.abstract_
    t.features ++= ~s.eStructuralFeatures
    t.features ++= ~s.eOperations
  }

  def ruleEDataType2PrimitiveType(s: _ecore.EDataType, t: _simpleoo.PrimitiveType) {}

  @Abstract
  def ruleEStructuralFeature2Property(s: _ecore.EStructuralFeature, t: _simpleoo.Property) {
    t.type_ = ~s.eType
    t.multi = s.many
  }

  def ruleEAttribute2Property(s: _ecore.EAttribute, t: _simpleoo.Property) {}
  def ruleEReference2Property(s: _ecore.EReference, t: _simpleoo.Property) {}

  def ruleEOperation2Operation(s: _ecore.EOperation, t: _simpleoo.Operation) {
    t.returnType = ~s.eGenericType
  }
}

object Ecore2SimpleOO extends App with EcorePackageScalaSupport {

  val m2m = new Ecore2SimpleOO

  val (pri, sec) = m2m.execute(_ecore.ePackage)

  println(pri)
  pri.head.dump()
  println(sec)

}
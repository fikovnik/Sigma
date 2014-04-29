package fr.unice.i3s.sigma.examples.simpleoo.m2m

import fr.unice.i3s.sigma.m2m._
import fr.unice.i3s.sigma.m2m.emf._
import fr.unice.i3s.sigma.m2m.annotations.Abstract
import fr.unice.i3s.sigma.examples.simpleoo.support.SimpleOO
import fr.unice.i3s.sigma.examples.simpleoo.support.SimpleOO._simpleoo._
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore._
import org.eclipse.emf.ecore.EStructuralFeature

class Ecore2SimpleOO extends M2MT with SimpleOO with EcorePackageScalaSupport {

  sourceMetaModels = EMFModel(_ecore)
  targetMetaModels = EMFModel(_simpleoo)
  
  @Abstract
  def ruleENamedElement2ModelElement(s: _ecore.ENamedElement, t: _simpleoo.ModelElement) {
    t.name = s.name
  }

  def ruleEPackage2Package(s: _ecore.EPackage, t: _simpleoo.Package) {
    t.ownedElements ++= s.eClassifiers.sTarget[Class]
  }

  def ruleEClass2Class(s: _ecore.EClass, t: _simpleoo.Class) {
    if (s.eSuperTypes.nonEmpty) t.superClass = s.eSuperTypes(0).sTarget[Class]
    
    t.abstract_ = s.abstract_
    t.features ++= s.eStructuralFeatures.sTarget[Feature]
    t.features ++= s.eOperations.sTarget[Feature]
  }

  def ruleEDataType2PrimitiveType(s: _ecore.EDataType, t: _simpleoo.PrimitiveType) {}

  @Abstract
  def ruleEStructuralFeature2Property(s: _ecore.EStructuralFeature, t: _simpleoo.Property) {
    t.type_ = s.eType.sTarget[Class]
    t.multi = s.many
  }

  def ruleEAttribute2Property(s: _ecore.EAttribute, t: _simpleoo.Property) {}
  def ruleEReference2Property(s: _ecore.EReference, t: _simpleoo.Property) {}

  def ruleEOperation2Operation(s: _ecore.EOperation, t: _simpleoo.Operation) {
    t.returnType = s.eGenericType.sTarget[Class]
  }
}

object Ecore2SimpleOO extends App with EcorePackageScalaSupport {

  val m2m = new Ecore2SimpleOO

  val targets = m2m.transform(_ecore.ePackage)

   targets.head.asInstanceOf[EObject].sDump()
}
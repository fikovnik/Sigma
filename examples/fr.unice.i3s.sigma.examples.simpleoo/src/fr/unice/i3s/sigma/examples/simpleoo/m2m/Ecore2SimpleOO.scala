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
    t.ownedElements ++= ~ s.eClassifiers
  }


  
}
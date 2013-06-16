package uml.support

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import uml.UMLPackage;

trait UmlPackageScalaSupport
  extends ModelElementScalaSupport with
  StereotypeScalaSupport with
  PackageScalaSupport with
  ClassifierScalaSupport with
  ClassScalaSupport with
  PrimitiveTypeScalaSupport with
  FeatureScalaSupport with
  PropertyScalaSupport with
  OperationScalaSupport with
  EMFScalaSupport

object UmlPackageScalaSupport extends UmlPackageScalaSupport {
  private[this] val pkg = UMLPackage.eINSTANCE
  
  val builder = new EMFBuilder(pkg)
}

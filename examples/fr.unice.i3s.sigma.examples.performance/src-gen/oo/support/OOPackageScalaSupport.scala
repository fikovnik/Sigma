package oo.support

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.OOPackage;


trait OOPackageScalaSupport
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

object OOPackageScalaSupport extends OOPackageScalaSupport {
  private[this] val pkg = OOPackage.eINSTANCE
  
  protected[support] val _ooBuilder = new EMFBuilder(pkg)
}

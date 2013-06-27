package db.support

import db.DBPackage;

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait DBPackageScalaSupport
  extends TableScalaSupport with
  ColumnScalaSupport with
  EMFScalaSupport

object DBPackageScalaSupport extends DBPackageScalaSupport {
  private[this] val pkg = DBPackage.eINSTANCE
  
  protected[support] val _dbBuilder = new EMFBuilder(pkg)
}

package relational.support

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import relational.RelationalPackage;

trait RelationalPackageScalaSupport
  extends TableScalaSupport with
  ColumnScalaSupport with
  EMFScalaSupport

object RelationalPackageScalaSupport extends RelationalPackageScalaSupport {
  private[this] val pkg = RelationalPackage.eINSTANCE
  
  val builder = new EMFBuilder(pkg)
}

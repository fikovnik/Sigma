package library.support

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import library.LibraryPackage;

trait LibraryPackageScalaSupport
  extends LibraryScalaSupport with
  BookScalaSupport with
  AuthorScalaSupport with
  EMFScalaSupport

object LibraryPackageScalaSupport extends LibraryPackageScalaSupport {
  private[this] val pkg = LibraryPackage.eINSTANCE
  
  val builder = new EMFBuilder(pkg)
}

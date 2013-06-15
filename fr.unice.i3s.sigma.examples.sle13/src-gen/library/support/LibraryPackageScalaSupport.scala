package library.support

import library.LibraryPackage;

trait LibraryPackageScalaSupport
  extends LibraryScalaSupport with
  BookScalaSupport with
  AuthorScalaSupport with
  fr.unice.i3s.sigma.support.EMFScalaSupport

object LibraryPackageScalaSupport extends LibraryPackageScalaSupport {
  private[this] val pkg = LibraryPackage.eINSTANCE
}

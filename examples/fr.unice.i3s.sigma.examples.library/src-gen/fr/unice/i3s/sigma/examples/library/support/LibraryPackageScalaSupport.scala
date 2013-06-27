package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.LibraryPackage;

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait LibraryPackageScalaSupport
  extends LibraryScalaSupport with
  CategoryScalaSupport with
  AuthorScalaSupport with
  BookScalaSupport with
  MemberScalaSupport with
  LoanScalaSupport with
  EMFScalaSupport

object LibraryPackageScalaSupport extends LibraryPackageScalaSupport {
  private[this] val pkg = LibraryPackage.eINSTANCE
  
  protected[support] val _libraryBuilder = new EMFBuilder(pkg)
  
  val Date = pkg.getDate
}

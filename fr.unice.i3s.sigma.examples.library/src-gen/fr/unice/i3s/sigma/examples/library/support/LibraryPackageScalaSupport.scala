package fr.unice.i3s.sigma.examples.library.support


import fr.unice.i3s.sigma.examples.library.LibraryPackage;

trait LibraryPackageScalaSupport
  extends LibraryScalaSupport with
  BookScalaSupport with
  MemberScalaSupport with
  LoanScalaSupport

object LibraryPackageScalaSupport extends LibraryPackageScalaSupport {
  
  private[this] val pkg = LibraryPackage.eINSTANCE
  
  val Date = pkg.getDate
}
package fr.unice.i3s.sigma.examples.library.scala

trait LibraryPackageScalaSupport
  extends LibraryScalaSupport
  with BookScalaSupport
  with MemberScalaSupport
  with LoanScalaSupport

object LibraryPackageScalaSupport extends LibraryPackageScalaSupport

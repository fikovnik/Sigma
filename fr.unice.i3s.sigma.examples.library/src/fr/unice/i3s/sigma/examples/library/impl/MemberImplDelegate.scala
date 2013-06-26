package fr.unice.i3s.sigma.examples.library.impl


import fr.unice.i3s.sigma.examples.library.support.LibraryPackageScalaSupport;
import fr.unice.i3s.sigma.examples.library.Member


class MemberImplDelegate extends MemberImpl with MemberDelegate

trait MemberDelegate extends Member with LibraryPackageScalaSupport {
  
  override def getLoans = this.library.loans filter (_.member == this)
  override def getBooks = this.loans map (_.book)
  
}

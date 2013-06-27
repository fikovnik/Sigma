package fr.unice.i3s.sigma.examples.library.impl

import fr.unice.i3s.sigma.examples.library.support.LibraryPackageScalaSupport;
import fr.unice.i3s.sigma.examples.library.Book


class BookImplDelegate extends BookImpl with BookDelegate

trait BookDelegate extends Book with LibraryPackageScalaSupport {

  override def isAvailable = this.loans.size < this.copies
  override def getLoans = this.library.loans filter (_.book == this)
  
}

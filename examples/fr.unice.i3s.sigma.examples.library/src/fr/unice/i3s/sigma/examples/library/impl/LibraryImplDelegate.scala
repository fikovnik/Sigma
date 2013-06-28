package fr.unice.i3s.sigma.examples.library.impl


import fr.unice.i3s.sigma.examples.library.support.LibraryPackageScalaSupport;
import fr.unice.i3s.sigma.examples.library.Library


class LibraryImplDelegate extends LibraryImpl with LibraryDelegate

trait LibraryDelegate extends Library with LibraryPackageScalaSupport {

  override def getBookByName(name: String) = {
    require(name != null)
    
    this.books.find (_.name == name).orNull
  }
  
}

package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Author;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AuthorScalaSupport extends EMFScalaSupport {
  type Author = fr.unice.i3s.sigma.examples.library.Author
  
  protected implicit val _authorProxyBuilder = new EMFProxyBuilder[Author](LibraryPackageScalaSupport._libraryBuilder)
  
  object Author {
    def apply(name: String = null): Author = {
      val instance = LibraryPackageScalaSupport._libraryBuilder.create[Author]
      
      if (name != null) instance.setName(name)
      
      instance
    }
  }
  
  implicit class AuthorScalaSupport(that: Author) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object AuthorScalaSupport extends AuthorScalaSupport

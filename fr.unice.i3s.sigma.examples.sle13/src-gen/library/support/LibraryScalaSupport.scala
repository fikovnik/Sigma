package library.support

import library.Author;
import library.Book;
import library.Library;

import org.eclipse.emf.common.util.EList;

trait LibraryScalaSupport {
  type Library = library.Library
  
  object Library {
    def apply(catalog: EList[Book] = null, authors: EList[Author] = null): Library = {
      val instance = library.LibraryFactory.eINSTANCE.createLibrary
      
      if (catalog != null) instance.getCatalog.addAll(catalog)
      if (authors != null) instance.getAuthors.addAll(authors)
      
      instance
    }
    
    def unapply(that: Library): Option[(EList[Book],EList[Author])] =
      Some((that.getCatalog,that.getAuthors))
  }
  
  implicit class LibraryScalaSupport(that: Library) {
    def catalog: EList[Book] = that.getCatalog
    def authors: EList[Author] = that.getAuthors
  }
}

object LibraryScalaSupport extends LibraryScalaSupport

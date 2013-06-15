package null.library.support


import library.Author;
import library.Book;
import library.Library;

import org.eclipse.emf.common.util.EList;

trait LibraryScalaSupport {
  implicit class LibraryScalaSupport(that: Library) {
    def catalog: EList[Book] = that.getCatalog
    def authors: EList[Author] = that.getAuthors
  }
}


object LibraryScalaSupport extends LibraryScalaSupport


package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Author;
import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Category;
import fr.unice.i3s.sigma.examples.library.Library;
import fr.unice.i3s.sigma.examples.library.Loan;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import scala.Option;

trait BookScalaSupport extends EMFScalaSupport {
  type Book = fr.unice.i3s.sigma.examples.library.Book
  
  protected implicit val _bookProxyBuilder = new EMFProxyBuilder[Book](LibraryPackageScalaSupport._libraryBuilder)
  
  object Book {
    def apply(name: String = null, copies: Int = 0): Book = {
      val instance = LibraryPackageScalaSupport._libraryBuilder.create[Book]
      
      if (name != null) instance.setName(name)
      if (copies != 0) instance.setCopies(copies)
      
      instance
    }
    
    def unapply(that: Book): Option[(String,Author,Int,Library,EList[Loan],EList[Category])] =
      Some((that.getName,that.getAuthor,that.getCopies,that.getLibrary,that.getLoans,that.getCategories))
  }
  
  implicit class BookScalaSupport(that: Book) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def author: Author = that.getAuthor
    def author_=(value: Author): Unit = that.setAuthor(value)
    def author_=(value: ⇒ Option[Author]): Unit =
      that.setAuthor(LibraryPackageScalaSupport._libraryBuilder.ref(value))
    def copies: Int = that.getCopies
    def copies_=(value: Int): Unit = that.setCopies(value)
    def library: Library = that.getLibrary
    def library_=(value: Library): Unit = that.setLibrary(value)
    def library_=(value: ⇒ Option[Library]): Unit =
      that.setLibrary(LibraryPackageScalaSupport._libraryBuilder.ref(value))
    def loans: EList[Loan] = that.getLoans
    def categories: EList[Category] = that.getCategories
  }
}

object BookScalaSupport extends BookScalaSupport

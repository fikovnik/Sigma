package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Author;
import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Category;
import fr.unice.i3s.sigma.examples.library.Library;
import fr.unice.i3s.sigma.examples.library.Loan;
import fr.unice.i3s.sigma.examples.library.Member;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait LibraryScalaSupport extends EMFScalaSupport {
  type Library = fr.unice.i3s.sigma.examples.library.Library
  
  protected implicit val _libraryProxyBuilder = new EMFProxyBuilder[Library](LibraryPackageScalaSupport._libraryBuilder)
  
  object Library {
    def apply(name: String = null): Library = {
      val instance = LibraryPackageScalaSupport._libraryBuilder.create[Library]
      
      if (name != null) instance.setName(name)
      
      instance
    }
    
    def unapply(that: Library): Option[(String,EList[Book],EList[Loan],EList[Member],EList[Author],EList[Category])] =
      Some((that.getName,that.getBooks,that.getLoans,that.getMembers,that.getAuthors,that.getCategories))
  }
  
  implicit class LibraryScalaSupport(that: Library) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def books: EList[Book] = that.getBooks
    def loans: EList[Loan] = that.getLoans
    def members: EList[Member] = that.getMembers
    def authors: EList[Author] = that.getAuthors
    def categories: EList[Category] = that.getCategories
  }
}

object LibraryScalaSupport extends LibraryScalaSupport

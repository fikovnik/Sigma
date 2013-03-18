package fr.unice.i3s.sigma.examples.library.scala

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Library;
import fr.unice.i3s.sigma.examples.library.Loan;
import fr.unice.i3s.sigma.examples.library.Member;

import org.eclipse.emf.common.util.EList;

trait LibraryScalaSupport {
  implicit class LibraryScalaSupport(that: Library) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def books: EList[Book] = that.getBooks
    def loans: EList[Loan] = that.getLoans
    def members: EList[Member] = that.getMembers
  }
}

object LibraryScalaSupport extends LibraryScalaSupport

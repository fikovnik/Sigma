package fr.unice.i3s.sigma.examples.library.scala

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Library;
import fr.unice.i3s.sigma.examples.library.Loan;

import org.eclipse.emf.common.util.EList;

trait BookScalaSupport {
  implicit class BookScalaSupport(that: Book) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def copies: Int = that.getCopies
    def copies_=(value: Int): Unit = that.setCopies(value)
    def library: Library = that.getLibrary
    def library_=(value: Library): Unit = that.setLibrary(value)
    def loans: EList[Loan] = that.getLoans
  }
}

object BookScalaSupport extends BookScalaSupport

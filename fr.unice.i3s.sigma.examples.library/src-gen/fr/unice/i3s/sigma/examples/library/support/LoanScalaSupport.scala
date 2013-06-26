package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Loan;
import fr.unice.i3s.sigma.examples.library.Member;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import java.util.Date;

import scala.Option;

trait LoanScalaSupport extends EMFScalaSupport {
  type Loan = fr.unice.i3s.sigma.examples.library.Loan
  
  protected implicit val _loanProxyBuilder = new EMFProxyBuilder[Loan](LibraryPackageScalaSupport._libraryBuilder)
  
  object Loan {
    def apply(date: Date = null): Loan = {
      val instance = LibraryPackageScalaSupport._libraryBuilder.create[Loan]
      
      if (date != null) instance.setDate(date)
      
      instance
    }
    
    def unapply(that: Loan): Option[(Book,Member,Date)] =
      Some((that.getBook,that.getMember,that.getDate))
  }
  
  implicit class LoanScalaSupport(that: Loan) {
    def book: Book = that.getBook
    def book_=(value: Book): Unit = that.setBook(value)
    def book_=(value: ⇒ Option[Book]): Unit =
      that.setBook(LibraryPackageScalaSupport._libraryBuilder.ref(value))
    def member: Member = that.getMember
    def member_=(value: Member): Unit = that.setMember(value)
    def member_=(value: ⇒ Option[Member]): Unit =
      that.setMember(LibraryPackageScalaSupport._libraryBuilder.ref(value))
    def date: Option[Date] = Option(that.getDate)
    def date_=(value: Date): Unit = that.setDate(value)
  }
}

object LoanScalaSupport extends LoanScalaSupport

package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Loan;
import fr.unice.i3s.sigma.examples.library.Member;

import java.util.Date;

trait LoanScalaSupport {
  implicit class LoanScalaSupport(that: Loan) {
    def book: Book = that.getBook
    def book_=(value: Book): Unit = that.setBook(value)
    def member: Member = that.getMember
    def member_=(value: Member): Unit = that.setMember(value)
    def date: Date = that.getDate
    def date_=(value: Date): Unit = that.setDate(value)
  }
}

object LoanScalaSupport extends LoanScalaSupport

package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Library;
import fr.unice.i3s.sigma.examples.library.Loan;
import fr.unice.i3s.sigma.examples.library.Member;
import fr.unice.i3s.sigma.examples.library.MembershipType;

import org.eclipse.emf.common.util.EList;

trait MemberScalaSupport {
  implicit class MemberScalaSupport(that: Member) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def library: Library = that.getLibrary
    def library_=(value: Library): Unit = that.setLibrary(value)
    def loans: EList[Loan] = that.getLoans
    def books: EList[Book] = that.getBooks
    def membershipType: MembershipType = that.getMembershipType
    def membershipType_=(value: MembershipType): Unit = that.setMembershipType(value)
  }
}

object MemberScalaSupport extends MemberScalaSupport

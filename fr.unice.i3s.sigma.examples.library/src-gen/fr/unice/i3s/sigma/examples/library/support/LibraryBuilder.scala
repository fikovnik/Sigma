package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Library;
import fr.unice.i3s.sigma.examples.library.LibraryPackage;
import fr.unice.i3s.sigma.examples.library.Loan;
import fr.unice.i3s.sigma.examples.library.Member;
import fr.unice.i3s.sigma.examples.library.MembershipType;

import fr.unice.i3s.sigma.support.AutoContainment;
import fr.unice.i3s.sigma.support.EMFBuilder;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

object LibraryBuilder extends EMFBuilder(LibraryPackage.eINSTANCE) {
  import AutoContainment._
  
  type Library = fr.unice.i3s.sigma.examples.library.Library
  object Library {
    def apply(config: (Library ⇒ Any)*): Library =
      contained(build[Library](config: _*))
  }
  
  type Book = fr.unice.i3s.sigma.examples.library.Book
  object Book {
    def apply(config: (Book ⇒ Any)*): Book =
      contained(build[Book](config: _*))
  }
  
  type Member = fr.unice.i3s.sigma.examples.library.Member
  object Member {
    def apply(config: (Member ⇒ Any)*): Member =
      contained(build[Member](config: _*))
  }
  
  type Loan = fr.unice.i3s.sigma.examples.library.Loan
  object Loan {
    def apply(config: (Loan ⇒ Any)*): Loan =
      contained(build[Loan](config: _*))
  }
}

object LibraryAssignments extends OverloadHack {
  private def nothing: Nothing = sys.error("this method is not meant to be called")
  
  def name(implicit ev: Nothing) = nothing
  def name_=[T <: Library](value: String) =
    (target: T) ⇒ target.setName(value)
  
  def name_=[T <: Book](value: String)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setName(value)
  
  def name_=[T <: Member](value: String)(implicit o: Overloaded2) =
    (target: T) ⇒ target.setName(value)
  
  
  def membershipType(implicit ev: Nothing) = nothing
  def membershipType_=[T <: Member](value: MembershipType) =
    (target: T) ⇒ target.setMembershipType(value)
  
  
  def book(implicit ev: Nothing) = nothing
  def book_=[T <: Loan](value: Book) =
    (target: T) ⇒ target.setBook(value)
  def book_=[T <: Loan](value: ⇒ Option[Book]) =
    (target: T) ⇒ target.setBook(LibraryBuilder.ref(value))
  
  
  def copies(implicit ev: Nothing) = nothing
  def copies_=[T <: Book](value: Int) =
    (target: T) ⇒ target.setCopies(value)
  
  
  def loans(implicit ev: Nothing) = nothing
  def loans_=[T <: Library](value: EList[Loan]) =
    (target: T) ⇒ target.getLoans.addAll(value)
  
  
  def date(implicit ev: Nothing) = nothing
  def date_=[T <: Loan](value: Date) =
    (target: T) ⇒ target.setDate(value)
  
  
  def member(implicit ev: Nothing) = nothing
  def member_=[T <: Loan](value: Member) =
    (target: T) ⇒ target.setMember(value)
  def member_=[T <: Loan](value: ⇒ Option[Member]) =
    (target: T) ⇒ target.setMember(LibraryBuilder.ref(value))
  
  
  def books(implicit ev: Nothing) = nothing
  def books_=[T <: Library](value: EList[Book]) =
    (target: T) ⇒ target.getBooks.addAll(value)
  
  
  def members(implicit ev: Nothing) = nothing
  def members_=[T <: Library](value: EList[Member]) =
    (target: T) ⇒ target.getMembers.addAll(value)
}

trait OverloadHack {
  class Overloaded1
  implicit val overload1 = new Overloaded1
  
  class Overloaded2
  implicit val overload2 = new Overloaded2
}

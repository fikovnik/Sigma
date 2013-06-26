package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Book;
import fr.unice.i3s.sigma.examples.library.Library;
import fr.unice.i3s.sigma.examples.library.Loan;
import fr.unice.i3s.sigma.examples.library.Member;
import fr.unice.i3s.sigma.examples.library.MembershipType;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import scala.Option;

trait MemberScalaSupport extends EMFScalaSupport {
  type Member = fr.unice.i3s.sigma.examples.library.Member
  
  protected implicit val _memberProxyBuilder = new EMFProxyBuilder[Member](LibraryPackageScalaSupport._libraryBuilder)
  
  object Member {
    def apply(name: String = null, membershipType: MembershipType = MembershipType.STANDARD): Member = {
      val instance = LibraryPackageScalaSupport._libraryBuilder.create[Member]
      
      if (name != null) instance.setName(name)
      if (membershipType != MembershipType.STANDARD) instance.setMembershipType(membershipType)
      
      instance
    }
    
    def unapply(that: Member): Option[(String,Library,EList[Loan],EList[Book],MembershipType)] =
      Some((that.getName,that.getLibrary,that.getLoans,that.getBooks,that.getMembershipType))
  }
  
  implicit class MemberScalaSupport(that: Member) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def library: Library = that.getLibrary
    def library_=(value: Library): Unit = that.setLibrary(value)
    def library_=(value: ⇒ Option[Library]): Unit =
      that.setLibrary(LibraryPackageScalaSupport._libraryBuilder.ref(value))
    def loans: EList[Loan] = that.getLoans
    def books: EList[Book] = that.getBooks
    def membershipType: MembershipType = that.getMembershipType
    def membershipType_=(value: MembershipType): Unit = that.setMembershipType(value)
  }
}

object MemberScalaSupport extends MemberScalaSupport

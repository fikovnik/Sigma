package null.library.support


import fr.unice.i3s.sigma.support.AutoContainment;
import fr.unice.i3s.sigma.support.EMFBuilder;

import library.Author;
import library.Book;
import library.Library;
import library.LibraryPackage;

import org.eclipse.emf.common.util.EList;

object LibraryBuilder extends EMFBuilder(LibraryPackage.eINSTANCE) {
  import AutoContainment._
  
  
  type Library = library.Library
  
  object Library {
    def apply(config: (Library ⇒ Any)*): Library =
      contained(build[Library](config: _*))
    def unapply(that: Library): Option[(EList[Book],EList[Author])] =
      Some((that.getCatalog,that.getAuthors))
  }
  
  
  type Book = library.Book
  
  object Book {
    def apply(config: (Book ⇒ Any)*): Book =
      contained(build[Book](config: _*))
    def unapply(that: Book): Option[(String,Author,Int)] =
      Some((that.getName,that.getAuthor,that.getPages))
  }
  
  
  type Author = library.Author
  
  object Author {
    def apply(config: (Author ⇒ Any)*): Author =
      contained(build[Author](config: _*))
    def unapply(that: Author): Option[(String)] =
      Some((that.getName))
  }
}


object LibraryAssignments {
  class Overloaded1
  
  implicit val overload1 = new Overloaded1
  
  
  
  
  private def nothing: Nothing = sys.error("this method is not meant to be called")
  
  
  def author(implicit ev: Nothing) = nothing
  
  def author_=[T <: Book](value: Author) =
    (target: T) ⇒ target.setAuthor(value)
  
  def author_=[T <: Book](value: ⇒ Option[Author]) =
    (target: T) ⇒ target.setAuthor(LibraryBuilder.ref(value))
  
  
  
  def name(implicit ev: Nothing) = nothing
  
  def name_=[T <: Book](value: String) =
    (target: T) ⇒ target.setName(value)
  
  
  def name_=[T <: Author](value: String)(implicit o: Overloaded1) =
    (target: T) ⇒ target.setName(value)
  
  
  
  def catalog(implicit ev: Nothing) = nothing
  
  def catalog_=[T <: Library](value: EList[Book]) =
    (target: T) ⇒ target.getCatalog.addAll(value)
  
  
  
  def pages(implicit ev: Nothing) = nothing
  
  def pages_=[T <: Book](value: Int) =
    (target: T) ⇒ target.setPages(value)
  
  
  
  def authors(implicit ev: Nothing) = nothing
  
  def authors_=[T <: Library](value: EList[Author]) =
    (target: T) ⇒ target.getAuthors.addAll(value)
}

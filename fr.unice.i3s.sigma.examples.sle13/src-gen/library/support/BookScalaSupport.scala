package library.support

import library.Author;
import library.Book;

import scala.Option;

trait BookScalaSupport {
  type Book = library.Book
  
  object Book {
    def apply(name: String = null, author: Author = null, pages: Int = 0): Book = {
      val instance = LibraryPackageScalaSupport.builder.create[Book]
      
      if (name != null) instance.setName(name)
      if (author != null) instance.setAuthor(author)
      if (pages != 0) instance.setPages(pages)
      
      instance
    }
    
    def unapply(that: Book): Option[(String,Author,Int)] =
      Some((that.getName,that.getAuthor,that.getPages))
  }
  
  implicit class BookScalaSupport(that: Book) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def author: Author = that.getAuthor
    def author_=(value: Author): Unit = that.setAuthor(value)
    def author_=(value: ⇒ Option[Author]): Unit =
      that.setAuthor(LibraryPackageScalaSupport.builder.ref(value))
    def pages: Int = that.getPages
    def pages_=(value: Int): Unit = that.setPages(value)
  }
}

object BookScalaSupport extends BookScalaSupport

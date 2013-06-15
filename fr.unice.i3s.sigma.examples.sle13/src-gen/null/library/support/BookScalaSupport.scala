package null.library.support


import library.Author;
import library.Book;

trait BookScalaSupport {
  implicit class BookScalaSupport(that: Book) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    
    def author: Author = that.getAuthor
    def author_=(value: Author): Unit = that.setAuthor(value)
    
    def pages: Int = that.getPages
    def pages_=(value: Int): Unit = that.setPages(value)
  }
}


object BookScalaSupport extends BookScalaSupport


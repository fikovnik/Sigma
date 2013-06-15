package library.support

import library.Author;

trait AuthorScalaSupport {
  type Author = library.Author
  
  object Author {
    def apply(name: String = null): Author = {
      val instance = library.LibraryFactory.eINSTANCE.createAuthor
      
      if (name != null) instance.setName(name)
      
      instance
    }
    
    def unapply(that: Author): Option[(String)] =
      Some((that.getName))
  }
  
  implicit class AuthorScalaSupport(that: Author) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object AuthorScalaSupport extends AuthorScalaSupport

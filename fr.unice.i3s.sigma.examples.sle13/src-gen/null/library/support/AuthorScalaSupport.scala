package null.library.support


import library.Author;

trait AuthorScalaSupport {
  implicit class AuthorScalaSupport(that: Author) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}


object AuthorScalaSupport extends AuthorScalaSupport


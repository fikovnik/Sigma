package fr.unice.i3s.sigma.validation

object Fix {

  class FixBuilder(val title: String) {
    def apply(action: ⇒ Unit): Fix = {
      new Fix(title, { () ⇒ action })
    }
  }

  def apply(title: String): FixBuilder = {
    new FixBuilder(title)
  }

}

class Fix(val title: String, val action: () ⇒ Unit)
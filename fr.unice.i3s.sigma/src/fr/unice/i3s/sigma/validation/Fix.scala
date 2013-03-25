package fr.unice.i3s.sigma.validation

object Fix {
  def apply(title: String)(action: ⇒ Unit): Fix = {
    new Fix(title, { () ⇒ action })
  }
}

class Fix(val title: String, val action: () ⇒ Unit)
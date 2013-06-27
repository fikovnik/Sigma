package fr.unice.i3s.sigma.internal

trait OverloadHack {
  class Overloaded1
  class Overloaded2

  implicit val overload1 = new Overloaded1
  implicit val overload2 = new Overloaded2
}

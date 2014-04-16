package fr.unice.i3s.sigma.m2m

class M2MTransformationException(message: String, cause: Throwable) extends Exception(message, cause) {
  def this(message: String) = this(message, null)
}
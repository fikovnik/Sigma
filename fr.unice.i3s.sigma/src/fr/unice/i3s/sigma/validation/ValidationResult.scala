package fr.unice.i3s.sigma.validation

sealed trait ValidationResult {
  def isValidOrCanceled: Boolean
}

object Passed extends ValidationResult {
  def isValidOrCanceled = true
}

object Canceled extends ValidationResult {
  def isValidOrCanceled = true
}

object Warning {
  def apply(message: String, fixes: Fix*) = new Warning(message, fixes: _*)
}

class Warning(val message: String, val fixes: Fix*) extends ValidationResult {
  def isValidOrCanceled = false
}

object Error {
  def apply(message: String, fixes: Fix*) = new Error(message, fixes: _*)
}

class Error(val message: String, val fixes: Fix*) extends ValidationResult {
  def isValidOrCanceled = false
}
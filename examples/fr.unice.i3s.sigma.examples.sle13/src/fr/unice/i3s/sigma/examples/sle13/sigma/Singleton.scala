package fr.unice.i3s.sigma.examples.sle13.sigma

import scala.reflect.ClassTag
import fr.unice.i3s.sigma.validation.Error
import fr.unice.i3s.sigma.validation.InvMethods
import fr.unice.i3s.sigma.validation.Passed
import fr.unice.i3s.sigma.validation.ValidationContext
import oo.ScopeKind
import oo.support.OOPackageScalaSupport
import fr.unice.i3s.sigma.validation.InvBuilder
import scala.language.postfixOps

class SingletonMethodBased extends ValidationContext with InvMethods with OOPackageScalaSupport {

  // define the context type, the type of self
  type Self = Class
  implicit val selfTag: ClassTag[Self] = implicitly

  // context guard
  override def guard = {
    self.stereotypes exists (_.name == "singleton")
  }

  def invHasGetInstance =
    getGetInstanceOperation(self) != null

  def invGetInstanceIsStatic = guardedBy {
    self satisfies invHasGetInstance
  } check {
    val op = getGetInstanceOperation(self)
    if (op.ownerScope == ScopeKind.SK_CLASSIFIER) Passed
    else Error(s"${self.name}.getInstance must be static")
      .quickFix(s"Change ${self.name}.getInstance to static") {
        op.ownerScope = ScopeKind.SK_CLASSIFIER
      }
  }

  def getGetInstanceOperation(c: Class): Operation =
    c.operations find (_.name == "getInstance") orNull
}

class SingletonBuilderBased extends ValidationContext with InvBuilder with OOPackageScalaSupport {

  // define the context type, the type of self
  type Self = Class
  implicit val selfTag: ClassTag[Self] = implicitly

  // context guard
  override def guard = {
    self.stereotypes exists (_.name == "singleton")
  }

  constraint("HasGetInstance")
    .check { getGetInstanceOperation(self) != null }

  constraint("GetInstanceIsStatic")
    .guardedBy { self satisfies "HasGetInstance" }
    .check {
      val op = getGetInstanceOperation(self)
      if (op.ownerScope == ScopeKind.SK_CLASSIFIER) Passed
      else Error(s"${self.name}.getInstance must be static")
        .quickFix(s"Change ${self.name}.getInstance to static") {
          op.ownerScope = ScopeKind.SK_CLASSIFIER
        }
    }

  def getGetInstanceOperation(c: Class): Operation =
    c.operations find (_.name == "getInstance") orNull

}

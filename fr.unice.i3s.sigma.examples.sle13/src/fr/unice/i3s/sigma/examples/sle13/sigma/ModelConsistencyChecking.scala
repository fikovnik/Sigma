package fr.unice.i3s.sigma.examples.sle13

import fr.unice.i3s.sigma.validation.ValidationContext
import fr.unice.i3s.sigma.validation.InvMethods
import fr.unice.i3s.sigma.validation.InvBuilder
import uml.support.UmlPackageScalaSupport
import uml.ScopeKind
import fr.unice.i3s.sigma.validation.Passed
import fr.unice.i3s.sigma.validation.Error
import scala.reflect.ClassTag

class SingletonMethodBased extends ValidationContext with InvMethods
  with UmlPackageScalaSupport {

  // define the context type, the type of self
  type Self = UmlClass
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

  def getGetInstanceOperation(c: UmlClass): Operation =
    c.operations find (_.name == "getInstance") orNull
}

class SingletonBuilderBased extends ValidationContext with InvBuilder with UmlPackageScalaSupport {

  // define the context type, the type of self
  type Self = UmlClass
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

  def getGetInstanceOperation(c: UmlClass): Operation =
    c.operations find (_.name == "getInstance") orNull

}


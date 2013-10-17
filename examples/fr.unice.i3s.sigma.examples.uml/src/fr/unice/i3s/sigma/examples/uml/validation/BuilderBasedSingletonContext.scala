package fr.unice.i3s.sigma.examples.uml.validation

import fr.unice.i3s.sigma.validation.Passed
import fr.unice.i3s.sigma.validation.Error
import fr.unice.i3s.sigma.validation.InvBuilder
import fr.unice.i3s.sigma.validation.ValidationContext
import fr.unice.i3s.sigma.examples.uml.support.UMLPackageScalaSupport
import scala.reflect.classTag
import org.eclipse.uml2.uml.VisibilityKind

class BuilderBasedSingletonContext extends ValidationContext with InvBuilder with UMLPackageScalaSupport {

  type Self = Class
  implicit val selfTag = classTag[Class]

  override def guard = self.getAppliedStereotype("TestProfile::singleton") != null

  constraint("DefinesGetInstance")
    .check {
      Option(getGetInstanceOperation) match {
        case Some(_) ⇒ Passed
        case None ⇒
          Error(s"Singleton ${self.name} must define a getInstance() operation")
            .quickFix("Add a getInstance() operation to ${self.name}") {

              val op = self.createOwnedOperation("getInstance", null, null)
              op.static = true
              op.createReturnResult(null, self)
            }

      }
    }

  constraint("GetInstanceIsStatic")
    .guardedBy { self satisfies "DefinesGetInstance" }
    .check {
      if (getGetInstanceOperation.static) Passed
      else {
        if (getGetInstanceOperation.static) Passed
        else
          Error(s"The getInstance() operation of singleton ${self.name} must be static")
            .quickFix("Change to static") {
              getGetInstanceOperation.static = true
            }
      }
    }

  constraint("GetInstanceReturnsSame")
    .guardedBy { self satisfies "DefinesGetInstance" }
    .check {
      Option(getGetInstanceOperation.getReturnResult) match {
        case Some(p) if p.getType == self ⇒ Passed
        case _ ⇒
          Error(s"The getInstance() operation of singleton ${self.name} must return ${self.name}").quickFix(s"Change return type to ${self.name}") {
            val op = getGetInstanceOperation
            Option(op.getReturnResult) match {
              case Some(p) ⇒ p.type_ = self
              case None ⇒ op.createReturnResult(null, self)
            }
          }
      }
    }

  def getGetInstanceOperation =
    self.ownedOperation find { _.name == "getInstance" } orNull

}
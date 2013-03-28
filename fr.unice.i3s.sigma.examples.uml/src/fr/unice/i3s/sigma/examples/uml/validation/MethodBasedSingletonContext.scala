package fr.unice.i3s.sigma.examples.uml.validation

import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.validation.ValidationContext
import fr.unice.i3s.sigma.examples.uml.support.UmlBuilder._
import fr.unice.i3s.sigma.examples.uml.support.UmlPackageScalaSupport
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.uml2.uml.resource.UMLResource
import fr.unice.i3s.sigma.util.EMFUtils
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.emf.mapping.ecore2xml.util.Ecore2XMLResource
import org.eclipse.uml2.uml.resource.UML22UMLResource
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.mapping.ecore2xml.Ecore2XMLPackage
import org.eclipse.uml2.uml.resource.UML22UMLExtendedMetaData
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil
import fr.unice.i3s.sigma.workflow.WorkflowApp
import fr.unice.i3s.sigma.workflow.lib.StandaloneSetup
import fr.unice.i3s.sigma.workflow.lib.LoadModel
import fr.unice.i3s.sigma.workflow.lib.ValidateModel
import fr.unice.i3s.sigma.validation.Passed
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.uml2.uml.resources.ResourcesPlugin
import org.eclipse.emf.ecore.plugin.EcorePlugin
import org.eclipse.uml2.uml.UMLPlugin
import fr.unice.i3s.sigma.validation.Error
import scala.collection.mutable.Buffer

class MethodBasedSingletonContext extends ValidationContext[UMLClass] with UmlPackageScalaSupport {

  guard = self.getAppliedStereotype("TestProfile::singleton") != null

  def invDefinesGetInstance = {
    getGetInstanceOperation match {
      case Some(_) ⇒ Passed
      case None ⇒ {
        new Error {
          message = s"Singleton ${self.name} must define a getInstance() operation"

          new Fix {
            title = "Add a getInstance() operation to ${self.name}"
            perform = {
              val op = self.createOwnedOperation("getInstance", null, null)
              op.setIsStatic(true)
              op.createReturnResult(null, self)
            }
          }
        }
      }
    }
  }

  def invGetInstanceIsStatic_Guard = self satisfies 'DefinesGetInstance
  def invGetInstanceIsStatic = {
    if (getGetInstanceOperation.get.isStatic) Passed
    else {
      new Error {
        message = s"The getInstance() operation of singleton ${self.name} must be static"

        new Fix {
          title = "Change to static"
          perform = {
            getGetInstanceOperation.get.setIsStatic(true)
          }
        }
      }
    }
  }

  def invGetInstanceReturnsSame_Guard = self satisfies 'DefinesGetInstance
  def invGetInstanceReturnsSame = {
    Option(getGetInstanceOperation.get.getReturnResult) match {
      case Some(p) if p.getType == self ⇒ Passed
      case _ ⇒ {
        new Error {
          message = "The getInstance() operation of singleton ${self.name} must return ${self.name}"

          new Fix {
            title = s"Change return type to ${self.name}"
            perform = {
              val op = getGetInstanceOperation.get
              Option(op.getReturnResult) match {
                case Some(p) ⇒ p.setType(self)
                case None ⇒ op.createReturnResult(null, self)
              }
            }
          }
        }
      }
    }
  }

  def getGetInstanceOperation =
    self.ownedOperation find { _.name == "getInstance" }

}
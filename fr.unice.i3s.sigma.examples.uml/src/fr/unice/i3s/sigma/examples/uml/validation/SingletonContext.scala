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
import fr.unice.i3s.sigma.validation.Fix
import scala.collection.mutable.Buffer

class SingletonContext extends ValidationContext[UMLClass] with UmlPackageScalaSupport {

  guard = self.getAppliedStereotype("TestProfile::singleton") != null

  val invDefinesGetInstance = new Constraint("DefinesGetInstance") {
    check =
      if (getGetInstanceOperation.isDefined) Passed
      else
        Error(s"Singleton ${self.name} must define a getInstance() operation",
          Fix(s"Add a getInstance() operation to ${self.name}") {
            val op = self.createOwnedOperation("getInstance", null, null)
            op.setIsStatic(true)
            op.createReturnResult(null, self)
          })
  }

  val invGetInstanceIsStatic = new Constraint("GetInstanceIsStatic") {
    guard = self.satisfies(invDefinesGetInstance)
    check =
      if (getGetInstanceOperation.get.isStatic) Passed
      else
        Error(s" The getInstance() operation of singleton ${self.name} must be static",
          Fix("Change to static") {
            getGetInstanceOperation.get.setIsStatic(true)
          })
  }

  val invGetInstanceReturnsSame = new Constraint("GetInstanceReturnsSame") {
    guard = self.satisfies(invDefinesGetInstance)
    check = Option(getGetInstanceOperation.get.getReturnResult) match {
      case Some(p) if p.getType == self ⇒ Passed
      case _ ⇒
        Error(s"The getInstance() operation of singleton ${self.name} must return ${self.name}",
          Fix(s"Change return type to ${self.name}") {
            val op = getGetInstanceOperation.get
            Option(op.getReturnResult) match {
              case Some(p) ⇒ p.setType(self)
              case None ⇒ op.createReturnResult(null, self)
            }
          })
    }
  }

  def getGetInstanceOperation =
    self.ownedOperation find { _.name == "getInstance" }

}

object Test extends WorkflowApp with UmlPackageScalaSupport {

  // http://www.eclipse.org/forums/index.php/mv/msg/151754/

  val projectName = "fr.unice.i3s.sigma.examples.uml"
  val runtimeProject = s"../$projectName"

  StandaloneSetup(
    platformPath = s"$runtimeProject/..",
    config = { t ⇒
      t.registerPackage(org.eclipse.uml2.uml.UMLPackage.eINSTANCE)

      t.registerExtension(UMLResource.FILE_EXTENSION, UMLResource.Factory.INSTANCE)

      t.addMapping("platform:/plugin/org.eclipse.uml2.uml/model/UML.ecore", "platform:/resource/org.eclipse.uml2.uml/model/UML.ecore")
      t.addMapping(UMLResource.LIBRARIES_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/libraries/")
      t.addMapping(UMLResource.METAMODELS_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/metamodels/")
      t.addMapping(UMLResource.PROFILES_PATHMAP, "platform:/resource/org.eclipse.uml2.uml.resources/profiles/")
    })

  val pkg = LoadModel(URI.createPlatformResourceURI("/fr.unice.i3s.sigma.examples.uml/model/Test.uml", false)).model[UMLPackage]
  ValidateModel(pkg)

  val ctx = new SingletonContext
  for (cls ← pkg.packagedElement collect { case e: UMLClass ⇒ e }) {
    println(cls.name)
    println(ctx.validate(cls))
  }

  //  println(pkg)
  //  println(pkg.getAllAppliedProfiles())
  //
  //    println(ctx.validate(cls))
  //    println(cls)
  //    println(pkg.getAllAppliedProfiles())
  //    println(cls.getAppliedStereotypes())
  //    println(cls.getAppliedStereotypes() map { _.qualifiedName })
  //  }

  //context Singleton {
  //    
  //     guard : self.stereotype->exists(s|s.name = "singleton")
  //    
  //     constraint DefinesGetInstance {
  //          check : self.getGetInstanceOperation().isDefined()
  //          message : "Singleton " + self.name +
  //               " must define a getInstance() operation"
  //          fix {
  //               title : "Add a getInstance() operation to " + self.name
  //               do {
  //                    // Create the getInstance operation
  //                    var op : new Operation;
  //                    op.name = "getInstance";
  //                    op.owner = self;
  //                    op.ownerScope = ScopeKind#sk_classifier;
  //                   
  //                    // Create the return parameter
  //                    var returnParameter : new Parameter;
  //                    returnParameter.type = self;
  //                    op.parameter = Sequence{returnParameter};
  //                    returnParameter.kind = ParameterDirectionKind#pdk_return;
  //               }
  //          }
  //     }
  //    
  //     constraint GetInstanceIsStatic {
  //          guard : self.satisfies("DefinesGetInstance")
  //          check : self.getGetInstanceOperation().ownerScope =
  //                  ScopeKind#sk_classifier
  //          message : " The getInstance() operation of singleton "
  //                    + self.name + " must be static"
  //    
  //          fix {
  //               title : "Change to static"
  //               do {
  //                    self.getGetInstanceOperation.ownerScope
  //                      = ScopeKind#sk_classifier;
  //               }
  //          }
  //     }
  //    
  //     constraint GetInstanceReturnsSame {
  //    
  //          guard : self.satisfies("DefinesGetInstance")
  //          check {
  //               var returnParameter : Parameter;
  //               returnParameter = self.getReturnParameter();
  //               return (returnParameter->isDefined()
  //                       and returnParameter.type = self);
  //          }
  //          message : " The getInstance() operation of singleton "
  //                    + self.name + " must return " + self.name
  //              
  //          fix {
  //               title : "Change return type to " + self.name
  //               do {
  //                    var returnParameter : Parameter;
  //                    returnParameter = self.getReturnParameter();
  //                   
  //                    // If the operation does not have a return parameter
  //                    // create one
  //                    if (not returnParameter.isDefined()){
  //                         returnParameter = Parameter.newInstance();
  //                         returnParameter.kind = ParameterDirectionKind#pdk_return;
  //                         returnParameter.behavioralFeature =
  //                              self.getInstanceOperation();
  //                    }
  //                    // Set the correct return type
  //                    returnParameter.type = self;
  //               }
  //          }
  //     }
  //}
  //
  //operation Class getGetInstanceOperation() : Operation {
  //     return self.feature.
  //          select(o:Operation|o.name = "getInstance").first();
  //}
  //
  //operation Operation getReturnParameter() : Parameter {
  //     return self.parameter.
  //          select(p:Parameter|p.kind =
  //               ParameterDirectionKind#pdk_return).first();
  //}
  //  

}
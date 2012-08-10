package fr.unice.i3s.sigma.support.scala.tools

import java.util.List
import scala.collection.JavaConversions._
import scala.collection.mutable.ArrayBuffer
import scala.reflect.BeanProperty
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EcorePackage
import org.stringtemplate.v4.STGroupFile
import fr.unice.i3s.sigma.core.AbstractSigmaDelegate
import fr.unice.i3s.sigma.core.SigmaDelegateDomain._
import fr.unice.i3s.sigma.scala.SigmaScalaDelegateDomain
import fr.unice.i3s.sigma.scala.SigmaScalaSettingDelegate
import fr.unice.i3s.sigma.scala.SigmaScalaInvocationDelegate
import fr.unice.i3s.sigma.scala.SigmaScalaValiationDelegate
import org.eclipse.emf.ecore.EAnnotation
import java.io.File
import com.google.common.io.Files
import com.google.common.base.Charsets
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EObject
import org.stringtemplate.v4.STErrorListener
import org.stringtemplate.v4.misc.STMessage

object DelegateGenerator extends App {

  def delegateClazz(e: EModelElement) = {
    Option(e.getEAnnotation(SigmaScalaDelegateDomain.DELEGATE_URI)) map { a =>
      Option(e match {
        case _: EAttribute => a.getDetails().get(SETTER_CONSTRAINT_KEY)
        case _: EReference => a.getDetails().get(SETTER_CONSTRAINT_KEY)
        case _: EOperation => a.getDetails().get(INVOCATION_CONSTRAINT_KEY)
      }).orElse(Option(a.getDetails.get(DELEGATE_CONSTRAINT_KEY)))
    }
  }

  if (args.length < 2 || args.length > 3) {
    println("Usage: %s <model.genmodel> <target_dir> [<generate_all>]" format getClass.getName)
    scala.sys.exit(1)
  }

  val (genModel, rs) = tools.load[GenModel](args(0))
  val targetDir = new File(args(1))
  val generateAll = if (args.length == 3) true else false

  if (!targetDir.isDirectory || !targetDir.canWrite) {
    println(targetDir + ": not such file or directory or not writtable")
    scala.sys.exit(1)
  }
  //fr.unice.i3s.actress.modeling.core.types.delegates
  val domain = new SigmaScalaDelegateDomain

  val stg = new STGroupFile("fr/unice/i3s/sigma/support/scala/tools/delegates.stg")
  stg.setListener(new STErrorListener {
    def compileTimeError(msg: STMessage) { println(msg) }
    def runTimeError(msg: STMessage) { println(msg) }
    def IOError(msg: STMessage) { println(msg) }
    def internalError(msg: STMessage) { println(msg) }
  })

  for (genPkg <- genModel.getGenPackages) {
    val pkg = genPkg.getEcorePackage
    val pkgFQN = genPkg.getBasePackage + "." + genPkg.getPackageName + ".delegates"
    val out = new File(targetDir, pkg.getName)

    println("Generating package: " + pkgFQN + " into " + out)

    if (!out.exists && !out.mkdir) {
      println("Unable to create directory: " + out)
      scala.sys.exit(1)
    }

    for (clazz <- pkg.getEClassifiers() collect { case c: EClass => c }) {
      val content = collection.mutable.Buffer[AbstractSigmaDelegate[_]]()

      val features = if (generateAll)
        clazz.getEAllStructuralFeatures ++ clazz.getEAllOperations
      else
        clazz.getEStructuralFeatures ++ clazz.getEOperations()

      for (e <- features) {
        delegateClazz(e) match {
          case Some(o) => {
            content += (e match {
              case e: EStructuralFeature => new SigmaScalaSettingDelegate(e, domain)
              case e: EOperation => new SigmaScalaInvocationDelegate(e, domain)
              case _ => throw new RuntimeException()
            })
          }
          case None =>
        }
      }

      Option(clazz.getEAnnotation(EcorePackage.eINSTANCE.getNsURI)).map(
        _.getDetails.get("constraints").split(" ").foreach {
          content += new SigmaScalaValiationDelegate(clazz, domain, _)
        })

      if (content.length > 0 || generateAll) {
        val delegateName = clazz.getName + "Delegate"
        val template = stg.getInstanceOf("template")

        template.addAggr("d.{package, class, name, content}",
          Array(pkgFQN, clazz, delegateName, bufferAsJavaList(content)))

        Files.write(template.render, new File(out, delegateName + ".scala"), Charsets.UTF_8)
        println("\t- Generated: " + delegateName);
      }
    }
  }
}
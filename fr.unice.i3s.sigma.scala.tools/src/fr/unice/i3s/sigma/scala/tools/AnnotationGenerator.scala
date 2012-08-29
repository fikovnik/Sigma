package fr.unice.i3s.sigma.scala.tools

import fr.unice.i3s.sigma.core.SigmaDelegateDomain
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import scala.collection.JavaConversions.asScalaBuffer
import scala.collection.JavaConversions.mapAsScalaMap
import fr.unice.i3s.sigma.scala.tools._
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import fr.unice.i3s.sigma.scala.SigmaScalaDelegateDomain

object AnnotationGenerator extends App {

  def eClassConstraints(clazz: EClass): Array[String] = {
    Option(clazz.getEAnnotation(EcorePackage.eINSTANCE.getNsURI)).flatMap { a =>
      Option(a.getDetails.get("constraints")).map { c =>
        for (e <- c.split(" "))
          yield e.trim
      }
    }.getOrElse(Array())
  }

  def addEAnnotationDetail(e: EModelElement, source: String, detail: Option[(String, String)] = None) {
    var a = e.getEAnnotation(source)
    if (a == null) {
      a = EcoreFactory.eINSTANCE.createEAnnotation()
      a.setSource(source)
      e.getEAnnotations.add(a)
    }

    detail match {
      case Some((k, v)) if (a.getDetails.containsKey(k)) =>
        a.getDetails.removeKey(k)
        a.getDetails.put(k, v)
      case Some((k, v)) =>
        a.getDetails.put(k, v)
      case _ =>
    }
  }

  val delegateURI = SigmaScalaDelegateDomain.DELEGATE_URI
  val addSigmaAnnotationDetail = addEAnnotationDetail(_: EModelElement, delegateURI, _: Option[(String, String)])

  def processEClass(clazz: EClass, pkgName: String) {
    val d = pkgName + "." + clazz.getName + "Delegate"

    clazz.getEAnnotations --= clazz.getEAnnotations.filter(_.getSource == delegateURI)
    addSigmaAnnotationDetail(clazz, Some(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY, d))

    for (e <- clazz.getEStructuralFeatures) {
      if (e.isDerived) {
        e.getEAnnotations --= e.getEAnnotations.filter(_.getSource == delegateURI)
        addSigmaAnnotationDetail(e, None)
      }
    }

    for (e <- clazz.getEOperations) {
      e.getEAnnotations --= e.getEAnnotations.filter(_.getSource == delegateURI)
      addSigmaAnnotationDetail(e, None)
    }

    for (e <- eClassConstraints(clazz)) {
      addSigmaAnnotationDetail(clazz, Some(e, ""))
    }
  }

  if (args.length != 1) {
    println("Usage: %s <model.genmodel>" format getClass.getName)
    scala.sys.exit(1)
  }

  val (genModel, rs) = load[GenModel](args(0))

  for (genPkg <- genModel.getGenPackages) {
    val pkg = genPkg.getEcorePackage
    val pkgFQN = genPkg.getBasePackage + "." + genPkg.getPackageName + ".delegates"

    Option(pkg.getEAnnotation(EcorePackage.eINSTANCE.getNsURI)).map { a =>
      val details = a.getDetails

      if (!details.containsKey("invocationDelegates")) {
        details.put("invocationDelegates", delegateURI)
      }
      if (!details.containsKey("settingDelegates")) {
        details.put("invocationDelegates", delegateURI)
      }
      if (!details.containsKey("validationDelegates")) {
        details.put("invocationDelegates", delegateURI)
      }
    }

    for (clazz <- pkg.getEClassifiers) {
      clazz match {
        case c: EClass => processEClass(c, pkgFQN)
        case _ =>
      }
    }
    
    pkg.eResource.save(null)
    println("Saving package %s to %s" format (pkg.getName, pkg.eResource))
  }

//  rs.getResources.foreach(_.save(null))
}
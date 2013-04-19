package fr.unice.i3s.sigma.docgen.common

import scala.collection.JavaConversions._
import org.eclipse.emf.ecore.EStructuralFeature
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.ETypedElement

trait EcoreDocUtils extends EcorePackageScalaSupport {

  protected[common] def multiplicity(typedElement: ETypedElement): Option[String] = {
    val multi = (typedElement.lowerBound, typedElement.upperBound) match {
      case (-1, -1) ⇒ Some("*")
      case (1, -1) ⇒ Some("1..*")
      case (1, 1) ⇒ None
      case (-1, 1) ⇒ Some("0..1")
      case (n, m) ⇒ Some(s"$n..$m")
    }

    multi.map("[" + _ + "]")
  }

  protected[common] def fqpn(pkg: EPackage, sep: String = "__"): String = {
    require(pkg != null)

    def superPackages(p: EPackage): List[EPackage] = Option(p.eSuperPackage) match {
      case None ⇒ List(p)
      case Some(sp) ⇒ superPackages(sp) ::: List(sp, p)
    }
    superPackages(pkg) map (_.name) mkString (sep)
  }

  protected[common] def fqcn(classifier: EClassifier, sep: String = "__"): String = {
    require(classifier != null)

    Option(classifier.ePackage).map(fqpn(_, sep)).getOrElse("") + sep + classifier.name
  }

  protected[common] def documentation(elem: EModelElement) =
    Option(EcoreUtil.getDocumentation(elem)) match {
      case Some(doc) ⇒ doc
      case None ⇒ ""
    }

  protected[common] def typeName(typedElement: ETypedElement) =
    s"${typedElement.eType.name}"

  protected[common] def featureLabel(feature: EStructuralFeature): String = {
    s"- ${feature.name} ${multiplicity(feature)}"
  }

  protected[common] def featureType(feature: EStructuralFeature): String =
    feature match {
      case e: EAttribute ⇒ e.eType.name
      case e: EReference ⇒ e.eReferenceType.name
    }

  protected[common] def featureLabelWithType(feature: EStructuralFeature) =
    s"- ${feature.name} : ${featureType(feature)}" + (multiplicity(feature) match {
      case None ⇒ ""
      case Some(m) ⇒ " " + m
    })

  protected[common] def operationParamLabel(param: EParameter) =
    s"${param.name}: ${typeName(param)}" + (multiplicity(param) match {
      case None ⇒ ""
      case Some(m) ⇒ " " + m
    })

  protected[common] def operationLabelWithType(operation: EOperation) = {
    val params = operation.eParameters map (operationParamLabel(_)) mkString (", ")
    s"- ${operation.name}($params) : ${typeName(operation)}" + (multiplicity(operation) match {
      case None ⇒ ""
      case Some(m) ⇒ " " + m
    })
  }
}
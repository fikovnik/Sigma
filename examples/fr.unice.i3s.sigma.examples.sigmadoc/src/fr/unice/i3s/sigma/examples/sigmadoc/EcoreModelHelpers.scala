package fr.unice.i3s.sigma.examples.sigmadoc

import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore._
import org.eclipse.emf.ecore.util.EcoreUtil

trait EcoreModelHelpers extends EcorePackageScalaSupport {

  implicit class ExtendedETypedElement(that: ETypedElement) {
    def cardinality = (that.lowerBound, that.upperBound) match {
      case (lo, -1) ⇒ s"$lo..*"
      case (lo, up) ⇒ s"$lo..$up"
    }
  }

  implicit class ExtendedEModelElement(that: EModelElement) {
    def documentation = Option(EcoreUtil.getDocumentation(that))
    def version = Option(that.getEAnnotation("doc")).flatMap(d ⇒ Option(d.details.get("version")))
    def seeRefs = Option(that.getEAnnotation("doc")).flatMap(d ⇒ Option(d.details.get("see"))).map(_.split(","))
  }

}
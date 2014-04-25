package fr.unice.i3s.sigma.examples.sigmadoc

import collection.JavaConversions._
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.Resource
import scalatags.all._
import scalatags.{ Node, Tags2 ⇒ tags }
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore._
import fr.unice.i3s.sigma.m2t.M2T

class Ecore2HTML extends EcorePackageScalaSupport with EcoreModelHelpers {

  var pkgFilename: EPackage ⇒ String = p ⇒ s"${p.name}.html"
  var clsFilename: EClassifier ⇒ String = p ⇒ s"${p.name}.html"
  var metaModelName: String = _

  private object listing extends EcorePackageScalaSupport {
    def apply[T](elements: Seq[T], name: T ⇒ String, filename: T ⇒ String) = ul(
      for (e ← elements sortBy (name(_))) yield li(a(href := filename(e), name(e)))
    )
  }

  abstract class Page extends M2T {
    // extension of the ScalaTags
    val httpEquiv = new scalatags.TypedStyle[String]("http-equiv", "http-equiv")
    val media = new scalatags.TypedStyle[String]("media", "media")
    val nbsp = new scalatags.RawNode("&nbsp;")
    object empty extends Node {
      def writeTo(strb: StringBuilder) {}
    }

    implicit class SigmaScalatagNode(that: scalatags.Node) {
      case class SiblingNode(left: Node, right: Node) extends Node {
        def writeTo(strb: StringBuilder) {
          left.writeTo(strb)
          right.writeTo(strb)
        }
      }

      def unary_! = !that.toString
      def +(sibling: Node) = new SiblingNode(that, sibling)
    }

    def main {
      !html(xmlns := "http://www.w3.org/1999/xhtml",
        header,
        body(onload := "setupControls()",
          div(id := "container",
            div(id := "header", pageHeader),
            div(id := "wrapper",
              div(id := "sidebar", pageSidebar),
              div(id := "content", pageContent),
              div(id := "footer", pageFooter)
            )
          )
        )
      )
    }

    def pageSidebar: Node
    def pageContent: Node

    def header = head(
      tags.title(metaModelName),
      meta(httpEquiv := "content-type", content := "text/html;charset=utf-8"),
      meta(httpEquiv := "Content-Style-Type", content := "text/css"),
      link(rel := "stylesheet", `type` := "text/css", media := "screen, projection", href := "css/screen.css"),
      script(`type` := "text/javascript", src := "scripts/controls.js")
    )

    def pageHeader = h1(
      a(href := "index.html", s"$metaModelName Meta-Model")
    )

    def pageFooter = h1("Generated using SigmaDoc",
      p("Validate ",
        a(href := "http://validator.w3.org/check/referer", title := "XHTML Validation courtesy of W3", "XHTML"),
        " | ",
        a(href := "http://jigsaw.w3.org/css-validator/check/referer?warning=no&amp;profile=css2", title := "CSS Validation courtesy of W3", "CSS")
      )
    )

  }

  class IndexPage extends Page {
    type Source = Resource

    var metaModelOverviewFigure: String = _

    def pageSidebar = div(id := "packages",
      h1("Packages"),
      listing[EPackage](source.contents[EPackage], p ⇒ p.name, pkgFilename)
    )

    def pageContent = img(src := metaModelOverviewFigure, alt := s"Overview of the $metaModelName metamodel")
  }

  class PackagePage extends Page {
    type Source = EPackage

    var metaModelOverviewFigure: String = _

    def pageSidebar =
      div(id := "packages",
        h1("Packages"),
        listing[EPackage](source.eResource.contents[EPackage], p ⇒ p.name, pkgFilename)
      ) +
        div(id := "classifiers",
          h1("Datatypes"),
          listing[EDataType](source.sAllContents[EDataType], c ⇒ c.name, clsFilename),
          h1("Classes"),
          listing[EClass](source.sAllContents[EClass], c ⇒ c.name, clsFilename)
        )

    def pageContent = img(src := metaModelOverviewFigure, alt := s"Overview of the $metaModelName metamodel")
  }

  abstract class ClassifierPage extends Page {
    override type Source >: Null <: EClassifier

    def pageSidebar =
      div(id := "controls",
        h1("Controls"),
        form(action := "noAction()",
          fieldset(
            input(`type` := "checkbox", id := "inherited", name := "inherited", onclick := "saveShowInherited();"),
            label(`for` := "inherited", "Show inherited features")
          )
        )
      ) +
        div(id := "packages",
          h1("Packages"),
          listing[EPackage](source.eResource.contents[EPackage], p ⇒ p.name, pkgFilename)
        ) +
          div(id := "classifiers",
            h1("Datatypes"),
            listing[EDataType](source.ePackage.sAllContents[EDataType], c ⇒ c.name, clsFilename),
            h1("Classes"),
            listing[EClass](source.ePackage.sAllContents[EClass], c ⇒ c.name, clsFilename)
          )

    def description = source.documentation.map { v ⇒
      hr + p(id := "description", v)
    }.getOrElse(empty)

    def version = source.version.map { v ⇒
      h3("Version:") + p(id := "version", v)
    }.getOrElse(empty)

    def seeAlso = source.seeRefs.map { v ⇒
      h3("See also:") + ul(
        for (e ← v.toSeq) yield li(a(href := e.trim, e.trim))
      )
    }.getOrElse(empty)

  }

  class ClassPage extends ClassifierPage {
    override type Source = EClass

    def pageContent =
      h1(s"Package: ${source.ePackage.name}") +
        h2({
          if (source.isAbstract()) "Abstract Class"
          else if (source.isInterface()) "Interface"
          else "Class"
        } + " " + source.name) +
        // super types
        {
          if (source.eSuperTypes.nonEmpty) {
            h3("Inherits from:") +
              ul(
                for (st ← source.eSuperTypes.sortBy(_.name)) yield li(a(href := clsFilename(st), st.name))
              )
          } else empty
        } +
        // sub types
        {
          val subtypes = source.eResource.contents[EClass].filter(_.eSuperTypes contains source)
          if (subtypes.nonEmpty) {
            h3("Direct subclasses:") +
              ul(
                for (st ← subtypes) yield li(a(href := clsFilename(st), st.name))
              )
          } else empty
        } +
        description +
        version +
        seeAlso +
        hr +
        // attributes
        {
          if (source.eAllAttributes.nonEmpty) attributes + hr
          else empty
        } +
        // operations
        {
          if (source.eAllOperations.nonEmpty) operations + hr
          else empty
        } +
        // references
        {
          if (source.eAllReferences.nonEmpty) references + hr
          else empty
        }

    def attributes = h4("Attributes") + table(borderSpacing := "0px",
      tr(
        th(`class` := "inheritedFrom", nbsp),
        th("Name"),
        th("Type"),
        th("Changeable"),
        th("Required"),
        th("Description")
      ),
      for (attribute ← source.eAllAttributes sortBy (_.name)) yield {
        listingRow(attribute.eContainingClass == source, attribute.eContainingClass) {
          td(attribute.name) +
            // type
            td(Option(attribute.eType).map { v ⇒ a(href := clsFilename(v), v.name) }.getOrElse(nbsp)) +
            // changeable
            td(booleanAttribute(attribute.changeable)) +
            // required
            td(booleanAttribute(attribute.required)) +
            // description
            td(attribute.documentation.getOrElse(nbsp).toString)
        }
      }
    )

    def operations = h4("Operations") + table(borderSpacing := "0px",
      tr(
        th(`class` := "inheritedFrom", nbsp),
        th("Signature"),
        th("Type"),
        th("Description")
      ),

      for (operation ← source.eAllOperations sortBy (_.name)) yield {
        listingRow(operation.eContainingClass == source, operation.eContainingClass) {
          td(signature(operation)) +
            // type
            td(Option(operation.eType).map { v ⇒ a(href := clsFilename(v), v.name) }.getOrElse(nbsp)) +
            // description
            td(operation.documentation.getOrElse(nbsp).toString)
        }
      }
    )

    def references = h4("Refereces") + table(borderSpacing := "0px",
      tr(
        th(`class` := "inheritedFrom", nbsp),
        th("Name"),
        th("Type"),
        th("Changeable"),
        th("Required"),
        th("Ordered"),
        th("Unique"),
        th("Cardinality"),
        th("Description")
      ),
      for (reference ← source.eAllReferences sortBy (_.name)) yield {
        listingRow(reference.eContainingClass == source, reference.eContainingClass) {
          td(reference.name) +
            // type
            td(Option(reference.eType).map { v ⇒ a(href := clsFilename(v), v.name) }.getOrElse(nbsp)) +
            // changeable
            td(booleanAttribute(reference.changeable)) +
            // required
            td(booleanAttribute(reference.required)) +
            // ordered
            td(booleanAttribute(reference.ordered)) +
            // unique
            td(booleanAttribute(reference.unique)) +
            // cardinality
            td(reference.cardinality) +
            // description
            td(reference.documentation.getOrElse(nbsp).toString)
        }
      }
    )

    private def listingRow(inherited: Boolean, inheritedClass: EClass)(rowBody: Node) =
      tr((if (!inherited) empty else `class` := "inheritedFeature"),
        td(`class` := "inheritedFrom") {
          if (inherited)
            nbsp
          else
            a(href := clsFilename(inheritedClass),
              img(src := "img/arrow_up.png", alt := s"Inherited from ${inheritedClass.name}")
            )
        } +
          rowBody
      )

    private def signature(operation: EOperation) = {
      val params = operation.eParameters map { p ⇒
        Option(p.eType).map(_.name + " ").getOrElse("") + p.name
      } mkString (", ")

      val exceptions = operation.eExceptions.toSeq match {
        case Seq() ⇒ ""
        case Seq(xs @ _*) ⇒ xs map (_.name) mkString (" throws ", ", ", "")
      }

      s"${operation.name}($params)$exceptions"
    }

    private def booleanAttribute(value: Boolean) = if (value) "true" else "false"
  }

  abstract class AbstractDataTypePage extends ClassifierPage {
    override type Source >: Null <: EDataType

    def pageContent =
      h1(s"Package: ${source.ePackage.name}") +
        h2(s"Datatype: ${source.name}") +
        description +
        version +
        seeAlso
  }

  class DataTypePage extends AbstractDataTypePage {
    override type Source = EDataType
  }

  class EnumPage extends AbstractDataTypePage {
    override type Source = EEnum

    override def pageContent = super.pageContent + (source.eLiterals.toSeq match {
      case Seq() ⇒ empty
      case Seq(xs @ _*) ⇒ hr +
        h4("Literals") +
        table(borderSpacing := "0px",
          tr(
            th("Name"),
            th("Value"),
            th("Description")
          ),
          for (l ← xs.sortBy(_.name)) yield tr(
            td(l.name),
            td(l.value.toString),
            td(l.documentation.getOrElse("").toString)
          )
        )
    })
  }
}
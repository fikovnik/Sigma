package fr.unice.i3s.sigma.docgen.common

import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EModelElement
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.ENamedElement
import fr.unice.i3s.sigma.m2t.TextTemplate
import java.io.File
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement

object LatexReference {

  object LatexSection {
    private val Sections = Chapter :: Section :: SubSection :: SubSubSection :: Nil
  }

  sealed abstract class LatexSection(val cmd: String, val labelPrefix: String = "sec") {
    import LatexSection._

    private lazy val idx = Sections.indexOf(this)

    def apply(name: String, label: String, star: Boolean = false) =
      s"""
      \\$cmd${if (star) "*" else ""}{$name}
      \\label{$labelPrefix:$label}
      """

    def next: LatexSection = this + 1
    def +(x: Int): LatexSection = Sections(idx + x)
  }

  case object Chapter extends LatexSection("chapter", "chap")
  case object Section extends LatexSection("section")
  case object SubSection extends LatexSection("subsection")
  case object SubSubSection extends LatexSection("subsubsection")
}

class LatexReference extends TextTemplate with EcoreDocUtils with EcorePackageScalaSupport {

  import LatexReference._

  protected var rootPackage: EPackage = _

  protected var generateMaster: Boolean = true

  protected var topSection: LatexSection = Chapter
  // TODO: check the minimum section level in the getter

  protected var topSectionName: String = "Model Reference"

  protected var topSectionLabel: String = "chap:ModelReference"

  protected var classDiagramMap: ENamedElement ⇒ (String, String) = _

  def render = {

    if (generateMaster) {
      genMasterFile
    } else {
      genModelReference
    }

  }

  protected def genClassDiagram(pkg: EPackage) {
    val (args, imagePath) = classDiagramMap(pkg)
    genIncludeGraphics(args, s"Package: ${pkg.name}", imagePath)
  }

  protected def genClassDiagram(clazz: EClass) {
    val (args, imagePath) = classDiagramMap(clazz)
    genIncludeGraphics(args, s"Class: ${clazz.name}", imagePath)
  }

  protected def genIncludeGraphics(args: String, caption: String, imagePath: String) {
    !s"""
    \\begin{figure}[H]
    \\centering
    \\IncludeGraphics[$args]{$imagePath}
    \\caption{${caption}}
    \\end{figure}
    """
  }

  protected[common] def genClassReference(clazz: EClass) {
    !topSection.next.next("Class: " + clazz.name, "EClassRef" + fqcn(clazz, sep = "_"), star = true)

    genClassDiagram(clazz)

    !"\\paragraph*{Documentation}"
    !endl
    !documentation(clazz).getOrElse("")
    !endl

    if (clazz.eStructuralFeatures.nonEmpty) {
      !"\\paragraph*{Attributes}"
      begin("center") {
        begin("tabularx", "{\\textwidth}", "{ X }") {
          !"\\toprule"

          for (f ← clazz.eStructuralFeatures.sortBy(_.name)) {
            !s"\\cellcolor[gray]{0.9} \\ttfamily ${featureLabelWithType(f)} \\\\"
            documentation(f) match {
              case Some(doc) ⇒ !s"\\small \\hspace*{5mm} $doc \\\\"
              case None ⇒
            }
          }

          !"\\bottomrule"
        }
      }
    }

    if (clazz.eOperations.nonEmpty) {
      !"\\paragraph*{Operations}"
      begin("center") {
        begin("tabularx", "{\\textwidth}", "{ X }") {
          !"\\toprule"

          for (o ← clazz.eOperations.sortBy(_.name)) {
            !s"\\cellcolor[gray]{0.9} \\small \\ttfamily ${operationLabelWithType(o)} \\\\"
            documentation(o) match {
              case Some(doc) ⇒ !s"\\small \\hspace*{5mm} $doc \\\\"
              case None ⇒
            }
          }

          !"\\bottomrule"
        }
      }
    }

  }

  protected def begin(name: String, args: String*)(block: ⇒ Unit) {
    !s"\\begin{$name}${args.mkString}" indent {
      block
    }
    !s"\\end{$name}"
  }

  protected def genPackageRefernce(pkg: EPackage) {
    !topSection.next("Package: " + fqpn(pkg, sep = "."), "EPackageRef" + fqpn(pkg, sep = "_"), star = true)

    genClassDiagram(pkg)

    !documentation(pkg).getOrElse("")

    pkg.eClassifiers.collect { case e: EClass ⇒ e }.foreach(genClassReference)

    pkg.eSubpackages.foreach(genPackageRefernce)

  }

  protected def genModelReference {

    !topSection(topSectionName, topSectionLabel)
    !"\\clearpage"
    genPackageRefernce(rootPackage)

  }

  protected def genMasterFile {
    !s"""
    \\documentclass[english]{report}

	% use synctex
	\\synctex=1

	% provides graphics
	\\usepackage{graphicx}
	% provides URL typesettings
	\\usepackage{url}
    """

    begin("document") {
      !"""
	  \makeatletter
	  \newbox\image@box%
	  \newdimen\image@width%
	  \newcommand\IncludeGraphics[2][\@empty]{%
		\setbox\image@box=\hbox{\includegraphics[#1]{#2}}%
		\image@width\wd\image@box%
		\ifdim \image@width>\linewidth%
		   \setbox\image@box=\hbox{\includegraphics[width=\linewidth]{#2}}%
		   \box\image@box%
		\else%
		   \includegraphics[#1]{#2}%
		\fi%
	  }
	  \makeatother
	  """

      !"""
      \\title{A Title}
	  \\author{An Author}

	  \\maketitle
	  """

      genModelReference
    }
  }
}
package fr.unice.i3s.sigma.examples.sigmadoc

import collection.JavaConversions._
import fr.unice.i3s.sigma.m2t.TextTemplate
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import scala.annotation.tailrec
import org.eclipse.emf.ecore.resource.Resource

class Ecore2Dot extends TextTemplate with EcorePackageScalaSupport with EcoreModelHelpers {

  type M2TSource = Resource

  def execute {
    !"digraph G" curlyIndent {
      !s"""
        node [shape=record, fontname=Tahoma, fontsize=10];
	    edge [fontname=Tahoma, fontsize=8];
	    center=true;
	    nodesep=1.5;
	    """

      genReferences(source.contents[EReference])
      genInheritance
      genClasses
    }
  }

  private def genClasses =
    for (c ← source.contents[EClass]) {
      val atts = c.eAllAttributes map (label) mkString ("\\n")
      !s"""_${c.name} [label="{${c.name}|{$atts}|{}}"];"""
    }

  private def genInheritance =
    for {
      c ← source.contents[EClass]
      s ← c.eSuperTypes
    } !s"${c.name} -> ${s.name} [arrowhead=onormal];"

  @tailrec
  private def genReferences(references: Seq[EReference], skips: Seq[EReference] = Seq()): Unit = references match {
    case Seq() ⇒
    case Seq(x, xs @ _*) if skips contains x ⇒ genReferences(xs, skips)
    case Seq(x, xs @ _*) ⇒
      !s"_${x.eContainingClass.name} -> _${x.eType.name}"

      Option(x.eOpposite) match {
        case Some(ref) ⇒
          !s""" [headlabel="${label(ref)}" taillabel="${label(x)}" arrowhead=${arrow(ref)} awwortail=${arrow(x)} labeldistance=3.5];"""
          genReferences(xs, skips :+ x :+ ref)
        case None ⇒
          !s""" [headlabel="" taillabel="${label(x)}" ${
            if (arrow(x) == "none") "arrowhead=vee"
            else "arrowhead=none"
          } arrowtail=${arrow(x)} labeldistance=3.5];"""

          genReferences(xs, skips :+ x)
      }
  }

  def arrow(r: EReference) = if (r.containment) "normalinv" else "none"
  def label(r: EReference) = s"${r.name} [${r.cardinality}]"
  def label(a: EAttribute) = s"${a.name}: ${a.eType.name} [${a.cardinality}]"
}
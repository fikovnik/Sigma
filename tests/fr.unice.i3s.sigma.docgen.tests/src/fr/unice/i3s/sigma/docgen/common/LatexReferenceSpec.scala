package fr.unice.i3s.sigma.docgen.common

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.m2t.TextTemplateTesting
import org.eclipse.emf.ecore.util.EcoreUtil

@RunWith(classOf[JUnitRunner])
class LatexReferenceSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport with EMFScalaSupport {

  import EcorePackageScalaSupport.{EString, EInt}
  
  "LatexReference" must "generate class attribute reference" in {

    val clazz = EClass(name = "MyClass")
    EcoreUtil.setDocumentation(clazz, "My Class documentation")

    clazz.eStructuralFeatures += EAttribute(name = "attr1", eType = EString, lowerBound = 1, upperBound = 1) init { a ⇒
      EcoreUtil.setDocumentation(a, "attr1 documentation")
    }
    clazz.eStructuralFeatures +=
      EAttribute(name = "attr2", eType = EString, lowerBound = 1, upperBound = -1)

    val ref = new LatexReference with TextTemplateTesting

    ref.genClassReference(clazz)

    ref.partial must be ===
      """|\subsection*{Class: MyClass}
         |\label{sec:EClassRef_MyClass}
         |\paragraph*{Documentation}
         |
         |My Class documentation
         |
         |\paragraph*{Attributes}
         |\begin{center}
         |  \begin{tabularx}{\textwidth}{ X }
         |    \toprule
         |    \cellcolor[gray]{0.9} \ttfamily - attr1 : EString \\
         |    \small \hspace*{5mm} attr1 documentation \\
         |    \cellcolor[gray]{0.9} \ttfamily - attr2 : EString [1..*] \\
         |    \bottomrule
         |  \end{tabularx}
         |\end{center}
         |""".stripMargin
  }

  "LatexReference" must "generate class operation reference" in {

    val clazz = EClass(name = "MyClass")
    EcoreUtil.setDocumentation(clazz, "My Class documentation")
    
    clazz.eOperations += EOperation(name = "op1", eType = EString, lowerBound = 1, upperBound = 1) init { x ⇒
      EcoreUtil.setDocumentation(x, "op1 documentation")

      x.eParameters += EParameter(name = "a", eType = EInt, lowerBound = 1, upperBound = 1)
      x.eParameters += EParameter(name = "b", eType = EString, lowerBound = 1, upperBound = 1)
    }

    val ref = new LatexReference with TextTemplateTesting

    ref.genClassReference(clazz)

    ref.partial must be ===
      """|\subsection*{Class: MyClass}
    	 |\label{sec:EClassRef_MyClass}
		 |\paragraph*{Documentation}
         |
		 |My Class documentation
		 |
		 |\paragraph*{Operations}
		 |\begin{center}
         |  \begin{tabularx}{\textwidth}{ X }
         |    \toprule
         |    \cellcolor[gray]{0.9} \small \ttfamily - op1(a: EInt, b: EString) : EString \\
         |    \small \hspace*{5mm} op1 documentation \\
         |    \bottomrule
         |  \end{tabularx}
         |\end{center}
         |""".stripMargin
  }

}
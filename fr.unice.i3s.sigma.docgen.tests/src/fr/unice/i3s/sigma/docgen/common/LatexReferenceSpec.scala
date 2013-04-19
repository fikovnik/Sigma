package fr.unice.i3s.sigma.docgen.common

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.support.AutoContainment._
import fr.unice.i3s.sigma.support.EMFBuilder._
import fr.unice.i3s.sigma.support.ecore.EcoreBuilder._
import fr.unice.i3s.sigma.support.ecore.EcoreAssignments._
import fr.unice.i3s.sigma.m2t.TextTemplateTesting
import org.eclipse.emf.ecore.util.EcoreUtil

@RunWith(classOf[JUnitRunner])
class LatexReferenceSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport with EMFScalaSupport {

  "LatexReference" must "generate class attribute reference" in {

    val clazz = EClass(name = "MyClass")
    EcoreUtil.setDocumentation(clazz, "My Class documentation")

    clazz.eStructuralFeatures {
      EAttribute(name = "attr1", eType = EString, lowerBound = 1, upperBound = 1) init { a ⇒
        EcoreUtil.setDocumentation(a, "attr1 documentation")
      }
      EAttribute(name = "attr2", eType = EString, lowerBound = 1, upperBound = -1)
    }

    val ref = new LatexReference with TextTemplateTesting

    ref.genClassReference(clazz)
    println(ref.partial)

    ref.partial must be ===
      """|\subsection{Class: MyClass}
    	 |\label{sec:EClassRef_MyClass}
		 |
		 |My Class documentation
		 |
		 |\paragraph*{Attributes}
		 |\begin{center}
		 |  \rowcolors{2}{white}{lightgray}
		 |  \begin{tabular}{ | l | p{.6\textwidth} | }
		 |    \hline
		 |    \textbf{Attribute} & \textbf{Description} \\ \hline
    	 |    \small - attr1 : \texttt{EString} & \small attr1 documentation \\ \hline
		 |    \small - attr2 : \texttt{EString} [1..*] & \small  \\ \hline
		 |  \end{tabular}
		 |\end{center}
         |""".stripMargin
  }

  "LatexReference" must "generate class operation reference" in {

    val clazz = EClass(name = "MyClass")
    EcoreUtil.setDocumentation(clazz, "My Class documentation")

    clazz.eOperations {
      EOperation(name = "op1", eType = EString, lowerBound = 1, upperBound = 1) init { a ⇒
        EcoreUtil.setDocumentation(a, "op1 documentation")

        a eParameters {
          EParameter(name = "a", eType = EInt, lowerBound = 1, upperBound = 1)
          EParameter(name = "b", eType = EString, lowerBound = 1, upperBound = 1)
        }
      }
    }

    val ref = new LatexReference with TextTemplateTesting

    ref.genClassReference(clazz)
    println(ref.partial)

    ref.partial must be ===
      """|\subsection{Class: MyClass}
    	 |\label{sec:EClassRef_MyClass}
		 |
		 |My Class documentation
		 |
		 |\paragraph*{Operations}
		 |\begin{center}
		 |  \rowcolors{2}{white}{lightgray}
		 |  \begin{tabular}{ | l | p{.6\textwidth} | }
		 |    \hline
		 |    \textbf{Operation} & \textbf{Description} \\ \hline
		 |    \small - op1(a: \texttt{EInt}, b: \texttt{EString}) : \texttt{EString} & \small op1 documentation \\ \hline
		 |  \end{tabular}
		 |\end{center}
         |""".stripMargin
  }

}
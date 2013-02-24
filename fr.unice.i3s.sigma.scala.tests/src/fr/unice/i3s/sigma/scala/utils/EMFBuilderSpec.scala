package fr.unice.i3s.sigma.scala.utils

import collection.JavaConversions._
import fr.unice.i3s.sigma.scala.utils._
import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.EOperation

@RunWith(classOf[JUnitRunner])
class EMFBuilderSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport {

  import EcorePackageScalaSupport._

  "EMF Builder" must "correctly set the refernces" in {
    val builder = new EcoreBuilder
    import builder._

    val clazzA = eClass(name = "A")
    val clazzB = eClass(name = "B")
    clazzA.eStructuralFeatures += eReference(name = "b", eType = clazzB)
    clazzB.eStructuralFeatures += eReference(name = "a", eType = clazzA)

    val pkg = ePackage(name = "pkg", nsPrefix = "p", nsURI = "http://p.net")
    pkg.eClassifiers ++= clazzA :: clazzB :: Nil

    //    EPackage.Registry.INSTANCE.put(pkg.nsURI, pkg);
    //    println(pkg.getEFactoryInstance())

    //    println(EcoreUtil.ProxyCrossReferencer.find(pkg))
    println(pkg.validate prettyPrint)

    //    for (e ← pkg.eAllContents) {
    //      println(e)
    //    }
  }

  def derived[T <: EStructuralFeature](feature: T): T = {
    feature.derived = true
    feature.transient = true
    feature.volatile = true
    feature
  }

  "EcoreBuilder" must "conveniently create the library example" in {
    val builder = new EcoreBuilder
    import builder._

    val pkg = ePackage(name = "library", nsPrefix = "library", nsURI = "http://library.me")
    pkg eClassifiers {
      val Library = eClass("Library")
      val Book = eClass("Book")
      val Loan = eClass("Loan")
      val Member = eClass("Member")

      Library {
        eStructuralFeatures {
          eAttribute(name = "name", eType = EString, lowerBound = 1)

          eReference(name = "books", eType = Book, lowerBound = 0, upperBound = -1, containment = true,
            //          "//Book/eReferences/name='library'"
            eOpposite = ref(Book.eReferences find (_.name == "library")))
          eReference(name = "loans", eType = Loan, lowerBound = 0, upperBound = -1, containment = true)
          //          eReference(name = "members", eType = Member, lowerBound = 0, upperBound = -1, containment = true, eOpposite = Member.eReferences.byName("library"))
        }
        eOperations {
          eOperation(name = "toString", eType = EBoolean)
          eOperation(name = "getBookByName", eType = EBoolean,
            eParameters = List(eParameter(name = "name", eType = EString)))
        }
      }

      Book {
        eStructuralFeatures {
          eAttribute(name = "name", eType = EString, lowerBound = 1)
          eAttribute(name = "copies", eType = EInt, lowerBound = 1)

          eReference(name = "library", eType = Library, lowerBound = 1, eOpposite = Library.eReferences.byName("books"))
          derived(eReference(name = "loans", eType = Loan, lowerBound = 1, upperBound = -1))
        }
        eOperations {
          eOperation(name = "isAvailable", eType = EBoolean)
        }
      }

      Member {
        eStructuralFeatures {
          eAttribute(name = "name", eType = EString, lowerBound = 1)
          eAttribute(name = "copies", eType = EInt, lowerBound = 1)

          //          eReference(name = "library", eType = Library, lowerBound = 1, eOpposite = Library.eReferences.byName("members"))
          derived(eReference(name = "loans", eType = Loan, lowerBound = 1, upperBound = -1))
          derived(eReference(name = "books", eType = Book, lowerBound = 1, upperBound = -1))
        }
      }

      Loan {
        eStructuralFeatures {
          eAttribute(name = "date", eType = EDate)

          eReference(name = "book", eType = Loan, lowerBound = 1)
          eReference(name = "member", eType = Member, lowerBound = 1)
        }
      }
    }

    println(pkg.validate prettyPrint)
  }

}
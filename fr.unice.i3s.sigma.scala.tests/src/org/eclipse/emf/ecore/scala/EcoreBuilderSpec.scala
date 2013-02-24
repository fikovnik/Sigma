package org.eclipse.emf.ecore.scala

import scala.reflect.runtime.universe
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport.EBoolean
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport.EDate
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport.EInt
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport.EString
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.EClass
import collection.JavaConversions._
import org.eclipse.emf.ecore.EAttribute
import fr.unice.i3s.sigma.scala.utils.eListAsScalaImmutableList
import fr.unice.i3s.sigma.scala.utils.richEObject
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.scala.utils._
import fr.unice.i3s.sigma.scala.construct.AutoContainment

@RunWith(classOf[JUnitRunner])
class EcoreBuilderSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport {

  import EcorePackageScalaSupport._

  def setDerived[T <: EStructuralFeature] =
    (feature: T) ⇒ {
      feature.derived = true
      feature.transient = true
      feature.volatile = true
    }

  "EcoreBuilder" must "conveniently create the library example" in {
    val builder = new EcoreBuilder with EcoreAssignments with AutoContainment
    import builder._

    val pkg = ePackage(name = "library", nsPrefix = "library", nsURI = "http://library.me")
    pkg eClassifiers {
      val library = eClass(name = "Library")
      val book = eClass(name = "Book")
      val loan = eClass(name = "Loan")
      val member = eClass(name = "Member")

      library init { c ⇒
        c eStructuralFeatures {
          eAttribute(name = "name", eType = EString, lowerBound = 1)

          eReference(name = "books", eType = book, lowerBound = 0, upperBound = -1, containment = true,
            eOpposite = ref(book.eReferences find (_.name == "library")))
          eReference(name = "loans", eType = loan, lowerBound = 0, upperBound = -1, containment = true)
          eReference(name = "members", eType = member, lowerBound = 0, upperBound = -1, containment = true,
            eOpposite = ref(member.eReferences find (_.name == "library")))
        }
        c eOperations {
          eOperation(name = "toString", eType = EBoolean)
          eOperation(name = "getBookByName", eType = EBoolean) init { c ⇒
            c eParameters {
              eParameter(name = "name", eType = EString)
            }
          }
        }
      }

      book init { c ⇒
        c eStructuralFeatures {
          eAttribute(name = "name", eType = EString, lowerBound = 1)
          eAttribute(name = "copies", eType = EInt, lowerBound = 1)

          eReference(name = "library", eType = library, lowerBound = 1,
            eOpposite = ref(library.eReferences find (_.name == "books")))
          eReference(name = "loans", eType = loan, lowerBound = 1, upperBound = -1, setDerived)
        }
        c eOperations {
          eOperation(name = "isAvailable", eType = EBoolean)
        }
      }

      member init { c ⇒
        c eStructuralFeatures {
          eAttribute(name = "name", eType = EString, lowerBound = 1)
          eAttribute(name = "copies", eType = EInt, lowerBound = 1)

          eReference(name = "library", eType = library, lowerBound = 1,
            eOpposite = ref(library.eReferences find (_.name == "members")))
          eReference(name = "loans", eType = loan, lowerBound = 1, upperBound = -1, setDerived)
          eReference(name = "books", eType = book, lowerBound = 1, upperBound = -1, setDerived)
        }
      }

      loan init { c ⇒
        c eStructuralFeatures {
          eAttribute(name = "date", eType = EDate)

          eReference(name = "book", eType = loan, lowerBound = 1)
          eReference(name = "member", eType = member, lowerBound = 1)
        }
      }
    }

    pkg.isValid must be === true
    pkg.eClassifiers must have size (4)
  }

}
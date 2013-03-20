package fr.unice.i3s.sigma.support.ecore

import scala.reflect.runtime.universe
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.eclipse.emf.ecore.EcorePackage
import collection.JavaConversions._
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.support.AutoContainment
import fr.unice.i3s.sigma.support.EMFBuilder
import fr.unice.i3s.sigma.support.ecore.EcoreBuilder._
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EClassifier

@RunWith(classOf[JUnitRunner])
class EcoreBuilderSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport with EMFScalaSupport {

  import EcorePackageScalaSupport._

  def setDerived[T <: EStructuralFeature] =
    (feature: T) ⇒ {
      feature.derived = true
      feature.transient = true
      feature.volatile = true
    }

  implicit def typeName[T <: ETypedElement](that: (String, EClassifier)) =
    (target: T) ⇒ {
      target.name = that._1
      target.eType = that._2
    }

  def required[T <: ETypedElement] = (target: T) ⇒ target.lowerBound = 1
  def many[T <: ETypedElement] = (target: T) ⇒ target.upperBound = -1
  def oneToMany[T <: ETypedElement] = (target: T) ⇒ {
    target.lowerBound = 1
    target.upperBound = -1
  }

  // TODO: test the extractors

  "EcoreBuilder" must "conveniently create the library example" in {
    import EMFBuilder._
    import EcoreBuilder._
    import AutoContainment._
    import EcoreAssignments._

    val pkg = EPackage(name = "library", nsPrefix = "library", nsURI = "http://library.me")
    pkg eClassifiers {
      val library = EClass(name = "Library")
      val book = EClass(name = "Book")
      val loan = EClass(name = "Loan")
      val member = EClass(name = "Member")

      library init { c ⇒
        c eStructuralFeatures {
          EAttribute("name" -> EString, required)

          EReference("books" -> book, many, containment = true, eOpposite = book.eReferences find (_.name == "library"))
          EReference("loans" -> loan, many, containment = true)
          EReference("members" -> member, many, containment = true, eOpposite = member.eReferences find (_.name == "library"))
        }
        c eOperations {
          EOperation("toString" -> EBoolean)
          EOperation("getBookByName" -> EBoolean) init { c ⇒
            c eParameters {
              EParameter("name" -> EString)
            }
          }
        }
      }

      book init { c ⇒
        c eStructuralFeatures {
          EAttribute("name" -> EString, required)
          EAttribute("copies" -> EInt, required)

          EReference("library" -> library, required, eOpposite = library.eReferences find (_.name == "books"))
          EReference("loans" -> loan, many, setDerived)
        }
        c eOperations {
          EOperation("isAvailable" -> EBoolean)
        }
      }

      member init { c ⇒
        c eStructuralFeatures {
          EAttribute("name" -> EString, many)
          EAttribute("copies" -> EInt, many)

          EReference("library" -> library, required, eOpposite = library.eReferences find (_.name == "members"))
          EReference("loans" -> loan, oneToMany, setDerived)
          EReference("books" -> book, oneToMany, setDerived)
        }
      }

      loan init { c ⇒
        c eStructuralFeatures {
          EAttribute("date" -> EDate)

          EReference("book" -> loan, required)
          EReference("member" -> member, required)
        }
      }
    }

    println(pkg.validate prettyPrint)
    pkg.isValid must be === true
    pkg.eClassifiers must have size (4)
  }

}
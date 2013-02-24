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
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ETypedElement

@RunWith(classOf[JUnitRunner])
class EcoreBuilderSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport {

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
          eAttribute("name" -> EString, required)

          eReference("books" -> book, many, containment = true, eOpposite = ref(book.eReferences find (_.name == "library")))
          eReference("loans" -> loan, many, containment = true)
          eReference("members" -> member, many, containment = true, eOpposite = ref(member.eReferences find (_.name == "library")))
        }
        c eOperations {
          eOperation("toString" -> EBoolean)
          eOperation("getBookByName" -> EBoolean) init { c ⇒
            c eParameters {
              eParameter("name" -> EString)
            }
          }
        }
      }

      book init { c ⇒
        c eStructuralFeatures {
          eAttribute("name" -> EString, required)
          eAttribute("copies" -> EInt, required)

          eReference("library" -> library, required, eOpposite = ref(library.eReferences find (_.name == "books")))
          eReference("loans" -> loan, many, setDerived)
        }
        c eOperations {
          eOperation("isAvailable" -> EBoolean)
        }
      }

      member init { c ⇒
        c eStructuralFeatures {
          eAttribute("name" -> EString, many)
          eAttribute("copies" -> EInt, many)

          eReference("library" -> library, required, eOpposite = ref(library.eReferences find (_.name == "members")))
          eReference("loans" -> loan, oneToMany, setDerived)
          eReference("books" -> book, oneToMany, setDerived)
        }
      }

      loan init { c ⇒
        c eStructuralFeatures {
          eAttribute("date" -> EDate)

          eReference("book" -> loan, required)
          eReference("member" -> member, required)
        }
      }
    }

    pkg.isValid must be === true
    pkg.eClassifiers must have size (4)
  }

}
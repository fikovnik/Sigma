package fr.unice.i3s.sigma.scala.utils

import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.scala.utils._
import org.eclipse.emf.ecore._
import reflect.{ ClassTag, classTag }

//trait EcoreAssignments extends EMFDynamicContext {
//  type HasSetName = EObject { def setName(name: String) }
//
//  def name(implicit ev: Nothing) = ???
//  def name_=(name: String) =
//    self[HasSetName].setName(name)
//}

//trait EcoreScalaSetters {
//  implicit class EClassSetters(val obj: EClass) {
//    // generate a getter and a setter for each structural feature that is not many
//    def name = obj.getName
//    def name_=(name: String) = obj.setName(name)
//
//    // generate a getter for each isMany feature
//    def eSuperTypes = obj.getESuperTypes()
//  }
//}

class EcoreBuilder extends EMFBuilder(EcorePackage.eINSTANCE) {

  def ePackage(
    name: String = null,
    nsURI: String = null,
    nsPrefix: String = null): EPackage = {
    val obj = create[EPackage]

    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setNsURI, nsURI, null)
    setNotDefault(obj.setNsPrefix, nsPrefix, null)

    obj
  }

  //  def eClassifiers = self[EPackage] match {
  //    case Some(e) ⇒ e.getEClassifiers
  //    case None ⇒ throw new IllegalStateException("No EPackage context found")
  //  }

  def eClass(
    name: String,
    eSuperTypes: List[EClass] = Nil): EClass = {
    val obj = create[EClass]

    container[EClassifier] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    setNotDefault(obj.setName, name, null)
    obj.getESuperTypes() ++= eSuperTypes

    obj
  }

  //  def eStructuralFeatures = self[EClass] match {
  //    case Some(e) ⇒ e.getEStructuralFeatures
  //    case None ⇒ throw new IllegalStateException("No EClass context found")
  //  }

  // FIXME: fix the problem with eGenericType
  def eAttribute(
    name: String = null,
    iD: Boolean = false,
    transient: Boolean = false,
    volatile: Boolean = false,
    changeable: Boolean = false,
    defaultValueLiteral: String = null,
    unsettable: Boolean = false,
    derived: Boolean = false,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null): EAttribute = {

    val obj = create[EAttribute]

    // set containment    
    container[EStructuralFeature] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set values
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setID, iD, false)
    setNotDefault(obj.setTransient, transient, false)
    setNotDefault(obj.setVolatile, volatile, false)
    setNotDefault(obj.setChangeable, changeable, false)
    setNotDefault(obj.setDefaultValueLiteral, defaultValueLiteral, null)
    setNotDefault(obj.setUnsettable, unsettable, false)
    setNotDefault(obj.setDerived, derived, false)
    setNotDefault(obj.setOrdered, ordered, true)
    setNotDefault(obj.setUnique, unique, true)
    setNotDefault(obj.setLowerBound, lowerBound, 0)
    setNotDefault(obj.setUpperBound, upperBound, 1)
    setNotDefault(obj.setEType, eType, null)
    setNotDefault(obj.setEGenericType, eGenericType, null)

    obj
  }

  def eReference(
    name: String,
    transient: Boolean = false,
    volatile: Boolean = false,
    changeable: Boolean = false,
    defaultValueLiteral: String = null,
    unsettable: Boolean = false,
    derived: Boolean = false,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null,
    containment: Boolean = false,
    resolveProxies: Boolean = true,
    eOpposite: EReference = null): EReference = {

    val obj = create[EReference]

    // set containment
    container[EStructuralFeature] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set values
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setTransient, transient, false)
    setNotDefault(obj.setVolatile, volatile, false)
    setNotDefault(obj.setChangeable, changeable, false)
    setNotDefault(obj.setDefaultValueLiteral, defaultValueLiteral, null)
    setNotDefault(obj.setUnsettable, unsettable, false)
    setNotDefault(obj.setDerived, derived, false)
    setNotDefault(obj.setOrdered, ordered, true)
    setNotDefault(obj.setUnique, unique, true)
    setNotDefault(obj.setLowerBound, lowerBound, 0)
    setNotDefault(obj.setUpperBound, upperBound, 1)
    setNotDefault(obj.setEType, eType, null)
    setNotDefault(obj.setEGenericType, eGenericType, null)
    setNotDefault(obj.setContainment, containment, false)
    setNotDefault(obj.setResolveProxies, resolveProxies, true)
    setNotDefault(obj.setEOpposite, eOpposite, null)

    obj
  }

  //  def refClassifier(path: String): EClassifier = {
  //    val ctx = self[EObject] match {
  //      case Some(e) ⇒ e
  //      case None ⇒ throw new IllegalStateException("No EObject context found")
  //    }
  //
  //    val pkg = find[EPackage](ctx)
  //    pkg.getEClassifiers find (_.getName == path) match {
  //      case Some(c) ⇒ c
  //      case None ⇒ throw new IllegalArgumentException("Unable to find classifier: " + path)
  //    }
  //  }
  //
  //  private def find[T <: EObject: ClassTag](start: EObject): T = classTag[T] match {
  //    case t if t.runtimeClass.isAssignableFrom(start.getClass) ⇒ start.asInstanceOf[T]
  //    case t if start.eContainer != null ⇒ find[T](start.eContainer)
  //    case t ⇒ throw new IllegalArgumentException("Unable to find container of type: " + t.runtimeClass)
  //  }

}

//object Test extends App {
//
//  val builder = new EcoreBuilder with EcoreAssignments
//  import builder._
//
//  val myPkg = epackage("pkg") {
//    eclass("clazz") {
//      ereference("a")
//      ereference("b")
//    }
//    eclass("clazz2") init { c ⇒
//      c.setName("clazz2Ex")
//    }
//    eclass("clazz3") {
//      name = "clazz3Ex"
//    }
//    eclass("clazz4") {
//      container[EClass].setName("clazz4Ex")
//    }
//  }
//
//  print(myPkg)
//
//  def print(obj: EObject, indent: Int = 0) {
//    println(" " * indent + obj)
//    obj.eContents foreach (print(_, indent + 2))
//  }
//
//}
//
////object TestDynamic extends App {
////
////  val b = new EMFBuilder(EcorePackage.eINSTANCE)
////  import b._
////
////  //  val myPkg = b.epackage[EPackage]("pkg").apply()
////  val myPkg = b.create[EPackage]
////  myPkg {
////    myPkg.getNsPrefix()
////  }
////  //  {
////  //    eclass("clazz") {
////  //      ereference("a")
////  //      ereference("b")
////  //    }
////  //    eclass("clazz2") init { c =>
////  //      c.setName("clazz2Ex")
////  //    }
////  //    eclass("clazz3") {
////  //      name = "clazz3Ex"
////  //    }
////  //    eclass("clazz4") {
////  //      container[EClass].setName("clazz4Ex")
////  //    }
////  //  }
////
////  print(myPkg)
////
////  def print(obj: EObject, indent: Int = 0) {
////    println(" " * indent + obj)
////    obj.eContents foreach (print(_, indent + 2))
////  }
////
////}

package org.eclipse.emf.ecore.scala

import fr.unice.i3s.sigma.scala.construct.EMFBuilder;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.Enumerator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;

import scala.collection.JavaConversions._
import fr.unice.i3s.sigma.scala.utils._

class EcoreBuilder extends EMFBuilder(EcorePackage.eINSTANCE) {
  def eAttribute(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null,
    changeable: Boolean = true,
    volatile: Boolean = false,
    transient: Boolean = false,
    defaultValueLiteral: String = null,
    unsettable: Boolean = false,
    derived: Boolean = false,
    iD: Boolean = false): EAttribute = {

    val obj = create[EAttribute]

    // set containment
    container[EAttribute] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setOrdered, ordered, true)
    setNotDefault(obj.setUnique, unique, true)
    setNotDefault(obj.setLowerBound, lowerBound, 0)
    setNotDefault(obj.setUpperBound, upperBound, 1)
    setNotDefault(obj.setEType, eType, null)
    setNotDefault(obj.setEGenericType, eGenericType, null)
    setNotDefault(obj.setChangeable, changeable, true)
    setNotDefault(obj.setVolatile, volatile, false)
    setNotDefault(obj.setTransient, transient, false)
    setNotDefault(obj.setDefaultValueLiteral, defaultValueLiteral, null)
    setNotDefault(obj.setUnsettable, unsettable, false)
    setNotDefault(obj.setDerived, derived, false)
    setNotDefault(obj.setID, iD, false)

    obj
  }

  def eAnnotation(
    eAnnotations: List[EAnnotation] = Nil,
    source: String = null,
    details: Map[String, String] = Map.empty,
    eModelElement: EModelElement = null,
    contents: List[EObject] = Nil,
    references: List[EObject] = Nil): EAnnotation = {

    val obj = create[EAnnotation]

    // set containment
    container[EAnnotation] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setSource, source, null)
    obj.getDetails ++= details
    setNotDefault(obj.setEModelElement, eModelElement, null)
    obj.getContents ++= contents
    obj.getReferences ++= references

    obj
  }

  def eClass(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    instanceClassName: String = null,
    instanceTypeName: String = null,
    eTypeParameters: List[ETypeParameter] = Nil,
    `abstract`: Boolean = false,
    interface: Boolean = false,
    eSuperTypes: List[EClass] = Nil,
    eOperations: List[EOperation] = Nil,
    eStructuralFeatures: List[EStructuralFeature] = Nil,
    eGenericSuperTypes: List[EGenericType] = Nil): EClass = {

    val obj = create[EClass]

    // set containment
    container[EClass] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setInstanceClassName, instanceClassName, null)
    setNotDefault(obj.setInstanceTypeName, instanceTypeName, null)
    obj.getETypeParameters ++= eTypeParameters
    setNotDefault(obj.setAbstract, `abstract`, false)
    setNotDefault(obj.setInterface, interface, false)
    obj.getESuperTypes ++= eSuperTypes
    obj.getEOperations ++= eOperations
    obj.getEStructuralFeatures ++= eStructuralFeatures
    obj.getEGenericSuperTypes ++= eGenericSuperTypes

    obj
  }

  def eDataType(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    instanceClassName: String = null,
    instanceTypeName: String = null,
    eTypeParameters: List[ETypeParameter] = Nil,
    serializable: Boolean = true): EDataType = {

    val obj = create[EDataType]

    // set containment
    container[EDataType] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setInstanceClassName, instanceClassName, null)
    setNotDefault(obj.setInstanceTypeName, instanceTypeName, null)
    obj.getETypeParameters ++= eTypeParameters
    setNotDefault(obj.setSerializable, serializable, true)

    obj
  }

  def eEnum(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    instanceClassName: String = null,
    instanceTypeName: String = null,
    eTypeParameters: List[ETypeParameter] = Nil,
    serializable: Boolean = true,
    eLiterals: List[EEnumLiteral] = Nil): EEnum = {

    val obj = create[EEnum]

    // set containment
    container[EEnum] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setInstanceClassName, instanceClassName, null)
    setNotDefault(obj.setInstanceTypeName, instanceTypeName, null)
    obj.getETypeParameters ++= eTypeParameters
    setNotDefault(obj.setSerializable, serializable, true)
    obj.getELiterals ++= eLiterals

    obj
  }

  def eEnumLiteral(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    value: Int = 0,
    instance: Enumerator = null,
    literal: String = null): EEnumLiteral = {

    val obj = create[EEnumLiteral]

    // set containment
    container[EEnumLiteral] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setValue, value, 0)
    setNotDefault(obj.setInstance, instance, null)
    setNotDefault(obj.setLiteral, literal, null)

    obj
  }

  def eFactory(
    eAnnotations: List[EAnnotation] = Nil,
    ePackage: EPackage = null): EFactory = {

    val obj = create[EFactory]

    // set containment
    container[EFactory] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setEPackage, ePackage, null)

    obj
  }

  def eObject(): EObject = {

    val obj = create[EObject]

    // set containment
    container[EObject] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties

    obj
  }

  def eOperation(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null,
    eTypeParameters: List[ETypeParameter] = Nil,
    eParameters: List[EParameter] = Nil,
    eExceptions: List[EClassifier] = Nil,
    eGenericExceptions: List[EGenericType] = Nil): EOperation = {

    val obj = create[EOperation]

    // set containment
    container[EOperation] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setOrdered, ordered, true)
    setNotDefault(obj.setUnique, unique, true)
    setNotDefault(obj.setLowerBound, lowerBound, 0)
    setNotDefault(obj.setUpperBound, upperBound, 1)
    setNotDefault(obj.setEType, eType, null)
    setNotDefault(obj.setEGenericType, eGenericType, null)
    obj.getETypeParameters ++= eTypeParameters
    obj.getEParameters ++= eParameters
    obj.getEExceptions ++= eExceptions
    obj.getEGenericExceptions ++= eGenericExceptions

    obj
  }

  def ePackage(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    nsURI: String = null,
    nsPrefix: String = null,
    eFactoryInstance: EFactory = null,
    eClassifiers: List[EClassifier] = Nil,
    eSubpackages: List[EPackage] = Nil): EPackage = {

    val obj = create[EPackage]

    // set containment
    container[EPackage] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setNsURI, nsURI, null)
    setNotDefault(obj.setNsPrefix, nsPrefix, null)
    setNotDefault(obj.setEFactoryInstance, eFactoryInstance, null)
    obj.getEClassifiers ++= eClassifiers
    obj.getESubpackages ++= eSubpackages

    obj
  }

  def eParameter(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null): EParameter = {

    val obj = create[EParameter]

    // set containment
    container[EParameter] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setOrdered, ordered, true)
    setNotDefault(obj.setUnique, unique, true)
    setNotDefault(obj.setLowerBound, lowerBound, 0)
    setNotDefault(obj.setUpperBound, upperBound, 1)
    setNotDefault(obj.setEType, eType, null)
    setNotDefault(obj.setEGenericType, eGenericType, null)

    obj
  }

  def eReference(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null,
    changeable: Boolean = true,
    volatile: Boolean = false,
    transient: Boolean = false,
    defaultValueLiteral: String = null,
    unsettable: Boolean = false,
    derived: Boolean = false,
    containment: Boolean = false,
    resolveProxies: Boolean = true,
    eOpposite: EReference = null,
    eKeys: List[EAttribute] = Nil): EReference = {

    val obj = create[EReference]

    // set containment
    container[EReference] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setOrdered, ordered, true)
    setNotDefault(obj.setUnique, unique, true)
    setNotDefault(obj.setLowerBound, lowerBound, 0)
    setNotDefault(obj.setUpperBound, upperBound, 1)
    setNotDefault(obj.setEType, eType, null)
    setNotDefault(obj.setEGenericType, eGenericType, null)
    setNotDefault(obj.setChangeable, changeable, true)
    setNotDefault(obj.setVolatile, volatile, false)
    setNotDefault(obj.setTransient, transient, false)
    setNotDefault(obj.setDefaultValueLiteral, defaultValueLiteral, null)
    setNotDefault(obj.setUnsettable, unsettable, false)
    setNotDefault(obj.setDerived, derived, false)
    setNotDefault(obj.setContainment, containment, false)
    setNotDefault(obj.setResolveProxies, resolveProxies, true)
    setNotDefault(obj.setEOpposite, eOpposite, null)
    obj.getEKeys ++= eKeys

    obj
  }

  def eGenericType(
    eUpperBound: EGenericType = null,
    eTypeArguments: List[EGenericType] = Nil,
    eLowerBound: EGenericType = null,
    eTypeParameter: ETypeParameter = null,
    eClassifier: EClassifier = null): EGenericType = {

    val obj = create[EGenericType]

    // set containment
    container[EGenericType] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    setNotDefault(obj.setEUpperBound, eUpperBound, null)
    obj.getETypeArguments ++= eTypeArguments
    setNotDefault(obj.setELowerBound, eLowerBound, null)
    setNotDefault(obj.setETypeParameter, eTypeParameter, null)
    setNotDefault(obj.setEClassifier, eClassifier, null)

    obj
  }

  def eTypeParameter(
    eAnnotations: List[EAnnotation] = Nil,
    name: String = null,
    eBounds: List[EGenericType] = Nil): ETypeParameter = {

    val obj = create[ETypeParameter]

    // set containment
    container[ETypeParameter] match {
      case Some(list) ⇒ list += obj
      case None ⇒
    }

    // set properties
    obj.getEAnnotations ++= eAnnotations
    setNotDefault(obj.setName, name, null)
    obj.getEBounds ++= eBounds

    obj
  }

  def details: EMap[String, String] = self[EAnnotation] match {

    case Some(e) ⇒ e.getDetails
    case None ⇒ throw new IllegalStateException("No EAnnotation context found")

  }

  def contents: EList[EObject] = self[EAnnotation] match {

    case Some(e) ⇒ e.getContents
    case None ⇒ throw new IllegalStateException("No EAnnotation context found")

  }

  def eOperations: EList[EOperation] = self[EClass] match {

    case Some(e) ⇒ e.getEOperations
    case None ⇒ throw new IllegalStateException("No EClass context found")

  }

  def eStructuralFeatures: EList[EStructuralFeature] = self[EClass] match {

    case Some(e) ⇒ e.getEStructuralFeatures
    case None ⇒ throw new IllegalStateException("No EClass context found")

  }

  def eGenericSuperTypes: EList[EGenericType] = self[EClass] match {

    case Some(e) ⇒ e.getEGenericSuperTypes
    case None ⇒ throw new IllegalStateException("No EClass context found")

  }

  def eLiterals: EList[EEnumLiteral] = self[EEnum] match {

    case Some(e) ⇒ e.getELiterals
    case None ⇒ throw new IllegalStateException("No EEnum context found")

  }

  def eTypeParameters: EList[ETypeParameter] = self[EOperation] match {

    case Some(e) ⇒ e.getETypeParameters
    case None ⇒ throw new IllegalStateException("No EOperation context found")

  }

  def eParameters: EList[EParameter] = self[EOperation] match {

    case Some(e) ⇒ e.getEParameters
    case None ⇒ throw new IllegalStateException("No EOperation context found")

  }

  def eGenericExceptions: EList[EGenericType] = self[EOperation] match {

    case Some(e) ⇒ e.getEGenericExceptions
    case None ⇒ throw new IllegalStateException("No EOperation context found")

  }

  def eClassifiers: EList[EClassifier] = self[EPackage] match {

    case Some(e) ⇒ e.getEClassifiers
    case None ⇒ throw new IllegalStateException("No EPackage context found")

  }

  def eSubpackages: EList[EPackage] = self[EPackage] match {

    case Some(e) ⇒ e.getESubpackages
    case None ⇒ throw new IllegalStateException("No EPackage context found")

  }

  def eUpperBound: EGenericType = self[EGenericType] match {

    case Some(e) ⇒ e.getEUpperBound
    case None ⇒ throw new IllegalStateException("No EGenericType context found")

  }

  def eTypeArguments: EList[EGenericType] = self[EGenericType] match {

    case Some(e) ⇒ e.getETypeArguments
    case None ⇒ throw new IllegalStateException("No EGenericType context found")

  }

  def eLowerBound: EGenericType = self[EGenericType] match {

    case Some(e) ⇒ e.getELowerBound
    case None ⇒ throw new IllegalStateException("No EGenericType context found")

  }

  def eBounds: EList[EGenericType] = self[ETypeParameter] match {

    case Some(e) ⇒ e.getEBounds
    case None ⇒ throw new IllegalStateException("No ETypeParameter context found")

  }
}
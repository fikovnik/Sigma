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

class EcoreBuilder extends EMFBuilder(EcorePackage.eINSTANCE) {
  def eAttribute(
    eAnnotations: EList[EAnnotation] = null,
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

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
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
    eAnnotations: EList[EAnnotation] = null,
    source: String = null,
    details: EMap[String, String] = null,
    eModelElement: EModelElement = null,
    contents: EList[EObject] = null,
    references: EList[EObject] = null): EAnnotation = {

    val obj = create[EAnnotation]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setSource, source, null)
    setNotEmpty(obj.getDetails, details)
    setNotDefault(obj.setEModelElement, eModelElement, null)
    setNotEmpty(obj.getContents, contents)
    setNotEmpty(obj.getReferences, references)

    obj
  }

  def eClass(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    instanceClassName: String = null,
    instanceTypeName: String = null,
    eTypeParameters: EList[ETypeParameter] = null,
    `abstract`: Boolean = false,
    interface: Boolean = false,
    eSuperTypes: EList[EClass] = null,
    eOperations: EList[EOperation] = null,
    eStructuralFeatures: EList[EStructuralFeature] = null,
    eGenericSuperTypes: EList[EGenericType] = null): EClass = {

    val obj = create[EClass]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setInstanceClassName, instanceClassName, null)
    setNotDefault(obj.setInstanceTypeName, instanceTypeName, null)
    setNotEmpty(obj.getETypeParameters, eTypeParameters)
    setNotDefault(obj.setAbstract, `abstract`, false)
    setNotDefault(obj.setInterface, interface, false)
    setNotEmpty(obj.getESuperTypes, eSuperTypes)
    setNotEmpty(obj.getEOperations, eOperations)
    setNotEmpty(obj.getEStructuralFeatures, eStructuralFeatures)
    setNotEmpty(obj.getEGenericSuperTypes, eGenericSuperTypes)

    obj
  }

  def eDataType(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    instanceClassName: String = null,
    instanceTypeName: String = null,
    eTypeParameters: EList[ETypeParameter] = null,
    serializable: Boolean = true): EDataType = {

    val obj = create[EDataType]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setInstanceClassName, instanceClassName, null)
    setNotDefault(obj.setInstanceTypeName, instanceTypeName, null)
    setNotEmpty(obj.getETypeParameters, eTypeParameters)
    setNotDefault(obj.setSerializable, serializable, true)

    obj
  }

  def eEnum(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    instanceClassName: String = null,
    instanceTypeName: String = null,
    eTypeParameters: EList[ETypeParameter] = null,
    serializable: Boolean = true,
    eLiterals: EList[EEnumLiteral] = null): EEnum = {

    val obj = create[EEnum]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setInstanceClassName, instanceClassName, null)
    setNotDefault(obj.setInstanceTypeName, instanceTypeName, null)
    setNotEmpty(obj.getETypeParameters, eTypeParameters)
    setNotDefault(obj.setSerializable, serializable, true)
    setNotEmpty(obj.getELiterals, eLiterals)

    obj
  }

  def eEnumLiteral(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    value: Int = 0,
    instance: Enumerator = null,
    literal: String = null): EEnumLiteral = {

    val obj = create[EEnumLiteral]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setValue, value, 0)
    setNotDefault(obj.setInstance, instance, null)
    setNotDefault(obj.setLiteral, literal, null)

    obj
  }

  def eFactory(
    eAnnotations: EList[EAnnotation] = null,
    ePackage: EPackage = null): EFactory = {

    val obj = create[EFactory]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setEPackage, ePackage, null)

    obj
  }

  def eObject(): EObject = {

    val obj = create[EObject]

    // set properties

    obj
  }

  def eOperation(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null,
    eTypeParameters: EList[ETypeParameter] = null,
    eParameters: EList[EParameter] = null,
    eExceptions: EList[EClassifier] = null,
    eGenericExceptions: EList[EGenericType] = null): EOperation = {

    val obj = create[EOperation]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setOrdered, ordered, true)
    setNotDefault(obj.setUnique, unique, true)
    setNotDefault(obj.setLowerBound, lowerBound, 0)
    setNotDefault(obj.setUpperBound, upperBound, 1)
    setNotDefault(obj.setEType, eType, null)
    setNotDefault(obj.setEGenericType, eGenericType, null)
    setNotEmpty(obj.getETypeParameters, eTypeParameters)
    setNotEmpty(obj.getEParameters, eParameters)
    setNotEmpty(obj.getEExceptions, eExceptions)
    setNotEmpty(obj.getEGenericExceptions, eGenericExceptions)

    obj
  }

  def ePackage(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    nsURI: String = null,
    nsPrefix: String = null,
    eFactoryInstance: EFactory = null,
    eClassifiers: EList[EClassifier] = null,
    eSubpackages: EList[EPackage] = null): EPackage = {

    val obj = create[EPackage]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setName, name, null)
    setNotDefault(obj.setNsURI, nsURI, null)
    setNotDefault(obj.setNsPrefix, nsPrefix, null)
    setNotDefault(obj.setEFactoryInstance, eFactoryInstance, null)
    setNotEmpty(obj.getEClassifiers, eClassifiers)
    setNotEmpty(obj.getESubpackages, eSubpackages)

    obj
  }

  def eParameter(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    ordered: Boolean = true,
    unique: Boolean = true,
    lowerBound: Int = 0,
    upperBound: Int = 1,
    eType: EClassifier = null,
    eGenericType: EGenericType = null): EParameter = {

    val obj = create[EParameter]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
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
    eAnnotations: EList[EAnnotation] = null,
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
    eKeys: EList[EAttribute] = null): EReference = {

    val obj = create[EReference]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
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
    setNotEmpty(obj.getEKeys, eKeys)

    obj
  }

  def eGenericType(
    eUpperBound: EGenericType = null,
    eTypeArguments: EList[EGenericType] = null,
    eLowerBound: EGenericType = null,
    eTypeParameter: ETypeParameter = null,
    eClassifier: EClassifier = null): EGenericType = {

    val obj = create[EGenericType]

    // set properties
    setNotDefault(obj.setEUpperBound, eUpperBound, null)
    setNotEmpty(obj.getETypeArguments, eTypeArguments)
    setNotDefault(obj.setELowerBound, eLowerBound, null)
    setNotDefault(obj.setETypeParameter, eTypeParameter, null)
    setNotDefault(obj.setEClassifier, eClassifier, null)

    obj
  }

  def eTypeParameter(
    eAnnotations: EList[EAnnotation] = null,
    name: String = null,
    eBounds: EList[EGenericType] = null): ETypeParameter = {

    val obj = create[ETypeParameter]

    // set properties
    setNotEmpty(obj.getEAnnotations, eAnnotations)
    setNotDefault(obj.setName, name, null)
    setNotEmpty(obj.getEBounds, eBounds)

    obj
  }
}
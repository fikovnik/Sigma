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
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;

class EcoreBuilder extends EMFBuilder(EcorePackage.eINSTANCE) {
  def eAttribute(config: (EAttribute => Any)*): EAttribute = build[EAttribute](config: _*)
  
  def eAnnotation(config: (EAnnotation => Any)*): EAnnotation = build[EAnnotation](config: _*)
  
  def eClass(config: (EClass => Any)*): EClass = build[EClass](config: _*)
  
  def eDataType(config: (EDataType => Any)*): EDataType = build[EDataType](config: _*)
  
  def eEnum(config: (EEnum => Any)*): EEnum = build[EEnum](config: _*)
  
  def eEnumLiteral(config: (EEnumLiteral => Any)*): EEnumLiteral = build[EEnumLiteral](config: _*)
  
  def eFactory(config: (EFactory => Any)*): EFactory = build[EFactory](config: _*)
  
  def eObject(config: (EObject => Any)*): EObject = build[EObject](config: _*)
  
  def eOperation(config: (EOperation => Any)*): EOperation = build[EOperation](config: _*)
  
  def ePackage(config: (EPackage => Any)*): EPackage = build[EPackage](config: _*)
  
  def eParameter(config: (EParameter => Any)*): EParameter = build[EParameter](config: _*)
  
  def eReference(config: (EReference => Any)*): EReference = build[EReference](config: _*)
  
  def eGenericType(config: (EGenericType => Any)*): EGenericType = build[EGenericType](config: _*)
  
  def eTypeParameter(config: (ETypeParameter => Any)*): ETypeParameter = build[ETypeParameter](config: _*)
}

trait EcoreAssignments extends OverloadHack {
  private def nothing: Nothing = sys.error("this method is not meant to be called")
  def eSuperTypes(implicit ev: Nothing) = nothing
  def eSuperTypes_=[T <: EClass](value: EList[EClass]) =
    (target: T) ⇒ target.getESuperTypes.addAll(value)
  
  
  def name(implicit ev: Nothing) = nothing
  def name_=[T <: ENamedElement](value: String) =
    (target: T) ⇒ target.setName(value)
  
  
  def resolveProxies(implicit ev: Nothing) = nothing
  def resolveProxies_=[T <: EReference](value: Boolean) =
    (target: T) ⇒ target.setResolveProxies(value)
  
  
  def source(implicit ev: Nothing) = nothing
  def source_=[T <: EAnnotation](value: String) =
    (target: T) ⇒ target.setSource(value)
  
  
  def eParameters(implicit ev: Nothing) = nothing
  def eParameters_=[T <: EOperation](value: EList[EParameter]) =
    (target: T) ⇒ target.getEParameters.addAll(value)
  
  
  def eGenericExceptions(implicit ev: Nothing) = nothing
  def eGenericExceptions_=[T <: EOperation](value: EList[EGenericType]) =
    (target: T) ⇒ target.getEGenericExceptions.addAll(value)
  
  
  def lowerBound(implicit ev: Nothing) = nothing
  def lowerBound_=[T <: ETypedElement](value: Int) =
    (target: T) ⇒ target.setLowerBound(value)
  
  
  def volatile(implicit ev: Nothing) = nothing
  def volatile_=[T <: EStructuralFeature](value: Boolean) =
    (target: T) ⇒ target.setVolatile(value)
  
  
  def eTypeParameters(implicit ev: Nothing) = nothing
  def eTypeParameters_=[T <: EClassifier](value: EList[ETypeParameter]) =
    (target: T) ⇒ target.getETypeParameters.addAll(value)
  
  def eTypeParameters_=[T <: EOperation](value: EList[ETypeParameter])(implicit o: Overloaded1) =
    (target: T) ⇒ target.getETypeParameters.addAll(value)
  
  
  def instanceTypeName(implicit ev: Nothing) = nothing
  def instanceTypeName_=[T <: EClassifier](value: String) =
    (target: T) ⇒ target.setInstanceTypeName(value)
  
  
  def eLowerBound(implicit ev: Nothing) = nothing
  def eLowerBound_=[T <: EGenericType](value: EGenericType) =
    (target: T) ⇒ target.setELowerBound(value)
  
  
  def eOperations(implicit ev: Nothing) = nothing
  def eOperations_=[T <: EClass](value: EList[EOperation]) =
    (target: T) ⇒ target.getEOperations.addAll(value)
  
  
  def derived(implicit ev: Nothing) = nothing
  def derived_=[T <: EStructuralFeature](value: Boolean) =
    (target: T) ⇒ target.setDerived(value)
  
  
  def eUpperBound(implicit ev: Nothing) = nothing
  def eUpperBound_=[T <: EGenericType](value: EGenericType) =
    (target: T) ⇒ target.setEUpperBound(value)
  
  
  def interface(implicit ev: Nothing) = nothing
  def interface_=[T <: EClass](value: Boolean) =
    (target: T) ⇒ target.setInterface(value)
  
  
  def `abstract`(implicit ev: Nothing) = nothing
  def abstract_=[T <: EClass](value: Boolean) =
    (target: T) ⇒ target.setAbstract(value)
  
  
  def eFactoryInstance(implicit ev: Nothing) = nothing
  def eFactoryInstance_=[T <: EPackage](value: EFactory) =
    (target: T) ⇒ target.setEFactoryInstance(value)
  
  
  def eExceptions(implicit ev: Nothing) = nothing
  def eExceptions_=[T <: EOperation](value: EList[EClassifier]) =
    (target: T) ⇒ target.getEExceptions.addAll(value)
  
  
  def containment(implicit ev: Nothing) = nothing
  def containment_=[T <: EReference](value: Boolean) =
    (target: T) ⇒ target.setContainment(value)
  
  
  def eModelElement(implicit ev: Nothing) = nothing
  def eModelElement_=[T <: EAnnotation](value: EModelElement) =
    (target: T) ⇒ target.setEModelElement(value)
  
  
  def eSubpackages(implicit ev: Nothing) = nothing
  def eSubpackages_=[T <: EPackage](value: EList[EPackage]) =
    (target: T) ⇒ target.getESubpackages.addAll(value)
  
  
  def eAnnotations(implicit ev: Nothing) = nothing
  def eAnnotations_=[T <: EModelElement](value: EList[EAnnotation]) =
    (target: T) ⇒ target.getEAnnotations.addAll(value)
  
  
  def instance(implicit ev: Nothing) = nothing
  def instance_=[T <: EEnumLiteral](value: Enumerator) =
    (target: T) ⇒ target.setInstance(value)
  
  
  def eLiterals(implicit ev: Nothing) = nothing
  def eLiterals_=[T <: EEnum](value: EList[EEnumLiteral]) =
    (target: T) ⇒ target.getELiterals.addAll(value)
  
  
  def eClassifier(implicit ev: Nothing) = nothing
  def eClassifier_=[T <: EGenericType](value: EClassifier) =
    (target: T) ⇒ target.setEClassifier(value)
  
  
  def ordered(implicit ev: Nothing) = nothing
  def ordered_=[T <: ETypedElement](value: Boolean) =
    (target: T) ⇒ target.setOrdered(value)
  
  
  def instanceClassName(implicit ev: Nothing) = nothing
  def instanceClassName_=[T <: EClassifier](value: String) =
    (target: T) ⇒ target.setInstanceClassName(value)
  
  
  def eOpposite(implicit ev: Nothing) = nothing
  def eOpposite_=[T <: EReference](value: EReference) =
    (target: T) ⇒ target.setEOpposite(value)
  
  
  def contents(implicit ev: Nothing) = nothing
  def contents_=[T <: EAnnotation](value: EList[EObject]) =
    (target: T) ⇒ target.getContents.addAll(value)
  
  
  def eKeys(implicit ev: Nothing) = nothing
  def eKeys_=[T <: EReference](value: EList[EAttribute]) =
    (target: T) ⇒ target.getEKeys.addAll(value)
  
  
  def upperBound(implicit ev: Nothing) = nothing
  def upperBound_=[T <: ETypedElement](value: Int) =
    (target: T) ⇒ target.setUpperBound(value)
  
  
  def unsettable(implicit ev: Nothing) = nothing
  def unsettable_=[T <: EStructuralFeature](value: Boolean) =
    (target: T) ⇒ target.setUnsettable(value)
  
  
  def eClassifiers(implicit ev: Nothing) = nothing
  def eClassifiers_=[T <: EPackage](value: EList[EClassifier]) =
    (target: T) ⇒ target.getEClassifiers.addAll(value)
  
  
  def nsPrefix(implicit ev: Nothing) = nothing
  def nsPrefix_=[T <: EPackage](value: String) =
    (target: T) ⇒ target.setNsPrefix(value)
  
  
  def eStructuralFeatures(implicit ev: Nothing) = nothing
  def eStructuralFeatures_=[T <: EClass](value: EList[EStructuralFeature]) =
    (target: T) ⇒ target.getEStructuralFeatures.addAll(value)
  
  
  def references(implicit ev: Nothing) = nothing
  def references_=[T <: EAnnotation](value: EList[EObject]) =
    (target: T) ⇒ target.getReferences.addAll(value)
  
  
  def eTypeArguments(implicit ev: Nothing) = nothing
  def eTypeArguments_=[T <: EGenericType](value: EList[EGenericType]) =
    (target: T) ⇒ target.getETypeArguments.addAll(value)
  
  
  def serializable(implicit ev: Nothing) = nothing
  def serializable_=[T <: EDataType](value: Boolean) =
    (target: T) ⇒ target.setSerializable(value)
  
  
  def details(implicit ev: Nothing) = nothing
  def details_=[T <: EAnnotation](value: EMap[String, String]) =
    (target: T) ⇒ target.getDetails.addAll(value)
  
  
  def literal(implicit ev: Nothing) = nothing
  def literal_=[T <: EEnumLiteral](value: String) =
    (target: T) ⇒ target.setLiteral(value)
  
  
  def transient(implicit ev: Nothing) = nothing
  def transient_=[T <: EStructuralFeature](value: Boolean) =
    (target: T) ⇒ target.setTransient(value)
  
  
  def eType(implicit ev: Nothing) = nothing
  def eType_=[T <: ETypedElement](value: EClassifier) =
    (target: T) ⇒ target.setEType(value)
  
  
  def changeable(implicit ev: Nothing) = nothing
  def changeable_=[T <: EStructuralFeature](value: Boolean) =
    (target: T) ⇒ target.setChangeable(value)
  
  
  def eGenericSuperTypes(implicit ev: Nothing) = nothing
  def eGenericSuperTypes_=[T <: EClass](value: EList[EGenericType]) =
    (target: T) ⇒ target.getEGenericSuperTypes.addAll(value)
  
  
  def eBounds(implicit ev: Nothing) = nothing
  def eBounds_=[T <: ETypeParameter](value: EList[EGenericType]) =
    (target: T) ⇒ target.getEBounds.addAll(value)
  
  
  def value(implicit ev: Nothing) = nothing
  def value_=[T <: EEnumLiteral](value: Int) =
    (target: T) ⇒ target.setValue(value)
  
  
  def iD(implicit ev: Nothing) = nothing
  def iD_=[T <: EAttribute](value: Boolean) =
    (target: T) ⇒ target.setID(value)
  
  
  def unique(implicit ev: Nothing) = nothing
  def unique_=[T <: ETypedElement](value: Boolean) =
    (target: T) ⇒ target.setUnique(value)
  
  
  def defaultValueLiteral(implicit ev: Nothing) = nothing
  def defaultValueLiteral_=[T <: EStructuralFeature](value: String) =
    (target: T) ⇒ target.setDefaultValueLiteral(value)
  
  
  def nsURI(implicit ev: Nothing) = nothing
  def nsURI_=[T <: EPackage](value: String) =
    (target: T) ⇒ target.setNsURI(value)
}

trait OverloadHack {
  class Overloaded1
  implicit val overload1 = new Overloaded1
}

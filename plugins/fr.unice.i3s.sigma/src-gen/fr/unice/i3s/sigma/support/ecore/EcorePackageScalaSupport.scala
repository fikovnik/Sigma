package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.m2m.Transformable;

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;
import fr.unice.i3s.sigma.support.SigmaEcorePackage;

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

import scala.Option;


trait EcorePackageScalaSupport
  extends EMFScalaSupport {
    
    implicit class EAttribute2Sigma(that: EAttribute) {
      def iD: Boolean = that.isID
      def iD_=(value: Boolean): Unit = that.setID(value)
      def eAttributeType: EDataType = that.getEAttributeType
    }
    
    implicit class EAnnotation2Sigma(that: EAnnotation) {
      def source: String = that.getSource
      def source_=(value: String): Unit = that.setSource(value)
      def details: EMap[String, String] = that.getDetails
      def eModelElement: EModelElement = that.getEModelElement
      def eModelElement_=(value: EModelElement): Unit = that.setEModelElement(value)
      def eModelElement_=(value: Transformable): Unit = value.transform[EModelElement].foreach(that.setEModelElement(_))
      def eModelElement_=(value: ⇒ Option[EModelElement]): Unit =
        that.setEModelElement(EcorePackageScalaSupport._ecoreBuilder.ref(value))
      def contents: EList[EObject] = that.getContents
      def references: EList[EObject] = that.getReferences
    }
    
    implicit class EClass2Sigma(that: EClass) {
      def abstract_ : Boolean = that.isAbstract
      def abstract__=(value: Boolean): Unit = that.setAbstract(value)
      def interface: Boolean = that.isInterface
      def interface_=(value: Boolean): Unit = that.setInterface(value)
      def eSuperTypes: EList[EClass] = that.getESuperTypes
      def eOperations: EList[EOperation] = that.getEOperations
      def eAllAttributes: EList[EAttribute] = that.getEAllAttributes
      def eAllReferences: EList[EReference] = that.getEAllReferences
      def eReferences: EList[EReference] = that.getEReferences
      def eAttributes: EList[EAttribute] = that.getEAttributes
      def eAllContainments: EList[EReference] = that.getEAllContainments
      def eAllOperations: EList[EOperation] = that.getEAllOperations
      def eAllStructuralFeatures: EList[EStructuralFeature] = that.getEAllStructuralFeatures
      def eAllSuperTypes: EList[EClass] = that.getEAllSuperTypes
      def eIDAttribute: EAttribute = that.getEIDAttribute
      def eStructuralFeatures: EList[EStructuralFeature] = that.getEStructuralFeatures
      def eGenericSuperTypes: EList[EGenericType] = that.getEGenericSuperTypes
      def eAllGenericSuperTypes: EList[EGenericType] = that.getEAllGenericSuperTypes
    }
    
    implicit class EClassifier2Sigma(that: EClassifier) {
      def instanceClassName: String = that.getInstanceClassName
      def instanceClassName_=(value: String): Unit = that.setInstanceClassName(value)
      def instanceClass: Class[_] = that.getInstanceClass
      def defaultValue: Object = that.getDefaultValue
      def instanceTypeName: String = that.getInstanceTypeName
      def instanceTypeName_=(value: String): Unit = that.setInstanceTypeName(value)
      def ePackage: EPackage = that.getEPackage
      def eTypeParameters: EList[ETypeParameter] = that.getETypeParameters
    }
    
    implicit class EDataType2Sigma(that: EDataType) {
      def serializable: Boolean = that.isSerializable
      def serializable_=(value: Boolean): Unit = that.setSerializable(value)
    }
    
    implicit class EEnum2Sigma(that: EEnum) {
      def eLiterals: EList[EEnumLiteral] = that.getELiterals
    }
    
    implicit class EEnumLiteral2Sigma(that: EEnumLiteral) {
      def value: Int = that.getValue
      def value_=(value: Int): Unit = that.setValue(value)
      def instance: Enumerator = that.getInstance
      def instance_=(value: Enumerator): Unit = that.setInstance(value)
      def literal: String = that.getLiteral
      def literal_=(value: String): Unit = that.setLiteral(value)
      def eEnum: EEnum = that.getEEnum
    }
    
    implicit class EFactory2Sigma(that: EFactory) {
      def ePackage: EPackage = that.getEPackage
      def ePackage_=(value: EPackage): Unit = that.setEPackage(value)
      def ePackage_=(value: Transformable): Unit = value.transform[EPackage].foreach(that.setEPackage(_))
      def ePackage_=(value: ⇒ Option[EPackage]): Unit =
        that.setEPackage(EcorePackageScalaSupport._ecoreBuilder.ref(value))
    }
    
    implicit class EModelElement2Sigma(that: EModelElement) {
      def eAnnotations: EList[EAnnotation] = that.getEAnnotations
    }
    
    implicit class ENamedElement2Sigma(that: ENamedElement) {
      def name: String = that.getName
      def name_=(value: String): Unit = that.setName(value)
    }
    
    
    implicit class EOperation2Sigma(that: EOperation) {
      def eContainingClass: EClass = that.getEContainingClass
      def eTypeParameters: EList[ETypeParameter] = that.getETypeParameters
      def eParameters: EList[EParameter] = that.getEParameters
      def eExceptions: EList[EClassifier] = that.getEExceptions
      def eGenericExceptions: EList[EGenericType] = that.getEGenericExceptions
    }
    
    implicit class EPackage2Sigma(that: EPackage) {
      def nsURI: String = that.getNsURI
      def nsURI_=(value: String): Unit = that.setNsURI(value)
      def nsPrefix: String = that.getNsPrefix
      def nsPrefix_=(value: String): Unit = that.setNsPrefix(value)
      def eFactoryInstance: EFactory = that.getEFactoryInstance
      def eFactoryInstance_=(value: EFactory): Unit = that.setEFactoryInstance(value)
      def eFactoryInstance_=(value: Transformable): Unit = value.transform[EFactory].foreach(that.setEFactoryInstance(_))
      def eFactoryInstance_=(value: ⇒ Option[EFactory]): Unit =
        that.setEFactoryInstance(EcorePackageScalaSupport._ecoreBuilder.ref(value))
      def eClassifiers: EList[EClassifier] = that.getEClassifiers
      def eSubpackages: EList[EPackage] = that.getESubpackages
      def eSuperPackage: EPackage = that.getESuperPackage
    }
    
    implicit class EParameter2Sigma(that: EParameter) {
      def eOperation: EOperation = that.getEOperation
    }
    
    implicit class EReference2Sigma(that: EReference) {
      def containment: Boolean = that.isContainment
      def containment_=(value: Boolean): Unit = that.setContainment(value)
      def container: Boolean = that.isContainer
      def resolveProxies: Boolean = that.isResolveProxies
      def resolveProxies_=(value: Boolean): Unit = that.setResolveProxies(value)
      def eOpposite: EReference = that.getEOpposite
      def eOpposite_=(value: EReference): Unit = that.setEOpposite(value)
      def eOpposite_=(value: Transformable): Unit = value.transform[EReference].foreach(that.setEOpposite(_))
      def eOpposite_=(value: ⇒ Option[EReference]): Unit =
        that.setEOpposite(EcorePackageScalaSupport._ecoreBuilder.ref(value))
      def eReferenceType: EClass = that.getEReferenceType
      def eKeys: EList[EAttribute] = that.getEKeys
    }
    
    implicit class EStructuralFeature2Sigma(that: EStructuralFeature) {
      def changeable: Boolean = that.isChangeable
      def changeable_=(value: Boolean): Unit = that.setChangeable(value)
      def volatile: Boolean = that.isVolatile
      def volatile_=(value: Boolean): Unit = that.setVolatile(value)
      def transient: Boolean = that.isTransient
      def transient_=(value: Boolean): Unit = that.setTransient(value)
      def defaultValueLiteral: String = that.getDefaultValueLiteral
      def defaultValueLiteral_=(value: String): Unit = that.setDefaultValueLiteral(value)
      def defaultValue: Object = that.getDefaultValue
      def unsettable: Boolean = that.isUnsettable
      def unsettable_=(value: Boolean): Unit = that.setUnsettable(value)
      def derived: Boolean = that.isDerived
      def derived_=(value: Boolean): Unit = that.setDerived(value)
      def eContainingClass: EClass = that.getEContainingClass
    }
    
    implicit class ETypedElement2Sigma(that: ETypedElement) {
      def ordered: Boolean = that.isOrdered
      def ordered_=(value: Boolean): Unit = that.setOrdered(value)
      def unique: Boolean = that.isUnique
      def unique_=(value: Boolean): Unit = that.setUnique(value)
      def lowerBound: Int = that.getLowerBound
      def lowerBound_=(value: Int): Unit = that.setLowerBound(value)
      def upperBound: Int = that.getUpperBound
      def upperBound_=(value: Int): Unit = that.setUpperBound(value)
      def many: Boolean = that.isMany
      def required: Boolean = that.isRequired
      def eType: EClassifier = that.getEType
      def eType_=(value: EClassifier): Unit = that.setEType(value)
      def eType_=(value: Transformable): Unit = value.transform[EClassifier].foreach(that.setEType(_))
      def eType_=(value: ⇒ Option[EClassifier]): Unit =
        that.setEType(EcorePackageScalaSupport._ecoreBuilder.ref(value))
      def eGenericType: EGenericType = that.getEGenericType
      def eGenericType_=(value: EGenericType): Unit = that.setEGenericType(value)
      def eGenericType_=(value: Transformable): Unit = value.transform[EGenericType].foreach(that.setEGenericType(_))
    }
    
    implicit class EGenericType2Sigma(that: EGenericType) {
      def eUpperBound: EGenericType = that.getEUpperBound
      def eUpperBound_=(value: EGenericType): Unit = that.setEUpperBound(value)
      def eUpperBound_=(value: Transformable): Unit = value.transform[EGenericType].foreach(that.setEUpperBound(_))
      def eTypeArguments: EList[EGenericType] = that.getETypeArguments
      def eRawType: EClassifier = that.getERawType
      def eLowerBound: EGenericType = that.getELowerBound
      def eLowerBound_=(value: EGenericType): Unit = that.setELowerBound(value)
      def eLowerBound_=(value: Transformable): Unit = value.transform[EGenericType].foreach(that.setELowerBound(_))
      def eTypeParameter: ETypeParameter = that.getETypeParameter
      def eTypeParameter_=(value: ETypeParameter): Unit = that.setETypeParameter(value)
      def eTypeParameter_=(value: Transformable): Unit = value.transform[ETypeParameter].foreach(that.setETypeParameter(_))
      def eTypeParameter_=(value: ⇒ Option[ETypeParameter]): Unit =
        that.setETypeParameter(EcorePackageScalaSupport._ecoreBuilder.ref(value))
      def eClassifier: EClassifier = that.getEClassifier
      def eClassifier_=(value: EClassifier): Unit = that.setEClassifier(value)
      def eClassifier_=(value: Transformable): Unit = value.transform[EClassifier].foreach(that.setEClassifier(_))
      def eClassifier_=(value: ⇒ Option[EClassifier]): Unit =
        that.setEClassifier(EcorePackageScalaSupport._ecoreBuilder.ref(value))
    }
    
    implicit class ETypeParameter2Sigma(that: ETypeParameter) {
      def eBounds: EList[EGenericType] = that.getEBounds
    }
    
    
    object _ecore extends SigmaEcorePackage[EcorePackage] with
      EAttributeScalaSupport with
      EAnnotationScalaSupport with
      EClassScalaSupport with
      EClassifierScalaSupport with
      EDataTypeScalaSupport with
      EEnumScalaSupport with
      EEnumLiteralScalaSupport with
      EFactoryScalaSupport with
      EModelElementScalaSupport with
      ENamedElementScalaSupport with
      EObjectScalaSupport with
      EOperationScalaSupport with
      EPackageScalaSupport with
      EParameterScalaSupport with
      EReferenceScalaSupport with
      EStructuralFeatureScalaSupport with
      ETypedElementScalaSupport with
      EGenericTypeScalaSupport with
      ETypeParameterScalaSupport {
      
      val ePackage = EcorePackage.eINSTANCE
      
      val EBigDecimal = ePackage.getEBigDecimal
      val EBigInteger = ePackage.getEBigInteger
      val EBoolean = ePackage.getEBoolean
      val EBooleanObject = ePackage.getEBooleanObject
      val EByte = ePackage.getEByte
      val EByteArray = ePackage.getEByteArray
      val EByteObject = ePackage.getEByteObject
      val EChar = ePackage.getEChar
      val ECharacterObject = ePackage.getECharacterObject
      val EDate = ePackage.getEDate
      val EDiagnosticChain = ePackage.getEDiagnosticChain
      val EDouble = ePackage.getEDouble
      val EDoubleObject = ePackage.getEDoubleObject
      val EEList = ePackage.getEEList
      val EEnumerator = ePackage.getEEnumerator
      val EFeatureMap = ePackage.getEFeatureMap
      val EFeatureMapEntry = ePackage.getEFeatureMapEntry
      val EFloat = ePackage.getEFloat
      val EFloatObject = ePackage.getEFloatObject
      val EInt = ePackage.getEInt
      val EIntegerObject = ePackage.getEIntegerObject
      val EJavaClass = ePackage.getEJavaClass
      val EJavaObject = ePackage.getEJavaObject
      val ELong = ePackage.getELong
      val ELongObject = ePackage.getELongObject
      val EMap = ePackage.getEMap
      val EResource = ePackage.getEResource
      val EResourceSet = ePackage.getEResourceSet
      val EShort = ePackage.getEShort
      val EShortObject = ePackage.getEShortObject
      val EString = ePackage.getEString
      val ETreeIterator = ePackage.getETreeIterator
      val EInvocationTargetException = ePackage.getEInvocationTargetException
    }
  }

object EcorePackageScalaSupport extends EcorePackageScalaSupport {
  private[this] val ePackage = EcorePackage.eINSTANCE
  
  protected[support] val _ecoreBuilder = new EMFBuilder(ePackage)
}

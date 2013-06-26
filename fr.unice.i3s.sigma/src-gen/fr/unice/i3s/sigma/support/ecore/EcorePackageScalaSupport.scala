package fr.unice.i3s.sigma.support.ecore

import fr.unice.i3s.sigma.support.EMFBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.ecore.EcorePackage;

trait EcorePackageScalaSupport
  extends EAttributeScalaSupport with
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
  ETypeParameterScalaSupport with
  EMFScalaSupport

object EcorePackageScalaSupport extends EcorePackageScalaSupport {
  private[this] val pkg = EcorePackage.eINSTANCE
  
  protected[support] val _ecoreBuilder = new EMFBuilder(pkg)
  
  val EBigDecimal = pkg.getEBigDecimal
  val EBigInteger = pkg.getEBigInteger
  val EBoolean = pkg.getEBoolean
  val EBooleanObject = pkg.getEBooleanObject
  val EByte = pkg.getEByte
  val EByteArray = pkg.getEByteArray
  val EByteObject = pkg.getEByteObject
  val EChar = pkg.getEChar
  val ECharacterObject = pkg.getECharacterObject
  val EDate = pkg.getEDate
  val EDiagnosticChain = pkg.getEDiagnosticChain
  val EDouble = pkg.getEDouble
  val EDoubleObject = pkg.getEDoubleObject
  val EEList = pkg.getEEList
  val EEnumerator = pkg.getEEnumerator
  val EFeatureMap = pkg.getEFeatureMap
  val EFeatureMapEntry = pkg.getEFeatureMapEntry
  val EFloat = pkg.getEFloat
  val EFloatObject = pkg.getEFloatObject
  val EInt = pkg.getEInt
  val EIntegerObject = pkg.getEIntegerObject
  val EJavaClass = pkg.getEJavaClass
  val EJavaObject = pkg.getEJavaObject
  val ELong = pkg.getELong
  val ELongObject = pkg.getELongObject
  val EMap = pkg.getEMap
  val EResource = pkg.getEResource
  val EResourceSet = pkg.getEResourceSet
  val EShort = pkg.getEShort
  val EShortObject = pkg.getEShortObject
  val EString = pkg.getEString
  val ETreeIterator = pkg.getETreeIterator
  val EInvocationTargetException = pkg.getEInvocationTargetException
}

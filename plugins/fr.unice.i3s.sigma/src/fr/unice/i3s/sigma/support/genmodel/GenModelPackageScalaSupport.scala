package fr.unice.i3s.sigma.support.genmodel

import org.eclipse.emf.codegen.util.ImportManager
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType
import fr.unice.i3s.sigma.support.EMFScalaSupport

trait GenModelPackageScalaSupport extends EMFScalaSupport {

  implicit class GenFeatureScalaSupport(that: GenFeature) {
    def genClass = that.getGenClass
    def genPackage = that.getGenPackage
    def name = that.getName
    def defaultValue = {
      if (that.many) "null"
      else that.getStaticDefaultValue
    }
    def setter = {
      if (that.many) s"${that.getter}.addAll"
      else s"set${that.getAccessorName}"
    }

    def getter = that.getGetAccessor
    def required = that.getEcoreFeature.isRequired
    def many = that.getEcoreFeature.isMany
    def changeable = that.isSet
  }

  implicit class GenDataTypeScalaSupport(that: GenDataType) {
    def name = that.getName
    def classifierAccessorName = that.getClassifierAccessorName
  }

  implicit class GenModelScalaSupport(that: GenModel) {
    def usedGenPackages = that.getUsedGenPackages
    def genPackages = that.getGenPackages
    def importManager = that.getImportManager
    def importManager_=(value: ImportManager) = that.setImportManager(value)

  }
  //  implicit class GenBase(that: GenBase) {
  //  }

  implicit class GenPackageScalaSupport(that: GenPackage) {
    def basePackage = that.getBasePackage
    def prefix = that.getPrefix
    def packageName = that.getPackageName
    def classPackageSuffix = that.getClassPackageSuffix
    def importedPackageInterfaceName = that.getImportedPackageInterfaceName
    def genModel = that.getGenModel
    def genClasses = that.getGenClasses
    def genDataTypes = that.getGenDataTypes
    def qualifiedFactoryInterfaceName = that.getQualifiedFactoryInterfaceName
  }

  implicit class GenClassScalaSupport(that: GenClass) {
    def genModel = that.getGenModel
    def name = that.getName
    def genPackage = that.getGenPackage
    def allGenFeatures = that.getAllGenFeatures
    def genFeatures = that.getGenFeatures
    def genOperations = that.getGenOperations
    def importedInterfaceName = that.getImportedInterfaceName
    def importedClassName = that.getImportedClassName
    def qualifiedInterfaceName = that.getQualifiedInterfaceName
  }
}
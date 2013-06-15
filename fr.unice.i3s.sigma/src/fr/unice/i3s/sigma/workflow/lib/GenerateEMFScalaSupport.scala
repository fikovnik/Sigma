package fr.unice.i3s.sigma.workflow.lib

import scala.collection.JavaConversions._
import java.io.File
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.util.ImportManager
import org.eclipse.emf.common.util.URI
import fr.unice.i3s.sigma.util.EMFUtils
import fr.unice.i3s.sigma.util.IOUtils.using
import fr.unice.i3s.sigma.m2t.TextTemplate
import fr.unice.i3s.sigma.workflow.WorkflowTask
import com.typesafe.scalalogging.log4j.Logging
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import fr.unice.i3s.sigma.support.EMFBuilder
import fr.unice.i3s.sigma.support.EMFScalaSupport
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement
import fr.unice.i3s.sigma.support.AutoContainment
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import scala.collection.mutable.Buffer
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil
import org.eclipse.emf.codegen.ecore.genmodel.GenBase
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType
import scala.reflect.{ classTag, ClassTag }

object GenModelScalaSupport {
  val ScalaKeywords = List("abstract", "case", "do", "else", "finally", "for", "import", "lazy", "object", "override", "return", "sealed", "trait", "try", "var", "while", "catch", "class", "extends", "false", "forSome", "if", "match", "new", "package", "private", "super", "this", "true", "type", "with", "yield", "def", "final", "implicit", "null", "protected", "throw", "val")
}

trait GenModelScalaSupport extends EMFScalaSupport {

  import GenModelScalaSupport._

  protected def checkName(name: String) = {
    if (ScalaKeywords contains name) s"`$name`"
    else name
  }

  protected def mapPrimitiveType(e: GenTypedElement) = e.getRawImportedType match {
    case "boolean" ⇒ "Boolean"
    case "byte" ⇒ "Byte"
    case "short" ⇒ "Short"
    case "int" ⇒ "Int"
    case "char" ⇒ "Char"
    case "float" ⇒ "Float"
    case "double" ⇒ "Double"
    case name ⇒ name
  }

  protected def typeName(feature: GenFeature) = {
    if (feature.isPrimitiveType())
      mapPrimitiveType(feature)
    else {
      feature.getImportedType(feature.genClass)
        .replace('<', '[')
        .replace('>', ']')
        .replace('?', '_')
    }
  }

  implicit class ImportManagerEx(that: ImportManager) {
    def importName[T: ClassTag] = {
      that.getImportedName(classTag[T].runtimeClass.getName, true)
    }
  }

  implicit class GenFeatureEx(that: GenFeature) {
    def genClass = that.getGenClass
    def name = that.getName
    def scalaName = checkName(that.getName)
    def scalaType = typeName(that)
    def defaultValue = that.getStaticDefaultValue
    def setter = {
      if (that.many) s"${that.getter}.addAll"
      else s"set${that.getAccessorName}"
    }
    def getter = that.getGetAccessor
    def required = that.getEcoreFeature.isRequired
    def many = that.getEcoreFeature.isMany
    def changeable = that.isSet
  }

  implicit class GenDataTypeEx(that: GenDataType) {
    def name = that.getName
    def classifierAccessorName = that.getClassifierAccessorName
  }

  implicit class GenModelEx(that: GenModel) {
    def usedGenPackages = that.getUsedGenPackages
    def genPackages = that.getGenPackages
    def importManager = that.getImportManager
    def importManager_=(value: ImportManager) = that.setImportManager(value)

  }
  //  implicit class GenBase(that: GenBase) {
  //  }

  implicit class GenPackageEx(that: GenPackage) {
    def basePackage = that.getBasePackage
    def packageName = that.getPackageName
    def importedPackageInterfaceName = that.getImportedPackageInterfaceName
    def genModel = that.getGenModel
    def genClasses = that.getGenClasses
    def genDataTypes = that.getGenDataTypes
    def qualifiedFactoryInterfaceName = that.getQualifiedFactoryInterfaceName
  }

  implicit class GenClassEx(that: GenClass) {
    def genModel = that.getGenModel
    def name = that.getName
    def genPackage = that.getGenPackage
    def allGenFeatures = that.getAllGenFeatures
    def genFeatures = that.getGenFeatures
    def importedInterfaceName = that.getImportedInterfaceName
    def qualifiedInterfaceName = that.getQualifiedInterfaceName

    // TODO: rename to generateConstructor
    def generateApply = {
      Option(GenModelUtil.getAnnotation(that, "http://www.i3s.unice.fr/Sigma", "generateApply")) match {
        case Some(x) ⇒ x.toBoolean
        case None ⇒ true
      }
    }

    def extraCompanionObjectCode = {
      Option(GenModelUtil.getAnnotation(that, "http://www.i3s.unice.fr/Sigma", "extraCompanionObjectCode"))
    }
  }
}

// we do not have to worry much about this class since it will
// get replaced by a Type macro later
case class EClassScalaSupportTemplate(
  clazz: GenClass,
  pkgName: String,
  clazzSupportName: String,
  pkgSupportName: String,
  useOption: Boolean,
  useEMFBuilder: Boolean,
  mappings: Map[String, String] = Map.empty) extends TextTemplate with Logging with GenModelScalaSupport {

  implicit class GenClassMapping(that: GenClass) {
    def scalaName = {
      mappings.get(that.name) match {
        case Some(name) ⇒ name
        case None ⇒
          val name = that.importedInterfaceName
          if (name.contains(".")) {
            val pkgName = that.genPackage.packageName.map { _.toUpper }
            val alias = pkgName + that.name
            logger.warn(s"Class name: ${that.name} conflicts with an already imported class (likely default import). It will be aliased to ${alias}.")
            alias
          } else name
      }
    }
  }

  val importManager = new ImportManager(pkgName, clazzSupportName)
  clazz.genModel.importManager = importManager

  override def render {
    !s"package $pkgName"

    // mark imports
    val imports = out.startSection

    !endl

    renderScalaSupportTrait

    !endl

    renderScalaSupportObject

    // output imports
    imports << importManager.computeSortedImports() << endl
  }

  protected def renderScalaSupportTrait {
    // the scala support trait
    !s"trait $clazzSupportName" curlyIndent {
      renderTypeDecl(clazz)

      !endl

      renderCompanionObject(clazz)

      !endl

      renderImplicitClass(clazz)
    }
  }

  protected def renderScalaSupportObject {
    !s"object $clazzSupportName extends $clazzSupportName"
  }

  protected def renderImplicitClass(clazz: GenClass) {
    !s"implicit class $clazzSupportName(that: ${clazz.importedInterfaceName})" curlyIndent {
      clazz.genFeatures foreach renderFeatureSupport
    }
  }

  protected def renderCompanionObject(clazz: GenClass) = {
    !s"object ${clazz.scalaName}" curlyIndent {
      if (clazz.generateApply) renderConstructor(clazz) << endl
      if (clazz.generateExtractor) renderExtractor(clazz)

      !clazz.extraCompanionObjectCode.getOrElse("")
    }
  }

  protected def renderExtractor(clazz: GenClass) = {
    val features = clazz.allGenFeatures.filter(_.generateExtractor)
      .map { f ⇒ (f.getter -> f.scalaType) }

    val types = features map (_._2) mkString (",")
    val names = features map ("that." + _._1) mkString (",")

    !s"def unapply(that: ${clazz.scalaName}): Option[($types)] =" indent {
      !s"Some(($names))"
    }

  }

  protected def renderConstructor(clazz: GenClass) = {
    val features = clazz.allGenFeatures filter { f ⇒
      !f.isDerived &&
        f.isChangeable &&
        f.isBidirectional implies !f.isContainer
    }

    val featureParams = features map { f ⇒
      s"${f.scalaName}: ${f.scalaType} = ${f.defaultValue}"
    }

    !s"def apply(${featureParams mkString (", ")}): ${clazz.scalaName} =" curlyIndent {
      if (useEMFBuilder) {
        !s"val instance = $pkgSupportName.builder.create[${clazz.scalaName}]" << endl
      } else {
        !s"val instance = ${clazz.genPackage.qualifiedFactoryInterfaceName}.eINSTANCE.create${clazz.name}" << endl
      }

      for (f ← features) {
        !s"if (${f.scalaName} != ${f.defaultValue}) instance.${f.setter}(${f.scalaName})"
      }

      !endl
      !"instance"
    }
  }

  protected def renderTypeDecl(clazz: GenClass) {
    !s"type ${clazz.scalaName} = ${clazz.qualifiedInterfaceName}"
  }

  protected def renderFeatureSupport(f: GenFeature) = {
    renderFeatureGetter(f)
    if (f.changeable) renderFeatureSetter(f)
  }

  protected def renderFeatureGetter(f: GenFeature) = {
    if (useOption && !f.required && !f.many) {
      val option = importManager.importName[Option[_]]
      !s"def ${f.scalaName}: $option[${f.scalaType}] = $option(that.${f.getter})"
    } else {
      !s"def ${f.scalaName}: ${f.scalaType} = that.${f.getter}"
    }
  }

  protected def renderFeatureSetter(f: GenFeature) = {
    // for setters we do not need to escape scala keywords
    val name = f.name
    !s"def ${name}_=(value: ${f.scalaType}): Unit = that.${f.setter}(value)"
    // a proxy setter for all non-containable references
    if (!f.isContains && f.isReferenceType && !f.isListType) {
      !s"def ${name}_=(value: ⇒ ${importManager.importName[Option[_]]}[${f.scalaType}]): Unit =" indent {
        !s"that.${f.setter}($pkgSupportName.builder.ref(value))"
      }
    }
  }

  implicit class GenBaseEx(that: GenBase) {
    def generateExtractor = {
      Option(GenModelUtil.getAnnotation(that, "http://www.i3s.unice.fr/Sigma", "excludeFromExtractors")) match {
        case Some(x) ⇒ x.toBoolean
        case None ⇒ true
      }
    }
  }
}

case class EPackageScalaSupportTemplate(
  pkg: GenPackage,
  pkgName: String,
  pkgSupportName: String,
  skipTypes: List[String] = Nil) extends TextTemplate with GenModelScalaSupport {

  val importManager = new ImportManager(pkgName, pkgSupportName)
  pkg.genModel.importManager = importManager

  override def render {
    !s"package $pkgName"

    // mark imports
    val imports = out.startSection

    renderScalaPackageSupportTrait

    !endl

    renderScalaPackageSupportObject

    // output imports
    imports << importManager.computeSortedImports() << endl << endl
  }

  def renderScalaPackageSupportTrait {
    !s"trait $pkgSupportName" indent {
      val traits = pkg.genClasses
        .filter { c ⇒ !(skipTypes contains c.name) }
        .map { _.name + "ScalaSupport" }

      // always include EMFScalaSupport
      traits += importManager.importName[EMFScalaSupport]

      !traits.mkString("extends ", " with" + endl, "")
    }
  }

  def renderScalaPackageSupportObject {
    !s"object $pkgSupportName extends $pkgSupportName" curlyIndent {
      // get the package  
      !s"private[this] val pkg = ${pkg.importedPackageInterfaceName}.eINSTANCE" << endl
      !s"val builder = new ${importManager.importName[EMFBuilder[_]]}(pkg)" << endl

      // constants for all data types
      pkg.genDataTypes foreach renderDataType("pkg") _
    }
  }

  def renderDataType(pkgVal: String)(e: GenDataType) {
    !s"val ${e.name} = $pkgVal.get${e.classifierAccessorName}"
  }

}

object GenerateEMFScalaSupport {

  EMFUtils.IO.registerDefaultFactories

  // initialize packages
  EcorePackage.eINSTANCE.getEFactoryInstance()
  GenModelPackage.eINSTANCE.getEFactoryInstance()

}

class GenerateEMFScalaSupport extends WorkflowTask with Logging with GenModelScalaSupport {

  // call the companion's object static block
  GenerateEMFScalaSupport

  protected var baseDir: File = _
  protected def baseDir_=(v: String): Unit = baseDir = new File(v)

  protected var genModelURI: URI = _
  protected def genModelURI_=(v: String): Unit = genModelURI = URI.createURI(v)

  protected var packageNameMapping: String ⇒ String = _

  protected var generateExtractors: Boolean = false

  protected var useOption: Boolean = false
  protected var useEMFBuilder: Boolean = false

  private var _packageName: String = _
  protected def packageName: String = _packageName
  protected def packageName_=(v: String) = {
    _packageName = v
    packageNameMapping = { _ ⇒ _packageName }
  }

  private val skipTypes: Buffer[String] = Buffer.empty
  def skipType(typeName: String) = skipTypes += typeName

  private val mappings: collection.mutable.Map[String, String] = collection.mutable.Map.empty
  def mapping(from: String, to: String) = mappings += (from -> to)

  def doExecute {
    logger.info("Generating EMF Scala Support for " + genModelURI)

    val genModel = EMFUtils.IO.load[GenModel](genModelURI)
    genModel.reconcile()

    val unresolvedPackages = genModel.usedGenPackages filter (_.eIsProxy)
    if (unresolvedPackages.size > 0) {
      logger.warn("Following packages are unresolved after loading - this might likely cause problems:")
      unresolvedPackages.foreach { p ⇒ logger.warn("- " + p) }
    }

    for (pkg ← genModel.genPackages) {

      val pkgName = packageNameMapping(Option(pkg.basePackage).map(_ + ".").getOrElse("") + pkg.packageName)
      val dir = (baseDir /: pkgName.split('.'))(new File(_, _))
      checkDir(dir)

      val pkgSupportName = pkg.packageName.capitalize + "PackageScalaSupport"
      using(new File(dir, pkgSupportName + ".scala")) { f ⇒
        logger debug s"Generated package support for ${pkg.packageName}"
        EPackageScalaSupportTemplate(pkg, pkgName, pkgSupportName, skipTypes.toList) >> f
      }

      for (clazz ← pkg.genClasses if !(skipTypes contains clazz.name)) {
        val clazzSupportName = clazz.name + "ScalaSupport"
        using(new File(dir, clazzSupportName + ".scala")) { f ⇒
          logger debug s"Generated class support for ${clazz.name}"
          EClassScalaSupportTemplate(clazz, pkgName, clazzSupportName, pkgSupportName, useOption, useEMFBuilder, mappings.toMap) >> f
        }
      }

    }
  }

  protected def checkDir(dir: File) {
    if (!dir.exists()) {
      assert(dir.mkdirs(), "Unable to create directory: " + dir)
    } else {
      require(dir.isDirectory())
    }
  }
}

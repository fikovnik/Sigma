package fr.unice.i3s.sigma.workflow.lib

import java.io.File
import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
import scala.reflect.ClassTag
import scala.reflect.classTag
import org.eclipse.emf.codegen.ecore.genmodel.GenBase
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenDataType
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement
import org.eclipse.emf.codegen.ecore.genmodel.util.GenModelUtil
import org.eclipse.emf.codegen.util.ImportManager
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EcorePackage
import com.typesafe.scalalogging.log4j.Logging
import fr.unice.i3s.sigma.m2t.TextTemplate
import fr.unice.i3s.sigma.support.EMFBuilder
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.util.EMFUtils
import fr.unice.i3s.sigma.util.IOUtils.using
import fr.unice.i3s.sigma.workflow.WorkflowRunner
import fr.unice.i3s.sigma.workflow.WorkflowTask
import fr.unice.i3s.sigma.support.genmodel.GenModelPackageScalaSupport
import org.eclipse.emf.codegen.util.ImportManager
import fr.unice.i3s.sigma.support.EMFProxyBuilder

protected object GenModelUtils {
  val ScalaKeywords = List("abstract", "case", "do", "else", "finally", "for", "import", "lazy", "object", "override", "return", "sealed", "trait", "try", "var", "while", "catch", "class", "extends", "false", "forSome", "if", "match", "new", "package", "private", "super", "this", "true", "type", "with", "yield", "def", "final", "implicit", "null", "protected", "throw", "val")
}

protected trait GenModelUtils extends GenModelPackageScalaSupport {

  import GenModelUtils._

  protected def checkName(name: String) = {
    // the space after _ is mandatory otherwise Scala compiler will complain
    if (ScalaKeywords contains name) name + "_ "
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
    def importName(name: String) = that.getImportedName(name, true)
    def importName[T: ClassTag] = {
      that.getImportedName(classTag[T].runtimeClass.getName, true)
    }
  }

  implicit class GenPackageEx(that: GenPackage) {
    def emfBuilderName = s"_${that.prefix.toLowerCase}Builder"
  }

  implicit class GenFeatureEx(that: GenFeature) {
    def scalaType = typeName(that)
  }

  implicit class GenBaseEx(that: GenBase) {
    def excludeFromConstructor = {
      Option(GenModelUtil.getAnnotation(that, "http://www.i3s.unice.fr/Sigma", "excludeFromConstructor")) match {
        case Some(x) ⇒ x.toBoolean
        case None ⇒ false
      }
    }

    def excludeFromExtractor = {
      Option(GenModelUtil.getAnnotation(that, "http://www.i3s.unice.fr/Sigma", "excludeFromExtractor")) match {
        case Some(x) ⇒ x.toBoolean
        case None ⇒ false
      }
    }
  }

  implicit class GenClassEx(that: GenClass) {
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
  generateExtractors: Boolean,
  useOption: Boolean,
  useEMFBuilder: Boolean,
  mappings: Map[String, String] = Map.empty) extends TextTemplate with Logging with GenModelUtils {

  // TODO: move this to the util class
  implicit class GenFeatureScalaName(that: GenFeature) {
    def scalaName = {
      mappings.get(s"${that.genClass.name}.${that.name}") match {
        case Some(name) ⇒ name
        case None ⇒ checkName(that.getName)
      }
    }
    
    def scalaNameWithoutSpace = {
      val name = scalaName
      if (name.endsWith("_ ")) name.dropRight(1)
      else name
    }
  }

  implicit class GenClassScalaName(that: GenClass) {
    def scalaName = {
      mappings.get(that.name) match {
        case Some(name) ⇒ name
        case None ⇒
          val name = that.importedInterfaceName
          // if there is a conflict with some std Java names
          // it will use full-qualified name
          if (name.contains(".")) {
            logger.warn(s"Class name: ${that.name} conflicts with an already imported class (likely default import). Consider adding a mapping.")
            that.name
          } else name
      }
    }
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
    !s"trait $clazzSupportName extends ${importManager.importName[EMFScalaSupport]}" curlyIndent {
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
    if (!clazz.genFeatures.isEmpty) {
      !s"implicit class $clazzSupportName(that: ${clazz.importedInterfaceName})" curlyIndent {
        clazz.genFeatures foreach renderFeatureSupport
      }
    }
  }

  protected def renderCompanionObject(clazz: GenClass) = {
    if (useEMFBuilder) {
      !s"protected implicit val _${clazz.scalaName.toLowerCase}ProxyBuilder = new ${importManager.importName[EMFProxyBuilder[_]]}[${clazz.scalaName}](${pkgSupportName}.${clazz.genPackage.emfBuilderName})"
      !endl
    }
    !s"object ${clazz.scalaName}" curlyIndent {
      if (clazz.generateApply) {
        renderConstructor(clazz)
        !endl
      }
      if (generateExtractors && !clazz.excludeFromExtractor) renderExtractor(clazz)

      !clazz.extraCompanionObjectCode.getOrElse("")
    }
  }

  protected def renderExtractor(clazz: GenClass) = {
    val features = clazz.allGenFeatures.filter(!_.excludeFromExtractor)
      .map { f ⇒ (f.getter -> f.scalaType) }

    if (features.size > 1 && features.size <= 22) {
      val types = features map (_._2) mkString (",")
      val names = features map ("that." + _._1) mkString (",")

      !s"def unapply(that: ${clazz.scalaName}): Option[($types)] =" indent {
        !s"Some(($names))"
      }
    } else {
      logger warn s"The number of features of ${clazz.name} has to be <= 22, but it is ${features.size} - skipping extractor"
    }
  }

  protected def renderConstructor(clazz: GenClass) = {
    val features = clazz.allGenFeatures filter { f ⇒
      !f.excludeFromConstructor &&
        !f.isDerived &&
        f.isChangeable &&
        (f.isBidirectional implies !f.isContainer)
    }

    val featureParams = features map { f ⇒
      s"${f.scalaName}: ${f.scalaType} = ${f.defaultValue}"
    }

    if (features.size <= 22) {
      !s"def apply(${featureParams mkString (", ")}): ${clazz.scalaName} =" curlyIndent {
        if (useEMFBuilder) {
          !s"val _instance = $pkgSupportName.${clazz.genPackage.emfBuilderName}.create[${clazz.scalaName}]" << endl
        } else {
          !s"val _instance = ${clazz.genPackage.qualifiedFactoryInterfaceName}.eINSTANCE.create${clazz.name}" << endl
        }

        for (f ← features) {
          !s"if (${f.scalaName} != ${f.defaultValue}) _instance.${f.setter}(${f.scalaName})"
        }

        !endl
        !"_instance"
      }
    } else {
      !s"def apply(): ${clazz.scalaName} =" curlyIndent {
        if (useEMFBuilder) {
          !s"$pkgSupportName.${clazz.genPackage.emfBuilderName}.create[${clazz.scalaName}]" << endl
        } else {
          !s"${clazz.genPackage.qualifiedFactoryInterfaceName}.eINSTANCE.create${clazz.name}" << endl
        }
      }
      logger warn s"The number of features of ${clazz.name} has to be <= 22, but it is ${features.size} - generating no-arg constructor"
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
    !s"def ${f.scalaNameWithoutSpace}_=(value: ${f.scalaType}): Unit = that.${f.setter}(value)"

    // a proxy setter for all non-containable references
    if (useEMFBuilder &&
      !f.isContains &&
      f.isReferenceType &&
      !f.isListType) {
      !s"def ${f.scalaNameWithoutSpace}_=(value: => ${importManager.importName[Option[_]]}[${f.scalaType}]): Unit =" indent {
        !s"that.${f.setter}($pkgSupportName.${f.genPackage.emfBuilderName}.ref(value))"
      }
    }
  }

}

case class DelegateTemplate(
  clazz: GenClass,
  clazzDelegateImplName: String,
  pkgName: String,
  pkgSupportName: String) extends TextTemplate with GenModelUtils {

  val importManager = new ImportManager(pkgName, clazzDelegateImplName)
  clazz.genModel.importManager = importManager

  val clazzDelegateName = s"${clazz.importedInterfaceName}Delegate"

  override def render {
    !s"package ${pkgName}"

    // mark imports
    val imports = out.startSection

    !endl
    !s"class $clazzDelegateImplName extends ${clazz.importedClassName} with $clazzDelegateName"

    !endl
    !s"trait $clazzDelegateName extends ${clazz.importedInterfaceName} with ${importManager.importName(pkgSupportName)}" curlyIndent {
      // TODO: generate stubs for derived features and operation bodies
    }

    // output imports
    imports << importManager.computeSortedImports() << endl << endl
  }

}

case class EPackageScalaSupportTemplate(
  pkg: GenPackage,
  pkgName: String,
  pkgSupportName: String,
  useEMFBuilder: Boolean,
  skipTypes: List[String] = Nil) extends TextTemplate with GenModelUtils {

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
      if (useEMFBuilder) {
        // TODO: externalize
        !s"protected[support] val ${pkg.emfBuilderName} = new ${importManager.importName[EMFBuilder[_]]}(pkg)" << endl
      }

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

class GenerateEMFScalaSupport extends WorkflowTask with Logging with GenModelUtils {

  // call the companion's object static block
  GenerateEMFScalaSupport

  protected var baseDir: File = _
  protected def baseDir_=(v: String): Unit = baseDir = new File(v)

  protected var genModelURI: URI = _
  protected def genModelURI_=(v: String): Unit = genModelURI = URI.createURI(v)

  protected var packageNameMapping: String ⇒ String = _

  protected var generateExtractors: Boolean = false

  protected var generateDelegates: Boolean = false
  protected var delegatesBaseDir: File = _
  protected def delegatesBaseDir_=(v: String): Unit = delegatesBaseDir = new File(v)

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

    require(generateDelegates implies delegatesBaseDir.isDirectory, "generateDelegates option implies delegatesBaseDir option")

    val genModel = EMFUtils.IO.load[GenModel](genModelURI)
    genModel.reconcile()

    val unresolvedPackages = genModel.usedGenPackages filter (_.eIsProxy)
    if (unresolvedPackages.size > 0) {
      logger.warn("Following packages are unresolved after loading - this might likely cause problems:")
      unresolvedPackages.foreach { p ⇒ logger.warn("- " + p) }
    }

    for (pkg ← genModel.genPackages) {

      val basePkg = Option(pkg.basePackage).map(_ + ".").getOrElse("") + pkg.packageName
      val pkgName = packageNameMapping(basePkg)
      val dir = (baseDir /: pkgName.split('.'))(new File(_, _))
      checkDir(dir)

      val pkgSupportName = pkg.prefix + "PackageScalaSupport"
      using(new File(dir, pkgSupportName + ".scala")) { f ⇒
        logger debug s"Generated package support for ${pkg.packageName}"
        EPackageScalaSupportTemplate(pkg, pkgName, pkgSupportName, useEMFBuilder, skipTypes.toList) >> f
      }

      for (clazz ← pkg.genClasses if !(skipTypes contains clazz.name)) {
        val clazzSupportName = clazz.name + "ScalaSupport"
        using(new File(dir, clazzSupportName + ".scala")) { f ⇒
          logger debug s"Generated class support for ${clazz.name}"
          EClassScalaSupportTemplate(clazz, pkgName, clazzSupportName, pkgSupportName, generateExtractors, useOption, useEMFBuilder, mappings.toMap) >> f
        }

        if (generateDelegates &&
          (clazz.genFeatures.exists(_.isDerived) || clazz.genOperations.nonEmpty)) {
          val implPkg = basePkg + "." + pkg.classPackageSuffix
          val clazzDelegateImplName = clazz.importedClassName + "Delegate"
          val delegatesDir = (delegatesBaseDir /: implPkg.split('.'))(new File(_, _))
          checkDir(delegatesDir)

          val clazzFile = new File(delegatesDir, clazzDelegateImplName + ".scala")
          if (!clazzFile.exists) {
            using(clazzFile) { f ⇒
              logger debug s"Generated delegeate for ${clazz.name}"
              DelegateTemplate(clazz, clazzDelegateImplName, implPkg, s"$pkgName.$pkgSupportName") >> f
            }
          } else {
            logger debug s"Delegeate for ${clazz.name} already exists - skipping"
          }
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

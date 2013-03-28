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

trait Utils {
  val scalaKeywords = List("abstract", "case", "do", "else", "finally", "for", "import", "lazy", "object", "override", "return", "sealed", "trait", "try", "var", "while", "catch", "class", "extends", "false", "forSome", "if", "match", "new", "package", "private", "super", "this", "true", "type", "with", "yield", "def", "final", "implicit", "null", "protected", "throw", "val")

  protected def checkName(name: String) = {
    if (scalaKeywords contains name) s"`$name`"
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
      feature.getImportedType(feature.getGenClass)
        .replace('<', '[')
        .replace('>', ']')
        .replace('?', '_')
    }
  }
}

trait NameMappings {

  val mappings: Map[String, String]

  protected def mapName(feature: GenFeature) = {
    val key = feature.getGenClass.getName + "." + feature.getName
    mappings.get(key) match {
      case Some(name) ⇒ name
      case None ⇒ feature.getName
    }
  }
}

case class EMFBuilderTemplate(
  pkg: GenPackage,
  pkgName: String,
  builderName: String,
  skipTypes: List[String] = Nil,
  mappings: Map[String, String] = Map.empty) extends TextTemplate with EMFScalaSupport with Utils with NameMappings with Logging {

  val importManager = new ImportManager(pkgName, builderName)
  pkg.getGenModel.setImportManager(importManager)
  val emfBuilder = importManager.getImportedName(classOf[EMFBuilder[_]].getName, true)
  val autoContainment = importManager.getImportedName(AutoContainment.getClass.getName, true)

  override def render {
    // starts
    !s"package $pkgName" << endl

    // mark imports
    val imports = out.startSection

    val clazzes = pkg.getGenClasses filter { c ⇒ !skipTypes.contains(c.getName) && !c.isAbstract }
    !s"object $builderName extends $emfBuilder(${pkg.getImportedPackageInterfaceName()}.eINSTANCE)" curlyIndent {
      !s"import ${autoContainment}_" << endl << endl

      // for each class generate a construct method
      for (clazz ← clazzes) {
        renderEClassConstructMethod(clazz)
        !endl << endl
      }

      !endl
    }

    !endl
    !endl

    // collect all features for which we will generate the assignments
    val featuresMap = pkg.getGenClasses
      .filter { c ⇒ !(skipTypes contains c.getName) }
      .flatMap(_.getGenFeatures)
      .filter { f ⇒ !f.isDerived && f.isChangeable && (f.isBidirectional implies !f.isContainer) }
      .groupBy { f ⇒ mapName(f) }

    // are there any two or more methods that have the same names?  
    val overloadHackMax = featuresMap.values.map(_.size).max

    !s"object ${pkg.getPackageName.capitalize}Assignments"
    if (overloadHackMax > 1) !s" extends OverloadHack"

    out curlyIndent {
      !"""private def nothing: Nothing = sys.error("this method is not meant to be called")""" << endl
      !endl

      for ((featureName, features) ← featuresMap) {
        renderFeatureMethods(featureName, features)
        !endl
      }
    }

    if (overloadHackMax > 1) {
      !endl
      !endl

      !"trait OverloadHack" curlyIndent {
        for (i ← 1 until overloadHackMax) {
          !s"class Overloaded$i" << endl
          !s"implicit val overload$i = new Overloaded$i" << endl
          !endl
        }
      }

      !endl
    }

    imports << importManager.computeSortedImports() << endl << endl
  }

  protected def renderFeatureMethods(featureName: String, features: Seq[GenFeature]) {
    // getter
    !s"def ${checkName(featureName)}(implicit ev: Nothing) = nothing" << endl

    // setters
    for ((feature, i) ← features.zipWithIndex) {
      val clazzName = feature.getGenClass.getImportedInterfaceName
      val overload = if (i > 0) s"(implicit o: Overloaded$i)" else ""

      // direct setter
      !s"def ${featureName}_=[T <: $clazzName](value: ${typeName(feature)})$overload =" indent {
        if (feature.isListType)
          !s"(target: T) ⇒ target.${feature.getGetAccessor}.addAll(value)" << endl
        else
          !s"(target: T) ⇒ target.set${feature.getAccessorName}(value)" << endl
      }
      !endl

      // a proxy setter for all non-containable references
      if (!feature.isContains && feature.isReferenceType && !feature.isListType()) {
        !s"def ${featureName}_=[T <: $clazzName](value: ⇒ Option[${typeName(feature)}])$overload =" indent {
          if (feature.isListType)
            !s"(target: T) ⇒ target.${feature.getGetAccessor}.addAll($builderName.ref(value))" << endl
          else
            !s"(target: T) ⇒ target.set${feature.getAccessorName}($builderName.ref(value))" << endl
        }
        !endl
      }

      !endl
    }
  }

  protected def renderEClassConstructMethod(clazz: GenClass) {
    val clazzName = mapClazzName(clazz)

    !s"type ${clazzName} = ${clazz.getQualifiedInterfaceName}" << endl
    !s"object ${clazzName}" curlyIndent {
      !s"def apply(config: ($clazzName ⇒ Any)*): $clazzName =" indent {
        !s"contained(build[$clazzName](config: _*))"
      }
    }
  }

  protected def mapClazzName(clazz: GenClass) = {
    mappings.get(clazz.getName) match {
      case Some(name) ⇒ name
      case None ⇒
        val name = clazz.getImportedInterfaceName
        if (name.contains(".")) {
          val pkgName = clazz.getGenPackage.getPackageName.map { _.toUpper }
          val alias = pkgName + clazz.getName
          logger.warn(s"Class name: ${clazz.getName} conflicts with an already imported class (likely default import). It will be aliased to ${alias}.")
          alias
        } else name
    }
  }
}

// we do not have to worry much about this class since it will
// get replaced by a Type macro later
case class EClassScalaSupportTemplate(clazz: GenClass, 
    pkgName: String, 
    clazzSupportName: String,
    mappings: Map[String, String] = Map.empty) extends TextTemplate with NameMappings with Utils {

  val importManager = new ImportManager(pkgName, clazzSupportName)
  clazz.getGenModel.setImportManager(importManager)

  override def render {

    // starts
    !s"package $pkgName" << endl

    // mark imports
    val imports = out.startSection

    // the trait
    !s"trait $clazzSupportName" curlyIndent {
      !s"implicit class $clazzSupportName(that: ${clazz.getImportedInterfaceName})" curlyIndent {
        clazz.getGenFeatures foreach renderFeatureSupport
      }
    }

    // the companion object
    !endl
    !endl
    !s"object $clazzSupportName extends $clazzSupportName" << endl

    imports << importManager.computeSortedImports() << endl << endl
  }

  protected def renderFeatureSupport(feature: GenFeature) {
    val featureName = mapName(feature)
    val featureType = typeName(feature)

    // getter
    !s"def ${checkName(featureName)}: $featureType = that.${feature.getGetAccessor}" << endl
    if (feature.isSet()) {
      // setter
      !s"def ${featureName}_=(value: $featureType): Unit = that.set${feature.getAccessorName}(value)" << endl
    }
  }

}

case class EPackageScalaSupportTemplate(pkg: GenPackage, pkgName: String, pkgSupportName: String, val skipTypes: List[String] = Nil) extends TextTemplate {

  val importManager = new ImportManager(pkgName, pkgSupportName)
  pkg.getGenModel.setImportManager(importManager)

  override def render {

    val x :: xs = pkg.getGenClasses.toList

    // start
    !s"package $pkgName" << endl << endl

    // mark imports
    val imports = out.startSection

    // the trait
    !s"trait $pkgSupportName" indent {
      !pkg.getGenClasses
        .filter { c ⇒ !(skipTypes contains c.getName) }
        .map { _.getName + "ScalaSupport" }
        .mkString("extends ", " with" + endl, "")
    }

    !endl
    !endl

    // the companion object
    !s"object $pkgSupportName extends $pkgSupportName" curlyIndent {
      !endl
      // get the package  
      !s"private[this] val pkg = ${pkg.getImportedPackageInterfaceName}.eINSTANCE" << endl << endl
      // constants for all data types
      for (e ← pkg.getGenDataTypes())
        !s"val ${e.getName} = pkg.get${e.getClassifierAccessorName}" << endl
    }

    imports << importManager.computeSortedImports() << endl << endl
  }

}

object GenerateEMFScalaSupport {

  EMFUtils.IO.registerDefaultFactories

  // initialize packages
  EcorePackage.eINSTANCE.getEFactoryInstance()
  GenModelPackage.eINSTANCE.getEFactoryInstance()

}

class GenerateEMFScalaSupport extends WorkflowTask with Logging {

  private var _baseDir: File = _
  protected def baseDir: File = _baseDir
  protected def baseDir_=(v: File) = _baseDir = v
  protected def baseDir_=(v: String) = _baseDir = new File(v)

  private var _genModelURI: URI = _
  protected def genModelURI: URI = _genModelURI
  protected def genModelURI_=(v: URI) = _genModelURI = v
  protected def genModelURI_=(v: String) = _genModelURI = URI.createURI(v)

  private var _pkgName: String = _
  protected def pkgName: String = _pkgName
  protected def pkgName_=(v: String) = _pkgName = v

  private val skipTypes: Buffer[String] = Buffer.empty
  private val mappings: collection.mutable.Map[String, String] = collection.mutable.Map.empty

  // call the companion's object static block
  GenerateEMFScalaSupport

  def doExecute {
    logger.info("Generating EMF Scala Support for " + genModelURI)

    val genModel = EMFUtils.IO.load[GenModel](genModelURI)

    val unresolvedPackages = genModel.getUsedGenPackages.filter { _.eIsProxy }
    if (unresolvedPackages.size > 0) {
      logger.warn("Following packages are unresolved after loading - this might likely cause problems:")
      unresolvedPackages.foreach { p ⇒ logger.warn("- " + p) }
    }

    for (pkg ← genModel.getGenPackages) {

      val dir = (baseDir /: pkgName.split('.'))(new File(_, _))
      checkDir(dir)

      val builderName = pkg.getPackageName.capitalize + "Builder"
      using(new File(dir, builderName + ".scala")) { f ⇒
        logger debug s"Generated builder for $builderName"
        EMFBuilderTemplate(pkg, pkgName, builderName, skipTypes.toList, mappings.toMap) >> f
      }

      val pkgSupportName = pkg.getPackageName.capitalize + "PackageScalaSupport"
      using(new File(dir, pkgSupportName + ".scala")) { f ⇒
        logger debug s"Generated package support for ${pkg.getPackageName}"
        EPackageScalaSupportTemplate(pkg, pkgName, pkgSupportName, skipTypes.toList) >> f
      }

      for (clazz ← pkg.getGenClasses if !(skipTypes contains clazz.getName)) {
        val clazzSupportName = clazz.getName + "ScalaSupport"
        using(new File(dir, clazzSupportName + ".scala")) { f ⇒
          logger debug s"Generated class support for ${clazz.getName}"
          EClassScalaSupportTemplate(clazz, pkgName, clazzSupportName, mappings.toMap) >> f
        }
      }

    }
  }

  def mapping(from: String, to: String) = mappings += (from -> to)

  def skipType(typeName: String) = skipTypes += typeName

  protected def checkDir(dir: File) {
    if (!dir.exists()) {
      assert(dir.mkdirs(), "Unable to create directory: " + dir)
    } else {
      require(dir.isDirectory())
    }
  }
}

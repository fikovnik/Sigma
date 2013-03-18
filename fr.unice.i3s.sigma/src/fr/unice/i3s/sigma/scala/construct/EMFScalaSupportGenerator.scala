package fr.unice.i3s.sigma.scala.construct

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
import fr.unice.i3s.sigma.scala.mtt.TextTemplate
import fr.unice.i3s.sigma.util.ToolUtils

// we do not have to worry much about this class since it will
// get replaced by a Type macro later
class EClassScalaSupportTemplate(clazz: GenClass, scalaPkgName: String, scalaUnitName: String) extends TextTemplate {

  require(clazz != null)

  override def render {
    val importManager = new ImportManager(scalaPkgName, scalaUnitName)
    clazz.getGenModel.setImportManager(importManager)

    // starts
    !s"package $scalaPkgName" << endl

    // mark imports
    val imports = out.startSection

    // the trait
    !s"trait $scalaUnitName" curlyIndent {
      !s"implicit class $scalaUnitName(that: ${clazz.getImportedInterfaceName})" curlyIndent {
        clazz.getGenFeatures foreach renderFeatureSupport
      }
    }

    // the companion object
    !endl
    !endl
    !s"object $scalaUnitName extends $scalaUnitName" << endl

    imports << importManager.computeSortedImports() << endl << endl
  }

  protected def renderFeatureSupport(feature: GenFeature) {
    val featureName = feature.getName

    val featureType = mapTypeName(feature.getImportedType(feature.getGenClass()))
      .replace('<', '[')
      .replace('>', ']')
      .replace('?', '_')

    // getter
    !s"def ${checkName(featureName)}: $featureType = that.${feature.getGetAccessor}" << endl
    if (feature.isSet()) {
      // setter
      !s"def ${featureName}_=(value: $featureType): Unit = that.set${feature.getAccessorName}(value)" << endl
    }
  }

  protected def checkName(name: String) = {
    if (ToolUtils.scalaKeywords contains name) s"`$name`"
    else name
  }

  protected def mapTypeName(name: String) = name match {
    case "boolean" ⇒ "Boolean"
    case "byte" ⇒ "Byte"
    case "short" ⇒ "Short"
    case "int" ⇒ "Int"
    case "char" ⇒ "Char"
    case "float" ⇒ "Float"
    case "double" ⇒ "Double"
    case _ ⇒ name
  }
}

class EPackageScalaSupportTemplate(pkg: GenPackage, scalaPkgName: String, scalaUnitName: String) extends TextTemplate {

  require(!pkg.getGenClasses.isEmpty)

  override def render {
    val importManager = new ImportManager(scalaPkgName, scalaUnitName)
    pkg.getGenModel.setImportManager(importManager)

    val x :: xs = pkg.getGenClasses.toList

    // start
    !s"package $scalaPkgName" << endl << endl

    // mark imports
    val imports = out.startSection

    // the trait
    !s"trait $scalaUnitName" indent {
      !pkg.getGenClasses.map(_.getName + "ScalaSupport").mkString("extends ", " with" + endl, "")
    }

    !endl
    !endl

    // the companion object
    !s"object $scalaUnitName extends $scalaUnitName" curlyIndent {
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

class EMFScalaSupportGenerator {

  def generate(baseDir: File, genModelURI: URI, pkgName: String) {
    val (genModel, rs) = EMFUtils.IO.load[GenModel](genModelURI)
    generate(baseDir, genModel, Option(pkgName))
  }

  def generate(baseDir: File, model: GenModel, pkgNameOpt: Option[String]) {
    for (pkg ← model.getGenPackages) {

      val scalaPkgName = pkgNameOpt match {
        case Some(name) ⇒ name
        case None ⇒ pkg.getBasePackage + "." + pkg.getPackageName + ".scala"
      }

      val dir = (baseDir /: scalaPkgName.split('.'))(new File(_, _))
      checkDir(dir)

      for (clazz ← pkg.getGenClasses) {
        val scalaUnitName = clazz.getName + "ScalaSupport"
        val scalaClazz = new EClassScalaSupportTemplate(clazz, scalaPkgName, scalaUnitName)

        val f = new File(dir, scalaUnitName + ".scala")
        using(f) { writer ⇒
          println("Generated: " + scalaUnitName)
          scalaClazz >> writer
        }
      }

      val scalaUnitName = pkg.getPackageName.capitalize + "PackageScalaSupport"
      val scalaClazz = new EPackageScalaSupportTemplate(pkg, scalaPkgName, scalaUnitName)

      val f = new File(dir, scalaUnitName + ".scala")
      using(f) { writer ⇒
        println("Generated: " + scalaUnitName)
        scalaClazz >> writer
      }
    }
  }

  def checkDir(dir: File) {
    if (!dir.exists()) {
      assert(dir.mkdirs(), "Unable to create directory: " + dir)
    } else {
      require(dir.isDirectory())
    }
  }
}

object EMFScalaSupportGenerator extends App {

  if (args.length < 2 && args.length > 3) {
    println("Usage: %s <model.genmodel> <target_dir> [<base_package>]" format getClass.getName)
    scala.sys.exit(1)
  }

  val output = new File(args(1))
  val pkgName = if (args.length != 3) null else args(2)

  val generator = new EMFScalaSupportGenerator
  generator.generate(output, URI.createFileURI(args(0)), pkgName)

}

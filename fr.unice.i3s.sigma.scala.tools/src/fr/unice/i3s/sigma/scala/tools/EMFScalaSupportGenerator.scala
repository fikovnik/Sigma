package fr.unice.i3s.sigma.scala.tools

import fr.unice.i3s.sigma.scala.utils._
import fr.unice.i3s.sigma.scala.tools._
import fr.unice.i3s.sigma.scala.utils.io._
import org.eclipse.emf.ecore.EPackage
import java.io.File
import fr.unice.i3s.sigma.scala.mtt.TextTemplate
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.util.ImportManager
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

// we do not have to worry much about this class since it will
// get replaced by a Type macro later
object EClassScalaSupportTemplate {
  val keywords = List("abstract", "case", "do", "else", "finally", "for", "import", "lazy", "object", "override", "return", "sealed", "trait", "try", "var", "while", "catch", "class", "extends", "false", "forSome", "if", "match", "new", "package", "private", "super", "this", "true", "type", "with", "yield", "def", "final", "implicit", "null", "protected", "throw", "val")
}
class EClassScalaSupportTemplate(clazz: GenClass, scalaPkgName: String, scalaUnitName: String) extends TextTemplate {

  import EClassScalaSupportTemplate._

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
    if (keywords contains name) s"`$name`"
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

  def generate(baseDir: File, model: GenModel, pkgNameOpt: Option[String] = None) {
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

        using(new File(dir, scalaUnitName + ".scala")) { f ⇒
          println("Generated: " + scalaUnitName)
          scalaClazz >> f
        }
      }

      val scalaUnitName = pkg.getPackageName.capitalize + "PackageScalaSupport"
      val scalaClazz = new EPackageScalaSupportTemplate(pkg, scalaPkgName, scalaUnitName)

      using(new File(dir, scalaUnitName + ".scala")) { f ⇒
        println("Generated: " + scalaUnitName)
        scalaClazz >> f
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

  val (genModel, rs) = load[GenModel](args(0))
  val output = new File(args(1))
  val pkgNameOpt = if (args.length != 3) None else Some(args(2))

  val generator = new EMFScalaSupportGenerator
  generator.generate(output, genModel, pkgNameOpt)

}


package fr.unice.i3s.sigma.scala.tools

import collection.JavaConversions._
import fr.unice.i3s.sigma.scala.utils.io._
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import fr.unice.i3s.sigma.scala.mtt.TextTemplate
import org.eclipse.emf.codegen.util.ImportManager
import fr.unice.i3s.sigma.scala.construct.EMFBuilder
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import java.io.File
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement

class EMFBuilderTemplate(pkg: GenPackage, scalaPkgName: String, scalaUnitName: String, skipTypes: List[String] = Nil) extends TextTemplate {
  override val stripWhitespace = true

  val importManager = new ImportManager(scalaPkgName, scalaUnitName)
  pkg.getGenModel.setImportManager(importManager)

  override def render {
    val emfBuilder = importManager.getImportedName(classOf[EMFBuilder[_]].getName, true)

    // starts
    !s"package $scalaPkgName" << endl

    // mark imports
    val imports = out.startSection

    !s"class $scalaUnitName extends $emfBuilder(${pkg.getImportedPackageInterfaceName()}.eINSTANCE)" curlyIndent {

      // for each class generate a construct method
      for (
        clazz ← pkg.getGenClasses if !(skipTypes contains clazz.getName) && !clazz.isAbstract()
      ) {
        renderEClassConstructMethod(clazz)
        !endl << endl
      }

      !endl
    }

    //    trait OverloadHack {
    //  class Overloaded1
    //
    //  implicit val overload3 = new Overloaded3
    //}

    imports << importManager.computeSortedImports() << endl << endl
  }

  protected def renderEClassConstructMethod(clazz: GenClass) {
    val clazzName = clazz.getImportedInterfaceName
    val features = clazz.getAllGenFeatures filter (f ⇒ !f.isDerived && f.isChangeable)

    val params = features.map { feature ⇒
      s"${safeName(feature.getName)}: ${typeName(feature)} = ${defaultValue(feature)}"
    }

    !s"def ${safeName(decapitalize(clazz.getName))}" parenIndent {
      !params.mkString("," + endl)
    }
    !s": $clazzName =" curlyIndent {
      !endl
      !s"val obj = create[$clazzName]" << endl
      !endl

      !"// set properties" << endl
      for (feature ← features) {
        val featureName = safeName(feature.getName)
        if (feature.isListType()) {
          !s"setNotEmpty(obj.${feature.getGetAccessor}, $featureName)"
        } else {
          !s"setNotDefault(obj.set${feature.getAccessorName}, $featureName, ${defaultValue(feature)})"
        }
        !endl
      }
      !endl

      !"obj"
    }
  }

  protected def decapitalize(s: String) = s(0).toLower + s.drop(1)

  protected def defaultValue(e: GenFeature): String = {
    Option(e.getDefaultValue) match {
      case Some(value) ⇒ value.drop(1).dropRight(1) // remove quotes
      case None ⇒ e.getEcoreFeature.getEType.getName match {
        case "EBoolean" ⇒ "false"
        case "EByte" ⇒ "0"
        case "EShort" ⇒ "0"
        case "EInt" ⇒ "0"
        case "EChar" ⇒ "0"
        case "ELong" ⇒ "0L"
        case "EFloat" ⇒ "0F" // TODO: should be a better constant
        case "EDouble" ⇒ "0D" // TODO: should be a better constant
        case _ ⇒ "null"
      }
    }
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
    if (feature.isPrimitiveType()) mapPrimitiveType(feature)
    else {
      feature.getImportedType(feature.getGenClass)
        .replace('<', '[')
        .replace('>', ']')
        .replace('?', '_')
    }
  }

  protected def safeName(name: String) = {
    if (scalaKeywords contains name) s"`$name`"
    else name
  }
}

class EMFBuilderGenerator {
  def generate(baseDir: File, model: GenModel, pkgNameOpt: Option[String] = None, skipTypes: List[String] = Nil) {
    for (pkg ← model.getGenPackages) {

      val scalaPkgName = pkgNameOpt match {
        case Some(name) ⇒ name
        case None ⇒ pkg.getBasePackage + "." + pkg.getPackageName + ".scala"
      }

      val dir = (baseDir /: scalaPkgName.split('.'))(new File(_, _))
      checkDir(dir)

      val scalaUnitName = pkg.getPackageName.capitalize + "Builder"
      val scalaClazz = new EMFBuilderTemplate(pkg, scalaPkgName, scalaUnitName, skipTypes)

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

object EMFBuilderGenerator extends App {
  if (args.length < 2 && args.length > 3) {
    println("Usage: %s <model.genmodel> <target_dir> [<base_package>]" format getClass.getName)
    scala.sys.exit(1)
  }

  val (genModel, rs) = load[GenModel](args(0))
  val output = new File(args(1))
  val pkgNameOpt = if (args.length != 3) None else Some(args(2))

  val generator = new EMFBuilderGenerator
  generator.generate(output, genModel, pkgNameOpt, List("EStringToStringMapEntry"))
}
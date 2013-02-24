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
import scala.collection.mutable.Buffer

class EMFBuilderTemplate(pkg: GenPackage, scalaPkgName: String, scalaUnitName: String, skipTypes: List[String] = Nil) extends TextTemplate {
  override val stripWhitespace = true

  val importManager = new ImportManager(scalaPkgName, scalaUnitName)
  pkg.getGenModel.setImportManager(importManager)

  val renderedFeatures = collection.mutable.Map[String, Int]()

  override def render {
    val emfBuilder = importManager.getImportedName(classOf[EMFBuilder[_]].getName, true)

    // starts
    !s"package $scalaPkgName" << endl

    // mark imports
    val imports = out.startSection

    val clazzes = pkg.getGenClasses filter (c ⇒ !skipTypes.contains(c.getName) && !c.isAbstract)
    !s"class $scalaUnitName extends $emfBuilder(${pkg.getImportedPackageInterfaceName()}.eINSTANCE)" curlyIndent {

      // for each class generate a construct method
      for (clazz ← clazzes) {
        renderEClassConstructMethod(clazz)
        !endl << endl
      }

      !endl
    }

    !endl
    !endl

    !s"trait ${pkg.getPackageName.capitalize}Assignments extends OverloadHack" curlyIndent {
      !"""private def nothing: Nothing = sys.error("this method is not meant to be called")"""
      !endl

      val nameConflicts = clazzes map (c ⇒ decapitalize(c.getName))
      for {
        clazz ← pkg.getGenClasses if !(skipTypes contains clazz.getName)
        feature ← clazz.getGenFeatures if !feature.isDerived && feature.isChangeable && !nameConflicts.contains(feature.getName)
      } {
        renderFeatureMethod(feature)
        !endl << endl
      }
    }

    !endl
    !endl

    val max = renderedFeatures.values.max
    !"trait OverloadHack" curlyIndent {
      for (i ← 1 until max - 1) {
        !s"class Overloaded$i" << endl
        !s"implicit val overload$i = new Overloaded$i" << endl
        !endl
      }
    }
    !endl

    imports << importManager.computeSortedImports() << endl << endl
  }

  protected def renderFeatureMethod(feature: GenFeature) {
    val featureName = feature.getName
    val clazzName = feature.getGenClass.getImportedInterfaceName

    val rendered = renderedFeatures.get(featureName).map(_ + 1).getOrElse(0)

    if (rendered == 0)
      !s"def ${safeName(featureName)}(implicit ev: Nothing) = nothing" << endl

    !s"def ${featureName}_=[T <: $clazzName](value: ${typeName(feature)})${overloadHack(feature)} =" indent {
      if (feature.isListType)
        !s"(target: T) ⇒ target.${feature.getGetAccessor}.addAll(value)" << endl
      else
        !s"(target: T) ⇒ target.set${feature.getAccessorName}(value)" << endl
    }

    renderedFeatures(featureName) = rendered + 1
  }

  protected def overloadHack(feature: GenFeature) = {
    renderedFeatures
      .get(feature.getName)
      .filter(_ > 0)
      .map(c ⇒ s"(implicit o: Overloaded$c)")
      .getOrElse("")
  }

  protected def renderEClassConstructMethod(clazz: GenClass) {
    val clazzName = clazz.getImportedInterfaceName

    !s"def ${safeName(decapitalize(clazz.getName))}(config: ($clazzName => Any)*): $clazzName = build[$clazzName](config: _*)"
  }

  protected def decapitalize(s: String) = s(0).toLower + s.drop(1)

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
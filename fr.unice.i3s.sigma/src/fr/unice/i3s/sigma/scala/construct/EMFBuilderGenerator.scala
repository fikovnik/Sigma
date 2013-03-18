package fr.unice.i3s.sigma.scala.construct

import scala.collection.JavaConversions._
import java.io.File
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenTypedElement
import org.eclipse.emf.codegen.util.ImportManager
import fr.unice.i3s.sigma.scala.mtt.TextTemplate
import fr.unice.i3s.sigma.util.IOUtils.using
import fr.unice.i3s.sigma.common.EMFScalaSupport
import fr.unice.i3s.sigma.util.EMFUtils
import org.eclipse.emf.common.util.URI
import fr.unice.i3s.sigma.util.ToolUtils

class EMFBuilderTemplate(pkg: GenPackage, scalaPkgName: String, scalaUnitName: String, skipTypes: List[String] = Nil) extends TextTemplate with EMFScalaSupport {

  override def stripWhitespace = true

  val importManager = new ImportManager(scalaPkgName, scalaUnitName)
  pkg.getGenModel.setImportManager(importManager)

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

    // it is possible to have a class that has the same name as the feature
    // in this case the class method has a priority
    val nameConflicts = clazzes map (c ⇒ decapitalize(c.getName))
    val featuresMap = pkg.getGenClasses
      .filter(c ⇒ !(skipTypes contains c.getName))
      .flatMap(_.getGenFeatures)
      .filter(f ⇒ !f.isDerived && f.isChangeable && !(nameConflicts contains f.getName) && (f.isBidirectional implies !f.isContainer))
      .groupBy(_.getName)

    // are there any two or more methods that have the same names?  
    val overloadHackMax = featuresMap.values.map(_.size).max

    !s"trait ${pkg.getPackageName.capitalize}Assignments"
    if (overloadHackMax > 1) {
      !s" extends OverloadHack"
    }
    out curlyIndent {
      !s"this: $scalaUnitName =>" << endl
      !endl
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
    !s"def ${safeName(featureName)}(implicit ev: Nothing) = nothing" << endl

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
            !s"(target: T) ⇒ target.${feature.getGetAccessor}.addAll(ref(value))" << endl
          else
            !s"(target: T) ⇒ target.set${feature.getAccessorName}(ref(value))" << endl
        }
        !endl
      }

      !endl
    }
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
    if (ToolUtils.scalaKeywords contains name) s"`$name`"
    else name
  }
}

class EMFBuilderGenerator {
  def generate(baseDir: File, genModelURI: URI, pkgNameOpt: Option[String], skipTypes: List[String]) {
    val (genModel, rs) = EMFUtils.IO.load[GenModel](genModelURI)
    generate(baseDir, genModel, pkgNameOpt, skipTypes)
  }

  def generate(baseDir: File, model: GenModel, pkgNameOpt: Option[String], skipTypes: List[String]) {
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

  val output = new File(args(1))
  val pkgNameOpt = if (args.length != 3) None else Some(args(2))

  val generator = new EMFBuilderGenerator
  generator.generate(output, URI.createFileURI(args(0)), pkgNameOpt, List("EStringToStringMapEntry"))
}
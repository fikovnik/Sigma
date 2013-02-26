package fr.unice.i3s.sigma.scala.codegen

import scala.collection.JavaConversions.asScalaBuffer

import org.eclipse.emf.codegen.ecore.genmodel.GenBase
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.scala.EcoreBuilder
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport
import org.eclipse.emf.ecore.util.EcoreUtil

import fr.unice.i3s.sigma.scala.SigmaScalaDelegateDomain

object ScalaEcoreExtensionsGenClassGeneratorAdapter {
  val ENABLE_SCALA_ECORE_EXTENSION = "EnableScalaEcoreExtension"
}

class ScalaEcoreExtensionsGenClassGeneratorAdapter(val domain: SigmaScalaDelegateDomain, factory: ScalaEcoreExtensionsGeneratorAdapterFactory)
  extends GenBaseGeneratorAdapter(factory) with EcorePackageScalaSupport {

  import ScalaEcoreExtensionsGenClassGeneratorAdapter._

  val builder = new EcoreBuilder

  override def doPreGenerate(`object`: Any, projectType: Any): Diagnostic = {
    val genClazz = `object`.asInstanceOf[GenClass];

    if ((projectType == GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE) && isScalaExtensionEnabled(genClazz)) {
      try
        processClass(genClazz)
      catch {
        case e: Throwable ⇒
          e.printStackTrace
      }
    }

    return super.doPreGenerate(`object`, projectType)
  }

  def processClass(genClazz: GenClass) {
    val im = genClazz.getGenModel.getImportManager;

    for (genFeature ← genClazz.getGenFeatures.toList) {
      val feature = genFeature.getEcoreFeature

      val op = builder.eOperation()

      op.name = feature.name
      op.lowerBound = feature.lowerBound
      op.upperBound = feature.upperBound
      op.ordered = feature.ordered
      op.unique = feature.unique

      genClazz.getEcoreClass().eOperations += op

      val doc =
        s"""|Scala compatible getter method for {@code ${genFeature.getName}} property,
            |delegating to {@code ${genFeature.getGetAccessor}()}
            |
            |@return the value of the '<em>${genFeature.getFormattedName}</em>' ${genFeature.getFeatureKind()}.
            |@see #${genFeature.getGetAccessor}
            |""".stripMargin
      EcoreUtil.setDocumentation(op, doc)

      val option = !feature.required && !feature.many
      if (option) {
        op.eGenericType = createOption(feature.eType, genClazz.getGenPackage)

        val body = "return %s.<%s>apply(%s());" format (
          im.getImportedName(classOf[Option[_]].getName, true),
          genFeature.getImportedType(genClazz),
          genFeature.getGetAccessor())

        installBody(op, body)
      } else {
        op.eType = feature.eType
        val body = "return " + genFeature.getGetAccessor() + "();"

        installBody(op, body)
      }
    }

    genClazz.initialize(genClazz.getEcoreClass)
  }

  def installBody(op: EOperation, body: String) {
    EcoreUtil.setAnnotation(op, GenModelPackage.eNS_URI, "body", body);
  }

  def createOption(nested: EClassifier, genPkg: GenPackage) = {
    val pkg = genPkg.getEcorePackage

    var option = pkg.getEClassifier("Option")
    if (option == null) {
      option = builder.eDataType()
      option.setName("Option")
      option.setInstanceTypeName("scala.Option")
      option.getETypeParameters().add {
        val T = builder.eTypeParameter()
        T.setName("T")
        T
      }
      pkg.getEClassifiers.add(option)
      genPkg.initialize(pkg)

      // add to the model
      addDependencyToScalaLib(genPkg.getGenModel)
    }

    val genericType = builder.eGenericType()
    genericType.eClassifier = option
    val aT = builder.eGenericType()
    aT.eClassifier = nested
    genericType.eTypeArguments += aT

    genericType
  }

  def addDependencyToScalaLib(genModel: GenModel) {
    val scalaLib = "org.scala-ide.scala.library"
    if (!genModel.getModelPluginVariables.contains(scalaLib)) {
      genModel.getModelPluginVariables.add(scalaLib)
    }
  }

  def isScalaExtensionEnabled(genClazz: GenClass) = {
    def findAnnotation(genBase: GenBase, source: String, key: String): Option[String] = {
      val value = Option(genBase.getGenAnnotation(source))
        .map(_.getDetails.get(key))
        .orNull

      if (value != null) Some(value)
      else genBase match {
        case clazz: GenClass ⇒ findAnnotation(clazz.getGenPackage, source, key)
        case pkg: GenPackage if pkg.getSuperGenPackage != null ⇒ findAnnotation(pkg.getSuperGenPackage, source, key)
        case pkg: GenPackage ⇒ findAnnotation(pkg.getGenModel, source, key)
        case model: GenModel ⇒ None
      }
    }

    val enabled = findAnnotation(genClazz, domain.getURI, ENABLE_SCALA_ECORE_EXTENSION)
    enabled match {
      case Some(value) ⇒ value.toBoolean
      case None ⇒ false
    }

  }

}
package fr.unice.i3s.sigma.scala.codegen

import fr.unice.i3s.sigma.scala.utils._
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter
import org.eclipse.emf.codegen.ecore.genmodel.GenModel
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.codegen.ecore.genmodel.GenBase
import fr.unice.i3s.sigma.scala.SigmaScalaDelegateDomain
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.EOperation

object ScalaEcoreExtensionsGenClassGeneratorAdapter {
  val ENABLE_SCALA_ECORE_EXTENSION = "EnableScalaEcoreExtension"
}

class ScalaEcoreExtensionsGenClassGeneratorAdapter(val domain: SigmaScalaDelegateDomain, factory: ScalaEcoreExtensionsGeneratorAdapterFactory) extends GenBaseGeneratorAdapter(factory) {

  import ScalaEcoreExtensionsGenClassGeneratorAdapter._

  override def doPreGenerate(`object`: Any, projectType: Any): Diagnostic = {
    val genClazz = `object`.asInstanceOf[GenClass];

    if ((projectType == GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE) && isScalaExtensionEnabled(genClazz)) {
      processClass(genClazz)
    }

    return super.doPreGenerate(`object`, projectType)
  }

  def processClass(genClazz: GenClass) {
    val im = genClazz.getGenModel.getImportManager;

    for (genFeature <- genClazz.getGenFeatures) {
      val feature = genFeature.getEcoreFeature
      val op = EcoreFactory.eINSTANCE.createEOperation()
      genClazz.getEcoreClass().getEOperations.add(op)

      val option = !feature.isRequired && !feature.isMany

      op.setName(feature.getName)
      op.setLowerBound(feature.getLowerBound())
      op.setUpperBound(feature.getUpperBound())
      op.setOrdered(feature.isOrdered())
      op.setUnique(feature.isUnique())

      val doc =
        s"""|Scala compatible getter method for {@code ${genFeature.getName}} property,
            |delegating to {@code ${genFeature.getGetAccessor}()}
            |
            |@return the value of the '<em>${genFeature.getFormattedName}</em>' ${genFeature.getFeatureKind()}.
            |@see #${genFeature.getGetAccessor}
            |""".stripMargin
      EcoreUtil.setDocumentation(op, doc)

      if (option) {
        op.setEGenericType(createOption(feature.getEType, genClazz.getGenPackage))
        val body = "return %s.<%s>apply(%s());" format (
          im.getImportedName(classOf[Option[_]].getName, true),
          genFeature.getImportedType(genClazz),
          genFeature.getGetAccessor())

        installBody(op, body)
      } else {
        op.setEType(feature.getEType())
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
      option = EcoreFactory.eINSTANCE.createEDataType;
      option.setName("Option")
      option.setInstanceTypeName("scala.Option")
      option.getETypeParameters().add {
        val T = EcoreFactory.eINSTANCE.createETypeParameter
        T.setName("T")
        T
      }
      pkg.getEClassifiers.add(option)
      genPkg.initialize(pkg)

      // add to the model
      addDependencyToScalaLib(genPkg.getGenModel)
    }

    val genericType = EcoreFactory.eINSTANCE.createEGenericType
    genericType.setEClassifier(option)
    val aT = EcoreFactory.eINSTANCE.createEGenericType
    aT.setEClassifier(nested)
    genericType.getETypeArguments().add(aT)

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
        case clazz: GenClass => findAnnotation(clazz.getGenPackage, source, key)
        case pkg: GenPackage if pkg.getSuperGenPackage != null => findAnnotation(pkg.getSuperGenPackage, source, key)
        case pkg: GenPackage => findAnnotation(pkg.getGenModel, source, key)
        case model: GenModel => None
      }
    }

    val enabled = findAnnotation(genClazz, domain.getURI, ENABLE_SCALA_ECORE_EXTENSION)
    enabled match {
      case Some(value) => value.toBoolean
      case None => false
    }

  }

}
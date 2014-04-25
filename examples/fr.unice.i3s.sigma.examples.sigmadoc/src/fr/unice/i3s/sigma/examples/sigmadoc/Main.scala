package fr.unice.i3s.sigma.examples.sigmadoc

import java.io.File

import scala.util.Failure
import scala.util.Success
import scala.util.Try

import org.eclipse.emf.ecore.EcorePackage

import fr.unice.i3s.sigma.support.SigmaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore._
import fr.unice.i3s.sigma.util.EMFUtils
import fr.unice.i3s.sigma.util.IOUtils

object Main extends App with EcorePackageScalaSupport with SigmaSupport {

  class Options(var destination: String, var graphviz: Option[String], var modelFile: File)

  object Options {
    val Usage =
      s"""|Usage: Main [-destination outputDir] [-dot pathToDot] MetaModelFile
          |
          |where:
          |- outputDir     is is the directory in which the documentation will be generated.
	      |- pathToDot     is the path to the GraphViz dot executable.
	      |- MetaModelFile is an EMF meta-model file.""".stripMargin // egldoc also only supports EMF

    def apply(args: List[String]) = {
      if (args.isEmpty) throw new Exception("Missing MetaModelFile")

      val defOutputDir = System.getProperty("user.dir") +
        System.getProperty("file.separator") +
        "output";

      val options = new Options(defOutputDir, None, null)

      def nextOption(args: List[String]): Unit = args match {
        case Nil ⇒ // we are done 
        case "-destination" :: value :: tail ⇒
          options.destination = value
          nextOption(tail)
        case "-dot" :: value :: tail ⇒
          options.graphviz = Some(value)
          nextOption(tail)
        case value :: opt :: tail if opt(0) == '-' ⇒
          options.modelFile = new File(value)
          nextOption(args.tail)
        case value :: Nil ⇒
          options.modelFile = new File(value)
          nextOption(args.tail)
        case option :: tail ⇒
          throw new Exception(s"Unknown option $option")
      }

      nextOption(args)
      options
    }
  }

  def file(path: String) = {
    val f = new File(path)
    val p = f.getParentFile
    if (!p.exists()) assert(p.mkdirs())
    f
  }

  def execute(options: Options) {
    def pFilename(p: EPackage) = s"${p.name}-package-index.html"
    def cFilename(c: EClassifier) = s"${c.ePackage.name}-${c.name}.html"

    EMFUtils.IO.registerDefaultFactories
    EcorePackage.eINSTANCE.getEFactoryInstance()

    // load model
    val res = EMFUtils.IO.loadResourceFromFile(options.modelFile, true)

    // overview figure
    val metaModelOverviewFigureOpt = options.graphviz match {
      case Some(graphviz) =>
        val dotFile = File.createTempFile("dot", ".dot")
        val pngFile = file(options.destination + s"/${options.modelFile.getName}-overview.png")
        val dot = new Ecore2Dot
        
        dot.transform(res) >> dotFile 
        val cmd = s"$graphviz -Tpng ${dotFile.getAbsolutePath} -o ${pngFile.getAbsolutePath}"
        println(cmd)
        IOUtils.SystemExecutor.execute(cmd) match {
          case Success(_) =>
          case Failure(e) =>
            println(s"""|Error encountered whilst generating png.
                        |\tpathToDot: ${dotFile.getAbsolutePath}
                        |\tinputFile: ${pngFile.getAbsolutePath}
                        |Errors: $e""".stripMargin)
            sys.exit(1)
        }
        
        Some(pngFile.getName)
      case None => None
    }

    // instantiate templates
    val ecore2html = new Ecore2HTML {
      metaModelName = options.modelFile.getName
      pkgFilename = pFilename
      clsFilename = cFilename
    }
    val indexPage = new ecore2html.IndexPage {
      metaModelOverviewFigure = metaModelOverviewFigureOpt.getOrElse("")
    }
    val packagePage = new ecore2html.PackagePage {
      metaModelOverviewFigure = metaModelOverviewFigureOpt.getOrElse("")
    }
    val dataTypePage = new ecore2html.DataTypePage
    val enumPage = new ecore2html.EnumPage
    val classPage = new ecore2html.ClassPage

    // run the template    
    indexPage.transform(res) >> file(options.destination + "/index.html")
    for (p ← res.contents[EPackage]) {
      for (c ← p.eClassifiers) {
        val classifier  = c match {
          case enum: EEnum ⇒ enumPage.transform(enum)
          case dt: EDataType ⇒ dataTypePage.transform(dt)
          case cls: EClass ⇒ classPage.transform(cls)
        } 
        classifier >> file(options.destination + "/" + cFilename(c))
      }
      packagePage.transform(p) >> file(options.destination + "/" + pFilename(p))
    }

    // copy common files
    this.getClass.getResourceAsStream("resources/css/screen.css") >> file(options.destination + "/css/screen.css")
    this.getClass.getResourceAsStream("resources/img/arrow_up.png") >> file(options.destination + "/img/arrow_up.png")
    this.getClass.getResourceAsStream("resources/scripts/controls.js") >> file(options.destination + "/scripts/controls.js")
  }

  Try {
    Options(args.toList)
  } match {
    case Success(options) ⇒ execute(options)
    case Failure(ex) ⇒
      println(Options.Usage)
      sys.exit(1)
  }
}
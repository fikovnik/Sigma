package fr.inria.spirals.sigma.ttc14.fixml

import java.io.File

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Class
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.unice.i3s.sigma.m2t.M2TF
import fr.unice.i3s.sigma.support.ScalaSigmaSupport
import fr.unice.i3s.sigma.util.IOUtils

object Main extends App with ScalaSigmaSupport with ObjLang {

  // currently implemented drivers
  val drivers = Seq(
    ("java", M2TF(
      (new ObjLang2Java, { s: Class ⇒ s"${s.name}.java" }))),
    ("cs", M2TF(
      (new ObjLang2CSharp, { s: Class ⇒ s"${s.name}.cs" }))),
    ("cpp", M2TF(
      (new ObjLang2CPP, { s: Class ⇒ s"${s.name}.cpp" }),
      (new ObjLang2HPP, { s: Class ⇒ s"${s.name}.h" }))))

  def execute(src: File, dest: File) {

    if (dest.isDirectory) {
      println(s"Cleaning directory ${dest}")
      IOUtils.rmdir(dest, false, true)
    } else {
      println(s"Creating output directory ${dest}")
      IOUtils.mkdirs(dest)
    }

    val files = if (src.isDirectory) {
      src.listFiles filter (_.getName.endsWith("xml"))
    } else {
      Array(src)
    }

    val m2m = new XMLMM2ObjLang
    
    for {
      file ← files
      (ext, m2tf) ← drivers
    } {
      println(s"Processing $file -> $ext")

      val fixml = FIXMLParser.parseFromFile(file) orCrash s"Unable to load FIXML from ${src}"

      val output = new File(new File(dest, file.getName), ext)
      IOUtils.mkdirs(output)

      val targets = m2m.transform(fixml)
      targets collect { case c: Class ⇒ c } foreach { m2tf.transform(_, output) }
    }
  }

  val Usage =
    s"""|Usage: Main <src> <dest>
        |
        |where:
        |- src     is is FIXML 4.4 message file or a directory with multiple FIXML 4.4 messages
	    |- dest    is the output directory where the source code should generated.""".stripMargin

  if (args.size != 2) {
    println(Usage)
    sys.exit(1)
  }

  execute(new File(args(0)), new File(args(1)))

}
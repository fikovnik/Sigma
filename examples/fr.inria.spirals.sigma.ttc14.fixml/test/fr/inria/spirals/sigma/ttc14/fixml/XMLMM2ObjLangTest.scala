package fr.inria.spirals.sigma.ttc14.fixml

import org.scalatest.Matchers
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM._xmlmm._
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.util.EMFUtils
import java.io.File
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang
import fr.inria.spirals.sigma.ttc14.fixml.objlang.support.ObjLang._objlang._
import fr.unice.i3s.sigma.support.ScalaSigmaSupport
import scala.util.Success
import scala.util.Failure
import fr.unice.i3s.sigma.util.IOUtils

@RunWith(classOf[JUnitRunner])
class XMLMM2ObjLangTest extends FlatSpec with Matchers with XMLMM with ScalaSigmaSupport {

  "XMLMM -> ObjLang" should "trasform" in {

    val test =
      <FIXML>
        <car>
          <engine name="A"/>
          <engine type="B"/>
          <engine>
            <part serial="C"/>
            <part serial="C" subpart="1"/>
          </engine>
        </car>
      </FIXML>

    val fixml = FIXMLParser.parse(test).get
    fixml foreach (_.sDump())

    val m2m = new XMLMM2ObjLang

    val targets = m2m.transform(fixml.head)

    targets foreach (_.sDump())
    
    println("\nNo container\n")
    
    targets filter {_.eContainer == null}  foreach (println(_))

    EMFUtils.IO.registerDefaultFactories
    EMFUtils.IO.saveToFile(new File("test1.xmi"), targets)

    val m2t = new ObjLang2Java
    val code = targets collect { case x: Class ⇒ m2t.transform(x) }
    println(code)

  }

//  it should "transform the test cases" in {
//    val m2ts = Map(
//      "java" -> (new XMLMM2Java, new ObjLang2Java),
//      "cs" -> (new XMLMM2CSharp, new ObjLang2CSharp),
//      "cpp" -> (new XMLMM2CPP, new ObjLang2CPPWithInitializerList)
//    )
//
//    for (file ← Set("test1.xml", "test2.xml", "test5.xml", "test6.xml")) {
//      FIXMLParser.parseFromURL(classOf[FIXMLParserTest].getResource(s"resources/$file")) match {
//        case Success(fixml) ⇒
//
//          for ((ext, (m2m, m2t)) ← m2ts) {
//            val targets = m2m.transform(fixml.head)
//            val code = targets collect { case x: Class ⇒ m2t.transform(x) } mkString ("\n\n")
//
//            code >> new File(file + "." + ext)
//          }
//
//        case Failure(e) ⇒ fail(s"File $file is a file - should not fail", e)
//      }
//    }
//  }

}
package fr.unice.i3s.sigma.docgen.graphviz.common

import scala.collection.JavaConversions._
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.scala.mtt.TextTemplateTest
import org.eclipse.emf.ecore.scala.EcorePackageScalaSupport
import org.eclipse.emf.ecore.scala.EcoreBuilder

@RunWith(classOf[JUnitRunner])
class ClassDiagramSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport {

  val builder = new EcoreBuilder
  import builder._

  val pkg = ePackage(name = "MyPackage", nsURI = "http://mypkg", nsPrefix = "my")

  "ClassDiagram" must "must render a generalization" in {

    val classA = eClass(name = "A")
    val classB = eClass(name = "B", eSuperTypes = List(classA))
    pkg.eClassifiers += (classA, classB)

    val diag = new ClassDiagram(pkg) with TextTemplateTest
    diag.renderGeneralization(classB, classA)

    // actually we only need to check the first row
    diag.toString.split("\n").head must be ===
      "MyPackage__A:port -> MyPackage__B:port ["

  }

  it must "must render a data type" in {

    val dataTypeA = eDataType(name = "A", instanceClassName = "java.util.A")
    pkg.eClassifiers += dataTypeA

    val diag = new ClassDiagram(pkg) with TextTemplateTest
    diag.renderDataType(dataTypeA)

    diag.toString must be ===
      """|MyPackage__A [
         |  label =  <
		 |    <TABLE bgcolor="white" border="0" cellspacing="0" cellpadding="0" cellborder="0" port="port">
		 |    <TR><TD>
		 |    <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
		 |    <TR><TD>«datatype»</TD></TR>
		 |    <TR><TD>A</TD></TR>
		 |    </TABLE>
		 |    </TD></TR>
		 |    <TR><TD>
		 |    <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
		 |    <TR><TD align="left">«javaclass» java.util.A</TD></TR>
		 |    </TABLE>
		 |    </TD></TR>
		 |    </TABLE>
		 |  >
		 |]""".stripMargin
  }

  it must "must render an enum" in {

    val enumA = eEnum(name = "A", eLiterals = List(eEnumLiteral(name = "ValueA"), eEnumLiteral(name = "ValueB")))
    pkg.eClassifiers += enumA

    val diag = new ClassDiagram(pkg) with TextTemplateTest
    diag.renderEnum(enumA)

    diag.toString must be ===
      """|MyPackage__A [
         |  label =  <
		 |    <TABLE bgcolor="white" border="0" cellspacing="0" cellpadding="0" cellborder="0" port="port">
		 |    <TR><TD>
		 |    <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
		 |    <TR><TD>«enumeration»</TD></TR>
		 |    <TR><TD>A</TD></TR>
		 |    </TABLE>
		 |    </TD></TR>
		 |    <TR><TD>
		 |    <TABLE border="1" cellborder="0" cellpadding="3" cellspacing="0" align="left">
         |    <TR><TD align="left">- ValueA</TD></TR>
		 |    <TR><TD align="left">- ValueB</TD></TR>
		 |    </TABLE>
		 |    </TD></TR>
		 |    </TABLE>
		 |  >
		 |]""".stripMargin
  }

}
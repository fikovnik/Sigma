package fr.unice.i3s.sigma.docgen.common

import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers

import fr.unice.i3s.sigma.m2t.TextTemplateTesting
import fr.unice.i3s.sigma.support.EMFScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport

@RunWith(classOf[JUnitRunner])
class ClassDiagramSpec extends FlatSpec with MustMatchers with EcorePackageScalaSupport with EMFScalaSupport {

  val pkg = EPackage(name = "MyPackage", nsURI = "http://mypkg", nsPrefix = "my")

  "ClassDiagram" must "must render a generalization" in {

    val classA = EClass(name = "A")
    val classB = EClass(name = "B", eSuperTypes = Seq(classA))
    pkg.eClassifiers ++= Seq(classA, classB)

    val diag = new ClassDiagram with TextTemplateTesting {
      rootElement = pkg
    }
    diag.renderGeneralization(classB, classA)

    // actually we only need to check the first row
    diag.partial.split("\n").head must be ===
      "MyPackage__A:port -> MyPackage__B:port ["

  }

  it must "must render a data type" in {

    val dataTypeA = EDataType(name = "A", instanceClassName = "java.util.A")
    pkg.eClassifiers += dataTypeA

    val diag = new ClassDiagram with TextTemplateTesting {
      rootElement = pkg
    }
    diag.renderDataType(dataTypeA)

    diag.partial must be ===
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
		 |]
         |""".stripMargin
  }

  it must "must render an enum" in {

    val enumA = EEnum(name = "A", eLiterals = Seq(EEnumLiteral(name = "ValueA"), EEnumLiteral(name = "ValueB")))
    pkg.eClassifiers += enumA

    val diag = new ClassDiagram with TextTemplateTesting {
      rootElement = pkg
    }
    diag.renderEnum(enumA)

    diag.partial must be ===
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
  		 |]
         |""".stripMargin
  }

}
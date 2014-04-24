package fr.inria.spirals.sigma.ttc14.fixml

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.util.Success
import scala.util.Failure
import org.xml.sax.SAXParseException

@RunWith(classOf[JUnitRunner])
class FIXMLParserTest extends FlatSpec with Matchers with XMLMM {

  "FIXMLParser" should "load the test1.xml" in {
    
    val fixml = FIXMLParser.parseFromURL(classOf[FIXMLParserTest].getResource("resources/test1.xml"))

    fixml shouldBe a[Success[_]]
    fixml.get should have size (1)

    val order = fixml.get.toSeq(0)

    order.tag shouldBe "Order"
    order.attributes.map { a ⇒ (a.name, a.value) }.toSet shouldBe Set(
      ("ClOrdID", "123456"),
      ("Side", "2"),
      ("TransactTm", "2001-09-11T09:30:47-05:00"),
      ("OrdTyp", "2"),
      ("Px", "93.25"),
      ("Acct", "26522154")
    )

    order.subnodes should have size (3)

    val hdr = order.subnodes(0)
    hdr.tag shouldBe "Hdr"

    hdr.attributes.map { a ⇒ (a.name, a.value) }.toSet shouldBe Set(
      ("Snt", "2001-09-11T09:30:47-05:00"),
      ("PosDup", "N"),
      ("PosRsnd", "N"),
      ("SeqNum", "521")
    )

    hdr.subnodes should have size (2)
    hdr.subnodes(0).tag shouldBe "Sndr"
    hdr.subnodes(0).attributes(0).toString shouldBe "ID=AFUNDMGR"

    hdr.subnodes(1).tag shouldBe "Tgt"
    hdr.subnodes(1).attributes(0).toString shouldBe "ID=ABROKER"

    val instrmt = order.subnodes(1)
    instrmt.attributes.map { a ⇒ (a.name, a.value) }.toSet shouldBe Set(
      ("Sym", "IBM"),
      ("ID", "459200101"),
      ("IDSrc", "1")
    )

    val ordqty = order.subnodes(2)
    ordqty.tag shouldBe "OrdQty"
    ordqty.attributes(0).toString shouldBe "Qty=1000"

    
    for (file <- Set("test2.xml", "test5.xml", "test6.xml"))
      FIXMLParser.parseFromURL(classOf[FIXMLParserTest].getResource(s"resources/$file")) match {
      case Success(_) => 
      case Failure(e) => fail(s"File $file is a file - should not fail", e)
    }     
  }

  it should "fail grecefully on FIXML DTD versions" in {
    // all these appears to be invalid
    for (file <- Set("test3.xml", "test4.xml"))
      FIXMLParser.parseFromURL(classOf[FIXMLParserTest].getResource(s"resources/$file")) match {
      case Success(_) => fail(s"File $file is FIXML DTD Version - should fail")
      case Failure(e) => e.getMessage shouldBe "FIXML DTD Version is not supported"
    }     
  }
  
  it should "fail gracefully on wrong input" in {
    // missing FIXML
    val xml1 = """<?xml version="1.0" encoding="ASCII"?>
        <Instrmt Sym="IBM"
                    ID="459200101"
                    IDSrc="1"/>
        """

    FIXMLParser.parseFromText(xml1) match {
      case Success(_) => fail(s"FIXML is missing - should fail")
      case Failure(e) => e.getMessage shouldBe "No matching FIXML tag found"
    } 
    
    // all these appears to be invalid
    for (file <- Set("test7.xml", "test8.xml"))
      FIXMLParser.parseFromURL(classOf[FIXMLParserTest].getResource(s"resources/$file")) match {
      case Success(_) => fail(s"File $file is not a valid XML file - should fail")
      case Failure(e) => e.getCause shouldBe a[SAXParseException]
    } 

  }

}
package fr.inria.spirals.sigma.ttc14.fixml

import java.net.URL
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import scala.xml.Elem
import scala.xml.MetaData
import scala.xml.Node
import scala.xml.Source
import scala.xml.XML
import org.xml.sax.InputSource
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM
import fr.inria.spirals.sigma.ttc14.fixml.xmlmm.support.XMLMM._xmlmm._
import scala.xml.Utility
import java.io.File

class FIXMLParserException(message: String, cause: Throwable = null) extends Exception(message, cause)

object FIXMLParser extends XMLMM {

  def parseFromText(text: String): Try[Iterable[XMLNode]] =
    parseFromInputSource(Source.fromString(text))

  def parseFromFile(filename: String): Try[Iterable[XMLNode]] =
    parseFromInputSource(Source.fromFile(filename))

  def parseFromFile(file: File): Try[Iterable[XMLNode]] =
    parseFromInputSource(Source.fromFile(file))

  def parseFromURL(url: URL): Try[Iterable[XMLNode]] =
    parseFromInputSource(Source.fromInputStream(url.openStream()))

  def parseFromInputSource(in: InputSource): Try[Iterable[XMLNode]] =
    Try(XML.load(in)) match {
      case Success(fixml) ⇒ parse(fixml)
      case Failure(e) ⇒ Failure(new FIXMLParserException(s"Unable to parse XML file: $e", e))
    }

  def parse(root: Node): Try[Iterable[XMLNode]] =
    Utility.trim(root) match {
      case <FIXML><FIXMLMessage>{ _* }</FIXMLMessage></FIXML> ⇒ Failure(new FIXMLParserException("FIXML DTD Version is not supported"))
      case <FIXML>{ tags @ _* }</FIXML> ⇒ Success(parseNodes(tags))
      case _ ⇒ Failure(new FIXMLParserException("No matching FIXML tag found"))
    }

  protected def parseAttributes(metaData: MetaData): Iterable[XMLAttribute] =
    metaData collect {
      case e: xml.Attribute ⇒ XMLAttribute(name = e.key, value = e.value.toString)
    }

  protected def parseNodes(nodes: Iterable[Node]): Iterable[XMLNode] = {
    // discard any XML PCDATA nodes
    val elems = nodes collect { case e: Elem ⇒ e }

    // convert all nodes into XMLNode
    for (elem ← elems) yield XMLNode(
      tag = elem.label,
      subnodes = parseNodes(elem.child),
      attributes = parseAttributes(elem.attributes))
  }

}
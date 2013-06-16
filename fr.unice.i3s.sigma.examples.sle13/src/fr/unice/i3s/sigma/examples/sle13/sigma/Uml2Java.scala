package fr.unice.i3s.sigma.examples.sle13.sigma

import fr.unice.i3s.sigma.m2t.TextTemplate
import uml.support.UmlPackageScalaSupport
import uml.support.UmlPackageScalaSupport.UmlClass

case class Uml2Java(cls: UmlClass) extends TextTemplate with UmlPackageScalaSupport {

  // main template
  def render() =
    !s"public class ${cls.name}" curlyIndent {
      !endl // extra new line 
      for (o ← cls.operations)
        genOperation(o) << endl // call to another template
    }

  def genOperation(o: Operation) =
    !s"public ${o.returnType.name} ${o.name}()" curlyIndent {
      genOperationBody(o)
    }

  def genOperationBody(o: Operation) = !s"""
   // TODO: should be implemented
   throw new UnsupportedOperationException("${o.name}");
   """

}
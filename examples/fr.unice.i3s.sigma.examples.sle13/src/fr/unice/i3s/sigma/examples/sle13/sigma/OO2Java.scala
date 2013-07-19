package fr.unice.i3s.sigma.examples.sle13.sigma

import oo.support.OOPackageScalaSupport
import fr.unice.i3s.sigma.m2t.TextTemplate

class OO2Java extends TextTemplate with OOPackageScalaSupport { 
  type M2TSource = Class // input type for this transformation
  
  // main template
  protected def execute =
    !s"public class ${source.name}" curlyIndent {
      !endl // extra new line
   
      for (o <- source.operations) {
        genOperation(o) // call to another template
        !endl // extra new line
      }
    }
    
  def genOperation(o: Operation) =
    !s"public ${o.returnType.name} ${o.name}()" curlyIndent {
      !s"""
      // TODO: should be implemented
      throw new UnsupportedOperationException("${o.name}");
      """
    } 
}
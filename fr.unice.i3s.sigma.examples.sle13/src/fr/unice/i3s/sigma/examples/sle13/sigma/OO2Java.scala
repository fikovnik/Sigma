package fr.unice.i3s.sigma.examples.sle13.sigma

import fr.unice.i3s.sigma.m2t.M2T
import oo.support.OOPackageScalaSupport

class OO2Java extends M2T with OOPackageScalaSupport { 
  type Root = Class // input type for this transformation
  
  // main template
  def render =
    !s"public class ${root.name}" curlyIndent {
      !endl // extra new line
   
      for (o <- root.operations) {
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
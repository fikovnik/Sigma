package fr.unice.i3s.sigma.examples.pl14.sigma

import oo.support.OOPackageScalaSupport
import fr.unice.i3s.sigma.m2t.TextTemplate

class OO2Java extends TextTemplate with OOPackageScalaSupport {
  type M2TSource = Class

  // main template
  protected def execute =
    !s"public class ${source.name}" curlyIndent {
      !endl

      !"// fields"
      source.properties foreach genField
      !endl
      
      !"// getters"
      source.properties foreach genGetter
      ! endl
      
      !"// setters"
      source.properties foreach genSetter
      !endl      
      
      !"// operations"
      source.operations foreach genOperation
    }

  def genGetter(o: Property) =
    !s"public ${o.getType.name} get${o.name.capitalize}()" curlyIndent {
      !s"return ${o.name};"
    }

  def genSetter(o: Property) =
    !s"public void set${o.name.capitalize}()" curlyIndent {
      !s"this.${o.name} = ${o.name};"
    }

  def genField(o: Property) =
    !s"private ${o.getType.name} ${o.name};"

  def genOperation(o: Operation) = {
    !s"public ${o.returnType.name} ${o.name}()" curlyIndent {
      !s"""
      // TODO: should be implemented
      throw new UnsupportedOperationException("${o.name}");
      """
    }
  }
}
package Relational.support

import Relational.EnumeratedLiteral;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait EnumeratedLiteralScalaSupport extends EMFScalaSupport {
  type EnumeratedLiteral = Relational.EnumeratedLiteral
  
  object EnumeratedLiteral {
    def apply(name: String = null): EnumeratedLiteral = {
      val _instance = Relational.RelationalFactory.eINSTANCE.createEnumeratedLiteral
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object EnumeratedLiteralScalaSupport extends EnumeratedLiteralScalaSupport

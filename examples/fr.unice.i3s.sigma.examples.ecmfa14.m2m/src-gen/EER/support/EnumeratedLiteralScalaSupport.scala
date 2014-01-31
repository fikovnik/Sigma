package EER.support

import EER.EnumeratedLiteral;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait EnumeratedLiteralScalaSupport extends EMFScalaSupport {
  type EnumeratedLiteral = EER.EnumeratedLiteral
  
  object EnumeratedLiteral {
    def apply(name: String = null): EnumeratedLiteral = {
      val _instance = EER.EERFactory.eINSTANCE.createEnumeratedLiteral
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object EnumeratedLiteralScalaSupport extends EnumeratedLiteralScalaSupport

package Relational.support

import Relational.EnumeratedLiteral;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait EnumeratedLiteralScalaSupport extends EMFScalaSupport {
  type EnumeratedLiteral = Relational.EnumeratedLiteral
  
  protected implicit val _enumeratedliteralProxyBuilder = new EMFProxyBuilder[EnumeratedLiteral](RelationalPackageScalaSupport._relationalBuilder)
  
  object EnumeratedLiteral {
    def apply(name: String = null): EnumeratedLiteral = {
      val _instance = RelationalPackageScalaSupport._relationalBuilder.create[EnumeratedLiteral]
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object EnumeratedLiteralScalaSupport extends EnumeratedLiteralScalaSupport

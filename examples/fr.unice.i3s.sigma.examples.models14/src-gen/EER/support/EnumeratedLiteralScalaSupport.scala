package EER.support

import EER.EnumeratedLiteral;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait EnumeratedLiteralScalaSupport extends EMFScalaSupport {
  type EnumeratedLiteral = EER.EnumeratedLiteral
  
  protected implicit val _enumeratedliteralProxyBuilder = new EMFProxyBuilder[EnumeratedLiteral](EERPackageScalaSupport._eerBuilder)
  
  object EnumeratedLiteral {
    def apply(name: String = null): EnumeratedLiteral = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[EnumeratedLiteral]
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object EnumeratedLiteralScalaSupport extends EnumeratedLiteralScalaSupport

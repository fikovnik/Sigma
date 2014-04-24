package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait NullLiteralScalaSupport extends EMFScalaSupport {
  type NullLiteral = fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral
  
  protected implicit val _nullliteralProxyBuilder = new EMFProxyBuilder[NullLiteral](ObjLang._objlangBuilder)
  
  object NullLiteral {
    def apply(): NullLiteral = {
      val _instance = ObjLang._objlangBuilder.create[NullLiteral]
      
      
      _instance
    }
  }
}

object NullLiteralScalaSupport extends NullLiteralScalaSupport

package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait IntegerLiteralScalaSupport extends EMFScalaSupport {
  type IntegerLiteral = fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral
  
  protected implicit val _integerliteralProxyBuilder = new EMFProxyBuilder[IntegerLiteral](ObjLang._objlangBuilder)
  
  object IntegerLiteral {
    def apply(value: Int = 0): IntegerLiteral = {
      val _instance = ObjLang._objlangBuilder.create[IntegerLiteral]
      
      if (value != 0) _instance.setValue(value)
      
      _instance
    }
    
    def unapply(that: IntegerLiteral): Option[(Int)] =
      Some((that.getValue))
  }
}

object IntegerLiteralScalaSupport extends IntegerLiteralScalaSupport

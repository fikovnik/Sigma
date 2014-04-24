package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait StringLiteralScalaSupport extends EMFScalaSupport {
  type StringLiteral = fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral
  
  protected implicit val _stringliteralProxyBuilder = new EMFProxyBuilder[StringLiteral](ObjLang._objlangBuilder)
  
  object StringLiteral {
    def apply(value: String = null): StringLiteral = {
      val _instance = ObjLang._objlangBuilder.create[StringLiteral]
      
      if (value != null) _instance.setValue(value)
      
      _instance
    }
    
    def unapply(that: StringLiteral): Option[(String)] =
      Some((that.getValue))
  }
}

object StringLiteralScalaSupport extends StringLiteralScalaSupport

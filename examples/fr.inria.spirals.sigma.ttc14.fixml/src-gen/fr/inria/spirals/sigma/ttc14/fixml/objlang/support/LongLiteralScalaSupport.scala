package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait LongLiteralScalaSupport extends EMFScalaSupport {
  type LongLiteral = fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral
  
  protected implicit val _longliteralProxyBuilder = new EMFProxyBuilder[LongLiteral](ObjLang._objlangBuilder)
  
  object LongLiteral {
    def apply(value: Long = 0L): LongLiteral = {
      val _instance = ObjLang._objlangBuilder.create[LongLiteral]
      
      if (value != 0L) _instance.setValue(value)
      
      _instance
    }
    
    def unapply(that: LongLiteral): Option[(Long)] =
      Some((that.getValue))
  }
}

object LongLiteralScalaSupport extends LongLiteralScalaSupport

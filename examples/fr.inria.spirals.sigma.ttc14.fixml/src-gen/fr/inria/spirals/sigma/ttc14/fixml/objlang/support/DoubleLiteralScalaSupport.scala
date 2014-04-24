package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait DoubleLiteralScalaSupport extends EMFScalaSupport {
  type DoubleLiteral = fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral
  
  protected implicit val _doubleliteralProxyBuilder = new EMFProxyBuilder[DoubleLiteral](ObjLang._objlangBuilder)
  
  object DoubleLiteral {
    def apply(value: Double = 0.0): DoubleLiteral = {
      val _instance = ObjLang._objlangBuilder.create[DoubleLiteral]
      
      if (value != 0.0) _instance.setValue(value)
      
      _instance
    }
    
    def unapply(that: DoubleLiteral): Option[(Double)] =
      Some((that.getValue))
  }
}

object DoubleLiteralScalaSupport extends DoubleLiteralScalaSupport

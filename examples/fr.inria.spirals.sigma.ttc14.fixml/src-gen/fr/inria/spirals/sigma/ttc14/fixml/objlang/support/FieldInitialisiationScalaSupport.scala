package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Field;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait FieldInitialisiationScalaSupport extends EMFScalaSupport {
  type FieldInitialisiation = fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation
  
  protected implicit val _fieldinitialisiationProxyBuilder = new EMFProxyBuilder[FieldInitialisiation](ObjLang._objlangBuilder)
  
  object FieldInitialisiation {
    def apply(field: Field = null, expression: Expression = null): FieldInitialisiation = {
      val _instance = ObjLang._objlangBuilder.create[FieldInitialisiation]
      
      if (field != null) _instance.setField(field)
      if (expression != null) _instance.setExpression(expression)
      
      _instance
    }
    
    def unapply(that: FieldInitialisiation): Option[(Field,Expression)] =
      Some((that.getField,that.getExpression))
  }
}

object FieldInitialisiationScalaSupport extends FieldInitialisiationScalaSupport

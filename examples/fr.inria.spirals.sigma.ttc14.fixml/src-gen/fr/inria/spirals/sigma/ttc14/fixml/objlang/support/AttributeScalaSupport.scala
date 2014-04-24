package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AttributeScalaSupport extends EMFScalaSupport {
  type Attribute = fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute
  
  protected implicit val _attributeProxyBuilder = new EMFProxyBuilder[Attribute](ObjLang._objlangBuilder)
  
  object Attribute {
    def apply(name: String = null, initialValue: Expression = null, type_ : PrimitiveType = PrimitiveType.STRING): Attribute = {
      val _instance = ObjLang._objlangBuilder.create[Attribute]
      
      if (name != null) _instance.setName(name)
      if (initialValue != null) _instance.setInitialValue(initialValue)
      if (type_  != PrimitiveType.STRING) _instance.setType(type_ )
      
      _instance
    }
    
    def unapply(that: Attribute): Option[(String,fr.inria.spirals.sigma.ttc14.fixml.objlang.Class,Expression,PrimitiveType)] =
      Some((that.getName,that.getParent,that.getInitialValue,that.getType))
  }
}

object AttributeScalaSupport extends AttributeScalaSupport

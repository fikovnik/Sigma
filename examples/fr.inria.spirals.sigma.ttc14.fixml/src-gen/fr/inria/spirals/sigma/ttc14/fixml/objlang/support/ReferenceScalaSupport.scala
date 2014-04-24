package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ReferenceScalaSupport extends EMFScalaSupport {
  type Reference = fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference
  
  protected implicit val _referenceProxyBuilder = new EMFProxyBuilder[Reference](ObjLang._objlangBuilder)
  
  object Reference {
    def apply(name: String = null, initialValue: Expression = null, type_ : fr.inria.spirals.sigma.ttc14.fixml.objlang.Class = null): Reference = {
      val _instance = ObjLang._objlangBuilder.create[Reference]
      
      if (name != null) _instance.setName(name)
      if (initialValue != null) _instance.setInitialValue(initialValue)
      if (type_  != null) _instance.setType(type_ )
      
      _instance
    }
    
    def unapply(that: Reference): Option[(String,fr.inria.spirals.sigma.ttc14.fixml.objlang.Class,Expression,fr.inria.spirals.sigma.ttc14.fixml.objlang.Class)] =
      Some((that.getName,that.getParent,that.getInitialValue,that.getType))
  }
}

object ReferenceScalaSupport extends ReferenceScalaSupport

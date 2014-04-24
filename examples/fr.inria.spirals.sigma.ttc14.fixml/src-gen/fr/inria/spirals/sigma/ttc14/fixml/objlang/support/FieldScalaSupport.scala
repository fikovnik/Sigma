package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Field;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait FieldScalaSupport extends EMFScalaSupport {
  type Field = fr.inria.spirals.sigma.ttc14.fixml.objlang.Field
  
  protected implicit val _fieldProxyBuilder = new EMFProxyBuilder[Field](ObjLang._objlangBuilder)
  
  object Field {
    def apply(name: String = null, type_ : Classifier = null, many: Boolean = false, initialValue: Expression = null): Field = {
      val _instance = ObjLang._objlangBuilder.create[Field]
      
      if (name != null) _instance.setName(name)
      if (type_  != null) _instance.setType(type_ )
      if (many != false) _instance.setMany(many)
      if (initialValue != null) _instance.setInitialValue(initialValue)
      
      _instance
    }
    
    def unapply(that: Field): Option[(String,Classifier,Boolean,fr.inria.spirals.sigma.ttc14.fixml.objlang.Class,Expression)] =
      Some((that.getName,that.getType,that.isMany,that.getParent,that.getInitialValue))
  }
}

object FieldScalaSupport extends FieldScalaSupport

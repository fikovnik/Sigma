package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait TypedElementScalaSupport extends EMFScalaSupport {
  type TypedElement = fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement
  
  protected implicit val _typedelementProxyBuilder = new EMFProxyBuilder[TypedElement](ObjLang._objlangBuilder)
  
  object TypedElement {
    def apply(name: String = null, type_ : Classifier = null, many: Boolean = false): TypedElement = {
      val _instance = ObjLang._objlangBuilder.create[TypedElement]
      
      if (name != null) _instance.setName(name)
      if (type_  != null) _instance.setType(type_ )
      if (many != false) _instance.setMany(many)
      
      _instance
    }
    
    def unapply(that: TypedElement): Option[(String,Classifier,Boolean)] =
      Some((that.getName,that.getType,that.isMany))
  }
}

object TypedElementScalaSupport extends TypedElementScalaSupport

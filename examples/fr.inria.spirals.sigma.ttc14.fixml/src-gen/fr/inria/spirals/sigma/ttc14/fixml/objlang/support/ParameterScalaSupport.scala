package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ParameterScalaSupport extends EMFScalaSupport {
  type Parameter = fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter
  
  protected implicit val _parameterProxyBuilder = new EMFProxyBuilder[Parameter](ObjLang._objlangBuilder)
  
  object Parameter {
    def apply(name: String = null, type_ : Classifier = null, many: Boolean = false): Parameter = {
      val _instance = ObjLang._objlangBuilder.create[Parameter]
      
      if (name != null) _instance.setName(name)
      if (type_  != null) _instance.setType(type_ )
      if (many != false) _instance.setMany(many)
      
      _instance
    }
    
    def unapply(that: Parameter): Option[(String,Classifier,Boolean)] =
      Some((that.getName,that.getType,that.isMany))
  }
}

object ParameterScalaSupport extends ParameterScalaSupport

package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ReferenceParameterScalaSupport extends EMFScalaSupport {
  type ReferenceParameter = fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter
  
  protected implicit val _referenceparameterProxyBuilder = new EMFProxyBuilder[ReferenceParameter](ObjLang._objlangBuilder)
  
  object ReferenceParameter {
    def apply(name: String = null, type_ : fr.inria.spirals.sigma.ttc14.fixml.objlang.Class = null): ReferenceParameter = {
      val _instance = ObjLang._objlangBuilder.create[ReferenceParameter]
      
      if (name != null) _instance.setName(name)
      if (type_  != null) _instance.setType(type_ )
      
      _instance
    }
    
    def unapply(that: ReferenceParameter): Option[(String,fr.inria.spirals.sigma.ttc14.fixml.objlang.Class)] =
      Some((that.getName,that.getType))
  }
}

object ReferenceParameterScalaSupport extends ReferenceParameterScalaSupport

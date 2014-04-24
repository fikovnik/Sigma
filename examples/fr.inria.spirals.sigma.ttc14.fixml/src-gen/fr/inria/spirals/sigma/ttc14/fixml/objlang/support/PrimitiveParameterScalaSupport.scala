package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait PrimitiveParameterScalaSupport extends EMFScalaSupport {
  type PrimitiveParameter = fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter
  
  protected implicit val _primitiveparameterProxyBuilder = new EMFProxyBuilder[PrimitiveParameter](ObjLang._objlangBuilder)
  
  object PrimitiveParameter {
    def apply(name: String = null, type_ : PrimitiveType = PrimitiveType.STRING): PrimitiveParameter = {
      val _instance = ObjLang._objlangBuilder.create[PrimitiveParameter]
      
      if (name != null) _instance.setName(name)
      if (type_  != PrimitiveType.STRING) _instance.setType(type_ )
      
      _instance
    }
    
    def unapply(that: PrimitiveParameter): Option[(String,PrimitiveType)] =
      Some((that.getName,that.getType))
  }
}

object PrimitiveParameterScalaSupport extends PrimitiveParameterScalaSupport

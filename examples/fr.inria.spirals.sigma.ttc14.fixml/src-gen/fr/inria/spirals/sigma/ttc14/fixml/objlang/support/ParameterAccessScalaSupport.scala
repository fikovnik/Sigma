package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ParameterAccessScalaSupport extends EMFScalaSupport {
  type ParameterAccess = fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess
  
  protected implicit val _parameteraccessProxyBuilder = new EMFProxyBuilder[ParameterAccess](ObjLang._objlangBuilder)
  
  object ParameterAccess {
    def apply(parameter: Parameter = null): ParameterAccess = {
      val _instance = ObjLang._objlangBuilder.create[ParameterAccess]
      
      if (parameter != null) _instance.setParameter(parameter)
      
      _instance
    }
    
    def unapply(that: ParameterAccess): Option[(Parameter)] =
      Some((that.getParameter))
  }
}

object ParameterAccessScalaSupport extends ParameterAccessScalaSupport

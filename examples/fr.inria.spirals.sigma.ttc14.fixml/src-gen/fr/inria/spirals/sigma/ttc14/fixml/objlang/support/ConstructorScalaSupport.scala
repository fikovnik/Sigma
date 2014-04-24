package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ConstructorScalaSupport extends EMFScalaSupport {
  type Constructor = fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor
  
  protected implicit val _constructorProxyBuilder = new EMFProxyBuilder[Constructor](ObjLang._objlangBuilder)
  
  object Constructor {
    def apply(parameters: EList[Parameter] = null, initialisations: EList[FieldInitialisiation] = null): Constructor = {
      val _instance = ObjLang._objlangBuilder.create[Constructor]
      
      if (parameters != null) _instance.getParameters.addAll(parameters)
      if (initialisations != null) _instance.getInitialisations.addAll(initialisations)
      
      _instance
    }
    
    def unapply(that: Constructor): Option[(fr.inria.spirals.sigma.ttc14.fixml.objlang.Class,EList[Parameter],EList[FieldInitialisiation])] =
      Some((that.getParent,that.getParameters,that.getInitialisations))
  }
}

object ConstructorScalaSupport extends ConstructorScalaSupport

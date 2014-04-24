package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ConstructorCallScalaSupport extends EMFScalaSupport {
  type ConstructorCall = fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall
  
  protected implicit val _constructorcallProxyBuilder = new EMFProxyBuilder[ConstructorCall](ObjLang._objlangBuilder)
  
  object ConstructorCall {
    def apply(constructor: Constructor = null, arguments: EList[Expression] = null): ConstructorCall = {
      val _instance = ObjLang._objlangBuilder.create[ConstructorCall]
      
      if (constructor != null) _instance.setConstructor(constructor)
      if (arguments != null) _instance.getArguments.addAll(arguments)
      
      _instance
    }
    
    def unapply(that: ConstructorCall): Option[(Constructor,EList[Expression])] =
      Some((that.getConstructor,that.getArguments))
  }
}

object ConstructorCallScalaSupport extends ConstructorCallScalaSupport

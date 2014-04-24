package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ArrayLiteralScalaSupport extends EMFScalaSupport {
  type ArrayLiteral = fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral
  
  protected implicit val _arrayliteralProxyBuilder = new EMFProxyBuilder[ArrayLiteral](ObjLang._objlangBuilder)
  
  object ArrayLiteral {
    def apply(type_ : Classifier = null, elements: EList[Expression] = null): ArrayLiteral = {
      val _instance = ObjLang._objlangBuilder.create[ArrayLiteral]
      
      if (type_  != null) _instance.setType(type_ )
      if (elements != null) _instance.getElements.addAll(elements)
      
      _instance
    }
    
    def unapply(that: ArrayLiteral): Option[(Classifier,EList[Expression])] =
      Some((that.getType,that.getElements))
  }
}

object ArrayLiteralScalaSupport extends ArrayLiteralScalaSupport

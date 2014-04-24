package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait DataTypeScalaSupport extends EMFScalaSupport {
  type DataType = fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType
  
  protected implicit val _datatypeProxyBuilder = new EMFProxyBuilder[DataType](ObjLang._objlangBuilder)
  
  object DataType {
    def apply(name: String = null): DataType = {
      val _instance = ObjLang._objlangBuilder.create[DataType]
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
    
    def unapply(that: DataType): Option[(String)] =
      Some((that.getName))
  }
}

object DataTypeScalaSupport extends DataTypeScalaSupport

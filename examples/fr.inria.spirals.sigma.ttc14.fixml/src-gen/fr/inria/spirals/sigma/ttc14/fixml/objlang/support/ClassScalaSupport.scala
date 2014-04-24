package fr.inria.spirals.sigma.ttc14.fixml.objlang.support

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Field;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Member;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ClassScalaSupport extends EMFScalaSupport {
  type Class = fr.inria.spirals.sigma.ttc14.fixml.objlang.Class
  
  protected implicit val _classProxyBuilder = new EMFProxyBuilder[Class](ObjLang._objlangBuilder)
  
  object Class {
    def apply(name: String = null, superclass: fr.inria.spirals.sigma.ttc14.fixml.objlang.Class = null, members: EList[Member] = null): Class = {
      val _instance = ObjLang._objlangBuilder.create[Class]
      
      if (name != null) _instance.setName(name)
      if (superclass != null) _instance.setSuperclass(superclass)
      if (members != null) _instance.getMembers.addAll(members)
      
      _instance
    }
    
    def unapply(that: Class): Option[(String,fr.inria.spirals.sigma.ttc14.fixml.objlang.Class,EList[Member],EList[Constructor],EList[Field])] =
      Some((that.getName,that.getSuperclass,that.getMembers,that.getConstructors,that.getFields))
  }
}

object ClassScalaSupport extends ClassScalaSupport

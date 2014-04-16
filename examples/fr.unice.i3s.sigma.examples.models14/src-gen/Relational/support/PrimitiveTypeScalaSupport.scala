package Relational.support

import Relational.Constraint;
import Relational.PrimitiveType;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait PrimitiveTypeScalaSupport extends EMFScalaSupport {
  type PrimitiveType = Relational.PrimitiveType
  
  protected implicit val _primitivetypeProxyBuilder = new EMFProxyBuilder[PrimitiveType](RelationalPackageScalaSupport._relationalBuilder)
  
  object PrimitiveType {
    def apply(name: String = null, constraints: EList[Constraint] = null): PrimitiveType = {
      val _instance = RelationalPackageScalaSupport._relationalBuilder.create[PrimitiveType]
      
      if (name != null) _instance.setName(name)
      if (constraints != null) _instance.getConstraints.addAll(constraints)
      
      _instance
    }
  }
}

object PrimitiveTypeScalaSupport extends PrimitiveTypeScalaSupport

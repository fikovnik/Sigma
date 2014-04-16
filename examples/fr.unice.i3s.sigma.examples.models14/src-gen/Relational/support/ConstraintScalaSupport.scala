package Relational.support

import Relational.Constraint;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ConstraintScalaSupport extends EMFScalaSupport {
  type Constraint = Relational.Constraint
  
  protected implicit val _constraintProxyBuilder = new EMFProxyBuilder[Constraint](RelationalPackageScalaSupport._relationalBuilder)
  
  object Constraint {
    def apply(name: String = null, description: String = null): Constraint = {
      val _instance = RelationalPackageScalaSupport._relationalBuilder.create[Constraint]
      
      if (name != null) _instance.setName(name)
      if (description != null) _instance.setDescription(description)
      
      _instance
    }
  }
}

object ConstraintScalaSupport extends ConstraintScalaSupport

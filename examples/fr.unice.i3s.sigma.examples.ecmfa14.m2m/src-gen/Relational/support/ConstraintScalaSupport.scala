package Relational.support

import Relational.Constraint;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ConstraintScalaSupport extends EMFScalaSupport {
  type Constraint = Relational.Constraint
  
  object Constraint {
    def apply(name: String = null, description: String = null): Constraint = {
      val _instance = Relational.RelationalFactory.eINSTANCE.createConstraint
      
      if (name != null) _instance.setName(name)
      if (description != null) _instance.setDescription(description)
      
      _instance
    }
  }
}

object ConstraintScalaSupport extends ConstraintScalaSupport

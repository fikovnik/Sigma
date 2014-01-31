package EER.support

import EER.Constraint;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ConstraintScalaSupport extends EMFScalaSupport {
  type Constraint = EER.Constraint
  
  object Constraint {
    def apply(name: String = null): Constraint = {
      val _instance = EER.EERFactory.eINSTANCE.createConstraint
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object ConstraintScalaSupport extends ConstraintScalaSupport

package EER.support

import EER.Constraint;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ConstraintScalaSupport extends EMFScalaSupport {
  type Constraint = EER.Constraint
  
  protected implicit val _constraintProxyBuilder = new EMFProxyBuilder[Constraint](EERPackageScalaSupport._eerBuilder)
  
  object Constraint {
    def apply(name: String = null): Constraint = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[Constraint]
      
      if (name != null) _instance.setName(name)
      
      _instance
    }
  }
}

object ConstraintScalaSupport extends ConstraintScalaSupport

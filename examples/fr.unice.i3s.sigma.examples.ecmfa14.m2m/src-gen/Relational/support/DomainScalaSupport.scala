package Relational.support

import Relational.Constraint;
import Relational.Domain;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait DomainScalaSupport extends EMFScalaSupport {
  type Domain = Relational.Domain
  
  object Domain {
    def apply(name: String = null, constraints: EList[Constraint] = null): Domain = {
      val _instance = Relational.RelationalFactory.eINSTANCE.createDomain
      
      if (name != null) _instance.setName(name)
      if (constraints != null) _instance.getConstraints.addAll(constraints)
      
      _instance
    }
  }
}

object DomainScalaSupport extends DomainScalaSupport

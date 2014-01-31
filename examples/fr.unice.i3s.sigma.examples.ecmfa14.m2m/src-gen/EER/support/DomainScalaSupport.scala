package EER.support

import EER.Domain;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait DomainScalaSupport extends EMFScalaSupport {
  type Domain = EER.Domain
  
  object Domain {
  }
}

object DomainScalaSupport extends DomainScalaSupport

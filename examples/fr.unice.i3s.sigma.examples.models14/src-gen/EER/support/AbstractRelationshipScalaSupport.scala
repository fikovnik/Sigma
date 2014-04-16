package EER.support

import EER.AbstractRelationship;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AbstractRelationshipScalaSupport extends EMFScalaSupport {
  type AbstractRelationship = EER.AbstractRelationship
  
  object AbstractRelationship {
  }
}

object AbstractRelationshipScalaSupport extends AbstractRelationshipScalaSupport

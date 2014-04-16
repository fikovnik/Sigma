package EER.support

import EER.AbstractParticipant;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AbstractParticipantScalaSupport extends EMFScalaSupport {
  type AbstractParticipant = EER.AbstractParticipant
  
  object AbstractParticipant {
  }
}

object AbstractParticipantScalaSupport extends AbstractParticipantScalaSupport

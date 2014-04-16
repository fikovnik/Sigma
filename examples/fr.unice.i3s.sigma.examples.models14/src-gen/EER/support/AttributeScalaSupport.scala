package EER.support

import EER.Attribute;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait AttributeScalaSupport extends EMFScalaSupport {
  type Attribute = EER.Attribute
  
  object Attribute {
  }
}

object AttributeScalaSupport extends AttributeScalaSupport

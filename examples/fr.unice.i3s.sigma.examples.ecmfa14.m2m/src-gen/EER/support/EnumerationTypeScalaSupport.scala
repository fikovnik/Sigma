package EER.support

import EER.EnumeratedLiteral;
import EER.EnumerationType;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait EnumerationTypeScalaSupport extends EMFScalaSupport {
  type EnumerationType = EER.EnumerationType
  
  object EnumerationType {
    def apply(name: String = null, literals: EList[EnumeratedLiteral] = null): EnumerationType = {
      val _instance = EER.EERFactory.eINSTANCE.createEnumerationType
      
      if (name != null) _instance.setName(name)
      if (literals != null) _instance.getLiterals.addAll(literals)
      
      _instance
    }
  }
}

object EnumerationTypeScalaSupport extends EnumerationTypeScalaSupport

package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Classifier;
import fr.unice.i3s.sigma.examples.simpleoo.Operation;
import fr.unice.i3s.sigma.examples.simpleoo.ScopeKind;
import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait OperationScalaSupport extends EMFScalaSupport {
  type Operation = fr.unice.i3s.sigma.examples.simpleoo.Operation
  
  protected implicit val _operationProxyBuilder = new EMFProxyBuilder[Operation](SimpleooPackageScalaSupport._simpleooBuilder)
  
  object Operation {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE, returnType: Classifier = null): Operation = {
      val _instance = SimpleooPackageScalaSupport._simpleooBuilder.create[Operation]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      if (ownerScope != ScopeKind.SK_INSTANCE) _instance.setOwnerScope(ownerScope)
      if (returnType != null) _instance.setReturnType(returnType)
      
      _instance
    }
  }
}

object OperationScalaSupport extends OperationScalaSupport

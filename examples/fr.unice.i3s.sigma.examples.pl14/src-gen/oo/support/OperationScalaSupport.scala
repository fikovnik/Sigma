package oo.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import oo.Classifier;
import oo.Operation;
import oo.ScopeKind;
import oo.Stereotype;

import org.eclipse.emf.common.util.EList;

import scala.Option;

trait OperationScalaSupport extends EMFScalaSupport {
  type Operation = oo.Operation
  
  protected implicit val _operationProxyBuilder = new EMFProxyBuilder[Operation](OOPackageScalaSupport._ooBuilder)
  
  object Operation {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE, returnType: Classifier = null): Operation = {
      val _instance = OOPackageScalaSupport._ooBuilder.create[Operation]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      if (ownerScope != ScopeKind.SK_INSTANCE) _instance.setOwnerScope(ownerScope)
      if (returnType != null) _instance.setReturnType(returnType)
      
      _instance
    }
    
    def unapply(that: Operation): Option[(EList[Stereotype],String,ScopeKind,Classifier)] =
      Some((that.getStereotypes,that.getName,that.getOwnerScope,that.getReturnType))
  }
  
  implicit class OperationScalaSupport(that: Operation) {
    def returnType: Classifier = that.getReturnType
    def returnType_=(value: Classifier): Unit = that.setReturnType(value)
    def returnType_=(value: ⇒ Option[Classifier]): Unit =
      that.setReturnType(OOPackageScalaSupport._ooBuilder.ref(value))
  }
}

object OperationScalaSupport extends OperationScalaSupport

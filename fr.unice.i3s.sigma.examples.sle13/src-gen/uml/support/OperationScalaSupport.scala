package uml.support

import org.eclipse.emf.common.util.EList;

import scala.Option;

import uml.Classifier;
import uml.Operation;
import uml.ScopeKind;
import uml.Stereotype;

trait OperationScalaSupport {
  type Operation = uml.Operation
  
  object Operation {
    def apply(name: String = null, stereotypes: EList[Stereotype] = null, ownerScope: ScopeKind = ScopeKind.SK_INSTANCE, returnType: Classifier = null): Operation = {
      val instance = UmlPackageScalaSupport.builder.create[Operation]
      
      if (name != null) instance.setName(name)
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (ownerScope != ScopeKind.SK_INSTANCE) instance.setOwnerScope(ownerScope)
      if (returnType != null) instance.setReturnType(returnType)
      
      instance
    }
    
    def unapply(that: Operation): Option[(String,EList[Stereotype],ScopeKind,Classifier)] =
      Some((that.getName,that.getStereotypes,that.getOwnerScope,that.getReturnType))
  }
  
  implicit class OperationScalaSupport(that: Operation) {
    def returnType: Classifier = that.getReturnType
    def returnType_=(value: Classifier): Unit = that.setReturnType(value)
    def returnType_=(value: ⇒ Option[Classifier]): Unit =
      that.setReturnType(UmlPackageScalaSupport.builder.ref(value))
  }
}

object OperationScalaSupport extends OperationScalaSupport

package uml.support

import org.eclipse.emf.common.util.EList;

import uml.Operation;
import uml.Property;
import uml.Stereotype;

trait ClassScalaSupport {
  type UmlClass = uml.Class
  
  object UmlClass {
    def apply(name: String = null, stereotypes: EList[Stereotype] = null, `abstract`: Boolean = false, attributes: EList[Property] = null, operations: EList[Operation] = null): UmlClass = {
      val instance = UmlPackageScalaSupport.builder.create[UmlClass]
      
      if (name != null) instance.setName(name)
      if (stereotypes != null) instance.getStereotypes.addAll(stereotypes)
      if (`abstract` != false) instance.setAbstract(`abstract`)
      if (attributes != null) instance.getAttributes.addAll(attributes)
      if (operations != null) instance.getOperations.addAll(operations)
      
      instance
    }
    
    def unapply(that: UmlClass): Option[(String,EList[Stereotype],Boolean,EList[Property],EList[Operation])] =
      Some((that.getName,that.getStereotypes,that.isAbstract,that.getAttributes,that.getOperations))
  }
  
  implicit class ClassScalaSupport(that: uml.Class) {
    def `abstract`: Boolean = that.isAbstract
    def abstract_=(value: Boolean): Unit = that.setAbstract(value)
    def attributes: EList[Property] = that.getAttributes
    def operations: EList[Operation] = that.getOperations
  }
}

object ClassScalaSupport extends ClassScalaSupport

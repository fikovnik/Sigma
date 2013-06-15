package uml.support

import uml.Stereotype;

trait StereotypeScalaSupport {
  type Stereotype = uml.Stereotype
  
  object Stereotype {
    def apply(name: String = null): Stereotype = {
      val instance = UmlPackageScalaSupport.builder.create[Stereotype]
      
      if (name != null) instance.setName(name)
      
      instance
    }
    
    def unapply(that: Stereotype): Option[(String)] =
      Some((that.getName))
  }
  
  implicit class StereotypeScalaSupport(that: Stereotype) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object StereotypeScalaSupport extends StereotypeScalaSupport

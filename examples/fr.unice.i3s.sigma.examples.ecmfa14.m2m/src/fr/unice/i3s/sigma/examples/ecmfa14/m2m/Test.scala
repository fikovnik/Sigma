package fr.unice.i3s.sigma.examples.ecmfa14.m2m

import fr.unice.i3s.sigma.support.EMFScalaSupport

trait EERSupport {
  
  trait ConstraintScalaSupport extends EMFScalaSupport {
    type Constraint = EER.Constraint

    object Constraint {
      def apply(name: String = null): Constraint = {
        val _instance = EER.EERFactory.eINSTANCE.createConstraint

        if (name != null) _instance.setName(name)

        _instance
      }
    }

  }

  implicit class Constraint2Sigma(that: EER.Constraint) {
    def name: Option[String] = Option(that.getName)
    def name_=(value: String): Unit = that.setName(value)
  }

  object _EER extends ConstraintScalaSupport
}

trait RelationalSupport {

  trait ConstraintScalaSupport extends EMFScalaSupport {
    type Constraint = Relational.Constraint

    object Constraint {
      def apply(name: String = null, description: String = null): Constraint = {
        val _instance = Relational.RelationalFactory.eINSTANCE.createConstraint

        if (name != null) _instance.setName(name)
        if (description != null) _instance.setDescription(description)

        _instance
      }
    }

  }

  implicit class Constraint2Sigma(that: Relational.Constraint) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def description: String = that.getDescription
    def description_=(value: String): Unit = that.setDescription(value)
  }
  
  object _Relational extends ConstraintScalaSupport
}

class Test extends EERSupport with RelationalSupport {

  val c = _EER.Constraint(name = "Hi")
  c.name = "A"

  val r = _Relational.Constraint(name = "Hi") 
  r.name = "B"
    
  def ruleClass2Table(p: _EER.Constraint, s: _Relational.Constraint) {
    
  }  
    
    
}
package Relational.support

import Relational.Constraint;
import Relational.Domain;
import Relational.Schema;
import Relational.Table;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait SchemaScalaSupport extends EMFScalaSupport {
  type Schema = Relational.Schema
  
  object Schema {
    def apply(name: String = null, tables: EList[Table] = null, domains: EList[Domain] = null, constraints: EList[Constraint] = null): Schema = {
      val _instance = Relational.RelationalFactory.eINSTANCE.createSchema
      
      if (name != null) _instance.setName(name)
      if (tables != null) _instance.getTables.addAll(tables)
      if (domains != null) _instance.getDomains.addAll(domains)
      if (constraints != null) _instance.getConstraints.addAll(constraints)
      
      _instance
    }
  }
}

object SchemaScalaSupport extends SchemaScalaSupport

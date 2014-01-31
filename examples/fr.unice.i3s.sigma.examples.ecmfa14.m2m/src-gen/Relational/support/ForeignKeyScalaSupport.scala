package Relational.support

import Relational.Attribute;
import Relational.ForeignKey;
import Relational.Table;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ForeignKeyScalaSupport extends EMFScalaSupport {
  type ForeignKey = Relational.ForeignKey
  
  object ForeignKey {
    def apply(attributes: EList[Attribute] = null, name: String = null, referencedTable: Table = null): ForeignKey = {
      val _instance = Relational.RelationalFactory.eINSTANCE.createForeignKey
      
      if (attributes != null) _instance.getAttributes.addAll(attributes)
      if (name != null) _instance.setName(name)
      if (referencedTable != null) _instance.setReferencedTable(referencedTable)
      
      _instance
    }
  }
}

object ForeignKeyScalaSupport extends ForeignKeyScalaSupport

package Relational.support

import Relational.Attribute;
import Relational.CandidateKey;
import Relational.ForeignKey;
import Relational.Table;

import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait TableScalaSupport extends EMFScalaSupport {
  type Table = Relational.Table
  
  object Table {
    def apply(name: String = null, primaryKey: CandidateKey = null, candidateKey: EList[CandidateKey] = null, attributes: EList[Attribute] = null, foreignKey: EList[ForeignKey] = null): Table = {
      val _instance = Relational.RelationalFactory.eINSTANCE.createTable
      
      if (name != null) _instance.setName(name)
      if (primaryKey != null) _instance.setPrimaryKey(primaryKey)
      if (candidateKey != null) _instance.getCandidateKey.addAll(candidateKey)
      if (attributes != null) _instance.getAttributes.addAll(attributes)
      if (foreignKey != null) _instance.getForeignKey.addAll(foreignKey)
      
      _instance
    }
  }
}

object TableScalaSupport extends TableScalaSupport

package Relational.support

import Relational.Constraint;
import Relational.EnumeratedLiteral;
import Relational.EnumerationType;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait EnumerationTypeScalaSupport extends EMFScalaSupport {
  type EnumerationType = Relational.EnumerationType
  
  protected implicit val _enumerationtypeProxyBuilder = new EMFProxyBuilder[EnumerationType](RelationalPackageScalaSupport._relationalBuilder)
  
  object EnumerationType {
    def apply(name: String = null, constraints: EList[Constraint] = null, literals: EList[EnumeratedLiteral] = null): EnumerationType = {
      val _instance = RelationalPackageScalaSupport._relationalBuilder.create[EnumerationType]
      
      if (name != null) _instance.setName(name)
      if (constraints != null) _instance.getConstraints.addAll(constraints)
      if (literals != null) _instance.getLiterals.addAll(literals)
      
      _instance
    }
  }
}

object EnumerationTypeScalaSupport extends EnumerationTypeScalaSupport

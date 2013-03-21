package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Dependency;

trait CollaborationUseScalaSupport {
  implicit class CollaborationUseScalaSupport(that: CollaborationUse) {
    def roleBinding: EList[Dependency] = that.getRoleBindings
    def `type`: Collaboration = that.getType
    def type_=(value: Collaboration): Unit = that.setType(value)
  }
}

object CollaborationUseScalaSupport extends CollaborationUseScalaSupport

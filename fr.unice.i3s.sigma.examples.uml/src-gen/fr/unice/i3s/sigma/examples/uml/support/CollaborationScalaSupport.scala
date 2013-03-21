package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.ConnectableElement;

trait CollaborationScalaSupport {
  implicit class CollaborationScalaSupport(that: Collaboration) {
    def collaborationRole: EList[ConnectableElement] = that.getCollaborationRoles
  }
}

object CollaborationScalaSupport extends CollaborationScalaSupport

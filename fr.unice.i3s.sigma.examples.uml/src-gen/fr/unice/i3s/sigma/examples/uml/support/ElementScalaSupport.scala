package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

trait ElementScalaSupport {
  implicit class ElementScalaSupport(that: Element) {
    def ownedComment: EList[Comment] = that.getOwnedComments
    def ownedElement: EList[Element] = that.getOwnedElements
    def owner: Element = that.getOwner
  }
}

object ElementScalaSupport extends ElementScalaSupport

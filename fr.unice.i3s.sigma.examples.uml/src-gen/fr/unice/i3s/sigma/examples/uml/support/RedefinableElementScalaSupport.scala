package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.RedefinableElement;

trait RedefinableElementScalaSupport {
  implicit class RedefinableElementScalaSupport(that: RedefinableElement) {
    def isLeaf: Boolean = that.isLeaf
    def isLeaf_=(value: Boolean): Unit = that.setIsLeaf(value)
    def redefinedElement: EList[RedefinableElement] = that.getRedefinedElements
    def redefinitionContext: EList[Classifier] = that.getRedefinitionContexts
  }
}

object RedefinableElementScalaSupport extends RedefinableElementScalaSupport

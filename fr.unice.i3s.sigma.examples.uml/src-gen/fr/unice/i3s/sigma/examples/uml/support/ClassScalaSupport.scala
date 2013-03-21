package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Reception;

trait ClassScalaSupport {
  implicit class ClassScalaSupport(that: org.eclipse.uml2.uml.Class) {
    def ownedOperation: EList[Operation] = that.getOwnedOperations
    def extension: EList[Extension] = that.getExtensions
    def isActive: Boolean = that.isActive
    def isActive_=(value: Boolean): Unit = that.setIsActive(value)
    def nestedClassifier: EList[Classifier] = that.getNestedClassifiers
    def ownedReception: EList[Reception] = that.getOwnedReceptions
    def superClass: EList[org.eclipse.uml2.uml.Class] = that.getSuperClasses
  }
}

object ClassScalaSupport extends ClassScalaSupport

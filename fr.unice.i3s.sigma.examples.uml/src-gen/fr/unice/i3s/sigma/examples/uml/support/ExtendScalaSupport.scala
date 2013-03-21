package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.UseCase;

trait ExtendScalaSupport {
  implicit class ExtendScalaSupport(that: Extend) {
    def condition: Constraint = that.getCondition
    def condition_=(value: Constraint): Unit = that.setCondition(value)
    def extendedCase: UseCase = that.getExtendedCase
    def extendedCase_=(value: UseCase): Unit = that.setExtendedCase(value)
    def extensionLocation: EList[ExtensionPoint] = that.getExtensionLocations
    def extension: UseCase = that.getExtension
    def extension_=(value: UseCase): Unit = that.setExtension(value)
  }
}

object ExtendScalaSupport extends ExtendScalaSupport

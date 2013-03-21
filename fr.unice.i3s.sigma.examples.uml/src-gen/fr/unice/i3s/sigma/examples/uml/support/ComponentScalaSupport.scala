package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.ComponentRealization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.PackageableElement;

trait ComponentScalaSupport {
  implicit class ComponentScalaSupport(that: Component) {
    def isIndirectlyInstantiated: Boolean = that.isIndirectlyInstantiated
    def isIndirectlyInstantiated_=(value: Boolean): Unit = that.setIsIndirectlyInstantiated(value)
    def packagedElement: EList[PackageableElement] = that.getPackagedElements
    def provided: EList[Interface] = that.getProvideds
    def realization: EList[ComponentRealization] = that.getRealizations
    def required: EList[Interface] = that.getRequireds
  }
}

object ComponentScalaSupport extends ComponentScalaSupport

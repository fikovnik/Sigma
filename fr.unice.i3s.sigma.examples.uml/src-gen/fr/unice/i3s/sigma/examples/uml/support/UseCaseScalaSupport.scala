package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Extend;
import org.eclipse.uml2.uml.ExtensionPoint;
import org.eclipse.uml2.uml.Include;
import org.eclipse.uml2.uml.UseCase;

trait UseCaseScalaSupport {
  implicit class UseCaseScalaSupport(that: UseCase) {
    def extend: EList[Extend] = that.getExtends
    def extensionPoint: EList[ExtensionPoint] = that.getExtensionPoints
    def include: EList[Include] = that.getIncludes
    def subject: EList[Classifier] = that.getSubjects
  }
}

object UseCaseScalaSupport extends UseCaseScalaSupport

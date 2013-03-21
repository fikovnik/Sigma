package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.NamedElement;

trait ConsiderIgnoreFragmentScalaSupport {
  implicit class ConsiderIgnoreFragmentScalaSupport(that: ConsiderIgnoreFragment) {
    def message: EList[NamedElement] = that.getMessages
  }
}

object ConsiderIgnoreFragmentScalaSupport extends ConsiderIgnoreFragmentScalaSupport

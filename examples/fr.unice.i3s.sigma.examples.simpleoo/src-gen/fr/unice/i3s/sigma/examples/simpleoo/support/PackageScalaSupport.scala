package fr.unice.i3s.sigma.examples.simpleoo.support

import fr.unice.i3s.sigma.examples.simpleoo.Classifier;
import fr.unice.i3s.sigma.examples.simpleoo.Stereotype;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait PackageScalaSupport extends EMFScalaSupport {
  type Package = fr.unice.i3s.sigma.examples.simpleoo.Package
  
  protected implicit val _packageProxyBuilder = new EMFProxyBuilder[Package](SimpleooPackageScalaSupport._simpleooBuilder)
  
  object Package {
    def apply(stereotypes: EList[Stereotype] = null, name: String = null, ownedElements: EList[Classifier] = null, ownedStereotypes: EList[Stereotype] = null): Package = {
      val _instance = SimpleooPackageScalaSupport._simpleooBuilder.create[Package]
      
      if (stereotypes != null) _instance.getStereotypes.addAll(stereotypes)
      if (name != null) _instance.setName(name)
      if (ownedElements != null) _instance.getOwnedElements.addAll(ownedElements)
      if (ownedStereotypes != null) _instance.getOwnedStereotypes.addAll(ownedStereotypes)
      
      _instance
    }
  }
}

object PackageScalaSupport extends PackageScalaSupport

package EER.support

import EER.AttributedNode;
import EER.Domain;
import EER.Project;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait ProjectScalaSupport extends EMFScalaSupport {
  type Project = EER.Project
  
  protected implicit val _projectProxyBuilder = new EMFProxyBuilder[Project](EERPackageScalaSupport._eerBuilder)
  
  object Project {
    def apply(name: String = null, domains: EList[Domain] = null, nodes: EList[AttributedNode] = null): Project = {
      val _instance = EERPackageScalaSupport._eerBuilder.create[Project]
      
      if (name != null) _instance.setName(name)
      if (domains != null) _instance.getDomains.addAll(domains)
      if (nodes != null) _instance.getNodes.addAll(nodes)
      
      _instance
    }
  }
}

object ProjectScalaSupport extends ProjectScalaSupport

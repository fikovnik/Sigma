package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait InterfaceRealizationScalaSupport extends EMFScalaSupport {
  type InterfaceRealization = org.eclipse.uml2.uml.InterfaceRealization
  
  protected implicit val _interfacerealizationProxyBuilder = new EMFProxyBuilder[InterfaceRealization](UMLPackageScalaSupport._umlBuilder)
  
  object InterfaceRealization {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, client: EList[NamedElement] = null, supplier: EList[NamedElement] = null, mapping: OpaqueExpression = null, contract: Interface = null): InterfaceRealization = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[InterfaceRealization]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (templateParameter != null) _instance.setTemplateParameter(templateParameter)
      if (client != null) _instance.getClients.addAll(client)
      if (supplier != null) _instance.getSuppliers.addAll(supplier)
      if (mapping != null) _instance.setMapping(mapping)
      if (contract != null) _instance.setContract(contract)
      
      _instance
    }
  }
  
  implicit class InterfaceRealizationScalaSupport(that: InterfaceRealization) {
    def contract: Interface = that.getContract
    def contract_=(value: Interface): Unit = that.setContract(value)
    def contract_=(value: ⇒ Option[Interface]): Unit =
      that.setContract(UMLPackageScalaSupport._umlBuilder.ref(value))
    def implementingClassifier: BehavioredClassifier = that.getImplementingClassifier
    def implementingClassifier_=(value: BehavioredClassifier): Unit = that.setImplementingClassifier(value)
    def implementingClassifier_=(value: ⇒ Option[BehavioredClassifier]): Unit =
      that.setImplementingClassifier(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object InterfaceRealizationScalaSupport extends InterfaceRealizationScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OpaqueExpression;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait SubstitutionScalaSupport extends EMFScalaSupport {
  type Substitution = org.eclipse.uml2.uml.Substitution
  
  protected implicit val _substitutionProxyBuilder = new EMFProxyBuilder[Substitution](UMLPackageScalaSupport._umlBuilder)
  
  object Substitution {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, templateParameter: TemplateParameter = null, client: EList[NamedElement] = null, supplier: EList[NamedElement] = null, mapping: OpaqueExpression = null, contract: Classifier = null): Substitution = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Substitution]
      
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
  
  implicit class SubstitutionScalaSupport(that: Substitution) {
    def contract: Classifier = that.getContract
    def contract_=(value: Classifier): Unit = that.setContract(value)
    def contract_=(value: ⇒ Option[Classifier]): Unit =
      that.setContract(UMLPackageScalaSupport._umlBuilder.ref(value))
    def substitutingClassifier: Classifier = that.getSubstitutingClassifier
    def substitutingClassifier_=(value: Classifier): Unit = that.setSubstitutingClassifier(value)
    def substitutingClassifier_=(value: ⇒ Option[Classifier]): Unit =
      that.setSubstitutingClassifier(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object SubstitutionScalaSupport extends SubstitutionScalaSupport

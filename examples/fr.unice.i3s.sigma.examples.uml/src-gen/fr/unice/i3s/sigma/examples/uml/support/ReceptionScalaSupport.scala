package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallConcurrencyKind;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.Reception;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait ReceptionScalaSupport extends EMFScalaSupport {
  type Reception = org.eclipse.uml2.uml.Reception
  
  protected implicit val _receptionProxyBuilder = new EMFProxyBuilder[Reception](UMLPackageScalaSupport._umlBuilder)
  
  object Reception {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, clientDependency: EList[Dependency] = null, name: String = null, nameExpression: StringExpression = null, visibility: VisibilityKind = VisibilityKind.PUBLIC_LITERAL, elementImport: EList[ElementImport] = null, packageImport: EList[PackageImport] = null, ownedRule: EList[Constraint] = null, isLeaf: Boolean = false, static: Boolean = false, concurrency: CallConcurrencyKind = CallConcurrencyKind.SEQUENTIAL_LITERAL, isAbstract: Boolean = false, method: EList[Behavior] = null, ownedParameter: EList[Parameter] = null, ownedParameterSet: EList[ParameterSet] = null, raisedException: EList[Type] = null, signal: Signal = null): Reception = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Reception]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (clientDependency != null) _instance.getClientDependencies.addAll(clientDependency)
      if (name != null) _instance.setName(name)
      if (nameExpression != null) _instance.setNameExpression(nameExpression)
      if (visibility != VisibilityKind.PUBLIC_LITERAL) _instance.setVisibility(visibility)
      if (elementImport != null) _instance.getElementImports.addAll(elementImport)
      if (packageImport != null) _instance.getPackageImports.addAll(packageImport)
      if (ownedRule != null) _instance.getOwnedRules.addAll(ownedRule)
      if (isLeaf != false) _instance.setIsLeaf(isLeaf)
      if (static != false) _instance.setIsStatic(static)
      if (concurrency != CallConcurrencyKind.SEQUENTIAL_LITERAL) _instance.setConcurrency(concurrency)
      if (isAbstract != false) _instance.setIsAbstract(isAbstract)
      if (method != null) _instance.getMethods.addAll(method)
      if (ownedParameter != null) _instance.getOwnedParameters.addAll(ownedParameter)
      if (ownedParameterSet != null) _instance.getOwnedParameterSets.addAll(ownedParameterSet)
      if (raisedException != null) _instance.getRaisedExceptions.addAll(raisedException)
      if (signal != null) _instance.setSignal(signal)
      
      _instance
    }
  }
  
  implicit class ReceptionScalaSupport(that: Reception) {
    def signal: Signal = that.getSignal
    def signal_=(value: Signal): Unit = that.setSignal(value)
    def signal_=(value: ⇒ Option[Signal]): Unit =
      that.setSignal(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object ReceptionScalaSupport extends ReceptionScalaSupport

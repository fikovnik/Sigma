package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.StringExpression;
import org.eclipse.uml2.uml.Substitution;
import org.eclipse.uml2.uml.TemplateBinding;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.TemplateSignature;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.VisibilityKind;

import scala.Option;

trait BehavioredClassifierScalaSupport extends EMFScalaSupport {
  type BehavioredClassifier = org.eclipse.uml2.uml.BehavioredClassifier
  
  protected implicit val _behavioredclassifierProxyBuilder = new EMFProxyBuilder[BehavioredClassifier](UMLPackageScalaSupport._umlBuilder)
  
  object BehavioredClassifier {
    def apply(): BehavioredClassifier = {
      UMLPackageScalaSupport._umlBuilder.create[BehavioredClassifier]
    }
  }
  
  implicit class BehavioredClassifierScalaSupport(that: BehavioredClassifier) {
    def classifierBehavior: Behavior = that.getClassifierBehavior
    def classifierBehavior_=(value: Behavior): Unit = that.setClassifierBehavior(value)
    def classifierBehavior_=(value: ⇒ Option[Behavior]): Unit =
      that.setClassifierBehavior(UMLPackageScalaSupport._umlBuilder.ref(value))
    def interfaceRealization: EList[InterfaceRealization] = that.getInterfaceRealizations
    def ownedBehavior: EList[Behavior] = that.getOwnedBehaviors
  }
}

object BehavioredClassifierScalaSupport extends BehavioredClassifierScalaSupport

package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.GeneralizationSet;

import scala.Option;

trait GeneralizationScalaSupport extends EMFScalaSupport {
  type Generalization = org.eclipse.uml2.uml.Generalization
  
  protected implicit val _generalizationProxyBuilder = new EMFProxyBuilder[Generalization](UMLPackageScalaSupport._umlBuilder)
  
  object Generalization {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, general: Classifier = null, generalizationSet: EList[GeneralizationSet] = null, isSubstitutable: Boolean = true): Generalization = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Generalization]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (general != null) _instance.setGeneral(general)
      if (generalizationSet != null) _instance.getGeneralizationSets.addAll(generalizationSet)
      if (isSubstitutable != true) _instance.setIsSubstitutable(isSubstitutable)
      
      _instance
    }
  }
  
  implicit class GeneralizationScalaSupport(that: Generalization) {
    def general: Classifier = that.getGeneral
    def general_=(value: Classifier): Unit = that.setGeneral(value)
    def general_=(value: ⇒ Option[Classifier]): Unit =
      that.setGeneral(UMLPackageScalaSupport._umlBuilder.ref(value))
    def generalizationSet: EList[GeneralizationSet] = that.getGeneralizationSets
    def isSubstitutable: Boolean = that.isSubstitutable
    def isSubstitutable_=(value: Boolean): Unit = that.setIsSubstitutable(value)
    def specific: Classifier = that.getSpecific
    def specific_=(value: Classifier): Unit = that.setSpecific(value)
    def specific_=(value: ⇒ Option[Classifier]): Unit =
      that.setSpecific(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object GeneralizationScalaSupport extends GeneralizationScalaSupport

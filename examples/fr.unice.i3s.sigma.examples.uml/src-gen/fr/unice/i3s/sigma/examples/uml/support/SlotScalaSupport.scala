package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Slot;
import org.eclipse.uml2.uml.StructuralFeature;
import org.eclipse.uml2.uml.ValueSpecification;

import scala.Option;

trait SlotScalaSupport extends EMFScalaSupport {
  type Slot = org.eclipse.uml2.uml.Slot
  
  protected implicit val _slotProxyBuilder = new EMFProxyBuilder[Slot](UMLPackageScalaSupport._umlBuilder)
  
  object Slot {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, definingFeature: StructuralFeature = null, value: EList[ValueSpecification] = null): Slot = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Slot]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (definingFeature != null) _instance.setDefiningFeature(definingFeature)
      if (value != null) _instance.getValues.addAll(value)
      
      _instance
    }
  }
  
  implicit class SlotScalaSupport(that: Slot) {
    def definingFeature: StructuralFeature = that.getDefiningFeature
    def definingFeature_=(value: StructuralFeature): Unit = that.setDefiningFeature(value)
    def definingFeature_=(value: ⇒ Option[StructuralFeature]): Unit =
      that.setDefiningFeature(UMLPackageScalaSupport._umlBuilder.ref(value))
    def value: EList[ValueSpecification] = that.getValues
    def owningInstance: InstanceSpecification = that.getOwningInstance
    def owningInstance_=(value: InstanceSpecification): Unit = that.setOwningInstance(value)
    def owningInstance_=(value: ⇒ Option[InstanceSpecification]): Unit =
      that.setOwningInstance(UMLPackageScalaSupport._umlBuilder.ref(value))
  }
}

object SlotScalaSupport extends SlotScalaSupport

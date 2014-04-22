package fr.unice.i3s.sigma.examples.models14.validation

import fr.unice.i3s.sigma.validation._
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore._
import fr.unice.i3s.sigma.support.SigmaSupport
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl

class EPackageContext extends ValidationContext with InvMethods with EcoreExtras {

  type Self = EPackage

  def invDiagramIsDefined = self.getDiagramClass match {
    case Some(_) ⇒ Passed
    case None ⇒ Error("One class must be specified as gmf.diagram")
  }

  def invContainmentReferencesAreDefined = guardedBy {
    self satisfies invDiagramIsDefined
  } check {
    self.getDiagramClass.get.eAllStructuralFeatures collectFirst { case r: EReference if r.containment ⇒ r } match {
      case Some(_) ⇒ Passed
      case None ⇒ Error(s"Diagram class ${self.getDiagramClass.get.name} must define at least one containment reference")
    }
  }

  def invNodesAreDefined = guardedBy {
    self satisfies invDiagramIsDefined
  } check {
    if (self.sAllContents[EClass] filter (_.isNode) nonEmpty) Passed
    else Error("No nodes (gmf.node) have been defined")
  }

  def invReferenceLinksAreDefined = guardedBy {
    self satisfies invDiagramIsDefined
  } check {
    if (getReferenceLinks.nonEmpty || (self.sAllContents[EClass] filter (_.isLink) nonEmpty)) Passed
    else Warning("No reference links (gmf.link) have been defined")
  }

  def getReferenceLinks = self.getDiagramClass.get.getAnnotationValue("gmf.diagram", "refsarelinks") match {
    case Some("true") ⇒ self.sAllContents[EReference] filter (!_.containment)
    case _ ⇒ self.sAllContents[EReference] filter (_.isLink)
  }
}

class EClassNodeContext extends ValidationContext with InvMethods with EcoreExtras with SigmaSupport {
  type Self = EClass

  override def guard = self.isNode

  def invIsValidSvgNode = {
    if (self.getAnnotationValue("gmf.node", "figure") == Some("svg") implies
      self.getAnnotationValue("gmf.node", "svg.uri").isDefined) Passed
    else Error(s"No svg.uri provided for SVG figure ${self.name}")
  }

  def invIsValidPolygonNode = {
    if (self.getAnnotationValue("gmf.node", "figure") == Some("polygon") implies
      (
        self.getAnnotationValue("gmf.node", "polygon.x").isDefined &&
        self.getAnnotationValue("gmf.node", "polygon.y").isDefined
      )) Passed
    else Error(s"No polygon x/y coordinates provided for polygon figure ${self.name}")
  }

  def invNodeLabelIsDefined = guardedBy {
    self.getAnnotationValue("gmf.node", "figure") != Some("none")
  } check {
    if (self.getAnnotationValue("gmf.node", "label.placement").isDefined) Passed
    else Error(s"No polygon x/y coordinates provided for polygon figure ${self.name}")
  }

  def invNodeLabelsExist = guardedBy {
    self satisfies invNodeLabelIsDefined
  } check {
    val missing = for {
      labels ← self.getAnnotationValue("gmf.node", "label").toSeq
      label ← labels split (",") map (_.trim) if self.eStructuralFeatures.find(_.name == label).isEmpty
    } yield label

    if (missing.isEmpty) Passed
    else Error(s"Label attribute(s) ${missing.mkString(", ")} do(es) not exist in class ${self.name}")
  }

}

class EClassLinkContext extends ValidationContext with InvMethods with EcoreExtras with SigmaSupport {
  type Self = EClass

  override def guard = self.isLink

  def invLinkLabelExists = guardedBy {
    self.getAnnotationValue("gmf.link", "label").isDefined
  } check {
    val missing = for {
      labels ← self.getAnnotationValue("gmf.node", "label").toSeq
      label ← labels split (",") map (_.trim) if self.eStructuralFeatures.find(_.name == label).isEmpty
    } yield label

    if (missing.isEmpty) Passed
    else Error(s"Label attribute(s) ${missing.mkString(", ")} do(es) not exist in class ${self.name}")
  }

  def invLinkSourceIsDefined = {
    if (self.getAnnotationValue("gmf.link", "source").isDefined) Passed
    else Error(s"No source defined for link class ${self.name}")
  }

  def invSourceExists = guardedBy {
    self satisfies invLinkSourceIsDefined
  } check {
    if ((self.getAnnotationValue("gmf.link", "source") flatMap { v ⇒ self.eAllStructuralFeatures.find(_.name == v) }).isDefined) Passed
    else Error(s"'No reference named ${self.getAnnotationValue("gmf.link", "source")} exists in link class ${self.name}")
  }

  def invLinkTargetIsDefined = {
    if (self.getAnnotationValue("gmf.link", "target").isDefined) Passed
    else Error(s"No target defined for link class ${self.name}")
  }

  def invTargetExists = guardedBy {
    self satisfies invLinkTargetIsDefined
  } check {
    if ((self.getAnnotationValue("gmf.link", "target") flatMap { v ⇒ self.eAllStructuralFeatures.find(_.name == v) }).isDefined) Passed
    else Error(s"'No reference named ${self.getAnnotationValue("gmf.link", "target")} exists in link class ${self.name}")
  }

  def invTargetAndSourceMustBeDifferent = guardedBy {
    (self satisfies invLinkSourceIsDefined) && (self satisfies invLinkTargetIsDefined)
  } check {
    if (self.getAnnotationValue("gmf.link", "source") != self.getAnnotationValue("gmf.link", "target")) Passed
    else Error(s"Source and target attributes must be different in link class ${self.name}")
  }

  def invCanBeVisualized = guardedBy {
    self.ePackage.getDiagramClass.isDefined
  } check {
    val diagram = self.ePackage.getDiagramClass.get
    val refs = diagram.eStructuralFeatures collect { case r: EReference if r.containment ⇒ r }
    val ref = refs find { r ⇒ (diagram.eAllSuperTypes contains (r.eType)) || diagram == r.eType }

    if (ref.isDefined) Passed
    else Warning(s"Cannot generate link for class ${self.name} because it cannot be contained in any containment reference of diagram root ${diagram.name}")
  }

}

class EStringToStringMapEntryContext extends ValidationContext with InvMethods with EcoreExtras with SigmaSupport {
  type Self = EStringToStringMapEntryImpl

  def invIsValidLinkDecoration = guardedBy {
    self.is("gmf.link", "source.decoration") || self.is("gmf.link", "target.decoration")
  } check {
    val values = Seq("none", "arrow", "rhomb", "filledrhomb", "square", "filledsquare", "closedarrow", "filledclosedarrow");
    if ((values contains self.value) || self.value.contains(".")) Passed
    else Warning(s"The value of ${self.toEmfatic} must be one of ${values.mkString(", ")} or a fully-qualified Java class name")
  }

  def invIsValidNodeFigure = guardedBy {
    self.is("gmf.node", "figure")
  } check {
    val values = Seq("rectangle", "ellipse", "rounded", "svg", "polygon")
    if ((values contains self.value) || self.value.contains(".")) Passed
    else Warning(s"The value of ${self.toEmfatic} must be one of ${values.mkString(", ")} or a fully-qualified Java class name")
  }

  def invIsValidLabelPlacement = guardedBy {
    self.is("gmf.node", "label.placement")
  } check {
    val values = Seq("internal", "external", "none")
    if (values contains self.value) Passed
    else Warning(s"The value of ${self.toEmfatic} must be one of ${values.mkString(", ")}")
  }

  def invIsValidInteger = guardedBy {
    self.is("gmf.node", "border.width") || self.is("gmf.node", "margin")
  } check {
    try {
      self.value.toInt
    } catch {
      case x: NumberFormatException ⇒ Error("The value of ${self.key} is not a valid integer")
    }
    Passed
  }

  def invIsValidListOfIntegers = guardedBy {
    self.is("gmf.node", "polygon.x") || self.is("gmf.node", "polygon.y")
  } check {
    if (self.value.matches("(\\s*\\d+)+")) Passed
    else Error(s"The value of ${self.toEmfatic} is not a valid list of integers")
  }

  def invIsValidRGB = guardedBy {
    self.is("gmf.node", "border.color") || self.is("gmf.node", "color") || self.is("gmf.link", "color")
  } check {
    if (self.value.matches("\\s*\\d+,\\s*\\d+,\\s*\\d+\\s*")) Passed
    else Error(s"The value of ${self.toEmfatic} is not a valid RGB color")
  }

  def invIsValidBoolean = guardedBy {
    self.is("gmf.diagram", "rcp") ||
      self.is("gmf.node", "label.icon") ||
      self.is("gmf.node", "label.readOnly") ||
      self.is("gmf.node", "phantom") ||
      self.is("gmf.node", "resizable") ||
      self.is("gmf.compartment", "collapsible") ||
      self.is("gmf.label", "label.readOnly")
  } check {
    val values = Seq("true", "false")
    if (values contains self.value) Passed
    else Warning(s"The value of ${self.toEmfatic} must be one of ${values.mkString(", ")}")
  }

  def invIsValidLineStyle = guardedBy {
    self.is("gmf.node", "border.style") || self.is("gmf.link", "style")
  } check {
    val values = Seq("dot", "dash", "solid")
    if (values contains self.value) Passed
    else Warning(s"The value of ${self.toEmfatic} must be one of ${values.mkString(", ")}")
  }

  def IsValidCompartmentLayout = guardedBy {
    self.key == "layout"
  } check {
    val values = Seq("list", "tree")
    if (values contains self.value) Passed
    else Warning(s"The value of ${self.eContainer().eContainer()} compartment must be one of ${values.mkString(", ")}")
  }

}

class EAnnotationContext extends ValidationContext with InvMethods with EcoreExtras with SigmaSupport {
  type Self = EAnnotation

  def invIsValidCompartment = guardedBy {
    self.source == "gmf.compartment"
  } check {
    if (self.eContainer match {
      case r: EReference ⇒ r.containment == true
      case _ ⇒ false
    }) Passed
    else Error(s"EObject ${self.eContainer} is not a containment reference")
  }

}

trait EcoreExtras extends EcorePackageScalaSupport {

  implicit class EStringToStringMapEntryImplExtras(that: EStringToStringMapEntryImpl) {
    def value = that.getValue
    def key = that.getKey
    def is(name: String, detail: String) = that.eContainer match {
      case x: EAnnotation ⇒ x.source == name && x.details.containsKey(detail)
      case _ ⇒ false
    }
    def toEmfatic = that.eContainer match {
      case x: EAnnotation ⇒ s"@${that.eContainer} (${that.key}) of ${that.eContainer.eContainer.asInstanceOf[ENamedElement].name}"
      case _ ⇒ ""
    }
  }

  implicit class EReferenceExtras(that: EReference) {
    def isLink: Boolean = that.isAnnotatedAs("gmf.link")
  }

  implicit class EPackageExtras(that: EPackage) {
    def getDiagramClass = that.eClassifiers collectFirst { case c: EClass if c.getAnnotation("gmf.diagram").isDefined ⇒ c }
  }

  implicit class EClassExtras(that: EClass) {
    def isNode: Boolean = {
      if (that.isLink || that.abstract_) false
      else if (that.isAnnotatedAs("gmf.nonode")) false
      else if (that.isAnnotatedAs("gmf.node")) true
      else that.eSuperTypes exists (_.isNode)
    }

    def isLink: Boolean = {
      if (that.abstract_) false
      else if (that.isAnnotatedAs("gmf.nolink")) false
      else if (that.isAnnotatedAs("gmf.link")) true
      else that.eSuperTypes exists (_.isLink)
    }
  }
}

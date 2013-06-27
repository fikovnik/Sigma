package fr.unice.i3s.sigma.examples.uml.support

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Image;

trait ImageScalaSupport extends EMFScalaSupport {
  type Image = org.eclipse.uml2.uml.Image
  
  protected implicit val _imageProxyBuilder = new EMFProxyBuilder[Image](UMLPackageScalaSupport._umlBuilder)
  
  object Image {
    def apply(eAnnotations: EList[EAnnotation] = null, ownedComment: EList[Comment] = null, content: String = null, format: String = null, location: String = null): Image = {
      val _instance = UMLPackageScalaSupport._umlBuilder.create[Image]
      
      if (eAnnotations != null) _instance.getEAnnotations.addAll(eAnnotations)
      if (ownedComment != null) _instance.getOwnedComments.addAll(ownedComment)
      if (content != null) _instance.setContent(content)
      if (format != null) _instance.setFormat(format)
      if (location != null) _instance.setLocation(location)
      
      _instance
    }
  }
  
  implicit class ImageScalaSupport(that: Image) {
    def content: String = that.getContent
    def content_=(value: String): Unit = that.setContent(value)
    def format: String = that.getFormat
    def format_=(value: String): Unit = that.setFormat(value)
    def location: String = that.getLocation
    def location_=(value: String): Unit = that.setLocation(value)
  }
}

object ImageScalaSupport extends ImageScalaSupport

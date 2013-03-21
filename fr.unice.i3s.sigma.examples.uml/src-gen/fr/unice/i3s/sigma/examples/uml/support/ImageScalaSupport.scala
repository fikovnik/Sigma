package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.Image;

trait ImageScalaSupport {
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

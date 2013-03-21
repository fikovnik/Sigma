package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.emf.common.util.EList;

import org.eclipse.uml2.uml.Comment;
import org.eclipse.uml2.uml.Element;

trait CommentScalaSupport {
  implicit class CommentScalaSupport(that: Comment) {
    def annotatedElement: EList[Element] = that.getAnnotatedElements
    def body: String = that.getBody
    def body_=(value: String): Unit = that.setBody(value)
  }
}

object CommentScalaSupport extends CommentScalaSupport

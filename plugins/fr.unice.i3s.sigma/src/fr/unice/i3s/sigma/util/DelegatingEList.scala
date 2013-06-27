package fr.unice.i3s.sigma.util

import java.util.{ List ⇒ JList }
import scala.collection.JavaConversions.seqAsJavaList
import scala.collection.mutable.Buffer

class DelegatingEList[E](delegatingList: Buffer[E]) extends org.eclipse.emf.common.util.DelegatingEList[E] {

  override def delegateList(): JList[E] = delegatingList

}
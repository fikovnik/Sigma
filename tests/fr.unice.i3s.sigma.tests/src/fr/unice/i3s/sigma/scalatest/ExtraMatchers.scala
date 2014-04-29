package fr.unice.i3s.sigma.scalatest

import scala.reflect.ClassTag
import scala.reflect.classTag
import org.eclipse.emf.ecore.EClass
import org.scalatest.matchers.BeMatcher
import org.scalatest.matchers.MatchResult

trait ExtraMatchers {

  def anEClass[T: ClassTag] = BeMatcher { obj: EClass ⇒
    val cls = classTag[T].runtimeClass
    MatchResult(
      cls.isAssignableFrom(obj.getInstanceClass),
      obj.toString + " was not an instance of " + cls.toString,
      obj.toString + " was an instance of " + cls.toString
    )
  }
  
}

object ExtraMatchers extends ExtraMatchers

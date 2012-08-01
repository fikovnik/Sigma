package test.delegates

import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
import fr.unice.i3s.sigma.scala.utils._
import test.D

object DDelegate {
  def getAttr1(self: D): String = {
    "D"
  }

  def validateAlwaysTrueInvariant(self: D): Boolean = {
    println("D")
    true
  }

  def validateAlwaysFalseInvariant(self: D): Boolean = {
    println("D")
    false
  }

}

package test.delegates

import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer
import test.D

object DDelegate {
  def getAttr1(self: D): String = {
    "D"
  }

  def validateAlwaysTrueInvariant(self: D): Boolean = {
    true
  }

  def validateAlwaysFalseInvariant(self: D): Boolean = {
    false
  }

}

package fr.unice.i3s.sigma.scala.mtt

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import fr.unice.i3s.sigma.scala.mtt.TextFile._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TextFileSpec extends FlatSpec with MustMatchers {

  "TextFile" must "append text" in {

    val t = new TextFile()
    t <<< "class A {"
    t indent {
      t << "def a(): String = " <<^ "a"
    }
    t <<< "}"

    println(t)

  }


}
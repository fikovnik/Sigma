package fr.unice.i3s.sigma.util

import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import java.io.File
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import scala.collection.mutable.Buffer

@RunWith(classOf[JUnitRunner])
class IOUtilsSpec extends FlatSpec with MustMatchers {

  "walk" must " visit only files" in {

    val tmp = IOUtils.mkdtemp
    new File(tmp, "1/2").mkdirs must be === true
    new File(tmp, "1/2/a").createNewFile must be === true
    new File(tmp, "3/4").mkdirs must be === true
    new File(tmp, "3/4/b").createNewFile must be === true

    val visited = Buffer[String]()
    IOUtils.walk(tmp) {
      case IOUtils.VisitFile(f) ⇒ visited += f.getName; IOUtils.Continue
    }

    visited must be === Buffer("a", "b")

    IOUtils.rmdir(tmp)
    tmp.exists must be === false
  }

  it must " visit only directories" in {

    val tmp = IOUtils.mkdtemp
    new File(tmp, "1/2").mkdirs must be === true
    new File(tmp, "3").mkdirs must be === true

    val visited = Buffer[String]()
    IOUtils.walk(tmp) {
      case IOUtils.PreVisitDir(f) if f != tmp ⇒
        visited += "pre" + f.getName; IOUtils.Continue
      case IOUtils.PostVisitDir(f) if f != tmp ⇒
        visited += "post" + f.getName; IOUtils.Continue
    }

    visited must be === Buffer("pre1", "pre2", "post2", "post1", "pre3", "post3")

    IOUtils.rmdir(tmp)
    tmp.exists must be === false
  }

  it must "visit both" in {

    val tmp = IOUtils.mkdtemp
    new File(tmp, "1/2").mkdirs must be === true
    new File(tmp, "1/2/a").createNewFile must be === true
    new File(tmp, "3").mkdirs must be === true
    new File(tmp, "3/b").createNewFile must be === true

    val visited = Buffer[String]()
    IOUtils.walk(tmp) {
      case IOUtils.PreVisitDir(f) if f != tmp ⇒
        visited += "pre" + f.getName; IOUtils.Continue
      case IOUtils.PostVisitDir(f) if f != tmp ⇒
        visited += "post" + f.getName; IOUtils.Continue
      case IOUtils.VisitFile(f) ⇒ visited += f.getName; IOUtils.Continue
    }

    visited must be === Buffer("pre1", "pre2", "a", "post2", "post1", "pre3", "b", "post3")

    IOUtils.rmdir(tmp)
    tmp.exists must be === false
  }

  it must "be able to terminate" in {

    val tmp = IOUtils.mkdtemp
    new File(tmp, "1/2").mkdirs must be === true
    new File(tmp, "1/2/a").createNewFile must be === true
    new File(tmp, "1/2/b").createNewFile must be === true
    new File(tmp, "3").mkdirs must be === true
    new File(tmp, "3/c").createNewFile must be === true

    val visited = Buffer[String]()
    IOUtils.walk(tmp) {
      case IOUtils.PreVisitDir(f) if f != tmp ⇒
        visited += "pre" + f.getName; IOUtils.Continue
      case IOUtils.PostVisitDir(f) if f != tmp ⇒
        visited += "post" + f.getName; IOUtils.Continue
      case IOUtils.VisitFile(f) ⇒ IOUtils.Terminate
    }

    visited must be === Buffer("pre1", "pre2")

    IOUtils.rmdir(tmp)
    tmp.exists must be === false
  }

  it must "be able to skip" in {

    val tmp = IOUtils.mkdtemp
    new File(tmp, "1/2").mkdirs must be === true
    new File(tmp, "1/2/a").createNewFile must be === true
    new File(tmp, "1/2/b").createNewFile must be === true
    new File(tmp, "3").mkdirs must be === true
    new File(tmp, "3/c").createNewFile must be === true

    IOUtils.walk(tmp) {
      case IOUtils.PreVisitDir(f) ⇒
        println("predir: " + f); IOUtils.Continue
      case IOUtils.PostVisitDir(f) if f != tmp ⇒
        println("postdir: " + f); IOUtils.Continue
      case IOUtils.VisitFile(f) if "a" == f.getName ⇒
        println("file: " + f); IOUtils.Continue
    }

    val visited = Buffer[String]()
    IOUtils.walk(tmp) {
      case IOUtils.PreVisitDir(f) if f != tmp ⇒
        visited += "pre" + f.getName; IOUtils.Continue
      case IOUtils.PostVisitDir(f) if f != tmp ⇒
        visited += "post" + f.getName; IOUtils.Continue
      case IOUtils.VisitFile(f) if "a" == f.getName ⇒
        IOUtils.Skip
      case IOUtils.VisitFile(f) ⇒
        visited += f.getName; IOUtils.Continue
    }

    visited must be === Buffer("pre1", "pre2", "post2", "post1", "pre3", "c", "post3")

    IOUtils.rmdir(tmp)
    tmp.exists must be === false
  }

  it must "be able to skip in pre dir visit" in {

    val tmp = IOUtils.mkdtemp
    new File(tmp, "1/2").mkdirs must be === true
    new File(tmp, "1/2/a").createNewFile must be === true
    new File(tmp, "1/3").mkdirs must be === true
    new File(tmp, "1/c").createNewFile must be === true

    IOUtils.walk(tmp) {
      case IOUtils.PreVisitDir(f) ⇒
        println("predir: " + f); IOUtils.Continue
      case IOUtils.PostVisitDir(f) if f != tmp ⇒
        println("postdir: " + f); IOUtils.Continue
      case IOUtils.VisitFile(f) if "a" == f.getName ⇒
        println("file: " + f); IOUtils.Continue
    }

    val visited = Buffer[String]()
    IOUtils.walk(tmp) {
      case IOUtils.PreVisitDir(f) if f != tmp ⇒
        visited += "pre" + f.getName;
        if (f.getName == "2") IOUtils.Skip
        else IOUtils.Continue
      case IOUtils.PostVisitDir(f) if f != tmp ⇒
        visited += "post" + f.getName; IOUtils.Continue
      case IOUtils.VisitFile(f) ⇒
        visited += f.getName; IOUtils.Continue
    }

    visited must be === Buffer("pre1", "pre2", "post2", "pre3", "post3", "c", "post1")

    IOUtils.rmdir(tmp)
    tmp.exists must be === false
  }

}
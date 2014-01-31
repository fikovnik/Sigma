package fr.unice.i3s.sigma.examples.ecmfa14.m2m

import fr.unice.i3s.sigma.m2m.M2M
import fr.unice.i3s.sigma.util.EMFUtils
import fr.unice.i3s.sigma.m2m.RuleMethods
import EER.support.EERPackageScalaSupport
import Relational.support.RelationalPackageScalaSupport
import Relational.RelationalPackage
import com.typesafe.scalalogging.log4j.Logging
import sun.util.logging.resources.logging
import org.junit.runner.RunWith
import org.scalatest.matchers.MustMatchers
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import java.io.File

class EER2Relational extends M2M with RuleMethods with EERPackageScalaSupport with RelationalPackageScalaSupport with Logging {

  val targetMetaModels = Seq(_Relational.ePackage)

  // TODO: pre block

  def ruleProject2Schema(p: _EER.Project, s: _Relational.Schema) {
    logger info s"Processing project ${p.name}"

    // The schema is named as the EER project
    s.name = p.name;
    // We add as tables the results of transforming all the entities and weak entities
    s.tables ++= ~p.nodes.collect { case e: _EER.Entity ⇒ e }
    // We add as domains the results of transforming all domains
    // TODO: following is not implemented in the original
    // s.domains ++= ~p.domains	
  }

  def ruleEntity2Table(e: _EER.Entity, t: _Relational.Table) {
    logger info s"Processing entity ${e.name}"

    t.name = e.name
  }

}

@RunWith(classOf[JUnitRunner])
class EER2RelationalTest extends FunSuite with MustMatchers with EERPackageScalaSupport {

  EMFUtils.IO.registerDefaultFactories

  test("Simple test") {
    val project = _EER.Project(name = "Project")
    project.nodes += _EER.Entity(name = "Entity 1")

    val transform = new EER2Relational()
    val schema = transform(project)

    schema foreach (_.dump())
  }

  test("default.xmi") {
    val project = EMFUtils.IO.loadFromFile[_EER.Project](new File("tests/default.xmi"), true)

    val transform = new EER2Relational()
    val schema = transform(project)

    schema foreach (_.dump())
  }

}
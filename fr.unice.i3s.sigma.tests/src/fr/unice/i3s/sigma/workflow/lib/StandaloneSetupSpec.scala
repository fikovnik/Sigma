package fr.unice.i3s.sigma.workflow.lib

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers

@RunWith(classOf[JUnitRunner])
class StandaloneSetupSpec extends FlatSpec with MustMatchers {

  "StandaloneSetup" must "register platform URI" in {

    StandaloneSetup(platformURI = "..", logResourceURIMap = true)

  }

}
package fr.unice.i3s.sigma.scalatest

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcorePackage
import org.junit.runner.RunWith
import org.scalatest.Finders
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import fr.unice.i3s.sigma.test.scalatest.ExtraMatchers
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ExtraMatchersTest extends FlatSpec with Matchers with ExtraMatchers {

  "anEClass matcher" should "match classes o EClasses" in {

    val ePackage = EcorePackage.eINSTANCE.getEPackage
    ePackage shouldBe anEClass [EPackage]
	ePackage should not be anEClass [EClass]
    
  }  
  
}
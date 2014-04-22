package fr.unice.i3s.sigma.m2m

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage

import org.junit.runner.RunWith

import org.scalatest.Finders
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.mock.MockitoSugar

import fr.unice.i3s.sigma.m2m.annotations.Abstract
import fr.unice.i3s.sigma.m2m.annotations.Greedy
import fr.unice.i3s.sigma.m2m.annotations.Lazy
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.test.scalatest.ExtraMatchers

import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MethodRulesSpec extends FlatSpec with Matchers with ExtraMatchers with EcorePackageScalaSupport {

  abstract class TestM2M extends M2MT {
    sourceMetaModels = _ecore
    targetMetaModels = _ecore
  }

  "MethodBasedRules M2M" should "load a matched rule" in {
    val m2m = new TestM2M {
      def rule1(s: _ecore.EClass, t: _ecore.EPackage) = {}
    }

    m2m.rules should have length (1)
    m2m.rules(0) shouldBe a[MatchedRule]
    m2m.rules(0).name should be === "1"
    m2m.rules(0).sourceClass shouldBe anEClass[EClass]
    m2m.rules(0).targetClasses should have length (1)
    m2m.rules(0).targetClasses(0) shouldBe anEClass[EPackage]
  }

  it should "load a matched rule with a guard" in {
    val m2m = new TestM2M {
      def rule1(s: _ecore.EClass, t: _ecore.EPackage) = guardedBy {
        true
      } transform {

      }
    }

    m2m.rules should have length (1)
  }

  it should "load a lazy rule" in {
    val m2m = new TestM2M {
      @Lazy def rule1(s: _ecore.EClass, t: _ecore.EPackage) {}
    }

    m2m.rules should have length (1)
    m2m.rules(0) shouldBe a[LazyRule]
  }

  it should "load a lazy and greedy rule" in {
    val m2m = new TestM2M {
      @Lazy @Greedy def rule1(s: _ecore.EClass, t: _ecore.EPackage) {}
    }

    m2m.rules should have length (1)
    m2m.rules(0) shouldBe a[LazyRule]
    m2m.rules(0) shouldBe a[GreedyRule]
  }  
  
  it should "load an abstract rule" in {
    val m2m = new TestM2M {
      // note: t is abstract class which is fine
      @Abstract def rule1(s: _ecore.EClass, t: _ecore.ENamedElement) {}
      @Abstract def rule2(s: _ecore.EClass, t: _ecore.EPackage) {}
    }

    m2m.rules should have length (2)
    m2m.rules(0) shouldBe a[AbstractRule]
    m2m.rules(1) shouldBe a[AbstractRule]
  }
  
  it should "throw an exception in case a non-abstract rule defines an abstract class as its target" in {
	  class M2M extends TestM2M {
		  @Abstract def rule1(s: _ecore.EClass, t: _ecore.ENamedElement) {}
	  }
	  
	  try {
	    new M2M
	  } catch {
	    case e: M2MTransformationException =>
	      e.getMessage shouldBe "Rule: 1 is non-abstract and as such it cannot define a target which is an abstract class"
	  }
  }

  it should "load a greedy rule" in {
    val m2m = new TestM2M {
      @Greedy def rule1(s: _ecore.EClass, t: _ecore.EPackage) {}
    }

    m2m.rules should have length (1)
    m2m.rules(0) shouldBe a[GreedyRule]
  }

  it should "execute the corresponding method" in {
    import org.scalatest.mock.MockitoSugar.mock
    import org.mockito.Mockito.{times, verify}
    
    class M2M extends TestM2M {
      def rule1(s: _ecore.EClass, t: _ecore.EPackage) { }
    }

    val source = _ecore.EClass()
    val target = _ecore.EPackage()

    val mockedM2M = mock[M2M]
    
    val m2m = new M2M {
      override protected val target = mockedM2M
    }
    
    m2m.rules(0).transform(source, Seq(target))
    
    verify(mockedM2M, times(1)).rule1(source, target)
  }

}
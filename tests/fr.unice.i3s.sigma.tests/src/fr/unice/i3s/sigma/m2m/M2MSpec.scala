package fr.unice.i3s.sigma.m2m

import scala.reflect.ClassTag
import scala.util.Success
import scala.util.Try
import org.junit.runner.RunWith
import org.mockito.ArgumentMatcher
import org.mockito.Matchers.anyObject
import org.mockito.Matchers.argThat
import org.mockito.Matchers.refEq
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalatest.mock.MockitoSugar
import fr.unice.i3s.sigma.examples.simpleoo.support.SimpleooPackageScalaSupport
import fr.unice.i3s.sigma.m2m.annotations.Abstract
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.test.scalatest.ExtraMatchers
import org.scalatest.junit.JUnitRunner
import fr.unice.i3s.sigma.m2m.annotations.Greedy
import fr.unice.i3s.sigma.m2m.annotations.Lazy

@RunWith(classOf[JUnitRunner])
class M2MSpec extends FlatSpec with Matchers with ExtraMatchers with MockitoSugar with EcorePackageScalaSupport with SimpleooPackageScalaSupport {

  import org.mockito.Mockito.{ mock ⇒ _, _ }
  import org.mockito.Matchers.{ refEq, argThat, anyObject }

  implicit def funToMatcher[T: ClassTag](fun: T ⇒ Boolean): ArgumentMatcher[T] = new ArgumentMatcher[T] {
    override def matches(arg: Object) = fun(arg.asInstanceOf[T])
  }

  def anyOf[T: ClassTag, S >: T](s: Iterable[S]) = argThat { x: T ⇒ s.toSeq contains x }

  abstract class TestM2M extends M2MT {
    sourceMetaModels = _ecore
    targetMetaModels = _simpleoo
  }

  "M2M transformation" should "execute all matching rules (in random order)" in {

    class M2M extends TestM2M {
      def rule1(s: _ecore.EClass, t: _simpleoo.Class) {}
      def rule2(s: _ecore.EClass, t: _simpleoo.Property) {}
      def rule3(s: _ecore.EClass, t: _simpleoo.Package) {}
      def rule4(s: _ecore.EPackage, t: _simpleoo.Class) {}
    }

    val mockedM2M = mock[M2M]
    val m2m = new M2M {
      override protected val target = mockedM2M
    }

    val source = _ecore.EClass()
    val (pri, sec) = m2m.execute(source)

    pri should have size (3) // three unique targets
    // TODO: should contain instanceOf
    pri exists (_.isInstanceOf[_simpleoo.Class]) shouldBe true
    pri exists (_.isInstanceOf[_simpleoo.Package]) shouldBe true
    pri exists (_.isInstanceOf[_simpleoo.Property]) shouldBe true
    sec shouldBe empty

    verify(mockedM2M, times(1)).rule1(refEq(source), anyOf(pri))
    verify(mockedM2M, times(1)).rule2(refEq(source), anyOf(pri))
    verify(mockedM2M, times(1)).rule3(refEq(source), anyOf(pri))
    verify(mockedM2M, never()).rule4(anyObject(), anyObject())
  }

  it should "execute abstract rules from regular rules" in {
    class M2M extends TestM2M {
      @Abstract def rule1(s: _ecore.ENamedElement, t: _simpleoo.ModelElement) {}
      @Abstract def rule2(s: _ecore.EClassifier, t: _simpleoo.ModelElement) {}
      @Abstract def rule3(s: _ecore.EPackage, t: _simpleoo.ModelElement) {}

      def rule4(s: _ecore.EClass, t: _simpleoo.Class) {}
      def rule5(s: _ecore.EClass, t1: _simpleoo.Package, t2: _simpleoo.Class) {}
    }

    val mockedM2M = mock[M2M]
    val m2m = new M2M {
      override protected val target = mockedM2M
    }

    val source = _ecore.EClass()
    m2m(source)

    verify(mockedM2M, times(2)).rule1(refEq(source), anyObject())
    verify(mockedM2M, times(2)).rule2(refEq(source), anyObject())
    verify(mockedM2M, never()).rule3(anyObject(), anyObject())
    verify(mockedM2M, times(1)).rule4(refEq(source), anyObject())
    verify(mockedM2M, times(1)).rule5(refEq(source), anyObject(), anyObject())
  }

  it should "execute abstract rules with the correct arguments" in {
    val m2m = new TestM2M {
      @Abstract def rule1(s: _ecore.ENamedElement, t: _simpleoo.ModelElement) {
        t.name = "A"
      }

      def rule2(s: _ecore.EClass, t1: _simpleoo.Class, t2: _simpleoo.Class) {
        t2.name = "B"
      }
    }

    val (pri, sec) = m2m.execute(_ecore.EClass())

    pri should have size (1)
    pri.toSeq(0).asInstanceOf[_simpleoo.Class].name shouldBe "A"
    sec should have size (1)
    sec.toSeq(0).asInstanceOf[_simpleoo.Class].name shouldBe "B"

  }

  it should "only execute abstract rule from regular rules" in {
    class M2M extends TestM2M {
      @Abstract def rule1(s: _ecore.ENamedElement, t: _simpleoo.ModelElement) {}
      @Greedy def rule2(s: _ecore.EModelElement, t: _simpleoo.Class) {}
    }

    val mockedM2M = mock[M2M]
    val m2m = new M2M {
      override protected val target = mockedM2M
    }

    val source = _ecore.EClass()
    m2m(source)

    verify(mockedM2M, never()).rule1(anyObject(), anyObject())
    verify(mockedM2M, times(1)).rule2(refEq(source), anyObject())
  }

  it should "not allow conflicting rules" in {
    class M2M extends TestM2M {
      def rule1(s: _ecore.EClass, t: _simpleoo.Class) {}
      def rule2(s: _ecore.EClass, t: _simpleoo.Class) {}
    }

    try {
      new M2M
    } catch {
      case x: M2MTransformationException ⇒ x.printStackTrace()
    }
  }

  it should "not execute lazy rules during regular transformation" in {
    class M2M extends TestM2M {
      @Lazy def rule1(s: _ecore.EClass, t: _simpleoo.Class) {}
    }

    val mockedM2M = mock[M2M]
    val m2m = new M2M {
      override protected val target = mockedM2M
    }

    val source = _ecore.EClass()
    m2m(source)

    verify(mockedM2M, never()).rule1(anyObject(), anyObject())
  }

  "Equivalent operator" should "implicitly transform an element" in {
    val m2m = new TestM2M {
      def rule1(s: _ecore.EClass, t: _simpleoo.Class) {
        t.name = s.name
        t.superClass = ~s.eSuperTypes.headOption
      }
    }

    val c1 = _ecore.EClass(name = "c1")
    val c2 = _ecore.EClass(name = "c2")
    c2.eSuperTypes += c1

    val (pri, sec) = m2m.execute(c2)

    pri should have size (1)
    pri.toSeq(0).asInstanceOf[_simpleoo.Class].name shouldBe "c2"
    pri.toSeq(0).asInstanceOf[_simpleoo.Class].superClass.get.name = "c1"

    sec should have size (1)
    sec.toSeq(0).asInstanceOf[_simpleoo.Class].name shouldBe "c1"
  }

  it should "implicitly transform a collection" in {
    val m2m = new TestM2M {
      def rule1(s: _ecore.EClass, t: _simpleoo.Class) {
        t.name = s.name
        t.features ++= ~s.eStructuralFeatures
      }

      def rule2(s: _ecore.EAttribute, t: _simpleoo.Property) {
        t.name = s.name
      }

      def rule3(s: _ecore.EAttribute, t: _simpleoo.Class) {
        t.name = s.name
      }
    }

    val c1 = _ecore.EClass(name = "c1")
    c1.eStructuralFeatures += _ecore.EAttribute(name = "a1")
    c1.eStructuralFeatures += _ecore.EAttribute(name = "a2")

    val (pri, sec) = m2m.execute(c1)

    pri should have size (1)
    val c1t = pri.toSeq(0).asInstanceOf[_simpleoo.Class]
    c1t.name shouldBe "c1"
    c1t.features should have size (2)
    c1t.features.map(_.name) shouldBe Seq("a1", "a2")

    // from the rule3
    sec should have size (2)
  }

  it should "execute lazy rules" in {
    val m2m = new TestM2M {
      def rule2(s: _ecore.EClass, t: _simpleoo.Class) {
        t.features ++= ~s.eStructuralFeatures
      }

      @Lazy def rule1(s: _ecore.EAttribute, t: _simpleoo.Property) {
        t.name = "A"
      }
    }

    val source = _ecore.EClass()
    source.eStructuralFeatures += _ecore.EAttribute(name = "B")
    val (prim, sec) = m2m.execute(source)

    prim.toSeq(0).eContents.get(0).asInstanceOf[_simpleoo.Property].name shouldBe "A"
  }

  it should "consider all targets" in {
    val m2m = new TestM2M {
      def rule2(s: _ecore.EClass, t: _simpleoo.Class) {
        t.features ++= ~s.eStructuralFeatures
      }

      def rule1(s: _ecore.EAttribute, t: _simpleoo.Property) {
        t.name = "A"
      }
      def rule3(s: _ecore.EAttribute, t: _simpleoo.Operation) {
    	t.name = "B"
      }
    }

    val source = _ecore.EClass()
    source.eStructuralFeatures += _ecore.EAttribute()
    val (prim, sec) = m2m.execute(source)

    prim.toSeq(0).eContents should have size(2)
    // TODO: verify the contents includes both Property and Operation 
    // [fr.unice.i3s.sigma.examples.simpleoo.impl.PropertyImpl@23c7a1e5 (name: A) (ownerScope: sk_instance) (multi: false), fr.unice.i3s.sigma.examples.simpleoo.impl.OperationImpl@44dc688f (name: B) (ownerScope: sk_instance)]
  }

  // TODO: greedy rules
  // TODO: object is transformed only once
  // TODO: containment - multiple targets
  // 

  class NOPRule(
    val sourceClass: _ecore.EClass,
    val targetClasses: Seq[_ecore.EClass]) extends Rule {

    val name = "NOPRule"

    def isApplicable(source: _ecore.EObject) = true
    protected def doTransform(source: _ecore.EObject, targets: Seq[_ecore.EObject]): Try[Boolean] = Success(true)
  }

  "AbstractRule" should "be a super rule to a rule whose source and targets are the same of are sublasses" in {

    val rule1 = new NOPRule(_ecore.ePackage.getEDataType, Seq(_ecore.ePackage.getEClass)) with AbstractRule
    val rule2 = new NOPRule(_ecore.ePackage.getENamedElement, Seq(_ecore.ePackage.getEClassifier)) with AbstractRule

    rule2.isSuperRuleOf(rule1) shouldBe true

    val rule3 = new NOPRule(_ecore.ePackage.getEClass, Seq(_ecore.ePackage.getEClassifier)) with AbstractRule

    rule3.isSuperRuleOf(rule1) shouldBe false

    val rule4 = new NOPRule(_ecore.ePackage.getENamedElement, Seq(_ecore.ePackage.getEPackage)) with AbstractRule

    rule4.isSuperRuleOf(rule1) shouldBe false

    val rule5 = new NOPRule(_ecore.ePackage.getEClass, Seq(_simpleoo.ePackage.getClass_, _simpleoo.ePackage.getClass_))
    val rule6 = new NOPRule(_ecore.ePackage.getENamedElement, Seq(_simpleoo.ePackage.getModelElement)) with AbstractRule

    rule6.isSuperRuleOf(rule5) shouldBe true
  }

  "MatcherRule" should "conflict with a rule defining the same source - target relation" in {
    val rule1 = new NOPRule(_ecore.ePackage.getEClass, Seq(_ecore.ePackage.getEClass))
    val rule2 = new NOPRule(_ecore.ePackage.getEClass, Seq(_ecore.ePackage.getEClass))

    rule1.conflicts(rule2) shouldBe true
    rule2.conflicts(rule1) shouldBe true

    val rule3 = new NOPRule(_ecore.ePackage.getEPackage, Seq(_ecore.ePackage.getEClass))
    rule3.conflicts(rule1) shouldBe false
    rule1.conflicts(rule3) shouldBe false
  }

  "GreedyRule" should "conflict with a rule defining the same source - target relation" in {
    val rule1 = new NOPRule(_ecore.ePackage.getEClass, Seq(_ecore.ePackage.getEClass))
    val rule2 = new NOPRule(_ecore.ePackage.getEClassifier, Seq(_ecore.ePackage.getEClass)) with GreedyRule

    rule1.conflicts(rule2) shouldBe false
    rule2.conflicts(rule1) shouldBe true
  }

}
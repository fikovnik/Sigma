package fr.unice.i3s.sigma.m2m

import scala.collection.JavaConversions.asScalaBuffer
import scala.reflect.ClassTag

import org.eclipse.emf.common.util.EList

import fr.unice.i3s.sigma.support.SigmaEcorePackage
import fr.unice.i3s.sigma.support.SigmaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore.EClass
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore.EObject
import fr.unice.i3s.sigma.support.ecore.EcorePackageScalaSupport._ecore.EPackage

package object emf {
  implicit def eobject2transformable(that: EObject)(implicit context: M2MContext) = new DefaultTransformable(context, that)
  implicit def elist2TransformableSeq[A <% Transformable](that: EList[A]) = new SigmaM2MSequenceSupport(that)
  implicit def sigmaEcorePackage2MetaModel[A <: EPackage : ClassTag](that: SigmaEcorePackage[A]) = new EMFMetaModel(that.ePackage)
}

package emf {

  object EMFMetaModel {
    def apply[T <: EPackage: ClassTag](pkg: T) = new EMFMetaModel(pkg)
    def apply[T <: EPackage: ClassTag](pkg: SigmaEcorePackage[T]) = new EMFMetaModel(pkg.ePackage)
  }

  class EClassMetaClass(val eclass: EClass) {

  }

  class EMFMetaModel[T <: EPackage : ClassTag](val pkg: T) extends MetaModel with SigmaSupport with EcorePackageScalaSupport {

    case class EClassMetaClass(eclass: EClass) extends MetaClass {

      def isTypeOf(m: MetaClass): Boolean = m match {
        case x: EClassMetaClass => x.eclass == eclass
      }

      def isKindOf(m: MetaClass): Boolean = m match {
        case x: EClassMetaClass => eclass.isSuperTypeOf(x.eclass)
        case _ => false
      }

      def isTypeOf(m: AnyRef): Boolean = m match {
        case x: EObject => eclass == x.eClass
        case _ => false
      }

      def isKindOf(m: AnyRef): Boolean = m match {
        case x: EObject => eclass.isSuperTypeOf(x.eClass)
        case _ => false
      }

      def newInstance: AnyRef = pkg.getEFactoryInstance.create(eclass)

      def isAbstract = eclass.isAbstract || eclass.isInterface

      def name = eclass.name

      def contents(elem: AnyRef): Seq[AnyRef] = elem match {
        case x: EObject => x.eContents
        case _ => Seq()
      }
    }

    type MC = EClassMetaClass

    lazy val classifiers = pkg.sAllContents[EClass]

    def findMetaClass(elem: AnyRef): Option[MetaClass] = elem match {
      case x: EObject if classifiers contains (x.eClass) => Some(EClassMetaClass(x.eClass))
      case _ => None
    }

    def findMetaClass(clazz: Class[_]): Option[MetaClass] =
      classifiers find (_.instanceClassName == clazz.getName) map (EClassMetaClass(_))

    def containsClass(clazz: Class[_]): Boolean = 
      classifiers exists (_.instanceClassName == clazz.getName)
    
    def containsElement(elem: AnyRef): Boolean = elem match {
      case x: EObject if classifiers contains (x.eClass) => true
      case _ => false
    }

    override def toString = s"EMFModel(${pkg.name} - ${pkg.nsURI})"

  }

}
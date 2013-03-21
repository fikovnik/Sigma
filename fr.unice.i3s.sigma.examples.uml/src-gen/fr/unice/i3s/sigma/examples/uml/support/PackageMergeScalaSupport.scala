package fr.unice.i3s.sigma.examples.uml.support

import org.eclipse.uml2.uml.PackageMerge;

trait PackageMergeScalaSupport {
  implicit class PackageMergeScalaSupport(that: PackageMerge) {
    def mergedPackage: org.eclipse.uml2.uml.Package = that.getMergedPackage
    def mergedPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setMergedPackage(value)
    def receivingPackage: org.eclipse.uml2.uml.Package = that.getReceivingPackage
    def receivingPackage_=(value: org.eclipse.uml2.uml.Package): Unit = that.setReceivingPackage(value)
  }
}

object PackageMergeScalaSupport extends PackageMergeScalaSupport

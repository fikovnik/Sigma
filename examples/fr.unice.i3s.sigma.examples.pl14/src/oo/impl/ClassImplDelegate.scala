package oo.impl

import oo.Class
import oo.support.OOPackageScalaSupport

class ClassImplDelegate extends ClassImpl with ClassDelegate

protected trait ClassDelegate extends Class with OOPackageScalaSupport {
  
  override def getOperations = this.features collect {
    case x: Operation => x 
  }
  
  override def getProperties = this.features collect {
    case x: Property => x
  }
  
}
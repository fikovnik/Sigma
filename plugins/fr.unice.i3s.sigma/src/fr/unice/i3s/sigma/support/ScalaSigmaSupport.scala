package fr.unice.i3s.sigma.support

import fr.unice.i3s.sigma.m2t.TextOutputting

trait ScalaSigmaSupport {

  implicit class SigmaOption[T](that: Option[T]) {
    
    /** Returns the option's value if it is nonempty, or throw the given exception `t` if it is empty. */
    def orThrow(t: Throwable): T = if (that.isDefined) that.get else throw t
  }
  
  implicit class SigmaBoolean(that: Boolean) {
    
    /** Logical implication */
    def implies(b: => Boolean): Boolean = !that || b
    
  }
  
  /** Makes string to implement [[TextOutputting]] */
  implicit class RichSigmaString(that: String) extends TextOutputting  
}

object ScalaSigmaSupport extends ScalaSigmaSupport
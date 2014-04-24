package fr.unice.i3s.sigma.support

import fr.unice.i3s.sigma.m2t.TextOutputting
import scala.util.Try
import scala.util.Failure
import scala.util.Success
import scala.collection.TraversableLike

trait ScalaSigmaSupport {

  implicit class SigmaOption[T](that: Option[T]) {

    /** Returns the option's value if it is nonempty, or throw the given exception `t` if it is empty. */
    def orThrow(t: Throwable): T = if (that.isDefined) that.get else throw t
  }

  implicit class SigmaTry[T](that: Try[T]) {

    /** Returns the value from this Success or throws a runtime exception with the given `message` and the Failure exception as a cause. */
    def orCrash(message: String) = that match {
      case Success(v) => v
      case Failure(e) => throw new RuntimeException(message, e)
    }
  }

  implicit class SigmaBoolean(that: Boolean) {

    /** Logical implication */
    def implies(b: => Boolean): Boolean = !that || b

  }

  implicit class SigmaIterable[A](that: Iterable[A]) {
    def distinctBy[B, That](f: A => B) =
      that.filterNot {
        var set = Set[B]()
        
        elem =>
          
          val b = f(elem)
          val contains = set(b)
          set += b;
          contains
      }
  }

  /** Makes string to implement [[TextOutputting]] */
  implicit class RichSigmaString(that: String) extends TextOutputting {
    override def toString = that.toString
  }
}

object ScalaSigmaSupport extends ScalaSigmaSupport
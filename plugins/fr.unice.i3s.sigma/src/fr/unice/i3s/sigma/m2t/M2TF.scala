package fr.unice.i3s.sigma.m2t

import scala.util.Try
import java.io.File
import fr.unice.i3s.sigma.support.ScalaSigmaSupport

case class M2TF[T >: Null](transformations: (M2T {type Source = T}, (T => String))*) extends ScalaSigmaSupport {

  def transform(source: T, dest: File) = {
    for ((m2t, nameFun) <- transformations) {
      m2t.transform(source) >> new File(dest, nameFun(source))
    }
  }
  
}
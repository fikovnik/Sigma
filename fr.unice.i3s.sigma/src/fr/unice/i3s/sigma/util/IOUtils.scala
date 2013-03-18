package fr.unice.i3s.sigma.util

import java.io.Closeable
import java.io.Writer
import java.io.FileWriter
import java.io.File

object IOUtils {

  def using[B](file: File)(f: Writer ⇒ B): B = using(new FileWriter(file))(f)

  def using[A <: Closeable, B](input: A)(f: A ⇒ B): B = {
    try { f(input) } finally { input.close() }
  }

}
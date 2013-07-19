package fr.unice.i3s.sigma.m2t

import java.io.Writer
import java.io.OutputStreamWriter
import java.io.OutputStream
import com.google.common.base.Charsets
import java.io.File
import fr.unice.i3s.sigma.util.IOUtils
import java.io.FileWriter

/**
 * Provides some convenient methods for outputting text into streams and writers.
 * The text is taken from the {{{#toString}}} method of the class where this trait is mixed in.
 */
trait TextOutput {
  
  def output(out: Writer): this.type = {
    out append (toString)
    out.flush
    this
  }

  def output(out: OutputStream): this.type = {
    output(new OutputStreamWriter(out, Charsets.UTF_8))
  }

  def output(file: File): this.type = {
    IOUtils.using(file) { fw =>
      output(fw)
    }
    this
  }
  
  def >>(out: Writer): this.type = output(out)
  def >>(out: OutputStream): this.type = output(out)
  def >>(out: File): this.type = output(out)
  
}
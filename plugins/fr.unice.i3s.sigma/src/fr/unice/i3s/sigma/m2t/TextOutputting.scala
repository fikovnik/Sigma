package fr.unice.i3s.sigma.m2t

import java.io.File
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.io.Writer

import fr.unice.i3s.sigma.util.IOUtils

/**
 * Provides some convenient methods for outputting text into streams and writers.
 * The text is taken from the {{{#toString}}} method of the class where this trait is mixed in.
 */
trait TextOutputting {
  
  def output(out: Writer): TextOutputting.this.type = {
    out append (toString)
    out.flush
    TextOutputting.this
  }

  def output(out: OutputStream): TextOutputting.this.type = {
    output(new OutputStreamWriter(out))
  }

  def output(file: File): TextOutputting.this.type = {
    IOUtils.using(file) { fw =>
      output(fw)
    }
    TextOutputting.this
  }
  
  def >>(out: Writer): TextOutputting.this.type = output(out)
  def >>(out: OutputStream): TextOutputting.this.type = output(out)
  def >>(out: File): TextOutputting.this.type = output(out)
  
}
package fr.unice.i3s.sigma.support

import java.nio.file.Files
import java.io.InputStream
import java.io.File
import java.nio.file.Paths

trait IOSupport {

  implicit class SigmaInputStream(that: InputStream) {
    def >>(file: File) = Files.copy(that, Paths.get(file.toURI))
  }

}

object IOSupport extends IOSupport
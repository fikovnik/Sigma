package fr.unice.i3s.sigma.util

import scala.util.Try

trait Executor {
  def execute(cmd: String): Try[String]
  def execute(cmdArgs: Seq[String]): Try[String]
}

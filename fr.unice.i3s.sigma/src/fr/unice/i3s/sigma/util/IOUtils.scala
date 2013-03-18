package fr.unice.i3s.sigma.util

import java.io.Closeable
import java.io.Writer
import java.io.FileWriter
import java.io.File
import scala.collection.TraversableLike
import scala.annotation.tailrec

object IOUtils {

  lazy val pathSep = System.getProperty("path.separator")

  def rmdir(dir: File, deleteParentDir: Boolean = true, stopOnError: Boolean = false) = {
    def remove(f: File) = if (!f.delete && stopOnError) Terminate else Continue

    walk(dir) { e ⇒
      e match {
        case VisitFile(f) ⇒ remove(f)
        case PostVisitDir(f) if !(f == dir) || deleteParentDir ⇒ remove(f)
      }
    }
  }

  def mkdtemp: File = mkdtemp("temp", System.nanoTime.toString)
  def mkdtemp(prefix: String, suffix: String): File = {
    val f = File.createTempFile(prefix, suffix)
    if (!f.delete) throw new RuntimeException("Unable to remove temp file: " + f)
    if (!f.mkdir) throw new RuntimeException("Unable to create a temp dir: " + f)
    f
  }

  def using[B](file: File)(f: Writer ⇒ B): B = using(new FileWriter(file))(f)

  def using[A <: Closeable, B](input: A)(f: A ⇒ B): B = {
    try { f(input) } finally { input.close() }
  }

  sealed trait FileVisitResult
  case class VisitFile(val file: File) extends FileVisitEvent
  case class PreVisitDir(val dir: File) extends FileVisitEvent
  case class PostVisitDir(val dir: File) extends FileVisitEvent

  sealed trait FileVisitEvent
  /** Continue */
  case object Continue extends FileVisitResult
  /** Continue without visiting the entries in this directory.  */
  case object Skip extends FileVisitResult
  /** Terminate */
  case object Terminate extends FileVisitResult

  def walk(file: File)(proc: PartialFunction[FileVisitEvent, FileVisitResult]) {
    val continue = { _: FileVisitEvent ⇒ Continue }

    def doWalk(f: File): FileVisitResult = {

      def loopUntil(it: Seq[File]): FileVisitResult = it match {
        case Seq() ⇒ Continue
        case Seq(x, xs @ _*) ⇒
          doWalk(x) match {
            case Continue ⇒ loopUntil(xs)
            case r ⇒ r
          }
      }

      if (f.isDirectory) {
        proc.applyOrElse(PreVisitDir(f), continue) match {
          case Continue ⇒
            val files = f.listFiles
            if (files != null) loopUntil(files) match {
              case Terminate ⇒ Terminate
              case _ ⇒ proc.applyOrElse(PostVisitDir(f), continue)
            }
            else Continue
          case r ⇒ r
        }
      } else proc(VisitFile(f))
    }

    doWalk(file)
  }
}
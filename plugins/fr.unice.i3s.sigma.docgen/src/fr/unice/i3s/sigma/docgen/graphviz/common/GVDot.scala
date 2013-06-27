package fr.unice.i3s.sigma.docgen.graphviz.common

import java.io.File
import scala.util.Failure
import scala.util.Success
import scala.util.Try
import com.google.common.io.Files
import fr.unice.i3s.sigma.util.IOUtils
import fr.unice.i3s.sigma.util.Executor

abstract sealed class GVOutputType(val name: String, val ext: String, val description: String)

object GVOutputType {
  case object PNG extends GVOutputType("PNG", "png", "PNG (Portable Network Graphics)")
  case object PDF extends GVOutputType("PDF", "pdf", "PDF (Portable Document Format)")
  case object DOT extends GVOutputType("Graphviz DOT", "dot", "Graphviz Graph File")

  val values = PDF :: PNG :: DOT :: Nil
}

object GVDot {
  case class DotVersion(val major: Int, val minor: Int) extends Ordered[DotVersion] {
    def compare(that: DotVersion) = (major * 100 + minor) - (that.major * 100 + that.minor)
    override def toString = s"$major.$minor"
  }

  val DOT_FILE_EXT = "dot"
  val COMPATIBLE_VERSION = DotVersion(2, 0)

  private val DOT_VERSION_PATTERN = "^dot - graphviz version (\\d+)\\.(\\d+)\\.(\\d+).*$".r

  class UnsupportedVersionException(val version: DotVersion) extends Exception(s"Expected >= $COMPATIBLE_VERSION, got $version")
}




/**
 * Wrapper of the Graphviz dot program
 *
 * Potential problems:
 * - Not found or unable to execute -> IOException
 * - Wrong version -> IncompatibleVersionException
 * - Runtime problem -> RuntimeException
 */
class GVDot(path: String) {

  val executor: Executor = IOUtils.SystemExecutor

  import GVDot._

  def version: Try[DotVersion] = {
    executor.execute(List(path, "-V")) match {
      case Success(output) ⇒ {
        val lines = output split ("\n")
        lines(0) match {
          case DOT_VERSION_PATTERN(major, minor, _) ⇒ Success(DotVersion(major.toInt, minor.toInt))
          case _ ⇒ Failure(new Exception("Unable to match version number from dot output: " + output))
        }
      }
      case Failure(e) ⇒ Failure(e)
    }
  }

  def validate: Try[DotVersion] = version match {
    case Success(version) if version >= COMPATIBLE_VERSION ⇒ Success(version)
    case Success(version) ⇒ Failure(new UnsupportedVersionException(version))
    case Failure(e) ⇒ Failure(e)
  }

  def generate(in: File, out: File, outputType: GVOutputType): Try[File] = {
    if (outputType == GVOutputType.DOT) {
      Files.copy(in, out)
      return Success(out)
    }

    validate match {
      case Success(_) ⇒
      case Failure(e) ⇒ Failure(e)
    }

    val args = List(path, "-T", outputType.ext, in.getAbsolutePath(), "-o", out.getAbsolutePath())

    executor.execute(args) match {
      case Success(_) ⇒ Success(out)
      case Failure(e) ⇒ Failure(e)
    }
  }

}
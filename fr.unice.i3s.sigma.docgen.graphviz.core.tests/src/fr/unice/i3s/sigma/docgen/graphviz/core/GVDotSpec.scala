package fr.unice.i3s.sigma.docgen.graphviz.core

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.matchers.MustMatchers
import org.scalatest.FlatSpec
import fr.unice.i3s.sigma.docgen.graphviz.core.GVDot
import fr.unice.i3s.sigma.docgen.graphviz.core.GVDot._
import org.scalatest.mock.MockitoSugar
import fr.unice.i3s.sigma.docgen.graphviz.core.Executor
import fr.unice.i3s.sigma.docgen.graphviz.core.GVDot.DotVersion
import org.mockito.Mockito._
import org.mockito.Matchers._
import scala.collection.JavaConversions._
import scala.util.Success
import fr.unice.i3s.sigma.docgen.graphviz.core.GVDot._
import java.io.File
import org.mockito.Matchers

@RunWith(classOf[JUnitRunner])
class GVDotSpec extends FlatSpec with MustMatchers with MockitoSugar {

  "GVDot" must "parse the version correctly" in {

    val executorMock = mock[Executor]
    when(executorMock.execute(List("pathToDot", "--version"))).thenReturn(Success(
      """dot - graphviz version 2.28.0 (20130128.1032)
           |libdir = "/usr/local/Cellar/graphviz/2.28.0/lib/graphviz"
           |Activated plugin library: libgvplugin_quartz.6.dylib
           |Using textlayout: textlayout:quartz
           |Activated plugin library: libgvplugin_dot_layout.6.dylib
           |Using layout: dot:dot_layout
           |Activated plugin library: libgvplugin_core.6.dylib
           |Using render: dot:core
           |Using device: dot:dot:core
           |The plugin configuration file:
           |	/usr/local/Cellar/graphviz/2.28.0/lib/graphviz/config6
           |		was successfully loaded.
           |    render	:  dot fig gd map ps quartz svg tk vml vrml xdot
           |    layout	:  circo dot fdp neato nop nop1 nop2 osage patchwork sfdp twopi
           |    textlayout	:  textlayout
           |    device	:  bmp canon cgimage cmap cmapx cmapx_np dot eps exr fig gd gd2 gif gv imap imap_np ismap jp2 jpe jpeg jpg pct pdf pict plain plain-ext png ps ps2 psd sgi svg svgz tga tif tiff tk vml vmlz vrml wbmp xdot
           |    loadimage	:  (lib) bmp eps gd gd2 gif jpe jpeg jpg pdf png ps svg xbm""".stripMargin))

    val dot = new GVDot("pathToDot") {
      override val executor = executorMock
    }

    dot.version.get must be === DotVersion(2, 28)

  }

  it must "detect incompatible version" in {

    val executorMock = mock[Executor]
    when(executorMock.execute(List("pathToDot", "--version"))).thenReturn(Success(
      "dot - graphviz version 1.28.0 (20130128.1032)"))

    val dot = new GVDot("pathToDot") {
      override val executor = executorMock
    }

    val thrown = evaluating { dot.validate.get } must produce[IncompatibleVersionException]
    thrown.getMessage must equal(s"Incompatible Graphviz version 1.28. Expected >= $COMPATIBLE_VERSION")
  }

  it must "correctly compose the cmdline arguments" in {
    val executorMock = mock[Executor]
    when(executorMock.execute(any())).thenReturn(Success(""))
    val dot = new GVDot("pathToDot") {
      override val executor = executorMock
    }

    val in = new File("a")
    val out = new File("a")
    dot.generate(in, out, PNG)

    verify(executorMock).execute(List("pathToDot", "-T", "png", in.getAbsolutePath(), "-o", out.getAbsolutePath()))
  }
}
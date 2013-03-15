package fr.unice.i3s.sigma.docgen.graphviz.ui.internal.handlers

import scala.collection.JavaConversions._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.matchers.MustMatchers
import org.scalatest.mock.MockitoSugar
import fr.unice.i3s.sigma.docgen.graphviz.common.GVDot
import org.eclipse.core.commands.ExecutionEvent
import org.mockito.Mockito._
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.core.expressions.IEvaluationContext
import org.eclipse.ui.ISources

@RunWith(classOf[JUnitRunner])
class ExportClassDiagramAsImageHandlerSpec extends FlatSpec with MustMatchers with MockitoSugar {

  "ExportClassDiagramAsImageHandler" must " not do anything on an empty selection" in {
    val dotMock = mock[GVDot]
    val ctxMock = mock[IEvaluationContext]
    val selectionMock = mock[IStructuredSelection]

    when(ctxMock.getVariable(ISources.ACTIVE_MENU_SELECTION_NAME)) thenReturn (selectionMock, Nil: _*)
    when(selectionMock.isEmpty()) thenReturn true

    val handler = new ExportClassDiagramHandler {
      override def dot = dotMock
    }

    val event = new ExecutionEvent(null, Map[Any, Any](), null, ctxMock)
    handler.execute(event)

    verifyNoMoreInteractions(dotMock)
  }

}
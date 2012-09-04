package fr.unice.i3s.sigma.scala.utils
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.notify.Notification
import org.junit.Test
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.util.EContentAdapter
import library.Library
import library.Book
import library.LibraryFactory.eINSTANCE.createBook
import library.LibraryFactory.eINSTANCE.createLibrary
import org.junit.Test
import library.LibraryPackage
import library.LibraryFactory

final class NotificationTest extends InitializableEcore {

  @Test
  def testNotification2() {

    

    class MyAdapter extends EContentAdapter {
      override def notifyChanged(notification: Notification) {
        super.notifyChanged(notification)
        println(notification)
      }
    }

    val builder = new EMFBuilder(LibraryPackage.eINSTANCE)

    import builder._

    val res = new ResourceImpl
    res.eAdapters.add(new MyAdapter)
    res.eAdapters.add(new PostponeContentInitializerAdapter)

    val library = create[Library]
    res.getContents.add(library)

    val book = create[Book] initLater { a =>
      a.setPages(100)
    }
    library.getBooks.add(book)

  }

  //  @Test
  def testNotification() {

    class MyAdapter extends AdapterImpl {
      override def notifyChanged(notification: Notification) {
        println(notification)
      }
    }

    import LibraryFactory.eINSTANCE._

    val res = new ResourceImpl
    val library = createLibrary
    val book = createBook
    book.eAdapters.add(new MyAdapter)
    library.getBooks.add(book)
    book.setPages(100)
  }

}
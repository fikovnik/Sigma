package fr.unice.i3s.utils.scala.emf
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.notify.Notification
import org.junit.Test
import library.LibraryFactory
import org.eclipse.emf.ecore.resource.impl.ResourceImpl
import org.eclipse.emf.ecore.util.EContentAdapter
import library.LibraryPackage
import library.Library
import library.Book
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EObject

class NotificationTest {

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

    val library = create[Library]()
    res.getContents.add(library)

    val book = create[Book]() initializeLater { a =>
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
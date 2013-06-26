package fr.unice.i3s.sigma.examples.library.support

import fr.unice.i3s.sigma.examples.library.Category;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait CategoryScalaSupport extends EMFScalaSupport {
  type Category = fr.unice.i3s.sigma.examples.library.Category
  
  protected implicit val _categoryProxyBuilder = new EMFProxyBuilder[Category](LibraryPackageScalaSupport._libraryBuilder)
  
  object Category {
    def apply(name: String = null): Category = {
      val instance = LibraryPackageScalaSupport._libraryBuilder.create[Category]
      
      if (name != null) instance.setName(name)
      
      instance
    }
  }
  
  implicit class CategoryScalaSupport(that: Category) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
  }
}

object CategoryScalaSupport extends CategoryScalaSupport

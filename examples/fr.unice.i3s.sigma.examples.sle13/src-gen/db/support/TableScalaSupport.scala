package db.support

import db.Column;
import db.Table;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

import org.eclipse.emf.common.util.EList;

trait TableScalaSupport extends EMFScalaSupport {
  type Table = db.Table
  
  protected implicit val _tableProxyBuilder = new EMFProxyBuilder[Table](DBPackageScalaSupport._dbBuilder)
  
  object Table {
    def apply(name: String = null, columns: EList[Column] = null): Table = {
      val instance = DBPackageScalaSupport._dbBuilder.create[Table]
      
      if (name != null) instance.setName(name)
      if (columns != null) instance.getColumns.addAll(columns)
      
      instance
    }
    
    def unapply(that: Table): Option[(String,EList[Column])] =
      Some((that.getName,that.getColumns))
  }
  
  implicit class TableScalaSupport(that: Table) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def columns: EList[Column] = that.getColumns
  }
}

object TableScalaSupport extends TableScalaSupport

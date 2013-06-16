package relational.support

import org.eclipse.emf.common.util.EList;

import relational.Column;
import relational.Table;

trait TableScalaSupport {
  type Table = relational.Table
  
  object Table {
    def apply(name: String = null, columns: EList[Column] = null): Table = {
      val instance = RelationalPackageScalaSupport.builder.create[Table]
      
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

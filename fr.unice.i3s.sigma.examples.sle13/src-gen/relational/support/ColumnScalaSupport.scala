package relational.support

import relational.Column;

trait ColumnScalaSupport {
  type Column = relational.Column
  
  object Column {
    def apply(name: String = null, dataType: String = null): Column = {
      val instance = RelationalPackageScalaSupport.builder.create[Column]
      
      if (name != null) instance.setName(name)
      if (dataType != null) instance.setDataType(dataType)
      
      instance
    }
    
    def unapply(that: Column): Option[(String,String)] =
      Some((that.getName,that.getDataType))
  }
  
  implicit class ColumnScalaSupport(that: Column) {
    def name: String = that.getName
    def name_=(value: String): Unit = that.setName(value)
    def dataType: String = that.getDataType
    def dataType_=(value: String): Unit = that.setDataType(value)
  }
}

object ColumnScalaSupport extends ColumnScalaSupport

package db.support

import db.Column;

import fr.unice.i3s.sigma.support.EMFProxyBuilder;
import fr.unice.i3s.sigma.support.EMFScalaSupport;

trait ColumnScalaSupport extends EMFScalaSupport {
  type Column = db.Column
  
  protected implicit val _columnProxyBuilder = new EMFProxyBuilder[Column](DBPackageScalaSupport._dbBuilder)
  
  object Column {
    def apply(name: String = null, dataType: String = null): Column = {
      val _instance = DBPackageScalaSupport._dbBuilder.create[Column]
      
      if (name != null) _instance.setName(name)
      if (dataType != null) _instance.setDataType(dataType)
      
      _instance
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

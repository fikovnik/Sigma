package fr.unice.i3s.sigma.m2m

trait MetaClass {

  def isTypeOf(clazz: MetaClass): Boolean
  def isTypeOf(elem: AnyRef): Boolean
  def isKindOf(clazz: MetaClass): Boolean
  def isKindOf(elem: AnyRef): Boolean
  def newInstance: AnyRef
  def isAbstract: Boolean
  def name: String
  def contents(elem: AnyRef): Seq[AnyRef]
  
}

trait MetaModel {
  def findMetaClass(clazz: Class[_]): Option[MetaClass]
  def findMetaClass(elem: AnyRef): Option[MetaClass]
  
  def containsClass(clazz: Class[_]): Boolean
  def containsElement(elem: AnyRef): Boolean
}


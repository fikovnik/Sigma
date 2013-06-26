//package fr.unice.i3s.sigma.examples.sle13.sigma
//
//import uml.Class
//import uml.Operation
//
//class Uml2JavaInScala(cls: Class) {
//
//  val sb = new StringBuilder
//
//  def genOperation(o: Operation) {
//    sb.append("\tpublic ").append(o.getReturnType().getName()).append(" " + o.getName() + " {")
//    sb.append("\t\t// TODO: should be implemented")
//    sb.append("\t\tthrow new UnsupportedOperationException(\"").append(o.getName()).append("\");")
//    sb.append("}")
//  }
//
//  def generate = {
//    sb.append("public class " + cls.getName() + " {");
//    var i = 0
//    while (i < cls.getOperations().size()) {
//      genOperation(cls.getOperations().get(i))
//      i += 1
//    }
//    sb.append("}")
//    
//    sb.toString
//  }
//
//}
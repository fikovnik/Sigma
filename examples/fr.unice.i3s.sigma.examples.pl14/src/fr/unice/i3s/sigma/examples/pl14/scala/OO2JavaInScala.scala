package fr.unice.i3s.sigma.examples.pl14.scala

import scala.collection.JavaConversions.asScalaBuffer

import oo.Class
import oo.Operation
import oo.Property

class OO2JavaInScala(cls: Class) {

  val sb = new StringBuilder

  generate

  def genGetter(o: Property) {
    sb.append("\tpublic ").append(o.getType().getName()).append(" get" + o.getName().charAt(0).toUpper).append(o.getName().substring(1)).append(" {\n")
    sb.append("\t\treturn " + o.getName() + ";\n")
    sb.append("\t}\n")
  }
  def genSetter(o: Property) {
    sb.append("\tpublic void").append(" set" + o.getName().substring(0, 1).toUpperCase()).append(o.getName().substring(1)).append("(").append(o.getType().getName() + " " + o.getName()).append(")").append(" {\n")
    sb.append("\t\tthis.").append(o.getName()).append(" = ").append(o.getName()).append(";\n")
    sb.append("\t}\n")
  }
  def genField(o: Property) {
    sb.append("\tprivate ").append(o.getType().getName()).append(" " + o.getName() + ";\n")
  }
  def genOperation(o: Operation) {
    sb.append("\tpublic ").append(o.getReturnType().getName()).append(" " + o.getName() + " {\n")
    sb.append("\t\t// TODO: should be implemented\n")
    sb.append("\t\tthrow new UnsupportedOperationException(\"").append(o.getName()).append("\");\n")
    sb.append("\t}\n")
  }

  def generate = {
    sb.append("public class " + cls.getName() + " {");

    sb.append("\n// fields \n");
    for (p ← cls.getProperties) {
      genField(p)
    }

    sb.append("\n// getters \n");
    for (p ← cls.getProperties) {
      genGetter(p)
    }

    sb.append("\n// setters \n");
    for (p ← cls.getProperties) {
      genSetter(p)
    }

    sb.append("\n// operations \n");
    for (o ← cls.getOperations) {
      genOperation(o)
    }
    sb.append("}")
  }

  override def toString = sb.toString

}
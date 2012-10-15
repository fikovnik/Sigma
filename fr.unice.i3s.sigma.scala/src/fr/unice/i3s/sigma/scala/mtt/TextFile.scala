package fr.unice.i3s.sigma.scala.mtt

object TextFile {
  val endl = System.getProperty("line.separator")
}

class TextFile(val defaultIndent: Int = 2) {
  
  import TextFile._
  
  private[this] val buffer = new StringBuilder
  private[this] var indentLevel = 0
  
  def append(strings: String*) {
    strings.foreach(append(_))
  }
  
  def append(s: String): this.type = {
    buffer append " " * (indentLevel * defaultIndent)
    // TODO: replace all new lines with indent
    buffer append s
    this
  }
  
  def <<(s: String): this.type = append(s)
  
  def <<^(s: String): this.type = append("\""+s+"\"")
  def <<<(s: String): this.type = append(s+endl)
  
  def indent(block: => Any): this.type = {
    indentLevel += 1
    block
    append(endl)
    indentLevel -= 1
    this
  }
  
  override def toString = buffer.toString 
}


/*
 * 
 * file("myfile.scala") {
 *   append("")
 *   indent {
 *     append("")
 *   }
 * }
 * 
 * file("myfile.scala") {
 *   object("MyObject") {
 *     method("doSomething") {
 *       returnType()
 *       parameters()
 *       typeParameters()
 *       body {
 *         append("val x: ", )
 *       } 
 *     }
 *   }	 
 * }
 * 
 * 
 * f = file("myfile.scala")
 * f.package("bla")
 * f.object("bla") {
 *   f.method("blaba") {
 *     f.returnTypes()
 *     f.parameters()
 *     f.typeParameters()
 *     f.body {
 *       f.append("val x:", f.type())
 *       f.indent {
 *         f << ""
 *       }
 *     }
 *   }
 * }
 * 
 * f = new file("myfile.scala") with ScalaLang
 * 
 * f.append() -- <<
 * f.indent()
 * f.endl()
 * 
 * f << "class A "
 * f << "extends X {" << endl
 * f indent {
 *   f << "def a"
 * }
 * 
 * f = new file("") {
 *   "class A", block {
 *     "val x = Array(",
 *     { for (i <- 1 to 5) " "+i },
 *     
 *   },   
 *   "class A", block {
 *     
 *   },
 * 
 * }
 * 
 */
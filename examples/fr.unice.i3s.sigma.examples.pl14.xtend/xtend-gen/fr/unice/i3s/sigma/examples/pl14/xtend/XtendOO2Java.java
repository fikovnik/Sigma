package fr.unice.i3s.sigma.examples.pl14.xtend;

import oo.Operation;
import oo.Property;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class XtendOO2Java {
  public CharSequence genGetter(final Property p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public \ufffd\ufffdp.type.name\ufffd\ufffd get\ufffd\ufffdp.name.toFirstUpper()\ufffd\ufffd() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return \ufffd\ufffdp.name\ufffd\ufffd;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genSetter(final Property p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set\ufffd\ufffdp.name.toFirstUpper()\ufffd\ufffd(\ufffd\ufffdp.type.name\ufffd\ufffd value) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("this.\ufffd\ufffdp.name\ufffd\ufffd = \ufffd\ufffdp.name\ufffd\ufffd;");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genField(final Property p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private \ufffd\ufffdp.type.name\ufffd\ufffd \ufffd\ufffdp.name\ufffd\ufffd;");
    return _builder;
  }
  
  public CharSequence genOperation(final Operation o) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public \ufffd\ufffdo.returnType.name\ufffd\ufffd \ufffd\ufffdo.name\ufffd\ufffd() {");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("// TODO: should be implemented");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("throw new UnsupportedOperationException(\"\ufffd\ufffdo.name\ufffd\ufffd\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate(final oo.Class cls) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class \ufffd\ufffdcls.name\ufffd\ufffd {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// fields");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdFOR p : cls.properties\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdgenField(p)\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdENDFOR\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// getters");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdFOR p : cls.properties\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdgenGetter(p)\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdENDFOR\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// setters");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdFOR p : cls.properties\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdgenSetter(p)\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdENDFOR\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// operations");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdFOR p : cls.operations\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdgenOperation(p)\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("\ufffd\ufffdENDFOR\ufffd\ufffd");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}

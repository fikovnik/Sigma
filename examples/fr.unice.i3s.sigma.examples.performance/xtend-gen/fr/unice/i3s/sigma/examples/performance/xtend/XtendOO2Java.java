package fr.unice.i3s.sigma.examples.performance.xtend;

import oo.Classifier;
import oo.Operation;
import oo.Property;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class XtendOO2Java {
  public CharSequence genGetter(final Property p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    Classifier _type = p.getType();
    String _name = _type.getName();
    _builder.append(_name, "");
    _builder.append(" get");
    String _name_1 = p.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name_1);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _name_2 = p.getName();
    _builder.append(_name_2, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genSetter(final Property p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public void set");
    String _name = p.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("(");
    Classifier _type = p.getType();
    String _name_1 = _type.getName();
    _builder.append(_name_1, "");
    _builder.append(" value) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _name_2 = p.getName();
    _builder.append(_name_2, "\t");
    _builder.append(" = ");
    String _name_3 = p.getName();
    _builder.append(_name_3, "\t");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genField(final Property p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    Classifier _type = p.getType();
    String _name = _type.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = p.getName();
    _builder.append(_name_1, "");
    _builder.append(";");
    return _builder;
  }
  
  public CharSequence genOperation(final Operation o) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    Classifier _returnType = o.getReturnType();
    String _name = _returnType.getName();
    _builder.append(_name, "");
    _builder.append(" ");
    String _name_1 = o.getName();
    _builder.append(_name_1, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("// TODO: should be implemented");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("throw new UnsupportedOperationException(\"");
    String _name_2 = o.getName();
    _builder.append(_name_2, "  ");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate(final oo.Class cls) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _name = cls.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// fields");
    _builder.newLine();
    {
      EList<Property> _properties = cls.getProperties();
      for(final Property p : _properties) {
        _builder.append("\t");
        CharSequence _genField = this.genField(p);
        _builder.append(_genField, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// getters");
    _builder.newLine();
    {
      EList<Property> _properties_1 = cls.getProperties();
      for(final Property p_1 : _properties_1) {
        _builder.append("\t");
        CharSequence _genGetter = this.genGetter(p_1);
        _builder.append(_genGetter, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// setters");
    _builder.newLine();
    {
      EList<Property> _properties_2 = cls.getProperties();
      for(final Property p_2 : _properties_2) {
        _builder.append("\t");
        CharSequence _genSetter = this.genSetter(p_2);
        _builder.append(_genSetter, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// operations");
    _builder.newLine();
    {
      EList<Operation> _operations = cls.getOperations();
      for(final Operation p_3 : _operations) {
        _builder.append("\t");
        CharSequence _genOperation = this.genOperation(p_3);
        _builder.append(_genOperation, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}

package fr.unice.i3s.sigma.examples.pl14.java;

import oo.Class;
import oo.Operation;
import oo.Property;

public class OO2JavaInJava {

	private final Class cls;
	private final StringBuilder sb = new StringBuilder();

	public OO2JavaInJava(Class cls) {
		this.cls = cls;
		generate();
	}

	public void genGetter(Property o) {
	    sb.append("\tpublic ").append(o.getType().getName()).append(" get" + o.getName().substring(0,1).toUpperCase()).append(o.getName().substring(1)).append(" {\n");
	    sb.append("\t\treturn "+o.getName()+";\n");
	    sb.append("\t}\n");
	}

	public void genSetter(Property o) {
		  sb.append("\tpublic void").append(" set" + o.getName().substring(0,1).toUpperCase()).append(o.getName().substring(1)).append("(").append(o.getType().getName()+" "+o.getName()).append(")").append(" {\n");
		  sb.append("\t\tthis.").append(o.getName()).append(" = ").append(o.getName()).append(";\n");
		  sb.append("\t}\n");
	}

	public void genField(Property o) {
		sb.append("\tprivate ").append(o.getType().getName()).append(" " + o.getName() + ";\n");
	}

	
	public void genOperation(Operation o) {
		sb.append("\tpublic ").append(o.getReturnType().getName()).append(" "+o.getName()+" {\n");
		sb.append("\t\t// TODO: should be implemented\n");
		sb.append("\t\tthrow new UnsupportedOperationException(\"").append(o.getName()).append("\");\n");
		sb.append("\t}\n");
	}
	
	public void generate() {				
		sb.append("public class "+cls.getName()+" {");
	    sb.append("\n// fields \n");
	    for (Property o: cls.getProperties()) {
	      genField(o);
	    }
	    sb.append("\n// getters \n");
	    for (Property o: cls.getProperties()) {
	    	genGetter(o);
	    }
	    sb.append("\n// setters \n");
	    for (Property o: cls.getProperties()) {
	    	genSetter(o);
	    }
	    sb.append("\n// operations \n");		
	    for (Operation o: cls.getOperations()) {
			genOperation(o);
		}
		sb.append("}");		
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
	
}

package fr.unice.i3s.sigma.examples.sle13.java;

import oo.Class;
import oo.Operation;

public class OO2JavaInJava {

	private final Class cls;
	private final StringBuilder sb = new StringBuilder();

	public OO2JavaInJava(Class cls) {
		this.cls = cls;
	}
	
	public void genOperation(Operation o) {
		sb.append("\tpublic ").append(o.getReturnType().getName()).append(" "+o.getName()+" {");
		sb.append("\t\t// TODO: should be implemented");
		sb.append("\t\tthrow new UnsupportedOperationException(\"").append(o.getName()).append("\");");
		sb.append("}");
	}
	
	public String generate() {				
		sb.append("public class "+cls.getName()+" {");
		for (Operation o: cls.getOperations()) {
			genOperation(o);
		}
		sb.append("}");
		
		return sb.toString();		
	}
	
}

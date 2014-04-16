package fr.unice.i3s.sigma.examples.performance.benchmark;

import oo.Class;
import oo.OOFactory;
import oo.Operation;
import oo.Package;
import oo.PrimitiveType;
import oo.Property;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class OO2JavaModelGenerator implements ResourceGenerator {

	private final int classes;
	private final int methods;
	private final int properties;

	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
	}

	public OO2JavaModelGenerator() {
//		this(500, 100, 100);
		this(250, 1000, 1000);
	}

	public OO2JavaModelGenerator(int classes, int methods, int properties) {
		this.classes = classes;
		this.methods = methods;
		this.properties = properties;
	}

	@Override
	public Resource generate() throws Exception {
		ResourceSetImpl resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI
				.createFileURI("sample-set"));
		OOFactory factory = OOFactory.eINSTANCE;

		Package pkg = factory.createPackage();
		resource.getContents().add(pkg);

		PrimitiveType intPT = factory.createPrimitiveType();
		intPT.setName("int");
		pkg.getOwnedElements().add(intPT);

		for (int i = 0; i < classes; i++) {
			Class cls = factory.createClass();
			cls.setName("A" + i);
			pkg.getOwnedElements().add(cls);

			for (int j = 0; j < methods; j++) {
				Operation op = factory.createOperation();
				op.setName("op" + j);
				op.setReturnType(intPT);
				cls.getFeatures().add(op);
			}
			
			for (int j = 0; j < properties; j++) {
				Property p = factory.createProperty();
				p.setName("prop" + j);
				p.setType(intPT);
				p.setMulti(false);
				cls.getFeatures().add(p);
			}
		}


		return resource;
	}

	@Override
	public String toString() {
		return "OO-model-"+classes+"-"+methods+"-"+properties;
	}
	
}

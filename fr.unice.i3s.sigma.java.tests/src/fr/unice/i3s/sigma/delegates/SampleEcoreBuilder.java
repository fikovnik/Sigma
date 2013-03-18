package fr.unice.i3s.sigma.delegates;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;

public class SampleEcoreBuilder {

	private static EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;

	public static <T> Map<T, T> hashMap(T... args) {
		assert (args.length & 1) == 0;
		HashMap<T, T> map = new HashMap<T, T>(args.length / 2);

		for (int i = 0; i < args.length; i++) {
			map.put(args[i], args[i + 1]);
			i++;
		}

		return map;
	}

	public static void createEAnnotation(EModelElement parent,
			String sourceURI, Map<String, String> details) {
		EAnnotation e = ecoreFactory.createEAnnotation();
		parent.getEAnnotations().add(e);
		e.setSource(sourceURI);
		for (Entry<String, String> d : details.entrySet()) {
			e.getDetails().put(d.getKey(), d.getValue());
		}
	}

	public static EClass createsEClass(EPackage parent, String name) {
		EClass e = ecoreFactory.createEClass();
		parent.getEClassifiers().add(e);
		e.setName(name);
		return e;
	}

	public static EOperation createEOperation(EClass parent, String name) {
		EOperation e = ecoreFactory.createEOperation();
		parent.getEOperations().add(e);
		e.setName(name);
		return e;
	}

	public static EPackage createEPackge(String name) {
		return createEPackge(null, name);
	}

	public static EPackage createEPackge(EPackage parent, String name) {
		EPackage e = ecoreFactory.createEPackage();
		e.setName(name);
		if (parent != null) {
			parent.getESubpackages().add(e);
		}
		return e;
	}

}
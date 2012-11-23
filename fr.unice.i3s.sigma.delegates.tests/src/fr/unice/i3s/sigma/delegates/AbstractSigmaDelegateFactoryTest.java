package fr.unice.i3s.sigma.delegates;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Test;

import fr.unice.i3s.sigma.delegates.AbstractSigmaDelegateFactory;
import fr.unice.i3s.sigma.delegates.AbstractSigmaDelegateFactory.DelegateMethod;
import fr.unice.i3s.sigma.delegates.SigmaDelegateDomain;

public class AbstractSigmaDelegateFactoryTest {

	SigmaDelegateDomain domain = SigmaDelegateDomain.getDefaultInstance();

	AbstractSigmaDelegateFactory factory = new AbstractSigmaDelegateFactory(
			domain) {
		// nothing
	};

	@Test
	public void testClassDelegateHasPriority() throws Exception {
		EPackage pkg = createEPackge("package1");
		createEAnnotation(
				pkg,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"pkgDelegate"));

		EClass clazz = createsEClass(pkg, "clazz1");
		createEAnnotation(
				clazz,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"classDelegate"));

		assertEquals("classDelegate", factory.getClassifierDelegateName(clazz));
	}

	@Test
	public void testPackageDelegateResolution() throws Exception {
		EPackage pkg = createEPackge("package1");
		createEAnnotation(
				pkg,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"pkgDelegate"));

		EClass clazz = createsEClass(pkg, "clazz1");

		assertEquals("pkgDelegate.clazz1Delegate",
				factory.getClassifierDelegateName(clazz));
	}

	@Test
	public void testNoDelegateAnnotation() throws Exception {
		EPackage pkg = createEPackge("package1");
		EClass clazz = createsEClass(pkg, "clazz1");

		assertEquals(null, factory.getClassifierDelegateName(clazz));
	}

	@Test
	public void testPackageHierarchyDelegateResolution() throws Exception {
		EPackage pkg1 = createEPackge("package1");
		createEAnnotation(
				pkg1,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"pkgDelegate1"));

		EPackage pkg2 = createEPackge(pkg1, "package2");
		createEAnnotation(
				pkg2,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"pkgDelegate2"));

		EPackage pkg3 = createEPackge(pkg2, "package3");

		EClass clazz = createsEClass(pkg3, "clazz1");

		assertEquals("pkgDelegate2.package3.clazz1Delegate",
				factory.getClassifierDelegateName(clazz));
	}

	@Test
	public void testParseDelegationOverride() throws Exception {
		EPackage pkg = createEPackge("package1");
		EClass clazz = createsEClass(pkg, "clazz1");
		createEAnnotation(clazz, domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY, "clazz1"));

		DelegateMethod dm = null;

		dm = factory.parseDelegateOverride("pkg.clazz.method", clazz);
		assertEquals("pkg.clazz", dm.className);
		assertEquals("method", dm.methodName);

		dm = factory.parseDelegateOverride("clazz.method", clazz);
		assertEquals("clazz", dm.className);
		assertEquals("method", dm.methodName);

		dm = factory.parseDelegateOverride("method", clazz);
		assertEquals("clazz1", dm.className);
		assertEquals("method", dm.methodName);

		try {
			dm = factory.parseDelegateOverride(null, clazz);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			dm = factory.parseDelegateOverride("", clazz);
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = factory.parseDelegateOverride("    	", clazz);
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = factory.parseDelegateOverride(".", clazz);
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = factory.parseDelegateOverride("clazz.", clazz);
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = factory.parseDelegateOverride(".method", clazz);
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = factory.parseDelegateOverride(".method.", clazz);
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = factory.parseDelegateOverride("..", clazz);
			fail();
		} catch (ParseException e) {
		}
	}

	private static EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;

	private static <T> Map<T, T> hashMap(T... args) {
		assert (args.length & 1) == 0;
		HashMap<T, T> map = new HashMap<T, T>(args.length / 2);

		for (int i = 0; i < args.length; i++) {
			map.put(args[i], args[i + 1]);
			i++;
		}

		return map;
	}

	private void createEAnnotation(EModelElement parent, String sourceURI,
			Map<String, String> details) {
		EAnnotation e = ecoreFactory.createEAnnotation();
		parent.getEAnnotations().add(e);
		e.setSource(sourceURI);
		for (Entry<String, String> d : details.entrySet()) {
			e.getDetails().put(d.getKey(), d.getValue());
		}
	}

	private static EClass createsEClass(EPackage parent, String name) {
		EClass e = ecoreFactory.createEClass();
		parent.getEClassifiers().add(e);
		e.setName(name);
		return e;
	}

	private static EPackage createEPackge(String name) {
		return createEPackge(null, name);
	}

	private static EPackage createEPackge(EPackage parent, String name) {
		EPackage e = ecoreFactory.createEPackage();
		e.setName(name);
		if (parent != null) {
			parent.getESubpackages().add(e);
		}
		return e;
	}

}

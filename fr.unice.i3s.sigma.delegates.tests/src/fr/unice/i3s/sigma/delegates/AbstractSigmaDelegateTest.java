package fr.unice.i3s.sigma.delegates;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.Test;

import static fr.unice.i3s.sigma.delegates.SampleEcoreBuilder.*;

public class AbstractSigmaDelegateTest {

	SigmaDelegateDomain domain = SigmaDelegateDomain.getDefaultInstance();

	class TestDelegate<T extends ENamedElement> extends
			AbstractSigmaDelegate<T> {

		public TestDelegate(T target) {
			super(target, SigmaDelegateDomain.getDefaultInstance());
		}

		@Override
		public String getMethodSignature() {
			return null;
		}

		@Override
		public String getExpectedMethodName() {
			return null;
		}

		@Override
		public String getName() {
			return null;
		}

		@Override
		protected boolean checkDelegateMethod(Method input) {
			return false;
		}

		@Override
		protected EClassifier getContainingEClass() {
			return null;
		}
	}

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

		EOperation op = createEOperation(clazz, "op");

		TestDelegate<EOperation> delegate = spy(new TestDelegate<EOperation>(op));
		when(delegate.getContainingEClass()).thenReturn(clazz);

		assertEquals("classDelegate", delegate.getMethodClassName());
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

		EOperation op = createEOperation(clazz, "op");

		TestDelegate<EOperation> delegate = spy(new TestDelegate<EOperation>(op));
		when(delegate.getContainingEClass()).thenReturn(clazz);

		assertEquals("pkgDelegate.clazz1Delegate",
				delegate.getMethodClassName());
	}

	@Test
	public void testNoDelegateAnnotation() throws Exception {
		EPackage pkg = createEPackge("package1");
		EClass clazz = createsEClass(pkg, "clazz1");
		EOperation op = createEOperation(clazz, "op");

		TestDelegate<EOperation> delegate = spy(new TestDelegate<EOperation>(op));
		when(delegate.getContainingEClass()).thenReturn(clazz);

		assertEquals(
				pkg.getName() + "." + delegate.getExpectedClassDelegateName(),
				delegate.getMethodClassName());
		assertEquals(delegate.getExpectedMethodName(), delegate.getMethodName());
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

		EOperation op = createEOperation(clazz, "op");

		TestDelegate<EOperation> delegate = spy(new TestDelegate<EOperation>(op));
		when(delegate.getContainingEClass()).thenReturn(clazz);

		assertEquals("pkgDelegate2.package3.clazz1Delegate",
				delegate.getMethodClassName());
	}

	@Test
	public void testDelegateOverrideResolution() throws Exception {
		EPackage pkg = createEPackge("package1");
		createEAnnotation(
				pkg,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"pkgDelegate1"));

		EClass clazz = createsEClass(pkg, "clazz1");
		createEAnnotation(
				clazz,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"clazz1Delegate"));

		EOperation op = createEOperation(clazz, "op");
		createEAnnotation(
				op,
				domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY,
						"myDelegate.delegate"));

		TestDelegate<EOperation> delegate = spy(new TestDelegate<EOperation>(op));
		when(delegate.getContainingEClass()).thenReturn(clazz);

		assertEquals("myDelegate", delegate.getMethodClassName());
		assertEquals("delegate", delegate.getMethodName());
	}

	@Test
	public void testParseDelegationOverride() throws Exception {
		EPackage pkg = createEPackge("package1");
		EClass clazz = createsEClass(pkg, "clazz1");
		createEAnnotation(clazz, domain.getURI(),
				hashMap(SigmaDelegateDomain.DELEGATE_CONSTRAINT_KEY, "clazz1"));

		EOperation op = createEOperation(clazz, "op");

		TestDelegate<EOperation> delegate = spy(new TestDelegate<EOperation>(op));
		when(delegate.getContainingEClass()).thenReturn(clazz);

		String[] dm = null;

		dm = delegate.parseDelegateOverride("pkg.clazz.method");
		assertEquals("pkg.clazz", dm[0]);
		assertEquals("method", dm[1]);

		dm = delegate.parseDelegateOverride("clazz.method");
		assertEquals("clazz", dm[0]);
		assertEquals("method", dm[1]);

		dm = delegate.parseDelegateOverride("method");
		assertEquals("clazz1", dm[0]);
		assertEquals("method", dm[1]);

		try {
			dm = delegate.parseDelegateOverride(null);
			fail();
		} catch (IllegalArgumentException e) {
		}
		try {
			dm = delegate.parseDelegateOverride("");
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = delegate.parseDelegateOverride("    	");
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = delegate.parseDelegateOverride(".");
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = delegate.parseDelegateOverride("clazz.");
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = delegate.parseDelegateOverride(".method");
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = delegate.parseDelegateOverride(".method.");
			fail();
		} catch (ParseException e) {
		}
		try {
			dm = delegate.parseDelegateOverride("..");
			fail();
		} catch (ParseException e) {
		}
	}

}

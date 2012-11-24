/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testmodel.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import testmodel.TestClass;
import testmodel.TestOverriding;
import testmodel.TmFactory;
import testmodel.TmPackage;

import testmodel.util.TmValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TmPackageImpl extends EPackageImpl implements TmPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testOverridingEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see testmodel.TmPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TmPackageImpl() {
		super(eNS_URI, TmFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TmPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TmPackage init() {
		if (isInited) return (TmPackage)EPackage.Registry.INSTANCE.getEPackage(TmPackage.eNS_URI);

		// Obtain or create and register package
		TmPackageImpl theTmPackage = (TmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TmPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theTmPackage.createPackageContents();

		// Initialize created meta-data
		theTmPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theTmPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return TmValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theTmPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TmPackage.eNS_URI, theTmPackage);
		return theTmPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestClass() {
		return testClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestClass_Attribute() {
		return (EAttribute)testClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestClass_DerivedAttribute() {
		return (EAttribute)testClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTestClass__Method() {
		return testClassEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTestClass__MethodWithArgs__String_int() {
		return testClassEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTestOverriding() {
		return testOverridingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestOverriding_Attribute() {
		return (EAttribute)testOverridingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTestOverriding_NormalAttribute() {
		return (EAttribute)testOverridingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTestOverriding__Method() {
		return testOverridingEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getTestOverriding__NormalMethod() {
		return testOverridingEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmFactory getTmFactory() {
		return (TmFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		testClassEClass = createEClass(TEST_CLASS);
		createEAttribute(testClassEClass, TEST_CLASS__ATTRIBUTE);
		createEAttribute(testClassEClass, TEST_CLASS__DERIVED_ATTRIBUTE);
		createEOperation(testClassEClass, TEST_CLASS___METHOD);
		createEOperation(testClassEClass, TEST_CLASS___METHOD_WITH_ARGS__STRING_INT);

		testOverridingEClass = createEClass(TEST_OVERRIDING);
		createEAttribute(testOverridingEClass, TEST_OVERRIDING__ATTRIBUTE);
		createEAttribute(testOverridingEClass, TEST_OVERRIDING__NORMAL_ATTRIBUTE);
		createEOperation(testOverridingEClass, TEST_OVERRIDING___METHOD);
		createEOperation(testOverridingEClass, TEST_OVERRIDING___NORMAL_METHOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(testClassEClass, TestClass.class, "TestClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestClass_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, TestClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTestClass_DerivedAttribute(), ecorePackage.getEString(), "derivedAttribute", null, 1, 1, TestClass.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEOperation(getTestClass__Method(), ecorePackage.getEString(), "method", 1, 1, IS_UNIQUE, IS_ORDERED);

		EOperation op = initEOperation(getTestClass__MethodWithArgs__String_int(), ecorePackage.getEString(), "methodWithArgs", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "str", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "number", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(testOverridingEClass, TestOverriding.class, "TestOverriding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestOverriding_Attribute(), ecorePackage.getEString(), "attribute", null, 1, 1, TestOverriding.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTestOverriding_NormalAttribute(), ecorePackage.getEString(), "normalAttribute", null, 1, 1, TestOverriding.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEOperation(getTestOverriding__Method(), ecorePackage.getEString(), "method", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEOperation(getTestOverriding__NormalMethod(), ecorePackage.getEString(), "normalMethod", 1, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.i3s.unice.fr/Sigma
		createSigmaAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "invocationDelegates", "http://www.i3s.unice.fr/Sigma",
			 "settingDelegates", "http://www.i3s.unice.fr/Sigma",
			 "validationDelegates", "http://www.i3s.unice.fr/Sigma"
		   });				
		addAnnotation
		  (testClassEClass, 
		   source, 
		   new String[] {
			 "constraints", "A B C D E F"
		   });						
		addAnnotation
		  (testOverridingEClass, 
		   source, 
		   new String[] {
			 "constraints", "constraint normalConstraint"
		   });				
	}

	/**
	 * Initializes the annotations for <b>http://www.i3s.unice.fr/Sigma</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createSigmaAnnotations() {
		String source = "http://www.i3s.unice.fr/Sigma";			
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "delegate", "testmodel.delegates"
		   });		
		addAnnotation
		  (testClassEClass, 
		   source, 
		   new String[] {
			 "A", "",
			 "B", "",
			 "C", "",
			 "D", "",
			 "E", "",
			 "F", ""
		   });			
		addAnnotation
		  (getTestClass__Method(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getTestClass__MethodWithArgs__String_int(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getTestClass_DerivedAttribute(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (testOverridingEClass, 
		   source, 
		   new String[] {
			 "delegate", "testmodel.delegates.OverrideClassDelegate",
			 "constraint", "testmodel.delegates.OverrideConstraintDelegate.checkA",
			 "normalConstraint", ""
		   });			
		addAnnotation
		  (getTestOverriding__Method(), 
		   source, 
		   new String[] {
			 "delegate", "testmodel.delegates.OverrideMethodDelegate.method"
		   });		
		addAnnotation
		  (getTestOverriding__NormalMethod(), 
		   source, 
		   new String[] {
		   });		
		addAnnotation
		  (getTestOverriding_Attribute(), 
		   source, 
		   new String[] {
			 "delegate", "testmodel.delegates.OverridePropertyDelegate.attribute"
		   });		
		addAnnotation
		  (getTestOverriding_NormalAttribute(), 
		   source, 
		   new String[] {
		   });
	}

} //TmPackageImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testmodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see testmodel.TmFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.i3s.unice.fr/Sigma' settingDelegates='http://www.i3s.unice.fr/Sigma' validationDelegates='http://www.i3s.unice.fr/Sigma'"
 * @generated
 */
public interface TmPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "testmodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.i3s.unice.fr/Sigma/TestModel";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "testmodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TmPackage eINSTANCE = testmodel.impl.TmPackageImpl.init();

	/**
	 * The meta object id for the '{@link testmodel.impl.TestClassImpl <em>Test Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see testmodel.impl.TestClassImpl
	 * @see testmodel.impl.TmPackageImpl#getTestClass()
	 * @generated
	 */
	int TEST_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS__ATTRIBUTE = 0;

	/**
	 * The feature id for the '<em><b>Derived Attribute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS__DERIVED_ATTRIBUTE = 1;

	/**
	 * The number of structural features of the '<em>Test Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Method</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS___METHOD = 0;

	/**
	 * The number of operations of the '<em>Test Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CLASS_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link testmodel.TestClass <em>Test Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Class</em>'.
	 * @see testmodel.TestClass
	 * @generated
	 */
	EClass getTestClass();

	/**
	 * Returns the meta object for the attribute '{@link testmodel.TestClass#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute</em>'.
	 * @see testmodel.TestClass#getAttribute()
	 * @see #getTestClass()
	 * @generated
	 */
	EAttribute getTestClass_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link testmodel.TestClass#getDerivedAttribute <em>Derived Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derived Attribute</em>'.
	 * @see testmodel.TestClass#getDerivedAttribute()
	 * @see #getTestClass()
	 * @generated
	 */
	EAttribute getTestClass_DerivedAttribute();

	/**
	 * Returns the meta object for the '{@link testmodel.TestClass#method() <em>Method</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Method</em>' operation.
	 * @see testmodel.TestClass#method()
	 * @generated
	 */
	EOperation getTestClass__Method();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TmFactory getTmFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link testmodel.impl.TestClassImpl <em>Test Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see testmodel.impl.TestClassImpl
		 * @see testmodel.impl.TmPackageImpl#getTestClass()
		 * @generated
		 */
		EClass TEST_CLASS = eINSTANCE.getTestClass();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CLASS__ATTRIBUTE = eINSTANCE.getTestClass_Attribute();

		/**
		 * The meta object literal for the '<em><b>Derived Attribute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CLASS__DERIVED_ATTRIBUTE = eINSTANCE.getTestClass_DerivedAttribute();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEST_CLASS___METHOD = eINSTANCE.getTestClass__Method();

	}

} //TmPackage

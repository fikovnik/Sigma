/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package testmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see testmodel.TmPackage
 * @generated
 */
public interface TmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TmFactory eINSTANCE = testmodel.impl.TmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Class</em>'.
	 * @generated
	 */
	TestClass createTestClass();

	/**
	 * Returns a new object of class '<em>Test Overriding</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Overriding</em>'.
	 * @generated
	 */
	TestOverriding createTestOverriding();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TmPackage getTmPackage();

} //TmFactory

/**
 */
package testmodel.impl;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import testmodel.TestOverriding;
import testmodel.TmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Overriding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link testmodel.impl.TestOverridingImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link testmodel.impl.TestOverridingImpl#getNormalAttribute <em>Normal Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TestOverridingImpl extends EObjectImpl implements TestOverriding {
	/**
	 * The cached setting delegate for the '{@link #getAttribute() <em>Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate ATTRIBUTE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)TmPackage.Literals.TEST_OVERRIDING__ATTRIBUTE).getSettingDelegate();

	/**
	 * The cached setting delegate for the '{@link #getNormalAttribute() <em>Normal Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNormalAttribute()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature.Internal.SettingDelegate NORMAL_ATTRIBUTE__ESETTING_DELEGATE = ((EStructuralFeature.Internal)TmPackage.Literals.TEST_OVERRIDING__NORMAL_ATTRIBUTE).getSettingDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestOverridingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TmPackage.Literals.TEST_OVERRIDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute() {
		return (String)ATTRIBUTE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNormalAttribute() {
		return (String)NORMAL_ATTRIBUTE__ESETTING_DELEGATE.dynamicGet(this, null, 0, true, false);
	}

	/**
	 * The cached invocation delegate for the '{@link #method() <em>Method</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #method()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate METHOD__EINVOCATION_DELEGATE = ((EOperation.Internal)TmPackage.Literals.TEST_OVERRIDING___METHOD).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String method() {
		try {
			return (String)METHOD__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * The cached invocation delegate for the '{@link #normalMethod() <em>Normal Method</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #normalMethod()
	 * @generated
	 * @ordered
	 */
	protected static final EOperation.Internal.InvocationDelegate NORMAL_METHOD__EINVOCATION_DELEGATE = ((EOperation.Internal)TmPackage.Literals.TEST_OVERRIDING___NORMAL_METHOD).getInvocationDelegate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String normalMethod() {
		try {
			return (String)NORMAL_METHOD__EINVOCATION_DELEGATE.dynamicInvoke(this, null);
		}
		catch (InvocationTargetException ite) {
			throw new WrappedException(ite);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TmPackage.TEST_OVERRIDING__ATTRIBUTE:
				return getAttribute();
			case TmPackage.TEST_OVERRIDING__NORMAL_ATTRIBUTE:
				return getNormalAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TmPackage.TEST_OVERRIDING__ATTRIBUTE:
				return ATTRIBUTE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
			case TmPackage.TEST_OVERRIDING__NORMAL_ATTRIBUTE:
				return NORMAL_ATTRIBUTE__ESETTING_DELEGATE.dynamicIsSet(this, null, 0);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case TmPackage.TEST_OVERRIDING___METHOD:
				return method();
			case TmPackage.TEST_OVERRIDING___NORMAL_METHOD:
				return normalMethod();
		}
		return super.eInvoke(operationID, arguments);
	}

} //TestOverridingImpl

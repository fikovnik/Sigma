/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package my.impl;

import java.util.Collection;

import my.Class1;
import my.MyPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class1</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link my.impl.Class1Impl#getAttribute1 <em>Attribute1</em>}</li>
 *   <li>{@link my.impl.Class1Impl#isAttributeNoSet1 <em>Attribute No Set1</em>}</li>
 *   <li>{@link my.impl.Class1Impl#getReferenceNoSet1 <em>Reference No Set1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class Class1Impl extends EObjectImpl implements Class1 {
	/**
	 * The default value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE1_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttribute1() <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute1()
	 * @generated
	 * @ordered
	 */
	protected String attribute1 = ATTRIBUTE1_EDEFAULT;

	/**
	 * The default value of the '{@link #isAttributeNoSet1() <em>Attribute No Set1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttributeNoSet1()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ATTRIBUTE_NO_SET1_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAttributeNoSet1() <em>Attribute No Set1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAttributeNoSet1()
	 * @generated
	 * @ordered
	 */
	protected boolean attributeNoSet1 = ATTRIBUTE_NO_SET1_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReferenceNoSet1() <em>Reference No Set1</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferenceNoSet1()
	 * @generated
	 * @ordered
	 */
	protected EList<Class1> referenceNoSet1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Class1Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MyPackage.Literals.CLASS1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttribute1() {
		return attribute1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttribute1(String newAttribute1) {
		String oldAttribute1 = attribute1;
		attribute1 = newAttribute1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyPackage.CLASS1__ATTRIBUTE1, oldAttribute1, attribute1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAttributeNoSet1() {
		return attributeNoSet1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeNoSet1(boolean newAttributeNoSet1) {
		boolean oldAttributeNoSet1 = attributeNoSet1;
		attributeNoSet1 = newAttributeNoSet1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MyPackage.CLASS1__ATTRIBUTE_NO_SET1, oldAttributeNoSet1, attributeNoSet1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Class1> getReferenceNoSet1() {
		if (referenceNoSet1 == null) {
			referenceNoSet1 = new EObjectResolvingEList<Class1>(Class1.class, this, MyPackage.CLASS1__REFERENCE_NO_SET1);
		}
		return referenceNoSet1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MyPackage.CLASS1__ATTRIBUTE1:
				return getAttribute1();
			case MyPackage.CLASS1__ATTRIBUTE_NO_SET1:
				return isAttributeNoSet1();
			case MyPackage.CLASS1__REFERENCE_NO_SET1:
				return getReferenceNoSet1();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MyPackage.CLASS1__ATTRIBUTE1:
				setAttribute1((String)newValue);
				return;
			case MyPackage.CLASS1__ATTRIBUTE_NO_SET1:
				setAttributeNoSet1((Boolean)newValue);
				return;
			case MyPackage.CLASS1__REFERENCE_NO_SET1:
				getReferenceNoSet1().clear();
				getReferenceNoSet1().addAll((Collection<? extends Class1>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MyPackage.CLASS1__ATTRIBUTE1:
				setAttribute1(ATTRIBUTE1_EDEFAULT);
				return;
			case MyPackage.CLASS1__ATTRIBUTE_NO_SET1:
				setAttributeNoSet1(ATTRIBUTE_NO_SET1_EDEFAULT);
				return;
			case MyPackage.CLASS1__REFERENCE_NO_SET1:
				getReferenceNoSet1().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MyPackage.CLASS1__ATTRIBUTE1:
				return ATTRIBUTE1_EDEFAULT == null ? attribute1 != null : !ATTRIBUTE1_EDEFAULT.equals(attribute1);
			case MyPackage.CLASS1__ATTRIBUTE_NO_SET1:
				return attributeNoSet1 != ATTRIBUTE_NO_SET1_EDEFAULT;
			case MyPackage.CLASS1__REFERENCE_NO_SET1:
				return referenceNoSet1 != null && !referenceNoSet1.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (attribute1: ");
		result.append(attribute1);
		result.append(", attributeNoSet1: ");
		result.append(attributeNoSet1);
		result.append(')');
		return result.toString();
	}

// Following are the Scala compatible delegates

  /**
   * Scala compatible getter method for {@code attribute1} property,
   * delegating to {@code getAttribute1()}
   *
   * @return the value of the '<em>Attribute1</em>' attribute.
   * @see #getAttribute1
   * @generated
   */
  public String attribute1() {
      return getAttribute1();
  }   

  /**
   * Scala compatible getter method for {@code attributeNoSet1} property,
   * delegating to {@code isAttributeNoSet1()}
   *
   * @return the value of the '<em>Attribute No Set1</em>' attribute.
   * @see #isAttributeNoSet1
   * @generated
   */
  public boolean attributeNoSet1() {
      return isAttributeNoSet1();
  }   

  /**
   * Scala compatible getter method for {@code referenceNoSet1} property,
   * delegating to {@code getReferenceNoSet1()}
   *
   * @return the value of the '<em>Reference No Set1</em>' reference list.
   * @see #getReferenceNoSet1
   * @generated
   */
  public EList<Class1> referenceNoSet1() {
      return getReferenceNoSet1();
  }   
} //Class1Impl

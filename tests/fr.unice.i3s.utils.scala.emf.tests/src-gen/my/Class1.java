/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package my;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link my.Class1#getAttribute1 <em>Attribute1</em>}</li>
 *   <li>{@link my.Class1#isAttributeNoSet1 <em>Attribute No Set1</em>}</li>
 *   <li>{@link my.Class1#getReferenceNoSet1 <em>Reference No Set1</em>}</li>
 * </ul>
 * </p>
 *
 * @see my.MyPackage#getClass1()
 * @model
 * @generated
 */
public interface Class1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Attribute1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute1</em>' attribute.
	 * @see #setAttribute1(String)
	 * @see my.MyPackage#getClass1_Attribute1()
	 * @model required="true"
	 * @generated
	 */
	String getAttribute1();

	/**
	 * Sets the value of the '{@link my.Class1#getAttribute1 <em>Attribute1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute1</em>' attribute.
	 * @see #getAttribute1()
	 * @generated
	 */
	void setAttribute1(String value);

	/**
	 * Returns the value of the '<em><b>Attribute No Set1</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute No Set1</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute No Set1</em>' attribute.
	 * @see #setAttributeNoSet1(boolean)
	 * @see my.MyPackage#getClass1_AttributeNoSet1()
	 * @model required="true" derived="true"
	 * @generated
	 */
	boolean isAttributeNoSet1();

	/**
	 * Sets the value of the '{@link my.Class1#isAttributeNoSet1 <em>Attribute No Set1</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute No Set1</em>' attribute.
	 * @see #isAttributeNoSet1()
	 * @generated
	 */
	void setAttributeNoSet1(boolean value);

	/**
	 * Returns the value of the '<em><b>Reference No Set1</b></em>' reference list.
	 * The list contents are of type {@link my.Class1}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference No Set1</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference No Set1</em>' reference list.
	 * @see my.MyPackage#getClass1_ReferenceNoSet1()
	 * @model
	 * @generated
	 */
	EList<Class1> getReferenceNoSet1();

// Following are the Scala compatible delegates

  /**
   * Scala compatible getter method for {@code attribute1} property,
   * delegating to {@code getAttribute1()}
   *
   * @return the value of the '<em>Attribute1</em>' attribute.
   * @see #getAttribute1
   * @generated
   */
  String attribute1(); 

  /**
   * Scala compatible getter method for {@code attributeNoSet1} property,
   * delegating to {@code isAttributeNoSet1()}
   *
   * @return the value of the '<em>Attribute No Set1</em>' attribute.
   * @see #isAttributeNoSet1
   * @generated
   */
  boolean attributeNoSet1(); 

  /**
   * Scala compatible getter method for {@code referenceNoSet1} property,
   * delegating to {@code getReferenceNoSet1()}
   *
   * @return the value of the '<em>Reference No Set1</em>' reference list.
   * @see #getReferenceNoSet1
   * @generated
   */
  EList<Class1> referenceNoSet1(); 
} // Class1

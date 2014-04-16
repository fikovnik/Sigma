/**
 */
package EER;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.SingleAttribute#isDerivate <em>Derivate</em>}</li>
 *   <li>{@link EER.SingleAttribute#getDomain <em>Domain</em>}</li>
 *   <li>{@link EER.SingleAttribute#getMultiplicity <em>Multiplicity</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getSingleAttribute()
 * @model
 * @generated
 */
public interface SingleAttribute extends Attribute
{
	/**
	 * Returns the value of the '<em><b>Derivate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derivate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derivate</em>' attribute.
	 * @see #setDerivate(boolean)
	 * @see EER.EERPackage#getSingleAttribute_Derivate()
	 * @model required="true"
	 * @generated
	 */
	boolean isDerivate();

	/**
	 * Sets the value of the '{@link EER.SingleAttribute#isDerivate <em>Derivate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Derivate</em>' attribute.
	 * @see #isDerivate()
	 * @generated
	 */
	void setDerivate(boolean value);

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference.
	 * @see #setDomain(Domain)
	 * @see EER.EERPackage#getSingleAttribute_Domain()
	 * @model required="true"
	 * @generated
	 */
	Domain getDomain();

	/**
	 * Sets the value of the '{@link EER.SingleAttribute#getDomain <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain</em>' reference.
	 * @see #getDomain()
	 * @generated
	 */
	void setDomain(Domain value);

	/**
	 * Returns the value of the '<em><b>Multiplicity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiplicity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiplicity</em>' attribute.
	 * @see #setMultiplicity(int)
	 * @see EER.EERPackage#getSingleAttribute_Multiplicity()
	 * @model default="1" required="true"
	 * @generated
	 */
	int getMultiplicity();

	/**
	 * Sets the value of the '{@link EER.SingleAttribute#getMultiplicity <em>Multiplicity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiplicity</em>' attribute.
	 * @see #getMultiplicity()
	 * @generated
	 */
	void setMultiplicity(int value);

} // SingleAttribute

/**
 */
package EER;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.DependencyRelationship#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getDependencyRelationship()
 * @model
 * @generated
 */
public interface DependencyRelationship extends AbstractRelationship
{
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link EER.DependencyType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see EER.DependencyType
	 * @see #setType(DependencyType)
	 * @see EER.EERPackage#getDependencyRelationship_Type()
	 * @model required="true"
	 * @generated
	 */
	DependencyType getType();

	/**
	 * Sets the value of the '{@link EER.DependencyRelationship#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see EER.DependencyType
	 * @see #getType()
	 * @generated
	 */
	void setType(DependencyType value);

} // DependencyRelationship

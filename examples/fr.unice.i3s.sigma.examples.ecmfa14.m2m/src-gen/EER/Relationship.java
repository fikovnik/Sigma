/**
 */
package EER;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Relationship#getExclusionConstraints <em>Exclusion Constraints</em>}</li>
 *   <li>{@link EER.Relationship#getInclusionConstraints <em>Inclusion Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getRelationship()
 * @model
 * @generated
 */
public interface Relationship extends AbstractRelationship
{
	/**
	 * Returns the value of the '<em><b>Exclusion Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link EER.Exclusion}.
	 * It is bidirectional and its opposite is '{@link EER.Exclusion#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusion Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusion Constraints</em>' containment reference list.
	 * @see EER.EERPackage#getRelationship_ExclusionConstraints()
	 * @see EER.Exclusion#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Exclusion> getExclusionConstraints();

	/**
	 * Returns the value of the '<em><b>Inclusion Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link EER.Inclusion}.
	 * It is bidirectional and its opposite is '{@link EER.Inclusion#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inclusion Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inclusion Constraints</em>' containment reference list.
	 * @see EER.EERPackage#getRelationship_InclusionConstraints()
	 * @see EER.Inclusion#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Inclusion> getInclusionConstraints();

} // Relationship

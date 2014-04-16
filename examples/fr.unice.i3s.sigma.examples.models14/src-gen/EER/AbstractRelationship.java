/**
 */
package EER;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.AbstractRelationship#getParticipants <em>Participants</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getAbstractRelationship()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRelationship extends Node
{
	/**
	 * Returns the value of the '<em><b>Participants</b></em>' containment reference list.
	 * The list contents are of type {@link EER.Participant}.
	 * It is bidirectional and its opposite is '{@link EER.Participant#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' containment reference list.
	 * @see EER.EERPackage#getAbstractRelationship_Participants()
	 * @see EER.Participant#getSource
	 * @model opposite="source" containment="true" lower="2"
	 * @generated
	 */
	EList<Participant> getParticipants();

} // AbstractRelationship

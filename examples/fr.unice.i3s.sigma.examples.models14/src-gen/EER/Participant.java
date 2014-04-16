/**
 */
package EER;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Participant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Participant#getTarget <em>Target</em>}</li>
 *   <li>{@link EER.Participant#getSource <em>Source</em>}</li>
 *   <li>{@link EER.Participant#getExclusiveConstraint <em>Exclusive Constraint</em>}</li>
 *   <li>{@link EER.Participant#getInclusivenessConstraint <em>Inclusiveness Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getParticipant()
 * @model
 * @generated
 */
public interface Participant extends AbstractParticipant
{
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Entity)
	 * @see EER.EERPackage#getParticipant_Target()
	 * @model required="true"
	 * @generated
	 */
	Entity getTarget();

	/**
	 * Sets the value of the '{@link EER.Participant#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Entity value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EER.AbstractRelationship#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(AbstractRelationship)
	 * @see EER.EERPackage#getParticipant_Source()
	 * @see EER.AbstractRelationship#getParticipants
	 * @model opposite="participants" required="true" transient="false"
	 * @generated
	 */
	AbstractRelationship getSource();

	/**
	 * Sets the value of the '{@link EER.Participant#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(AbstractRelationship value);

	/**
	 * Returns the value of the '<em><b>Exclusive Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link EER.Exclusive}.
	 * It is bidirectional and its opposite is '{@link EER.Exclusive#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exclusive Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusive Constraint</em>' containment reference list.
	 * @see EER.EERPackage#getParticipant_ExclusiveConstraint()
	 * @see EER.Exclusive#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Exclusive> getExclusiveConstraint();

	/**
	 * Returns the value of the '<em><b>Inclusiveness Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link EER.Inclusiveness}.
	 * It is bidirectional and its opposite is '{@link EER.Inclusiveness#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inclusiveness Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inclusiveness Constraint</em>' containment reference list.
	 * @see EER.EERPackage#getParticipant_InclusivenessConstraint()
	 * @see EER.Inclusiveness#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<Inclusiveness> getInclusivenessConstraint();

} // Participant

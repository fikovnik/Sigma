/**
 */
package EER;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation Participant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.AggregationParticipant#getTarget <em>Target</em>}</li>
 *   <li>{@link EER.AggregationParticipant#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getAggregationParticipant()
 * @model
 * @generated
 */
public interface AggregationParticipant extends AbstractParticipant
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
	 * @see #setTarget(Node)
	 * @see EER.EERPackage#getAggregationParticipant_Target()
	 * @model
	 * @generated
	 */
	Node getTarget();

	/**
	 * Sets the value of the '{@link EER.AggregationParticipant#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Node value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EER.Aggregation#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Aggregation)
	 * @see EER.EERPackage#getAggregationParticipant_Source()
	 * @see EER.Aggregation#getParticipants
	 * @model opposite="participants" required="true" transient="false"
	 * @generated
	 */
	Aggregation getSource();

	/**
	 * Sets the value of the '{@link EER.AggregationParticipant#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Aggregation value);

} // AggregationParticipant

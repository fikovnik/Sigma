/**
 */
package EER;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Aggregation#getSource <em>Source</em>}</li>
 *   <li>{@link EER.Aggregation#getParticipants <em>Participants</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getAggregation()
 * @model
 * @generated
 */
public interface Aggregation extends AttributedNode
{
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Entity)
	 * @see EER.EERPackage#getAggregation_Source()
	 * @model required="true"
	 * @generated
	 */
	Entity getSource();

	/**
	 * Sets the value of the '{@link EER.Aggregation#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Entity value);

	/**
	 * Returns the value of the '<em><b>Participants</b></em>' containment reference list.
	 * The list contents are of type {@link EER.AggregationParticipant}.
	 * It is bidirectional and its opposite is '{@link EER.AggregationParticipant#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Participants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Participants</em>' containment reference list.
	 * @see EER.EERPackage#getAggregation_Participants()
	 * @see EER.AggregationParticipant#getSource
	 * @model opposite="source" containment="true" required="true"
	 * @generated
	 */
	EList<AggregationParticipant> getParticipants();

} // Aggregation

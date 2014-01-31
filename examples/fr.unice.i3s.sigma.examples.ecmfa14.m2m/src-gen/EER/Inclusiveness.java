/**
 */
package EER;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Inclusiveness</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Inclusiveness#getSource <em>Source</em>}</li>
 *   <li>{@link EER.Inclusiveness#getTarget <em>Target</em>}</li>
 *   <li>{@link EER.Inclusiveness#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link EER.Inclusiveness#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getInclusiveness()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SourceTarget'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL SourceTarget='\n\t\t\tself.target <> self.source'"
 * @generated
 */
public interface Inclusiveness extends Constraint
{
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EER.Participant#getInclusivenessConstraint <em>Inclusiveness Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Participant)
	 * @see EER.EERPackage#getInclusiveness_Source()
	 * @see EER.Participant#getInclusivenessConstraint
	 * @model opposite="inclusivenessConstraint" required="true" transient="false"
	 * @generated
	 */
	Participant getSource();

	/**
	 * Sets the value of the '{@link EER.Inclusiveness#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Participant value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Participant)
	 * @see EER.EERPackage#getInclusiveness_Target()
	 * @model required="true"
	 * @generated
	 */
	Participant getTarget();

	/**
	 * Sets the value of the '{@link EER.Inclusiveness#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Participant value);

	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(int)
	 * @see EER.EERPackage#getInclusiveness_LowerBound()
	 * @model required="true"
	 * @generated
	 */
	int getLowerBound();

	/**
	 * Sets the value of the '{@link EER.Inclusiveness#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(int value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(int)
	 * @see EER.EERPackage#getInclusiveness_UpperBound()
	 * @model
	 * @generated
	 */
	int getUpperBound();

	/**
	 * Sets the value of the '{@link EER.Inclusiveness#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(int value);

} // Inclusiveness

/**
 */
package EER;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclusive</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Exclusive#getSource <em>Source</em>}</li>
 *   <li>{@link EER.Exclusive#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getExclusive()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SourceTarget'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL SourceTarget='\n\t\t\tself.target <> self.source'"
 * @generated
 */
public interface Exclusive extends Constraint
{
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EER.Participant#getExclusiveConstraint <em>Exclusive Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Participant)
	 * @see EER.EERPackage#getExclusive_Source()
	 * @see EER.Participant#getExclusiveConstraint
	 * @model opposite="exclusiveConstraint" required="true" transient="false"
	 * @generated
	 */
	Participant getSource();

	/**
	 * Sets the value of the '{@link EER.Exclusive#getSource <em>Source</em>}' container reference.
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
	 * @see EER.EERPackage#getExclusive_Target()
	 * @model required="true"
	 * @generated
	 */
	Participant getTarget();

	/**
	 * Sets the value of the '{@link EER.Exclusive#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Participant value);

} // Exclusive

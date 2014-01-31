/**
 */
package EER;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exclusion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Exclusion#getSource <em>Source</em>}</li>
 *   <li>{@link EER.Exclusion#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getExclusion()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SourceTarget'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL SourceTarget='\n\t\t\tself.target <> self.source'"
 * @generated
 */
public interface Exclusion extends Constraint
{
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EER.Relationship#getExclusionConstraints <em>Exclusion Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Relationship)
	 * @see EER.EERPackage#getExclusion_Source()
	 * @see EER.Relationship#getExclusionConstraints
	 * @model opposite="exclusionConstraints" required="true" transient="false"
	 * @generated
	 */
	Relationship getSource();

	/**
	 * Sets the value of the '{@link EER.Exclusion#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Relationship value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Relationship)
	 * @see EER.EERPackage#getExclusion_Target()
	 * @model required="true"
	 * @generated
	 */
	Relationship getTarget();

	/**
	 * Sets the value of the '{@link EER.Exclusion#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Relationship value);

} // Exclusion

/**
 */
package EER;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.SpecializationRelationship#getSource <em>Source</em>}</li>
 *   <li>{@link EER.SpecializationRelationship#getRelationship <em>Relationship</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getSpecializationRelationship()
 * @model
 * @generated
 */
public interface SpecializationRelationship extends EObject
{
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EER.Entity#getIsSpecializedBy <em>Is Specialized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(Entity)
	 * @see EER.EERPackage#getSpecializationRelationship_Source()
	 * @see EER.Entity#getIsSpecializedBy
	 * @model opposite="isSpecializedBy" required="true" transient="false"
	 * @generated
	 */
	Entity getSource();

	/**
	 * Sets the value of the '{@link EER.SpecializationRelationship#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Entity value);

	/**
	 * Returns the value of the '<em><b>Relationship</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link EER.Generalization#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship</em>' reference.
	 * @see #setRelationship(Generalization)
	 * @see EER.EERPackage#getSpecializationRelationship_Relationship()
	 * @see EER.Generalization#getParent
	 * @model opposite="parent" required="true"
	 * @generated
	 */
	Generalization getRelationship();

	/**
	 * Sets the value of the '{@link EER.SpecializationRelationship#getRelationship <em>Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relationship</em>' reference.
	 * @see #getRelationship()
	 * @generated
	 */
	void setRelationship(Generalization value);

} // SpecializationRelationship

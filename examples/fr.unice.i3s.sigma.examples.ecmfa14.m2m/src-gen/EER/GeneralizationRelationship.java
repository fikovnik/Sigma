/**
 */
package EER;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generalization Relationship</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.GeneralizationRelationship#getRelationship <em>Relationship</em>}</li>
 *   <li>{@link EER.GeneralizationRelationship#getChild <em>Child</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getGeneralizationRelationship()
 * @model
 * @generated
 */
public interface GeneralizationRelationship extends EObject
{
	/**
	 * Returns the value of the '<em><b>Relationship</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link EER.Generalization#getChilds <em>Childs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relationship</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relationship</em>' reference.
	 * @see #setRelationship(Generalization)
	 * @see EER.EERPackage#getGeneralizationRelationship_Relationship()
	 * @see EER.Generalization#getChilds
	 * @model opposite="childs" required="true"
	 * @generated
	 */
	Generalization getRelationship();

	/**
	 * Sets the value of the '{@link EER.GeneralizationRelationship#getRelationship <em>Relationship</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relationship</em>' reference.
	 * @see #getRelationship()
	 * @generated
	 */
	void setRelationship(Generalization value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link EER.Entity#getSpecializes <em>Specializes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' container reference.
	 * @see #setChild(Entity)
	 * @see EER.EERPackage#getGeneralizationRelationship_Child()
	 * @see EER.Entity#getSpecializes
	 * @model opposite="specializes" required="true" transient="false"
	 * @generated
	 */
	Entity getChild();

	/**
	 * Sets the value of the '{@link EER.GeneralizationRelationship#getChild <em>Child</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' container reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(Entity value);

} // GeneralizationRelationship

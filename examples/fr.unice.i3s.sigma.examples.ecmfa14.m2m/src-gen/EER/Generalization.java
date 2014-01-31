/**
 */
package EER;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generalization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Generalization#getParent <em>Parent</em>}</li>
 *   <li>{@link EER.Generalization#getChilds <em>Childs</em>}</li>
 *   <li>{@link EER.Generalization#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link EER.Generalization#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getGeneralization()
 * @model
 * @generated
 */
public interface Generalization extends AttributedNode
{
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link EER.SpecializationRelationship#getRelationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(SpecializationRelationship)
	 * @see EER.EERPackage#getGeneralization_Parent()
	 * @see EER.SpecializationRelationship#getRelationship
	 * @model opposite="relationship" required="true"
	 * @generated
	 */
	SpecializationRelationship getParent();

	/**
	 * Sets the value of the '{@link EER.Generalization#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(SpecializationRelationship value);

	/**
	 * Returns the value of the '<em><b>Childs</b></em>' reference list.
	 * The list contents are of type {@link EER.GeneralizationRelationship}.
	 * It is bidirectional and its opposite is '{@link EER.GeneralizationRelationship#getRelationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Childs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Childs</em>' reference list.
	 * @see EER.EERPackage#getGeneralization_Childs()
	 * @see EER.GeneralizationRelationship#getRelationship
	 * @model opposite="relationship" required="true"
	 * @generated
	 */
	EList<GeneralizationRelationship> getChilds();

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference.
	 * @see #setAttribute(Attribute)
	 * @see EER.EERPackage#getGeneralization_Attribute()
	 * @model containment="true"
	 * @generated
	 */
	Attribute getAttribute();

	/**
	 * Sets the value of the '{@link EER.Generalization#getAttribute <em>Attribute</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute</em>' containment reference.
	 * @see #getAttribute()
	 * @generated
	 */
	void setAttribute(Attribute value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link EER.GeneralizationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see EER.GeneralizationType
	 * @see #setType(GeneralizationType)
	 * @see EER.EERPackage#getGeneralization_Type()
	 * @model required="true"
	 * @generated
	 */
	GeneralizationType getType();

	/**
	 * Sets the value of the '{@link EER.Generalization#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see EER.GeneralizationType
	 * @see #getType()
	 * @generated
	 */
	void setType(GeneralizationType value);

} // Generalization

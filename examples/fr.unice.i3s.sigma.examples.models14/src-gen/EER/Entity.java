/**
 */
package EER;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.Entity#getPrimaryKey <em>Primary Key</em>}</li>
 *   <li>{@link EER.Entity#getCandidateKey <em>Candidate Key</em>}</li>
 *   <li>{@link EER.Entity#getDependencyRelationships <em>Dependency Relationships</em>}</li>
 *   <li>{@link EER.Entity#getIsSpecializedBy <em>Is Specialized By</em>}</li>
 *   <li>{@link EER.Entity#getSpecializes <em>Specializes</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getEntity()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='PrimaryKeysOCL'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore/OCL PrimaryKeysOCL='\n\t\t\tself.isSpecializedBy -> size() = 0 and \n\t\t\tself.specializes -> size() = 0 \n\t\t\t  implies  self.primaryKey -> size() = 1'"
 * @generated
 */
public interface Entity extends Node
{
	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' reference.
	 * @see #setPrimaryKey(CandidateKey)
	 * @see EER.EERPackage#getEntity_PrimaryKey()
	 * @model
	 * @generated
	 */
	CandidateKey getPrimaryKey();

	/**
	 * Sets the value of the '{@link EER.Entity#getPrimaryKey <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(CandidateKey value);

	/**
	 * Returns the value of the '<em><b>Candidate Key</b></em>' containment reference list.
	 * The list contents are of type {@link EER.CandidateKey}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidate Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidate Key</em>' containment reference list.
	 * @see EER.EERPackage#getEntity_CandidateKey()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<CandidateKey> getCandidateKey();

	/**
	 * Returns the value of the '<em><b>Dependency Relationships</b></em>' containment reference list.
	 * The list contents are of type {@link EER.DependencyRelationship}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dependency Relationships</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency Relationships</em>' containment reference list.
	 * @see EER.EERPackage#getEntity_DependencyRelationships()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependencyRelationship> getDependencyRelationships();

	/**
	 * Returns the value of the '<em><b>Is Specialized By</b></em>' containment reference list.
	 * The list contents are of type {@link EER.SpecializationRelationship}.
	 * It is bidirectional and its opposite is '{@link EER.SpecializationRelationship#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Specialized By</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Specialized By</em>' containment reference list.
	 * @see EER.EERPackage#getEntity_IsSpecializedBy()
	 * @see EER.SpecializationRelationship#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<SpecializationRelationship> getIsSpecializedBy();

	/**
	 * Returns the value of the '<em><b>Specializes</b></em>' containment reference list.
	 * The list contents are of type {@link EER.GeneralizationRelationship}.
	 * It is bidirectional and its opposite is '{@link EER.GeneralizationRelationship#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specializes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specializes</em>' containment reference list.
	 * @see EER.EERPackage#getEntity_Specializes()
	 * @see EER.GeneralizationRelationship#getChild
	 * @model opposite="child" containment="true"
	 * @generated
	 */
	EList<GeneralizationRelationship> getSpecializes();

} // Entity

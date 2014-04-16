/**
 */
package EER;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link EER.CompositeAttribute#getSinglesAttributes <em>Singles Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see EER.EERPackage#getCompositeAttribute()
 * @model
 * @generated
 */
public interface CompositeAttribute extends Attribute
{
	/**
	 * Returns the value of the '<em><b>Singles Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link EER.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Singles Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Singles Attributes</em>' containment reference list.
	 * @see EER.EERPackage#getCompositeAttribute_SinglesAttributes()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Attribute> getSinglesAttributes();

} // CompositeAttribute

/**
 */
package EER;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Generalization Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see EER.EERPackage#getGeneralizationType()
 * @model
 * @generated
 */
public enum GeneralizationType implements Enumerator
{
	/**
	 * The '<em><b>Total Overlapping</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOTAL_OVERLAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	TOTAL_OVERLAPPING(0, "totalOverlapping", "totalOverlapping"),

	/**
	 * The '<em><b>Total Disjoint</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOTAL_DISJOINT_VALUE
	 * @generated
	 * @ordered
	 */
	TOTAL_DISJOINT(1, "totalDisjoint", "totalDisjoint"),

	/**
	 * The '<em><b>Partial Overlapping</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTIAL_OVERLAPPING_VALUE
	 * @generated
	 * @ordered
	 */
	PARTIAL_OVERLAPPING(2, "partialOverlapping", "partialOverlapping"),

	/**
	 * The '<em><b>Partial Disjoint</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARTIAL_DISJOINT_VALUE
	 * @generated
	 * @ordered
	 */
	PARTIAL_DISJOINT(3, "partialDisjoint", "partialDisjoint");

	/**
	 * The '<em><b>Total Overlapping</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Total Overlapping</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOTAL_OVERLAPPING
	 * @model name="totalOverlapping"
	 * @generated
	 * @ordered
	 */
	public static final int TOTAL_OVERLAPPING_VALUE = 0;

	/**
	 * The '<em><b>Total Disjoint</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Total Disjoint</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOTAL_DISJOINT
	 * @model name="totalDisjoint"
	 * @generated
	 * @ordered
	 */
	public static final int TOTAL_DISJOINT_VALUE = 1;

	/**
	 * The '<em><b>Partial Overlapping</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Partial Overlapping</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTIAL_OVERLAPPING
	 * @model name="partialOverlapping"
	 * @generated
	 * @ordered
	 */
	public static final int PARTIAL_OVERLAPPING_VALUE = 2;

	/**
	 * The '<em><b>Partial Disjoint</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Partial Disjoint</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARTIAL_DISJOINT
	 * @model name="partialDisjoint"
	 * @generated
	 * @ordered
	 */
	public static final int PARTIAL_DISJOINT_VALUE = 3;

	/**
	 * An array of all the '<em><b>Generalization Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GeneralizationType[] VALUES_ARRAY =
		new GeneralizationType[]
		{
			TOTAL_OVERLAPPING,
			TOTAL_DISJOINT,
			PARTIAL_OVERLAPPING,
			PARTIAL_DISJOINT,
		};

	/**
	 * A public read-only list of all the '<em><b>Generalization Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GeneralizationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Generalization Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneralizationType get(String literal)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			GeneralizationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generalization Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneralizationType getByName(String name)
	{
		for (int i = 0; i < VALUES_ARRAY.length; ++i)
		{
			GeneralizationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name))
			{
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Generalization Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneralizationType get(int value)
	{
		switch (value)
		{
			case TOTAL_OVERLAPPING_VALUE: return TOTAL_OVERLAPPING;
			case TOTAL_DISJOINT_VALUE: return TOTAL_DISJOINT;
			case PARTIAL_OVERLAPPING_VALUE: return PARTIAL_OVERLAPPING;
			case PARTIAL_DISJOINT_VALUE: return PARTIAL_DISJOINT;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private GeneralizationType(int value, String name, String literal)
	{
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue()
	{
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName()
	{
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral()
	{
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		return literal;
	}
	
} //GeneralizationType

/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang.util;

import fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Field;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Member;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage
 * @generated
 */
public class ObjLangAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ObjLangPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjLangAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = ObjLangPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object)
	{
		if (object == modelPackage)
		{
			return true;
		}
		if (object instanceof EObject)
		{
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjLangSwitch<Adapter> modelSwitch =
		new ObjLangSwitch<Adapter>()
		{
			@Override
			public Adapter caseNamedElement(NamedElement object)
			{
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseClassifier(Classifier object)
			{
				return createClassifierAdapter();
			}
			@Override
			public Adapter caseClass(fr.inria.spirals.sigma.ttc14.fixml.objlang.Class object)
			{
				return createClassAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object)
			{
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object)
			{
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseMember(Member object)
			{
				return createMemberAdapter();
			}
			@Override
			public Adapter caseConstructor(Constructor object)
			{
				return createConstructorAdapter();
			}
			@Override
			public Adapter caseParameter(Parameter object)
			{
				return createParameterAdapter();
			}
			@Override
			public Adapter caseFieldInitialisiation(FieldInitialisiation object)
			{
				return createFieldInitialisiationAdapter();
			}
			@Override
			public Adapter caseField(Field object)
			{
				return createFieldAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object)
			{
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object)
			{
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseDoubleLiteral(DoubleLiteral object)
			{
				return createDoubleLiteralAdapter();
			}
			@Override
			public Adapter caseLongLiteral(LongLiteral object)
			{
				return createLongLiteralAdapter();
			}
			@Override
			public Adapter caseIntegerLiteral(IntegerLiteral object)
			{
				return createIntegerLiteralAdapter();
			}
			@Override
			public Adapter caseConstructorCall(ConstructorCall object)
			{
				return createConstructorCallAdapter();
			}
			@Override
			public Adapter caseParameterAccess(ParameterAccess object)
			{
				return createParameterAccessAdapter();
			}
			@Override
			public Adapter caseNullLiteral(NullLiteral object)
			{
				return createNullLiteralAdapter();
			}
			@Override
			public Adapter caseArrayLiteral(ArrayLiteral object)
			{
				return createArrayLiteralAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object)
			{
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target)
	{
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier
	 * @generated
	 */
	public Adapter createClassifierAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class
	 * @generated
	 */
	public Adapter createClassAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Member
	 * @generated
	 */
	public Adapter createMemberAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor
	 * @generated
	 */
	public Adapter createConstructorAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter
	 * @generated
	 */
	public Adapter createParameterAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation <em>Field Initialisiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation
	 * @generated
	 */
	public Adapter createFieldInitialisiationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Field
	 * @generated
	 */
	public Adapter createFieldAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral
	 * @generated
	 */
	public Adapter createDoubleLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral <em>Long Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral
	 * @generated
	 */
	public Adapter createLongLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral
	 * @generated
	 */
	public Adapter createIntegerLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall <em>Constructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall
	 * @generated
	 */
	public Adapter createConstructorCallAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess <em>Parameter Access</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess
	 * @generated
	 */
	public Adapter createParameterAccessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral <em>Null Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral
	 * @generated
	 */
	public Adapter createNullLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral <em>Array Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral
	 * @generated
	 */
	public Adapter createArrayLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter()
	{
		return null;
	}

} //ObjLangAdapterFactory

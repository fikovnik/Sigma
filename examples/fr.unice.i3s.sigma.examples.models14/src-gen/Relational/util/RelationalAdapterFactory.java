/**
 */
package Relational.util;

import Relational.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see Relational.RelationalPackage
 * @generated
 */
public class RelationalAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static RelationalPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = RelationalPackage.eINSTANCE;
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
	protected RelationalSwitch<Adapter> modelSwitch =
		new RelationalSwitch<Adapter>()
		{
			@Override
			public Adapter caseSchema(Schema object)
			{
				return createSchemaAdapter();
			}
			@Override
			public Adapter caseTable(Table object)
			{
				return createTableAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object)
			{
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseDomain(Domain object)
			{
				return createDomainAdapter();
			}
			@Override
			public Adapter caseCandidateKey(CandidateKey object)
			{
				return createCandidateKeyAdapter();
			}
			@Override
			public Adapter caseForeignKey(ForeignKey object)
			{
				return createForeignKeyAdapter();
			}
			@Override
			public Adapter casePrimitiveType(PrimitiveType object)
			{
				return createPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseEnumerationType(EnumerationType object)
			{
				return createEnumerationTypeAdapter();
			}
			@Override
			public Adapter caseEnumeratedLiteral(EnumeratedLiteral object)
			{
				return createEnumeratedLiteralAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object)
			{
				return createConstraintAdapter();
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
	 * Creates a new adapter for an object of class '{@link Relational.Schema <em>Schema</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.Schema
	 * @generated
	 */
	public Adapter createSchemaAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.Table
	 * @generated
	 */
	public Adapter createTableAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.Domain
	 * @generated
	 */
	public Adapter createDomainAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.CandidateKey <em>Candidate Key</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.CandidateKey
	 * @generated
	 */
	public Adapter createCandidateKeyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.ForeignKey <em>Foreign Key</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.ForeignKey
	 * @generated
	 */
	public Adapter createForeignKeyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.EnumerationType
	 * @generated
	 */
	public Adapter createEnumerationTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.EnumeratedLiteral <em>Enumerated Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.EnumeratedLiteral
	 * @generated
	 */
	public Adapter createEnumeratedLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link Relational.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see Relational.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter()
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

} //RelationalAdapterFactory

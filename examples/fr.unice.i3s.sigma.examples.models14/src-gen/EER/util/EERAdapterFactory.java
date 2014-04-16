/**
 */
package EER.util;

import EER.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see EER.EERPackage
 * @generated
 */
public class EERAdapterFactory extends AdapterFactoryImpl
{
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EERPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EERAdapterFactory()
	{
		if (modelPackage == null)
		{
			modelPackage = EERPackage.eINSTANCE;
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
	protected EERSwitch<Adapter> modelSwitch =
		new EERSwitch<Adapter>()
		{
			@Override
			public Adapter caseProject(Project object)
			{
				return createProjectAdapter();
			}
			@Override
			public Adapter caseAttributedNode(AttributedNode object)
			{
				return createAttributedNodeAdapter();
			}
			@Override
			public Adapter caseEntity(Entity object)
			{
				return createEntityAdapter();
			}
			@Override
			public Adapter caseWeakEntity(WeakEntity object)
			{
				return createWeakEntityAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object)
			{
				return createConstraintAdapter();
			}
			@Override
			public Adapter caseExclusive(Exclusive object)
			{
				return createExclusiveAdapter();
			}
			@Override
			public Adapter caseInclusiveness(Inclusiveness object)
			{
				return createInclusivenessAdapter();
			}
			@Override
			public Adapter caseExclusion(Exclusion object)
			{
				return createExclusionAdapter();
			}
			@Override
			public Adapter caseInclusion(Inclusion object)
			{
				return createInclusionAdapter();
			}
			@Override
			public Adapter caseCandidateKey(CandidateKey object)
			{
				return createCandidateKeyAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object)
			{
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseCompositeAttribute(CompositeAttribute object)
			{
				return createCompositeAttributeAdapter();
			}
			@Override
			public Adapter caseSingleAttribute(SingleAttribute object)
			{
				return createSingleAttributeAdapter();
			}
			@Override
			public Adapter caseDomain(Domain object)
			{
				return createDomainAdapter();
			}
			@Override
			public Adapter caseEnumerationType(EnumerationType object)
			{
				return createEnumerationTypeAdapter();
			}
			@Override
			public Adapter casePrimitiveType(PrimitiveType object)
			{
				return createPrimitiveTypeAdapter();
			}
			@Override
			public Adapter caseEnumeratedLiteral(EnumeratedLiteral object)
			{
				return createEnumeratedLiteralAdapter();
			}
			@Override
			public Adapter caseAbstractRelationship(AbstractRelationship object)
			{
				return createAbstractRelationshipAdapter();
			}
			@Override
			public Adapter caseRelationship(Relationship object)
			{
				return createRelationshipAdapter();
			}
			@Override
			public Adapter caseDependencyRelationship(DependencyRelationship object)
			{
				return createDependencyRelationshipAdapter();
			}
			@Override
			public Adapter caseParticipant(Participant object)
			{
				return createParticipantAdapter();
			}
			@Override
			public Adapter caseGeneralization(Generalization object)
			{
				return createGeneralizationAdapter();
			}
			@Override
			public Adapter caseSpecializationRelationship(SpecializationRelationship object)
			{
				return createSpecializationRelationshipAdapter();
			}
			@Override
			public Adapter caseGeneralizationRelationship(GeneralizationRelationship object)
			{
				return createGeneralizationRelationshipAdapter();
			}
			@Override
			public Adapter caseAbstractParticipant(AbstractParticipant object)
			{
				return createAbstractParticipantAdapter();
			}
			@Override
			public Adapter caseAggregationParticipant(AggregationParticipant object)
			{
				return createAggregationParticipantAdapter();
			}
			@Override
			public Adapter caseNode(Node object)
			{
				return createNodeAdapter();
			}
			@Override
			public Adapter caseAggregation(Aggregation object)
			{
				return createAggregationAdapter();
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
	 * Creates a new adapter for an object of class '{@link EER.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Project
	 * @generated
	 */
	public Adapter createProjectAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.AttributedNode <em>Attributed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.AttributedNode
	 * @generated
	 */
	public Adapter createAttributedNodeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.WeakEntity <em>Weak Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.WeakEntity
	 * @generated
	 */
	public Adapter createWeakEntityAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Exclusive <em>Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Exclusive
	 * @generated
	 */
	public Adapter createExclusiveAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Inclusiveness <em>Inclusiveness</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Inclusiveness
	 * @generated
	 */
	public Adapter createInclusivenessAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Exclusion <em>Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Exclusion
	 * @generated
	 */
	public Adapter createExclusionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Inclusion <em>Inclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Inclusion
	 * @generated
	 */
	public Adapter createInclusionAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.CandidateKey <em>Candidate Key</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.CandidateKey
	 * @generated
	 */
	public Adapter createCandidateKeyAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.CompositeAttribute <em>Composite Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.CompositeAttribute
	 * @generated
	 */
	public Adapter createCompositeAttributeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.SingleAttribute <em>Single Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.SingleAttribute
	 * @generated
	 */
	public Adapter createSingleAttributeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Domain
	 * @generated
	 */
	public Adapter createDomainAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.EnumerationType
	 * @generated
	 */
	public Adapter createEnumerationTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.PrimitiveType
	 * @generated
	 */
	public Adapter createPrimitiveTypeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.EnumeratedLiteral <em>Enumerated Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.EnumeratedLiteral
	 * @generated
	 */
	public Adapter createEnumeratedLiteralAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.AbstractRelationship <em>Abstract Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.AbstractRelationship
	 * @generated
	 */
	public Adapter createAbstractRelationshipAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Relationship
	 * @generated
	 */
	public Adapter createRelationshipAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.DependencyRelationship <em>Dependency Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.DependencyRelationship
	 * @generated
	 */
	public Adapter createDependencyRelationshipAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Participant
	 * @generated
	 */
	public Adapter createParticipantAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Generalization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Generalization
	 * @generated
	 */
	public Adapter createGeneralizationAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.SpecializationRelationship <em>Specialization Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.SpecializationRelationship
	 * @generated
	 */
	public Adapter createSpecializationRelationshipAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.GeneralizationRelationship <em>Generalization Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.GeneralizationRelationship
	 * @generated
	 */
	public Adapter createGeneralizationRelationshipAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.AbstractParticipant <em>Abstract Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.AbstractParticipant
	 * @generated
	 */
	public Adapter createAbstractParticipantAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.AggregationParticipant <em>Aggregation Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.AggregationParticipant
	 * @generated
	 */
	public Adapter createAggregationParticipantAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Node
	 * @generated
	 */
	public Adapter createNodeAdapter()
	{
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link EER.Aggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see EER.Aggregation
	 * @generated
	 */
	public Adapter createAggregationAdapter()
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

} //EERAdapterFactory

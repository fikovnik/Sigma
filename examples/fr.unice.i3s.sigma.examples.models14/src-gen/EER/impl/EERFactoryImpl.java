/**
 */
package EER.impl;

import EER.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EERFactoryImpl extends EFactoryImpl implements EERFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static EERFactory init()
	{
		try
		{
			EERFactory theEERFactory = (EERFactory)EPackage.Registry.INSTANCE.getEFactory(EERPackage.eNS_URI);
			if (theEERFactory != null)
			{
				return theEERFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new EERFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EERFactoryImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass)
	{
		switch (eClass.getClassifierID())
		{
			case EERPackage.PROJECT: return createProject();
			case EERPackage.ENTITY: return createEntity();
			case EERPackage.WEAK_ENTITY: return createWeakEntity();
			case EERPackage.CONSTRAINT: return createConstraint();
			case EERPackage.EXCLUSIVE: return createExclusive();
			case EERPackage.INCLUSIVENESS: return createInclusiveness();
			case EERPackage.EXCLUSION: return createExclusion();
			case EERPackage.INCLUSION: return createInclusion();
			case EERPackage.CANDIDATE_KEY: return createCandidateKey();
			case EERPackage.COMPOSITE_ATTRIBUTE: return createCompositeAttribute();
			case EERPackage.SINGLE_ATTRIBUTE: return createSingleAttribute();
			case EERPackage.ENUMERATION_TYPE: return createEnumerationType();
			case EERPackage.PRIMITIVE_TYPE: return createPrimitiveType();
			case EERPackage.ENUMERATED_LITERAL: return createEnumeratedLiteral();
			case EERPackage.RELATIONSHIP: return createRelationship();
			case EERPackage.DEPENDENCY_RELATIONSHIP: return createDependencyRelationship();
			case EERPackage.PARTICIPANT: return createParticipant();
			case EERPackage.GENERALIZATION: return createGeneralization();
			case EERPackage.SPECIALIZATION_RELATIONSHIP: return createSpecializationRelationship();
			case EERPackage.GENERALIZATION_RELATIONSHIP: return createGeneralizationRelationship();
			case EERPackage.AGGREGATION_PARTICIPANT: return createAggregationParticipant();
			case EERPackage.AGGREGATION: return createAggregation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue)
	{
		switch (eDataType.getClassifierID())
		{
			case EERPackage.DEPENDENCY_TYPE:
				return createDependencyTypeFromString(eDataType, initialValue);
			case EERPackage.GENERALIZATION_TYPE:
				return createGeneralizationTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue)
	{
		switch (eDataType.getClassifierID())
		{
			case EERPackage.DEPENDENCY_TYPE:
				return convertDependencyTypeToString(eDataType, instanceValue);
			case EERPackage.GENERALIZATION_TYPE:
				return convertGeneralizationTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Project createProject()
	{
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Entity createEntity()
	{
		EntityImpl entity = new EntityImpl();
		return entity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WeakEntity createWeakEntity()
	{
		WeakEntityImpl weakEntity = new WeakEntityImpl();
		return weakEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint()
	{
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exclusive createExclusive()
	{
		ExclusiveImpl exclusive = new ExclusiveImpl();
		return exclusive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inclusiveness createInclusiveness()
	{
		InclusivenessImpl inclusiveness = new InclusivenessImpl();
		return inclusiveness;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exclusion createExclusion()
	{
		ExclusionImpl exclusion = new ExclusionImpl();
		return exclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Inclusion createInclusion()
	{
		InclusionImpl inclusion = new InclusionImpl();
		return inclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CandidateKey createCandidateKey()
	{
		CandidateKeyImpl candidateKey = new CandidateKeyImpl();
		return candidateKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeAttribute createCompositeAttribute()
	{
		CompositeAttributeImpl compositeAttribute = new CompositeAttributeImpl();
		return compositeAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SingleAttribute createSingleAttribute()
	{
		SingleAttributeImpl singleAttribute = new SingleAttributeImpl();
		return singleAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationType createEnumerationType()
	{
		EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
		return enumerationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType createPrimitiveType()
	{
		PrimitiveTypeImpl primitiveType = new PrimitiveTypeImpl();
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumeratedLiteral createEnumeratedLiteral()
	{
		EnumeratedLiteralImpl enumeratedLiteral = new EnumeratedLiteralImpl();
		return enumeratedLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Relationship createRelationship()
	{
		RelationshipImpl relationship = new RelationshipImpl();
		return relationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyRelationship createDependencyRelationship()
	{
		DependencyRelationshipImpl dependencyRelationship = new DependencyRelationshipImpl();
		return dependencyRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Participant createParticipant()
	{
		ParticipantImpl participant = new ParticipantImpl();
		return participant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generalization createGeneralization()
	{
		GeneralizationImpl generalization = new GeneralizationImpl();
		return generalization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecializationRelationship createSpecializationRelationship()
	{
		SpecializationRelationshipImpl specializationRelationship = new SpecializationRelationshipImpl();
		return specializationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationRelationship createGeneralizationRelationship()
	{
		GeneralizationRelationshipImpl generalizationRelationship = new GeneralizationRelationshipImpl();
		return generalizationRelationship;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationParticipant createAggregationParticipant()
	{
		AggregationParticipantImpl aggregationParticipant = new AggregationParticipantImpl();
		return aggregationParticipant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aggregation createAggregation()
	{
		AggregationImpl aggregation = new AggregationImpl();
		return aggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DependencyType createDependencyTypeFromString(EDataType eDataType, String initialValue)
	{
		DependencyType result = DependencyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDependencyTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneralizationType createGeneralizationTypeFromString(EDataType eDataType, String initialValue)
	{
		GeneralizationType result = GeneralizationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGeneralizationTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EERPackage getEERPackage()
	{
		return (EERPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static EERPackage getPackage()
	{
		return EERPackage.eINSTANCE;
	}

} //EERFactoryImpl

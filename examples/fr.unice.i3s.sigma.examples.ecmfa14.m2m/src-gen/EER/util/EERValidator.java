/**
 */
package EER.util;

import EER.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see EER.EERPackage
 * @generated
 */
public class EERValidator extends EObjectValidator
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final EERValidator INSTANCE = new EERValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "EER";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EERValidator()
	{
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage()
	{
	  return EERPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		switch (classifierID)
		{
			case EERPackage.PROJECT:
				return validateProject((Project)value, diagnostics, context);
			case EERPackage.ATTRIBUTED_NODE:
				return validateAttributedNode((AttributedNode)value, diagnostics, context);
			case EERPackage.ENTITY:
				return validateEntity((Entity)value, diagnostics, context);
			case EERPackage.WEAK_ENTITY:
				return validateWeakEntity((WeakEntity)value, diagnostics, context);
			case EERPackage.CONSTRAINT:
				return validateConstraint((Constraint)value, diagnostics, context);
			case EERPackage.EXCLUSIVE:
				return validateExclusive((Exclusive)value, diagnostics, context);
			case EERPackage.INCLUSIVENESS:
				return validateInclusiveness((Inclusiveness)value, diagnostics, context);
			case EERPackage.EXCLUSION:
				return validateExclusion((Exclusion)value, diagnostics, context);
			case EERPackage.INCLUSION:
				return validateInclusion((Inclusion)value, diagnostics, context);
			case EERPackage.CANDIDATE_KEY:
				return validateCandidateKey((CandidateKey)value, diagnostics, context);
			case EERPackage.ATTRIBUTE:
				return validateAttribute((Attribute)value, diagnostics, context);
			case EERPackage.COMPOSITE_ATTRIBUTE:
				return validateCompositeAttribute((CompositeAttribute)value, diagnostics, context);
			case EERPackage.SINGLE_ATTRIBUTE:
				return validateSingleAttribute((SingleAttribute)value, diagnostics, context);
			case EERPackage.DOMAIN:
				return validateDomain((Domain)value, diagnostics, context);
			case EERPackage.ENUMERATION_TYPE:
				return validateEnumerationType((EnumerationType)value, diagnostics, context);
			case EERPackage.PRIMITIVE_TYPE:
				return validatePrimitiveType((PrimitiveType)value, diagnostics, context);
			case EERPackage.ENUMERATED_LITERAL:
				return validateEnumeratedLiteral((EnumeratedLiteral)value, diagnostics, context);
			case EERPackage.ABSTRACT_RELATIONSHIP:
				return validateAbstractRelationship((AbstractRelationship)value, diagnostics, context);
			case EERPackage.RELATIONSHIP:
				return validateRelationship((Relationship)value, diagnostics, context);
			case EERPackage.DEPENDENCY_RELATIONSHIP:
				return validateDependencyRelationship((DependencyRelationship)value, diagnostics, context);
			case EERPackage.PARTICIPANT:
				return validateParticipant((Participant)value, diagnostics, context);
			case EERPackage.GENERALIZATION:
				return validateGeneralization((Generalization)value, diagnostics, context);
			case EERPackage.SPECIALIZATION_RELATIONSHIP:
				return validateSpecializationRelationship((SpecializationRelationship)value, diagnostics, context);
			case EERPackage.GENERALIZATION_RELATIONSHIP:
				return validateGeneralizationRelationship((GeneralizationRelationship)value, diagnostics, context);
			case EERPackage.ABSTRACT_PARTICIPANT:
				return validateAbstractParticipant((AbstractParticipant)value, diagnostics, context);
			case EERPackage.AGGREGATION_PARTICIPANT:
				return validateAggregationParticipant((AggregationParticipant)value, diagnostics, context);
			case EERPackage.NODE:
				return validateNode((Node)value, diagnostics, context);
			case EERPackage.AGGREGATION:
				return validateAggregation((Aggregation)value, diagnostics, context);
			case EERPackage.DEPENDENCY_TYPE:
				return validateDependencyType((DependencyType)value, diagnostics, context);
			case EERPackage.GENERALIZATION_TYPE:
				return validateGeneralizationType((GeneralizationType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateProject(Project project, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(project, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttributedNode(AttributedNode attributedNode, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(attributedNode, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(entity, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entity, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntity_PrimaryKeysOCL(entity, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the PrimaryKeysOCL constraint of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String ENTITY__PRIMARY_KEYS_OCL__EEXPRESSION = "\n" +
		"\t\t\tself.isSpecializedBy -> size() = 0 and \n" +
		"\t\t\tself.specializes -> size() = 0 \n" +
		"\t\t\t  implies  self.primaryKey -> size() = 1";

	/**
	 * Validates the PrimaryKeysOCL constraint of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntity_PrimaryKeysOCL(Entity entity, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return
			validate
				(EERPackage.Literals.ENTITY,
				 entity,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "PrimaryKeysOCL",
				 ENTITY__PRIMARY_KEYS_OCL__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateWeakEntity(WeakEntity weakEntity, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(weakEntity, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(weakEntity, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntity_PrimaryKeysOCL(weakEntity, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateConstraint(Constraint constraint, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(constraint, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExclusive(Exclusive exclusive, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(exclusive, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(exclusive, diagnostics, context);
		if (result || diagnostics != null) result &= validateExclusive_SourceTarget(exclusive, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SourceTarget constraint of '<em>Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EXCLUSIVE__SOURCE_TARGET__EEXPRESSION = "\n" +
		"\t\t\tself.target <> self.source";

	/**
	 * Validates the SourceTarget constraint of '<em>Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExclusive_SourceTarget(Exclusive exclusive, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return
			validate
				(EERPackage.Literals.EXCLUSIVE,
				 exclusive,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SourceTarget",
				 EXCLUSIVE__SOURCE_TARGET__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInclusiveness(Inclusiveness inclusiveness, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(inclusiveness, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inclusiveness, diagnostics, context);
		if (result || diagnostics != null) result &= validateInclusiveness_SourceTarget(inclusiveness, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SourceTarget constraint of '<em>Inclusiveness</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String INCLUSIVENESS__SOURCE_TARGET__EEXPRESSION = "\n" +
		"\t\t\tself.target <> self.source";

	/**
	 * Validates the SourceTarget constraint of '<em>Inclusiveness</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInclusiveness_SourceTarget(Inclusiveness inclusiveness, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return
			validate
				(EERPackage.Literals.INCLUSIVENESS,
				 inclusiveness,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SourceTarget",
				 INCLUSIVENESS__SOURCE_TARGET__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExclusion(Exclusion exclusion, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(exclusion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(exclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validateExclusion_SourceTarget(exclusion, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SourceTarget constraint of '<em>Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String EXCLUSION__SOURCE_TARGET__EEXPRESSION = "\n" +
		"\t\t\tself.target <> self.source";

	/**
	 * Validates the SourceTarget constraint of '<em>Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExclusion_SourceTarget(Exclusion exclusion, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return
			validate
				(EERPackage.Literals.EXCLUSION,
				 exclusion,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SourceTarget",
				 EXCLUSION__SOURCE_TARGET__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInclusion(Inclusion inclusion, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		if (!validate_NoCircularContainment(inclusion, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(inclusion, diagnostics, context);
		if (result || diagnostics != null) result &= validateInclusion_SourceTarget(inclusion, diagnostics, context);
		return result;
	}

	/**
	 * The cached validation expression for the SourceTarget constraint of '<em>Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final String INCLUSION__SOURCE_TARGET__EEXPRESSION = "\n" +
		"\t\t\tself.target <> self.source";

	/**
	 * Validates the SourceTarget constraint of '<em>Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateInclusion_SourceTarget(Inclusion inclusion, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return
			validate
				(EERPackage.Literals.INCLUSION,
				 inclusion,
				 diagnostics,
				 context,
				 "http://www.eclipse.org/emf/2002/Ecore/OCL",
				 "SourceTarget",
				 INCLUSION__SOURCE_TARGET__EEXPRESSION,
				 Diagnostic.ERROR,
				 DIAGNOSTIC_SOURCE,
				 0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCandidateKey(CandidateKey candidateKey, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(candidateKey, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAttribute(Attribute attribute, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(attribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeAttribute(CompositeAttribute compositeAttribute, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(compositeAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSingleAttribute(SingleAttribute singleAttribute, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(singleAttribute, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDomain(Domain domain, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(domain, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumerationType(EnumerationType enumerationType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(enumerationType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePrimitiveType(PrimitiveType primitiveType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(primitiveType, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEnumeratedLiteral(EnumeratedLiteral enumeratedLiteral, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(enumeratedLiteral, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractRelationship(AbstractRelationship abstractRelationship, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(abstractRelationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRelationship(Relationship relationship, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(relationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyRelationship(DependencyRelationship dependencyRelationship, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(dependencyRelationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateParticipant(Participant participant, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(participant, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralization(Generalization generalization, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(generalization, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecializationRelationship(SpecializationRelationship specializationRelationship, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(specializationRelationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralizationRelationship(GeneralizationRelationship generalizationRelationship, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(generalizationRelationship, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAbstractParticipant(AbstractParticipant abstractParticipant, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(abstractParticipant, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAggregationParticipant(AggregationParticipant aggregationParticipant, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(aggregationParticipant, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNode(Node node, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(node, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateAggregation(Aggregation aggregation, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return validate_EveryDefaultConstraint(aggregation, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDependencyType(DependencyType dependencyType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateGeneralizationType(GeneralizationType generalizationType, DiagnosticChain diagnostics, Map<Object, Object> context)
	{
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator()
	{
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //EERValidator

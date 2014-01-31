/**
 */
package EER.impl;

import EER.AbstractParticipant;
import EER.AbstractRelationship;
import EER.Aggregation;
import EER.AggregationParticipant;
import EER.Attribute;
import EER.AttributedNode;
import EER.CandidateKey;
import EER.CompositeAttribute;
import EER.Constraint;
import EER.DependencyRelationship;
import EER.DependencyType;
import EER.Domain;
import EER.EERFactory;
import EER.EERPackage;
import EER.Entity;
import EER.EnumeratedLiteral;
import EER.EnumerationType;
import EER.Exclusion;
import EER.Exclusive;
import EER.Generalization;
import EER.GeneralizationRelationship;
import EER.GeneralizationType;
import EER.Inclusion;
import EER.Inclusiveness;
import EER.Node;
import EER.Participant;
import EER.PrimitiveType;
import EER.Project;
import EER.Relationship;
import EER.SingleAttribute;
import EER.SpecializationRelationship;
import EER.WeakEntity;

import EER.util.EERValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class EERPackageImpl extends EPackageImpl implements EERPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass projectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributedNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weakEntityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exclusiveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inclusivenessEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inclusionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass candidateKeyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singleAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratedLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dependencyRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass participantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalizationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass generalizationRelationshipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractParticipantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationParticipantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum dependencyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum generalizationTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see EER.EERPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EERPackageImpl()
	{
		super(eNS_URI, EERFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link EERPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EERPackage init()
	{
		if (isInited) return (EERPackage)EPackage.Registry.INSTANCE.getEPackage(EERPackage.eNS_URI);

		// Obtain or create and register package
		EERPackageImpl theEERPackage = (EERPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EERPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EERPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theEERPackage.createPackageContents();

		// Initialize created meta-data
		theEERPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theEERPackage, 
			 new EValidator.Descriptor()
			 {
				 public EValidator getEValidator()
				 {
					 return EERValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theEERPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EERPackage.eNS_URI, theEERPackage);
		return theEERPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProject()
	{
		return projectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProject_Name()
	{
		return (EAttribute)projectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Domains()
	{
		return (EReference)projectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProject_Nodes()
	{
		return (EReference)projectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributedNode()
	{
		return attributedNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributedNode_Name()
	{
		return (EAttribute)attributedNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntity()
	{
		return entityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_PrimaryKey()
	{
		return (EReference)entityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_CandidateKey()
	{
		return (EReference)entityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_DependencyRelationships()
	{
		return (EReference)entityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_IsSpecializedBy()
	{
		return (EReference)entityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntity_Specializes()
	{
		return (EReference)entityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeakEntity()
	{
		return weakEntityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint()
	{
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Name()
	{
		return (EAttribute)constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExclusive()
	{
		return exclusiveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExclusive_Source()
	{
		return (EReference)exclusiveEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExclusive_Target()
	{
		return (EReference)exclusiveEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInclusiveness()
	{
		return inclusivenessEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInclusiveness_Source()
	{
		return (EReference)inclusivenessEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInclusiveness_Target()
	{
		return (EReference)inclusivenessEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInclusiveness_LowerBound()
	{
		return (EAttribute)inclusivenessEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInclusiveness_UpperBound()
	{
		return (EAttribute)inclusivenessEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExclusion()
	{
		return exclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExclusion_Source()
	{
		return (EReference)exclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExclusion_Target()
	{
		return (EReference)exclusionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInclusion()
	{
		return inclusionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInclusion_Source()
	{
		return (EReference)inclusionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInclusion_Target()
	{
		return (EReference)inclusionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCandidateKey()
	{
		return candidateKeyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCandidateKey_Attributes()
	{
		return (EReference)candidateKeyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCandidateKey_Name()
	{
		return (EAttribute)candidateKeyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute()
	{
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Name()
	{
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Nullable()
	{
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeAttribute()
	{
		return compositeAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeAttribute_SinglesAttributes()
	{
		return (EReference)compositeAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleAttribute()
	{
		return singleAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleAttribute_Derivate()
	{
		return (EAttribute)singleAttributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleAttribute_Domain()
	{
		return (EReference)singleAttributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSingleAttribute_Multiplicity()
	{
		return (EAttribute)singleAttributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain()
	{
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_Name()
	{
		return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationType()
	{
		return enumerationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationType_Literals()
	{
		return (EReference)enumerationTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType()
	{
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumeratedLiteral()
	{
		return enumeratedLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumeratedLiteral_Name()
	{
		return (EAttribute)enumeratedLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractRelationship()
	{
		return abstractRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractRelationship_Participants()
	{
		return (EReference)abstractRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationship()
	{
		return relationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_ExclusionConstraints()
	{
		return (EReference)relationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationship_InclusionConstraints()
	{
		return (EReference)relationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDependencyRelationship()
	{
		return dependencyRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDependencyRelationship_Type()
	{
		return (EAttribute)dependencyRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParticipant()
	{
		return participantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_Target()
	{
		return (EReference)participantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_Source()
	{
		return (EReference)participantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_ExclusiveConstraint()
	{
		return (EReference)participantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParticipant_InclusivenessConstraint()
	{
		return (EReference)participantEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralization()
	{
		return generalizationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralization_Parent()
	{
		return (EReference)generalizationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralization_Childs()
	{
		return (EReference)generalizationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralization_Attribute()
	{
		return (EReference)generalizationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGeneralization_Type()
	{
		return (EAttribute)generalizationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecializationRelationship()
	{
		return specializationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecializationRelationship_Source()
	{
		return (EReference)specializationRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecializationRelationship_Relationship()
	{
		return (EReference)specializationRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGeneralizationRelationship()
	{
		return generalizationRelationshipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizationRelationship_Relationship()
	{
		return (EReference)generalizationRelationshipEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGeneralizationRelationship_Child()
	{
		return (EReference)generalizationRelationshipEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractParticipant()
	{
		return abstractParticipantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractParticipant_Role()
	{
		return (EAttribute)abstractParticipantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractParticipant_LowerBound()
	{
		return (EAttribute)abstractParticipantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractParticipant_UpperBound()
	{
		return (EAttribute)abstractParticipantEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregationParticipant()
	{
		return aggregationParticipantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregationParticipant_Target()
	{
		return (EReference)aggregationParticipantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregationParticipant_Source()
	{
		return (EReference)aggregationParticipantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode()
	{
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Attributes()
	{
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAggregation()
	{
		return aggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregation_Source()
	{
		return (EReference)aggregationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAggregation_Participants()
	{
		return (EReference)aggregationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getDependencyType()
	{
		return dependencyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGeneralizationType()
	{
		return generalizationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EERFactory getEERFactory()
	{
		return (EERFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		projectEClass = createEClass(PROJECT);
		createEAttribute(projectEClass, PROJECT__NAME);
		createEReference(projectEClass, PROJECT__DOMAINS);
		createEReference(projectEClass, PROJECT__NODES);

		attributedNodeEClass = createEClass(ATTRIBUTED_NODE);
		createEAttribute(attributedNodeEClass, ATTRIBUTED_NODE__NAME);

		entityEClass = createEClass(ENTITY);
		createEReference(entityEClass, ENTITY__PRIMARY_KEY);
		createEReference(entityEClass, ENTITY__CANDIDATE_KEY);
		createEReference(entityEClass, ENTITY__DEPENDENCY_RELATIONSHIPS);
		createEReference(entityEClass, ENTITY__IS_SPECIALIZED_BY);
		createEReference(entityEClass, ENTITY__SPECIALIZES);

		weakEntityEClass = createEClass(WEAK_ENTITY);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__NAME);

		exclusiveEClass = createEClass(EXCLUSIVE);
		createEReference(exclusiveEClass, EXCLUSIVE__SOURCE);
		createEReference(exclusiveEClass, EXCLUSIVE__TARGET);

		inclusivenessEClass = createEClass(INCLUSIVENESS);
		createEReference(inclusivenessEClass, INCLUSIVENESS__SOURCE);
		createEReference(inclusivenessEClass, INCLUSIVENESS__TARGET);
		createEAttribute(inclusivenessEClass, INCLUSIVENESS__LOWER_BOUND);
		createEAttribute(inclusivenessEClass, INCLUSIVENESS__UPPER_BOUND);

		exclusionEClass = createEClass(EXCLUSION);
		createEReference(exclusionEClass, EXCLUSION__SOURCE);
		createEReference(exclusionEClass, EXCLUSION__TARGET);

		inclusionEClass = createEClass(INCLUSION);
		createEReference(inclusionEClass, INCLUSION__SOURCE);
		createEReference(inclusionEClass, INCLUSION__TARGET);

		candidateKeyEClass = createEClass(CANDIDATE_KEY);
		createEReference(candidateKeyEClass, CANDIDATE_KEY__ATTRIBUTES);
		createEAttribute(candidateKeyEClass, CANDIDATE_KEY__NAME);

		attributeEClass = createEClass(ATTRIBUTE);
		createEAttribute(attributeEClass, ATTRIBUTE__NAME);
		createEAttribute(attributeEClass, ATTRIBUTE__NULLABLE);

		compositeAttributeEClass = createEClass(COMPOSITE_ATTRIBUTE);
		createEReference(compositeAttributeEClass, COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES);

		singleAttributeEClass = createEClass(SINGLE_ATTRIBUTE);
		createEAttribute(singleAttributeEClass, SINGLE_ATTRIBUTE__DERIVATE);
		createEReference(singleAttributeEClass, SINGLE_ATTRIBUTE__DOMAIN);
		createEAttribute(singleAttributeEClass, SINGLE_ATTRIBUTE__MULTIPLICITY);

		domainEClass = createEClass(DOMAIN);
		createEAttribute(domainEClass, DOMAIN__NAME);

		enumerationTypeEClass = createEClass(ENUMERATION_TYPE);
		createEReference(enumerationTypeEClass, ENUMERATION_TYPE__LITERALS);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);

		enumeratedLiteralEClass = createEClass(ENUMERATED_LITERAL);
		createEAttribute(enumeratedLiteralEClass, ENUMERATED_LITERAL__NAME);

		abstractRelationshipEClass = createEClass(ABSTRACT_RELATIONSHIP);
		createEReference(abstractRelationshipEClass, ABSTRACT_RELATIONSHIP__PARTICIPANTS);

		relationshipEClass = createEClass(RELATIONSHIP);
		createEReference(relationshipEClass, RELATIONSHIP__EXCLUSION_CONSTRAINTS);
		createEReference(relationshipEClass, RELATIONSHIP__INCLUSION_CONSTRAINTS);

		dependencyRelationshipEClass = createEClass(DEPENDENCY_RELATIONSHIP);
		createEAttribute(dependencyRelationshipEClass, DEPENDENCY_RELATIONSHIP__TYPE);

		participantEClass = createEClass(PARTICIPANT);
		createEReference(participantEClass, PARTICIPANT__TARGET);
		createEReference(participantEClass, PARTICIPANT__SOURCE);
		createEReference(participantEClass, PARTICIPANT__EXCLUSIVE_CONSTRAINT);
		createEReference(participantEClass, PARTICIPANT__INCLUSIVENESS_CONSTRAINT);

		generalizationEClass = createEClass(GENERALIZATION);
		createEReference(generalizationEClass, GENERALIZATION__PARENT);
		createEReference(generalizationEClass, GENERALIZATION__CHILDS);
		createEReference(generalizationEClass, GENERALIZATION__ATTRIBUTE);
		createEAttribute(generalizationEClass, GENERALIZATION__TYPE);

		specializationRelationshipEClass = createEClass(SPECIALIZATION_RELATIONSHIP);
		createEReference(specializationRelationshipEClass, SPECIALIZATION_RELATIONSHIP__SOURCE);
		createEReference(specializationRelationshipEClass, SPECIALIZATION_RELATIONSHIP__RELATIONSHIP);

		generalizationRelationshipEClass = createEClass(GENERALIZATION_RELATIONSHIP);
		createEReference(generalizationRelationshipEClass, GENERALIZATION_RELATIONSHIP__RELATIONSHIP);
		createEReference(generalizationRelationshipEClass, GENERALIZATION_RELATIONSHIP__CHILD);

		abstractParticipantEClass = createEClass(ABSTRACT_PARTICIPANT);
		createEAttribute(abstractParticipantEClass, ABSTRACT_PARTICIPANT__ROLE);
		createEAttribute(abstractParticipantEClass, ABSTRACT_PARTICIPANT__LOWER_BOUND);
		createEAttribute(abstractParticipantEClass, ABSTRACT_PARTICIPANT__UPPER_BOUND);

		aggregationParticipantEClass = createEClass(AGGREGATION_PARTICIPANT);
		createEReference(aggregationParticipantEClass, AGGREGATION_PARTICIPANT__TARGET);
		createEReference(aggregationParticipantEClass, AGGREGATION_PARTICIPANT__SOURCE);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__ATTRIBUTES);

		aggregationEClass = createEClass(AGGREGATION);
		createEReference(aggregationEClass, AGGREGATION__SOURCE);
		createEReference(aggregationEClass, AGGREGATION__PARTICIPANTS);

		// Create enums
		dependencyTypeEEnum = createEEnum(DEPENDENCY_TYPE);
		generalizationTypeEEnum = createEEnum(GENERALIZATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		entityEClass.getESuperTypes().add(this.getNode());
		weakEntityEClass.getESuperTypes().add(this.getEntity());
		exclusiveEClass.getESuperTypes().add(this.getConstraint());
		inclusivenessEClass.getESuperTypes().add(this.getConstraint());
		exclusionEClass.getESuperTypes().add(this.getConstraint());
		inclusionEClass.getESuperTypes().add(this.getConstraint());
		compositeAttributeEClass.getESuperTypes().add(this.getAttribute());
		singleAttributeEClass.getESuperTypes().add(this.getAttribute());
		enumerationTypeEClass.getESuperTypes().add(this.getDomain());
		primitiveTypeEClass.getESuperTypes().add(this.getDomain());
		abstractRelationshipEClass.getESuperTypes().add(this.getNode());
		relationshipEClass.getESuperTypes().add(this.getAbstractRelationship());
		dependencyRelationshipEClass.getESuperTypes().add(this.getAbstractRelationship());
		participantEClass.getESuperTypes().add(this.getAbstractParticipant());
		generalizationEClass.getESuperTypes().add(this.getAttributedNode());
		aggregationParticipantEClass.getESuperTypes().add(this.getAbstractParticipant());
		nodeEClass.getESuperTypes().add(this.getAttributedNode());
		aggregationEClass.getESuperTypes().add(this.getAttributedNode());

		// Initialize classes, features, and operations; add parameters
		initEClass(projectEClass, Project.class, "Project", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProject_Name(), ecorePackage.getEString(), "name", null, 1, 1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Domains(), this.getDomain(), null, "domains", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProject_Nodes(), this.getAttributedNode(), null, "nodes", null, 0, -1, Project.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributedNodeEClass, AttributedNode.class, "AttributedNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributedNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, AttributedNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entityEClass, Entity.class, "Entity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntity_PrimaryKey(), this.getCandidateKey(), null, "primaryKey", null, 0, 1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_CandidateKey(), this.getCandidateKey(), null, "candidateKey", null, 1, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_DependencyRelationships(), this.getDependencyRelationship(), null, "dependencyRelationships", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_IsSpecializedBy(), this.getSpecializationRelationship(), this.getSpecializationRelationship_Source(), "isSpecializedBy", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEntity_Specializes(), this.getGeneralizationRelationship(), this.getGeneralizationRelationship_Child(), "specializes", null, 0, -1, Entity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(weakEntityEClass, WeakEntity.class, "WeakEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Name(), ecorePackage.getEString(), "name", null, 0, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exclusiveEClass, Exclusive.class, "Exclusive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExclusive_Source(), this.getParticipant(), this.getParticipant_ExclusiveConstraint(), "source", null, 1, 1, Exclusive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExclusive_Target(), this.getParticipant(), null, "target", null, 1, 1, Exclusive.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inclusivenessEClass, Inclusiveness.class, "Inclusiveness", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInclusiveness_Source(), this.getParticipant(), this.getParticipant_InclusivenessConstraint(), "source", null, 1, 1, Inclusiveness.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInclusiveness_Target(), this.getParticipant(), null, "target", null, 1, 1, Inclusiveness.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInclusiveness_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, Inclusiveness.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInclusiveness_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 0, 1, Inclusiveness.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exclusionEClass, Exclusion.class, "Exclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExclusion_Source(), this.getRelationship(), this.getRelationship_ExclusionConstraints(), "source", null, 1, 1, Exclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExclusion_Target(), this.getRelationship(), null, "target", null, 1, 1, Exclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inclusionEClass, Inclusion.class, "Inclusion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInclusion_Source(), this.getRelationship(), this.getRelationship_InclusionConstraints(), "source", null, 1, 1, Inclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInclusion_Target(), this.getRelationship(), null, "target", null, 1, 1, Inclusion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(candidateKeyEClass, CandidateKey.class, "CandidateKey", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCandidateKey_Attributes(), this.getAttribute(), null, "attributes", null, 1, -1, CandidateKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCandidateKey_Name(), ecorePackage.getEString(), "name", null, 0, 1, CandidateKey.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttribute_Name(), ecorePackage.getEString(), "name", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Nullable(), ecorePackage.getEBoolean(), "nullable", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeAttributeEClass, CompositeAttribute.class, "CompositeAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeAttribute_SinglesAttributes(), this.getAttribute(), null, "singlesAttributes", null, 2, -1, CompositeAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(singleAttributeEClass, SingleAttribute.class, "SingleAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSingleAttribute_Derivate(), ecorePackage.getEBoolean(), "derivate", null, 1, 1, SingleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSingleAttribute_Domain(), this.getDomain(), null, "domain", null, 1, 1, SingleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSingleAttribute_Multiplicity(), ecorePackage.getEInt(), "multiplicity", "1", 1, 1, SingleAttribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(domainEClass, Domain.class, "Domain", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomain_Name(), ecorePackage.getEString(), "name", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumerationTypeEClass, EnumerationType.class, "EnumerationType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerationType_Literals(), this.getEnumeratedLiteral(), null, "literals", null, 1, -1, EnumerationType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(enumeratedLiteralEClass, EnumeratedLiteral.class, "EnumeratedLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumeratedLiteral_Name(), ecorePackage.getEString(), "name", null, 1, 1, EnumeratedLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractRelationshipEClass, AbstractRelationship.class, "AbstractRelationship", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractRelationship_Participants(), this.getParticipant(), this.getParticipant_Source(), "participants", null, 2, -1, AbstractRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationshipEClass, Relationship.class, "Relationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationship_ExclusionConstraints(), this.getExclusion(), this.getExclusion_Source(), "exclusionConstraints", null, 0, -1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationship_InclusionConstraints(), this.getInclusion(), this.getInclusion_Source(), "inclusionConstraints", null, 0, -1, Relationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dependencyRelationshipEClass, DependencyRelationship.class, "DependencyRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDependencyRelationship_Type(), this.getDependencyType(), "type", null, 1, 1, DependencyRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(participantEClass, Participant.class, "Participant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParticipant_Target(), this.getEntity(), null, "target", null, 1, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParticipant_Source(), this.getAbstractRelationship(), this.getAbstractRelationship_Participants(), "source", null, 1, 1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParticipant_ExclusiveConstraint(), this.getExclusive(), this.getExclusive_Source(), "exclusiveConstraint", null, 0, -1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParticipant_InclusivenessConstraint(), this.getInclusiveness(), this.getInclusiveness_Source(), "inclusivenessConstraint", null, 0, -1, Participant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generalizationEClass, Generalization.class, "Generalization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneralization_Parent(), this.getSpecializationRelationship(), this.getSpecializationRelationship_Relationship(), "parent", null, 1, 1, Generalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralization_Childs(), this.getGeneralizationRelationship(), this.getGeneralizationRelationship_Relationship(), "childs", null, 1, -1, Generalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralization_Attribute(), this.getAttribute(), null, "attribute", null, 0, 1, Generalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGeneralization_Type(), this.getGeneralizationType(), "type", null, 1, 1, Generalization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializationRelationshipEClass, SpecializationRelationship.class, "SpecializationRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializationRelationship_Source(), this.getEntity(), this.getEntity_IsSpecializedBy(), "source", null, 1, 1, SpecializationRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationRelationship_Relationship(), this.getGeneralization(), this.getGeneralization_Parent(), "relationship", null, 1, 1, SpecializationRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(generalizationRelationshipEClass, GeneralizationRelationship.class, "GeneralizationRelationship", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGeneralizationRelationship_Relationship(), this.getGeneralization(), this.getGeneralization_Childs(), "relationship", null, 1, 1, GeneralizationRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getGeneralizationRelationship_Child(), this.getEntity(), this.getEntity_Specializes(), "child", null, 1, 1, GeneralizationRelationship.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractParticipantEClass, AbstractParticipant.class, "AbstractParticipant", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractParticipant_Role(), ecorePackage.getEString(), "role", null, 0, 1, AbstractParticipant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractParticipant_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 1, 1, AbstractParticipant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractParticipant_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 0, 1, AbstractParticipant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregationParticipantEClass, AggregationParticipant.class, "AggregationParticipant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregationParticipant_Target(), this.getNode(), null, "target", null, 0, 1, AggregationParticipant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregationParticipant_Source(), this.getAggregation(), this.getAggregation_Participants(), "source", null, 1, 1, AggregationParticipant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_Attributes(), this.getAttribute(), null, "attributes", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(aggregationEClass, Aggregation.class, "Aggregation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregation_Source(), this.getEntity(), null, "source", null, 1, 1, Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregation_Participants(), this.getAggregationParticipant(), this.getAggregationParticipant_Source(), "participants", null, 1, -1, Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(dependencyTypeEEnum, DependencyType.class, "DependencyType");
		addEEnumLiteral(dependencyTypeEEnum, DependencyType.ID);
		addEEnumLiteral(dependencyTypeEEnum, DependencyType.E);

		initEEnum(generalizationTypeEEnum, GeneralizationType.class, "GeneralizationType");
		addEEnumLiteral(generalizationTypeEEnum, GeneralizationType.TOTAL_OVERLAPPING);
		addEEnumLiteral(generalizationTypeEEnum, GeneralizationType.TOTAL_DISJOINT);
		addEEnumLiteral(generalizationTypeEEnum, GeneralizationType.PARTIAL_OVERLAPPING);
		addEEnumLiteral(generalizationTypeEEnum, GeneralizationType.PARTIAL_DISJOINT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/Ecore";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] 
		   {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL",
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL"
		   });		
		addAnnotation
		  (entityEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "PrimaryKeysOCL"
		   });			
		addAnnotation
		  (exclusiveEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "SourceTarget"
		   });			
		addAnnotation
		  (inclusivenessEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "SourceTarget"
		   });			
		addAnnotation
		  (exclusionEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "SourceTarget"
		   });			
		addAnnotation
		  (inclusionEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "SourceTarget"
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL";				
		addAnnotation
		  (entityEClass, 
		   source, 
		   new String[] 
		   {
			 "PrimaryKeysOCL", "\n\t\t\tself.isSpecializedBy -> size() = 0 and \n\t\t\tself.specializes -> size() = 0 \n\t\t\t  implies  self.primaryKey -> size() = 1"
		   });			
		addAnnotation
		  (exclusiveEClass, 
		   source, 
		   new String[] 
		   {
			 "SourceTarget", "\n\t\t\tself.target <> self.source"
		   });			
		addAnnotation
		  (inclusivenessEClass, 
		   source, 
		   new String[] 
		   {
			 "SourceTarget", "\n\t\t\tself.target <> self.source"
		   });			
		addAnnotation
		  (exclusionEClass, 
		   source, 
		   new String[] 
		   {
			 "SourceTarget", "\n\t\t\tself.target <> self.source"
		   });			
		addAnnotation
		  (inclusionEClass, 
		   source, 
		   new String[] 
		   {
			 "SourceTarget", "\n\t\t\tself.target <> self.source"
		   });
	}

} //EERPackageImpl

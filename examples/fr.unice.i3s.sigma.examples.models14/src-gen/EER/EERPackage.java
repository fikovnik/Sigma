/**
 */
package EER;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see EER.EERFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface EERPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "EER";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://EER/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "EER";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EERPackage eINSTANCE = EER.impl.EERPackageImpl.init();

	/**
	 * The meta object id for the '{@link EER.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.ProjectImpl
	 * @see EER.impl.EERPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Domains</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__DOMAINS = 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NODES = 2;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.AttributedNodeImpl <em>Attributed Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.AttributedNodeImpl
	 * @see EER.impl.EERPackageImpl#getAttributedNode()
	 * @generated
	 */
	int ATTRIBUTED_NODE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTED_NODE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Attributed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTED_NODE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Attributed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTED_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.NodeImpl
	 * @see EER.impl.EERPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = ATTRIBUTED_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ATTRIBUTES = ATTRIBUTED_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = ATTRIBUTED_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = ATTRIBUTED_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.EntityImpl <em>Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.EntityImpl
	 * @see EER.impl.EERPackageImpl#getEntity()
	 * @generated
	 */
	int ENTITY = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__ATTRIBUTES = NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__PRIMARY_KEY = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Candidate Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__CANDIDATE_KEY = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Dependency Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__DEPENDENCY_RELATIONSHIPS = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Specialized By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__IS_SPECIALIZED_BY = NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Specializes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY__SPECIALIZES = NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_FEATURE_COUNT = NODE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.WeakEntityImpl <em>Weak Entity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.WeakEntityImpl
	 * @see EER.impl.EERPackageImpl#getWeakEntity()
	 * @generated
	 */
	int WEAK_ENTITY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY__NAME = ENTITY__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY__ATTRIBUTES = ENTITY__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY__PRIMARY_KEY = ENTITY__PRIMARY_KEY;

	/**
	 * The feature id for the '<em><b>Candidate Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY__CANDIDATE_KEY = ENTITY__CANDIDATE_KEY;

	/**
	 * The feature id for the '<em><b>Dependency Relationships</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY__DEPENDENCY_RELATIONSHIPS = ENTITY__DEPENDENCY_RELATIONSHIPS;

	/**
	 * The feature id for the '<em><b>Is Specialized By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY__IS_SPECIALIZED_BY = ENTITY__IS_SPECIALIZED_BY;

	/**
	 * The feature id for the '<em><b>Specializes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY__SPECIALIZES = ENTITY__SPECIALIZES;

	/**
	 * The number of structural features of the '<em>Weak Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Weak Entity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_ENTITY_OPERATION_COUNT = ENTITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.ConstraintImpl
	 * @see EER.impl.EERPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.ExclusiveImpl <em>Exclusive</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.ExclusiveImpl
	 * @see EER.impl.EERPackageImpl#getExclusive()
	 * @generated
	 */
	int EXCLUSIVE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE__SOURCE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE__TARGET = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Exclusive</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSIVE_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.InclusivenessImpl <em>Inclusiveness</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.InclusivenessImpl
	 * @see EER.impl.EERPackageImpl#getInclusiveness()
	 * @generated
	 */
	int INCLUSIVENESS = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVENESS__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVENESS__SOURCE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVENESS__TARGET = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVENESS__LOWER_BOUND = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVENESS__UPPER_BOUND = CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Inclusiveness</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVENESS_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Inclusiveness</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSIVENESS_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.ExclusionImpl <em>Exclusion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.ExclusionImpl
	 * @see EER.impl.EERPackageImpl#getExclusion()
	 * @generated
	 */
	int EXCLUSION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION__SOURCE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION__TARGET = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Exclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.InclusionImpl <em>Inclusion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.InclusionImpl
	 * @see EER.impl.EERPackageImpl#getInclusion()
	 * @generated
	 */
	int INCLUSION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSION__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSION__SOURCE = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSION__TARGET = CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Inclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSION_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Inclusion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUSION_OPERATION_COUNT = CONSTRAINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.CandidateKeyImpl <em>Candidate Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.CandidateKeyImpl
	 * @see EER.impl.EERPackageImpl#getCandidateKey()
	 * @generated
	 */
	int CANDIDATE_KEY = 9;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATE_KEY__ATTRIBUTES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATE_KEY__NAME = 1;

	/**
	 * The number of structural features of the '<em>Candidate Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATE_KEY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Candidate Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CANDIDATE_KEY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.AttributeImpl
	 * @see EER.impl.EERPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NULLABLE = 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.CompositeAttributeImpl <em>Composite Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.CompositeAttributeImpl
	 * @see EER.impl.EERPackageImpl#getCompositeAttribute()
	 * @generated
	 */
	int COMPOSITE_ATTRIBUTE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ATTRIBUTE__NULLABLE = ATTRIBUTE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Singles Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composite Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.SingleAttributeImpl <em>Single Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.SingleAttributeImpl
	 * @see EER.impl.EERPackageImpl#getSingleAttribute()
	 * @generated
	 */
	int SINGLE_ATTRIBUTE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ATTRIBUTE__NULLABLE = ATTRIBUTE__NULLABLE;

	/**
	 * The feature id for the '<em><b>Derivate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ATTRIBUTE__DERIVATE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ATTRIBUTE__DOMAIN = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Multiplicity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ATTRIBUTE__MULTIPLICITY = ATTRIBUTE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Single Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Single Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLE_ATTRIBUTE_OPERATION_COUNT = ATTRIBUTE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.DomainImpl
	 * @see EER.impl.EERPackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__NAME = 0;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.EnumerationTypeImpl
	 * @see EER.impl.EERPackageImpl#getEnumerationType()
	 * @generated
	 */
	int ENUMERATION_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__NAME = DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Literals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE__LITERALS = DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Enumeration Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_TYPE_OPERATION_COUNT = DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.PrimitiveTypeImpl
	 * @see EER.impl.EERPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE__NAME = DOMAIN__NAME;

	/**
	 * The number of structural features of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Primitive Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_TYPE_OPERATION_COUNT = DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.EnumeratedLiteralImpl <em>Enumerated Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.EnumeratedLiteralImpl
	 * @see EER.impl.EERPackageImpl#getEnumeratedLiteral()
	 * @generated
	 */
	int ENUMERATED_LITERAL = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_LITERAL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Enumerated Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_LITERAL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Enumerated Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATED_LITERAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.AbstractRelationshipImpl <em>Abstract Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.AbstractRelationshipImpl
	 * @see EER.impl.EERPackageImpl#getAbstractRelationship()
	 * @generated
	 */
	int ABSTRACT_RELATIONSHIP = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATIONSHIP__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATIONSHIP__ATTRIBUTES = NODE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATIONSHIP__PARTICIPANTS = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATIONSHIP_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Abstract Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RELATIONSHIP_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.RelationshipImpl <em>Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.RelationshipImpl
	 * @see EER.impl.EERPackageImpl#getRelationship()
	 * @generated
	 */
	int RELATIONSHIP = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__NAME = ABSTRACT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__ATTRIBUTES = ABSTRACT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__PARTICIPANTS = ABSTRACT_RELATIONSHIP__PARTICIPANTS;

	/**
	 * The feature id for the '<em><b>Exclusion Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__EXCLUSION_CONSTRAINTS = ABSTRACT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inclusion Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP__INCLUSION_CONSTRAINTS = ABSTRACT_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_FEATURE_COUNT = ABSTRACT_RELATIONSHIP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONSHIP_OPERATION_COUNT = ABSTRACT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.DependencyRelationshipImpl <em>Dependency Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.DependencyRelationshipImpl
	 * @see EER.impl.EERPackageImpl#getDependencyRelationship()
	 * @generated
	 */
	int DEPENDENCY_RELATIONSHIP = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATIONSHIP__NAME = ABSTRACT_RELATIONSHIP__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATIONSHIP__ATTRIBUTES = ABSTRACT_RELATIONSHIP__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATIONSHIP__PARTICIPANTS = ABSTRACT_RELATIONSHIP__PARTICIPANTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATIONSHIP__TYPE = ABSTRACT_RELATIONSHIP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dependency Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATIONSHIP_FEATURE_COUNT = ABSTRACT_RELATIONSHIP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Dependency Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_RELATIONSHIP_OPERATION_COUNT = ABSTRACT_RELATIONSHIP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.AbstractParticipantImpl <em>Abstract Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.AbstractParticipantImpl
	 * @see EER.impl.EERPackageImpl#getAbstractParticipant()
	 * @generated
	 */
	int ABSTRACT_PARTICIPANT = 24;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PARTICIPANT__ROLE = 0;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PARTICIPANT__LOWER_BOUND = 1;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PARTICIPANT__UPPER_BOUND = 2;

	/**
	 * The number of structural features of the '<em>Abstract Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PARTICIPANT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abstract Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_PARTICIPANT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.ParticipantImpl <em>Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.ParticipantImpl
	 * @see EER.impl.EERPackageImpl#getParticipant()
	 * @generated
	 */
	int PARTICIPANT = 20;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__ROLE = ABSTRACT_PARTICIPANT__ROLE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__LOWER_BOUND = ABSTRACT_PARTICIPANT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__UPPER_BOUND = ABSTRACT_PARTICIPANT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__TARGET = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__SOURCE = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exclusive Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__EXCLUSIVE_CONSTRAINT = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Inclusiveness Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT__INCLUSIVENESS_CONSTRAINT = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_FEATURE_COUNT = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_OPERATION_COUNT = ABSTRACT_PARTICIPANT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.GeneralizationImpl <em>Generalization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.GeneralizationImpl
	 * @see EER.impl.EERPackageImpl#getGeneralization()
	 * @generated
	 */
	int GENERALIZATION = 21;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION__NAME = ATTRIBUTED_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION__PARENT = ATTRIBUTED_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Childs</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION__CHILDS = ATTRIBUTED_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attribute</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION__ATTRIBUTE = ATTRIBUTED_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION__TYPE = ATTRIBUTED_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Generalization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_FEATURE_COUNT = ATTRIBUTED_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Generalization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_OPERATION_COUNT = ATTRIBUTED_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.SpecializationRelationshipImpl <em>Specialization Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.SpecializationRelationshipImpl
	 * @see EER.impl.EERPackageImpl#getSpecializationRelationship()
	 * @generated
	 */
	int SPECIALIZATION_RELATIONSHIP = 22;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_RELATIONSHIP__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_RELATIONSHIP__RELATIONSHIP = 1;

	/**
	 * The number of structural features of the '<em>Specialization Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_RELATIONSHIP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Specialization Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPECIALIZATION_RELATIONSHIP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.GeneralizationRelationshipImpl <em>Generalization Relationship</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.GeneralizationRelationshipImpl
	 * @see EER.impl.EERPackageImpl#getGeneralizationRelationship()
	 * @generated
	 */
	int GENERALIZATION_RELATIONSHIP = 23;

	/**
	 * The feature id for the '<em><b>Relationship</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_RELATIONSHIP__RELATIONSHIP = 0;

	/**
	 * The feature id for the '<em><b>Child</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_RELATIONSHIP__CHILD = 1;

	/**
	 * The number of structural features of the '<em>Generalization Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_RELATIONSHIP_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Generalization Relationship</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GENERALIZATION_RELATIONSHIP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link EER.impl.AggregationParticipantImpl <em>Aggregation Participant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.AggregationParticipantImpl
	 * @see EER.impl.EERPackageImpl#getAggregationParticipant()
	 * @generated
	 */
	int AGGREGATION_PARTICIPANT = 25;

	/**
	 * The feature id for the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_PARTICIPANT__ROLE = ABSTRACT_PARTICIPANT__ROLE;

	/**
	 * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_PARTICIPANT__LOWER_BOUND = ABSTRACT_PARTICIPANT__LOWER_BOUND;

	/**
	 * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_PARTICIPANT__UPPER_BOUND = ABSTRACT_PARTICIPANT__UPPER_BOUND;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_PARTICIPANT__TARGET = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_PARTICIPANT__SOURCE = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aggregation Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_PARTICIPANT_FEATURE_COUNT = ABSTRACT_PARTICIPANT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Aggregation Participant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_PARTICIPANT_OPERATION_COUNT = ABSTRACT_PARTICIPANT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.impl.AggregationImpl <em>Aggregation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.impl.AggregationImpl
	 * @see EER.impl.EERPackageImpl#getAggregation()
	 * @generated
	 */
	int AGGREGATION = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__NAME = ATTRIBUTED_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__SOURCE = ATTRIBUTED_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Participants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__PARTICIPANTS = ATTRIBUTED_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Aggregation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FEATURE_COUNT = ATTRIBUTED_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Aggregation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_OPERATION_COUNT = ATTRIBUTED_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link EER.DependencyType <em>Dependency Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.DependencyType
	 * @see EER.impl.EERPackageImpl#getDependencyType()
	 * @generated
	 */
	int DEPENDENCY_TYPE = 28;

	/**
	 * The meta object id for the '{@link EER.GeneralizationType <em>Generalization Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see EER.GeneralizationType
	 * @see EER.impl.EERPackageImpl#getGeneralizationType()
	 * @generated
	 */
	int GENERALIZATION_TYPE = 29;


	/**
	 * Returns the meta object for class '{@link EER.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see EER.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link EER.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EER.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Project#getDomains <em>Domains</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domains</em>'.
	 * @see EER.Project#getDomains()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Domains();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Project#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see EER.Project#getNodes()
	 * @see #getProject()
	 * @generated
	 */
	EReference getProject_Nodes();

	/**
	 * Returns the meta object for class '{@link EER.AttributedNode <em>Attributed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attributed Node</em>'.
	 * @see EER.AttributedNode
	 * @generated
	 */
	EClass getAttributedNode();

	/**
	 * Returns the meta object for the attribute '{@link EER.AttributedNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EER.AttributedNode#getName()
	 * @see #getAttributedNode()
	 * @generated
	 */
	EAttribute getAttributedNode_Name();

	/**
	 * Returns the meta object for class '{@link EER.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity</em>'.
	 * @see EER.Entity
	 * @generated
	 */
	EClass getEntity();

	/**
	 * Returns the meta object for the reference '{@link EER.Entity#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Key</em>'.
	 * @see EER.Entity#getPrimaryKey()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_PrimaryKey();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Entity#getCandidateKey <em>Candidate Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Candidate Key</em>'.
	 * @see EER.Entity#getCandidateKey()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_CandidateKey();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Entity#getDependencyRelationships <em>Dependency Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependency Relationships</em>'.
	 * @see EER.Entity#getDependencyRelationships()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_DependencyRelationships();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Entity#getIsSpecializedBy <em>Is Specialized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Is Specialized By</em>'.
	 * @see EER.Entity#getIsSpecializedBy()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_IsSpecializedBy();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Entity#getSpecializes <em>Specializes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Specializes</em>'.
	 * @see EER.Entity#getSpecializes()
	 * @see #getEntity()
	 * @generated
	 */
	EReference getEntity_Specializes();

	/**
	 * Returns the meta object for class '{@link EER.WeakEntity <em>Weak Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weak Entity</em>'.
	 * @see EER.WeakEntity
	 * @generated
	 */
	EClass getWeakEntity();

	/**
	 * Returns the meta object for class '{@link EER.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see EER.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the attribute '{@link EER.Constraint#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EER.Constraint#getName()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Name();

	/**
	 * Returns the meta object for class '{@link EER.Exclusive <em>Exclusive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exclusive</em>'.
	 * @see EER.Exclusive
	 * @generated
	 */
	EClass getExclusive();

	/**
	 * Returns the meta object for the container reference '{@link EER.Exclusive#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see EER.Exclusive#getSource()
	 * @see #getExclusive()
	 * @generated
	 */
	EReference getExclusive_Source();

	/**
	 * Returns the meta object for the reference '{@link EER.Exclusive#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see EER.Exclusive#getTarget()
	 * @see #getExclusive()
	 * @generated
	 */
	EReference getExclusive_Target();

	/**
	 * Returns the meta object for class '{@link EER.Inclusiveness <em>Inclusiveness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inclusiveness</em>'.
	 * @see EER.Inclusiveness
	 * @generated
	 */
	EClass getInclusiveness();

	/**
	 * Returns the meta object for the container reference '{@link EER.Inclusiveness#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see EER.Inclusiveness#getSource()
	 * @see #getInclusiveness()
	 * @generated
	 */
	EReference getInclusiveness_Source();

	/**
	 * Returns the meta object for the reference '{@link EER.Inclusiveness#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see EER.Inclusiveness#getTarget()
	 * @see #getInclusiveness()
	 * @generated
	 */
	EReference getInclusiveness_Target();

	/**
	 * Returns the meta object for the attribute '{@link EER.Inclusiveness#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see EER.Inclusiveness#getLowerBound()
	 * @see #getInclusiveness()
	 * @generated
	 */
	EAttribute getInclusiveness_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link EER.Inclusiveness#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see EER.Inclusiveness#getUpperBound()
	 * @see #getInclusiveness()
	 * @generated
	 */
	EAttribute getInclusiveness_UpperBound();

	/**
	 * Returns the meta object for class '{@link EER.Exclusion <em>Exclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exclusion</em>'.
	 * @see EER.Exclusion
	 * @generated
	 */
	EClass getExclusion();

	/**
	 * Returns the meta object for the container reference '{@link EER.Exclusion#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see EER.Exclusion#getSource()
	 * @see #getExclusion()
	 * @generated
	 */
	EReference getExclusion_Source();

	/**
	 * Returns the meta object for the reference '{@link EER.Exclusion#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see EER.Exclusion#getTarget()
	 * @see #getExclusion()
	 * @generated
	 */
	EReference getExclusion_Target();

	/**
	 * Returns the meta object for class '{@link EER.Inclusion <em>Inclusion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inclusion</em>'.
	 * @see EER.Inclusion
	 * @generated
	 */
	EClass getInclusion();

	/**
	 * Returns the meta object for the container reference '{@link EER.Inclusion#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see EER.Inclusion#getSource()
	 * @see #getInclusion()
	 * @generated
	 */
	EReference getInclusion_Source();

	/**
	 * Returns the meta object for the reference '{@link EER.Inclusion#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see EER.Inclusion#getTarget()
	 * @see #getInclusion()
	 * @generated
	 */
	EReference getInclusion_Target();

	/**
	 * Returns the meta object for class '{@link EER.CandidateKey <em>Candidate Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Candidate Key</em>'.
	 * @see EER.CandidateKey
	 * @generated
	 */
	EClass getCandidateKey();

	/**
	 * Returns the meta object for the reference list '{@link EER.CandidateKey#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see EER.CandidateKey#getAttributes()
	 * @see #getCandidateKey()
	 * @generated
	 */
	EReference getCandidateKey_Attributes();

	/**
	 * Returns the meta object for the attribute '{@link EER.CandidateKey#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EER.CandidateKey#getName()
	 * @see #getCandidateKey()
	 * @generated
	 */
	EAttribute getCandidateKey_Name();

	/**
	 * Returns the meta object for class '{@link EER.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see EER.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link EER.Attribute#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EER.Attribute#getName()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Name();

	/**
	 * Returns the meta object for the attribute '{@link EER.Attribute#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see EER.Attribute#isNullable()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Nullable();

	/**
	 * Returns the meta object for class '{@link EER.CompositeAttribute <em>Composite Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Attribute</em>'.
	 * @see EER.CompositeAttribute
	 * @generated
	 */
	EClass getCompositeAttribute();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.CompositeAttribute#getSinglesAttributes <em>Singles Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Singles Attributes</em>'.
	 * @see EER.CompositeAttribute#getSinglesAttributes()
	 * @see #getCompositeAttribute()
	 * @generated
	 */
	EReference getCompositeAttribute_SinglesAttributes();

	/**
	 * Returns the meta object for class '{@link EER.SingleAttribute <em>Single Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Single Attribute</em>'.
	 * @see EER.SingleAttribute
	 * @generated
	 */
	EClass getSingleAttribute();

	/**
	 * Returns the meta object for the attribute '{@link EER.SingleAttribute#isDerivate <em>Derivate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Derivate</em>'.
	 * @see EER.SingleAttribute#isDerivate()
	 * @see #getSingleAttribute()
	 * @generated
	 */
	EAttribute getSingleAttribute_Derivate();

	/**
	 * Returns the meta object for the reference '{@link EER.SingleAttribute#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see EER.SingleAttribute#getDomain()
	 * @see #getSingleAttribute()
	 * @generated
	 */
	EReference getSingleAttribute_Domain();

	/**
	 * Returns the meta object for the attribute '{@link EER.SingleAttribute#getMultiplicity <em>Multiplicity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Multiplicity</em>'.
	 * @see EER.SingleAttribute#getMultiplicity()
	 * @see #getSingleAttribute()
	 * @generated
	 */
	EAttribute getSingleAttribute_Multiplicity();

	/**
	 * Returns the meta object for class '{@link EER.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see EER.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the attribute '{@link EER.Domain#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EER.Domain#getName()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_Name();

	/**
	 * Returns the meta object for class '{@link EER.EnumerationType <em>Enumeration Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Type</em>'.
	 * @see EER.EnumerationType
	 * @generated
	 */
	EClass getEnumerationType();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.EnumerationType#getLiterals <em>Literals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literals</em>'.
	 * @see EER.EnumerationType#getLiterals()
	 * @see #getEnumerationType()
	 * @generated
	 */
	EReference getEnumerationType_Literals();

	/**
	 * Returns the meta object for class '{@link EER.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Type</em>'.
	 * @see EER.PrimitiveType
	 * @generated
	 */
	EClass getPrimitiveType();

	/**
	 * Returns the meta object for class '{@link EER.EnumeratedLiteral <em>Enumerated Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumerated Literal</em>'.
	 * @see EER.EnumeratedLiteral
	 * @generated
	 */
	EClass getEnumeratedLiteral();

	/**
	 * Returns the meta object for the attribute '{@link EER.EnumeratedLiteral#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see EER.EnumeratedLiteral#getName()
	 * @see #getEnumeratedLiteral()
	 * @generated
	 */
	EAttribute getEnumeratedLiteral_Name();

	/**
	 * Returns the meta object for class '{@link EER.AbstractRelationship <em>Abstract Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Relationship</em>'.
	 * @see EER.AbstractRelationship
	 * @generated
	 */
	EClass getAbstractRelationship();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.AbstractRelationship#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Participants</em>'.
	 * @see EER.AbstractRelationship#getParticipants()
	 * @see #getAbstractRelationship()
	 * @generated
	 */
	EReference getAbstractRelationship_Participants();

	/**
	 * Returns the meta object for class '{@link EER.Relationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relationship</em>'.
	 * @see EER.Relationship
	 * @generated
	 */
	EClass getRelationship();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Relationship#getExclusionConstraints <em>Exclusion Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exclusion Constraints</em>'.
	 * @see EER.Relationship#getExclusionConstraints()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_ExclusionConstraints();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Relationship#getInclusionConstraints <em>Inclusion Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inclusion Constraints</em>'.
	 * @see EER.Relationship#getInclusionConstraints()
	 * @see #getRelationship()
	 * @generated
	 */
	EReference getRelationship_InclusionConstraints();

	/**
	 * Returns the meta object for class '{@link EER.DependencyRelationship <em>Dependency Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Relationship</em>'.
	 * @see EER.DependencyRelationship
	 * @generated
	 */
	EClass getDependencyRelationship();

	/**
	 * Returns the meta object for the attribute '{@link EER.DependencyRelationship#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see EER.DependencyRelationship#getType()
	 * @see #getDependencyRelationship()
	 * @generated
	 */
	EAttribute getDependencyRelationship_Type();

	/**
	 * Returns the meta object for class '{@link EER.Participant <em>Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Participant</em>'.
	 * @see EER.Participant
	 * @generated
	 */
	EClass getParticipant();

	/**
	 * Returns the meta object for the reference '{@link EER.Participant#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see EER.Participant#getTarget()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_Target();

	/**
	 * Returns the meta object for the container reference '{@link EER.Participant#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see EER.Participant#getSource()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_Source();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Participant#getExclusiveConstraint <em>Exclusive Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Exclusive Constraint</em>'.
	 * @see EER.Participant#getExclusiveConstraint()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_ExclusiveConstraint();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Participant#getInclusivenessConstraint <em>Inclusiveness Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inclusiveness Constraint</em>'.
	 * @see EER.Participant#getInclusivenessConstraint()
	 * @see #getParticipant()
	 * @generated
	 */
	EReference getParticipant_InclusivenessConstraint();

	/**
	 * Returns the meta object for class '{@link EER.Generalization <em>Generalization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generalization</em>'.
	 * @see EER.Generalization
	 * @generated
	 */
	EClass getGeneralization();

	/**
	 * Returns the meta object for the reference '{@link EER.Generalization#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see EER.Generalization#getParent()
	 * @see #getGeneralization()
	 * @generated
	 */
	EReference getGeneralization_Parent();

	/**
	 * Returns the meta object for the reference list '{@link EER.Generalization#getChilds <em>Childs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Childs</em>'.
	 * @see EER.Generalization#getChilds()
	 * @see #getGeneralization()
	 * @generated
	 */
	EReference getGeneralization_Childs();

	/**
	 * Returns the meta object for the containment reference '{@link EER.Generalization#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Attribute</em>'.
	 * @see EER.Generalization#getAttribute()
	 * @see #getGeneralization()
	 * @generated
	 */
	EReference getGeneralization_Attribute();

	/**
	 * Returns the meta object for the attribute '{@link EER.Generalization#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see EER.Generalization#getType()
	 * @see #getGeneralization()
	 * @generated
	 */
	EAttribute getGeneralization_Type();

	/**
	 * Returns the meta object for class '{@link EER.SpecializationRelationship <em>Specialization Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Specialization Relationship</em>'.
	 * @see EER.SpecializationRelationship
	 * @generated
	 */
	EClass getSpecializationRelationship();

	/**
	 * Returns the meta object for the container reference '{@link EER.SpecializationRelationship#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see EER.SpecializationRelationship#getSource()
	 * @see #getSpecializationRelationship()
	 * @generated
	 */
	EReference getSpecializationRelationship_Source();

	/**
	 * Returns the meta object for the reference '{@link EER.SpecializationRelationship#getRelationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Relationship</em>'.
	 * @see EER.SpecializationRelationship#getRelationship()
	 * @see #getSpecializationRelationship()
	 * @generated
	 */
	EReference getSpecializationRelationship_Relationship();

	/**
	 * Returns the meta object for class '{@link EER.GeneralizationRelationship <em>Generalization Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Generalization Relationship</em>'.
	 * @see EER.GeneralizationRelationship
	 * @generated
	 */
	EClass getGeneralizationRelationship();

	/**
	 * Returns the meta object for the reference '{@link EER.GeneralizationRelationship#getRelationship <em>Relationship</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Relationship</em>'.
	 * @see EER.GeneralizationRelationship#getRelationship()
	 * @see #getGeneralizationRelationship()
	 * @generated
	 */
	EReference getGeneralizationRelationship_Relationship();

	/**
	 * Returns the meta object for the container reference '{@link EER.GeneralizationRelationship#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Child</em>'.
	 * @see EER.GeneralizationRelationship#getChild()
	 * @see #getGeneralizationRelationship()
	 * @generated
	 */
	EReference getGeneralizationRelationship_Child();

	/**
	 * Returns the meta object for class '{@link EER.AbstractParticipant <em>Abstract Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Participant</em>'.
	 * @see EER.AbstractParticipant
	 * @generated
	 */
	EClass getAbstractParticipant();

	/**
	 * Returns the meta object for the attribute '{@link EER.AbstractParticipant#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Role</em>'.
	 * @see EER.AbstractParticipant#getRole()
	 * @see #getAbstractParticipant()
	 * @generated
	 */
	EAttribute getAbstractParticipant_Role();

	/**
	 * Returns the meta object for the attribute '{@link EER.AbstractParticipant#getLowerBound <em>Lower Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound</em>'.
	 * @see EER.AbstractParticipant#getLowerBound()
	 * @see #getAbstractParticipant()
	 * @generated
	 */
	EAttribute getAbstractParticipant_LowerBound();

	/**
	 * Returns the meta object for the attribute '{@link EER.AbstractParticipant#getUpperBound <em>Upper Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound</em>'.
	 * @see EER.AbstractParticipant#getUpperBound()
	 * @see #getAbstractParticipant()
	 * @generated
	 */
	EAttribute getAbstractParticipant_UpperBound();

	/**
	 * Returns the meta object for class '{@link EER.AggregationParticipant <em>Aggregation Participant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation Participant</em>'.
	 * @see EER.AggregationParticipant
	 * @generated
	 */
	EClass getAggregationParticipant();

	/**
	 * Returns the meta object for the reference '{@link EER.AggregationParticipant#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see EER.AggregationParticipant#getTarget()
	 * @see #getAggregationParticipant()
	 * @generated
	 */
	EReference getAggregationParticipant_Target();

	/**
	 * Returns the meta object for the container reference '{@link EER.AggregationParticipant#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see EER.AggregationParticipant#getSource()
	 * @see #getAggregationParticipant()
	 * @generated
	 */
	EReference getAggregationParticipant_Source();

	/**
	 * Returns the meta object for class '{@link EER.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see EER.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Node#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see EER.Node#getAttributes()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Attributes();

	/**
	 * Returns the meta object for class '{@link EER.Aggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation</em>'.
	 * @see EER.Aggregation
	 * @generated
	 */
	EClass getAggregation();

	/**
	 * Returns the meta object for the reference '{@link EER.Aggregation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see EER.Aggregation#getSource()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_Source();

	/**
	 * Returns the meta object for the containment reference list '{@link EER.Aggregation#getParticipants <em>Participants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Participants</em>'.
	 * @see EER.Aggregation#getParticipants()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_Participants();

	/**
	 * Returns the meta object for enum '{@link EER.DependencyType <em>Dependency Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Dependency Type</em>'.
	 * @see EER.DependencyType
	 * @generated
	 */
	EEnum getDependencyType();

	/**
	 * Returns the meta object for enum '{@link EER.GeneralizationType <em>Generalization Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Generalization Type</em>'.
	 * @see EER.GeneralizationType
	 * @generated
	 */
	EEnum getGeneralizationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EERFactory getEERFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link EER.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.ProjectImpl
		 * @see EER.impl.EERPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Domains</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__DOMAINS = eINSTANCE.getProject_Domains();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT__NODES = eINSTANCE.getProject_Nodes();

		/**
		 * The meta object literal for the '{@link EER.impl.AttributedNodeImpl <em>Attributed Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.AttributedNodeImpl
		 * @see EER.impl.EERPackageImpl#getAttributedNode()
		 * @generated
		 */
		EClass ATTRIBUTED_NODE = eINSTANCE.getAttributedNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTED_NODE__NAME = eINSTANCE.getAttributedNode_Name();

		/**
		 * The meta object literal for the '{@link EER.impl.EntityImpl <em>Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.EntityImpl
		 * @see EER.impl.EERPackageImpl#getEntity()
		 * @generated
		 */
		EClass ENTITY = eINSTANCE.getEntity();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__PRIMARY_KEY = eINSTANCE.getEntity_PrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Candidate Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__CANDIDATE_KEY = eINSTANCE.getEntity_CandidateKey();

		/**
		 * The meta object literal for the '<em><b>Dependency Relationships</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__DEPENDENCY_RELATIONSHIPS = eINSTANCE.getEntity_DependencyRelationships();

		/**
		 * The meta object literal for the '<em><b>Is Specialized By</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__IS_SPECIALIZED_BY = eINSTANCE.getEntity_IsSpecializedBy();

		/**
		 * The meta object literal for the '<em><b>Specializes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY__SPECIALIZES = eINSTANCE.getEntity_Specializes();

		/**
		 * The meta object literal for the '{@link EER.impl.WeakEntityImpl <em>Weak Entity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.WeakEntityImpl
		 * @see EER.impl.EERPackageImpl#getWeakEntity()
		 * @generated
		 */
		EClass WEAK_ENTITY = eINSTANCE.getWeakEntity();

		/**
		 * The meta object literal for the '{@link EER.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.ConstraintImpl
		 * @see EER.impl.EERPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__NAME = eINSTANCE.getConstraint_Name();

		/**
		 * The meta object literal for the '{@link EER.impl.ExclusiveImpl <em>Exclusive</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.ExclusiveImpl
		 * @see EER.impl.EERPackageImpl#getExclusive()
		 * @generated
		 */
		EClass EXCLUSIVE = eINSTANCE.getExclusive();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUSIVE__SOURCE = eINSTANCE.getExclusive_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUSIVE__TARGET = eINSTANCE.getExclusive_Target();

		/**
		 * The meta object literal for the '{@link EER.impl.InclusivenessImpl <em>Inclusiveness</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.InclusivenessImpl
		 * @see EER.impl.EERPackageImpl#getInclusiveness()
		 * @generated
		 */
		EClass INCLUSIVENESS = eINSTANCE.getInclusiveness();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUSIVENESS__SOURCE = eINSTANCE.getInclusiveness_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUSIVENESS__TARGET = eINSTANCE.getInclusiveness_Target();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUSIVENESS__LOWER_BOUND = eINSTANCE.getInclusiveness_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INCLUSIVENESS__UPPER_BOUND = eINSTANCE.getInclusiveness_UpperBound();

		/**
		 * The meta object literal for the '{@link EER.impl.ExclusionImpl <em>Exclusion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.ExclusionImpl
		 * @see EER.impl.EERPackageImpl#getExclusion()
		 * @generated
		 */
		EClass EXCLUSION = eINSTANCE.getExclusion();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUSION__SOURCE = eINSTANCE.getExclusion_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXCLUSION__TARGET = eINSTANCE.getExclusion_Target();

		/**
		 * The meta object literal for the '{@link EER.impl.InclusionImpl <em>Inclusion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.InclusionImpl
		 * @see EER.impl.EERPackageImpl#getInclusion()
		 * @generated
		 */
		EClass INCLUSION = eINSTANCE.getInclusion();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUSION__SOURCE = eINSTANCE.getInclusion_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCLUSION__TARGET = eINSTANCE.getInclusion_Target();

		/**
		 * The meta object literal for the '{@link EER.impl.CandidateKeyImpl <em>Candidate Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.CandidateKeyImpl
		 * @see EER.impl.EERPackageImpl#getCandidateKey()
		 * @generated
		 */
		EClass CANDIDATE_KEY = eINSTANCE.getCandidateKey();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CANDIDATE_KEY__ATTRIBUTES = eINSTANCE.getCandidateKey_Attributes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CANDIDATE_KEY__NAME = eINSTANCE.getCandidateKey_Name();

		/**
		 * The meta object literal for the '{@link EER.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.AttributeImpl
		 * @see EER.impl.EERPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__NULLABLE = eINSTANCE.getAttribute_Nullable();

		/**
		 * The meta object literal for the '{@link EER.impl.CompositeAttributeImpl <em>Composite Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.CompositeAttributeImpl
		 * @see EER.impl.EERPackageImpl#getCompositeAttribute()
		 * @generated
		 */
		EClass COMPOSITE_ATTRIBUTE = eINSTANCE.getCompositeAttribute();

		/**
		 * The meta object literal for the '<em><b>Singles Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_ATTRIBUTE__SINGLES_ATTRIBUTES = eINSTANCE.getCompositeAttribute_SinglesAttributes();

		/**
		 * The meta object literal for the '{@link EER.impl.SingleAttributeImpl <em>Single Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.SingleAttributeImpl
		 * @see EER.impl.EERPackageImpl#getSingleAttribute()
		 * @generated
		 */
		EClass SINGLE_ATTRIBUTE = eINSTANCE.getSingleAttribute();

		/**
		 * The meta object literal for the '<em><b>Derivate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_ATTRIBUTE__DERIVATE = eINSTANCE.getSingleAttribute_Derivate();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLE_ATTRIBUTE__DOMAIN = eINSTANCE.getSingleAttribute_Domain();

		/**
		 * The meta object literal for the '<em><b>Multiplicity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SINGLE_ATTRIBUTE__MULTIPLICITY = eINSTANCE.getSingleAttribute_Multiplicity();

		/**
		 * The meta object literal for the '{@link EER.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.DomainImpl
		 * @see EER.impl.EERPackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN__NAME = eINSTANCE.getDomain_Name();

		/**
		 * The meta object literal for the '{@link EER.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.EnumerationTypeImpl
		 * @see EER.impl.EERPackageImpl#getEnumerationType()
		 * @generated
		 */
		EClass ENUMERATION_TYPE = eINSTANCE.getEnumerationType();

		/**
		 * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_TYPE__LITERALS = eINSTANCE.getEnumerationType_Literals();

		/**
		 * The meta object literal for the '{@link EER.impl.PrimitiveTypeImpl <em>Primitive Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.PrimitiveTypeImpl
		 * @see EER.impl.EERPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EClass PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

		/**
		 * The meta object literal for the '{@link EER.impl.EnumeratedLiteralImpl <em>Enumerated Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.EnumeratedLiteralImpl
		 * @see EER.impl.EERPackageImpl#getEnumeratedLiteral()
		 * @generated
		 */
		EClass ENUMERATED_LITERAL = eINSTANCE.getEnumeratedLiteral();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATED_LITERAL__NAME = eINSTANCE.getEnumeratedLiteral_Name();

		/**
		 * The meta object literal for the '{@link EER.impl.AbstractRelationshipImpl <em>Abstract Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.AbstractRelationshipImpl
		 * @see EER.impl.EERPackageImpl#getAbstractRelationship()
		 * @generated
		 */
		EClass ABSTRACT_RELATIONSHIP = eINSTANCE.getAbstractRelationship();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RELATIONSHIP__PARTICIPANTS = eINSTANCE.getAbstractRelationship_Participants();

		/**
		 * The meta object literal for the '{@link EER.impl.RelationshipImpl <em>Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.RelationshipImpl
		 * @see EER.impl.EERPackageImpl#getRelationship()
		 * @generated
		 */
		EClass RELATIONSHIP = eINSTANCE.getRelationship();

		/**
		 * The meta object literal for the '<em><b>Exclusion Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__EXCLUSION_CONSTRAINTS = eINSTANCE.getRelationship_ExclusionConstraints();

		/**
		 * The meta object literal for the '<em><b>Inclusion Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONSHIP__INCLUSION_CONSTRAINTS = eINSTANCE.getRelationship_InclusionConstraints();

		/**
		 * The meta object literal for the '{@link EER.impl.DependencyRelationshipImpl <em>Dependency Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.DependencyRelationshipImpl
		 * @see EER.impl.EERPackageImpl#getDependencyRelationship()
		 * @generated
		 */
		EClass DEPENDENCY_RELATIONSHIP = eINSTANCE.getDependencyRelationship();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_RELATIONSHIP__TYPE = eINSTANCE.getDependencyRelationship_Type();

		/**
		 * The meta object literal for the '{@link EER.impl.ParticipantImpl <em>Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.ParticipantImpl
		 * @see EER.impl.EERPackageImpl#getParticipant()
		 * @generated
		 */
		EClass PARTICIPANT = eINSTANCE.getParticipant();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__TARGET = eINSTANCE.getParticipant_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__SOURCE = eINSTANCE.getParticipant_Source();

		/**
		 * The meta object literal for the '<em><b>Exclusive Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__EXCLUSIVE_CONSTRAINT = eINSTANCE.getParticipant_ExclusiveConstraint();

		/**
		 * The meta object literal for the '<em><b>Inclusiveness Constraint</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARTICIPANT__INCLUSIVENESS_CONSTRAINT = eINSTANCE.getParticipant_InclusivenessConstraint();

		/**
		 * The meta object literal for the '{@link EER.impl.GeneralizationImpl <em>Generalization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.GeneralizationImpl
		 * @see EER.impl.EERPackageImpl#getGeneralization()
		 * @generated
		 */
		EClass GENERALIZATION = eINSTANCE.getGeneralization();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION__PARENT = eINSTANCE.getGeneralization_Parent();

		/**
		 * The meta object literal for the '<em><b>Childs</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION__CHILDS = eINSTANCE.getGeneralization_Childs();

		/**
		 * The meta object literal for the '<em><b>Attribute</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION__ATTRIBUTE = eINSTANCE.getGeneralization_Attribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GENERALIZATION__TYPE = eINSTANCE.getGeneralization_Type();

		/**
		 * The meta object literal for the '{@link EER.impl.SpecializationRelationshipImpl <em>Specialization Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.SpecializationRelationshipImpl
		 * @see EER.impl.EERPackageImpl#getSpecializationRelationship()
		 * @generated
		 */
		EClass SPECIALIZATION_RELATIONSHIP = eINSTANCE.getSpecializationRelationship();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_RELATIONSHIP__SOURCE = eINSTANCE.getSpecializationRelationship_Source();

		/**
		 * The meta object literal for the '<em><b>Relationship</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPECIALIZATION_RELATIONSHIP__RELATIONSHIP = eINSTANCE.getSpecializationRelationship_Relationship();

		/**
		 * The meta object literal for the '{@link EER.impl.GeneralizationRelationshipImpl <em>Generalization Relationship</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.GeneralizationRelationshipImpl
		 * @see EER.impl.EERPackageImpl#getGeneralizationRelationship()
		 * @generated
		 */
		EClass GENERALIZATION_RELATIONSHIP = eINSTANCE.getGeneralizationRelationship();

		/**
		 * The meta object literal for the '<em><b>Relationship</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_RELATIONSHIP__RELATIONSHIP = eINSTANCE.getGeneralizationRelationship_Relationship();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GENERALIZATION_RELATIONSHIP__CHILD = eINSTANCE.getGeneralizationRelationship_Child();

		/**
		 * The meta object literal for the '{@link EER.impl.AbstractParticipantImpl <em>Abstract Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.AbstractParticipantImpl
		 * @see EER.impl.EERPackageImpl#getAbstractParticipant()
		 * @generated
		 */
		EClass ABSTRACT_PARTICIPANT = eINSTANCE.getAbstractParticipant();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PARTICIPANT__ROLE = eINSTANCE.getAbstractParticipant_Role();

		/**
		 * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PARTICIPANT__LOWER_BOUND = eINSTANCE.getAbstractParticipant_LowerBound();

		/**
		 * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_PARTICIPANT__UPPER_BOUND = eINSTANCE.getAbstractParticipant_UpperBound();

		/**
		 * The meta object literal for the '{@link EER.impl.AggregationParticipantImpl <em>Aggregation Participant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.AggregationParticipantImpl
		 * @see EER.impl.EERPackageImpl#getAggregationParticipant()
		 * @generated
		 */
		EClass AGGREGATION_PARTICIPANT = eINSTANCE.getAggregationParticipant();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION_PARTICIPANT__TARGET = eINSTANCE.getAggregationParticipant_Target();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION_PARTICIPANT__SOURCE = eINSTANCE.getAggregationParticipant_Source();

		/**
		 * The meta object literal for the '{@link EER.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.NodeImpl
		 * @see EER.impl.EERPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__ATTRIBUTES = eINSTANCE.getNode_Attributes();

		/**
		 * The meta object literal for the '{@link EER.impl.AggregationImpl <em>Aggregation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.impl.AggregationImpl
		 * @see EER.impl.EERPackageImpl#getAggregation()
		 * @generated
		 */
		EClass AGGREGATION = eINSTANCE.getAggregation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__SOURCE = eINSTANCE.getAggregation_Source();

		/**
		 * The meta object literal for the '<em><b>Participants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__PARTICIPANTS = eINSTANCE.getAggregation_Participants();

		/**
		 * The meta object literal for the '{@link EER.DependencyType <em>Dependency Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.DependencyType
		 * @see EER.impl.EERPackageImpl#getDependencyType()
		 * @generated
		 */
		EEnum DEPENDENCY_TYPE = eINSTANCE.getDependencyType();

		/**
		 * The meta object literal for the '{@link EER.GeneralizationType <em>Generalization Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see EER.GeneralizationType
		 * @see EER.impl.EERPackageImpl#getGeneralizationType()
		 * @generated
		 */
		EEnum GENERALIZATION_TYPE = eINSTANCE.getGeneralizationType();

	}

} //EERPackage

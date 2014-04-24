/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangFactory
 * @model kind="package"
 * @generated
 */
public interface ObjLangPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "objlang";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://spirals.inria.fr/sigma/ttc14/fixml/objlang/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "objlang";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ObjLangPackage eINSTANCE = fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NamedElementImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassifierImpl <em>Classifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassifierImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Classifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the '<em><b>Superclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPERCLASS = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MEMBERS = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constructors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONSTRUCTORS = CLASSIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__FIELDS = CLASSIFIER_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DataTypeImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = CLASSIFIER__NAME;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.TypedElementImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__MANY = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.MemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.MemberImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER__PARENT = 0;

	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorImpl <em>Constructor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getConstructor()
	 * @generated
	 */
	int CONSTRUCTOR = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__PARENT = MEMBER__PARENT;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__PARAMETERS = MEMBER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initialisations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR__INITIALISATIONS = MEMBER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_FEATURE_COUNT = MEMBER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Constructor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_OPERATION_COUNT = MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__MANY = TYPED_ELEMENT__MANY;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldInitialisiationImpl <em>Field Initialisiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldInitialisiationImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getFieldInitialisiation()
	 * @generated
	 */
	int FIELD_INITIALISIATION = 8;

	/**
	 * The feature id for the '<em><b>Field</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INITIALISIATION__FIELD = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INITIALISIATION__EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Field Initialisiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INITIALISIATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Field Initialisiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_INITIALISIATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldImpl <em>Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getField()
	 * @generated
	 */
	int FIELD = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = TYPED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__MANY = TYPED_ELEMENT__MANY;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__PARENT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__INITIAL_VALUE = TYPED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ExpressionImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 10;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.StringLiteralImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>String Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DoubleLiteralImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getDoubleLiteral()
	 * @generated
	 */
	int DOUBLE_LITERAL = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Double Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.LongLiteralImpl <em>Long Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.LongLiteralImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getLongLiteral()
	 * @generated
	 */
	int LONG_LITERAL = 13;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Long Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Long Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.IntegerLiteralImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getIntegerLiteral()
	 * @generated
	 */
	int INTEGER_LITERAL = 14;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL__VALUE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Integer Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorCallImpl <em>Constructor Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorCallImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getConstructorCall()
	 * @generated
	 */
	int CONSTRUCTOR_CALL = 15;

	/**
	 * The feature id for the '<em><b>Constructor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CALL__CONSTRUCTOR = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CALL__ARGUMENTS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Constructor Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Constructor Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRUCTOR_CALL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterAccessImpl <em>Parameter Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterAccessImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getParameterAccess()
	 * @generated
	 */
	int PARAMETER_ACCESS = 16;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_ACCESS__PARAMETER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_ACCESS_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Parameter Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_ACCESS_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NullLiteralImpl <em>Null Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NullLiteralImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getNullLiteral()
	 * @generated
	 */
	int NULL_LITERAL = 17;

	/**
	 * The number of structural features of the '<em>Null Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Null Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ArrayLiteralImpl <em>Array Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ArrayLiteralImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getArrayLiteral()
	 * @generated
	 */
	int ARRAY_LITERAL = 18;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__TYPE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL__ELEMENTS = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Array Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Array Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_LITERAL_OPERATION_COUNT = EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Classifier</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getSuperclass <em>Superclass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Superclass</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getSuperclass()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Superclass();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Members</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getMembers()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Members();

	/**
	 * Returns the meta object for the reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getConstructors <em>Constructors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Constructors</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getConstructors()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Constructors();

	/**
	 * Returns the meta object for the reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fields</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getFields()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Fields();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#isMany <em>Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Many</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement#isMany()
	 * @see #getTypedElement()
	 * @generated
	 */
	EAttribute getTypedElement_Many();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Member <em>Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Member
	 * @generated
	 */
	EClass getMember();

	/**
	 * Returns the meta object for the container reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Member#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Member#getParent()
	 * @see #getMember()
	 * @generated
	 */
	EReference getMember_Parent();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor
	 * @generated
	 */
	EClass getConstructor();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor#getParameters()
	 * @see #getConstructor()
	 * @generated
	 */
	EReference getConstructor_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor#getInitialisations <em>Initialisations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Initialisations</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor#getInitialisations()
	 * @see #getConstructor()
	 * @generated
	 */
	EReference getConstructor_Initialisations();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation <em>Field Initialisiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Initialisiation</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation
	 * @generated
	 */
	EClass getFieldInitialisiation();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation#getField <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Field</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation#getField()
	 * @see #getFieldInitialisiation()
	 * @generated
	 */
	EReference getFieldInitialisiation_Field();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation#getExpression()
	 * @see #getFieldInitialisiation()
	 * @generated
	 */
	EReference getFieldInitialisiation_Expression();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Field <em>Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Field
	 * @generated
	 */
	EClass getField();

	/**
	 * Returns the meta object for the containment reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Field#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Field#getInitialValue()
	 * @see #getField()
	 * @generated
	 */
	EReference getField_InitialValue();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Literal</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral
	 * @generated
	 */
	EClass getDoubleLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral#getValue()
	 * @see #getDoubleLiteral()
	 * @generated
	 */
	EAttribute getDoubleLiteral_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral <em>Long Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Literal</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral
	 * @generated
	 */
	EClass getLongLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral#getValue()
	 * @see #getLongLiteral()
	 * @generated
	 */
	EAttribute getLongLiteral_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral <em>Integer Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral
	 * @generated
	 */
	EClass getIntegerLiteral();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral#getValue()
	 * @see #getIntegerLiteral()
	 * @generated
	 */
	EAttribute getIntegerLiteral_Value();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall <em>Constructor Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constructor Call</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall
	 * @generated
	 */
	EClass getConstructorCall();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall#getConstructor <em>Constructor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Constructor</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall#getConstructor()
	 * @see #getConstructorCall()
	 * @generated
	 */
	EReference getConstructorCall_Constructor();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall#getArguments()
	 * @see #getConstructorCall()
	 * @generated
	 */
	EReference getConstructorCall_Arguments();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess <em>Parameter Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Access</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess
	 * @generated
	 */
	EClass getParameterAccess();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess#getParameter()
	 * @see #getParameterAccess()
	 * @generated
	 */
	EReference getParameterAccess_Parameter();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral <em>Null Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral
	 * @generated
	 */
	EClass getNullLiteral();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral <em>Array Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Literal</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral
	 * @generated
	 */
	EClass getArrayLiteral();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral#getType()
	 * @see #getArrayLiteral()
	 * @generated
	 */
	EReference getArrayLiteral_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral#getElements()
	 * @see #getArrayLiteral()
	 * @generated
	 */
	EReference getArrayLiteral_Elements();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ObjLangFactory getObjLangFactory();

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
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NamedElementImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassifierImpl <em>Classifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassifierImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Superclass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPERCLASS = eINSTANCE.getClass_Superclass();

		/**
		 * The meta object literal for the '<em><b>Members</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__MEMBERS = eINSTANCE.getClass_Members();

		/**
		 * The meta object literal for the '<em><b>Constructors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CONSTRUCTORS = eINSTANCE.getClass_Constructors();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__FIELDS = eINSTANCE.getClass_Fields();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DataTypeImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.TypedElementImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '<em><b>Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPED_ELEMENT__MANY = eINSTANCE.getTypedElement_Many();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.MemberImpl <em>Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.MemberImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getMember()
		 * @generated
		 */
		EClass MEMBER = eINSTANCE.getMember();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER__PARENT = eINSTANCE.getMember_Parent();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorImpl <em>Constructor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getConstructor()
		 * @generated
		 */
		EClass CONSTRUCTOR = eINSTANCE.getConstructor();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR__PARAMETERS = eINSTANCE.getConstructor_Parameters();

		/**
		 * The meta object literal for the '<em><b>Initialisations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR__INITIALISATIONS = eINSTANCE.getConstructor_Initialisations();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldInitialisiationImpl <em>Field Initialisiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldInitialisiationImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getFieldInitialisiation()
		 * @generated
		 */
		EClass FIELD_INITIALISIATION = eINSTANCE.getFieldInitialisiation();

		/**
		 * The meta object literal for the '<em><b>Field</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_INITIALISIATION__FIELD = eINSTANCE.getFieldInitialisiation_Field();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD_INITIALISIATION__EXPRESSION = eINSTANCE.getFieldInitialisiation_Expression();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldImpl <em>Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getField()
		 * @generated
		 */
		EClass FIELD = eINSTANCE.getField();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FIELD__INITIAL_VALUE = eINSTANCE.getField_InitialValue();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ExpressionImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.StringLiteralImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getStringLiteral()
		 * @generated
		 */
		EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DoubleLiteralImpl <em>Double Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.DoubleLiteralImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getDoubleLiteral()
		 * @generated
		 */
		EClass DOUBLE_LITERAL = eINSTANCE.getDoubleLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_LITERAL__VALUE = eINSTANCE.getDoubleLiteral_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.LongLiteralImpl <em>Long Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.LongLiteralImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getLongLiteral()
		 * @generated
		 */
		EClass LONG_LITERAL = eINSTANCE.getLongLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LONG_LITERAL__VALUE = eINSTANCE.getLongLiteral_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.IntegerLiteralImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getIntegerLiteral()
		 * @generated
		 */
		EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorCallImpl <em>Constructor Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorCallImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getConstructorCall()
		 * @generated
		 */
		EClass CONSTRUCTOR_CALL = eINSTANCE.getConstructorCall();

		/**
		 * The meta object literal for the '<em><b>Constructor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_CALL__CONSTRUCTOR = eINSTANCE.getConstructorCall_Constructor();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRUCTOR_CALL__ARGUMENTS = eINSTANCE.getConstructorCall_Arguments();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterAccessImpl <em>Parameter Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ParameterAccessImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getParameterAccess()
		 * @generated
		 */
		EClass PARAMETER_ACCESS = eINSTANCE.getParameterAccess();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_ACCESS__PARAMETER = eINSTANCE.getParameterAccess_Parameter();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NullLiteralImpl <em>Null Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.NullLiteralImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getNullLiteral()
		 * @generated
		 */
		EClass NULL_LITERAL = eINSTANCE.getNullLiteral();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ArrayLiteralImpl <em>Array Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ArrayLiteralImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getArrayLiteral()
		 * @generated
		 */
		EClass ARRAY_LITERAL = eINSTANCE.getArrayLiteral();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_LITERAL__TYPE = eINSTANCE.getArrayLiteral_Type();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_LITERAL__ELEMENTS = eINSTANCE.getArrayLiteral_Elements();

	}

} //ObjLangPackage

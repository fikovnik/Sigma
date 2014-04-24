/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang;

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
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ClassImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Superclass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPERCLASS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Members</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__MEMBERS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Constructors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONSTRUCTORS = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__REFERENCES = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.MemberImpl <em>Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.MemberImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getMember()
	 * @generated
	 */
	int MEMBER = 2;

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
	int CONSTRUCTOR = 3;

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
	int PARAMETER = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceParameterImpl <em>Reference Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceParameterImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getReferenceParameter()
	 * @generated
	 */
	int REFERENCE_PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PARAMETER__TYPE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reference Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.PrimitiveParameterImpl <em>Primitive Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.PrimitiveParameterImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getPrimitiveParameter()
	 * @generated
	 */
	int PRIMITIVE_PARAMETER = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER__NAME = PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER__TYPE = PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER_FEATURE_COUNT = PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Primitive Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER_OPERATION_COUNT = PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldInitialisiationImpl <em>Field Initialisiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.FieldInitialisiationImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getFieldInitialisiation()
	 * @generated
	 */
	int FIELD_INITIALISIATION = 7;

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
	int FIELD = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__PARENT = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD__INITIAL_VALUE = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceImpl <em>Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getReference()
	 * @generated
	 */
	int REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__NAME = FIELD__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__PARENT = FIELD__PARENT;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__INITIAL_VALUE = FIELD__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE__TYPE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_OPERATION_COUNT = FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.AttributeImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getAttribute()
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
	int ATTRIBUTE__NAME = FIELD__NAME;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PARENT = FIELD__PARENT;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__INITIAL_VALUE = FIELD__INITIAL_VALUE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = FIELD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = FIELD_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = FIELD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ExpressionImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 11;

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
	int STRING_LITERAL = 12;

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
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorCallImpl <em>Constructor Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ConstructorCallImpl
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getConstructorCall()
	 * @generated
	 */
	int CONSTRUCTOR_CALL = 13;

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
	int PARAMETER_ACCESS = 14;

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
	int NULL_LITERAL = 15;

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
	 * The meta object id for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType <em>Primitive Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getPrimitiveType()
	 * @generated
	 */
	int PRIMITIVE_TYPE = 16;


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
	 * Returns the meta object for the reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Attributes</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getAttributes()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>References</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Class#getReferences()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_References();

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
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter <em>Reference Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Parameter</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter
	 * @generated
	 */
	EClass getReferenceParameter();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter#getType()
	 * @see #getReferenceParameter()
	 * @generated
	 */
	EReference getReferenceParameter_Type();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter <em>Primitive Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Parameter</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter
	 * @generated
	 */
	EClass getPrimitiveParameter();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter#getType()
	 * @see #getPrimitiveParameter()
	 * @generated
	 */
	EAttribute getPrimitiveParameter_Type();

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
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference
	 * @generated
	 */
	EClass getReference();

	/**
	 * Returns the meta object for the reference '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference#getType()
	 * @see #getReference()
	 * @generated
	 */
	EReference getReference_Type();

	/**
	 * Returns the meta object for class '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_Type();

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
	 * Returns the meta object for enum '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Type</em>'.
	 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType
	 * @generated
	 */
	EEnum getPrimitiveType();

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
		 * The meta object literal for the '<em><b>Attributes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTRIBUTES = eINSTANCE.getClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__REFERENCES = eINSTANCE.getClass_References();

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
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceParameterImpl <em>Reference Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceParameterImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getReferenceParameter()
		 * @generated
		 */
		EClass REFERENCE_PARAMETER = eINSTANCE.getReferenceParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_PARAMETER__TYPE = eINSTANCE.getReferenceParameter_Type();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.PrimitiveParameterImpl <em>Primitive Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.PrimitiveParameterImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getPrimitiveParameter()
		 * @generated
		 */
		EClass PRIMITIVE_PARAMETER = eINSTANCE.getPrimitiveParameter();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_PARAMETER__TYPE = eINSTANCE.getPrimitiveParameter_Type();

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
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceImpl <em>Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ReferenceImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getReference()
		 * @generated
		 */
		EClass REFERENCE = eINSTANCE.getReference();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE__TYPE = eINSTANCE.getReference_Type();

		/**
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.AttributeImpl
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

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
		 * The meta object literal for the '{@link fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType <em>Primitive Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType
		 * @see fr.inria.spirals.sigma.ttc14.fixml.objlang.impl.ObjLangPackageImpl#getPrimitiveType()
		 * @generated
		 */
		EEnum PRIMITIVE_TYPE = eINSTANCE.getPrimitiveType();

	}

} //ObjLangPackage

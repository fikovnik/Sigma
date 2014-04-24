/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang.impl;

import fr.inria.spirals.sigma.ttc14.fixml.objlang.ArrayLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.DataType;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.DoubleLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Field;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.IntegerLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.LongLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangFactory;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Parameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.TypedElement;

import org.eclipse.emf.ecore.EClass;
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
public class ObjLangFactoryImpl extends EFactoryImpl implements ObjLangFactory
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ObjLangFactory init()
	{
		try
		{
			ObjLangFactory theObjLangFactory = (ObjLangFactory)EPackage.Registry.INSTANCE.getEFactory(ObjLangPackage.eNS_URI);
			if (theObjLangFactory != null)
			{
				return theObjLangFactory;
			}
		}
		catch (Exception exception)
		{
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ObjLangFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjLangFactoryImpl()
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
			case ObjLangPackage.CLASS: return createClass();
			case ObjLangPackage.DATA_TYPE: return createDataType();
			case ObjLangPackage.TYPED_ELEMENT: return createTypedElement();
			case ObjLangPackage.CONSTRUCTOR: return createConstructor();
			case ObjLangPackage.PARAMETER: return createParameter();
			case ObjLangPackage.FIELD_INITIALISIATION: return createFieldInitialisiation();
			case ObjLangPackage.FIELD: return createField();
			case ObjLangPackage.STRING_LITERAL: return createStringLiteral();
			case ObjLangPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case ObjLangPackage.LONG_LITERAL: return createLongLiteral();
			case ObjLangPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case ObjLangPackage.CONSTRUCTOR_CALL: return createConstructorCall();
			case ObjLangPackage.PARAMETER_ACCESS: return createParameterAccess();
			case ObjLangPackage.NULL_LITERAL: return createNullLiteral();
			case ObjLangPackage.ARRAY_LITERAL: return createArrayLiteral();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public fr.inria.spirals.sigma.ttc14.fixml.objlang.Class createClass()
	{
		ClassImplDelegate class_ = new ClassImplDelegate();
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType createDataType()
	{
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedElement createTypedElement()
	{
		TypedElementImpl typedElement = new TypedElementImpl();
		return typedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constructor createConstructor()
	{
		ConstructorImpl constructor = new ConstructorImpl();
		return constructor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter()
	{
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldInitialisiation createFieldInitialisiation()
	{
		FieldInitialisiationImpl fieldInitialisiation = new FieldInitialisiationImpl();
		return fieldInitialisiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Field createField()
	{
		FieldImpl field = new FieldImpl();
		return field;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral()
	{
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleLiteral createDoubleLiteral()
	{
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongLiteral createLongLiteral()
	{
		LongLiteralImpl longLiteral = new LongLiteralImpl();
		return longLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteral createIntegerLiteral()
	{
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstructorCall createConstructorCall()
	{
		ConstructorCallImpl constructorCall = new ConstructorCallImpl();
		return constructorCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterAccess createParameterAccess()
	{
		ParameterAccessImpl parameterAccess = new ParameterAccessImpl();
		return parameterAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NullLiteral createNullLiteral()
	{
		NullLiteralImpl nullLiteral = new NullLiteralImpl();
		return nullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayLiteral createArrayLiteral()
	{
		ArrayLiteralImpl arrayLiteral = new ArrayLiteralImpl();
		return arrayLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjLangPackage getObjLangPackage()
	{
		return (ObjLangPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ObjLangPackage getPackage()
	{
		return ObjLangPackage.eINSTANCE;
	}

} //ObjLangFactoryImpl

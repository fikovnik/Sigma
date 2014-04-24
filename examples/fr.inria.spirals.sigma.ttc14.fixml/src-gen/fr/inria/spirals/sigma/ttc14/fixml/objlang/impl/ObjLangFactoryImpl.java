/**
 */
package fr.inria.spirals.sigma.ttc14.fixml.objlang.impl;

import fr.inria.spirals.sigma.ttc14.fixml.objlang.Attribute;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Constructor;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ConstructorCall;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.FieldInitialisiation;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.NullLiteral;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangFactory;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ObjLangPackage;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ParameterAccess;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveParameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.PrimitiveType;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.Reference;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.ReferenceParameter;
import fr.inria.spirals.sigma.ttc14.fixml.objlang.StringLiteral;

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
			case ObjLangPackage.CONSTRUCTOR: return createConstructor();
			case ObjLangPackage.REFERENCE_PARAMETER: return createReferenceParameter();
			case ObjLangPackage.PRIMITIVE_PARAMETER: return createPrimitiveParameter();
			case ObjLangPackage.FIELD_INITIALISIATION: return createFieldInitialisiation();
			case ObjLangPackage.REFERENCE: return createReference();
			case ObjLangPackage.ATTRIBUTE: return createAttribute();
			case ObjLangPackage.STRING_LITERAL: return createStringLiteral();
			case ObjLangPackage.CONSTRUCTOR_CALL: return createConstructorCall();
			case ObjLangPackage.PARAMETER_ACCESS: return createParameterAccess();
			case ObjLangPackage.NULL_LITERAL: return createNullLiteral();
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
			case ObjLangPackage.PRIMITIVE_TYPE:
				return createPrimitiveTypeFromString(eDataType, initialValue);
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
			case ObjLangPackage.PRIMITIVE_TYPE:
				return convertPrimitiveTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
	public ReferenceParameter createReferenceParameter()
	{
		ReferenceParameterImpl referenceParameter = new ReferenceParameterImpl();
		return referenceParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveParameter createPrimitiveParameter()
	{
		PrimitiveParameterImpl primitiveParameter = new PrimitiveParameterImpl();
		return primitiveParameter;
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
	public Reference createReference()
	{
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute()
	{
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
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
	public PrimitiveType createPrimitiveTypeFromString(EDataType eDataType, String initialValue)
	{
		PrimitiveType result = PrimitiveType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrimitiveTypeToString(EDataType eDataType, Object instanceValue)
	{
		return instanceValue == null ? null : instanceValue.toString();
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

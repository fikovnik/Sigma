/**
 */
package EER.util;

import EER.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see EER.EERPackage
 * @generated
 */
public class EERSwitch<T> extends Switch<T>
{
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EERPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EERSwitch()
	{
		if (modelPackage == null)
		{
			modelPackage = EERPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage)
	{
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject)
	{
		switch (classifierID)
		{
			case EERPackage.PROJECT:
			{
				Project project = (Project)theEObject;
				T result = caseProject(project);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.ATTRIBUTED_NODE:
			{
				AttributedNode attributedNode = (AttributedNode)theEObject;
				T result = caseAttributedNode(attributedNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.ENTITY:
			{
				Entity entity = (Entity)theEObject;
				T result = caseEntity(entity);
				if (result == null) result = caseNode(entity);
				if (result == null) result = caseAttributedNode(entity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.WEAK_ENTITY:
			{
				WeakEntity weakEntity = (WeakEntity)theEObject;
				T result = caseWeakEntity(weakEntity);
				if (result == null) result = caseEntity(weakEntity);
				if (result == null) result = caseNode(weakEntity);
				if (result == null) result = caseAttributedNode(weakEntity);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.CONSTRAINT:
			{
				Constraint constraint = (Constraint)theEObject;
				T result = caseConstraint(constraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.EXCLUSIVE:
			{
				Exclusive exclusive = (Exclusive)theEObject;
				T result = caseExclusive(exclusive);
				if (result == null) result = caseConstraint(exclusive);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.INCLUSIVENESS:
			{
				Inclusiveness inclusiveness = (Inclusiveness)theEObject;
				T result = caseInclusiveness(inclusiveness);
				if (result == null) result = caseConstraint(inclusiveness);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.EXCLUSION:
			{
				Exclusion exclusion = (Exclusion)theEObject;
				T result = caseExclusion(exclusion);
				if (result == null) result = caseConstraint(exclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.INCLUSION:
			{
				Inclusion inclusion = (Inclusion)theEObject;
				T result = caseInclusion(inclusion);
				if (result == null) result = caseConstraint(inclusion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.CANDIDATE_KEY:
			{
				CandidateKey candidateKey = (CandidateKey)theEObject;
				T result = caseCandidateKey(candidateKey);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.ATTRIBUTE:
			{
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.COMPOSITE_ATTRIBUTE:
			{
				CompositeAttribute compositeAttribute = (CompositeAttribute)theEObject;
				T result = caseCompositeAttribute(compositeAttribute);
				if (result == null) result = caseAttribute(compositeAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.SINGLE_ATTRIBUTE:
			{
				SingleAttribute singleAttribute = (SingleAttribute)theEObject;
				T result = caseSingleAttribute(singleAttribute);
				if (result == null) result = caseAttribute(singleAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.DOMAIN:
			{
				Domain domain = (Domain)theEObject;
				T result = caseDomain(domain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.ENUMERATION_TYPE:
			{
				EnumerationType enumerationType = (EnumerationType)theEObject;
				T result = caseEnumerationType(enumerationType);
				if (result == null) result = caseDomain(enumerationType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.PRIMITIVE_TYPE:
			{
				PrimitiveType primitiveType = (PrimitiveType)theEObject;
				T result = casePrimitiveType(primitiveType);
				if (result == null) result = caseDomain(primitiveType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.ENUMERATED_LITERAL:
			{
				EnumeratedLiteral enumeratedLiteral = (EnumeratedLiteral)theEObject;
				T result = caseEnumeratedLiteral(enumeratedLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.ABSTRACT_RELATIONSHIP:
			{
				AbstractRelationship abstractRelationship = (AbstractRelationship)theEObject;
				T result = caseAbstractRelationship(abstractRelationship);
				if (result == null) result = caseNode(abstractRelationship);
				if (result == null) result = caseAttributedNode(abstractRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.RELATIONSHIP:
			{
				Relationship relationship = (Relationship)theEObject;
				T result = caseRelationship(relationship);
				if (result == null) result = caseAbstractRelationship(relationship);
				if (result == null) result = caseNode(relationship);
				if (result == null) result = caseAttributedNode(relationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.DEPENDENCY_RELATIONSHIP:
			{
				DependencyRelationship dependencyRelationship = (DependencyRelationship)theEObject;
				T result = caseDependencyRelationship(dependencyRelationship);
				if (result == null) result = caseAbstractRelationship(dependencyRelationship);
				if (result == null) result = caseNode(dependencyRelationship);
				if (result == null) result = caseAttributedNode(dependencyRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.PARTICIPANT:
			{
				Participant participant = (Participant)theEObject;
				T result = caseParticipant(participant);
				if (result == null) result = caseAbstractParticipant(participant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.GENERALIZATION:
			{
				Generalization generalization = (Generalization)theEObject;
				T result = caseGeneralization(generalization);
				if (result == null) result = caseAttributedNode(generalization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.SPECIALIZATION_RELATIONSHIP:
			{
				SpecializationRelationship specializationRelationship = (SpecializationRelationship)theEObject;
				T result = caseSpecializationRelationship(specializationRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.GENERALIZATION_RELATIONSHIP:
			{
				GeneralizationRelationship generalizationRelationship = (GeneralizationRelationship)theEObject;
				T result = caseGeneralizationRelationship(generalizationRelationship);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.ABSTRACT_PARTICIPANT:
			{
				AbstractParticipant abstractParticipant = (AbstractParticipant)theEObject;
				T result = caseAbstractParticipant(abstractParticipant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.AGGREGATION_PARTICIPANT:
			{
				AggregationParticipant aggregationParticipant = (AggregationParticipant)theEObject;
				T result = caseAggregationParticipant(aggregationParticipant);
				if (result == null) result = caseAbstractParticipant(aggregationParticipant);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.NODE:
			{
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseAttributedNode(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EERPackage.AGGREGATION:
			{
				Aggregation aggregation = (Aggregation)theEObject;
				T result = caseAggregation(aggregation);
				if (result == null) result = caseAttributedNode(aggregation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProject(Project object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attributed Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attributed Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributedNode(AttributedNode object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Weak Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weak Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWeakEntity(WeakEntity object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exclusive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exclusive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExclusive(Exclusive object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inclusiveness</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inclusiveness</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInclusiveness(Inclusiveness object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExclusion(Exclusion object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Inclusion</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Inclusion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInclusion(Inclusion object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Candidate Key</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Candidate Key</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCandidateKey(CandidateKey object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeAttribute(CompositeAttribute object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleAttribute(SingleAttribute object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomain(Domain object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumerationType(EnumerationType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveType(PrimitiveType object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enumerated Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enumerated Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumeratedLiteral(EnumeratedLiteral object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractRelationship(AbstractRelationship object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationship(Relationship object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dependency Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dependency Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDependencyRelationship(DependencyRelationship object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Participant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Participant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParticipant(Participant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generalization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generalization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralization(Generalization object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specialization Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specialization Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecializationRelationship(SpecializationRelationship object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generalization Relationship</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generalization Relationship</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGeneralizationRelationship(GeneralizationRelationship object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Participant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Participant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractParticipant(AbstractParticipant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation Participant</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation Participant</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregationParticipant(AggregationParticipant object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregation(Aggregation object)
	{
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object)
	{
		return null;
	}

} //EERSwitch

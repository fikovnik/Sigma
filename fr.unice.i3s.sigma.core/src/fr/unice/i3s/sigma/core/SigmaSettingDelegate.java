package fr.unice.i3s.sigma.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;

public class SigmaSettingDelegate extends
		AbstractSigmaDelegate<EStructuralFeature> implements SettingDelegate {

	private final BasicSettingDelegate.Stateless settingDelegate;

	public SigmaSettingDelegate(EStructuralFeature eStructuralFeature,
			SigmaDelegateDomain domain) {
		super(eStructuralFeature, domain,
				SigmaDelegateDomain.SETTER_CONSTRAINT_KEY);

		settingDelegate = new BasicSettingDelegate.Stateless(eStructuralFeature) {

			@Override
			protected Object get(InternalEObject owner, boolean resolve,
					boolean coreType) {
				return SigmaSettingDelegate.this.get(owner, resolve, coreType);
			}

			@Override
			protected boolean isSet(InternalEObject owner) {
				return false; // derived features are, implicitly, never set
			}

		};
	}

	protected Object get(InternalEObject owner, boolean resolve,
			boolean coreType) {

		Method delegate = getDelegateChecked(owner);

		try {
			Object value = delegate.invoke(null, owner);
			return domain.processResult(target, value);
		} catch (IllegalArgumentException e) {
			throw domain.handleIllegalArgumentException(delegate, owner, e);
		} catch (IllegalAccessException e) {
			throw domain.handleIllegalAccessException(delegate, owner, e);
		} catch (InvocationTargetException e) {
			throw domain.handleInvocationTargetException(delegate, owner, e);
		}
	}

	protected String getExpectedMethodSignature() {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(domain.elementTypeName(target));
		sb.append(" ");
		sb.append(getDelegateMethodName());
		sb.append("(");

		// add self
		sb.append(domain.classifierTypeName(target.getEContainingClass()));
		sb.append(" self");

		sb.append(");");

		return sb.toString();
	}

	@Override
	protected boolean checkDelegateMethod(Method input) {
		// must have compatible return type
		if (!domain.checkElementType(target, input.getGenericReturnType())) {
			return false;
		}

		Class<?>[] delegateParams = input.getParameterTypes();

		// must have first argument of type of the setter container
		if (!(delegateParams.length == 1 && domain.checkClassifierType(
				target.getEContainingClass(), delegateParams[0]))) {
			return false;
		}

		return true;
	}

	@Override
	protected String getDelegateMethodName() {
		EClassifier retType = target.getEType();
		
		if (retType == EcorePackage.eINSTANCE.getEBoolean()
				|| retType == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return "is" + Utils.capitalize(target.getName());
		} else {
			return "get" + Utils.capitalize(target.getName());
		}
	}

	public final Setting dynamicSetting(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID) {
		return settingDelegate
				.dynamicSetting(owner, settings, dynamicFeatureID);
	}

	public final Object dynamicGet(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID, boolean resolve,
			boolean coreType) {
		return settingDelegate.dynamicGet(owner, settings, dynamicFeatureID,
				resolve, coreType);
	}

	public final boolean dynamicIsSet(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID) {
		return settingDelegate.dynamicIsSet(owner, settings, dynamicFeatureID);
	}

	public final void dynamicSet(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID, Object newValue) {
		settingDelegate.dynamicSet(owner, settings, dynamicFeatureID, newValue);
	}

	public final void dynamicUnset(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID) {
		settingDelegate.dynamicUnset(owner, settings, dynamicFeatureID);
	}

	public final NotificationChain dynamicInverseAdd(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID,
			InternalEObject otherEnd, NotificationChain notifications) {
		return settingDelegate.dynamicInverseAdd(owner, settings,
				dynamicFeatureID, otherEnd, notifications);
	}

	public final NotificationChain dynamicInverseRemove(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID,
			InternalEObject otherEnd, NotificationChain notifications) {
		return settingDelegate.dynamicInverseRemove(owner, settings,
				dynamicFeatureID, otherEnd, notifications);
	}

}

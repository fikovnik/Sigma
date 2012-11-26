package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;

import fr.unice.i3s.sigma.core.Utils;

public class SigmaSettingDelegate extends
		AbstractSigmaDelegate<EStructuralFeature> implements SettingDelegate {

	private final BasicSettingDelegate.Stateless settingDelegate;

	public SigmaSettingDelegate(EStructuralFeature target,
			SigmaDelegateDomain domain) {
		super(target, domain);

		settingDelegate = new BasicSettingDelegate.Stateless(target) {

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

		Method delegate = null;
		try {
			delegate = getDelegate();
		} catch (SigmaDelegateNotFoundException e) {
			handleDelegateNotFoundException(e);
		}

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

	@Override
	public final Setting dynamicSetting(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID) {
		return settingDelegate
				.dynamicSetting(owner, settings, dynamicFeatureID);
	}

	@Override
	public final Object dynamicGet(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID, boolean resolve,
			boolean coreType) {
		return settingDelegate.dynamicGet(owner, settings, dynamicFeatureID,
				resolve, coreType);
	}

	@Override
	public final boolean dynamicIsSet(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID) {
		return settingDelegate.dynamicIsSet(owner, settings, dynamicFeatureID);
	}

	@Override
	public final void dynamicSet(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID, Object newValue) {
		settingDelegate.dynamicSet(owner, settings, dynamicFeatureID, newValue);
	}

	@Override
	public final void dynamicUnset(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID) {
		settingDelegate.dynamicUnset(owner, settings, dynamicFeatureID);
	}

	@Override
	public final NotificationChain dynamicInverseAdd(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID,
			InternalEObject otherEnd, NotificationChain notifications) {
		return settingDelegate.dynamicInverseAdd(owner, settings,
				dynamicFeatureID, otherEnd, notifications);
	}

	@Override
	public final NotificationChain dynamicInverseRemove(InternalEObject owner,
			DynamicValueHolder settings, int dynamicFeatureID,
			InternalEObject otherEnd, NotificationChain notifications) {
		return settingDelegate.dynamicInverseRemove(owner, settings,
				dynamicFeatureID, otherEnd, notifications);
	}

	@Override
	public String getMethodSignature() {
		StringBuilder sb = new StringBuilder();

		sb.append("public static ");
		sb.append(domain.elementTypeName(target));
		sb.append(" ");
		sb.append(getExpectedMethodName());
		sb.append("(");

		// add self
		sb.append(domain.classifierTypeName(target.getEContainingClass()));
		sb.append(" self");

		sb.append(");");

		return sb.toString();
	}

	@Override
	public String getExpectedMethodName() {
		EClassifier retType = target.getEType();

		if (retType == EcorePackage.eINSTANCE.getEBoolean()
				|| retType == EcorePackage.eINSTANCE.getEBooleanObject()) {
			return "is" + Utils.capitalize(target.getName());
		} else {
			return "get" + Utils.capitalize(target.getName());
		}
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
	protected EClassifier getContainingEClass() {
		return target.getEContainingClass();
	}

}

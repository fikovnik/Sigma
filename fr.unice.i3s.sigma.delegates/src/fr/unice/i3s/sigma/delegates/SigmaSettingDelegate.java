package fr.unice.i3s.sigma.delegates;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.DynamicValueHolder;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicSettingDelegate;

public class SigmaSettingDelegate extends
		AbstractSigmaDelegate<EStructuralFeature> implements SettingDelegate {

	private final BasicSettingDelegate.Stateless settingDelegate;

	public SigmaSettingDelegate(Method delegate, EStructuralFeature target,
			SigmaDelegateDomain domain) {
		super(delegate, target, domain);

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

}

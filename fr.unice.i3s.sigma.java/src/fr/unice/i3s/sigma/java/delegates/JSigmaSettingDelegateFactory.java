package fr.unice.i3s.sigma.java.delegates;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory;

public class JSigmaSettingDelegateFactory extends AbstractSigmaDelegateFactory
		implements Factory {

	@Override
	public JSigmaSettingDelegate createSettingDelegate(EStructuralFeature target) {
		JSigmaSettingDelegate delegate = null;

		if (hasBeenDelegated(target)) {
			delegate = doCreateSettingDelegate(target);
		}

		return delegate;
	}

	@Override
	public JSigmaDelegateDomain getDomain() {
		return JSigmaDelegateDomain.getDefaultInstance();
	}

	protected JSigmaSettingDelegate doCreateSettingDelegate(
			EStructuralFeature target) {
		return new JSigmaSettingDelegate(target, getDomain());
	}

	protected boolean hasBeenDelegated(EStructuralFeature target) {
		return target.isDerived()
				&& target.getEAnnotation(getDomain().getURI()) != null;
	}

}

package fr.unice.i3s.sigma.delegates;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory;

public class SigmaSettingDelegateFactory extends AbstractSigmaDelegateFactory
		implements Factory {

	@Override
	public SigmaSettingDelegate createSettingDelegate(EStructuralFeature target) {
		SigmaSettingDelegate delegate = null;

		if (hasBeenDelegated(target)) {
			delegate = doCreateSettingDelegate(target);
		}

		return delegate;
	}

	@Override
	public SigmaDelegateDomain getDomain() {
		return SigmaDelegateDomain.getDefaultInstance();
	}

	protected SigmaSettingDelegate doCreateSettingDelegate(
			EStructuralFeature target) {
		return new SigmaSettingDelegate(target, getDomain());
	}

	protected boolean hasBeenDelegated(EStructuralFeature target) {
		return target.getEAnnotation(getDomain().getURI()) != null;
	}

}

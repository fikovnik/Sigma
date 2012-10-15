package fr.unice.i3s.sigma.delegates;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate;
import org.eclipse.emf.ecore.EStructuralFeature.Internal.SettingDelegate.Factory;

public final class SigmaSettingDelegateFactory implements Factory {

	private final SigmaDelegateDomain domain = SigmaDelegateDomain.getDefaultInstance();

	@Override
	public SettingDelegate createSettingDelegate(
			EStructuralFeature eStructuralFeature) {
		return new SigmaSettingDelegate(eStructuralFeature, domain);
	}

}

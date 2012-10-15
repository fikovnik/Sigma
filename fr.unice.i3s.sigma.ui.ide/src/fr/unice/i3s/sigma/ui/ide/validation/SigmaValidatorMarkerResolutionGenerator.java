package fr.unice.i3s.sigma.ui.ide.validation;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.google.common.collect.Collections2.filter;
import static com.google.common.collect.Collections2.transform;

import java.util.Collection;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

import fr.unice.i3s.sigma.ui.ide.validation.ISigmaQuickFixManager.ISigmaQuickFixEntry;

public class SigmaValidatorMarkerResolutionGenerator implements
		IMarkerResolutionGenerator {

	private static final IMarkerResolution[] NONE = new IMarkerResolution[] {};

	private static final IMarkerResolution IGNORE = new IMarkerResolution() {

		@Override
		public String getLabel() {
			return "Ignore";
		}

		@Override
		public void run(IMarker marker) {
			try {
				marker.delete();
			} catch (CoreException e) {
				// TODO: log
				e.printStackTrace();
			}
		}

	};

	private final ISigmaQuickFixManager quickFixManager;

	public SigmaValidatorMarkerResolutionGenerator() {
		this(SigmaQuickFixManager.getInstance());
	}

	public SigmaValidatorMarkerResolutionGenerator(
			ISigmaQuickFixManager quickFixManager) {
		this.quickFixManager = quickFixManager;
	}

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		try {
			String eCoreDiagnosticMarker = "org.eclipse.emf.ecore.diagnostic";
			if (!marker.getType().equals(eCoreDiagnosticMarker)
					&& !marker.isSubtypeOf(eCoreDiagnosticMarker)) {
				return NONE;
			}
		} catch (CoreException e) {
			return NONE;
		}

		// the problem description
		final String message = SigmaQuickFixManager.getMarkerMessage(marker);
		// the eObject URI
		URI eObjectURI = SigmaQuickFixManager.getMarkerURI(marker);

		if (eObjectURI == null || isNullOrEmpty(message)) {
			return NONE;
		}

		// all fixes for given object
		Collection<ISigmaQuickFixEntry> allFixes = quickFixManager
				.get(eObjectURI);

		// all fixes that matches the message
		Collection<ISigmaQuickFixEntry> fixes = filter(allFixes,
				new Predicate<ISigmaQuickFixEntry>() {
					@Override
					public boolean apply(ISigmaQuickFixEntry input) {
						return message.equals(input.getMessage());
					}
				});

		Collection<IMarkerResolution> resCol = transform(fixes,
				new Function<ISigmaQuickFixEntry, IMarkerResolution>() {
					@Override
					public IMarkerResolution apply(ISigmaQuickFixEntry input) {
						return new SigmaQuickFixMarkerResolution(input);
					}
				});

		IMarkerResolution[] res = resCol.toArray(new IMarkerResolution[fixes
				.size() + 1]);
		res[res.length - 1] = IGNORE;

		return res;
	}

}

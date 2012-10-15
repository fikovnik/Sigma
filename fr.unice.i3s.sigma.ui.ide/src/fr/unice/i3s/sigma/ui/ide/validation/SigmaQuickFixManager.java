package fr.unice.i3s.sigma.ui.ide.validation;

import static com.google.common.base.Strings.isNullOrEmpty;

import java.util.Collection;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EValidator;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import fr.unice.i3s.sigma.core.ISigmaQuickFix;

public final class SigmaQuickFixManager implements ISigmaQuickFixManager {

	static class SigmaQuickFixEntry implements ISigmaQuickFixEntry {

		private final String message;
		private final ISigmaQuickFix quickFix;

		public SigmaQuickFixEntry(String message, ISigmaQuickFix quickFix) {
			this.message = message;
			this.quickFix = quickFix;
		}

		@Override
		public String getMessage() {
			return message;
		}

		@Override
		public ISigmaQuickFix getQuickFix() {
			return quickFix;
		}

	}

	private static final ISigmaQuickFixManager INSTANCE = new SigmaQuickFixManager();

	public static ISigmaQuickFixManager getInstance() {
		return INSTANCE;
	}

	private final Multimap<URI, ISigmaQuickFixEntry> quickFixes = ArrayListMultimap
			.<URI, ISigmaQuickFixEntry> create();

	@Override
	public synchronized void add(URI eObjectURI, String message,
			ISigmaQuickFix quickFix) {
		quickFixes.put(eObjectURI, new SigmaQuickFixEntry(message, quickFix));
	}

	@Override
	public synchronized void addAll(URI eObjectURI, String message,
			Iterable<ISigmaQuickFix> quickFixs) {
		for (ISigmaQuickFix qf : quickFixs) {
			quickFixes.put(eObjectURI, new SigmaQuickFixEntry(message, qf));
		}
	}

	@Override
	public synchronized Collection<ISigmaQuickFixEntry> get(URI eObjectURI) {
		return quickFixes.get(eObjectURI);
	}

	@Override
	public synchronized void removeAll(URI eObjectURI) {
		quickFixes.removeAll(eObjectURI);
	}

	public static String getMarkerMessage(IMarker marker) {
		return marker.getAttribute(IMarker.MESSAGE, null);
	}

	public static URI getMarkerURI(IMarker marker) {
		String eObjectURI = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if (isNullOrEmpty(eObjectURI)) {
			return null;
		}

		// the eObject URI
		URI uri = null;

		try {
			uri = URI.createURI(eObjectURI);
		} catch (IllegalArgumentException e) {
			// TODO: log
			e.printStackTrace();
		}

		return uri;
	}

}

package fr.unice.i3s.sigma.ui.ide.validation;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import fr.unice.i3s.sigma.core.ISigmaQuickFix;

public interface ISigmaQuickFixManager {

	public interface ISigmaQuickFixEntry {
		public String getMessage();

		public ISigmaQuickFix getQuickFix();
	}

	public Collection<ISigmaQuickFixEntry> get(URI eObjectURI);

	public void add(URI eObjectURI, String message, ISigmaQuickFix entry);

	public void addAll(URI eObjectURI, String message,
			Iterable<ISigmaQuickFix> results);

	public void removeAll(URI eObjectURI);
}

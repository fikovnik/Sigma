package fr.unice.i3s.sigma.core;

import static com.google.common.collect.Iterables.isEmpty;
import static fr.unice.i3s.sigma.core.Assert.require;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.util.Diagnostic;
import com.google.common.collect.ImmutableList;

public final class ValidationResult {

	/**
	 * The bit mask value <code>0x0</code> for a {@link #getSeverity severity}
	 * indicating everything is okay.
	 * 
	 * @see Diagnostic#OK
	 */
	public static final int OK = Diagnostic.OK;

	/**
	 * The bit mask value <code>0x1</code> for a {@link #getSeverity severity}
	 * indicating there is an informational message.
	 * 
	 * @see Diagnostic#INFO
	 */
	public static int INFO = Diagnostic.INFO;

	/**
	 * The bit mask value <code>0x2</code> for a {@link #getSeverity severity}
	 * indicating there is warning message.
	 * 
	 * @see Diagnostic#WARNING
	 */
	public static final int WARNING = Diagnostic.WARNING;

	/**
	 * The bit mask value <code>0x4</code> for a {@link #getSeverity severity}
	 * indicating there is an error message.
	 * 
	 * @see Diagnostic#ERROR
	 */
	public static final int ERROR = Diagnostic.ERROR;

	/**
	 * The bit mask value <code>8</code> for a {@link #getSeverity severity}
	 * indicating that the diagnosis was canceled.
	 * 
	 * @see Diagnostic#CANCEL
	 */
	public static int CANCEL = Diagnostic.CANCEL;

	private final int severity;

	private final String message;

	private final Collection<ISigmaQuickFix> quickFixes;

	public ValidationResult(int severity, String message) {
		this.severity = severity;
		this.message = message;
		this.quickFixes = Collections.emptyList();
	}

	public ValidationResult(int severity, String message,
			Collection<? extends ISigmaQuickFix> quickFixes) {

		require(!(severity > OK)
				|| (quickFixes != null && !isEmpty(quickFixes)),
				"Quick fixes can only be provided in case that result's severity is other than OK.");

		this.severity = severity;
		this.message = message;
		this.quickFixes = ImmutableList.<ISigmaQuickFix> copyOf(quickFixes);
	}

	public int getSeverity() {
		return severity;
	}

	public String getMessage() {
		return message;
	}

	public Collection<ISigmaQuickFix> getQuickFixes() {
		return quickFixes;
	}

	public static ValidationResult ok() {
		return new ValidationResult(OK, "");
	}

	public static ValidationResult info(String message) {
		return new ValidationResult(INFO, message);
	}

	public static ValidationResult warning(String message) {
		return new ValidationResult(WARNING, message);
	}

	public static ValidationResult error(String message) {
		return new ValidationResult(ERROR, message);
	}

	public static ValidationResult cancel() {
		return new ValidationResult(CANCEL, "");
	}

	public static ValidationResult cancel(String message) {
		return new ValidationResult(CANCEL, message);
	}

	public boolean isValidOrCanceled() {
		return severity == OK || severity == CANCEL;
	}
}

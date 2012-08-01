package fr.unice.i3s.sigma.core;

import org.eclipse.emf.common.util.Diagnostic;

public final class SigmaValidationResult {

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

	public SigmaValidationResult(int severity, String message) {
		this.severity = severity;
		this.message = message;
	}

	public int getSeverity() {
		return severity;
	}

	public String getMessage() {
		return message;
	}

	public static SigmaValidationResult ok() {
		return new SigmaValidationResult(OK, "");
	}

	public static SigmaValidationResult info(String message) {
		return new SigmaValidationResult(INFO, message);
	}

	public static SigmaValidationResult warning(String message) {
		return new SigmaValidationResult(WARNING, message);
	}

	public static SigmaValidationResult error(String message) {
		return new SigmaValidationResult(ERROR, message);
	}

	public static SigmaValidationResult cancel(String message) {
		return new SigmaValidationResult(CANCEL, message);
	}

	public boolean isValidOrCanceled() {
		return severity == OK || severity == CANCEL;
	}
}

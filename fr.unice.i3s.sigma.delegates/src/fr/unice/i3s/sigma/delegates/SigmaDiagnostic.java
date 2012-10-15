package fr.unice.i3s.sigma.delegates;

import static fr.unice.i3s.sigma.core.Assert.notNull;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

import com.google.common.collect.ImmutableList;

import fr.unice.i3s.sigma.core.ISigmaDiagnostic;
import fr.unice.i3s.sigma.core.ISigmaQuickFix;
import fr.unice.i3s.sigma.core.ValidationResult;

class SigmaDiagnostic implements ISigmaDiagnostic {

	public static ISigmaDiagnostic fromException(String constraint,
			EObject eObject, String source, int code, String message,
			Throwable exception) {

		return new SigmaDiagnostic(eObject, constraint, source, code, ERROR,
				message, exception, Collections.<ISigmaQuickFix> emptyList());
	}

	public static ISigmaDiagnostic fromResult(EObject eObject,
			String constraint, String source, int code, ValidationResult result) {

		return new SigmaDiagnostic(eObject, constraint, source, code, ERROR,
				result.getMessage(), null, result.getQuickFixes());
	}

	private final EObject eObject;
	private final String constraint;
	private final String source;
	private final int code;
	private final int severity;
	private final String message;
	private final Throwable exception;
	private final Collection<ISigmaQuickFix> quickFixes;

	public SigmaDiagnostic(EObject eObject, String constraint, String source,
			int code, int severity, String message, Throwable exception,
			Collection<ISigmaQuickFix> quickFixes) {

		this.constraint = notNull(constraint);
		this.eObject = notNull(eObject);
		this.source = notNull(source);
		this.code = code;
		this.severity = severity;
		this.message = notNull(message);
		this.exception = exception;
		this.quickFixes = notNull(quickFixes);
	}

	@Override
	public int getSeverity() {
		return severity;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getSource() {
		return source;
	}

	@Override
	public int getCode() {
		return code;
	}

	@Override
	public Throwable getException() {
		return exception;
	}

	@Override
	public List<?> getData() {
		return ImmutableList.<EObject> of(eObject);
	}

	@Override
	public List<Diagnostic> getChildren() {
		return Collections.emptyList();
	}

	@Override
	public String getConstraint() {
		return constraint;
	}

	@Override
	public Collection<ISigmaQuickFix> getQuickFixes() {
		return quickFixes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SigmaDiagnostic ");
		switch (severity) {
		case OK:
			sb.append("OK");
			break;
		case INFO:
			sb.append("INFO");
			break;
		case WARNING:
			sb.append("WARNING");
			break;
		case ERROR:
			sb.append("ERROR");
			break;
		case CANCEL:
			sb.append("CANCEL");
			break;
		default:
			sb.append(Integer.toHexString(severity));
			break;
		}

		sb.append(" source=").append(source);
		sb.append(" code=").append(code);
		sb.append(' ').append(message);

		if (eObject != null) {
			sb.append(" data=").append(eObject);
		}

		if (exception != null) {
			sb.append(" exception=").append(exception);
		}
		if (quickFixes.size() > 0) {
			sb.append(" quickFixes=").append(quickFixes);
		}
		return sb.toString();
	}
}
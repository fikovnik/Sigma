package fr.unice.i3s.sigma.java.delegates;

/**
 * This exceptions occurs when at runtime a Sigma delegate cannot be resolved to
 * a {@link Method}.
 * 
 * @author krikava
 * 
 */
@SuppressWarnings("serial")
public final class SigmaDelegateNotFoundException extends RuntimeException {

	public SigmaDelegateNotFoundException(String message) {
		super(message, null);
	}

	public SigmaDelegateNotFoundException(String message, Exception cause) {
		super(message, cause);
	}
}

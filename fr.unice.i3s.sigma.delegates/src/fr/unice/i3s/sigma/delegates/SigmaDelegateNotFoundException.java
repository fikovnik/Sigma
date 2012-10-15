package fr.unice.i3s.sigma.delegates;


@SuppressWarnings("serial")
public final class SigmaDelegateNotFoundException extends RuntimeException {

		public SigmaDelegateNotFoundException(String message) {
			super(message, null);
		}

		public SigmaDelegateNotFoundException(String message, Exception cause) {
			super(message, cause);
		}
	}


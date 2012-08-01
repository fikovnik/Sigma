package fr.unice.i3s.sigma.core;


@SuppressWarnings("serial")
public final class SigmaDelegateException extends RuntimeException {

		public SigmaDelegateException(String message) {
			super(message, null);
		}

		public SigmaDelegateException(String message, Throwable cause) {
			super(message, cause);
		}
	}


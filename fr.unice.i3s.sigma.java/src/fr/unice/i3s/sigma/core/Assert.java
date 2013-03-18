package fr.unice.i3s.sigma.core;

import static com.google.common.base.Strings.isNullOrEmpty;

public final class Assert {

	public static void require(boolean condition, String message) {
		if (!condition) {
			if (isNullOrEmpty(message)) {
				throw new IllegalArgumentException(
						"Required condition is not legal");
			} else {
				throw new IllegalArgumentException(message);
			}
		}
	}

	public static <T> T notNull(T instance) {
		return notNull(instance, null);
	}

	public static <T> T notNull(T instance, String message) {
		if (instance == null) {
			if (isNullOrEmpty(message)) {
				throw new IllegalArgumentException("Argument must not be null");
			} else {
				throw new IllegalArgumentException(message);
			}
		} else {
			return instance;
		}
	}

}

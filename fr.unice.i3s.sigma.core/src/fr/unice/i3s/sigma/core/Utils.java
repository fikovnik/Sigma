package fr.unice.i3s.sigma.core;

import static java.util.Locale.ENGLISH;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.osgi.util.NLS;

public final class Utils {

	private Utils() {

	}

	/**
	 * Returns a String which capitalizes the first letter of the string.
	 */
	public static String capitalize(String name) {
		if (name == null || name.length() == 0) {
			return name;
		}
		return name.substring(0, 1).toUpperCase(ENGLISH) + name.substring(1);
	}

	public static String bind(String messageId, Object... values) {
		return NLS.bind(messageId, values);
	}

	public static String getAnnotationDetail(EModelElement element,
			String source, String detail) {

		EAnnotation annotation = element.getEAnnotation(source);
		if (annotation == null) {
			return null;
		}

		return annotation.getDetails().get(detail);
	}

}

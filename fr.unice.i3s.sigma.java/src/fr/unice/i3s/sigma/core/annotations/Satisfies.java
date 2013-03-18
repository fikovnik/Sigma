package fr.unice.i3s.sigma.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface Satisfies {
	/**
	 * Name of the other constrains that has to be satisfied in order to have
	 * the constraint evaluated.
	 * 
	 * @return
	 */
	String[] value() default {};

	// TODO: add bit more options
	// String[] one() default {};
	//
	// String[] all() default {};
}

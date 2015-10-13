package com.netbuilder.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Custom annotation example
 * 
 * @author jthompson
 *
 */
@Target ({ METHOD, CONSTRUCTOR })
@Retention (RUNTIME)
@Documented
public @interface MethodAuthor {
	String author() default "Undefined";
}
package com.feliphe.example.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	// define default course code
	String value() default "LUV";

	// define default message error
	String message() default "must start with LUV";

	// define default groups
	Class<?>[] groups() default {};

	// define default payloads
	Class<? extends Payload>[] payload() default {};

}

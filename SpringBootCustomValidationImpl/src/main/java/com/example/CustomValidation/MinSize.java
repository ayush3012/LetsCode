package com.example.CustomValidation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target({ FIELD, PARAMETER })
@Constraint(validatedBy= MinSizeValidator.class)
public @interface MinSize {
	
	String message() default "minimum size allowed 2";
	
	//Need to understand more:--
	Class[] groups() default {};   //represents group of constraints  
    Class[] payload() default {};   //represents additional information about annotation  

}

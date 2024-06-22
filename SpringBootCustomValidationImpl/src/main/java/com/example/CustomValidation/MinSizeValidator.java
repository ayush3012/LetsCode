package com.example.CustomValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class MinSizeValidator implements ConstraintValidator<MinSize,Integer> {

	@Override
	public boolean isValid(Integer id, ConstraintValidatorContext arg1) {
		return id>9;
	}

}

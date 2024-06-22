package com.example.controller;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	
	private MessageSource messageSource;
	
	@Autowired
	ApplicationController(MessageSource messageSource)
	{
		this.messageSource=messageSource;
	}
	
	@GetMapping("/i18n")
	public String i18nImpl()
	{
		Locale locale =LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message",locale);
	}
}

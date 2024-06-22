package com.example.DynamicFiltering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilterController {
	
	@GetMapping("/first-api")
	public MappingJacksonValue Api1()
	{
		Bean bean=new Bean("f1","f2","f3");
		MappingJacksonValue mjv=new MappingJacksonValue(bean);
		
		SimpleBeanPropertyFilter sbpf= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters= new SimpleFilterProvider().addFilter("BeanFilter",sbpf);
		
		mjv.setFilters(filters);
		
		return mjv;
	}
	
	@GetMapping("/second-api")
	public MappingJacksonValue Api2()
	{
		Bean bean=new Bean("f1","f2","f3");
		MappingJacksonValue mjv=new MappingJacksonValue(bean);
		
		SimpleBeanPropertyFilter sbpf= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		
		FilterProvider filters= new SimpleFilterProvider().addFilter("BeanFilter",sbpf);
		
		mjv.setFilters(filters);
		
		return mjv;
	}

}

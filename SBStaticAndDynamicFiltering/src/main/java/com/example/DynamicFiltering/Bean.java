package com.example.DynamicFiltering;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFilter;

@Component
@JsonFilter("BeanFilter")
public class Bean {

	String field1;
	String field2;
	String field3;
	Bean(String field1, String field2, String field3) {
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	Bean(){}
	public String getField1() {
		return field1;
	}
	public String getField2() {
		return field2;
	}
	public String getField3() {
		return field3;
	}
	@Override
	public String toString() {
		return "Bean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	
}

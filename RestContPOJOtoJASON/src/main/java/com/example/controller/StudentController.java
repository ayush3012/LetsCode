package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;

@RestController
public class StudentController {
	
	@GetMapping("/GetStu")
	public List<Student> getStudents() 
	{
		List<Student> stu=new ArrayList<>();
		stu.add(new Student("ayush","karna"));
		stu.add(new Student("meenakshi","bhasin"));
		stu.add(new Student("tina","francis"));
		return stu;
		
	}

}

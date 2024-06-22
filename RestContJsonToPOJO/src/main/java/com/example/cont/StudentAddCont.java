package com.example.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;

@RestController
public class StudentAddCont {
	
	@Autowired
	Student stu;
	
	@PostMapping("/createHere")
	public void addStudent(@RequestBody Student s)
	{
		stu.setFname(s.fname);
		stu.setLname(s.lname);
		System.out.println("Student created");
	}

	@GetMapping("/listHere")
	public Student showStudent()
	{
		System.out.println(stu.fname+" "+stu.lname);
		return stu;
	}

}

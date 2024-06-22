package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.handleException.StudentNotFoundException;
import com.example.repo.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@GetMapping("/listhere")
	public List<Student> getStudent()
	{
		List<Student> al=repo.findAll();
		System.out.println("students returned");
		return al;
	}

	@PostMapping("/savehere")
	public void saveStudent(@RequestBody Student stu)
	{
		Student s=new Student();
		s.setFirstname(stu.getFirstname());
		s.setId(stu.getId());
		s.setLastname(stu.getLastname());
		s.setSalary(stu.getSalary());
		repo.save(s);
		System.out.println("student with "+ stu.getId()+" saved in db");
	}
	
	@DeleteMapping("/deletehere/{did}")
	public void deleteStudent(@PathVariable int did)
	{
		repo.deleteById(did);
		System.out.println("student with id "+ did+" deleted from db");
	}
	@PutMapping("/updatehere")
	public void updateStudent(@RequestParam int d,@RequestBody Student stu)
	{
		List<Student> s=repo.findAll();
		Student ss=new Student();
		for(Student st:s)
		{
			if(st.getId()==d)
			{
				ss=st;
				break;
			}
		}
		ss.setFirstname(stu.getFirstname());
		ss.setLastname(stu.getLastname());
		ss.setSalary(stu.getSalary());
		repo.save(ss);
		System.out.println("student with id "+d+" updated");
		
	}
	@GetMapping("/one/{sid}")
	public Student getOne(@PathVariable int sid)
	{
	    boolean flag=false;
		List<Student> list=repo.findAll();
		for(Student s:list)
			if(s.getId()==sid)
				return s;
			else flag=true;
		if(flag)
			throw new StudentNotFoundException("not found with "+sid);
		return null;
	}
}

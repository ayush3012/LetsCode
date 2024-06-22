package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repository.MyRepository;

@RestController
public class MyController {
	
	@Autowired
	MyRepository repo;
	
	@GetMapping("/fetchAll")
	public List<Student> getStudents()
	{
		return repo.findAll();
	}
	
	@GetMapping("/fetchOne/{id}")
	public Student getStudent(@PathVariable int id)
	{
		return repo.findAll().stream().filter(i->i.getId()==id).findFirst().get();
	}
	
	@PostMapping("/commit")
	public String save(@RequestBody Student stu)
	{
		repo.save(stu);
		return stu.toString();
	}

}

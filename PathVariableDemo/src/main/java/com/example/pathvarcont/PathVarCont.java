package com.example.pathvarcont;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;

@RestController
public class PathVarCont {
	
	List<Student> stu;
	//localhost:8080/addlist
	@GetMapping("/addlist")
	public List<Student> addStudent(){
	stu=new ArrayList<>();
	stu.add(new Student("ayush","karna"));
	stu.add(new Student("meenakshi","bhasin"));
	stu.add(new Student("tina","francis"));
	return stu;
	}
	//localhost:8080/list/1
	@GetMapping("/list/{sid}")
	public Student getStudent(@PathVariable int sid)
	{
		return stu.get(sid);
	}
	//localhost:8080/list?sid=1
		@GetMapping("/list")
		public Student getStudentRP(@RequestParam int sid)
		{
			return stu.get(sid);
		}

}

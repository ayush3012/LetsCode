package com.example.StudentController;

import java.util.ArrayList;
import java.util.List;
import com.example.Entity.Student;
import com.example.StuErrorResponse.StudentErrorResponse;
import com.example.StuErrorResponse.StudentNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ControllerAdvice:-this is global exception handler that handles exception from all controller
public class StudentController {
	
	List<Student> al=new ArrayList<>();
	
	@PostMapping("/createhere")
	public void saveStudent(@RequestBody Student s)
	{
		al.add(new Student("ayush","karna"));
		System.out.println("student added...");
	}
	@GetMapping("/viewhere")
	public List<Student> show()
	{
		System.out.println("returned students..");
		return al;
	}
	@GetMapping("/singleview/{sid}") 
	public Student getOne(@PathVariable int sid )
	{
		if(sid>al.size() || sid<0)
			throw new StudentNotFoundException("student not found with "+sid);
		System.out.println("returned student "+sid);
		return al.get(sid);
	}
	/*
	//argument class will be matched to handle exception,
	//@ExceptionHandler is for current controller only
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException snfe)
	{
		StudentErrorResponse error=new StudentErrorResponse();
		error.setMessage(snfe.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	public ResponseEntity<StudentErrorResponse> handleException(Exception e)
	{
		StudentErrorResponse error=new StudentErrorResponse();
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	*/
}

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerCls {

	@GetMapping("/RestDemo")
	public String getMessage()
	{
		return "hello ayush rest demo";
	}
}


//Post: create new Resource
//Put: If resource not exist then create , if exists then update ::it will not throw exception 
                                           //if resource not found
//patch:If resource not exist then throw exception , if exist then partial update
//put an patch are both for partial updation
//options: if clients call options on server then it will return all the allowed 
                  //http methods on that server like, GET/POST/PUT/OPTIONS/DELETE
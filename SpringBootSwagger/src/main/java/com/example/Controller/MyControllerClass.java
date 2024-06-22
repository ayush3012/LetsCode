package com.example.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Entity.User;

@RestController
public class MyControllerClass {
	
	 static int userCount=0;
	
	static List<User> al=new ArrayList<>();
	
	static {
		
		al.add(new User(1,"ayush",LocalDate.now().minusYears(30)));
		al.add(new User(2,"jyoti",LocalDate.now().minusYears(15)));
		al.add(new User(3,"meenakshi",LocalDate.now().minusYears(20)));
	}
	
	@GetMapping("/user/all")
	public List<User> getAllUser()
	{
		return al;
	}
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable int id)
	{
		return al.stream().filter(i->i.getId()==id).findFirst().get(); 
	}
	
	@PostMapping("/save")
	public String saveUser(@RequestBody User us)
	{
		al.add(us);
		return us.toString();
	}

}

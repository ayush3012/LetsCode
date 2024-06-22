package com.example.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.User;

@RestController
public class ApiController {
	
	static List<User> al=new ArrayList<>();
	
	static {
		
		al.add(new User(1,"ayush",LocalDate.now().minusYears(20)));
		al.add(new User(2,"jyoti",LocalDate.now().minusYears(10)));
		al.add(new User(13,"meenakshi",LocalDate.now().minusYears(30)));
	}

	@GetMapping("/user/{id}")
	public User getUser(@Valid @PathVariable int id)
	{
		return al.stream().filter(i->i.getId()==id).findFirst().get();
	}
	
	@PostMapping("/save")
	public String saveUser(@Valid @RequestBody User usr)
	{
		al.add(usr);
		return usr.toString();
	}
}

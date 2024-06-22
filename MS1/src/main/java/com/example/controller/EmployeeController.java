package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.entity.Employee;
import com.example.repo.MyRepo;
import com.example.response.AddressResponse;
import com.example.response.EmployeeResponse;

@RestController
public class EmployeeController {
	
	final static String url="http://localhost:8086/one";
	
	@Autowired
	private MyRepo repo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//@Autowired
	private RestTemplate restTemplate=new RestTemplate();
	
	@GetMapping("/get")
	public List<Employee> getAllEmployee()
	{
		return repo.findAll();
	}

	@GetMapping("getone/{id}")
	public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable int id)
	{
		Employee emp=repo.findById(id).orElse(null);
		EmployeeResponse empRes=new EmployeeResponse();
		empRes.setId(emp.getEid());
		empRes.setFirstname(emp.getFirstname());
		empRes.setLastname(emp.getLastname());
		
		AddressResponse addr=restTemplate.getForObject(url+"/{id}", AddressResponse.class, id);
		
		empRes.setAddressResponse(addr);
		
		return ResponseEntity.status(HttpStatus.OK).body(empRes);
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Employee emp)
	{
		Employee e=new Employee(emp.getEid(),emp.getFirstname(),emp.getLastname());
		repo.save(e);
	}
	
}

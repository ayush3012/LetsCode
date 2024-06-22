package com.example.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Employee;

@RestController
public class EmployeeController {
	
	static List<Employee> al=new ArrayList<>();
	
	static {
		al.add(new Employee(1,"ayush",LocalDate.now().minusYears(20)));
		al.add(new Employee(2,"meenakshi",LocalDate.now().minusYears(15)));
		al.add(new Employee(3,"jyoti",LocalDate.now().minusYears(30)));
	}

	@RequestMapping(method=RequestMethod.GET,value="/emps")
	public List<Employee> getEmployee()
	{
		return al;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/emps/{id}")
	public Employee getEmployee(@PathVariable int id)
	{
		return al.stream().filter(i->i.getId()==id).findFirst().get();
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	public String saveEmployee(@RequestBody Employee emp)
	{
		al.add(emp);
		return emp.toString();
	}
}

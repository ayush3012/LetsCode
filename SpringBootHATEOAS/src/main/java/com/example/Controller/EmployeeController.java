package com.example.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
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
	public EntityModel<Employee> getEmployee(@Valid @PathVariable int id)
	{
		Employee employee=al.stream().filter(i->i.getId()==id).findFirst().get();
		
		EntityModel<Employee> entityModel= EntityModel.of(employee);
		
		// here we can hardcode link also but link can be changed so we provided method name to 
		// get corresponding link
		WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).getEmployee());
		
		entityModel.add(link.withRel("all-employees"));
		
		return entityModel;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	public String saveEmployee(@Valid @RequestBody Employee emp)
	{
		al.add(emp);
		return emp.toString();
	}
}

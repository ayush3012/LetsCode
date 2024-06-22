package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Address;
import com.example.repo.AddressRepo;
import com.example.response.AddressResponse;

@RestController
public class AddressController {
	
	@Autowired
	private AddressRepo repo;
	
	@GetMapping("/all")
	public List<Address> getAll()
	{
		return repo.findAll();
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<AddressResponse> getOne(@PathVariable int id)
	{
		Address add=repo.findById(id).orElse(null);
		AddressResponse addRes=new AddressResponse();
		addRes.setId(add.getId());
		addRes.setLane(add.getLane());
		addRes.setZip(add.getZip());
		addRes.setState(add.getState());
		return ResponseEntity.status(HttpStatus.OK).body(addRes);
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Address ad)
	{
		Address add=new Address(ad.getId(),ad.getLane(),ad.getZip(),ad.getState());
		repo.save(add);
	}
}

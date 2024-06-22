package com.example.controller;

import java.util.Map;
import javax.persistence.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Account;
import com.example.repo.AccountRepo;

@RestController
@CacheConfig(cacheNames = "Account")
public class AccountController {
	
	@Autowired
	private AccountRepo repo;
	
	@Autowired                 //implemented cache
	private Map<Integer,Account> cache;
	
	@GetMapping("/account/{id}")
	@CachePut(value="Account",key="#id",unless="#result==null")
	public Account getAccount(@PathVariable("id") int id)
	{
		if(cache.containsKey(id)) {
			System.out.println("returned from cache");
			return cache.get(id);
		}
		else
		{
			System.out.println("returned from DB...updating cache");
			cache.put(id,repo.findById(id).get());
			return repo.findById(id).orElse(null);
		}
	}
	
	@PostMapping("/create")
	public void saveAccount(@RequestBody Account ac)
	{
		cache.put(ac.getId(),ac);
		repo.save(ac);
	}

}

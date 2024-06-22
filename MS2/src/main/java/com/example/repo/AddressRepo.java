package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}

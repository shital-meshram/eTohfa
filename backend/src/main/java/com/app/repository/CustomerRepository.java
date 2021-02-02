package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojo.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer>{

	//List<Customers> findByName ()
	
	Customers findByEmail(String email);
	Customers findByEmailAndPassword(String email, String password);
	
}

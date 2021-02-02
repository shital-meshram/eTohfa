package com.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.app.pojo.Customers;

public interface ICustomerService {

	public List<Customers> getAllCustomers();
	
	public ResponseEntity<Customers> AddNewCustomer( Customers transientPOJO);
	
	public ResponseEntity<Customers> updateCustomerById(int id, Customers detachedPOJO);
	
	public Optional<Customers> getCustomerById(int id);
	
	public ResponseEntity<?> deleteAllCustomer();
	
	public ResponseEntity<?> deleteCustomerById(int id);
	
	public Customers findByEmailAndPassword(String email, String password);
	
	public ResponseEntity<Customers> findByEmail(String email);
}

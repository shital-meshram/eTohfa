package com.app.controller;

import java.io.Console;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojo.Address;
import com.app.pojo.Customers;
import com.app.service.IAddressService;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService custService;
	
	@Autowired
	private IAddressService addService;
	
	
	@GetMapping("/getcustomer")
	public ResponseEntity<?> getAllCustomer()
	{
		List<Customers> allCustomers = custService.getAllCustomers();
		
		if(allCustomers !=null)
		{
			return new ResponseEntity<>(allCustomers, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/register")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Customers> addNewCustomer(@RequestBody Customers cust)
	{
		try {
			return custService.AddNewCustomer(cust);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/getaddress")
	public List<Address> getAllAddress()
	{
		return addService.getAllAddress();
	}
	
	
	@PutMapping("/{customerId}")
	public ResponseEntity<Customers> updateCustomerDetails(@PathVariable int customerId, @RequestBody Customers cust)
	{
		try {
			return custService.updateCustomerById(customerId, cust);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public Optional<Customers> getCustomerById(@PathVariable int id)
	{
		return custService.getCustomerById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteAllCustomers()
	{
		return custService.deleteAllCustomer();
	}
	
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> deleteCustomerById(@PathVariable int customerId)
	{
		return custService.deleteCustomerById(customerId);
	}
	
	@GetMapping(value = "/login/{email}/{pass}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Customers loginCustomer(@PathVariable("email") String email, @PathVariable("pass") String password) 
	{
		
//		List<Customers> allCustomers = custService.getAllCustomers();
//		
//		for(Customers cust : allCustomers)
//		{
//			if(cust.getEmail().equals(email) && cust.getPassword().equals(password))
//			{
//				System.out.println("Customer Login Sucessfull");
//				return new ResponseEntity<>(HttpStatus.OK);
//			}
//		}
//		System.out.println("Bad Credentials");
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return custService.findByEmailAndPassword(email, password);
	} 
}









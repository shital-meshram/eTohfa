package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Customers;
import com.app.pojo.Employees;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	
	@GetMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employees> getAllEmployee()
	{
		return service.getAllEmployee();
	}
	
	@PostMapping
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> addNewEmployee(@RequestBody Employees newEmployee)
	{
		try {
			Employees emp = service.addNewEmployee(newEmployee);
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> deleteEmployee(@PathVariable int id)
	{
		
		String status = service.deteleteEmployeeById(id);
		if(status!=null)
		{
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/login/{email}/{pass}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employees LoginEmployee(@PathVariable("email") String email, @PathVariable("pass") String password)
	{
//		List<Employees> allEmployees = service.getAllEmployee();
//		
//		for(Employees emp : allEmployees)
//		{
//			if(emp.getEmail().equals(email) && emp.getPassword().equals(password))
//			{
//				System.out.println("Employee Login Sucessfull");
//				return new ResponseEntity<>(HttpStatus.OK);
//			}
//		}
//		System.out.println("Bad Credentials");
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		return service.EmployeeLogin(email, password);
	}
	
//	@GetMapping("/'{{role}}'")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public ResponseEntity<?> getAdmin(@PathVariable String role)
//	{
//		
//			Employees admin= this.service.getAdmin(role);
//			if(admin!=null)
//			{
//				return new ResponseEntity<>(admin, HttpStatus.OK);
//			}
//			
//		
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		
//	}
 	
}

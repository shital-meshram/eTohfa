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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojo.Credentials;
import com.app.pojo.Customers;
import com.app.service.ICredentialsService;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/credentials")
public class CredentialsController {

	
	@Autowired
	private ICredentialsService service;
	
	@Autowired
	private ICustomerService custService;
	
	@GetMapping
	public List<Credentials> getAllCredentials()
	{
		return service.getAllCredentials();
	}
	
	@PostMapping
	public ResponseEntity<?> addNewCredentials(@RequestBody Credentials transientPOJO)
	{
		try {
			Credentials credential= service.addCredentials(transientPOJO);
			return new ResponseEntity<>(credential, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/name/{name}") //NOTWORKING
	public ResponseEntity<?> getCredentialsByUserName(@PathVariable String username)
	{
		try {
			Credentials credentials = service.getCredentialByUsername(username);
			return new ResponseEntity<>(credentials, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAllCredentials(@PathVariable int id)
	{
		try {
			String msg = service.deleteCredential(id);
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getAllCredentialsById(@PathVariable int id)
	{
		try {
			Optional<Credentials> credentials = service.getCredentialsById(id);
			return new ResponseEntity<>(credentials, HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
}

package com.app.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.app.pojo.Address;
import com.app.pojo.Customers;
import com.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	
	@Override
	public ResponseEntity<Customers> AddNewCustomer(Customers cust) {
		
		Customers checkCust = custRepo.findByEmail(cust.getEmail());
				
		if(checkCust == null) {
			
			Address address = new Address();
			address.setCity(cust.getAddress().getCity());
			address.setCountry(cust.getAddress().getCountry());
			address.setPlotNo(cust.getAddress().getPlotNo());
			address.setPostalCode(cust.getAddress().getPostalCode());
			address.setState(cust.getAddress().getState());
					
			Customers customer= new Customers();
			customer.setFname(cust.getFname());
			customer.setLname(cust.getLname());
			customer.setEmail(cust.getEmail());
			customer.setPassword(cust.getPassword());
			customer.setAddress(address);
			checkCust = custRepo.save(cust);		
			
			return new ResponseEntity<>(checkCust, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		}

	}


	@Override
	public ResponseEntity<Customers> updateCustomerById(int id, Customers detachedPOJO) {
		
		Optional<Customers> existingCustomer = custRepo.findById(id);
		//CANNOT UPDATE EMAIL ID**********
		if(existingCustomer.isPresent())
		{
			Address address = existingCustomer.get().getAddress();
			address.setPlotNo(detachedPOJO.getAddress().getPlotNo());
			address.setCity(detachedPOJO.getAddress().getCity());
			address.setState(detachedPOJO.getAddress().getState());
			address.setCountry(detachedPOJO.getAddress().getCountry());
			address.setPostalCode(detachedPOJO.getAddress().getPostalCode());
			
			Customers customer = existingCustomer.get();
			customer.setFname(detachedPOJO.getFname());
			customer.setLname(detachedPOJO.getLname());
			customer.setPassword(detachedPOJO.getPassword());
			customer.setAddress(address);
			
			
			
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		
	}


	@Override
	public Optional<Customers> getCustomerById(int id) {
		
		return custRepo.findById(id);
	}


	@Override
	public ResponseEntity<?> deleteAllCustomer() {
		
		try {
			custRepo.deleteAll();
			return new ResponseEntity<> (HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


	@Override
	public ResponseEntity<?> deleteCustomerById(int id) {
		try {
			custRepo.deleteById(id);
			return  new ResponseEntity<> (HttpStatus.OK);
		}catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@Override
	public List<Customers> getAllCustomers() {
		try {
		  List<Customers> customers =  custRepo.findAll();
		  return customers;
		}catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public Customers findByEmailAndPassword(String email, String password) {

		return custRepo.findByEmailAndPassword(email, password);
	}


	@Override
	public ResponseEntity<Customers> findByEmail(String email) {
		custRepo.findByEmail(email);
		return null;
	}
	
	
	
	

}

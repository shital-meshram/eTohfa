package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Address;
import com.app.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addRepo;
	
	
	@Override
	public List<Address> getAllAddress() {
		
		return addRepo.findAll();
	}


	@Override
	public Address addNewAddress(Address addr) {
		
		return addRepo.save(addr);
	}

}

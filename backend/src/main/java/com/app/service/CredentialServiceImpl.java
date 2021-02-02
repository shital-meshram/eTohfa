package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Credentials;
import com.app.repository.CredentialsRepository;

@Service
@Transactional
public class CredentialServiceImpl  implements ICredentialsService{

	
	@Autowired
	private CredentialsRepository credRepo;
	@Override
	public List<Credentials> getAllCredentials() {
		
		return credRepo.findAll();
	}
	
	
	@Override
	public String deleteCredential(int credentialID) {
		
		credRepo.deleteAll();
		return "Credential with ID " + credentialID + " deleted";
	}


	@Override
	public Credentials getCredentialByUsername(String username) {
		
		return credRepo.findByUsername(username);
	}


	@Override
	public Credentials addCredentials(Credentials transientPOJO) {
		return credRepo.save(transientPOJO);
	}


	@Override
	public Optional<Credentials> getCredentialsById(int id) {
		
		return credRepo.findById(id);
	}




}

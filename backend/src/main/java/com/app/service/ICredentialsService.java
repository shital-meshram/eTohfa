package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojo.Credentials;

public interface ICredentialsService {

	public List<Credentials> getAllCredentials();
	
	public String deleteCredential(int credentialID);
	
	public Credentials getCredentialByUsername (String username);
	
	public Credentials addCredentials(Credentials transientPOJO);
	
	public Optional<Credentials> getCredentialsById(int id);
	
}

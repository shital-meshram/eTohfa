package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, Integer>{

	public Credentials findByUsername(String name);

}

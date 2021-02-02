package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

	//Employees findAllByRole(String role);
	Employees findByEmailAndPassword(String email, String password);
}

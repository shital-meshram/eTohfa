package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojo.Employees;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employees> getAllEmployee() {
		return empRepo.findAll();
	}

	@Override
	public Employees addNewEmployee(Employees newEmployee) {
		return empRepo.save(newEmployee);
	}

	@Override
	public String deteleteEmployeeById(int id) {
		empRepo.deleteById(id);
		return "deleted sucessfully...";
	}

	@Override
	public Employees EmployeeLogin(String email, String password) {
		return empRepo.findByEmailAndPassword(email, password);
		 
	}

//	@Override
//	public Employees getAdmin(String role) {
//		Employees emp = this.empRepo.findAllByRole(role);
//		System.out.println("In get admin"+emp);
//		return emp;
//	}

}

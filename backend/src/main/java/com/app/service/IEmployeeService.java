package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojo.Employees;

public interface IEmployeeService {

	public List<Employees> getAllEmployee();
	public Employees addNewEmployee(Employees newEmployee);
	public String deteleteEmployeeById(int id);
	//public Employees getAdmin(String ename);
	public Employees EmployeeLogin(String email, String password);
}

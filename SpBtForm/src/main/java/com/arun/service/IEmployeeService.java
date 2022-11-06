package com.arun.service;

import java.util.List;
import java.util.Optional;

import com.arun.entity.Employee;

public interface IEmployeeService {
	
	public Boolean saveEmployee(Employee employee);
	public List<Employee> getEmployeeList();
	public  Employee getEmployeebyId(long id);
	boolean deleteById(long id);
	 

}

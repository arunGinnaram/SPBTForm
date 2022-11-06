package com.arun.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.entity.Employee;
import com.arun.repo.IEmployeeRepo;
import com.arun.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepo iEmpRepo;
	 
	@Override
	public Boolean saveEmployee(Employee employee){		
		Employee save = iEmpRepo.save(employee);		
		if(save!=null) {
			System.out.println("Employee Saved");
			 return true;
		}else {						
			System.out.println("Employee Saved");
			return false;
			 
		}	
	} 

	@Override
	public List<Employee> getEmployeeList() {
		List<Employee> findAll = iEmpRepo.findAll();		
		return findAll;
	}

	@Override
	public Employee getEmployeebyId(long id) {
		Optional<Employee> findById = iEmpRepo.findById(id);		
		return findById.get();
	}
 

	@Override
	public boolean deleteById(long id) { 
		 iEmpRepo.deleteById(id);
		return true;
	}


	 


	 

	

}

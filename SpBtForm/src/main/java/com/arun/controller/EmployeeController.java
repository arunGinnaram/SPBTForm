package com.arun.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.arun.entity.Employee;
import com.arun.service.IEmployeeService;


@RestController
public class EmployeeController {
	
	@Autowired
	private IEmployeeService iempService;
	
	@GetMapping("/EmployeeList")
	public ModelAndView employeeList() {
		ModelAndView mav = new ModelAndView();
		List<Employee> employeeList = iempService.getEmployeeList();
		mav.addObject("EmployeeList",employeeList);
		mav.setViewName("EmployeeList");		
		return mav;
	}	
	
	@GetMapping("/")
	public ModelAndView employeeForm() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("Employee",new Employee());
		mav.setViewName("EmployeeForm");
		
		return mav;
	}
	 
	
	@PostMapping("/SaveEmployee")
	public ModelAndView saveEmployee(Employee employee) {
		ModelAndView mav = new ModelAndView();
		Boolean saveEmployee = iempService.saveEmployee(employee);
		if(saveEmployee) {
			mav.addObject("message","Employee Saved Successfully");
		}else {
			mav.addObject("message","Employee Not Saved");
		}
		
		mav.addObject("Employee",new Employee());
		mav.setViewName("EmployeeForm");
		
		return mav;
	}
	 
	
	@GetMapping("/EmployeeEdit/{id}")
	public ModelAndView employeeEdit(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView();
		Employee employeebyId = iempService.getEmployeebyId(id);
		mav.addObject("Employee",employeebyId);
		mav.setViewName("EmployeeForm");		
		return mav;
	} 
		
	@GetMapping("/DeleteEmployee/{id}")
	public ModelAndView employeeDelete(@PathVariable("id") long id) {
		ModelAndView mav = new ModelAndView("redirect:/usit/sales/page/1");
		boolean deleteById =iempService.deleteById(id);
		if (deleteById) {
			System.out.println("Deleted Successfully");
		} else {
			System.out.println("Not Deleted");
		}
		List<Employee> employeeList = iempService.getEmployeeList();
		mav.addObject("EmployeeList",employeeList);
		mav.setViewName("EmployeeList");
		return mav;
		 
		 
	} 

}

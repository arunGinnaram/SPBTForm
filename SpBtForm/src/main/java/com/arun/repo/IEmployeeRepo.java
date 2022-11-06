package com.arun.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arun.entity.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Serializable> {

}

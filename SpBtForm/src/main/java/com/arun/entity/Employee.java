package com.arun.entity;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employee")
public class Employee {
	@Id
	@Column(name="eid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long eid;
	
	@Column(name="FirstName",length = 255)
	private String firstname;
	
	@Column(name="LastName",length = 255)
	private String lastname;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="email",length = 255)
	private String email;
	
	@Column(name="DOB")
	private Date dob;
 	
	

}

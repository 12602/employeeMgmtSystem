package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Employee;

public interface EmpImpl  extends CrudRepository<Employee,Integer>
{
	
	

}

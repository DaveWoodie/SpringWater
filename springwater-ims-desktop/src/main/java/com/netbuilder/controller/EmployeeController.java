package com.netbuilder.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import entities.Employee;
import entityrepository.EmployeeRepository;

public class EmployeeController 
{
	@Autowired
	EmployeeRepository employeeRepo;
	
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	public void getEmployees()
	{
		employeeList = (ArrayList<Employee>) employeeRepo.findAll();
		for(Employee employee : employeeList)
		{
			System.out.println(employee.getUser());
		}
	}
}

package com.jpa.main.service;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.jpa.main.model.Employee;

public class EmployeeService {
	  Scanner sc;
	  
	  {
		  sc = new Scanner(System.in);
	  }
	
	  public Employee readEmployeeInput(Employee employee) {
		
		System.out.println("Enter Employee Name: ");
		String name = sc.next();
		employee.setName(name);
		
		System.out.println("Enter Employee Salary: ");
		double salary = sc.nextDouble();
		employee.setSalary(salary);
		
		System.out.println("Enter Employee City: ");
		String city = sc.next();
		employee.setCity(city);
		
		return employee;
	}

	public List<Employee> fetchAllEmployees(EntityManager entityManager) {
		List<Employee> list = entityManager
						.createQuery("select e from Employee e", Employee.class).getResultList();
		return list;
	}

	
}

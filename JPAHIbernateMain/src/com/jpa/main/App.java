package com.jpa.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jpa.main.model.Employee;
import com.jpa.main.service.EmployeeService;

public class App {
	public static void main(String[] args) {
		/*
		 * EntityManagerFactory will help us reach out to persistence.xml settings
		 */
		EntityManagerFactory entityFactory = null;
		/*
		 * EntityManager will help us manage and perform operations on our entities
		 */
		EntityManager entityManager = null;
		/*
		 * EntityTransaction is needed so that all operations in DB happen as atomic
		 */
		EntityTransaction transaction = null;
		try {
			entityFactory = Persistence.createEntityManagerFactory("mycompanydb");
			entityManager = entityFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			
			transaction.begin();
			Scanner sc = new Scanner(System.in);
			EmployeeService employeeService = new EmployeeService();
			while(true) {
				System.out.println("----Employee Operations----");
				System.out.println("1. Insert employee");
				System.out.println("2. Fetch all employees");
				System.out.println("0. exit");
				int input = sc.nextInt();
				if(input == 0)
					break;
				
				switch(input) {
				case 1: 
					Employee employee = new Employee();
					employee = employeeService.readEmployeeInput(employee);
					entityManager.persist(employee);
					System.out.println("Employee inserted in DB.");
					break;
				case 2:
					List<Employee> list = employeeService.fetchAllEmployees(entityManager);
					System.out.println("------ All Employee Details ----\n");
					for(Employee e: list) {
						System.out.print("Emplyee ID: " + e.getId());
						System.out.print(" ||  Emplyee Name: " + e.getName());
						System.out.print(" ||  Emplyee Salary: " +e.getSalary());
						System.out.print(" ||  Emplyee City: " + e.getCity());
						System.out.println();
					}
					break;
				default:
					break;
				}
			}
			
			
			
			transaction.commit();
			
 		} catch (Exception e) {
 			System.out.println(e);
 			transaction.rollback();
		}
		finally {
			entityManager.close();
			entityFactory.close();
		}
	}
}

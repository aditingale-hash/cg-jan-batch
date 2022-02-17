package com.jpa.main.service;

import javax.persistence.EntityManager;

import com.jpa.main.model.Department;

public class DepartmentService {

	private EntityManager entityManager; 
	
	public DepartmentService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void populate() {
		Department d1 = new Department();
		d1.setName("IT");
		entityManager.persist(d1);
		Department d2 = new Department();
		d2.setName("SALES");
		entityManager.persist(d2);
	}
}

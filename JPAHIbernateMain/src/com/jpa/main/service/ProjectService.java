package com.jpa.main.service;

import javax.persistence.EntityManager;

import com.jpa.main.model.Project;

public class ProjectService {

	private EntityManager entityManager;
	
	public ProjectService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void populate() {
		 Project p1 = new Project();
		 p1.setName("Banking Project");
		 p1.setCredits(1000);
		 entityManager.persist(p1);
		 Project p2 = new Project();
		 p2.setName("Ecom Project");
		 p2.setCredits(800);
		 entityManager.persist(p2);
	}

	
}

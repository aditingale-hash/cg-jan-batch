package com.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
			
			
 		} catch (Exception e) {
 			System.out.println(e);
		}
		finally {
			entityManager.close();
			entityFactory.close();
		}
	}
}
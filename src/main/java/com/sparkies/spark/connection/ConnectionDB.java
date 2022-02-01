package com.sparkies.spark.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Entity Manager Factory & Entity Manager
 */
public class ConnectionDB {

	public static EntityManager connectDB(String persistence) {
		// on spécifie le nom de l'unité de persistence en paramètre
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistence);
		EntityManager entityManager = emf.createEntityManager();
		return entityManager;
	}

}

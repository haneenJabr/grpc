package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProvider {

	private static EntityManagerFactory factory = null;
	private static EntityManager entityManager = null;

	private EntityManagerProvider() {

	}

	public static EntityManager getInstance() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("dept-unit");
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}

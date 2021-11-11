package utils;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HibernateUtils {
	private static HibernateUtils instance;
	private EntityManager entityManager;
	
	private HibernateUtils() {
		entityManager = Persistence.createEntityManagerFactory("BookStore_Server")
						.createEntityManager();
	}
	
	public synchronized static HibernateUtils getInstance() {
		if(instance == null) {
			instance = new HibernateUtils();
		}
		return instance;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
}

package ua.lviv.lgs.shared;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryManager {

	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
		}
		return emf;
	}
	
	public static EntityManager getEntityManager() {
		if(em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}
	
}

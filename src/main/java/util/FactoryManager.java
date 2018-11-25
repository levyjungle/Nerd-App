package util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryManager {
	
	private static EntityManagerFactory emf  =  Persistence.createEntityManagerFactory("Nerdzonia");
        
	public static EntityManager getManager() {
		return emf.createEntityManager();
	}
	
	public static void closeConnection() {
		emf.close();
	}
}

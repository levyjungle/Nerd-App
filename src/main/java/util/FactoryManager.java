package util;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryManager {
	
	//create an connection with database, this search name Nerdzonia in persistence.xml to access configurations
	private static EntityManagerFactory emf  =  Persistence.createEntityManagerFactory("Nerdzonia");
        
	public static EntityManager getManager() {
		return emf.createEntityManager();
	}
	
	public static void closeConnection() {
		emf.close();
	}
}

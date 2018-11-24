package repository;

import javax.persistence.EntityManager;

import model.Person;

public class PersonRepository {
	
	EntityManager em = FactoryManager.getManager();
	
	public void savePerson(Person person) {
		em.getTransaction().begin();
		em.persist(person);
		em.getTransaction().commit();
		em.close();
	}
	
	
}

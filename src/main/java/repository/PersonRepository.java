package repository;

import javax.persistence.EntityManager;

import model.Person;
import util.FactoryManager;

public class PersonRepository {
	
	EntityManager em = FactoryManager.getManager();
	
	public void savePerson(Person person) {
		try {
			em.getTransaction().begin();
			em.persist(person);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			FactoryManager.closeConnection();
		}
	}
	
	public void deletePerson(Person person) {
		EntityManager em = FactoryManager.getManager();
		try {
			em.getTransaction().begin();
			Person p = em.find(Person.class, person);
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		} finally {
			FactoryManager.closeConnection();
		}
	}
	
	public Person searchPersonId(String person_code) {
		EntityManager em = FactoryManager.getManager();
		try {
			Person p = em.find(Person.class, person_code);
			if(p == null) {
				return null;
			} else {
				return p;
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			FactoryManager.closeConnection();
		}
	}
	
}

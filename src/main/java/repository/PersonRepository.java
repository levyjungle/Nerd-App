package repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import model.Person;
import org.hibernate.HibernateException;
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
			e.printStackTrace();
			System.out.println(e.getCause());
		} finally {
			em.close();
		}
	}
	
	public void deletePerson(Person person) {
		EntityManager em = FactoryManager.getManager();
		try {
			em.getTransaction().begin();
			Person p = em.find(Person.class, person.getCode());
			em.remove(p);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println(e.getCause());
		} finally {
			em.close();
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
			em.close();
		}
	}
	
	public Person searchSpecificEntityValueIntoPerson(String tableName, String columnName, String valueToSearch) {
		String tableNameAlias = tableName.charAt(0)+"";
		EntityManager em = FactoryManager.getManager();
		Session session = (Session) em.getDelegate();
		Criteria criteria = session.createCriteria(Person.class);
		try {
			criteria.createAlias(tableName, tableNameAlias);
			Criterion c1 = Restrictions.eq(tableNameAlias+"."+columnName, valueToSearch);
			criteria.add(c1);
			Person person = (Person) criteria.uniqueResult();
			return person;
		}catch(HibernateException e){
			System.out.println(e.getMessage());
			return null;
		}finally {
			em.close();
		}
		
	}
        
    public void updatePerson(Person person){
         EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.merge(person);
	em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }  
    }
    
    public List<Person> listAllPerson() {
    	EntityManager em = FactoryManager.getManager();
    	try {
    		return em.createQuery("From Person", Person.class).getResultList();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return null;
    	}finally {
    		em.close();
    	}
    }
	
}

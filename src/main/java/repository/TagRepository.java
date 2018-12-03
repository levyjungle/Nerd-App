/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.util.List;

import javax.persistence.EntityManager;
import model.Tag;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.FactoryManager;

/**
 *
 * @author Lucas
 */
public class TagRepository {
    
    public void saveTag(Tag tag) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.persist(tag);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void deleteTag(String code) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            Tag tag = em.find(Tag.class, code);
            em.remove(tag);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void updateTag(Tag tag) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.merge(tag);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public List<Tag> searchTagByName(String tag) {
        EntityManager em = FactoryManager.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria c = session.createCriteria(Tag.class);
            c.add(Restrictions.ilike("tagName", tag, MatchMode.ANYWHERE));
            return  c.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    
    public Tag searchTagByCode(String code) {
    	EntityManager em = FactoryManager.getManager();
    	try {
    		return em.find(Tag.class, code);
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return null;
    	}finally {
    		em.close();
    	}
    }
   
    public List<Tag> listAllTag(){
    	EntityManager em = FactoryManager.getManager();
    	try {
    		return em.createQuery("From Tag", Tag.class).getResultList();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return null;
    	}finally{
    		em.close();
    	}
    }
}

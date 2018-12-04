package repository;

import java.util.List;

import javax.persistence.EntityManager;

import model.Media;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.FactoryManager;

public class MediaRepository {
	
    public void saveMedia(Media media) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.persist(media);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void deleteMedia(Media media) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.remove(media);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Media> searchMediaByName(String name) {
        EntityManager em = FactoryManager.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria c = session.createCriteria(Media.class);
            c.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
            return c.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    public Media searchMediaCode(String code) {
    	EntityManager em = FactoryManager.getManager();
    	try {
    		Media media = em.find(Media.class, code);
    		return media;
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return null;
    	}finally {
    		
    	}
    }
    public List<Media> sharedMediaBySpecificUser(String valueToSearch, String columnName){
        EntityManager em = FactoryManager.getManager();
        Session session = (Session) em.getDelegate();
        Criteria criteria = session.createCriteria(Media.class);
        try{
            Criterion c1 = Restrictions.eq(columnName, valueToSearch);
            criteria.add(c1);
            return criteria.list();
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }finally{
            em.close();
        }
    }
    
    public List<Media> listAllVideo() {
    	EntityManager em = FactoryManager.getManager();
    	try {
    		return em.createQuery("FROM Media", Media.class).getResultList();
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return null;
    	}finally {
    		em.close();
    	}
    }
    
    public void updateMedia(Media media) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.merge(media);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

}

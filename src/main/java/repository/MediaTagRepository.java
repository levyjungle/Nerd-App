/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import javax.persistence.EntityManager;
import model.MediaTags;
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
public class MediaTagRepository {
    
    public void saveMediaTag(MediaTags mediaTag) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.persist(mediaTag);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void deleteMediaTag(MediaTags mediaTag) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.remove(mediaTag);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public void updateMediaTag(MediaTags mediaTag) {
        EntityManager em = FactoryManager.getManager();
        try {
            em.getTransaction().begin();
            em.merge(mediaTag);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
    
    public MediaTags searchMediaTagByName(String mediaTag) {
        EntityManager em = FactoryManager.getManager();
        try {
            Session session = (Session) em.getDelegate();
            Criteria c = session.createCriteria(MediaTags.class);
            c.add(Restrictions.ilike("mediaTag", mediaTag, MatchMode.ANYWHERE));
            return (MediaTags) c.list();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
}

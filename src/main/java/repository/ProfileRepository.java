package repository;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import model.Profile;
import org.hibernate.HibernateException;
import util.FactoryManager;

public class ProfileRepository {

    public Profile searchEspecificProfileEmail(String email) {
        EntityManager em = FactoryManager.getManager();
        System.out.println(email);
        try {
            Session session = (Session) em.getDelegate();
            Criteria criteria = session.createCriteria(Profile.class);
            Criterion c1 = Restrictions.eq("email", email);
            System.out.println("Criou criteria" + criteria);
            criteria.add(c1);
            Profile pro = (Profile) criteria.uniqueResult();
            System.out.println(pro.getEmail());
            return pro;
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

}

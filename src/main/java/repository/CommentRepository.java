package repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import model.Comment;
import util.FactoryManager;

public class CommentRepository {
	
	public void saveComment(Comment comment) {
		EntityManager em = FactoryManager.getManager();
		try {
			em.getTransaction().begin();
			em.persist(comment);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			em.close();
		}
	}
	
	public List<Comment> searchCommentByMedia(String code) {
			EntityManager em = FactoryManager.getManager();
			Session session = (Session) em.getDelegate();
			Criteria criteria = session.createCriteria(Comment.class);
		try {
			Criterion c1 = Restrictions.eq("media.code", code);
			criteria.add(c1);
			criteria.addOrder(Order.desc("datetime"));
			return criteria.list();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
			return null;
		}finally {
			em.close();
		}
	}
	
	public Comment searchCommentCode(String code) {
		EntityManager em = FactoryManager.getManager();
		try {
			return em.find(Comment.class, code);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
			return null;
		}finally {
			em.close();
		}
	}
	
	public void deleteComment(String code) {
		EntityManager em = FactoryManager.getManager();
		try {
			em.getTransaction().begin();
			Comment comment = em.find(Comment.class, code);
			em.remove(comment);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			em.getTransaction().rollback();
		}finally {
			em.close();
		}
	}
}

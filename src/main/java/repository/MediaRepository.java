package repository;

import javax.persistence.EntityManager;

import model.Media;
import util.FactoryManager;

public class MediaRepository {
	
	public void saveMedia(Media media) {
		EntityManager em = FactoryManager.getManager();
		try {
			em.getTransaction().begin();
			em.persist(media);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally{
			em.close();
		}
	}
}

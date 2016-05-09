package fr.ipst.cnam.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import fr.ipst.cnam.entities.Message;
import fr.ipst.cnam.entities.Oc;

public class MessageDAO implements MessageDAOInterface {
	
	private EntityManagerFactory emf;
	
	public MessageDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}

	@Override
	public void persistMessage(Message msg) {
		EntityManager em = null;
		try
		{
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(msg);
			em.getTransaction().commit();
		}
		finally
		{
			em.close();
		}

	}

	@Override
	public List<Message> findAllMessages() {
		EntityManager em = null;
		try
		{
			em = getEntityManager();
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Message.class));
			Query q = em.createQuery(cq);
			return q.getResultList();
		}
		finally
		{
			em.close();
		}
	}

}

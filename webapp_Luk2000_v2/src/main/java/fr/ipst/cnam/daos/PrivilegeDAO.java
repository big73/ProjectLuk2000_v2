package fr.ipst.cnam.daos;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import fr.ipst.cnam.entities.Oc;
import fr.ipst.cnam.entities.Privilege;

public class PrivilegeDAO implements PrivilegeDAOInterface{
	
	private EntityManagerFactory emf;
	
	public PrivilegeDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public EntityManager getEntityManager() {
		EntityManager em = emf.createEntityManager();
		return em;
	}

	@Override
	public List<Privilege> findPrivileges(int idUser) {
		EntityManager em = null;
		List<Privilege> list = null;
		try
		{
			em = getEntityManager();
			
			Query query = em.createQuery("Select p from Privilege as p where p.idUser = ?1");
			query.setParameter(1, idUser);
			list = query.getResultList();
		}
		finally
		{
			em.close();
		}
		return list;
	}
	
	@Override
	public void addPrivilege(Privilege privilege)
	{
		EntityManager em = null;
		try
		{
			em = getEntityManager();
			em.getTransaction().begin();
			em.persist(privilege);
			em.getTransaction().commit();
		}
		finally
		{
			//em.close();
		}
	}

}

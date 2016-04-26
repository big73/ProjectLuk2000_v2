package fr.ipst.cnam.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import fr.ipst.cnam.entities.Oc;

public class OcDAO implements OcDAOInterface{
	
	private EntityManagerFactory emf;
	
	public OcDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	public EntityManager getEntityManager()
	{
		EntityManager em = emf.createEntityManager();
		return em;
	}

	@Override
	public void persistOc(Oc oc) {
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(oc);
		em.getTransaction().commit();
	}

	@Override
	public Oc findOc(Oc oc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Oc> findAllOc() {
		EntityManager em = getEntityManager();
		try
		{
			CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
			cq.select(cq.from(Oc.class));
			Query q = em.createQuery(cq);
			return q.getResultList();
			
		}
		finally
		{
			em.close();
		}
	}

	@Override
	public void updateOc(Oc oc) {
		
		String nouveauNomOc = oc.getNom();
		String nouveauDomainAct = oc.getDomaineAct();
		int nouveauIdProprio = oc.getIdProprietaire();
		
		Oc ocAModifier = null;
		EntityManager em = null;
		try
		{
			em = getEntityManager();
			em.getTransaction().begin();
			ocAModifier = em.find(Oc.class, oc.getId());
			
			Query queryNom = em.createQuery(
					"UPDATE Oc o SET o.nom = ?1 where o.id = ?2")
					.setParameter(1, nouveauNomOc)
					.setParameter(2, ocAModifier.getId());
					queryNom.executeUpdate();
					
			Query queryDomainAct = em.createQuery(
					"UPDATE Oc o SET o.domaineAct = ?1 where o.id = ?2")
					.setParameter(1, nouveauDomainAct)
					.setParameter(2, ocAModifier.getId());;
			queryDomainAct.executeUpdate();
			
			Query queryIdProprio = em.createQuery(
					"UPDATE Oc o SET o.idProprietaire = ?1 where o.id = ?2")
					.setParameter(1, nouveauIdProprio)
					.setParameter(2, ocAModifier.getId());;
			queryIdProprio.executeUpdate();
			
			em.getTransaction().commit();
		}
		finally
		{
			em.close();
		}
		
	}

	@Override
	public void destroyOc(Oc oc) {
		// TODO Auto-generated method stub
		
	}

}

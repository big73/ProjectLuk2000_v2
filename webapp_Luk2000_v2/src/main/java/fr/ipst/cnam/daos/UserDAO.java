package fr.ipst.cnam.daos;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import fr.ipst.cnam.entities.User;

public class UserDAO implements UserDAOInterface{
	
	private EntityManagerFactory emf;
	
	public UserDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public EntityManager getEntityManager()
	{
		EntityManager em = emf.createEntityManager();
		return em;
	}

	@Override
	public User findUser(String nom, String password) {
		
		User userCall = null;
		
		EntityManager em = getEntityManager();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.nom = ?1 "
				+ "AND u.password = ?2");
		
		query.setParameter(1, nom).setParameter(2, password);
		
		List<User> list = query.getResultList();
		
		Iterator<User> it = list.iterator();
		while(it.hasNext())
		{
			User user = it.next();
			userCall = user;
		}
		if(userCall != null)
		{
			return userCall;
		}
		return userCall;
	}

}

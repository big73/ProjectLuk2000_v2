package fr.ipst.cnam.daos;

import javax.persistence.EntityManager;

import fr.ipst.cnam.entities.User;

public interface UserDAOInterface {
	
	public EntityManager getEntityManager();
	
	public User findUser(String login, String passwd);

}

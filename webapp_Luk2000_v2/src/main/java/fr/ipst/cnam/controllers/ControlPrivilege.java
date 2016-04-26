package fr.ipst.cnam.controllers;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.UserDAO;
import fr.ipst.cnam.daos.UserDAOInterface;
import fr.ipst.cnam.entities.User;

public class ControlPrivilege {
	
	public User login(String login, String passwd)
	{
		User user;
		
		EntityManagerFactory emf = ManagerDAO.getInstance();
		UserDAOInterface dao = new UserDAO(emf);
		user = dao.findUser(login, passwd);
		return user;
	}

}

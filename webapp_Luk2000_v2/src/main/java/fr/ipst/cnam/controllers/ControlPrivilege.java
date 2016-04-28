package fr.ipst.cnam.controllers;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.PrivilegeDAO;
import fr.ipst.cnam.daos.PrivilegeDAOInterface;
import fr.ipst.cnam.daos.UserDAO;
import fr.ipst.cnam.daos.UserDAOInterface;
import fr.ipst.cnam.entities.Oc;
import fr.ipst.cnam.entities.Privilege;
import fr.ipst.cnam.entities.User;

public class ControlPrivilege {
	
	
	public User login(String login, String passwd)
	{
		User user;
		
		
		EntityManagerFactory emf = ManagerDAO.getInstance();
		UserDAOInterface dao = new UserDAO(emf);
		user = dao.findUser(login, passwd);
		
		if(user != null)
		{
			PrivilegeDAOInterface daoP = new PrivilegeDAO(emf);
			List<Privilege> packPrivilege =daoP.findPrivileges(user.getId());
			User.setPackPrivileges(packPrivilege);
			
			
		}
		return user;
	}
	
	public boolean checkPrivileges(User user, Oc oc, String typePrivilege)
	{
		boolean droitCrudOc = false;
		
		List<Privilege> packPrivileges = user.getPackPrivileges();
		
		Iterator<Privilege> it = packPrivileges.iterator();
		while(it.hasNext())
		{
			Privilege privilege = it.next();
			
			if(privilege.getIdUser() == user.getId() 
					&& privilege.getIdOc() == oc.getId()
					&& privilege.getActionCrudoc().contains(typePrivilege))
			{
				droitCrudOc = true;
			}
		}
		
		return droitCrudOc;
	}
	

}

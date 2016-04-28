package fr.ipst.cnam.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.PrivilegeDAO;
import fr.ipst.cnam.daos.PrivilegeDAOInterface;
import fr.ipst.cnam.entities.Privilege;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = ManagerDAO.getInstance();
		PrivilegeDAOInterface dao = new PrivilegeDAO(emf);
		
		List<Privilege> list = dao.findPrivileges(4);
		Iterator<Privilege> it = list.iterator();
		
		while(it.hasNext())
		{
			Privilege privilege = it.next();
			System.out.println(privilege.getActionCrudoc());
		}

	}

}

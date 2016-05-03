package fr.ipst.cnam.test;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.OcDAO;
import fr.ipst.cnam.daos.OcDAOInterface;
import fr.ipst.cnam.daos.PrivilegeDAO;
import fr.ipst.cnam.daos.PrivilegeDAOInterface;
import fr.ipst.cnam.entities.Oc;
import fr.ipst.cnam.entities.Privilege;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = ManagerDAO.getInstance();
		OcDAOInterface dao = new OcDAO(emf);
		
		Oc oc = new Oc();
		oc.setId(37);
		
		dao.destroyOc(oc);

	}
	
	static public int getAge()
	{
		return 3;
	}

}

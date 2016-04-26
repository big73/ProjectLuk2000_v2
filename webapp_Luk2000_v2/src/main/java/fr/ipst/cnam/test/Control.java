package fr.ipst.cnam.test;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.OcDAO;
import fr.ipst.cnam.daos.OcDAOInterface;
import fr.ipst.cnam.daos.UserDAO;
import fr.ipst.cnam.daos.UserDAOInterface;
import fr.ipst.cnam.entities.Oc;
import fr.ipst.cnam.entities.User;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = ManagerDAO.getInstance();
		OcDAOInterface dao = new OcDAO(emf);
		
		Oc oc = new Oc();
		oc.setId(32);
		oc.setNom("Jean charles");
		oc.setDomaineAct("labeur");
		oc.setIdProprietaire(1);
		
		dao.updateOc(oc);

	}

}

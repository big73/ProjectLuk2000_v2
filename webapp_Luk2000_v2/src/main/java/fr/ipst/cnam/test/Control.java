package fr.ipst.cnam.test;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.UserDAO;
import fr.ipst.cnam.daos.UserDAOInterface;
import fr.ipst.cnam.entities.User;

public class Control {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = ManagerDAO.getInstance();
		UserDAOInterface dao = new UserDAO(emf);
		
		User user = dao.findUser("Lamblin", "e.lamblin");
		System.out.println(user.getPrenom());

	}

}

package fr.ipst.cnam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.OcDAO;
import fr.ipst.cnam.daos.OcDAOInterface;

public class ParcOc {

	private static List<Oc> parcOc = null;
	
	private ParcOc() {
	}

	public static List<Oc> getInstance()
	{
		if(parcOc != null)
		{
			return parcOc;
		}
		else
		{
			EntityManagerFactory emf = ManagerDAO.getInstance();
			OcDAOInterface dao = new OcDAO(emf);
			
			parcOc = dao.findAllOc();
			return parcOc;
		}
	}
	
}

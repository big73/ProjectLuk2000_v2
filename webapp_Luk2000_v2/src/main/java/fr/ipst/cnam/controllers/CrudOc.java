package fr.ipst.cnam.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.OcDAO;
import fr.ipst.cnam.daos.OcDAOInterface;
import fr.ipst.cnam.entities.Oc;
import fr.ipst.cnam.entities.ParcOc;
import fr.ipst.cnam.managedBeansDialog.CreerOc;

public class CrudOc {
	
	public void valider(CreerOc creeroc)
	{
		Oc oc = new Oc();
		
		//on initialise la date en temps réel
		oc.setDateCrea(new Date());
		oc.setDomaineAct(creeroc.getDomaineAct());
		oc.setIdProprietaire(creeroc.getIdProprio());
		oc.setNom(creeroc.getNom());
		
		EntityManagerFactory emf = ManagerDAO.getInstance();
		OcDAOInterface dao = new OcDAO(emf);
		dao.persistOc(oc);
	}
	
	public static List<Oc> getParcOcInstance()
	{
		return ParcOc.getInstance();
	}
	
	public void modifierOc(int idOc, String nomOc, String domainAct, int idProprio)
	{
		System.out.println(domainAct +" "+idProprio);
	}

}

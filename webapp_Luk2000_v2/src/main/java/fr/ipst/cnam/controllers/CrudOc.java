package fr.ipst.cnam.controllers;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.OcDAO;
import fr.ipst.cnam.daos.OcDAOInterface;
import fr.ipst.cnam.daos.PrivilegeDAO;
import fr.ipst.cnam.daos.PrivilegeDAOInterface;
import fr.ipst.cnam.entities.Oc;
import fr.ipst.cnam.entities.ParcOc;
import fr.ipst.cnam.entities.Privilege;
import fr.ipst.cnam.managedBeansDialog.CreerOc;

public class CrudOc {
	
	public List<Oc> valider(CreerOc creeroc)
	{
		Oc oc = new Oc();
		
		//on initialise la date en temps réel
		oc.setDateCrea(new Date());
		oc.setDomaineAct(creeroc.getDomaineAct());
		oc.setIdProprietaire(creeroc.getUserBean().getUser().getId());
		oc.setNom(creeroc.getNom());
		
		EntityManagerFactory emf = ManagerDAO.getInstance();
		
		//persistance de l'oc en base de données
		OcDAOInterface dao = new OcDAO(emf);
		dao.persistOc(oc);
		
		//affectation des privilèges en base de données
		Privilege privilege = new Privilege();
		privilege.setActionCrudoc("msu");
		privilege.setIdOc(oc.getId());
		privilege.setIdUser(creeroc.getUserBean().getUser().getId());
		
		PrivilegeDAOInterface daoP = new PrivilegeDAO(emf);
		daoP.addPrivilege(privilege);
		
		return ParcOc.refresh();
	}
	
	public static List<Oc> getParcOcInstance()
	{
		return ParcOc.getInstance();
	}
	
	public void modifierOc(int idOc, String nomOc, String domainAct, int idProprio)
	{
		Oc oc = new Oc();
		oc.setId(idOc);
		oc.setNom(nomOc);
		oc.setDomaineAct(domainAct);
		oc.setIdProprietaire(idProprio);
		
		EntityManagerFactory emf = ManagerDAO.getInstance();
		OcDAOInterface dao = new OcDAO(emf);
		dao.updateOc(oc);
	}
	
	public List<Oc> supprimerOC(Oc oc)
	{
		EntityManagerFactory emf = ManagerDAO.getInstance();
		OcDAOInterface dao = new OcDAO(emf);
		dao.destroyOc(oc);		
		
		return ParcOc.refresh();
	}

}

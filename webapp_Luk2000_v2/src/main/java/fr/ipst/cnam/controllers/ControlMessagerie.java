package fr.ipst.cnam.controllers;


import java.util.Date;
import java.util.List;
import java.util.Random;

import fr.ipst.cnam.daos.ManagerDAO;
import fr.ipst.cnam.daos.MessageDAO;
import fr.ipst.cnam.daos.MessageDAOInterface;

import javax.persistence.EntityManagerFactory;

import fr.ipst.cnam.entities.Message;
import fr.ipst.cnam.entities.Messagerie;
import fr.ipst.cnam.entities.Oc;

public class ControlMessagerie {
	
	public List<Message> getMessagerie()
	{
		EntityManagerFactory emf = ManagerDAO.getInstance();
		MessageDAOInterface dao = new MessageDAO(emf);
		
		return dao.findAllMessages();
	}
	
	public void persistMessage(Message msg)
	{
		EntityManagerFactory emf = ManagerDAO.getInstance();
		MessageDAOInterface dao = new MessageDAO(emf);
		
		msg.setDateEnvoi(new Date());
		msg.setOptionAB("A");
		
		dao.persistMessage(msg);
	}
		
	public Message utiliserServiceOC(Oc oc, String optionAouB){
		
		Random r = new Random();  
		
		String titre;
		String contenu;
		int idOc = oc.getId();
		String optionAB = optionAouB;
		int idSvc;
		Message m;
		switch(oc.getDomaineAct()){
			case "Electroménager": {
				idSvc = 1;
				titre = "Etat batterie";
				int value = r.nextInt(100);
				contenu = value + " %";
				
				break;
			}
			case "Domotique": {
				idSvc = 2;
				titre = "Localisation";
				int geo1 = r.nextInt(80000000) + 10000000;
				int geo2 = r.nextInt(80000000) + 10000000;
				contenu = " ("+ geo1 + ";"+ geo2 + ") ";
				break;
			}
			case "Multimédia": {
				idSvc = 3;
				titre = "Taux d'humidité air";
				int value = r.nextInt(60);
				contenu = value + " %";
				break;
			}
			default: {
				idSvc = 4;
				titre = "Service indisponible";
				contenu = "-";
				break;
			}
				
		}
		m = new Message(titre, contenu, idOc, idSvc, optionAB);
		System.out.println("début du stockage "+ m.getContenu());
		int size = Messagerie.getMessagerie().size();
		Messagerie.getMessagerie().add(size++, m);
		System.out.println("fin du stockage");	
		
		
		// envoi par mail 
		/*
		if(optionAB.equals("B")){
			//m.envoyerParMail(u);
		}
		*/
		return m;
	} 
}

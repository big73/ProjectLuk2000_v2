package fr.ipst.cnam.managedBeansDialog;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.ipst.cnam.entities.Message;
import fr.ipst.cnam.entities.Oc;
import fr.ipst.cnam.entities.User;

@ManagedBean(name="messageBean")
@SessionScoped
public class MessageBean {
	
	//
	private static List<Message> fileMessage ;
	
	
	public static Message utiliserServiceOC(Oc oc, User u, String optionAouB) throws IOException, URISyntaxException{
		
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
		
		// stockage dans la file
		fileMessage.add(m);
		
		// envoi par mail 
		if(optionAB.equals("B")){
			//m.envoyerParMail(u);
		}
		return m;
	} 
}
